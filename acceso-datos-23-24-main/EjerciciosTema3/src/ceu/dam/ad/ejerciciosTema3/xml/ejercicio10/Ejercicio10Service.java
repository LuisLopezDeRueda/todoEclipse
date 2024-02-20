package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libros;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio10Service {

	public void escribirXMLLibros(String pathFile, List<Libro> lista) throws XMLExportException {
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathFile);
			Libros libros = new Libros();
			libros.setLibros(lista);
			mapper.writeValue(file, libros);
		}
		catch(Exception e) {
			System.err.println("Error escribiendo XML " + e.getMessage());
			throw new XMLExportException("Error escribiendo XML" , e);
		}
	}
	
	public List<Libro> leerXMLLibros(String pathFile) throws XMLExportException {
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathFile);
			Libros libros = mapper.readValue(file, Libros.class);
			return libros.getLibros();
		}
		catch(Exception e) {
			System.err.println("Error leyendo XML " + e.getMessage());
			throw new XMLExportException("Error leyendo XML" , e);
		}
	}
	
	
	public void escribirJsonLibros(String pathFile, List<Libro> lista) throws XMLExportException {
		try {
			JsonMapper mapper = new JsonMapper();
			File file = new File(pathFile);
			mapper.writeValue(file, lista);
		}
		catch(Exception e) {
			System.err.println("Error escribiendo JSON " + e.getMessage());
			throw new XMLExportException("Error escribiendo JSON" , e);
		}
	}
	
	public List<Libro> leerJsonLibros(String pathFile) throws XMLExportException {
		try {
			JsonMapper mapper = new JsonMapper();
			File file = new File(pathFile);
			return Arrays.asList(mapper.readValue(file, Libro[].class));
		}
		catch(Exception e) {
			System.err.println("Error leyendo JSON " + e.getMessage());
			throw new XMLExportException("Error leyendo JSON" , e);
		}
	}
	
	
	
	
	

}
