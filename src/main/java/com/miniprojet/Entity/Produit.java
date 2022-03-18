package com.miniprojet.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Produit {
    @Id
    private int id;

    private String nom;
    private String desc;
    private float prix;
    private String unite;
}
