package com.terroir.repositories;

import java.util.List;

import com.terroir.entities.Cooperative;
import com.terroir.entities.enumerations.SecteurActivite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepo extends JpaRepository<Cooperative, Integer> {
    
    @Query("from Cooperative as c where c.cooperative_id = :cooperative_id")
    Cooperative getCooperativeByID(@Param("cooperative_id") int cooperative_id);

    @Query("from Cooperative as c where c.cooperative_secteur_activite = :secteurActivite")
    List<Cooperative> getCooperativesBySecteurActivite(@Param("secteurActivite") SecteurActivite secteurActivite);
}
