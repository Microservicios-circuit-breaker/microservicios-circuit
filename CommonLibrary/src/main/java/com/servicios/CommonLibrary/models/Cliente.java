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
	
	public Cliente(){}
	
	public Cliente(Long id, String nombre, String email, String cedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.cedula = cedula;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
