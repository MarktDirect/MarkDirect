package com.markdirect.markdirect.database;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<DatabaseData> usersByAgeAndGender() {
		ArrayList<DatabaseData> data = new ArrayList<DatabaseData>();
		String sql = "SELECT userGen, SUM("
						+ "IF (userAge BETWEEN 18 AND 25, 1, 0)) '18-25', "
						+ "SUM(IF (userAge BETWEEN 26 AND 35, 1, 0)) '26-35', "
						+ "SUM(IF (userAge BETWEEN 36 AND 45, 1, 0)) '36-45', "
						+ "SUM(IF (userAge BETWEEN 46 AND 55, 1, 0)) '46-55', "
						+ "SUM(IF (userAge > 55, 1, 0)) '+55' FROM users GROUP BY userGen";
		SqlRowSet srs = jdbc.queryForRowSet(sql);
		while(srs.next()) {
			//Recoremos el SQLRowSet y creamos un objeto DatabaseData con cada par de valores
			//el género y todos los rangos de edad
			DatabaseData data1 = new DatabaseData(srs.getString("userGen"), srs.getInt("18-25"));
			DatabaseData data2 = new DatabaseData(srs.getString("userGen"), srs.getInt("26-35"));
			DatabaseData data3 = new DatabaseData(srs.getString("userGen"), srs.getInt("36-45"));
			DatabaseData data4 = new DatabaseData(srs.getString("userGen"), srs.getInt("46-55"));
			DatabaseData data5 = new DatabaseData(srs.getString("userGen"), srs.getInt("+55"));
			//los añadimos al arrayList
			data.add(data1);
			data.add(data2);
			data.add(data3);
			data.add(data4);
			data.add(data5);
		}
		return data;
	}
	
	
	
	
}
