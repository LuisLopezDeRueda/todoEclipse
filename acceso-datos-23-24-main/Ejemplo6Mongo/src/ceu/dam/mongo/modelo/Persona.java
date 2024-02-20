package ceu.dam.mongo.modelo;

import java.util.List;

public class Persona {

	private String dni;
	private String nombre;
	private Integer edad;
	private List<Direccion> direcciones;
	
	public Persona() {
	}
	
	public Persona(String dni, String nombre, Integer edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", direcciones=" + direcciones + "]";
	}
	
	
	
	
	
	
	
}
