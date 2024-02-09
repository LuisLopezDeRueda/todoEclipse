package Ejercicio7.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Ejercicio6.Modelo.Pelicula;
import Ejercicio6.Modelo.Persona;

public class Service {
	public List<Pelicula> leerXML(String ruta) throws PeliculasException {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();
			NodeList listaPeliculaTag = root.getElementsByTagName("pelicula");
			for (int i = 0; i < listaPeliculaTag.getLength(); i++) {
				Pelicula pelicula = new Pelicula();
				Element peliculaTag = (Element) listaPeliculaTag.item(i);
				Element tituloTag = (Element) peliculaTag.getElementsByTagName("titulo").item(0);
				pelicula.setTitulo(tituloTag.getTextContent());
				Element duracionTag = (Element) peliculaTag.getElementsByTagName("duración").item(0);
				pelicula.setDuracion(Integer.parseInt(duracionTag.getTextContent()));
				Element añoTag = (Element) peliculaTag.getElementsByTagName("año").item(0);
				pelicula.setAño(Integer.parseInt(añoTag.getTextContent()));

				Element artistasTag = (Element) peliculaTag.getElementsByTagName("artistas").item(0);
				NodeList listaArtistas = artistasTag.getElementsByTagName("artista");
				for (int x = 0; x < listaArtistas.getLength(); x++) {
					Persona persona = new Persona();
					Element artistaTag = (Element) listaArtistas.item(x);
					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					persona.setNombre(nombreTag.getTextContent());
					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					persona.setNacionalidad(nacionalidadTag.getTextContent());
					if (artistaTag.getAttribute("tipo").equals(Persona.DIRECCION)) {
						pelicula.setDireccion(persona);
					} else if (artistaTag.getAttribute("tipo").equals(Persona.PRODUCCION)) {
						pelicula.setProduccion(persona);
					} else
						pelicula.getActores().add(persona);
				}
				listaPelicula.add(pelicula);
			}
		} catch (Exception e) {

			throw new PeliculasException(e);
		}

		return listaPelicula;
	}
}
