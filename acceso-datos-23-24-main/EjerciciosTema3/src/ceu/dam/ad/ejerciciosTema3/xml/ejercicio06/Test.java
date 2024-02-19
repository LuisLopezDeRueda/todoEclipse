package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Pelicula;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio06Service service = new Ejercicio06Service();
		try {
			service.exportarXML(Pelicula.createRandomList(10), "c:/temporal/peliculasTest.xml");
		} catch (XMLExportException e) {
			e.printStackTrace();
		}
	}

}
