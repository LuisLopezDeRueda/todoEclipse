package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.modelo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Categoria {

	@JacksonXmlText
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}
	
	
	
}
