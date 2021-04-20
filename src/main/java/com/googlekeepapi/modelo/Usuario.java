package com.googlekeepapi.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.googlekeepapi.config.validacao.ValorUnico;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ValorUnico(campo = "email", entidade = Usuario.class)
	@Column(unique = true)
	private String email;
	private String senha;
	private LocalDateTime dataCriacaoUsuario = LocalDateTime.now();

	public Usuario() {
	}

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataCriacaoUsuario() {
		return dataCriacaoUsuario;
	}

	public void setDataCriacaoUsuario(LocalDateTime dataCriacaoUsuario) {
		this.dataCriacaoUsuario = dataCriacaoUsuario;
	}

}
