package Ficheros;

import lombok.Data;

public @Data class Asignatura {
	private String ciclo;
	private String nombre;
	private Integer id;

	public String toCSV() {
		return id + ";" + nombre + ";" + ciclo+"\n";
	}
}
