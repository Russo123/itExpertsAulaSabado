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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Data
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoDoc;
	private String numero;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cliente_id" , nullable = false)
	private Cliente cliente;

	public Documento(Long id, String tipoDoc, String numero, Cliente cliente) {
		super();
		this.id = id;
		this.tipoDoc = tipoDoc;
		this.numero = numero;
		this.cliente = cliente;
	}

}
