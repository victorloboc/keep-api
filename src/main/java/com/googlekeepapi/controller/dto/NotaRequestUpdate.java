package com.googlekeepapi.controller.dto;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import com.googlekeepapi.modelo.Cor;
import com.googlekeepapi.modelo.Nota;
import com.googlekeepapi.repository.NotaRepository;

public class NotaRequestUpdate {

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
	
	public Nota atualizar(Long id, NotaRepository notaRepository) {
		
		Nota nota = notaRepository.getOne(id);
		Cor cor = Cor.valueOf(this.corNota.toUpperCase());
		nota.setTitulo(this.titulo);
		nota.setTexto(this.texto);
		nota.setCorNota(cor);
		nota.setMarcador(this.marcador);
		nota.setFixar(this.fixar);

		return nota;
	}

}
