package com.servicios.clientes.dto;
import lombok.Builder;

import jakarta.validation.constraints.*;

@Builder
public class ClienteDTO {
	
	@Size()
	private String nombre;
	private String email;
	private String cedula;
	
	public ClienteDTO() {}
	
	public ClienteDTO(String nombre, String email, String cedula) {
		this.nombre = nombre;
		this.email = email;
		this.cedula = cedula;
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
