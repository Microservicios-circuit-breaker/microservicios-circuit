package com.servicios.libros.dto;

import com.servicios.libros.utilities.LibroUtility;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public class CreateLibroDTO {
	

	@Size( max = 30, min = 3, message = LibroUtility.TITULO_SIZE )
	@NotBlank( message = LibroUtility.TITULO_NOT_EMPTY )
	@NotNull( message = LibroUtility.TITULO_NOT_NULL )
	private String titulo;
	
	@Size( max = 30, min = 3, message = LibroUtility.AUTOR_SIZE )
	@NotBlank( message = LibroUtility.AUTOR_NOT_EMPTY )
	@NotNull( message = LibroUtility.AUTOR_NOT_NULL )
	private String autor;
	
	private Long id_propietario;
	

	public CreateLibroDTO() {}
	
	public CreateLibroDTO( String titulo, String autor, Long id_propietario) {
		this.id_propietario = id_propietario;
		this.autor = autor;
		this.titulo = titulo;
	}
	
	public Long getId_propietario() {
		return id_propietario;
	}

	public void setId_propietario(Long id_propietario) {
		this.id_propietario = id_propietario;
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