package com.googlekeepapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.googlekeepapi.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);

}
