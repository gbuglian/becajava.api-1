package br.eleicao.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import br.eleicao.app.model.*;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Numero;
	private String Nome;
	private String Tipo;
	
	@ManyToOne
	@JoinColumn(name = "MunicipioId")
	private Municipio Municipio;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNumero() {
		return Numero;
	}
	
	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public Municipio getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(Municipio municipio) {
		Municipio = municipio;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	

}
