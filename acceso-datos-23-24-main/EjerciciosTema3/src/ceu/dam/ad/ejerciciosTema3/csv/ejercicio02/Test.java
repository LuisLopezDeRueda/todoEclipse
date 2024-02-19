package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import ceu.dam.ad.ejerciciosTema3.csv.ejercicio01.FicheroException;

public class Test {


	public static void main(String[] args) {
		ServicioCiudadesCsv service = new ServicioCiudadesCsv();
		try {
			service.importarCiudadesCsv("c:/temporal/ciudades.csv");
		} catch (FicheroException e) {
			e.printStackTrace();
		}
	}

}
