package com.terroir.services;

import com.terroir.repositories.CommandeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
	@Autowired CommandeRepo commandeRepo;

	
}
