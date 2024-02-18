package Ficheros;

import lombok.Data;

public @Data class Asignatura {
	private String ciclo;
	private String nombre;
	private Integer id;

	public String toCSV() {
		return id + ";" + nombre + ";" + ciclo+"\n";
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
