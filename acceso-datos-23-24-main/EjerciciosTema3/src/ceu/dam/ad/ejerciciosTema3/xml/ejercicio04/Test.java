package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Test {

	public static void main(String[] args) {
		Ejercicio04Service service = new Ejercicio04Service();
		try {
			service.exportXML(Libro.createRandomList(10), "c:/temporal/librosTest.xml");
		} catch (XMLExportException e) {
			e.printStackTrace();
		}
	}

}
