package com.terroir.services;

import com.terroir.entities.MatierePremiere;
import com.terroir.exception.MatiereDejaExist;

public interface IMatierePremiereService {
    /**
     * Recuperer un matiere première avec son nom
     * 
     * @param nom
     * @return <code>MatierePremiere</code>
     */
    public MatierePremiere findByNom(String nom);

    /**
     * Ajouter <code>MatierePremiere</code> à BD
     * 
     * @param matierePremiere
     * @throws MatiereDejaExist <code>MatierePremiere</code> déjà existe dans BD
     */
    public void addMatierePremiere(MatierePremiere matierePremiere)
            throws MatiereDejaExist;
}
