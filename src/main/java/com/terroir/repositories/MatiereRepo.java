package com.terroir.repositories;

import com.terroir.entities.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unchecked")
public interface MatiereRepo extends JpaRepository<MatierePremiere,Integer> {
    public MatierePremiere findByNom(String nom);
    public MatierePremiere save(MatierePremiere mp);
}
