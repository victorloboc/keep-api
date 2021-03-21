package com.googlekeepapi.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.googlekeepapi.controller.dto.NotaDto;
import com.googlekeepapi.controller.form.NotaForm;
import com.googlekeepapi.controller.form.NotaFormAtualizacao;
import com.googlekeepapi.modelo.Nota;
import com.googlekeepapi.repository.MarcadorRepository;
import com.googlekeepapi.repository.NotaRepository;
import com.googlekeepapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/notas")
public class NotasController {

	@Autowired
	private MarcadorRepository marcadorRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private NotaRepository notaRepository;
	
	//CADASTRAR NOVA NOTA
	
	@PostMapping
	@Transactional
	public ResponseEntity<NotaDto> cadastrarNovaNota(@RequestBody @Valid NotaForm notaForm, 
			UriComponentsBuilder uriBuilder) {
		Nota nota = notaForm.converter(usuarioRepository, marcadorRepository);
		notaRepository.save(nota);
		
		URI uri = uriBuilder.path("/notas/{id}").buildAndExpand(nota.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaDto(nota));
	}
	
	//ALTERAR NOTA
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<NotaDto> alterarNota(@PathVariable Long id, 
			@RequestBody @Valid NotaFormAtualizacao notaFormAtualizacao){
		Optional<Nota> notaOpcional = notaRepository.findById(id);
		if(notaOpcional.isPresent()) {
			Nota nota = notaFormAtualizacao.atualizar(id, notaRepository, marcadorRepository);
			return ResponseEntity.ok(new NotaDto(nota));
		}
		
		return ResponseEntity.notFound().build();
	}

}
