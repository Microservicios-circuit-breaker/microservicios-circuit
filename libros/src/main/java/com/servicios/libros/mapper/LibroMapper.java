package com.servicios.libros.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.servicios.CommonLibrary.models.Cliente;
import com.servicios.CommonLibrary.models.Libro;
import com.servicios.libros.dto.ClienteDTO;
import com.servicios.libros.dto.CreateLibroDTO;
import com.servicios.libros.dto.LibroDTO;
import com.servicios.libros.dto.UpdateLibroDTO;

public class LibroMapper {
	
	public static LibroDTO modelToDto(Libro libro) {
		LibroDTO libroDTO = new LibroDTO();
		
		libroDTO.setTitulo(libro.getTitulo());
		libroDTO.setAutor(libro.getAutor());
		libroDTO.setClienteDTO(clientModelToDto(libro.getCliente()));
		
		return libroDTO;
	}
	
	
	public static Libro createLibroDtoToModel( CreateLibroDTO createLibroDTO ) {
		Libro libro = new Libro();
		libro.setTitulo( createLibroDTO.getTitulo() );
		libro.setAutor( createLibroDTO.getAutor());
		
		return libro;
	}
	
	public static List<LibroDTO> listModelToDto( List<Libro> libros){
		return libros.stream().map( LibroMapper::modelToDto ).collect( Collectors.toList());
	}
	
	public static Libro dtoToModel(LibroDTO libroDTO) {
		Libro libro = new Libro();
		
		libro.setTitulo(libro.getTitulo());
		libro.setAutor(libro.getAutor());
		
		return libro;
	}
	
	public static List<Libro> listDtoToModel( List<LibroDTO> librosDTO){
		return librosDTO.stream().map( LibroMapper::dtoToModel ).collect( Collectors.toList());
	}
	
	
	public static Cliente clientDtoToModel( ClienteDTO clienteDto ) {
        Cliente cliente = new Cliente();
        	
        cliente.setId( clienteDto.getId() );
        cliente.setNombre(clienteDto.getNombre());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setCedula(clienteDto.getCedula());
        
        return cliente;
    }
	
	public static ClienteDTO clientModelToDto( Cliente cliente ) {
        ClienteDTO clienteDTO = new ClienteDTO();
        
        clienteDTO.setId( cliente.getId() );
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setCedula(cliente.getCedula());

        return clienteDTO;
    }
	
	public static Libro updDtoToModel( UpdateLibroDTO updateLibroDTO) {
		Libro libro = new Libro();
		
		libro.setId( updateLibroDTO.getId() );
		libro.setTitulo(updateLibroDTO.getTitulo());
		libro.setAutor(updateLibroDTO.getAutor());
		
		return libro;
	}
	
}
