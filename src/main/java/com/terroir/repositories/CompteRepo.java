package com.terroir.repositories;

import com.terroir.entities.Compte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte, Integer> {}
