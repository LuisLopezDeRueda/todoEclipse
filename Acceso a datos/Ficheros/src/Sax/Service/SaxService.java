package Sax.Service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Sax.XmlHandler;
import Sax.Modelo.Curso;
import Service.FicheroException;

public class SaxService {
	public static void main(String[] args) {
		try {
			List<Curso>  lista = leerCurso("C:\\Users\\llopezderueda0480\\Pruebas\\cursos.xml");
			
			for (Curso curso : lista) {
				System.out.println(curso);
			}
			
		} catch (FicheroException e) {

			e.printStackTrace();
		}
	}

	public static List<Curso> leerCurso(String filePath) throws FicheroException {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			// 1 Nos creamos el SAXParser usando un SaxParserFactory
			SAXParser parse = factory.newSAXParser();
			// 2 Nos creamos una instancia de nustro Handler
			XmlHandler handler = new XmlHandler();
			// 3 Nos creamos un file a partir de la ruta+nombre de fichero
			File file = new File(filePath);
			parse.parse(file, handler);
			return handler.getListaCursos();
		} catch (Exception e) {

			System.out.println("Error leyendo el XML" + e);
			throw new FicheroException(e);
		}
	}

}
