package Ejercicio5.App;

import java.util.ArrayList;
import java.util.List;

import Ejercicio4.Modelo.Libro;
import Ejercicio5.Service.LibroException;
import Ejercicio5.Service.Service;

public class App {
	public static void main(String[] args) {
		Service service = new Service();

		List<Libro> listaLibros = new ArrayList<Libro>();
		try {
			listaLibros = service.leerXML("C:\\Users\\llopezderueda0480\\Pruebas/libros.xml");
		} catch (LibroException e) {

			e.printStackTrace();
		}
		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}
	}
}
