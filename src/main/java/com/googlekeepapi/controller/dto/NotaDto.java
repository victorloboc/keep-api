package com.googlekeepapi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.googlekeepapi.modelo.Marcador;
import com.googlekeepapi.modelo.Nota;

public class NotaDto {
	private Long id;
	private String titulo;
	private String texto;
	private LocalDateTime dataCriacao;
	private String emailUsuario;
	private String corNota;
	private String marcador;
	private Boolean fixar;

	public NotaDto(Nota nota) {
		this.id = nota.getId();
		this.titulo = nota.getTitulo();
		this.texto = nota.getTexto();
		this.dataCriacao = nota.getDataCriacao();
		this.emailUsuario = nota.getUsuario().getEmail();
		this.corNota = nota.getCorNota().name();
		this.marcador = nota.getMarcador().getNome();
		this.fixar = nota.getFixar();
	}

	public NotaDto() {
		super();
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
	
	public List<NotaDto> converter(List<Nota> notas) {
		List<NotaDto> notasDto = new ArrayList<NotaDto>();
		
		for(Nota nota : notas) {
			NotaDto notaDto = new NotaDto(nota);
			notasDto.add(notaDto);
		}
		return notasDto;
		
	}
	

}
