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
    
    @Autowired AdminService  adminService;

    /**
     * Accepter (ou refuser) une demande d'être coopérative
     * @param idCooperative ID Coopérative
     * @param isAccepted Accepter ou Refuser
     */
    @PostMapping("gererDemandeCoop")
    public void gererDemandeCoop(int idCooperative, boolean isAccepted)
    {
        adminService.gererDemandeCoop(idCooperative, isAccepted);
    }

    /**
     * Afficher tous les demandes coopératives qui ne sont pas encore approuvés
     */
    @GetMapping("getDemandesCooperatives")
    public ModelAndView getDemandesCooperatives()
    {
        ModelAndView model = new ModelAndView("contenu/gestionCooperativesContenu");
        model.addObject("demandeCooperatives", adminService.getDemandeCooperatives());
        return model;
    }

    /**
     * Afficher tous les matières premières actuel dans la BD
     */
    @GetMapping("getAllMP")
    public ModelAndView getAllMP()
    {
        ModelAndView model = new ModelAndView("contenu/gestionMPContenu");
        model.addObject("matierePremieres", adminService.getAllMatierePremieres());
        return model;
    }

    /**
     * Créer un nouveau matière première à partir du nom
     * @param nom Le nom du nouveau matière première
     */
    @PostMapping("newMP")
    public void newMP(String nom)
    {
        adminService.creerMatierePremiere(nom);
    }

    @GetMapping("getAllOrigine")
    public ModelAndView getAllOrigine()
    {
        ModelAndView model = new ModelAndView("contenu/gestionOrigineContenu");
        model.addObject("origines", adminService.getAllOrigines());
        return model;
    }

    /**
     * Créer une nouvelle origine à partir du nom
     * @param nom Le nom du nouveau origine
     */
    @PostMapping("newOrigine")
    public void newOrigine(String nom)
    {
        adminService.creerOrigine(nom);
    }
}
