package com.servicios.clientes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.servicios.CommonLibrary.models.Cliente;
import com.servicios.clientes.dto.ClienteDTO;
import com.servicios.clientes.dto.ClienteUpdDTO;

public class ClienteMapper {
	
	public static ClienteDTO modelToDto( Cliente cliente ) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setCedula(cliente.getCedula());
		
		return clienteDTO;
	}
	
	public static ClienteDTO updDtoToDto( ClienteUpdDTO clienteUpdDto ) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombre(clienteUpdDto.getNombre());
		clienteDTO.setEmail(clienteUpdDto.getEmail());
		clienteDTO.setCedula(clienteUpdDto.getCedula());
		
		return clienteDTO;
	}
	
	public static List<ClienteDTO> listModelToDto( List<Cliente> clientes){
		return clientes.stream().map( ClienteMapper::modelToDto).collect( Collectors.toList() );
	}
	
	public static Cliente dtoToModel( ClienteDTO clienteDTO ) {
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setCedula(clienteDTO.getCedula());
		
		return cliente;
	}
	
	public static List<Cliente> listDtoToModel( List<ClienteDTO> clientesDTO ){
		return clientesDTO.stream().map( ClienteMapper::dtoToModel).collect( Collectors.toList());
	}
}
