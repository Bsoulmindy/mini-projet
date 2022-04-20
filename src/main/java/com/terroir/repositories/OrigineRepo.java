package com.terroir.repositories;

import com.terroir.entities.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigineRepo extends JpaRepository<Origine, Integer> {
	@Query("from Origine as o where o.origine_nom = :nom")
	public Origine getOrigineByNom(@Param("nom") String nom);
}