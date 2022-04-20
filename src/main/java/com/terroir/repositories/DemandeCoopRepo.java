package com.terroir.repositories;

import com.terroir.entities.DemandeCooperative;
import com.terroir.entities.DemandeCooperativeKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCoopRepo extends JpaRepository<DemandeCooperative, DemandeCooperativeKey> {
	
}
