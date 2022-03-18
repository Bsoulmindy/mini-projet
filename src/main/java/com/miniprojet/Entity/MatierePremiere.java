package com.miniprojet.Entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class MatierePremiere {
    @Id
    private int id;

    private String nom;
}
