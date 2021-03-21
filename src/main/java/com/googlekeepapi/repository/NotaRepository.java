package com.googlekeepapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.googlekeepapi.modelo.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
	
}
