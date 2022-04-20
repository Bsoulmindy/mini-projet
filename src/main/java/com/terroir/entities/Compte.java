package com.terroir.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compte_id;

    @Column(unique = true)
    private String compte_username;

    private String compte_password;

    private boolean isAdmin;

    //private String coopName;

    @OneToOne(mappedBy = "compte")
    private Personne personne;

    @OneToMany(mappedBy = "compte")
    private List<Commande> commandes;
}
