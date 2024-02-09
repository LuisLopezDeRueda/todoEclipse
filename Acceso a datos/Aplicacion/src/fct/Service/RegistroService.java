package fct.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fct.DaoUsuario.RegistroDao;
import fct.Modelo.Registro;

@RestController
public class RegistroService {

	@GetMapping("/registrosUsuarios/{idUsuario}")//Ver la url y esta claro q estoy puscando path sino request
	public List<Registro> consultarRegistros(@PathVariable Long idUsuario) throws RegistroException {

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

	@PostMapping("/altaRegistro")
	public void insertarRegistros(@RequestBody Registro registro) throws RegistroException {

		Connection conn = null;
		RegistroDao csr = new RegistroDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			if (csr.consultarTodosRegistro(conn, registro.getId_usuario()).isEmpty()) {
				csr.registrarUnRegistro(conn, registro);
			} else {
				throw new RegistroException();
			}

		} catch (SQLException e) {
			System.out.println("Error al insertar registro" + e);
		}
	}
}
