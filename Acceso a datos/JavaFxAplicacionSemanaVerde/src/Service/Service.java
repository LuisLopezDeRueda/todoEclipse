package Service;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.Trabajador;
import Modelo.Venta;

public class Service {
	public void insertarTrabajador(Trabajador trabajador) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Trabajador> c = db.getCollection("Trabajador", Trabajador.class);
		c.insertOne(trabajador);
	}

	public void insertarCliente(Cliente cliente) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Cliente> c = db.getCollection("Cliente", Cliente.class);
		c.insertOne(cliente);
	}

	public void insertarArticulo(Articulo articulo) {
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
			throw new ArticuloException("El articulo no existe");
		}
		return result.first();
	}

	public Cliente consultarCliente(String dni) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Cliente> c = db.getCollection("Cliente", Cliente.class);
		FindIterable<Cliente> result = c.find(Filters.eq("dni", dni));
		return result.first();
	}

	public List<Articulo> consultarArticulos() {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Articulo> c = db.getCollection("Articulo", Articulo.class);
		FindIterable<Articulo> result = c.find();
		MongoCursor<Articulo> cursor = result.cursor();
		List<Articulo> articulos = new ArrayList<Articulo>();
		while (cursor.hasNext()) {
			articulos.add(cursor.next());
		}
		return articulos;
	}

	public void insertarVenta(Venta venta) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Venta> c = db.getCollection("Venta", Venta.class);
		c.insertOne(venta);
	}

}
