package com.terroir.repositories;

import com.terroir.entities.Cooperative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepo extends JpaRepository<Cooperative, Integer> {}
