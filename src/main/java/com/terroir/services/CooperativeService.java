package com.terroir.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.terroir.dto.associateProductForm;
import com.terroir.dto.newProductForm;
import com.terroir.dto.updateProductForm;
import com.terroir.entities.Commande;
import com.terroir.entities.CommandeProduitAsso;
import com.terroir.entities.Compte;
import com.terroir.entities.Cooperative;
import com.terroir.entities.DemandeCooperative;
import com.terroir.entities.Personne;
import com.terroir.entities.Produit;
import com.terroir.entities.ProduitMatiereAsso;
import com.terroir.entities.ProduitMatiereKey;
import com.terroir.entities.enumerations.Categorie;
import com.terroir.entities.enumerations.SecteurActivite;
import com.terroir.entities.enumerations.Unite;
import com.terroir.exception.FormException;
import com.terroir.repositories.CommandeProduitAssoRepo;
import com.terroir.repositories.CommandeRepo;
import com.terroir.repositories.CooperativeRepo;
import com.terroir.repositories.DemandeCoopRepo;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.OrigineRepo;
import com.terroir.repositories.ProduitMatiiereAssoRepo;
import com.terroir.repositories.ProduitRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class CooperativeService {
	@Autowired CommandeRepo commandeRepo;
	@Autowired ProduitRepo produitRepo;
	@Autowired ProduitMatiiereAssoRepo pmaRepo;
	@Autowired OrigineRepo origineRepo;
	@Autowired MatiereRepo matiereRepo;
	@Autowired CooperativeRepo cooperativeRepo;
	@Autowired DemandeCoopRepo demandeCoopRepo;
	@Autowired ProduitMatiiereAssoRepo produitMatiiereAssoRepo;
	@Autowired CommandeProduitAssoRepo commandeProduitAssoRepo;
	@Autowired FileService fileService;
	@Autowired CompteService compteService;

	/**
	 * Récupérer les coopératives selon un seul critère qui n'est pas <code>null</code>
	 * Si tous les critères sont <code>null</code>, on retourne tous les coopératives
	 * @param idCooperative selon un coopérative spécifique
	 * @param secteurActivite selon un secteur d'activité
	 * @param idOrigine selon l'origine
	 * @return Liste des coopératives respectant les critères
	 */
	public List<Cooperative> getCooperatives(@Nullable String cooperative, @Nullable String secteurActivite, @Nullable String origine) {
		List<Cooperative> cooperatives = new ArrayList<>();
		
		if(cooperative != null)
		{
			try {
				int idCooperative = Integer.valueOf(cooperative);
				cooperatives.add(cooperativeRepo.findById(idCooperative).get());
			} catch (Exception ignored) {}
		}
		else if(secteurActivite != null)
		{
			try {
				cooperatives.addAll(cooperativeRepo.getCooperativesBySecteurActivite(SecteurActivite.valueOf(secteurActivite)));
			} catch (Exception ignored) {}
		}
		else if(origine != null)
		{
			try {
				int idOrigine = Integer.valueOf(origine);
				cooperatives.addAll(origineRepo.findById(idOrigine).get().getCooperatives());
			} catch (Exception ignored) {}
		}
		else
		{
			return cooperativeRepo.findAll();
		}
		return cooperatives;
	}

	public void devenirCooperative(String nom,String activite, String origine, Personne personne) throws FormException
	{
		//Vérification si le personne a déjà une demande
		if(personne.getDemandeCooperative() != null)
			throw new FormException("Vous avez déjà une demande");
		System.out.println(origine);

		Cooperative coop = new Cooperative();
		coop.setCooperative_nom(nom);
		coop.setCooperative_secteur_activite(SecteurActivite.valueOf(activite));

		try {
			coop.setOrigine(origineRepo.findById(Integer.valueOf(origine)).get());
			coop = cooperativeRepo.save(coop);
		} catch (Exception e) {
			throw new FormException("Erreur lors de création du coopérative");
		}
		

		DemandeCooperative dc = new DemandeCooperative();
		dc.setDemande_approuvee(false);
		dc.setCooperative(coop);
		dc.setPersonne(personne);

		try {
			demandeCoopRepo.save(dc);
		} catch (Exception e) {
			try {
				cooperativeRepo.delete(coop);
			} catch (Exception ignored) {}
			throw new FormException("Erreur lors de création du demande");
		}
	}


	/**
	 * Récupere tous les commandes d'achat du coopérative actuel
	 * @return Liste de commandes
	 */
	public List<Commande> getCommandesOfCooperative()
	{
		Compte compte = compteService.recupererCompteActuel();
		Cooperative coop = compte.getPersonne().getDemandeCooperative().getCooperative();
		List<Commande> commandes = new ArrayList<>();

		for (Produit produit : coop.getProduits()) {
			for (CommandeProduitAsso asso : produit.getCommandeProduitAssos()) {
				commandes.add(asso.getCommande());
			}
		}

		return commandes;
	}

	/**
	 * Passer la commande depuis "Non délivré" à "Délivré", ou vice-versa
	 * @param idCommande ID du commande
	 * @param toggle <code>True</code> signifie "Non délivré" => "Délivré" <br>
	 * <code>False</code> signifie "Délivré" => "Non délivré"
	 */
	public void toggleCommande(int idCommande, boolean toggle)
	{
		try {
			Commande c = commandeRepo.findById(idCommande).get();
			c.setCommande_is_delivre(toggle);
			commandeRepo.save(c);
			
		} catch (Exception e) {
			//Si la commande n'existe pas, on fait rien
		}
	}

	public List<Produit> getProduitsOfCooperative()
	{
		Compte compte = compteService.recupererCompteActuel();
		Cooperative coop = compte.getPersonne().getDemandeCooperative().getCooperative();
		
		return coop.getProduits();
	}

	/**
	 * Créer un nouveau produit en l'associant avec le coopérative actuel
	 * @param form
	 */
	public void ajouterProduit(newProductForm form) throws FormException
	{
		Compte compte = compteService.recupererCompteActuel();
		Cooperative coop = compte.getPersonne().getDemandeCooperative().getCooperative();
		
		Produit p = new Produit();
		p.setProduit_nom(form.getNom());
		try {
			fileService.uploadImageToProduit(form.getImage(), p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FormException("Échec d'enregistrement de l'image!");
		}
		
		try {
			p.setProduit_unite(Unite.valueOf(form.getUnite()));
		} catch (IllegalArgumentException e) {
			throw new FormException("Unité invalide!");
		}
		try {
			p.setProduit_categorie(Categorie.valueOf(form.getCategorie()));
		} catch (IllegalArgumentException e) {
			throw new FormException("Catégorie invalide!");
		}
		p.setProduit_prix(form.getPrix());
		p.setCooperative(coop);
		p.setProduit_image("/images/" + form.getImage().getOriginalFilename());

		try {
			produitRepo.save(p);
		} catch (DataAccessException e) {
			throw new FormException("Échec de créer le produit!");
		}
	}


	/**
	 * Modifier le produit en changement seulement les attributs indiqués
	 * @param form
	 */
	public void updateProduit(updateProductForm form) throws FormException
	{
		Produit p = null;
		try {
			p = produitRepo.findById(form.getIdProduit()).get();
		} catch (NoSuchElementException e) {
			throw new FormException("Produit introuvable!");
		}
		if(!form.getNom().isEmpty()) p.setProduit_nom(form.getNom());
		if(form.getPrix() != 0) p.setProduit_prix(form.getPrix());
		try {
			if(!form.getCategorie().isEmpty()) p.setProduit_categorie(Categorie.valueOf(form.getCategorie()));
		} catch (IllegalArgumentException e) {
			throw new FormException("Catégorie invalide!");
		}
		try {
			if(!form.getUnite().isEmpty()) p.setProduit_unite(Unite.valueOf(form.getUnite()));
		} catch (IllegalArgumentException e) {
			throw new FormException("Unité invalide!");
		}
		
		try {
			if(form.getImage() != null)
				fileService.uploadImageToProduit(form.getImage(), p);
		} catch (Exception e) {
			throw new FormException("Échec d'enregistrement de l'image!");
		}
		try {
			produitRepo.save(p);
		} catch (Exception e) {
			throw new FormException("Échec de modification du produit!");
		}
	}

	/**
	 * Supprimer le produit
	 * Normalement les coopératives ne doivent pas supprimer leurs produits qui sont achetés pas des clients
	 */
	public void deleteProduit(int id) throws FormException
	{
		try {
			produitRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FormException("Échec de suppression du produit!");
		}
	}

	/**
	 * Associer le produit avec des matières premières et origines
	 */
	public void associerProduit(associateProductForm form) throws FormException
	{
		Produit p = produitRepo.findById(form.getIdProduit()).get();
		ProduitMatiereAsso pma = new ProduitMatiereAsso();
		ProduitMatiereKey id = new ProduitMatiereKey(form.getIdProduit(), form.getIdMatierePremiere());
		
		try {
			pma.setMatiere_premiere_quantite(Float.valueOf(form.getQte()));
		} catch (Exception e) {
			throw new FormException("La quantité doit être nombre");
		}
		try {
			pma.setMatiere_premiere_unite(Unite.valueOf(form.getUnite()));
		} catch (Exception e) {
			throw new FormException("Unité invalide!");
		}
		
		pma.setOrigine(origineRepo.findById(form.getIdOrigine()).get());
		pma.setMatierePremiere(matiereRepo.findById(form.getIdMatierePremiere()).get());
		pma.setProduit(p);
		pma.setIdref(id);

		try {
			pmaRepo.save(pma);
		} catch (Exception e) {
			throw new FormException("Échec d'association! peut-être elle est déjà existe");
		}
		
	}
}
