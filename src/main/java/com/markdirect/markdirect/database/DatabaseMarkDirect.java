package com.markdirect.markdirect.database;

import java.sql.SQLException;
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
		System.out.println("Estoy en el método listarPromociones");
		String sql = "SELECT promoName, promoDescription, promoSince, promoTo FROM promos";
		List<Promocion> listaPromociones = null;
		try {
			listaPromociones = jdbc.query(
				sql, 
				new BeanPropertyRowMapper<Promocion>(Promocion.class)
				);	
			System.out.println("He hecho la consulta bien");
		}catch(Exception e) {
			System.out.println("Error en la consulta");
		}
		
		if(listaPromociones.isEmpty()) {
			System.out.println("He realizado la consulta con éxito pero la lista está vacía");
		} else {
			System.out.println("Guay del paraguay");
		}
		
		return listaPromociones;
	}

}
