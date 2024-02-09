package ceu.dam.mongo.Service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.mongo.modelo.Persona;

public class Service {
	public String insertarPersona(Persona persona, MongoDatabase db) {
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		InsertOneResult result = c.insertOne(persona);
		return result.getInsertedId().toString();

	}

	public Persona consultarPersona(String id, MongoDatabase db) {
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		FindIterable<Persona> result = c.find(Filters.eq("_id", new ObjectId(id)));
		return result.first();

	}

	public void borrarPersona(String id, MongoDatabase db) {
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		c.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}

	public void borrarAdultos(String id, MongoDatabase db) {
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		c.deleteMany(Filters.gte("edad", 18));
	}

	public List<Persona> consultarPersonas(MongoDatabase db) {
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		FindIterable<Persona> result = c.find();
		MongoCursor<Persona> cursor = result.cursor();
		List<Persona> personas = new ArrayList<Persona>();
		while (cursor.hasNext()) {
			personas.add(cursor.next());
		}
		return personas;
	}
}