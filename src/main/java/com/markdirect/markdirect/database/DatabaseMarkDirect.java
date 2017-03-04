package com.markdirect.markdirect.database;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.beans.Administrador;
import com.markdirect.markdirect.beans.Centro;
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
	
	/**
	 * Método que consulta a la base de datos para obtener una lista de promociones
	 * @return List<Promocion> - si está completa; salta una excepción si hay error en la consulta 
	 */
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
	
	/**
	 * Método que consulta a la base de datos para obtener una lista de zonas
	 * @return List<Zona> - si está completa; salta una excepción si hay error en la consulta 
	 */
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
	
	/**
	 * Método que consulta a la base de datos para obtener una lista de centros
	 * @return List<Centro> - si está completa; salta una excepción si hay error en la consulta 
	 */
	public List<Centro> listarCentros() {
		String sql = "SELECT * FROM centers";
		List<Centro> listaCentros = null;
		try {
			listaCentros = jdbc.query(
				sql, 
				new BeanPropertyRowMapper<Centro>(Centro.class)
				);	
		}catch(Exception e) {
			System.out.println("Error en la consulta");
		}
		return listaCentros;
	}
	
	/**
	 * Método que consulta a la base de datos para obtener una lista de usuarios
	 * @return List<Usuario> - si está completa; salta una excepción si hay error en la consulta 
	 */
	public List<Usuario> listarUsuarios(){
		String sql ="SELECT * FROM users";
		List<Usuario> listausuario = null;
		try {
		listausuario = jdbc.query(
				sql, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		} catch(Exception e) {
			System.out.println("Error en la consulta");
		}
		return listausuario;
	}
	

	/**
	 * Metodo que devuelve un objeto según la petición creada y comprueba si el usuario existe o no 
	 * @param usuario
	 * @param password
	 * @return Administrador
	 */
	public Administrador login(String usuario,String password){
		Administrador admin=new Administrador();
			String sql = "SELECT * FROM admins WHERE admin = ? AND adminPassword = ?";
			admin = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Administrador>(Administrador.class),
					new Object[]{usuario,password});
		return admin;
		
	}

	//Metodo que añade una zona de control a la BBDD
	/**
	 * This method inserts a new row in the controlzones table.
	 * @param controlzoneMajor
	 * @param controlzoneMinor
	 * @param controlzoneEmplacement
	 * @param controlzone_centerId
	 * @return int rowsaffected with the number of rows affected by the update statement, -1 if fails
	 */
	public int insertarZonaControl (
			String controlzoneMajor, 
			String controlzoneMinor, 
			String controlzoneEmplacement, 
			int controlzone_centerId){
		
		//String con la consulta insert
		String sql = "INSERT INTO controlzones (controlzoneMajor, controlzoneMinor," +
		"controlzoneEmplacement, controlzone_centerId) VALUES (?,?,?,?)";
		//TODO preparedStatement
		
		System.out.println(sql);
		
		//Realizar update
		int rowsAffected = -1;
		rowsAffected = this.jdbc.update(sql, 
				new Object[] {controlzoneMajor, controlzoneMinor, controlzoneEmplacement, controlzone_centerId});

		return rowsAffected;

	}
	
	/**
	 * Método que inserta una promoción en la BBDD
	 * @param promoName
	 * @param promoDescription
	 * @param promoSince
	 * @param promoTo
	 * @param promoImage
	 * @param promo_controlZoneId
	 * @param promoMinAge
	 * @param promoMaxAge
	 * @param promoGen
	 * @return int filasAfectadas - será 1 si la sentencia se ha realizado con éxito
	 */
	public int addPromo(String promoName, String promoDescription, String promoSince, String promoTo, String promoImage,
			int promo_controlZoneId, int promoMinAge, int promoMaxAge, String promoGen) {
		//necesito instanciar un objeto de la clase promo para poder llamar al método activePromo()
		//no afecta a nada más
		Promocion promo = new Promocion(promoName, promoDescription, promoSince, promoTo, promoImage, promoMinAge, promoMaxAge, promoGen, promo_controlZoneId);
		
		String sql = "INSERT INTO promos (promoName, promoDescription, promoSince, promoTo, promoCreate, promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promoState) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int filasAfectadas = jdbc.update(sql, new Object[] {promoName, promoDescription, promoSince, promoTo, Promocion.dateTimePromo(), promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promo.activePromo()});
		
		return filasAfectadas;
	}
	
	/**
	 * Método que inserta un centro en la BBDD
	 * @param centerName
	 * @param centerDescription
	 * @param centerAddres
	 * @param centerType
	 * @param centerSubtype
	 * @return
	 */
	public int addCentro(String centerName, String centerDescription, String centerAddres, String centerType,
			String centerSubtype) {
				
		String sql = "INSERT INTO centers (centerName, centerDescription, centerAddres, centerType, centerSubtype) VALUES (?,?,?,?,?)";
		int filasAfectadas = jdbc.update(sql, new Object[] {centerName, centerDescription, centerAddres, centerType,centerSubtype});
		
		return filasAfectadas;
	}
	
	
}
