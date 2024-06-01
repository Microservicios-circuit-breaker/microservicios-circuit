package com.servicios.CommonLibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "libro")
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column( name = "titulo" )
	private String titulo;
	
	@Column( name = "autor" )
	private String autor;
	
}