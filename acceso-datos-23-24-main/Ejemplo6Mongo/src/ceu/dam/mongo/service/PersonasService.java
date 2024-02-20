package ceu.dam.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.mongo.MongoSession;
import ceu.dam.mongo.modelo.Persona;

public class PersonasService {

	
	public String insertarPersona(Persona persona) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		InsertOneResult result = c.insertOne(persona);
		return result.getInsertedId().toString();
	}
	
	public Persona consultarPersona(String id) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		Bson filter = Filters.eq("_id", new ObjectId(id));
		FindIterable<Persona> result = c.find(filter);
		return result.first();
	}
	
	public void borrarPersona(String id) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		Bson filter = Filters.eq("_id", new ObjectId(id));
		c.deleteOne(filter);
	}
	
	public void borrarAdultos() {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		Bson filter = Filters.gte("edad", 18);
		c.deleteMany(filter);
	}
	
	public List<Persona> consultarTodasPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		FindIterable<Persona> result = c.find();
		MongoCursor<Persona> cursor = result.cursor();
		while(cursor.hasNext()) {
			personas.add(cursor.next());
		}
		return personas;
	}
	
	
	
	
}
