package TerceraFormaXML.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
		escribirXML(listalibros, "C:\\Users\\llopezderueda0480\\Pruebas/libroPruba.xml");
		System.out.println(leerXML("C:\\Users\\llopezderueda0480\\Pruebas/libroPruba.xml"));
	}

	public static void escribirXML(List<Libro> libros, String path) {
		XmlMapper mapper = new XmlMapper();
		File file = new File(path);
		try {
			Libros libross = new Libros();
			libross.setPeliculas(libros);
			mapper.writeValue(file, libross);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public static  Libros leerXML(String path) {
		XmlMapper mapper = new XmlMapper();
		File file = new File(path);
		Libros libro  = new Libros();
		try {
			libro = mapper.readValue(file, Libros.class);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return libro;
	}

}
