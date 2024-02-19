package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio05Service service = new Ejercicio05Service();
		List<Libro> libros;
		try {
			libros = service.importXML("c:/temporal/librosTest.xml");
			System.out.println(libros);
		} catch (XMLImportException e) {
			e.printStackTrace();
		}
		
	}

}
