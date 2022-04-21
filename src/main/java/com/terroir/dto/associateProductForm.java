package com.terroir.dto;

import lombok.Data;

@Data
public class associateProductForm {
	int idProduit;
	int idMatierePremiere;
	int idOrigine;
	String qte;
	String unite;
}
