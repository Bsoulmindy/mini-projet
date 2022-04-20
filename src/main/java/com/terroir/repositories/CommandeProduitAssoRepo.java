package com.terroir.repositories;

import com.terroir.entities.CommandeProduitAsso;
import com.terroir.entities.CommandeProduitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitAssoRepo extends JpaRepository<CommandeProduitAsso, CommandeProduitKey> {}