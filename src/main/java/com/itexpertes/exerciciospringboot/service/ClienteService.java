package com.itexpertes.exerciciospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itexpertes.exerciciospringboot.model.Cliente;
import com.itexpertes.exerciciospringboot.repository.ClienteRepository;
import com.itexpertes.exerciciospringboot.repository.DocumentoRepository;
import com.itexpertes.exerciciospringboot.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Transactional
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional(readOnly = true)
	public List<Cliente> getAllClientes() {
	
		List<Cliente> clientes = clienteRepository.findAll();
		
		if (clientes.isEmpty())
			throw new RuntimeException("Ainda não posssui clientes cadastrados");

		return clientes;

	}

}
