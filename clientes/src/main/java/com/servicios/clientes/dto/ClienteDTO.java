package com.servicios.clientes.dto;
import lombok.Builder;

import com.servicios.clientes.utilities.ClienteUtilities;

import jakarta.validation.constraints.*;

@Builder
public class ClienteDTO {
	

	
	@Size( max = 30, min = 3, message = ClienteUtilities.NOMBRE_CARACTERES )
	@NotBlank( message = ClienteUtilities.NOMBRE_NO_VACIO )
	@NotNull( message =  ClienteUtilities.NOMBRE_NO_NULL )
	private String nombre;
	
	@NotBlank( message 	=  ClienteUtilities.EMAIL_NO_VACIO )
	@NotNull( message 	=  ClienteUtilities.EMAIL_NO_NULL  )
	@Pattern( regexp = ClienteUtilities.EMAIL_PATTERN, message = ClienteUtilities.EMAIL_NO_VALIDO )
	private String email;
	
	@NotBlank( message 	=  ClienteUtilities.CEDULA_NO_VACIO )
	@NotNull( message 	=  ClienteUtilities.CEDULA_NO_NULL  )
	private String cedula;
	
	public ClienteDTO() {}
	
	public ClienteDTO(String nombre, String email, String cedula) {
		this.nombre = nombre;
		this.email = email;
		this.cedula = cedula;
	}
	
	
	@Override
	public String toString() {
		return "ClienteDTO [nombre=" + nombre + ", email=" + email + ", cedula=" + cedula + "]";
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
