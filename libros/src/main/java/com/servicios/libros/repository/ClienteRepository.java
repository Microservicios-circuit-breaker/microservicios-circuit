package com.servicios.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.CommonLibrary.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	boolean existsById( Long id );
	boolean existsByCorreo( String correo );
	boolean existsByCedula( String cedula );
}
