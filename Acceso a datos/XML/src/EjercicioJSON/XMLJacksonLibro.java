package EjercicioJSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.json.JsonMapper;

import TerceraFormaXML.Ejercicio1.Edicion;
import TerceraFormaXML.Ejercicio1.Libro;

public class XMLJacksonLibro {
	public static void main(String[] args) {
		List<Libro> listalibros = new ArrayList<Libro>();
		Libro libro = new Libro();
		libro.setIsbn(1234);
		libro.setTitulo("El mejor titulo");
		libro.getAutores().add("Autor1");
		libro.getAutores().add("Autor2");
		Edicion edicion = new Edicion();
		edicion.setAño(123);
		edicion.setEditorial("La mejor editorial");
		libro.getEdiciones().add(edicion);

		Libro libro2 = new Libro();
		libro2.setIsbn(1234);
		libro2.setTitulo("El mejor titulo");
		libro2.getAutores().add("Autor1");
		libro2.getAutores().add("Autor2");
		Edicion edicion1 = new Edicion();
		edicion1.setAño(123);
		edicion1.setEditorial("La mejor editorial");
		listalibros.add(libro2);
		listalibros.add(libro);
		libro2.getEdiciones().add(edicion1);
		libro2.getEdiciones().add(edicion);
		libro.getEdiciones().add(edicion1);
		escribirJSON(listalibros, "C:\\Users\\llopezderueda0480\\Pruebas/libroPruba.json");
		System.out.println(leerJSON("C:\\Users\\llopezderueda0480\\Pruebas/libroPruba.json"));
	}

	public static void escribirJSON(List<Libro> libros, String path) {
		JsonMapper mapper = new JsonMapper();
		File file = new File(path);
		try {
			mapper.writeValue(file, libros);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static List<Libro> leerJSON(String path) {
		JsonMapper mapper = new JsonMapper();
		File file = new File(path);
		try {
			return Arrays.asList(mapper.readValue(file, Libro[].class));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

}
