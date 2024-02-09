package Ejercicio5.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Ejercicio4.Modelo.Edicion;
import Ejercicio4.Modelo.Libro;

public class Service {
	public List<Libro> leerXML(String ruta) throws LibroException {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		List<Libro> listaLibros = new ArrayList<Libro>();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();
			NodeList listalibrosList = root.getElementsByTagName("libro");
			for (int i = 0; i < listalibrosList.getLength(); i++) {

				Element libroTag = (Element) listalibrosList.item(i);
				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				Libro libro = new Libro(Integer.parseInt(libroTag.getAttribute("isbn")), tituloTag.getTextContent());
				Element aurtoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
				NodeList autor = aurtoresTag.getElementsByTagName("autor");

				for (int x = 0; x < autor.getLength(); x++) {
					Element autorTag = (Element) autor.item(x);
					libro.getAutores().add(autorTag.getTextContent());

				}
				Element eidcionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList edcion = eidcionesTag.getElementsByTagName("edicion");
				for (int x = 0; x < edcion.getLength(); x++) {
					Edicion edicion = new Edicion();
					Element edicionTag = (Element) edcion.item(x);
					Element añoTag = (Element) edicionTag.getElementsByTagName("año").item(0);
					edicion.setAño(Integer.parseInt(añoTag.getTextContent()));
					Element editorial = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					edicion.setEditorial(editorial.getTextContent());
					libro.getEdiciones().add(edicion);

				}
				listaLibros.add(libro);
			}

		} catch (Exception e) {

			throw new LibroException(e);
		}
		return listaLibros;
	}
}
