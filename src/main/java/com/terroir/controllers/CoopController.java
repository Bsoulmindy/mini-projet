package com.terroir.controllers;

import java.util.List;

import com.terroir.entities.Cooperative;
import com.terroir.services.CoopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
@RequestMapping("/cooperatives")
public class CoopController {
    
    @Autowired
    CoopService cooperativeService; 

    @GetMapping(value = "/{id}")
	public Cooperative getProduit(@PathVariable("id") int id){
        return CoopService.getCoop(id);
    }

      
    public List<Integer> getCoopParOrigine(@RequestParam("idorigine")int idorigine){
        return CoopService.getListCoopsParOrigine(idorigine);
    }    

    
    public List<Integer> getCoopParSecteur(@RequestParam("idsect")int idsect){
        return CoopService.getListCoopsParSecteur(idsect);
    }
    
    
    
}
