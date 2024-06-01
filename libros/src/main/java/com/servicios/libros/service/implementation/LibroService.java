package com.servicios.libros.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.libros.dto.LibroDTO;
import com.servicios.libros.dto.UpdateLibroDTO;
import com.servicios.libros.exception.LibroException;
import com.servicios.libros.mapper.LibroMapper;
import com.servicios.libros.repository.ClienteRepository;
import com.servicios.libros.repository.LibroRepository;
import com.servicios.libros.service.ILibroService;
import com.servicios.libros.utilities.LibroUtility;


@Service
public class LibroService implements ILibroService{
	
	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<LibroDTO> getAll() {
		return LibroMapper.listModelToDto(libroRepository.findAll());
	}

	@Override
	public LibroDTO getLibroById(Long id) throws LibroException {
		
		if (!libroRepository.existsById(id)) throw new LibroException(LibroUtility.LIBRO_NOT_FOUND);
		return LibroMapper.modelToDto(libroRepository.getReferenceById(id));
		
	}

	@Override
	public LibroDTO createLibro(LibroDTO libroDTO) throws LibroException {
		
		if( !clienteRepository.existsById( libroDTO.getClienteDTO().getId())) throw new LibroException(LibroUtility.CLIENTE_EXIST);
		if( libroRepository.existsByTitulo( libroDTO.getTitulo())) throw new LibroException(LibroUtility.TITULO_EXIST);
		
		return LibroMapper.modelToDto( libroRepository.save( LibroMapper.dtoToModel(libroDTO) ));
	}

	@Override
	public LibroDTO updateLibro(UpdateLibroDTO updateLibroDTO) throws LibroException {
		
		if (!libroRepository.existsById(updateLibroDTO.getId())) throw new LibroException(LibroUtility.LIBRO_NOT_FOUND);
		return LibroMapper.modelToDto(libroRepository.save(LibroMapper.updDtoToModel(updateLibroDTO)));
		
	}

	@Override
	public String deleteLibro(Long id) throws LibroException {
		
		if (!libroRepository.existsById(id)) throw new LibroException(String.format(LibroUtility.LIBRO_NOT_FOUND_ID, id));

		libroRepository.delete(libroRepository.findById(id).get());

        return String.format(LibroUtility.LIBRO_DELETED, id);
        
	}

}
