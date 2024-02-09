package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DaoUsuario.RegistroDao;
import Modelo.Registro;

public class RegistroService {

	public List<Registro> consultarRegistros(Long idUsuario) throws RegistroException {

		Connection conn = null;
		RegistroDao csr = new RegistroDao();
		List<Registro> listaRegistro = new ArrayList<Registro>();
		try {
			conn = new OpenConnectionceufct().getConection();
			listaRegistro = csr.consultarTodosRegistro(conn, idUsuario);
			if (listaRegistro == null || listaRegistro.isEmpty()) {
				throw new RegistroException();
			} else {
				return listaRegistro;
			}
		} catch (SQLException e) {
			System.out.println("Problema con los registros " + e);
		}
		return listaRegistro;
	}

	public void insertarRegistros(Registro registro) throws RegistroException {

		Connection conn = null;
		RegistroDao csr = new RegistroDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			if (csr.consultarTodosRegistro(conn, registro.getId_usuario()) == null) {
				csr.registrarUnRegistro(conn, registro);
			} else {
				throw new RegistroException();
			}

		} catch (SQLException e) {
			System.out.println("Error al insertar registro" + e);
		}
	}
}
