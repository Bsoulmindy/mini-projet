package com.terroir.entities;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.terroir.entities.enumerations.SecteurActivite;

@Data
public class Cooperative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cooperative_id;

    private String cooperative_nom;

    @Enumerated(EnumType.STRING)
    private SecteurActivite cooperative_secteur_activite;


    // LES METHODES
    @ManyToOne
    @JoinColumn(name = "origine_idref")
    private Origine origine;

    @OneToMany(mappedBy = "cooperative")
    private List<Produit> produits;
}
