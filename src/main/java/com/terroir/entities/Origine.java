package com.terroir.entities;

import lombok.Data;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Data
@Entity
public class Origine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int origine_id;
    private String origine_nom;


    // LES METHODES
    @OneToMany(mappedBy = "origine")
    private Set<ProduitMatiereAsso> produitMatieresAsso;
}
