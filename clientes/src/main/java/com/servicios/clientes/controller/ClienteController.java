package com.servicios.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.clientes.dto.ClienteDTO;
import com.servicios.clientes.dto.ClienteUpdDTO;
import com.servicios.clientes.exception.ClienteException;
import com.servicios.clientes.services.IClienteService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/cliente")
@Slf4j
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/obtenerTodos")
	public ResponseEntity<List<ClienteDTO>> obtenerTodos() throws ClienteException{
		return new ResponseEntity<List<ClienteDTO>>( clienteService.listarClientes(), HttpStatus.OK );
	}
	
	@GetMapping("/obtenerPorId/{id}")
	public ResponseEntity<ClienteDTO> obtenerPorId(@PathVariable Long id ) throws ClienteException{
		return new ResponseEntity<ClienteDTO>( clienteService.listarClienteId(id), HttpStatus.OK );
	}
	
	@PostMapping("/crear")
	public ResponseEntity<ClienteDTO> crear( @RequestBody @Valid ClienteDTO clienteDTO ) throws ClienteException{
		return new ResponseEntity<ClienteDTO>( clienteService.crearCliente(clienteDTO), HttpStatus.CREATED );
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<ClienteDTO> actualizar( @Valid @RequestBody ClienteUpdDTO clienteUpdDto ) throws ClienteException{
		return new ResponseEntity<ClienteDTO>( clienteService.actaulizarCliente(clienteUpdDto), HttpStatus.OK );
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar( @PathVariable Long id ) throws ClienteException{
		return new ResponseEntity<String>( clienteService.eliminarCliente(id), HttpStatus.OK );
	}
}
