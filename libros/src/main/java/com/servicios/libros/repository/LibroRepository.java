package com.servicios.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.CommonLibrary.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
	boolean existsById( Long id );
	boolean existsByTitulo( String titulo );
	boolean existsByAutor( String autor );
}