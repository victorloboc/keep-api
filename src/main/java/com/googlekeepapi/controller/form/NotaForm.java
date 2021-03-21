package com.googlekeepapi.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.googlekeepapi.modelo.Cor;
import com.googlekeepapi.modelo.Marcador;
import com.googlekeepapi.modelo.Nota;
import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.MarcadorRepository;
import com.googlekeepapi.repository.UsuarioRepository;

public class NotaForm {
	
	@NotNull
	@NotEmpty
	@Length(min = 15)
	@Email
	private String emailUsuario;
	@NotNull
	@NotEmpty
	@Length(min = 15)
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
	
	public Nota converter(UsuarioRepository usuarioRepository, MarcadorRepository marcadorRepository) {
		Usuario usuario = usuarioRepository.findByEmail(this.emailUsuario);
		Marcador marcador = marcadorRepository.findByNome(this.marcador);
		Cor cor = Cor.valueOf(corNota.toUpperCase());
		
		return new Nota(this.titulo, this.texto, marcador, this.fixar, usuario, cor);
	}

}
