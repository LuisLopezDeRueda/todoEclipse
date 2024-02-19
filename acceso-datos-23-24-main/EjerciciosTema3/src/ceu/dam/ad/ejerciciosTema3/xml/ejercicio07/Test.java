package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Pelicula;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio07Service service = new Ejercicio07Service();
		List<Pelicula> lista;
		try {
			lista = service.importarXML("c:/temporal/peliculasTest.xml");
			System.out.println(lista);
		} catch (XMLImportException e) {
			e.printStackTrace();
		}
	}
}
