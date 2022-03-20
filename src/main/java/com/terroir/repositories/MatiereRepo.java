package com.terroir.repositories;

import com.terroir.entities.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public interface MatiereRepo extends JpaRepository<MatierePremiere, Integer> {
    @Query("from MatierePremiere as mp where mp.matiere_premiere_nom = :nom")
    public MatierePremiere getByNom(@Param("nom") String nom);

    public MatierePremiere save(MatierePremiere mp);
}
