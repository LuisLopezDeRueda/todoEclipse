package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Pelicula;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio09Service {

	public List<Pelicula> importXML(String pathFile) throws XMLImportException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			PeliculasXMLHandler handler = new PeliculasXMLHandler();

			File file = new File(pathFile);

			parser.parse(file, handler);

			return handler.getPeliculas();
		} catch (Exception e) {
			System.err.println("Error leyendo XML. " + e.getMessage());
			throw new XMLImportException("Error leyendo XML", e);
		}

	}
}
