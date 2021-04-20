package com.googlekeepapi.controller.dto;

import com.googlekeepapi.modelo.Usuario;

public class UsuarioResponse {

	private Long id;
	private String email;

	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
