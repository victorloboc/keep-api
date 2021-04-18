package com.googlekeepapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.googlekeepapi.controller.dto.MarcadorDto;
import com.googlekeepapi.modelo.Marcador;
import com.googlekeepapi.repository.MarcadorRepository;

@RestController
@RequestMapping("/marcadores")
public class MarcadorController {

	@Autowired
	private MarcadorRepository marcadorRepository;
	
	//CADASTRAR MARCADOR
	
	@PostMapping
	@Transactional
	public ResponseEntity<MarcadorDto> cadastrarMarcador(@RequestBody @Valid MarcadorDto marcadorDto,
			UriComponentsBuilder uriBuilder) {
		Marcador marcador = marcadorDto.toMarcador();
		marcadorRepository.save(marcador);
		
		URI uri = uriBuilder.path("/marcadores/{id}").buildAndExpand(marcador.getId()).toUri();
		return ResponseEntity.created(uri).body(new MarcadorDto(marcador));
	}
	
//	//LISTAR MARCADORES
//	
//	@GetMapping
//	public ResponseEntity<List<MarcadorDto>> listarMarcadores() {
//		List<MarcadorDto> marcadoresDto = new ArrayList<MarcadorDto>();
//		List<Marcador> marcadores = marcadorRepository.findAll();
//		
//		for(Marcador marcador : marcadores) {
//			marcadoresDto.add(new MarcadorDto(marcador));
//		}
//		
//		return ResponseEntity.ok(marcadoresDto);
//	}
}
