package com.googlekeepapi.controller.dto;

import com.googlekeepapi.modelo.Marcador;

public class MarcadorDto {
	private String nome;

	public MarcadorDto() {
	}

	public MarcadorDto(Marcador marcador) {
		this.nome = marcador.getNome();
		
	}

	public String getNome() {
		return nome;
	}
	
	
	
	

}
