package com.servicios.clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.clientes.dto.ClienteDTO;
import com.servicios.clientes.dto.ClienteUpdDTO;
import com.servicios.clientes.exception.ClienteException;
import com.servicios.clientes.mapper.ClienteMapper;
import com.servicios.clientes.repository.ClienteRepository;
import com.servicios.clientes.utilities.ClienteUtilities;


@Service
public class ClienteService implements IClienteService{

	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws ClienteException {
		
		if( clienteRepository.existsByEmail( clienteDTO.getEmail() )) throw new ClienteException(ClienteUtilities.EMAIL_EXISTE);
		if( clienteRepository.existsByCedula( clienteDTO.getCedula())) throw new ClienteException(ClienteUtilities.CEDULA_EXISTE);
		return ClienteMapper.modelToDto( clienteRepository.save( ClienteMapper.dtoToModel(clienteDTO)));
	}

	@Override
	public List<ClienteDTO> listarClientes() throws ClienteException {
		return ClienteMapper.listModelToDto( clienteRepository.findAll() );
	}

	@Override
	public ClienteDTO listarClienteId(Long id) throws ClienteException {
		if( !clienteRepository.existsById( id ) ) throw new ClienteException( ClienteUtilities.ID_NO_EXISTE );
		return ClienteMapper.modelToDto( clienteRepository.getReferenceById( id ) );
	}

	@Override
	public ClienteDTO actaulizarCliente( ClienteUpdDTO clienteUpdDTO) throws ClienteException {
		
		if( !clienteRepository.existsById( clienteUpdDTO.getId())) throw new ClienteException(ClienteUtilities.ID_NO_EXISTE );		
		return ClienteMapper.modelToDto( clienteRepository.save( ClienteMapper.updDtoToModel( clienteUpdDTO ) ) );
	}

	@Override
	public String eliminarCliente(Long id) throws ClienteException {
		
		if( !clienteRepository.existsById( id )) throw new ClienteException( ClienteUtilities.ID_NO_EXISTE );
		return String.format( ClienteUtilities.ELIMINADO, id);
	}
}
