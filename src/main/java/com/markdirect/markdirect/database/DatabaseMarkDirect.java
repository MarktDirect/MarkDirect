package com.markdirect.markdirect.database;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseMarkDirect extends DatabaseGenerica {
	private JdbcTemplate jdbc;

	public static final String BASE_DATOS = "pedidos";

	public DatabaseMarkDirect(){
		
		this.jdbc = new JdbcTemplate(Conector.getDataSource());
		
		/*Aquí irán todos los métodos de consultas a la base de datos
		 * que después llamaremos desde los controladores designados para cada acción
		 */
	}
}
