package br.eleicao.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eleicao.app.repository.CandidatoRepository;
import br.eleicao.app.model.Candidato;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	
	final CandidatoRepository  _candidatoRepository;
	
	public CandidatoController(CandidatoRepository candidatoRepository) {
		_candidatoRepository = candidatoRepository;
	}
	
	@PostMapping
	public ResponseEntity Inserir(@RequestBody Candidato candidato) {
		_candidatoRepository.save(candidato);
		return ResponseEntity.status(HttpStatus.CREATED).body("Candidato Criado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity listar() {
		Iterable<Candidato> candidato = _candidatoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long Id) {
		Optional<Candidato> candidato = _candidatoRepository.findById(Id);
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato,@PathVariable Long id) {
		candidato.setId(id);
		_candidatoRepository.save(candidato);
		return ResponseEntity.status(HttpStatus.OK).body("Candidato Atualizado!!");
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_candidatoRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
