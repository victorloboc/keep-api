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
	@ManyToOne
	private Marcador marcador;
	private Boolean fixar;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
	private Usuario usuario;

	public Nota() {
	}

	public Nota(String titulo, String texto, Marcador marcador, Boolean fixar, Usuario usuario, Cor corNota) {
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

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}


	public Cor getCorNota() {
		return corNota;
	}

	public Marcador getMarcador() {
		return marcador;
	}

	public Boolean getFixar() {
		return fixar;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
