package com.terroir.repositories;

import com.terroir.entities.Produit;
import com.terroir.entities.enumerations.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Integer> {
    @Query("select p from Produit as p " + "inner join p.produitMatieresAsso as pmass "
            + "inner join pmass.matierePremiere as pm " + "on pm.matiere_premiere_id = :idmatp")
    public List<Produit> getProduitsByIdMatierePremiere(@Param("idmatp") int idmatp);
    
 

   // public List<commande_produit_asso> getCommande_produit();
   @Query("select * from Produit ")
   public List<Produit> getPopularProduits();

   @Query("select * from Produit")
   public List<Produit> getNewProducts();


   
  public List<Produit> getProduitsByMPandOrigineandCategorie(PathVariable matierePremiere, PathVariable origine,
                PathVariable categorie);


@Query("select * from Produit where produit_id = :produit_id")
public Produit getProduitDesc(PathVariable produit_id);

    @Query("select p from Produit as p where p.produit_categorie = :categorie")
    public List<Produit> getProduitsByCategorie(@Param("categorie") Categorie categorie);

}
