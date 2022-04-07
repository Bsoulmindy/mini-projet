package com.terroir.repositories;

import com.terroir.entities.Personne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends JpaRepository <Personne, Integer> {
	
}
