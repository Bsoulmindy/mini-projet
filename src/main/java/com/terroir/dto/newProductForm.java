package com.terroir.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class newProductForm {
	private String nom;
	private String unite;
	private String categorie;
	private float prix;
	private MultipartFile file;
}