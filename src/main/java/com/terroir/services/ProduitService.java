package com.terroir.services;

import com.terroir.entities.Cooperative;
import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Origine;
import com.terroir.entities.Produit;
import com.terroir.entities.ProduitMatiereAsso;
import com.terroir.entities.enumerations.Categorie;
import com.terroir.repositories.CooperativeRepo;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.OrigineRepo;
import com.terroir.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

@Service
public class ProduitService implements IProduitService {

    @Autowired CooperativeRepo cooperativeRepo;

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    MatiereRepo matiereRepo;

    @Autowired OrigineRepo origineRepo;

    @Transactional
    public int addProduit(Produit pr, MatierePremiere... listMatiere) {

        for (MatierePremiere mp : listMatiere) {
            ProduitMatiereAsso ligne = new ProduitMatiereAsso();
            MatierePremiere mpr = matiereRepo.getByNom(mp.getMatiere_premiere_nom());
            Collection<ProduitMatiereAsso> lignes = pr.getProduitMatieresAsso();
            if (mpr == null) {
                ligne.setMatierePremiere(mp);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
            else {
                ligne.setMatierePremiere(mpr);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
        }
        produitRepo.save(pr);
        return pr.getProduit_id();
    }

    /**
     *  Ajouter à un produit les matiéres premiére par leur ids
     * @param produit
     * @param listIdsMatiers
     * @return
     */
    @Override
    public int addProduit(Produit pr, int... ids) {
        for (int id : ids) {
            ProduitMatiereAsso ligne = new ProduitMatiereAsso();
            MatierePremiere mprp = matiereRepo.findById(id).get();
            MatierePremiere mpr = matiereRepo.getByNom(mprp.getMatiere_premiere_nom());
            Collection<ProduitMatiereAsso> lignes = pr.getProduitMatieresAsso();

            if (mpr == null) {
                ligne.setMatierePremiere(mprp);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
            else {
                ligne.setMatierePremiere(mpr);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
        }

        produitRepo.save(pr);
        return pr.getProduit_id();
    }

    /**
     *   Récupére list ids des produits par ses matiéres premiéres(ids)
     * @param listIdsMatiers
     * @return
     */
    @Override
    public List<Integer> getListProduitsParMatiers(int... idmatps) {
        List<Integer> ids1 = produitRepo.getProduitsByIdMatierePremiere(idmatps[0]).stream().map(produit -> produit.getProduit_id())
                .collect(Collectors.toList());

        for (int idmatp : idmatps) {
            List<Integer> ids = produitRepo.getProduitsByIdMatierePremiere(idmatp).stream().map(produit -> produit.getProduit_id())
                    .collect(Collectors.toList());

            ids1 = ids1.stream()
                    // .distinct()
                    .filter(ids::contains).collect(Collectors.toList());
        }

        return ids1;
    }
    /**
     *  Récupére list ids des produits par leur ids
     * @param listIdsProduits
     * @return
     */
    @Override
    public List<Produit> getProduitsById(int... ids)
    {
        List<Produit> produitsTrouvees = new ArrayList<>();

        for (int id : ids) {
            try {
                produitsTrouvees.add(produitRepo.findById(id).get()); 
            } catch (Exception e) {}
        }

        return produitsTrouvees;
    }
    /**
     *  Récupére list Produit exist dans les cookies(navigateur client)
     * @param listIdsProduits
     * @return
     */
    public List<Produit> getProduitsInCookies(Cookie[] cookies)
    {
        List<Produit> produits = new ArrayList<>();
		for (Cookie cookie : cookies) {
			try {
				int idProduit = Integer.parseInt(cookie.getName());
				Produit produit = produitRepo.getById(idProduit);
                produits.add(produit);
			} catch (Exception e) {
				continue;
			}
		}
        return produits;
    }

    /**
     *  Récupére list de toutes les Produits
     *  @return List<Produit>
     */
    public List<Produit> getAllProduits()
    {
        return produitRepo.findAll();
    }
    /**
     * Récupére list de toutes les Produits par leur catégorie
     * @param categorie
     * @return List<Produit>
     */
    public List<Produit> getAllProduitsOfCategory(String CategorieString)
    {
        return produitRepo.getProduitsByCategorie(Categorie.fromString(CategorieString));
    }

    /**
     * Récupére list de toutes les Produits par une matiéresPremiere
     */
    public List<Produit> getAllProduitsOfMatierePremiere(int idMatierePremiere)
    {
        List<Produit> produits = new ArrayList<>();
        try {
            MatierePremiere mp =  matiereRepo.findById(idMatierePremiere).get();
            for (ProduitMatiereAsso asso : mp.getProduitMatieres()) {
                produits.add(asso.getProduit());
            }
        } catch (Exception e) {}
        return produits;
    }

   /*  //getAllProduitsOfListMatierePremiere
    public List<Produit> getAllProduitsOfListMatierePremiere(List<MatierePremiere> listMatierePremiere){
    
        List<Produit> produits = new ArrayList<>();
        for (MatierePremiere mp : listMatierePremiere) {
            for (ProduitMatiereAsso asso : mp.getProduitMatieres()) {
                produits.add(asso.getProduit());
            }
        }
        return produits;
    } */
    
    /**
     * Récupére list de toutes les Produits par une origine
     */
    public List<Produit> getAllProduitsOfOrigine(int idOrigine)
    {
        List<Produit> produits = new ArrayList<>();
        try {
            Origine o =  origineRepo.findById(idOrigine).get();
            for (ProduitMatiereAsso asso : o.getProduitMatieresAsso()) {
                produits.add(asso.getProduit());
            }
        } catch (Exception e) {}
        return produits;
    }
    
    @Override
    public List<Produit> getPopularProduits() {

         

        return produitRepo.getPopularProduits();
    }

    
    public List<Produit> getNewProducts() {
        return produitRepo.findAll();
    }
    
    

    /**
     * Récupére list de toutes les Cooperatives par region et par secteur
     */
    public List<Cooperative> getCooperativesbyRegionandSecteur(PathVariable region, PathVariable secteur) {
        List<Cooperative> cooperatives = cooperativeRepo.findAll();
        List<Cooperative> cooperativesTrouvees = new ArrayList<>();
        for(Cooperative cooperative : cooperatives) {
            if(cooperative.getOrigine().getOrigine_nom().equals(region.toString()) && 
               cooperative.getCooperative_secteur_activite().toString().equals(secteur.toString())) {
                cooperativesTrouvees.add(cooperative);
            }
        }
        return cooperativesTrouvees;
    }


    public Cooperative getCooperativeDesc(PathVariable cooperative_id) {
        return cooperativeRepo.getCooperativeDesc(cooperative_id);
    }


    public Produit getProduitDesc(PathVariable produit_id) {
        return produitRepo.getProduitDesc(produit_id);
    }
}
