package Ejercicio2;

import java.util.List;

import EJ5.Modelo.Ciudad;
import Ejercicio2.csv.Csv;
import Service.FicheroException;

public class App {
	public static void main(String[] args) {
		Csv service = new Csv();
		List<Ciudad> listaCiudad = null;
		 try {
			listaCiudad = service.escribirCiudad("C:\\Users\\llopezderueda0480/ciudades.csv");
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
		for (Ciudad ciudad : listaCiudad) {
			System.out.println(ciudad);
		}
	}
}
