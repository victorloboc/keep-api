package com.googlekeepapi.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm, 
			UriComponentsBuilder uriBuilder) {
		//persistência
		Usuario usuario = new Usuario(usuarioForm);
		usuarioRepository.save(usuario);
		
		//uri da resposta da requisição
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
	
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario)); //dto tem que ter os getters
	}
	
	//ALTERAR DADOS DO USUÁRIO
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> alterarDadosUsuario(@PathVariable Long id, 
			@RequestBody @Valid UsuarioForm usuarioForm) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if(usuarioOptional.isPresent()) { //verificando se existe usuario com o id recebido
			Usuario usuario = usuarioForm.atualizar(id, usuarioRepository);
			usuarioRepository.save(usuario);
			
			return ResponseEntity.ok(new UsuarioDto(usuario));	
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//EXCLUIR USUARIO
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if(usuarioOptional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
