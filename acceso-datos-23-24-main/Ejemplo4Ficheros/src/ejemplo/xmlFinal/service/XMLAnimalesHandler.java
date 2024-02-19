package ejemplo.xmlFinal.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejemplo.xmlFinal.modelo.Animal;
import ejemplo.xmlFinal.modelo.Habitat;

public class XMLAnimalesHandler extends DefaultHandler{

	private Boolean openTag;
	private String texto;
	
	private List<Animal> animales;
	private Animal animal;
	private Habitat habitat;
	
	
	public XMLAnimalesHandler() {
		openTag = false;
		texto = "";
		animales = new ArrayList<Animal>();
	}
	
	
	
	public List<Animal> getAnimales() {
		return animales;
	}



	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";
		
		if (qName.equals("animal")) {
			animal = new Animal();
			animal.setHabitats(new ArrayList<Habitat>());
			animales.add(animal);
			animal.setCodigo(Integer.parseInt(attributes.getValue("codigo")));
		}
		else if (qName.equals("habitat")) {
			habitat = new Habitat();
			animal.getHabitats().add(habitat);
		}
	
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		
		if (qName.equals("especie")) {
			animal.setEspecie(texto);
		}
		else if (qName.equals("subespecie")) {
			animal.setSubespecie(texto);
		}
		else if (qName.equals("pais")) {
			habitat.setPais(texto);
		}
		else if (qName.equals("zona")) {
			habitat.setZona(texto);
		}
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}


	
	
}
