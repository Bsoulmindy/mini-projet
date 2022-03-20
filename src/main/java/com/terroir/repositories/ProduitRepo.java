package com.terroir.repositories;

import com.terroir.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit, Integer> {
    @Query("select p from Produit as p " + "inner join p.produitMatieresAsso as pmass "
            + "inner join pmass.matierePremiere as pm "
            + "on pm.idMatierePremiere = :idmatp")
    public List<Produit> getProduits(@Param("idmatp") int idmatp);

}
