package com.itexpertes.exerciciospringboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itexpertes.exerciciospringboot.model.Cliente;
import com.itexpertes.exerciciospringboot.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
		
		Cliente cli = clienteService.createCliente(cliente);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodosClientes() {
		
		List<Cliente> clientes = clienteService.getAllClientes();
		
		return ResponseEntity.ok().body(clientes);
	}
	

}
