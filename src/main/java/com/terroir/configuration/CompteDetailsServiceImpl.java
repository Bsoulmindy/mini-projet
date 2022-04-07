package com.terroir.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.terroir.entities.Compte;
import com.terroir.entities.DemandeCooperative;
import com.terroir.repositories.CompteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompteDetailsServiceImpl implements UserDetailsService {


   @Autowired private CompteRepo CompteRepository;

   public CompteDetailsServiceImpl(CompteRepo CompteRepository) {
      this.CompteRepository = CompteRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Compte Compte = CompteRepository.getByUsername(userName);
      if (Compte == null) {
         throw new UsernameNotFoundException("Compte non trouvé");
      }
      return new org.springframework.security.core.userdetails.User(Compte.getCompte_username(),
            Compte.getCompte_password(),
            mapRolesToAuthorities(Compte));
   }
   
   /**
    * <p>Donner les roles de chaque compte qui est en train de connecter</p>
    * <p>Les rôles disponibles sont: <code>Client</code> et <code>Admin</code></p>
    * @param isAdmin : Est ce que le compte est Admin ou non?
    * @return <code>Collection</code> qui contient les rôles associés du compte
    */
   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Compte compte) {
      List<String> roles = new ArrayList<String>();
      roles.add("User");
      // Est ce qu'il s'agit d'un admin?
      if (compte.isAdmin()) roles.add("Admin");
      // Est ce qu'il s'agit d'un coopérative?
      else
      {
         DemandeCooperative demandeCooperative = compte.getPersonne().getDemandeCooperative();
         if(demandeCooperative != null && demandeCooperative.isDemande_approuvee())
         {
            roles.add("Cooperative");
         }
      }
      return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role))
            .collect(Collectors.toList());
   }
}