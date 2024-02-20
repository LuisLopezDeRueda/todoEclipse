package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.services;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.solucionJackson.modelo.Catalogo;


public class Ejercicio12Service {

	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException{
		try {
			
			File file = new File(pathFile);
			XmlMapper mapper = new XmlMapper();
			mapper.writeValue(file, catalogo);
			
		} catch (Exception e) {
			throw new CatalogoXMLException("Error al exportar cat�logo", e);
		}
	}
	
	public Catalogo importXML(String pathFile) throws CatalogoXMLException{
		try {
			
			File file = new File(pathFile);
			XmlMapper mapper = new XmlMapper();
			return mapper.readValue(file, Catalogo.class);
			
		} catch (Exception e) {
			throw new CatalogoXMLException("Error al importar cat�logo", e);
		}
	}

	
	
}
