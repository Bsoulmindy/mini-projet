package com.terroir.service;

import com.terroir.entities.Produit;
import com.terroir.repositories.ProduitRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProduitServiceTest {

    @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepo produitRepo;

    @Test
    public void testAddProduit() {
    }

    @Test
    public void getListProduitsParMatiers() {
        List<Integer> lid = produitService.getListProduitsParMatiers(1);
        int id = lid.get(2);
            Produit produit = produitRepo.findById(id).get();
            assertEquals(produit.getProduit_nom(),"produit4");
    }



}