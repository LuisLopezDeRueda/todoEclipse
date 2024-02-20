package ejemplo.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejemplo.modelo.Alumno;
import ejemplo.modelo.Curso;

public class XMLCursosHandler extends DefaultHandler{

	private Boolean openTag;
	private String texto;
	
	private List<Curso> cursos;
	private Curso curso;
	private Alumno alumno;
	
	public XMLCursosHandler() {
		openTag = false;
		texto = "";
		cursos = new ArrayList<Curso>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";
		
		if (qName.equals("curso")) {
			curso = new Curso();
			cursos.add(curso);
		}
		else if (qName.equals("alumno")) {
			alumno = new Alumno();
			curso.getAlumnos().add(alumno);
			String dni = attributes.getValue("dni");
			alumno.setDni(dni);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("nombre")) {
			curso.setNombre(texto);
		}
		else if (qName.equals("horas")) {
			curso.setHora(Integer.parseInt(texto));
		}
		else if (qName.equals("alumno")) {
			alumno.setNombre(texto);
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	
	
	
}
