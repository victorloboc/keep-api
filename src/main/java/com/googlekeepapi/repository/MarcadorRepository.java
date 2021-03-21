package com.googlekeepapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.googlekeepapi.modelo.Marcador;

public interface MarcadorRepository extends JpaRepository<Marcador, String>{
	Marcador findByNome(String nome);
}
