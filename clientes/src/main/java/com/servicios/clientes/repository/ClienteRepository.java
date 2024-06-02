package com.servicios.clientes.repository;

import org.springframework.stereotype.Repository;

import com.servicios.CommonLibrary.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	boolean existsByEmail( String email );
	boolean existsByCedula( String cedula );
	boolean existsById( Long id );
}
