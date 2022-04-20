package com.terroir.controllers;

import com.terroir.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlleur unique aux admins
 */
@RestController
@RequestMapping("/admin/")
public class AdminController {
    
    @Autowired
    AdminService  adminService;

    /**
     * Accepter (ou refuser) une demande d'être coopérative
     * @param idCooperative ID Coopérative
     * @param isAccepted Accepter ou Refuser
     */
    @PostMapping("gererDemandeCoop")
    public void gererDemandeCoop(int idCooperative, boolean isAccepted)
    {
        //TODO
    }

    @GetMapping("getDemandesCooperatives")
    public ModelAndView getDemandesCooperatives() //TODO : demandeCooperatives
    {
        ModelAndView model = new ModelAndView("contenu/gestionCooperativesContenu");
        return model;
    }

    @GetMapping("getAllMP")
    public ModelAndView getAllMP() //TODO : matierePremieres
    {
        ModelAndView model = new ModelAndView("contenu/gestionMPContenu");
        return model;
    }

    /**
     * Créer un nouveau matière première à partir du nom
     * @param nom Le nom du nouveau matière première
     */
    @PostMapping("newMP")
    public void newMP(String nom)
    {
        //TODO
    }

    @GetMapping("getAllOrigine")
    public ModelAndView getAllOrigine() //TODO : origines
    {
        ModelAndView model = new ModelAndView("contenu/gestionOrigineContenu");
        return model;
    }

    /**
     * Créer une nouvelle origine à partir du nom
     * @param nom Le nom du nouveau origine
     */
    @PostMapping("newOrigine")
    public void newOrigine(String nom)
    {
        //TODO
    }
}
