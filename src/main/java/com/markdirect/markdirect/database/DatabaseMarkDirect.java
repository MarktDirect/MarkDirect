package com.markdirect.markdirect.database;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.beans.Administrador;
import com.markdirect.markdirect.beans.CategoriaNivel1;
import com.markdirect.markdirect.beans.CategoriaNivel2;
import com.markdirect.markdirect.beans.Centro;
import com.markdirect.markdirect.beans.Producto;
import com.markdirect.markdirect.beans.ProductoReducido;
import com.markdirect.markdirect.beans.Promocion;
import com.markdirect.markdirect.beans.Usuario;
import com.markdirect.markdirect.beans.Zona;
import com.mysql.fabric.xmlrpc.base.Array;

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
			System.out.println("Error en la consulta de listar promociones" + e.getMessage());
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
			int promo_controlZoneId, int promoMinAge, int promoMaxAge, String promoGen, int promo_catNivel1, int promo_catNivel2, long promo_idProduct) {
		//necesito instanciar un objeto de la clase promo para poder llamar al método activePromo()
		//no afecta a nada más
		Promocion promo = new Promocion(promoName, promoDescription, promoSince, promoTo, promoImage, promoMinAge, promoMaxAge, promoGen, promo_controlZoneId, promo_catNivel1, promo_catNivel2, promo_idProduct);
		
		String sql = "INSERT INTO promos (promoName, promoDescription, promoSince, promoTo, promoCreate, promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promoState, promo_catNivel1, promo_catNivel2, promo_idProduct) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int filasAfectadas = jdbc.update(sql, new Object[] {promoName, promoDescription, promoSince, promoTo, Promocion.dateTimePromo(), promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promo.activePromo(), promo_catNivel1, promo_catNivel2, promo_idProduct});
		

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

	//TODO método para editar una promoción

	/** 
	 * Método que devuelve una lista de todas las promociones genéricas activas, 
	 * sin filtros
	 * @return List<Promocion> - todas las promociones genéricas
	 */
	public List<Promocion> allGenericPromos() {
		String sql = "SELECT * FROM promos WHERE promo_controlzoneId = 0";
		List<Promocion> listaPromociones = null;
		try {
			listaPromociones = jdbc.query(
					sql, 
					new BeanPropertyRowMapper<Promocion>(Promocion.class)
					);	
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones genéricas");
		}
		return listaPromociones;
	}

	/**
	 * Método que devuelve una lista de las promociones genéricas activas, pero filtradas 
	 * según el género del usuario y su edad
	 * @param promoGen - género de la persona
	 * @param userAge - edad de la persona
	 * @return List<Promocion> - promociones que le corresponden en función al filtro realizado
	 */
	public List<Promocion> filteredGenericPromos(String promoGen, int userAge) {
		String sql = "SELECT * FROM promos WHERE promo_controlzoneId = 0 AND promoGen = ? AND promoMinAge < ? AND promoMaxAge > ? AND promoState = 1";
		List<Promocion> listaPromociones = null;
		try {
			listaPromociones = jdbc.query(
					sql, 
					new BeanPropertyRowMapper<Promocion>(Promocion.class), new Object[]{promoGen, userAge, userAge}
					);	
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones genéricas filtradas");
		}
		return listaPromociones;
	}

	/**
	 * Método que devuelve una lista de las promociones según la localización del usuario y sus
	 * características personales (género y edad) - sólo las que estén activas
	 * @param promoGen - género del usuario
	 * @param userAge - edad del usuario
	 * @param controlzoneMajor - major de la zona de control
	 * @param controlzoneMinor - minor de la zona de control
	 * @return List<Promocion> - promociones que le corresponden en función al filtro realizado
	 */
	public List<Promocion> listLocationPromos(String promoGen, int userAge, String controlzoneMajor, String controlzoneMinor) {
		//TODO añadir un contador para contar las notificaciones específicas que recibe un usuario
		/*Hay una consulta SELECT anidada, ya que necesitamos obtener la id de 
		la zona de control desde los major/minor que nos vienen de la app móvil*/
		String sql = "SELECT * FROM promos "
				+ "WHERE promo_controlzoneId = (SELECT controlzoneId FROM controlzones WHERE controlzoneMajor = ? AND controlzoneMinor = ?) "
				+ "AND promoGen = ? AND promoMinAge < ? AND promoMaxAge > ? AND promoState = 1";
		List<Promocion> locationPromos = null;
		try {
			locationPromos = jdbc.query(
					sql, 
					new BeanPropertyRowMapper<Promocion>(Promocion.class), new Object[]{controlzoneMajor, controlzoneMinor, promoGen, userAge, userAge}
					);	
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones de localización");
		}
		return locationPromos;
	}

	//Metodo para bloquear usuarios de momento sin conectar a la DB
	public List<Usuario> BloquearUsuario(String[] usuariosbloqueados){

		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int i=0;i<listausuario.size();i++){
			if(usuariosbloqueados[i].equals(listausuario.get(i).getUserEmail())){
				System.out.println("usuario bloqueado "+ listausuario.get(i).getUserEmail());
			}else{
				System.out.println("no bloquea");
			}
		}

		return  listausuario;

	}

	//Tuve que hacer dos metodos para bloquear usuarios ya que habia problema si solo bloqueaba uno
	//Saltaba una excepcion de arraylist al hacer el split
	public List<Usuario> BloquearUsuario(String userblock){

		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int i=0;i<listausuario.size();i++){
			if(userblock.equals(listausuario.get(i).getUserEmail())){
				System.out.println("usuario bloqueado "+ listausuario.get(i).getUserEmail());
			}else{

				System.out.println("no bloquea");
			}
		}

		return  listausuario;

	}

	/**
	 * Método que consulta las Las categorías de nivel 2 de la BBDD y devuelve un Json
	 * @return List<CategoriaNivel2> listaCatNiv2
	 */
	public List<CategoriaNivel2> listarCategoriasNivel2() {
		String sql = "SELECT * FROM categoriasnivel2";
		List<CategoriaNivel2> listaCatNiv2 = null;
		
		try{
			listaCatNiv2 = jdbc.query(sql, new BeanPropertyRowMapper<CategoriaNivel2>(CategoriaNivel2.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}
		
		return listaCatNiv2;
	}

	/**
	 * Método que consulta Las categorías de nivel 1 de la BBDD y devuelve un Json 
	 * @return List<CategoriaNivel1> listaCatNiv1
	 */
	public List<CategoriaNivel1> listarCategoriasNivel1() {
		String sql = "SELECT * FROM categoriasnivel1";
		List<CategoriaNivel1> listaCatNiv1 = null;
		
		try{
			listaCatNiv1 = jdbc.query(sql, new BeanPropertyRowMapper<CategoriaNivel1>(CategoriaNivel1.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}
		
		return listaCatNiv1;
	}

	/**
	 * Método que consulta los pruductos de la BBDDy devuelve un Json
	 * @return List<Producto> listaProductos
	 */
	public List<Producto> listarProductos() {
		String sql = "SELECT * FROM productos";
		List<Producto> listaProductos = null;
		
		try{
			listaProductos = jdbc.query(sql, new BeanPropertyRowMapper<Producto>(Producto.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}
		
		return listaProductos;
	}

	public List<ProductoReducido> listarProductosReducidos() {
		String sql = "SELECT  FROM productos";
		List<ProductoReducido> listaProductosReducidos = null;
		
		try{
			listaProductosReducidos = jdbc.query(sql, new BeanPropertyRowMapper<ProductoReducido>(ProductoReducido.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}
		return listaProductosReducidos;
	}

	
}
