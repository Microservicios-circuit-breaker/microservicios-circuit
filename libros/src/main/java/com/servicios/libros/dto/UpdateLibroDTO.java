package com.servicios.libros.dto;

import com.servicios.libros.utilities.LibroUtility;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateLibroDTO {
	
	@NotBlank( message = LibroUtility.ID_NOT_NULL )
	@NotNull( message = LibroUtility.ID_NOT_EMPTY )
	private Long id;
	
	@Size( max = 30, min = 3, message = LibroUtility.TITULO_SIZE )
	@NotBlank( message = LibroUtility.TITULO_NOT_EMPTY )
	@NotNull( message = LibroUtility.TITULO_NOT_NULL )
	private String titulo;
	
	@Size( max = 30, min = 3, message = LibroUtility.AUTOR_SIZE )
	@NotBlank( message = LibroUtility.AUTOR_NOT_EMPTY )
	@NotNull( message = LibroUtility.AUTOR_NOT_NULL )
	private String autor;
	
	private Long id_propietario;
	

	public UpdateLibroDTO() {}
	
	public UpdateLibroDTO(Long id, String titulo, String autor, Long id_propietario ) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.id_propietario = id_propietario;
	}
	
	
	public Long getId_propietario() {
		return id_propietario;
	}

	public void setId_propietario(Long id_propietario) {
		this.id_propietario = id_propietario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
