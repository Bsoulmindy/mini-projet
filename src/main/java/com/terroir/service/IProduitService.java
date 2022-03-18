package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Produit;

import java.util.List;

public interface IProduitService {
    public int addProduit(Produit pr, MatierePremiere... listMatiere);
    public int addProduit(Produit pr, int... ids);
    public List<Integer> getListProduitsParMatiers(int... idmatps);
}
