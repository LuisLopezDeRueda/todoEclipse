package Ejercicio6.Service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Ejercicio6.Modelo.Pelicula;
import Ejercicio6.Modelo.Persona;

public class Service {
	private Element artistasTag;

	public void crearXml(List<Pelicula> lista, String ruta) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.newDocument();
			Element root = xml.createElement("peliculas");
			xml.appendChild(root);
			for (Pelicula pelicula : lista) {
				Element peliculaTag = xml.createElement("pelicula");
				root.appendChild(peliculaTag);
				Element tituloTag = xml.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo());
				Element duracionTag = xml.createElement("duración");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());
				Element añoTag = xml.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());
				artistasTag = xml.createElement("artistas");
				peliculaTag.appendChild(artistasTag);
				crear(Persona.DIRECCION, pelicula.getDireccion().getNombre(), pelicula.getDireccion().getNacionalidad(),
						xml);
				crear(Persona.PRODUCCION, pelicula.getProduccion().getNombre(),
						pelicula.getProduccion().getNacionalidad(), xml);
				List<Persona> persona = pelicula.getActores();
				for (Persona person : persona) {
					crear(Persona.INTERPRETACION, person.getNombre(), person.getNacionalidad(), xml);
				}

			}
			TransformerFactory tranformerFactory = TransformerFactory.newInstance();

			Transformer transformer = tranformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(new File(ruta));

			transformer.transform(source, result);

		} catch (Exception e) {

		}
	}

	public void crear(String tipo, String nombre, String nacionalidad, Document xml) {
		Element artistaTag = xml.createElement("artista");
		artistasTag.appendChild(artistaTag);
		artistaTag.setAttribute("tipo", tipo);
		Element nombreTag2 = xml.createElement("nombre");
		artistaTag.appendChild(nombreTag2);
		nombreTag2.setTextContent(nombre);
		Element nacionalidadTag2 = xml.createElement("nacionalidad");
		artistaTag.appendChild(nacionalidadTag2);
		nacionalidadTag2.setTextContent(nacionalidad);
	};
}
