package ejemploJdbc2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemploJdbc2.modelo.Actor;

public class ActoresDao {

	public List<Actor> consultarActores(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Actor> actores = new ArrayList<Actor>();
			String sql = "select * from actor";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Actor a = new Actor();
				a.setId(rs.getInt("actor_id"));
				a.setNombre(rs.getString("first_name"));
				a.setApellidos(rs.getString("last_name"));
				actores.add(a);
			}
			return actores;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	
	}

}
