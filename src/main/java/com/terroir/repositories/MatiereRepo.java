package com.terroir.repositories;

import com.terroir.entities.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepo extends JpaRepository<MatierePremiere,Long> {
    public MatierePremiere findByNom(String nom);
    public MatierePremiere save(MatierePremiere mp);
}
