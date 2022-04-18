package com.terroir.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 
@Configuration 
public class WebSecurity extends WebSecurityConfigurerAdapter { 
   @Autowired JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
   @Autowired JwtRequestFilter jwtRequestFilter;
   /**
    * Une méthode pour utiliser l'entité <code>Compte</code> comme
    * <code>User</code> prédéfinie par Spring Security
    */
   @Bean
   public UserDetailsService userDetailsService() {
      return new CompteDetailsServiceImpl();
   }

   /**
    * 
    */
   @Override
   @Bean
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }
   /**
    * Par exemple un client veut se connecter avec username & password
    * <code>AuthenticationManager</code> va vérifier dans la BD ces crédentials
    * en utilisant le passwordEncoder
    */
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
   }

   @Bean 
   public PasswordEncoder passwordEncoder() { 
      return new BCryptPasswordEncoder(); 
   } 
   /**
    * Une méthode pour les autorisations
    */
   @Override 
   protected void configure(HttpSecurity http) throws Exception { 
      http 
      .csrf().disable()
      // autoriser
      .authorizeRequests()
      .antMatchers("/tracking").hasAuthority("User")
      .antMatchers("/Admin/**").hasAuthority("Admin")
      .anyRequest().permitAll()
      // Politique par défaut pour un client non autorisé
      .and().exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().
		// Mettre la session STATELESS
		sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

      // Mettre filter JWT avant l'authentification
      // Pourqoui? pour s'authentifier un client posséde le token directement
      // sans passer à <code>UsernamePasswordAuthenticationFilter</code>
		http.addFilterBefore(jwtRequestFilter, 
		UsernamePasswordAuthenticationFilter.class);
   }
}