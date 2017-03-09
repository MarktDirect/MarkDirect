package com.markdirect.markdirect.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.markdirect.markdirect.beans.Administrador;
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
	
	
	/**
	 * M�todo que consulta en la DDBB los productos m�s enviados a mujeres
	 * @return ArrayList<DatabaseData> listaProductsM : Devolvemos ArrayList con los productos
	 *  y el n�mero de veces que se ha enviado a mujeres
	 */	
	
	public ArrayList<DatabaseData> productWomen(){		
						
		//Creamos sentencia sql para mujeres
		String sqlM= "SELECT products.productName AS 'Producto', COUNT(products.productName)"+
				"AS 'Veces enviadas a mujeres' FROM products JOIN promos ON products.id="
				+ "promos.promo_idProduct JOIN sentpromos ON sentpromos.id_promo = "
				+ "promos.promoId JOIN usertoken ON sentpromos.user_token=usertoken.token "
				+ "JOIN users ON usertoken.id_user=users.userId WHERE users.userGen = 'M'GROUP"
				+ " BY productName";		
		
		//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:
			  				
		List listaProducts = jdbc.queryForList(sqlM);
		
		//Casteamos el List para que sea un ArrayList<Databasedata>
		ArrayList<DatabaseData> listaProductsM = new ArrayList<DatabaseData>();		
		listaProductsM =(ArrayList<DatabaseData>) listaProducts;
		
		//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a mujeres
		return  listaProductsM;
					
	}
	
	/**
	 *  M�todo que consulta en la DDBB los productos m�s enviados a hombres
	 * @returnArrayList<DatabaseData> listaProductsH : Devolvemos ArrayList con los productos
	 *  y el n�mero de veces que se ha enviado a hombres
	 */
	
	public ArrayList<DatabaseData> productMan(){		
		
		//Creamos sentencia sql para hombres
		String sqlH= "SELECT products.productName AS 'Producto', COUNT(products.productName)"+
				"AS 'Veces enviadas a hombres ' FROM products JOIN promos ON products.id="
				+ "promos.promo_idProduct JOIN sentpromos ON sentpromos.id_promo = "
				+ "promos.promoId JOIN usertoken ON sentpromos.user_token=usertoken.token "
				+ "JOIN users ON usertoken.id_user=users.userId WHERE users.userGen = 'H'GROUP"
				+ " BY productName";		
		
		//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:
			  				
		List listaProducts = jdbc.queryForList(sqlH);
		
		//Casteamos el List para que sea un ArrayList<Databasedata>
		ArrayList<DatabaseData> listaProductsH = new ArrayList<DatabaseData>();		
		listaProductsH =(ArrayList<DatabaseData>) listaProducts;
		
		//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a hombres
		return  listaProductsH;
					
	}
	
}
