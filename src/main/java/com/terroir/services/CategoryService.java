package com.terroir.services;

import java.util.ArrayList;
import java.util.List;

import com.terroir.entities.enumerations.Categorie;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	public List<String> getAllCategories()
	{
		List<String> list = new ArrayList<>();
		for (Categorie categorie : Categorie.values() ) {
			list.add(categorie.getName());
		}
		return list;
	}
}
