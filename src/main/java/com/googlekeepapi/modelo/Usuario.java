package com.googlekeepapi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.googlekeepapi.controller.form.UsuarioForm;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String senha;

	public Usuario() {
	}

	public Usuario(UsuarioForm usuarioForm) {
		super();
		this.email = usuarioForm.getEmail();
		this.senha = usuarioForm.getSenha();
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

}
