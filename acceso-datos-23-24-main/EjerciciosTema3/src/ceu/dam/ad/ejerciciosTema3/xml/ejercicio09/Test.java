package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Pelicula;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio09Service service = new Ejercicio09Service();
		try {
			List<Pelicula> peliculas =  service.importXML("c:/temporal/peliculasTest.xml");
			System.out.println(peliculas);
		} catch (XMLImportException e) {
			e.printStackTrace();
		}
	}

}
