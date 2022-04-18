package com.terroir.configuration;


import com.terroir.repositories.CompteRepo;

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
   @Autowired CompteRepo compteRepository;
   @Autowired JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
   @Autowired JwtRequestFilter jwtRequestFilter;
   @Bean
   public UserDetailsService userDetailsService() {
      return new CompteDetailsServiceImpl(compteRepository);
   }

   @Override
   @Bean
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
   }

   @Bean 
   public PasswordEncoder passwordEncoder() { 
      return new BCryptPasswordEncoder(); 
   } 
   @Override 
   protected void configure(HttpSecurity http) throws Exception { 
      http 
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/tracking").hasAuthority("User")
      .antMatchers("/Admin/**").hasAuthority("Admin")
      .anyRequest().permitAll() //any other request
      .and().exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
		sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// 		Add a filter to validate the tokens with every request
//		http.addFilterBefore(jwtRequestFilter, 
	//	UsernamePasswordAuthenticationFilter.class);
   }
}