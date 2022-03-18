package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Produit;

import java.util.List;

public interface IProduitService {
    public long addProduit(Produit pr, MatierePremiere... listMatiere);
    public long addProduit(Produit pr, Long... ids);
    public List<Long> getListProduitsParMatiers(Long... idmatps);
}
