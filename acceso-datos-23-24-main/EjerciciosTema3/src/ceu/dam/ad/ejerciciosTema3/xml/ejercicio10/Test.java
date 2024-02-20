package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio10Service service = new Ejercicio10Service();
		try {
//			service.escribirXMLLibros("c:/temporal/librosJackson.xml", Libro.createRandomList(10));
			
//			List<Libro> libros = service.leerXMLLibros("c:/temporal/librosJackson.xml");
//			System.out.println(libros);
			
//			service.escribirJsonLibros("c:/temporal/librosJackson.json", Libro.createRandomList(10));
			
			List<Libro> libros = service.leerJsonLibros("c:/temporal/librosJackson.json");
			System.out.println(libros);
			
		} catch (XMLExportException e) {
			e.printStackTrace();
		}
	}

}
