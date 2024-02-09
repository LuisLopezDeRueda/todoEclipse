package ceu.dam.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoDatabase;

import OpenConection.MongoSession;
import ceu.dam.mongo.Service.Service;
import ceu.dam.mongo.modelo.Direccion;
import ceu.dam.mongo.modelo.Persona;

public class Test {

	public static void main(String[] args) {
		System.out.println("Intentando iniciar conexión...");
		MongoDatabase db = MongoSession.getDatabase();
		Service servicio = new Service();
		Persona p = new Persona("23423X", "María de las Nieves", 48);
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Avda Hola", "Sevilla", 41002));
		p.getDirecciones().add(new Direccion("Avda Playa, 3", "Málaga", 23002));
		p.getDirecciones().add(new Direccion("Avda Montaña, 23", "Granada", 12002));
		String codigo = "65c3af4afd6fd813d5b59ac7";
		System.out.println(servicio.consultarPersona(codigo, db) + "\n Correcto \n");
		List<Persona> lista = servicio.consultarPersonas(db);
		for (Persona persona : lista) {
			System.out.println(persona);
		}

	}

}
