package Ej2Sax.Service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Ej2Sax.PeliculaHandler;
import Ej2Sax.Modelo.Pelicula;
import Service.FicheroException;

public class PeliculaServiceSax {
	public static void main(String[] args) {
		try {
			List<Pelicula> listaPeliculas = leerlibro("C:\\Users\\llopezderueda0480\\Pruebas\\peliculas.xml");
			for (Pelicula peliculas : listaPeliculas) {
				System.out.println(peliculas);
			}
		} catch (FicheroException e) {

			e.printStackTrace();
		}
	}

	public static List<Pelicula> leerlibro(String filePath) throws FicheroException {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			// 1 Nos creamos el SAXParser usando un SaxParserFactory
			SAXParser parse = factory.newSAXParser();
			// 2 Nos creamos una instancia de nustro Handler
			PeliculaHandler handler = new PeliculaHandler();
			// 3 Nos creamos un file a partir de la ruta+nombre de fichero
			File file = new File(filePath);
			parse.parse(file, handler);
			return handler.getlistaPeliculas();
		} catch (Exception e) {

			System.out.println("Error leyendo el XML" + e);
			throw new FicheroException(e);
		}
	}
}
