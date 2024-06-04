package com.servicios.libros.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.CommonLibrary.models.Libro;
import com.servicios.libros.dto.CreateLibroDTO;
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
	public LibroDTO createLibro(CreateLibroDTO createlibroDTO) throws LibroException {
		
		if( !clienteRepository.existsById( createlibroDTO.getId_propietario() )) throw new LibroException(LibroUtility.CLIENTE_EXIST);
		if( libroRepository.existsByTitulo( createlibroDTO.getTitulo())) throw new LibroException(LibroUtility.TITULO_NO_EXIST);
		
		
		Libro libro = LibroMapper.createLibroDtoToModel(createlibroDTO);
		
		libro.setCliente( clienteRepository.getReferenceById( createlibroDTO.getId_propietario()));
		return LibroMapper.modelToDto( libroRepository.save( libro ));
	}

	@Override
	public LibroDTO updateLibro(UpdateLibroDTO updateLibroDTO) throws LibroException {
		
		if (!libroRepository.existsById(updateLibroDTO.getId())) throw new LibroException(LibroUtility.LIBRO_NOT_FOUND);
		if( !clienteRepository.existsById( updateLibroDTO.getId_propietario() )) throw new LibroException(LibroUtility.CLIENTE_EXIST);
		
		Libro libro = LibroMapper.updDtoToModel( updateLibroDTO );
		libro.setCliente( clienteRepository.getReferenceById( updateLibroDTO.getId_propietario() ));
		
		return LibroMapper.modelToDto(libroRepository.save( libro ));
	}

	@Override
	public String deleteLibro(Long id) throws LibroException {
		
		if (!libroRepository.existsById(id)) throw new LibroException(String.format(LibroUtility.LIBRO_NOT_FOUND_ID, id));

		libroRepository.delete(libroRepository.findById(id).get());

        return String.format(LibroUtility.LIBRO_DELETED, id);
        
	}

}
