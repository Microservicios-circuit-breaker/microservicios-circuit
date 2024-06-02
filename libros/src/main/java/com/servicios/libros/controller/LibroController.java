package com.servicios.libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.libros.dto.CreateLibroDTO;
import com.servicios.libros.dto.LibroDTO;
import com.servicios.libros.dto.UpdateLibroDTO;
import com.servicios.libros.exception.LibroException;
import com.servicios.libros.service.ILibroService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/libro")
@Slf4j
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class LibroController {

    @Autowired
	private ILibroService iLibroService;

    @GetMapping( path = "/obtenerTodos" )
    public ResponseEntity<List<LibroDTO>> getAllLibros() throws LibroException {
        return new ResponseEntity<>(iLibroService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping( path = "/obtenerPorId/{id}" )
    public ResponseEntity<LibroDTO> getLibroById(@PathVariable Long id) throws LibroException {
    	return new ResponseEntity<>(iLibroService.getLibroById(id), HttpStatus.OK);
    }
    
    @PostMapping( path = "/crear" )
    public ResponseEntity<LibroDTO> createLibro(@Valid @RequestBody CreateLibroDTO createlibroDTO) throws LibroException {   
        return new ResponseEntity<>(iLibroService.createLibro(createlibroDTO), HttpStatus.CREATED);
    }
    
    @PutMapping( path = "/actualizar" )
    public ResponseEntity<LibroDTO> updateLibro(@Valid @RequestBody UpdateLibroDTO updateLibroDTO) throws LibroException {
        return new ResponseEntity<>(iLibroService.updateLibro(updateLibroDTO), HttpStatus.OK);
    }
	
    @DeleteMapping( path = "/eliminar/{id}" )
    public ResponseEntity<String> deleteLibro(@PathVariable Long id) throws LibroException {
    	return new ResponseEntity<>(iLibroService.deleteLibro(id), HttpStatus.OK);
    }
}
