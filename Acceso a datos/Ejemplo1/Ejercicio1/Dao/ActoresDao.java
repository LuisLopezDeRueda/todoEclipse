package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Actor;

public class ActoresDao {

	public List<Actor> consultarActor(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		List<Actor> listActores = new ArrayList<>();
		

			stmt = conn.createStatement();
			String sql = "SELECT * FROM ACTOR";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Actor actor = new Actor();
				actor.setNombre(rs.getNString("first_name"));
				actor.setApellidos(rs.getNString("last_name"));
				actor.setId(rs.getInt("actor_id"));
				listActores.add(actor);
			}		
					conn.close();
			
				
				return listActores;
				}
		
		
	}
	

