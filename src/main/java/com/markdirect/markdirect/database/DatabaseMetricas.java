package com.markdirect.markdirect.database;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseMetricas extends DatabaseGenerica {

	private JdbcTemplate jdbc;

	public static final String BASE_DATOS = "MarkDirect";
	
	public DatabaseMetricas() {
		this.jdbc = new JdbcTemplate(Conector.getDataSource());
	}
	
	
	
}
