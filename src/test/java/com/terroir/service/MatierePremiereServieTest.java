package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.exception.MatiereDejaExist;
import com.terroir.repositories.MatiereRepo;
import com.terroir.services.IMatierePremiereService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MatierePremiereServieTest {

    @Autowired
    IMatierePremiereService matierePremiereService;

    @Autowired
    MatiereRepo matiereRepo;

    @Test(expected = MatiereDejaExist.class)
    public void testAddException() throws MatiereDejaExist {
        MatierePremiere mp = matiereRepo.findByNom("m4");
        matierePremiereService.addMatierePremiere(mp);
        fail("Exception non lévée");
    }
}