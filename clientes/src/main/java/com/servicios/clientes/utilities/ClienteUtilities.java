package com.servicios.clientes.utilities;

public class ClienteUtilities {
	
	public static final String ID_NO_NULL 		= "El Id no debe ser nulo";
	public static final String ID_NO_VACIO 		= "El Id no debe estar vacio";
	public static final String ID_YA_EXISTE     = "El Id ya esta registrado";
	public static final String ID_NO_EXISTE		= "El Id de el cliente no existe";
	
	public static final String NOMBRE_NO_NULL 		= "El nombre de usuario no debe ser nulo";
	public static final String NOMBRE_NO_VACIO 		= "El nombre de usuario no debe estar vacio";
	public static final String NOMBRE_CARACTERES 	= "El nombre de usuario debe tener entre 3 y 30 caracteres";
	
	public static final String EMAIL_NO_NULL 		= "El email no debe ser nulo";
	public static final String EMAIL_NO_VACIO		= "El email no debe estar vacio";
	public static final String EMAIL_NO_VALIDO		= "El email debe ser valido";
	public static final String EMAIL_PATTERN 		= "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	public static final String EMAIL_EXISTE 		= "El correo ya existe";
	public static final String EMAIL_NO_EXISTE		= "El email no existe";
	
	
	public static final String CEDULA_NO_NULL 		= "El numero de cedula no debe ser nulo";
	public static final String CEDULA_NO_VACIO 		= "El numero de cedula no debe estar vacio";
	public static final String CEDULA_NO_VALIDO 	= "El numero de cedula no es valido";
	public static final String CEDULA_EXISTE 		= "El numero de cedula ya esta registrado";
	public static final String CEDULA_NO_EXISTE		= "El numero de cedula no esta registrado";
	
	public static final String ELIMINADO = "El Cliente con id %s fue eliminado con exito";
}
