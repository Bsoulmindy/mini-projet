package com.terroir.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
import com.terroir.repositories.CommandeRepo;
import com.terroir.repositories.CooperativeRepo;
import com.terroir.repositories.DemandeCoopRepo;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.OrigineRepo;
import com.terroir.repositories.ProduitMatiiereAssoRepo;
import com.terroir.repositories.ProduitRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
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

	public void devenirCooperative(String nom,String activite, String origine, Personne personne) throws FormException
	{
		//Vérification si le personne a déjà une demande
		if(personne.getDemandeCooperative() != null)
			throw new FormException("Vous avez déjà une demande");

		Cooperative coop = new Cooperative();
		coop.setCooperative_nom(nom);
		coop.setCooperative_secteur_activite(SecteurActivite.valueOf(activite));
		coop.setOrigine(origineRepo.getOrigineByNom(origine));

		try {
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
		Compte compte = (Compte)SecurityContextHolder.getContext().getAuthentication().getDetails();
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
		Compte compte = (Compte)SecurityContextHolder.getContext().getAuthentication().getDetails();
		Cooperative coop = compte.getPersonne().getDemandeCooperative().getCooperative();
		
		return coop.getProduits();
	}

	/**
	 * Créer un nouveau produit en l'associant avec le coopérative actuel
	 * @param form
	 */
	public void ajouterProduit(newProductForm form) throws FormException
	{
		Compte compte = (Compte)SecurityContextHolder.getContext().getAuthentication().getDetails();
		Cooperative coop = compte.getPersonne().getDemandeCooperative().getCooperative();
		//TODO : Sauvegarde de l'image

		Produit p = new Produit();
		p.setProduit_nom(form.getNom());
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
		p.setProduit_image(form.getFile().getOriginalFilename());

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
		
		//TODO : Sauvegarde de l'image
		try {
			produitRepo.save(p);
		} catch (Exception e) {
			throw new FormException("Échec de modification du produit!");
		}
	}

	/**
	 * Supprimer le produit
	 */
	public void deleteProduit(int id) throws FormException
	{
		try {
			produitRepo.deleteById(id);
		} catch (Exception e) {
			throw new FormException("Échec de suppression du produit!");
		}
	}

	/**
	 * Associer le produit
	 */
	public void associerProduit(int idProduit, int idMatierePremiere, int idOrigine) throws FormException
	{
		Produit p = produitRepo.findById(idProduit).get();
		ProduitMatiereAsso pma = new ProduitMatiereAsso();
		ProduitMatiereKey id = new ProduitMatiereKey(idProduit, idMatierePremiere);
		//TODO: implementer la qté et unité
		pma.setMatiere_premiere_quantite(1);
		pma.setMatiere_premiere_unite(Unite.Kg);
		pma.setOrigine(origineRepo.findById(idOrigine).get());
		pma.setMatierePremiere(matiereRepo.findById(idMatierePremiere).get());
		pma.setProduit(p);
		pma.setIdref(id);

		pmaRepo.save(pma);
	}
}
