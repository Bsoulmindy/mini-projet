package com.terroir.repositories;

import com.terroir.entities.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigineRepo extends JpaRepository<Origine, Integer> {}