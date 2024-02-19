package ejemplo.xml.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejemplo.modelo.Curso;
import ejemplo.xml.CursosXMLException;

public class XMLJacksonService {

	public void escribirXMLCurso(String pathName, List<Curso> lista) throws CursosXMLException {
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathName);
			Cursos cursos = new Cursos();
			cursos.setCursos(lista);
			mapper.writeValue(file, cursos);
		} catch (IOException e) {
			System.err.println("Error al escribir XML de curso" + e.getMessage());
			throw new CursosXMLException("Error escribiendo XML", e);
		}
		
		
		
	}
}
