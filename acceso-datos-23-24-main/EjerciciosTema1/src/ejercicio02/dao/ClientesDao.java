package ejercicio02.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio02.modelo.Cliente;

public class ClientesDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Cliente> resultado = new ArrayList<Cliente>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("customer_id"));
				cliente.setNombre(rs.getString("first_name"));
				cliente.setApellidos(rs.getString("last_name"));
				cliente.setEmail(rs.getString("email"));
				cliente.setActivo(rs.getBoolean("active"));
				resultado.add(cliente);
			}
			return resultado;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception ignore) {}
		}
	}

}
