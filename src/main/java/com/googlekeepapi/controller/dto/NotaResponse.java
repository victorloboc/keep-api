package com.googlekeepapi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.googlekeepapi.modelo.Nota;

public class NotaResponse {
	private Long id;
	private String titulo;
	private String texto;
	private LocalDateTime dataCriacao;
	private String emailUsuario;
	private String corNota;
	private String marcador;
	private Boolean fixar;

	public NotaResponse(Nota nota) {
		this.id = nota.getId();
		this.titulo = nota.getTitulo();
		this.texto = nota.getTexto();
		this.dataCriacao = nota.getDataCriacao();
		this.emailUsuario = nota.getUsuario().getEmail();
		this.corNota = nota.getCorNota().name();
		this.marcador = nota.getMarcador();
		this.fixar = nota.getFixar();
	}

	public NotaResponse() {
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}
	
	public String getMarcadores() {
		return marcador;
	}

	public Boolean getFixar() {
		return fixar;
	}

	public String getCorNota() {
		return corNota;
	}
	
	public List<NotaResponse> toList(List<Nota> notas) {
		List<NotaResponse> notasResponse = new ArrayList<NotaResponse>();
		
		for(Nota nota : notas) {
			NotaResponse notaDto = new NotaResponse(nota);
			notasResponse.add(notaDto);
		}
		return notasResponse;
		
	}
	

}
