package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio08Service {

	public List<Libro> importXML(String pathFile) throws XMLImportException  {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			LibrosXMLHandler handler = new LibrosXMLHandler();
			
			File file = new File(pathFile);
			
			parser.parse(file, handler);
	
			return handler.getLibros();
		}
		catch(Exception e) {
			System.err.println("Error leyendo XML. " + e.getMessage());
			throw new XMLImportException("Error leyendo XML", e);
		}
	}
}
