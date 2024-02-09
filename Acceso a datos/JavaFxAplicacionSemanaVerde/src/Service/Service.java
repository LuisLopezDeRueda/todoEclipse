package Service;

import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.Trabajador;

public class Service {
	public void insertarTrabajador(Trabajador trabajador){
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Trabajador> c = db.getCollection("Trabajador", Trabajador.class);
		c.insertOne(trabajador);
	}

	public void actualizarTrabajador(String nuevaContraseña, String nombre) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Trabajador> c = db.getCollection("Trabajador", Trabajador.class);
		Bson filtro = Filters.regex("nombre", nombre);
		Bson update = Updates.set("contraseña", nuevaContraseña);
		c.updateMany(filtro, update);
	}

	public void insertarArticulo(Articulo articulo) throws ArticuloException {
		if (consultarArticulo(articulo.getDescripcion()) != null) {
			throw new ArticuloException("El articulo ya existe");
		}
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Articulo> c = db.getCollection("Articulo", Articulo.class);
		c.insertOne(articulo);
	}

	public Trabajador consultarTrabajador(String nombre, String contraseña) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Trabajador> c = db.getCollection("Trabajador", Trabajador.class);
		FindIterable<Trabajador> result = c
				.find(Filters.and(Filters.eq("nombre", nombre), Filters.eq("contraseña", contraseña)));
		return result.first();
	}

	public Trabajador consultarTrabajadorSinContreseña(String nombre) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Trabajador> c = db.getCollection("Trabajador", Trabajador.class);
		FindIterable<Trabajador> result = c.find(Filters.eq("nombre", nombre));
		return result.first();
	}

	public Articulo consultarArticulo(String codigoBarras) throws ArticuloException {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Articulo> c = db.getCollection("Articulo", Articulo.class);
		FindIterable<Articulo> result = c.find(Filters.eq("codBarras", codigoBarras));
		if (result.first() == null) {
			throw new ArticuloException("No hay aritulos con ese codigo de barras");
		}
		return result.first();
	}

	public Cliente consultarCliente(String dni) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Cliente> c = db.getCollection("Cliente", Cliente.class);
		FindIterable<Cliente> result = c.find(Filters.eq("dni", dni));
		return result.first();
	}
}
