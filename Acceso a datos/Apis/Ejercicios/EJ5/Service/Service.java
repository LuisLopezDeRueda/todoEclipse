package EJ5.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EJ5.Dao.Dao;
import EJ5.Modelo.Ciudad;

@RestController
public class Service implements CityService {

	@Override
	@GetMapping("/city")
	public List<Ciudad> getCities(@RequestParam(required = false) String filtroDescripcion)
			throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			List<Ciudad> listaCiudades = dao.filtrarLista("", conn);
			if (listaCiudades.isEmpty()) {
				throw new NotFoundException();
			}
			if (filtroDescripcion == null) {
				return listaCiudades;
			}
			return dao.filtrarLista(filtroDescripcion, conn);
		} catch (SQLException e) {
			throw new ServerErrorException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}

	}

	@Override
	@GetMapping("/city/{id}")
	public Ciudad getCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {

		Connection conn = null;

		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			if (dao.buscarCiudad(id, conn) == null) {
				throw new NotFoundException();
			}
			return dao.buscarCiudad(id, conn);
		} catch (SQLException e) {
			throw new ServerErrorException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}
	}

	@Override
	@PostMapping("/city")
	public Ciudad createCity(@RequestBody Ciudad city) throws ServerErrorException {
		Connection conn = null;
		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			city.setId(dao.registrarUnaCiudad(conn, city));
			return city;
		} catch (SQLException e) {
			throw new ServerErrorException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody Ciudad city) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		Dao dao = new Dao();

		try {
			
			conn = new OpenConnection().getConection();
			Integer numero = dao.actualizarCiudad(conn, city);
			if (numero == 0) {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			System.out.println("Error");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}

	}

	@Override
	@PatchMapping("/city")
	public Ciudad updateSelectiveCity(@RequestBody Ciudad city) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			Integer numero = 0;
			if (dao.buscarCiudad(city.getId(), conn) == null) {
				throw new NotFoundException();
			}
			if (city.getCountryId() != null && city.getDescripcion() != null) {
				numero = dao.actualizarCiudad(conn, city);
			} else if (city.getDescripcion() == null) {
				numero = dao.actualizarCiudadBien(conn, city, 2);
			} else if (city.getCountryId() == null) {
				numero = dao.actualizarCiudadBien(conn, city, 3);
			}
			if (numero == 0) {
				throw new NotFoundException();
			}
			return city;
		} catch (SQLException e) {
			throw new ServerErrorException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}

	}

	@Override
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			Integer numero = dao.borrarCiudad(conn, id);
			if (numero == 0) {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			throw new ServerErrorException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error" + e);
			}
		}
	}

}
