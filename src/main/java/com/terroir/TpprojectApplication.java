package com.terroir;
import com.terroir.repositories.ProduitRepo;
import com.terroir.services.IMatierePremiereService;
import com.terroir.services.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class TpprojectApplication implements CommandLineRunner {

        @Autowired
        IProduitService produitService;

        @Autowired
        ProduitRepo produitRepo;

        @Autowired
        IMatierePremiereService matierePremiereService;

        public static void main(String[] args) {
                SpringApplication.run(TpprojectApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                /*
                 * MatierePremiere mp1 = Matierresult2ePremiere.builder() .nom("Amonde")
                 * .build(); MatierePremiere mp2 = MatierePremiere.builder() .nom("Argan")
                 * .build(); MatierePremiere mp3 = MatierePremiere.builder()
                 * .nom("Safran") .build(); Produit pr1 = Produit.builder()
                 * .nom("produit1") .produitMatieresAsso(new ArrayList<>()) .build();
                 * 
                 * Produit pr2 = Produit.builder() .nom("produit2")
                 * .produitMatieresAsso(new ArrayList<>()) .build();
                 */
                // produitService.addProduit(pr1, mp1, mp3);
                // produitService.addProduit(pr2, mp1);

              /*   List<Integer> lid = produitService.getListProduitsParMatiers(1);
                for (int idproduit : lid) {
                        Optional<Produit> produit = produitRepo.findById(idproduit);
                        System.out.println(produit.get().getProduit_nom());
                } */

                // System.out.println(cp.size());
        }
}
