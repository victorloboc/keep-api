package com.googlekeepapi.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Marcador {
	@Id 
	private String nome;

	public String getNome() {
		return nome;
	}


	

}
