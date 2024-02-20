package ejemplo.xmlFinal.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejemplo.xmlFinal.modelo.Animal;
import ejemplo.xmlFinal.modelo.Animales;
import ejemplo.xmlFinal.modelo.Habitat;

public class AnimalService {

	public List<Animal> leerXMLJackson(String fileName) throws AnimalesXMLException{
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(fileName);
			Animales animales = mapper.readValue(file, Animales.class);
			return animales.getAnimales();
		} catch (IOException e) {
			System.err.println("Error al leer XML de animales" + e.getMessage());
			throw new AnimalesXMLException("Error escribiendo XML", e);
		}
	
	}
	
	public void escribirXMLJackson(List<Animal> animales, String fileName) throws AnimalesXMLException{
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(fileName);

			Animales animalesObject = new Animales();
			animalesObject.setAnimales(animales);
			
			mapper.writeValue(file, animalesObject);
		} catch (IOException e) {
			System.err.println("Error al escribir XML de animales" + e.getMessage());
			throw new AnimalesXMLException("Error escribiendo XML", e);
		}
	
	}
	
	public List<Animal> leerXMLSax(String fileName) throws AnimalesXMLException{
		try {
			// 1. Nos creamos el SAXParser usando un SaxParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			// 2. Nos creamos una instancia de nuestro Handler
			XMLAnimalesHandler handler = new XMLAnimalesHandler();
			
			// 3. Nos creamos un file a partir de la ruta+nombre de fichero que recibimos
			File file = new File(fileName);
			
			// 4. Ejecutamos el parser para que lea el fichero pasándole el file y nuestro handler
			parser.parse(file, handler);
			
			// 5. Devolvemos la lista de cursos que se ha ido registrando en nuestro handler
			return  handler.getAnimales();
			
		}
		catch(Exception e) {
			System.err.println("Error leyendo XML: " + e.getMessage());
			throw new AnimalesXMLException("Error leyendo XML", e);
		}
		
	}
	
	public List<Animal> leerXMLDom(String fileName) throws AnimalesXMLException{
		List<Animal> animales = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document xml = builder.parse(new File(fileName));
			
			Element root = xml.getDocumentElement(); // Root
			NodeList animalTagList = root.getElementsByTagName("animal");
			for (int i = 0; i < animalTagList.getLength(); i++) {
				Element animalTag = (Element) animalTagList.item(i);
				Animal animal = new Animal();
				animal.setHabitats(new ArrayList<Habitat>());
				animales.add(animal);
				animal.setCodigo(Integer.parseInt(animalTag.getAttribute("codigo")));
				
				Element especieTag = (Element) animalTag.getElementsByTagName("especie").item(0);
				animal.setEspecie(especieTag.getTextContent());

				Element subespecieTag = (Element) animalTag.getElementsByTagName("subespecie").item(0);
				animal.setSubespecie(subespecieTag.getTextContent());
				
				Element habitatsTag = (Element) animalTag.getElementsByTagName("habitats").item(0);
				
				NodeList habitatTagList = habitatsTag.getElementsByTagName("habitat");
				for (int j = 0; j < habitatTagList.getLength(); j++) {
					Element habitatTag = (Element) habitatTagList.item(j);
					Habitat habitat = new Habitat();
					animal.getHabitats().add(habitat);
					
					Element paisTag = (Element) habitatTag.getElementsByTagName("pais").item(0);
					habitat.setPais(paisTag.getTextContent());

					Element zonaTag = (Element) habitatTag.getElementsByTagName("zona").item(0);
					habitat.setZona(zonaTag.getTextContent());
				}
			}
				
			return animales;
			
		}
		catch(Exception e) {
			throw new AnimalesXMLException("Error leyendo XML" , e);
		}
		
		
	}
	
	public void escribirXMLDom(List<Animal> animales, String fileName) throws AnimalesXMLException{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document xml = builder.newDocument();
			
			Element root = xml.createElement("animales");
			xml.appendChild(root);
			
			for (Animal animal : animales) {
				Element animalTag = xml.createElement("animal");
				root.appendChild(animalTag);
				animalTag.setAttribute("codigo", animal.getCodigo().toString());
				
				Element especieTag = xml.createElement("especie");
				animalTag.appendChild(especieTag);
				especieTag.setTextContent(animal.getEspecie());
				
				Element subespecieTag = xml.createElement("subespecie");
				animalTag.appendChild(subespecieTag);
				subespecieTag.setTextContent(animal.getSubespecie());
				
				Element habitatsTag = xml.createElement("habitats");
				animalTag.appendChild(habitatsTag);
				for (Habitat habitat : animal.getHabitats()) {
					Element habitatTag = xml.createElement("habitat");
					habitatsTag.appendChild(habitatTag);
					
					Element paisTag = xml.createElement("pais");
					habitatTag.appendChild(paisTag);
					paisTag.setTextContent(habitat.getPais());
					
					Element zonaTag = xml.createElement("zona");
					habitatTag.appendChild(zonaTag);
					zonaTag.setTextContent(habitat.getZona());
				}
			}
			
			// Guardar XML en fichero
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(fileName);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
			
		}
		catch(Exception e) {
			throw new AnimalesXMLException("Error generando XML de cursos", e);
		}	
	}	
	
}
