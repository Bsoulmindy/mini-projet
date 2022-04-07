package com.terroir.entities.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterCompteForm implements Serializable {
    
    //Infos sur le compte
    private String username;

    private String password;

    private String nom;
}
