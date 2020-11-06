package br.eleicao.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.eleicao.app.model.Municipio;
import br.eleicao.app.repository.MunicipioRepository;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

	final MunicipioRepository _municipioRepository; 

	public MunicipioController(MunicipioRepository municipioRepository) {
		_municipioRepository = municipioRepository;
	}
	@PostMapping
	public ResponseEntity inserir(@RequestBody Municipio municipio) {
		_municipioRepository.save(municipio);
		return ResponseEntity.status(HttpStatus.CREATED).body("Municipio Criado!!!");	
	}
	@GetMapping
	public ResponseEntity listar() {
		Iterable<Municipio> municipio = _municipioRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(municipio);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		Optional<Municipio> municipio = _municipioRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(municipio);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
		municipio.setId(id);
		_municipioRepository.save(municipio);
		return ResponseEntity.status(HttpStatus.OK).body("Municpio Atualizado!!");
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		_municipioRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}