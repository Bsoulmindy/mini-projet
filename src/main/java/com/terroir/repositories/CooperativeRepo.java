package com.terroir.repositories;

import com.terroir.entities.Cooperative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CooperativeRepo extends JpaRepository<Cooperative, Integer> {
    
    @Query("from Cooperative as c where c.cooperative_id = :cooperative_id")
    Cooperative getCooperativeDesc(PathVariable cooperative_id);
}
