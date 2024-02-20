package ejemplo.xml.sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ejemplo.modelo.Curso;
import ejemplo.xml.CursosXMLException;

public class XMLCursosSaxServices {

	public List<Curso> leerCursos(String filePath) throws CursosXMLException{
		try {
			// 1. Nos creamos el SAXParser usando un SaxParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			// 2. Nos creamos una instancia de nuestro Handler
			XMLCursosHandler handler = new XMLCursosHandler();
			
			// 3. Nos creamos un file a partir de la ruta+nombre de fichero que recibimos
			File file = new File(filePath);
			
			// 4. Ejecutamos el parser para que lea el fichero pasándole el file y nuestro handler
			parser.parse(file, handler);
			
			// 5. Devolvemos la lista de cursos que se ha ido registrando en nuestro handler
			return handler.getCursos();
			
		}
		catch(Exception e) {
			System.err.println("Error leyendo XML: " + e.getMessage());
			throw new CursosXMLException("Error leyendo XML", e);
		}
		
	}

}
