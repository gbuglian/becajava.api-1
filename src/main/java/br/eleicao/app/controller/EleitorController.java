package br.eleicao.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.eleicao.app.model.Eleitor;
import br.eleicao.app.repository.EleitorRepository;

@RestController
@RequestMapping(path = "/eleitores")
public class EleitorController {

	final EleitorRepository _eleitorRepository;

	public EleitorController(EleitorRepository eleitorRepository) {
		_eleitorRepository = eleitorRepository;
	}
	@PostMapping
	public ResponseEntity inserir(@RequestBody Eleitor eleitor) {
		_eleitorRepository.save(eleitor);
		return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor Criado!!");
	}
	@GetMapping
	public ResponseEntity listar() {
		Iterable<Eleitor> eleitor = _eleitorRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		Optional<Eleitor> eleitor = _eleitorRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Eleitor eleitor,@PathVariable Long id) {
		eleitor.setId(id);
		_eleitorRepository.save(eleitor);
		return ResponseEntity.status(HttpStatus.OK).body("Eleitor Atualizado!!");
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_eleitorRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}