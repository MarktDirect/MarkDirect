package com.markdirect.markdirect.database;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.markdirect.markdirect.beans.DatabaseData;

public class DatabaseMetricas extends DatabaseGenerica {

	private JdbcTemplate jdbc;

	public static final String BASE_DATOS = "MarkDirect";
	
	public DatabaseMetricas() {
		this.jdbc = new JdbcTemplate(Conector.getDataSource());
	}
	
	public ArrayList<DatabaseData> usersByGender() {
		
		ArrayList<DatabaseData> users = new ArrayList<DatabaseData>();
		
		//Sentencia sql que no servirá tanto para hombres como para mujeres
		String sqlM = "SELECT COUNT(*) FROM users WHERE userGen = 'M'";
		int usersM = jdbc.queryForInt(sqlM);
		DatabaseData women = new DatabaseData("Mujeres", usersM);
		String sqlH = "SELECT COUNT(*) FROM users WHERE userGen = 'H'";
		int usersH = jdbc.queryForInt(sqlH);
		DatabaseData men = new DatabaseData("Hombres", usersH);
		
		//Añadimos al arrayList los dos objetos
		users.add(women);
		users.add(men);
		
		System.out.println(users);
		
		return users;
	}
	
}
