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
	
	/**
	 * Método que consulta la BBDD para conocer el número de usuarios registrados filtrados por género
	 * @return ArrayList<DatabaseData> - un arrayList que contiene los datos por género
	 */
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
		
		return users;
	}
	
	/**
	 * Método que consulta la BBDD para obtener el número total de usuarios
	 * @return int - número total de usuarios
	 */
	public int totalUsers() {
		int totalUsers = jdbc.queryForInt("SELECT COUNT(*) FROM users");
		return totalUsers;
	}
	
	/**
	 * Método que consulta la BBDD para devolver la edad media de los usuarios registrados
	 * @return double - edad
	 */
	public double averageAge() {
		double averageAge = jdbc.queryForInt("SELECT AVG(userAge) FROM users");
		System.out.println("La edad media es: " + averageAge);
		return averageAge;
	}
	
}
