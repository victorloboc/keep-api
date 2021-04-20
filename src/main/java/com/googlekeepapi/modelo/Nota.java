package com.googlekeepapi.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String texto;
	@Enumerated(EnumType.STRING)
	private Cor corNota;
	private String marcador;
	private Boolean fixar;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
	private Usuario usuario;

	@Deprecated
	public Nota() {
	}

	public Nota(String titulo, String texto, String marcador, Boolean fixar, Usuario usuario, Cor corNota) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.marcador = marcador;
		this.fixar = fixar;
		this.usuario = usuario;
		this.corNota = corNota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Cor getCorNota() {
		return corNota;
	}

	public void setCorNota(Cor corNota) {
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
