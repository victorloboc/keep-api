package com.googlekeepapi.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.googlekeepapi.config.validacao.ValorUnico;

@Entity
public class Marcador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	@ValorUnico(entidade = Marcador.class, campo = "nome")
	@NotEmpty
	private String nome;

	public Marcador(String nome) {
		this.nome = nome;
	}

	@Deprecated
	public Marcador() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
