package com.googlekeepapi.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.googlekeepapi.controller.dto.UsuarioDto;
import com.googlekeepapi.controller.form.UsuarioForm;
import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//CADASTRAR USUÁRIOS
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, 
			UriComponentsBuilder uriBuilder) {
		//persistência
		Usuario usuario = new Usuario(usuarioForm);
		usuarioRepository.save(usuario);
		
		//uri da resposta da requisição
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
	
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario)); //dto tem que ter os getters
	}
	
}
