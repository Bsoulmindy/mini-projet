package com.terroir.service;

import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Produit;
import com.terroir.entities.ProduitMatiereAsso;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService implements IProduitService {

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    MatiereRepo matiereRepo;

    @Transactional
    public long addProduit(Produit pr, MatierePremiere... listMatiere) {

        for (MatierePremiere mp : listMatiere) {
            ProduitMatiereAsso ligne = new ProduitMatiereAsso();
         MatierePremiere mpr = matiereRepo.findByNom(mp.getNom());
         Collection<ProduitMatiereAsso> lignes = pr.getProduitMatieresAsso();
         if(mpr==null)
         {
               ligne.setMatierePremiere(mp);
               ligne.setProduit(pr);
               lignes.add(ligne);
         }
          else {
               ligne.setMatierePremiere(mpr);
               ligne.setProduit(pr);
               lignes.add(ligne);
           }
        }
        produitRepo.save(pr);
        return pr.getIdProduit();
    }

    @Override
    public long addProduit(Produit pr, Long... ids) {
        for (Long id : ids) {
            ProduitMatiereAsso ligne = new ProduitMatiereAsso();
            MatierePremiere mprp = matiereRepo.findById(id).get();
            MatierePremiere mpr = matiereRepo.findByNom(mprp.getNom());
            Collection<ProduitMatiereAsso> lignes = pr.getProduitMatieresAsso();
            if(mpr==null)
            {
                ligne.setMatierePremiere(mprp);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
            else {
                ligne.setMatierePremiere(mpr);
                ligne.setProduit(pr);
                lignes.add(ligne);
            }
        }
        produitRepo.save(pr);
        return pr.getIdProduit();
    }


    @Override
    public List<Long> getListProduitsParMatiers(Long... idmatps)
    {
        List<Long> ids1=produitRepo.getProduits(idmatps[0])
                .stream()
                .map(produit -> produit.getIdProduit())
                .collect(Collectors.toList());

        for(Long idmatp : idmatps) {
           List<Long >ids = produitRepo.getProduits(idmatp)
                    .stream()
                    .map(produit -> produit.getIdProduit())
                    .collect(Collectors.toList());

           ids1 = ids1.stream()
                    // .distinct()
                    .filter(ids::contains)
                    .collect(Collectors.toList());
       }

        return ids1;
    }
}
