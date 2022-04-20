package com.terroir.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commande_id;

    private float commande_prix_total;

    private boolean commande_is_delivre;

    

    // LES METHODES
    @OneToMany(mappedBy = "commande")
    private List<CommandeProduitAsso> commandeProduitAssos;

    @ManyToOne
    @JoinColumn(name = "compte_idref")
    private Compte compte;
}
