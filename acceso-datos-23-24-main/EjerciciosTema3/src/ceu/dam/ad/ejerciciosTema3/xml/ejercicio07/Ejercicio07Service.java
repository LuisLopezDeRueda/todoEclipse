package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Pelicula;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Persona;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio07Service {

	public List<Pelicula> importarXML(String fichero) throws XMLImportException {
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.parse(new File(fichero));

			Element peliculasTag = xml.getDocumentElement();
			NodeList peliculaTagList = peliculasTag.getElementsByTagName("pelicula");
			for (int i = 0; i < peliculaTagList.getLength(); i++) {
				Element peliculaTag = (Element) peliculaTagList.item(i);
				Pelicula pelicula = new Pelicula();
				pelicula.setActores(new ArrayList<>());
				peliculas.add(pelicula);

//				NodeList tituloTagList = peliculaTag.getElementsByTagName("titulo");
//				Element tituloTag = (Element) tituloTagList.item(0);

				Element tituloTag = (Element) peliculaTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();
				pelicula.setTitulo(titulo);
				Element duracionTag = (Element) peliculaTag.getElementsByTagName("duracion").item(0);
				String duracion = duracionTag.getTextContent();
				pelicula.setDuracion(Integer.parseInt(duracion));
				Element añoTag = (Element) peliculaTag.getElementsByTagName("año").item(0);
				String año = añoTag.getTextContent();
				pelicula.setAño(Integer.parseInt(año));

				Element artistasTag = (Element) peliculaTag.getElementsByTagName("artistas").item(0);
				NodeList artistaTagList = artistasTag.getElementsByTagName("artista");
				for (int j = 0; j < artistaTagList.getLength(); j++) {
					Element artistaTag = (Element) artistaTagList.item(j);
					Persona persona = new Persona();
					String tipo = artistaTag.getAttribute("tipo");
					if (tipo.equals(Persona.DIRECCION)) {
						pelicula.setDireccion(persona);
					} else if (tipo.equals(Persona.PRODUCCION)) {
						pelicula.setProduccion(persona);
					} else {
						pelicula.getActores().add(persona);
					}

					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					String nombre = nombreTag.getTextContent();
					persona.setNombre(nombre);

					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					String nacionalidad = nacionalidadTag.getTextContent();
					persona.setNacionalidad(nacionalidad);

				}
			}
		} catch (FileNotFoundException e) {
			throw new XMLImportException("El fichero indicado no existe o no se puede leer", e);
		} catch (Exception e) {
			throw new XMLImportException("Error leyendo XML de películas", e);
		}
		return peliculas;

	}

}
