package com.terroir.services;

import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Produit;

import java.util.List;

public interface IProduitService {
    /**
     * Ajouter un nouveau produit avec ses matières premières
     * 
     * @param pr
     * @param listMatiere
     * @return <code>id</code> du produit
     */
    public int addProduit(Produit pr, MatierePremiere... listMatiere);

    /**
     * Ajouter un nouveau produit avec les ids des matières premières
     * 
     * @param pr
     * @param ids : matières premières doit être existe dans BD
     * @return <code>id</code> du produit
     */
    public int addProduit(Produit pr, int... ids);

    /**
     * Recuperer une liste des ids des produits à partir des ids des matières premières
     * 
     * @param idmatps
     * @return <code>Liste</code> des ids des produits
     */
    public List<Integer> getListProduitsParMatiers(int... idmatps);

    /**
     * Recuperer les produits à partir de ses ids
     * 
     * @param ids
     * @return
     */
    public List<Produit> getProduitsById(int... ids);
}
