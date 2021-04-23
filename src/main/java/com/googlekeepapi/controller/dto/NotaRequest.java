package com.googlekeepapi.controller.dto;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import com.googlekeepapi.modelo.Cor;
import com.googlekeepapi.modelo.Nota;
import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.UsuarioRepository;

public class NotaRequest {
	
	@NotEmpty
	@Email
	private String emailUsuario;
	@NotEmpty
	@Length(min = 8)
	private String titulo;
	private String texto = " ";
	private String corNota = "padrao";
	private String marcador = "nenhum";
	private Boolean fixar = false;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCorNota() {
		return corNota;
	}

	public void setCorNota(String corNota) {
		this.corNota = corNota;
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public Boolean getFixar() {
		return fixar;
	}

	public void setFixar(Boolean fixar) {
		this.fixar = fixar;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	public Nota toNota(UsuarioRepository usuarioRepository) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(this.emailUsuario);
		Usuario usuario = usuarioOptional.get();
		Cor cor = Cor.valueOf(corNota.toUpperCase());
		System.out.println(usuario.getEmail());
		return new Nota(this.titulo, this.texto, this.marcador, this.fixar, usuario, cor);
	}

}
