package com.googlekeepapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.UsuarioRepository;

public class UsuarioForm {
	@NotNull
	@NotEmpty
	@Length(min = 15)
	private String email;
	@NotNull
	@NotEmpty
	@Length(min = 8)
	private String senha;

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		
		return usuario;
	}

}
