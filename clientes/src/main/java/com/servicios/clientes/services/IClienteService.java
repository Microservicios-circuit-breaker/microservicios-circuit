package com.servicios.clientes.services;

import com.servicios.clientes.dto.ClienteDTO;
import com.servicios.clientes.dto.ClienteUpdDTO;
import com.servicios.clientes.exception.ClienteException;

import java.util.List;

public interface IClienteService {
	
	ClienteDTO crearCliente( ClienteDTO clienteDTO ) throws ClienteException;
	List<ClienteDTO> listarClientes() throws ClienteException;
	ClienteDTO listarClienteId( Long id ) throws ClienteException;
	ClienteDTO actaulizarCliente( ClienteUpdDTO cliente ) throws ClienteException;
	String eliminarCliente( Long id ) throws ClienteException;
}
