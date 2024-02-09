package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;

public class ClientesDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		List<Cliente> listaCliente = new ArrayList<>();
		

			stmt = conn.createStatement();
			String sql = "SELECT * FROM CUSTOMER";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Cliente cliente= new Cliente();
				cliente.setId(rs.getInt("customer_id"));
				cliente.setFisrtName(rs.getString("first_name"));
				cliente.setLastName(rs.getString("last_name"));	
				cliente.setEmail(rs.getString("email"));
				cliente.setActivo(rs.getBoolean("active"));
				listaCliente.add(cliente);
			}		
			
			return listaCliente;
				
		}		
	}


