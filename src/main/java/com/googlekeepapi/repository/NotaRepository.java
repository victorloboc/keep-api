package com.googlekeepapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.googlekeepapi.modelo.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
	List<Nota> findByUsuario_Id(Long id);
}
