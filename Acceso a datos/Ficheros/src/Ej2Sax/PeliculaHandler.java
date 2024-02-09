package Ej2Sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Ej2Sax.Modelo.Pelicula;
import Ej2Sax.Modelo.Persona;

public class PeliculaHandler extends DefaultHandler {
	private Boolean openTag;
	private List<Pelicula> listaPeliculas;
	private Pelicula pelicula;
	private Persona persona;
	private String texto;

	public PeliculaHandler() {
		persona = new Persona();
		openTag = false;
		listaPeliculas = new ArrayList<Pelicula>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		texto = "";
		openTag = true;
		if (qName.equals("pelicula")) {
			pelicula = new Pelicula();
			listaPeliculas.add(pelicula);

		} else if (qName.equals("artista")) {
			persona = new Persona();
			if (attributes.getValue("tipo").equals(Persona.DIRECCION)) {
				pelicula.setDireccion(persona);
			} else if (attributes.getValue("tipo").equals(Persona.PRODUCCION)) {
				pelicula.setProduccion(persona);
			} else {
				pelicula.getActores().add(persona);
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("titulo")) {
			pelicula.setTitulo(texto);
		} else if (qName.equals("duración")) {
			pelicula.setDuracion(Integer.parseInt(texto));
		} else if (qName.equals("año")) {
			pelicula.setAño(Integer.parseInt(texto));
		} else if (qName.equals("nombre")) {
			persona.setNombre(texto);
		} else if (qName.equals("nacionalidad")) {
			persona.setNacionalidad(texto);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Pelicula> getlistaPeliculas() {
		return listaPeliculas;
	}

}
