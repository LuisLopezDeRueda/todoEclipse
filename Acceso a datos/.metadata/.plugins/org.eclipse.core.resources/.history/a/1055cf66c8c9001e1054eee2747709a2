package Ej1Sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Ej1Sax.Modelo.Edicion;
import Ej1Sax.Modelo.Libro;

public class LibroHandler extends DefaultHandler {
	private Boolean openTag;
	private List<Libro> listaLibros;
	private Libro libro;
	private Edicion edicion;
	private String texto;

	public LibroHandler() {
		openTag = false;
		listaLibros = new ArrayList<Libro>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		texto = "";
		openTag = true;
		if (qName.equals("libro")) {
			libro = new Libro();
			listaLibros.add(libro);
			libro.setIsbn(Integer.parseInt(attributes.getValue("isbn")));
		} else if (qName.equals("edicion")) {
			edicion = new Edicion();
			libro.getEdiciones().add(edicion);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("titulo")) {
			libro.setTitulo(texto);
		} else if (qName.equals("autor")) {
			libro.getAutores().add(texto);
		} else if (qName.equals("año")) {
			edicion.setAño(Integer.parseInt(texto));
		} else if (qName.equals("editorial")) {
			edicion.setEditorial(texto);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Libro> getListaLibros() {
		return listaLibros;
	}

}
