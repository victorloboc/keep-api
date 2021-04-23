package com.googlekeepapi.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.googlekeepapi.config.validacao.ValorUnico;
import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.UsuarioRepository;

public class UsuarioRequest {
	
	@NotEmpty
	@Email
	@ValorUnico(campo = "email", entidade = Usuario.class)
	private String email;
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

	public Usuario toUsuario() {
		return new Usuario(this.email, new BCryptPasswordEncoder().encode(this.senha));
	}

}
