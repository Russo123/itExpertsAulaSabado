package com.itexpertes.exerciciospringboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Endereco implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bairro;
	private String tipoLogradouro;
	private int numero;
	private String status;
	private String cidade;
	private String estado;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cliente_id" , nullable = false)
	private Cliente cliente;

	public Endereco(Long id, String bairro, String tipoLogradouro, int numero, String status, String cidade,
			String estado, Cliente cliente) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.tipoLogradouro = tipoLogradouro;
		this.numero = numero;
		this.status = status;
		this.cidade = cidade;
		this.estado = estado;
		this.cliente = cliente;
	}
	
	
}
