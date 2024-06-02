package com.servicios.CommonLibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column( name = "titulo" )
	private String titulo;
	
	@Column( name = "autor" )
	private String autor;
	
	@ManyToOne
	@JoinColumn( name = "id_propietario")
	private Cliente cliente;
}