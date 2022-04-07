package com.terroir.repositories;

import com.terroir.entities.Compte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Integer> {
	@Query("select c from Compte as c  where c.compte_username = :username")
    public Compte getByUsername(@Param("username") String username);
    
}
