package ceu.dam.ad.examen.ej2services;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.ad.examen.ej1dao.CategoriaDaoImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	@Override
	public Categoria crearCategoria(String nombre) throws InvalidParamException, AccessDatabaseException {
		Connection conn = null;
		CategoriaDaoImpl dao = new CategoriaDaoImpl();
		if (nombre == null) {
			throw new InvalidParamException("Error con el nombre");
		}
		try {
			conn = new OpenConnection().getConection();
			
			Long id = dao.insertarCategoria(conn, nombre);
			Categoria categoria = dao.consultarCategoria(conn, id);
			if (categoria.getName().isEmpty() || categoria.getName() == null || categoria.getName().isBlank()
					|| categoria.getName().length() > 25) {
				throw new InvalidParamException("Error con el nombre");
			}
			return categoria;
		} catch (SQLException e) {
			throw new AccessDatabaseException("Error con la base de datos " + e.getStackTrace());
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {

		Connection conn = null;
		CategoriaDaoImpl dao = new CategoriaDaoImpl();

		try {
			if (id == null) {
				throw new InvalidParamException("El id no puede ser nulo");
			}
			conn = new OpenConnection().getConection();
			Categoria categoria = dao.consultarCategoria(conn, id);
			if (categoria == null) {
				throw new NotFoundException("La categoria es nula");
			}
			return categoria;

		} catch (SQLException e) {
			throw new AccessDatabaseException("Error con la base de datos " + e.getStackTrace());
		}
	}

}
