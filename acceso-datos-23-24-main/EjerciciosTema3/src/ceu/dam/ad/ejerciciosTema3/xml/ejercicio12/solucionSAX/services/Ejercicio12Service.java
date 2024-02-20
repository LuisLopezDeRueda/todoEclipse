package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionSAX.services;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;


public class Ejercicio12Service {

	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException{
		// Esto con SAX no se puede hacer. SAX lo usamos sólo para leer
		System.out.println(">>>>> NO SE PUEDE EXPORTAR CON SAX <<<<<<<<");
	}
	
	
	
	public Catalogo importXML(String pathFile) throws CatalogoXMLException{
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			CatalogoXMLHandler handler = new CatalogoXMLHandler();

			File file = new File(pathFile);

			parser.parse(file, handler);

			return handler.getCatalogo();
			
		} catch (Exception e) {
			throw new CatalogoXMLException("Error al importar catálogo", e);
		}
	}

	
	
}
