package ceu.dam.mongo;

import java.util.ArrayList;

import ceu.dam.mongo.modelo.Direccion;
import ceu.dam.mongo.modelo.Persona;
import ceu.dam.mongo.service.PersonasService;

public class Test {

	public static void main(String[] args) {
		PersonasService service = new PersonasService();
		
//		Persona p = new Persona("23423X", "María de las Nieves", 48);
//		p.setDirecciones(new ArrayList<>());
//		p.getDirecciones().add(new Direccion("Avda Hola", "Sevilla", 41002));
//		p.getDirecciones().add(new Direccion("Avda Playa, 3", "Málaga", 23002));
//		p.getDirecciones().add(new Direccion("Avda Montaña, 23", "Granada", 12002));
//		String id = service.insertarPersona(p);
//		System.out.println(id);
//		
//		
//		p = new Persona("23423D", "Lucía de las Nieves", 17);
//		p.setDirecciones(new ArrayList<>());
//		p.getDirecciones().add(new Direccion("Avda Hola", "Sevilla", 41002));
//		p.getDirecciones().add(new Direccion("Avda Playa, 3", "Málaga", 23002));
//		p.getDirecciones().add(new Direccion("Avda Montaña, 23", "Granada", 12002));
//		id = service.insertarPersona(p);
//		System.out.println(id);

		System.out.println(service.consultarTodasPersonas());
		service.borrarAdultos();
		System.out.println(service.consultarTodasPersonas());
		
		
	}

}
