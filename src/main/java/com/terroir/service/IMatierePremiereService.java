package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.exception.MatiereDejaExist;

public interface IMatierePremiereService {
    public MatierePremiere findByNom(String nom);
    public void addMatierePremiere(MatierePremiere matierePremiere) throws MatiereDejaExist;
}
