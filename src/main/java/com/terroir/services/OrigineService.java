package com.terroir.services;

import java.util.List;

import com.terroir.entities.Origine;
import com.terroir.repositories.OrigineRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrigineService {
	@Autowired OrigineRepo origineRepo;

	public List<Origine> getAlOrigines() {
		return origineRepo.findAll();
	}
}
