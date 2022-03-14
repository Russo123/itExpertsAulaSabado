package com.itexpertes.exerciciospringboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Data
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;

	private String nome;
	private int idade;
	private char genero;
	private double altura;
	private boolean ativo;
	
	@JsonManagedReference
	@OneToMany
	private List<Documento> documento;
	
	@JsonManagedReference
	@OneToMany
	private List<Endereco> endereco;

	public Cliente(Long id, String nome, int idade, char genero, double altura, boolean ativo,
			List<Documento> documento, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.altura = altura;
		this.ativo = ativo;
		this.documento = documento;
		this.endereco = endereco;
	}

}
