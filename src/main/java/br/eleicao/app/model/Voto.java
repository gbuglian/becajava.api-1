package br.eleicao.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import br.eleicao.app.model.*;

@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "EleitorId")
	private Eleitor eleitor;
	
	
	@ManyToOne
	@JoinColumn(name = "CandidatoId")
	private Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name = "ZonaId")
	private Zona zona;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor Eleitor) {
		Eleitor = eleitor;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato Candidato) {
		Candidato = candidato;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}	
	
	
}
