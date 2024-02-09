package Ejemplo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejemplo {
	public void leerXML(String ruta) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();
			NodeList listaCursosList = root.getElementsByTagName("curso");
			for (Integer i = 0; i < listaCursosList.getLength(); i++) {
				Element cursoTag = (Element) listaCursosList.item(i);
				Element nombreTag = (Element) cursoTag.getElementsByTagName("nombre").item(0);
				String nombre = nombreTag.getTextContent();
				Element horasTag = (Element) cursoTag.getElementsByTagName("horas").item(0);
				String horas = horasTag.getTextContent();
				Element alumnosTag = (Element) cursoTag.getElementsByTagName("alumnos").item(0);
				NodeList alumnos = alumnosTag.getElementsByTagName("alumno");
				System.out.println("Nombre del curso: \t" +  nombre + " Numero de horas:" + horas);
				for (Integer x = 0; x < alumnos.getLength(); x++) {
					Element alumnoTag = (Element) alumnos.item(x);
					String alumnoNombre = alumnoTag.getTextContent();
					String dni = alumnoTag.getAttribute("dni");
					System.out.println("Alumnos nobre " + alumnoNombre + " alumno dni " + dni);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void crearXml(String ruta) {

		try {
			// Crear la fabrica de documentos
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			// Creamos documento
			Document xml = builder.newDocument();
			// Creamos la raiz del xml
			Element root = xml.createElement("cursos");
			xml.appendChild(root);

			// Cuando vayamos a escribir el fichero
			Element cursoTag = xml.createElement("curso");
			root.appendChild(cursoTag);
			Element nombreTag = xml.createElement("nombre");
			nombreTag.setTextContent("Programacion");
			cursoTag.appendChild(nombreTag);

			Element horasTag = xml.createElement("horas");
			horasTag.setTextContent("8");
			Element alumnosTag = xml.createElement("alumnos");

			cursoTag.appendChild(horasTag);
			cursoTag.appendChild(alumnosTag);
			Element alumnoTag = xml.createElement("alumno");
			alumnoTag.setTextContent("Lucas de los Campos");
			alumnoTag.setAttribute("dni", "1234567");
			alumnosTag.appendChild(alumnoTag);

			// Guardar xml en fichero
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
