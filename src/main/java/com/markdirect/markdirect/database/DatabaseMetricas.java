package com.markdirect.markdirect.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.markdirect.markdirect.beans.Administrador;

import org.springframework.jdbc.support.rowset.SqlRowSet;


import com.markdirect.markdirect.beans.DatabaseData;
import com.markdirect.markdirect.beans.Producto;

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
	 * Método que consulta la BBDD para obtener el número total de usuarios
	 * @return int - número total de usuarios
	 */
	public int totalSentPromos() {
		int totalSentPromos = jdbc.queryForInt("SELECT COUNT(*) FROM sentpromos");
		return totalSentPromos;
	}
	
	/**
	 * Método que devuelve el número de promociones genéricas enviadas
	 * @return
	 */
	public int totalGenericSent() {
		int totalGenericPromos = jdbc.queryForInt("SELECT COUNT(*) FROM sentpromos JOIN promos ON sentpromos.id_promo = promos.promoId WHERE promos.promo_controlzoneId = 0");
		return totalGenericPromos;
	}

	/**
	 * Método que devuelve el número de promociones genéricas enviadas
	 * @return
	 */
	public int totalLocationSent() {
		int totalLocationPromos = jdbc.queryForInt("SELECT COUNT(*) FROM sentpromos JOIN promos ON sentpromos.id_promo = promos.promoId WHERE promos.promo_controlzoneId > 0");
		return totalLocationPromos;
	}
	
	/**
	 * Método que consulta la BBDD para devolver la edad media de los usuarios registrados
	 * @return double - edad
	 */
	public double averageAge() {
		double averageAge = jdbc.queryForInt("SELECT AVG(userAge) FROM users");
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
				"AS 'Veces' FROM products JOIN promos ON products.id="
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
				"AS 'Veces' FROM products JOIN promos ON products.id="
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

	/**
	 * M�todo que consulta en la DDBB los niveles 1 m�s enviados a mujeres
	 * @return//listaNivels1M:ArrayList con los productos y el n�mero de veces que se ha enviado
	 *  a mujeres
	 */
	public ArrayList<DatabaseData> nivel1Women(){		

		//Creamos sentencia sql para mujeres
		String sqlM= "SELECT level1categories.category AS 'Categor�a Nivel 1', "
				+ "COUNT(level1categories.category) AS 'Veces'"
				+ " FROM level1categories JOIN products ON products.id_level2Category="
				+ "level1categories.id JOIN promos ON products.id=promos.promo_idProduct "
				+ "JOIN sentpromos ON sentpromos.id_promo = promos.promoId JOIN usertoken"
				+ " ON sentpromos.user_token=usertoken.token JOIN users ON usertoken.id_user"
				+ "=users.userId WHERE users.userGen = 'M'GROUP BY level1categories.category";		

		//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:

		List listaNivels1 = jdbc.queryForList(sqlM);

		//Casteamos el List para que sea un ArrayList<Databasedata>
		ArrayList<DatabaseData> listaNivels1M = new ArrayList<DatabaseData>();		
		listaNivels1M =(ArrayList<DatabaseData>) listaNivels1;

		//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a mujeres
		return  listaNivels1M;

	}

	/**
	 *  M�todo que consulta en la DDBB los niveles 1 m�s enviados a hombres
	 * @return listaNivels1H ArrayList con los productos y el n�mero de veces que se 
	 * ha enviado a hombres
	 */
	public ArrayList<DatabaseData> nivel1Men(){		

		//Creamos sentencia sql para hombres
		String sqlH= "SELECT level1categories.category AS 'Categor�a Nivel 1', "
				+ "COUNT(level1categories.category) AS 'Veces'"
				+ " FROM level1categories JOIN products ON products.id_level2Category="
				+ "level1categories.id JOIN promos ON products.id=promos.promo_idProduct "
				+ "JOIN sentpromos ON sentpromos.id_promo = promos.promoId JOIN usertoken"
				+ " ON sentpromos.user_token=usertoken.token JOIN users ON usertoken.id_user"
				+ "=users.userId WHERE users.userGen = 'H'GROUP BY level1categories.category";		

		//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:

		List listaNivels1 = jdbc.queryForList(sqlH);

		//Casteamos el List para que sea un ArrayList<Databasedata>
		ArrayList<DatabaseData> listaNivels1H = new ArrayList<DatabaseData>();		
		listaNivels1H =(ArrayList<DatabaseData>) listaNivels1;

		//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a hombres
		return  listaNivels1H;

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
	
public ArrayList<DatabaseData> brandMen(){		
		
		//Creamos sentencia sql para hombres
		String sql="SELECT products.productBrand AS 'Marca', "
				+ "COUNT(products.productBrand) AS 'Veces' "
				+ "FROM products JOIN promos ON products.id=promos.promo_idProduct JOIN sentpromos "
				+ "ON sentpromos.id_promo = promos.promoId JOIN usertoken ON sentpromos.user_token=usertoken.token "
				+ "JOIN users ON usertoken.id_user=users.userId WHERE users.userGen = 'H'GROUP BY productBrand";		
		//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:
			  				
		List listaMarcasH = jdbc.queryForList(sql);
		
		//Casteamos el List para que sea un ArrayList<Databasedata>
		ArrayList<DatabaseData> listaProductosmarcaH = new ArrayList<DatabaseData>();		
		listaProductosmarcaH =(ArrayList<DatabaseData>) listaMarcasH;
		
		//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a hombres
		System.out.println(listaMarcasH);
		return  listaProductosmarcaH;
					
	}	

public ArrayList<DatabaseData> brandWomen(){		
	
	//Creamos sentencia sql para hombres
	String sql="SELECT products.productBrand AS 'Marca', "
			+ "COUNT(products.productBrand) AS 'Veces' "
			+ "FROM products JOIN promos ON products.id=promos.promo_idProduct JOIN sentpromos "
			+ "ON sentpromos.id_promo = promos.promoId JOIN usertoken ON sentpromos.user_token=usertoken.token "
			+ "JOIN users ON usertoken.id_user=users.userId WHERE users.userGen = 'M'GROUP BY productBrand";		
	//Realizamos las consultas y los guadamos en un list de objetos DatabaseData:
		  				
	List listaMarcasM = jdbc.queryForList(sql);
	
	//Casteamos el List para que sea un ArrayList<Databasedata>
	ArrayList<DatabaseData> listaProductosmarcaM = new ArrayList<DatabaseData>();		
	listaProductosmarcaM =(ArrayList<DatabaseData>) listaMarcasM;
	System.out.println(listaMarcasM);
	//Devolvemos ArrayList con los productos y el n�mero de veces que se ha enviado a hombres
	return  listaProductosmarcaM;
				
}	

public ArrayList<DatabaseData> sentPromosByGender() {

	ArrayList<DatabaseData> totalPromosByGender = new ArrayList<DatabaseData>();

	//Sentencia sql que no servirá tanto para hombres como para mujeres
	String sqlM = "SELECT COUNT(sentpromos.id_promo) AS 'Veces' FROM sentpromos JOIN usertoken ON sentpromos.user_token = usertoken.token JOIN users ON usertoken.id_user = users.userId WHERE users.userGen = 'M'";
	int promocionesM = jdbc.queryForInt(sqlM);
	DatabaseData women = new DatabaseData("Mujeres", promocionesM);
	String sqlH = "SELECT COUNT(sentpromos.id_promo) AS 'Veces' FROM sentpromos JOIN usertoken ON sentpromos.user_token = usertoken.token JOIN users ON usertoken.id_user = users.userId WHERE users.userGen = 'H'";
	int promocionesH = jdbc.queryForInt(sqlH);
	DatabaseData men = new DatabaseData("Hombres", promocionesH);
	//Añadimos al arrayList los dos objetos
	totalPromosByGender.add(women);
	totalPromosByGender.add(men);

	return totalPromosByGender;
}		

public ArrayList<DatabaseData> promocionesPorGenero() {

	ArrayList<DatabaseData> promocionesgenero = new ArrayList<DatabaseData>();

	//Sentencia sql que no servirá tanto para hombres como para mujeres
	String sqlM = "SELECT sentpromos.id_promo AS 'Promo', "
			+ "COUNT(sentpromos.id_promo) AS 'Veces' "
			+ "FROM sentpromos JOIN usertoken ON sentpromos.user_token = usertoken.token "
			+ "JOIN users ON usertoken.id_user = users.userId WHERE users.userGen = 'M' GROUP BY id_promo";
	int promocionesM = jdbc.queryForInt(sqlM);
	DatabaseData mujer = new DatabaseData("Mujeres", promocionesM);
	System.out.println(mujer);
	String sqlH = "SELECT sentpromos.id_promo AS 'Promo ID', "
			+ "COUNT(sentpromos.id_promo) AS 'Veces' "
			+ "FROM sentpromos JOIN usertoken ON sentpromos.user_token = usertoken.token "
			+ "JOIN users ON usertoken.id_user = users.userId WHERE users.userGen = 'H' GROUP BY id_promo";
	int promocionesH = jdbc.queryForInt(sqlH);
	DatabaseData hombre = new DatabaseData("Hombres", promocionesH);
	System.out.println(hombre);
	//Añadimos al arrayList los dos objetos
	promocionesgenero.add(mujer);
	promocionesgenero.add(hombre);
	System.out.println(promocionesgenero);

	return promocionesgenero;
}		




	

}
