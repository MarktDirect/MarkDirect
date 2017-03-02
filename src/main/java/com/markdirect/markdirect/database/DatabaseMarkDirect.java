package com.markdirect.markdirect.database;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

import com.markdirect.markdirect.beans.Promocion;

public class DatabaseMarkDirect extends DatabaseGenerica {

	private JdbcTemplate jdbc;

	public static final String BASE_DATOS = "MarkDirect";

	public DatabaseMarkDirect(){

		this.jdbc = new JdbcTemplate(Conector.getDataSource());

		/*Aquí irán todos los métodos de consultas a la base de datos
		 * que después llamaremos desde los controladores designados para cada acción
		 */
	}
	/* Método que devuelve una lista de todas las promociones */
	public List<Promocion> listarPromociones() {
		String sql = "SELECT * FROM promos";
		List<Promocion> listaPromociones = jdbc.query(
				sql, 
				new BeanPropertyRowMapper<Promocion>(Promocion.class)
				);		

		if(listaPromociones.isEmpty()) {
			System.out.println("He realizado la consulta con éxito pero la lista está vacía");
		}
		
		return listaPromociones;
	}

}
