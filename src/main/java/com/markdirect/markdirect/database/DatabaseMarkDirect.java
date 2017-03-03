package com.markdirect.markdirect.database;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

import com.markdirect.markdirect.beans.Promocion;
import com.markdirect.markdirect.beans.Usuario;
import com.markdirect.markdirect.beans.Zona;

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
		List<Promocion> listaPromociones = null;
		try {
			listaPromociones = jdbc.query(
				sql, 
				new BeanPropertyRowMapper<Promocion>(Promocion.class)
				);	
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones");
		}
		return listaPromociones;
	}
	public List<Zona> listarZonas() {
		String sql = "SELECT * FROM controlzones";
		List<Zona> listaZonas = null;
		try {
			listaZonas = jdbc.query(
				sql, 
				new BeanPropertyRowMapper<Zona>(Zona.class)
				);	
		}catch(Exception e) {
			System.out.println("Error en la consulta");
		}
		return listaZonas;
	}
	
	
	//Metodo que devuelve una lista de los usuarios de la aplicacion
	public List<Usuario> listarUsuarios(){
		String SQL="SELECT*FROM users";
		List<Usuario> listausuario = jdbc.query(
				SQL, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		
		return listausuario;
	}
	/*
	 * Método que añade una promoción a la base de datos
	 */
	public int addPromo(String promoName, String promoDescription, String promoSince, String promoTo, String promoImage,
			int promo_controlZoneId, int promoMinAge, int promoMaxAge, String promoGen) {
		
		Promocion promo = new Promocion(promoName, promoDescription, promoSince, promoTo, promoImage, promoMinAge, promoMaxAge, promoGen, promo_controlZoneId);
		
		//TODO falta promoState
		String sql = "INSERT INTO promos (promoName, promoDescription, promoSince, promoTo, promoCreate, promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promoState) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int filasAfectadas = jdbc.update(sql, new Object[] {promoName, promoDescription, promoSince, promoTo, Promocion.dateTimePromo(), promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promo.activePromo()});
		
		if(filasAfectadas == 1) {
			System.out.println("Promoción añadida con éxito");
		} 
		else {
			System.out.println("Error en la consulta");
		}
		
		return filasAfectadas;
	}
}
