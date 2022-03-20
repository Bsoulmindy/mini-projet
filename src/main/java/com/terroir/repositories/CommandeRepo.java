package com.terroir.repositories;

import com.terroir.entities.Commande;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo extends JpaRepository<Commande, Integer> {}