package com.terroir.entities;

import javax.persistence.*;

import lombok.Data;

@Data
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compte_id;

    private String compte_email;

    private String compte_password;
}
