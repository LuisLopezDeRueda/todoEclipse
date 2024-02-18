package Ejercicio4.Service;

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

import Ejercicio4.Modelo.Edicion;
import Ejercicio4.Modelo.Libro;

public class Service {

	public void crearXml(List<Libro> lista, String ruta) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element root = xml.createElement("libros");
			xml.appendChild(root);
			for (Libro libro : lista) {
				Element librosTag = xml.createElement("libro");
				root.appendChild(librosTag);
				librosTag.setAttribute("isbn", libro.getIsbn().toString());
				Element tituloTag = xml.createElement("titulo");
				tituloTag.setTextContent(libro.getTitulo());
				librosTag.appendChild(tituloTag);
				Element autoresTag = xml.createElement("autores");
				librosTag.appendChild(autoresTag);
				List<String> listaAutores = libro.getAutores();
				for (String autor : listaAutores) {
					Element autorTag = xml.createElement("autor");
					autorTag.setTextContent(autor);
					autoresTag.appendChild(autorTag);
				}
				Element edicionesTag = xml.createElement("ediciones");
				librosTag.appendChild(edicionesTag);

				List<Edicion> listaEdiciones = libro.getEdiciones();
				for (Edicion edicion : listaEdiciones) {
					Element edicionTag = xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);
					Element añoTag = xml.createElement("año");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getAño().toString());
					Element editorialTag = xml.createElement("editorial");
					edicionTag.appendChild(editorialTag);
					editorialTag.setTextContent(edicion.getEditorial());
				}

			}
			TransformerFactory tranformerFactory = TransformerFactory.newInstance();

			Transformer transformer = tranformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(new File(ruta));

			transformer.transform(source, result);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
