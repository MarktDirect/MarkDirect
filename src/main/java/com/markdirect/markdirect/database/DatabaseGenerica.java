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

	//Datos del driver para la conexi�n con la base de datos, constantes para todo el proyecto
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
	 * Método que carga el driver especificado en DataBase.DRIVER_MYSQL en memoria.
	 * @return boolean - True si se cargó correctamente o false en caso contrario.
	 */
	public boolean loadDriver() {

		return this.loadDriver(this.DRIVER_MYSQL);
	}


	/**
	 * Método que carga un driver especificado.
	 * @param driver - String que representa la clase a cargar en  memoria que usará la BD.
	 * @return boolean - True si se cargó correctamente o false en caso contrario.
	 */
	public boolean loadDriver(String driver) {

		boolean load = false;
		try {
			Class.forName(driver);
			load = true;//Si no peta por la excepción y sigue ejecutando, es que se cargó correctamente.
			System.out.println("El driver se ha cargado correctamente");

		} catch (ClassNotFoundException e) {
			//Si peta por la excepción, no entra en el try y load sigue valiendo un false, por lo que devuelve ese valor.
		}
		return load;
	}




	/**
	 * Método que contruye la url de conexión a partir de los atributos del objeto.
	 * @return String - Cadena que devuelve la url de conexión a la base de datos.
	 */
	public String getURL() {
		return "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dataBase;
	}



	/**
	 * Método que establece una conexión con la base de datos especificada en los atributos de la clase.
	 * @return boolean - True si la conexión se estableció correctamente y false en caso contrario.
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
	 * Método que dice si tenemos una conexión establecida o no. (Para establecer una conexión tenemos que usar el
	 * método .createConnection()).
	 * @return boolean. True si hay conexión y false si la conexión es  null.
	 */
	public boolean isConnected() {
		return this.cn != null;
	}

	/**
	 * Método que se encarga de cerrar una conexión y capturar las excepciones que puedan darse.
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
