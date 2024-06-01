package com.servicios.libros.service;

import java.util.List;

import com.servicios.libros.dto.LibroDTO;
import com.servicios.libros.dto.UpdateLibroDTO;
import com.servicios.libros.exception.LibroException;

public interface ILibroService {
	List<LibroDTO> getAll();
	LibroDTO getLibroById(Long id) throws LibroException;
	LibroDTO createLibro(LibroDTO libroDTO) throws LibroException;
	LibroDTO updateLibro(UpdateLibroDTO updateLibroDTO) throws LibroException;
	String deleteLibro(Long id) throws LibroException;
}