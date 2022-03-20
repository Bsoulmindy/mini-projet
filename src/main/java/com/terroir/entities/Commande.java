package com.terroir.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commande_id;

    // LES METHODES
    @ManyToMany
    @JoinTable(name = "CommandeProduitAsso", joinColumns = @JoinColumn(name = "commande_idref"), inverseJoinColumns = @JoinColumn(name = "produit_idref"))
    private List<Produit> produits;
}
