package com.googlekeepapi.controller.dto;

import javax.validation.constraints.NotEmpty;
import com.googlekeepapi.config.validacao.ValorUnico;
import com.googlekeepapi.modelo.Marcador;

public class MarcadorDto {

	@ValorUnico(entidade = Marcador.class, campo = "nome")
	@NotEmpty
	private String nome;

	@Deprecated
	public MarcadorDto() {
	}

	public MarcadorDto(Marcador marcador) {
		this.nome = marcador.getNome();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marcador toMarcador() {
		return new Marcador(this.nome);
	}

}
