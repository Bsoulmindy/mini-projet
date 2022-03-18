package com.miniprojet.Repository;

import com.miniprojet.Entity.MatierePremiere;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatierePremiereRepo extends JpaRepository<MatierePremiere, Long> {
    
}
