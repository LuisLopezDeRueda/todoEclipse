package EJ5;

import java.sql.Connection;
import java.sql.SQLException;

import EJ5.Dao.Dao;
import EJ5.Modelo.Ciudad;
import EJ5.Service.OpenConnection;

public class App {

	public static void main(String[] args) {
		Connection conn = null;
		Ciudad city = new Ciudad();
		city.setCountryId(87L);
		city.setDescripcion("ASJDOAIHDIH");
		city.setId(601L);
		try {
			Dao dao = new Dao();
			conn = new OpenConnection().getConection();
			dao.registrarUnaCiudad(conn, city);
		} catch (SQLException e) {
			System.out.println("Error sql"+e);
		}	
		System.out.println("si");
	}

}
