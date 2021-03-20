package com.googlekeepapi.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Nota {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String texto;
	@OneToOne
	private Lembrete lembrete;
	@Enumerated(EnumType.STRING)
	private Cor corNota;
	@ManyToMany
	private List<Marcador> marcador;
	private Boolean fixar;
	private LocalDateTime dataCriacao;
	@ManyToOne
	private Usuario usuario;
	
}
