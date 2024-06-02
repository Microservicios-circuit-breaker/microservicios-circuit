package com.servicios.libros.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
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

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
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