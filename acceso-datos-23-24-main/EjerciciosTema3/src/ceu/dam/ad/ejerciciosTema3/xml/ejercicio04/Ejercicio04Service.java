package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04;

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

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio04Service {

	public void exportXML(List<Libro> libros, String pathFile) throws XMLExportException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Creo un document que será el xml
			Document xml = builder.newDocument();

			// Creo el nodo raíz y lo añado al documento
			Element root = xml.createElement("libros");
			xml.appendChild(root);

			for (Libro libro : libros) {
				Element libroTag = xml.createElement("libro");
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				root.appendChild(libroTag);

				Element tituloTag = xml.createElement("titulo");
				tituloTag.setTextContent(libro.getTitulo());
				libroTag.appendChild(tituloTag);

				Element autoresTag = xml.createElement("autores");
				libroTag.appendChild(autoresTag);

				for (String autor : libro.getAutores()) {
					Element autorTag = xml.createElement("autor");
					autorTag.setTextContent(autor);
					autoresTag.appendChild(autorTag);
				}

				Element edicionesTag = xml.createElement("ediciones");
				libroTag.appendChild(edicionesTag);

				for (Edicion edicion : libro.getEdiciones()) {
					Element edicionTag = xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);

					Element añoTag = xml.createElement("año");
					añoTag.setTextContent(edicion.getAño().toString());
					edicionTag.appendChild(añoTag);

					Element editorialTag = xml.createElement("editorial");
					editorialTag.setTextContent(edicion.getEditorial());
					edicionTag.appendChild(editorialTag);
				}

			}

			// Cuando termino el XML, lo quiero guardar en un fichero
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(new File(pathFile));
			transformer.transform(source, result);
		} catch (Exception e) {
			throw new XMLExportException("Error exportando XML", e);
		}
	}
}
