package Sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Sax.Modelo.Alumno;
import Sax.Modelo.Curso;

public class XmlHandler extends DefaultHandler {

	private Boolean openTag;
	private String texto;
	private List<Curso> listaCursos;
	private Curso curso;
	private Alumno alumno;

	public XmlHandler() {
		setOpenTag(false);
		texto = "";
		listaCursos = new ArrayList<Curso>();
	}
	//Este metodo es para inicializar los objetos
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		super.startElement(uri, localName, qName, attributes);
		setOpenTag(true);
		texto = "";
		if (qName.equals("curso")) {
			curso = new Curso();
			listaCursos.add(curso);

		} else if (qName.equals("alumno")) {
			alumno = new Alumno();
			curso.getAlumnos().add(alumno);
			alumno.setDni(attributes.getValue("dni"));
		}
	}
	//Este metodo es para darle informacion a los objetos
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
		setOpenTag(false);
		if (qName.equals("nombre")) {
			curso.setNombre(texto);
		} else if (qName.equals("horas")) {
			curso.setHora(Integer.parseInt(texto));
		} else if (qName.equals("alumno")) {
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

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public Boolean getOpenTag() {
		return openTag;
	}

	public void setOpenTag(Boolean openTag) {
		this.openTag = openTag;
	}

}
