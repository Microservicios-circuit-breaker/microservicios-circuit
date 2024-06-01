package com.servicios.CommonLibrary.models;

import jakarta.persistence.*;

@Table( name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( name = "nombre")
	private String nombre;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "cedula")
	private String cedula;
}
