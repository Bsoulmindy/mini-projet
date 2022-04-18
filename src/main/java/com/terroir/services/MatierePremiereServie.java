package com.terroir.services;

import java.util.List;

import com.terroir.entities.MatierePremiere;
import com.terroir.exception.MatiereDejaExist;
import com.terroir.repositories.MatiereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatierePremiereServie implements IMatierePremiereService {

    @Autowired
    MatiereRepo matiereRepo;

    @Override
    public MatierePremiere findByNom(String nom) { return matiereRepo.getByNom(nom); }

    @Override
    public void addMatierePremiere(MatierePremiere matierePremiere) throws MatiereDejaExist {
        String nom = matierePremiere.getMatiere_premiere_nom();
        MatierePremiere mp = this.findByNom(nom);
        if (mp != null)
            throw new MatiereDejaExist();
        else {
            matiereRepo.save(matierePremiere);
        }

    }

    public List<MatierePremiere> getAllMatierePremieres() {
        return matiereRepo.findAll();
    }
}
