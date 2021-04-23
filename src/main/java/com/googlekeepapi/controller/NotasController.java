package com.googlekeepapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.googlekeepapi.controller.dto.NotaRequest;
import com.googlekeepapi.controller.dto.NotaRequestUpdate;
import com.googlekeepapi.controller.dto.NotaResponse;
import com.googlekeepapi.modelo.Nota;
import com.googlekeepapi.modelo.Usuario;
import com.googlekeepapi.repository.NotaRepository;
import com.googlekeepapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/notas")
public class NotasController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private NotaRepository notaRepository;
	
	//CADASTRAR NOVA NOTA
	
	@PostMapping
	@Transactional
	public ResponseEntity<NotaResponse> cadastrarNovaNota(@RequestBody @Valid NotaRequest notaRequest, 
			UriComponentsBuilder uriBuilder) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(notaRequest.getEmailUsuario());
		if(usuarioOptional.isPresent()) {
			Nota nota = notaRequest.toNota(usuarioRepository);
			notaRepository.save(nota);
			
			URI uri = uriBuilder.path("/notas/{id}").buildAndExpand(nota.getId()).toUri();
			return ResponseEntity.created(uri).body(new NotaResponse(nota));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//ALTERAR NOTA
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<NotaResponse> alterarNota(@PathVariable Long id, 
			@RequestBody @Valid NotaRequestUpdate notaUpdate){
		Optional<Nota> notaOpcional = notaRepository.findById(id);
		if(notaOpcional.isPresent()) {
			Nota nota = notaUpdate.atualizar(id, notaRepository);
			return ResponseEntity.ok(new NotaResponse(nota));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//LISTAR NOTAS DE CADA USUARIO
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Page<NotaResponse>> listarNotas(@PathVariable Long idUsuario,
			@PageableDefault(sort = "id", direction = Direction.ASC, 
			page = 0, size = 3) Pageable paginacao) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
		if(usuarioOptional.isPresent()) {
			Page<Nota> notas = notaRepository.findByUsuario_Id(idUsuario, paginacao);
			return ResponseEntity.ok(new NotaResponse().toList(notas));
		}
			
		return ResponseEntity.notFound().build();
	}
	
	
	//DELETAR NOTA
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarNota(@PathVariable Long id) {
		Optional<Nota> notaOptional = notaRepository.findById(id);
		if(notaOptional.isPresent()) {
			notaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}



