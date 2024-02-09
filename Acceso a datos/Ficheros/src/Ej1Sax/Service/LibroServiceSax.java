package Ej1Sax.Service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Ej1Sax.LibroHandler;
import Ej1Sax.Modelo.Libro;
import Service.FicheroException;

public class LibroServiceSax {
	public static void main(String[] args) {
		try {
			List<Libro> listaLibros = leerlibro("C:\\Users\\llopezderueda0480\\Pruebas\\libros.xml");
			for (Libro libro : listaLibros) {
				System.out.println(libro);
			}
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static List<Libro> leerlibro(String filePath) throws FicheroException {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			// 1 Nos creamos el SAXParser usando un SaxParserFactory
			SAXParser parse = factory.newSAXParser();
			// 2 Nos creamos una instancia de nustro Handler
			LibroHandler handler = new LibroHandler();
			// 3 Nos creamos un file a partir de la ruta+nombre de fichero
			File file = new File(filePath);
			parse.parse(file, handler);
			return handler.getListaLibros();
		} catch (Exception e) {

			System.out.println("Error leyendo el XML" + e);
			throw new FicheroException(e);
		}
	}
}
