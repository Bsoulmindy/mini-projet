package com.terroir.controllers;

import com.terroir.configuration.CompteDetailsServiceImpl;
import com.terroir.configuration.JwtRequest;
import com.terroir.configuration.JwtResponse;
import com.terroir.configuration.JwtTokenUtil;
import com.terroir.services.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private CompteService compteService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CompteDetailsServiceImpl userDetailsService;

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		compteService.connecterAvecUsername(authenticationRequest);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
}