package com.terroir.repositories;

import com.terroir.entities.ProduitMatiereAsso;
import com.terroir.entities.ProduitMatiereKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitMatiiereAssoRepo extends JpaRepository<ProduitMatiereAsso, ProduitMatiereKey> {}