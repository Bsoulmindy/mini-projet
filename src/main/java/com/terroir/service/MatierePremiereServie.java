package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.exception.MatiereDejaExist;
import com.terroir.repositories.MatiereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatierePremiereServie implements  IMatierePremiereService{

    @Autowired
    MatiereRepo matiereRepo;


    @Override
    public MatierePremiere findByNom(String nom) {
        return matiereRepo.findByNom(nom);
    }

    @Override
    public void addMatierePremiere(MatierePremiere matierePremiere)
            throws MatiereDejaExist {
        String nom = matierePremiere.getNom();
        MatierePremiere mp = this.findByNom(nom);
        if(mp!=null) throw   new MatiereDejaExist();
        else  {
            matiereRepo.save(matierePremiere);
         }

    }
}
