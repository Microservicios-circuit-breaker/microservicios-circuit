package com.servicios.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "com.servicios.libros", "com.servicios.CommonLibrary.models" })
@EnableJpaRepositories({ "com.servicios.libros.repository", "com.servicios.CommonLibrary.models" })
@EntityScan({ "com.servicios.libros.entity", "com.servicios.CommonLibrary.models" })
@SpringBootApplication
public class LibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

}
