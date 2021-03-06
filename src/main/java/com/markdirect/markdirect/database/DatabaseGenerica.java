package com.markdirect.markdirect.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseGenerica {

	//Atributos 
	protected String host;
	protected int port;
	protected String dataBase;
	protected String user;
	protected String pass;
	protected Connection cn;

	//Datos del driver para la conexi髇 con la base de datos, constantes para todo el proyecto
	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_SQL_SERVER = "com.odbc.oracle.SQLServer";

	//Constructores
	protected DatabaseGenerica(){

	}

	public DatabaseGenerica(String host, int port, String dataBase, String user, String pass) {
		this.host = host;
		this.port = port;
		this.dataBase = dataBase;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * M茅todo que carga el driver especificado en DataBase.DRIVER_MYSQL en memoria.
	 * @return boolean - True si se carg贸 correctamente o false en caso contrario.
	 */
	public boolean loadDriver() {

		return this.loadDriver(this.DRIVER_MYSQL);
	}


	/**
	 * M茅todo que carga un driver especificado.
	 * @param driver - String que representa la clase a cargar en  memoria que usar谩 la BD.
	 * @return boolean - True si se carg贸 correctamente o false en caso contrario.
	 */
	public boolean loadDriver(String driver) {

		boolean load = false;
		try {
			Class.forName(driver);
			load = true;//Si no peta por la excepci贸n y sigue ejecutando, es que se carg贸 correctamente.
			System.out.println("El driver se ha cargado correctamente");

		} catch (ClassNotFoundException e) {
			//Si peta por la excepci贸n, no entra en el try y load sigue valiendo un false, por lo que devuelve ese valor.
		}
		return load;
	}




	/**
	 * M茅todo que contruye la url de conexi贸n a partir de los atributos del objeto.
	 * @return String - Cadena que devuelve la url de conexi贸n a la base de datos.
	 */
	public String getURL() {
		return "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dataBase;
	}



	/**
	 * M茅todo que establece una conexi贸n con la base de datos especificada en los atributos de la clase.
	 * @return boolean - True si la conexi贸n se estableci贸 correctamente y false en caso contrario.
	 */
	public boolean createConnection() {
		boolean conectedOK = false;
		this.cn = null;
		try {
			this.cn = DriverManager.getConnection(this.getURL(), this.user, this.pass);
			conectedOK = true;
		} catch (SQLException e) {
			// Si peta no hacemos nada, devolvemos un false.
		}

		return  conectedOK;

	}

	/**
	 * M茅todo que dice si tenemos una conexi贸n establecida o no. (Para establecer una conexi贸n tenemos que usar el
	 * m茅todo .createConnection()).
	 * @return boolean. True si hay conexi贸n y false si la conexi贸n es  null.
	 */
	public boolean isConnected() {
		return this.cn != null;
	}

	/**
	 * M茅todo que se encarga de cerrar una conexi贸n y capturar las excepciones que puedan darse.
	 * @return boolean - True si se cierra bien, false si no.
	 */
	public boolean closeConnection() {
		boolean todoCorrecto = false;
		try {
			this.cn.close();
			todoCorrecto = true;
		} catch (SQLException e) {

		}
		return todoCorrecto;
	}
}
