package com.markdirect.markdirect.database;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.beans.Administrador;
import com.markdirect.markdirect.beans.CategoriaNivel1;
import com.markdirect.markdirect.beans.CategoriaNivel2;
import com.markdirect.markdirect.beans.Centro;
import com.markdirect.markdirect.beans.ListaPromosJSON;
import com.markdirect.markdirect.beans.Producto;
import com.markdirect.markdirect.beans.ProductoReducido;
import com.markdirect.markdirect.beans.Promocion;
import com.markdirect.markdirect.beans.Usuario;
import com.markdirect.markdirect.beans.Zona;
import com.mysql.fabric.xmlrpc.base.Array;

public class DatabaseMarkDirect extends DatabaseGenerica {

	//Atributos
	private JdbcTemplate jdbc;

	public static final String BASE_DATOS = "MarkDirect";

	//Constructor
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
			String controlzoneEmplacement){

		//String con la consulta insert
		String sql = "INSERT INTO controlzones (controlzoneMajor, controlzoneMinor," +
				"controlzoneEmplacement, controlzone_centerId) VALUES (?,?,?,1)";

		//Realizar update
		int rowsAffected = -1;
		rowsAffected = this.jdbc.update(sql, 
				new Object[] {controlzoneMajor, controlzoneMinor, controlzoneEmplacement});

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
			int promo_controlzoneId, int promoMinAge, int promoMaxAge, String promoGen, int promo_catNivel1, int promo_catNivel2, long promo_idProduct) {
		//necesito instanciar un objeto de la clase promo para poder llamar al método activePromo()
		//no afecta a nada más
		Promocion promo = new Promocion(promoName, promoDescription, promoSince, promoTo, promoImage, promoMinAge, promoMaxAge, promoGen, promo_controlzoneId, promo_catNivel1, promo_catNivel2, promo_idProduct);

		String sql = "INSERT INTO promos (promoName, promoDescription, promoSince, promoTo, promoCreate, promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen, promoState, promo_catNivel1, promo_catNivel2, promo_idProduct) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int filasAfectadas = jdbc.update(sql, new Object[] {promoName, promoDescription, promoSince, promoTo, Promocion.dateTimePromo(), promoImage, promo_controlzoneId, promoMinAge, promoMaxAge, promoGen, promo.activePromo(), promo_catNivel1, promo_catNivel2, promo_idProduct});


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

	public int editPromos(int promoId, String promoName, String promoDescription, String promoSince, String promoTo, String promoImage,
			int promo_controlzoneId, int promoMinAge, int promoMaxAge, String promoGen, int promo_catNivel1, int promo_catNivel2, long promo_idProduct) {
		String sql= "UPDATE `promos` SET `promoName`= ?,`promoDescription`= ?,`promoSince`= ?,"
				+ "`promoTo`= ?,`promoImage`= ?,`promoMinAge`= ?,"
				+ "`promoMaxAge`= ?,`promoGen`= ?,`promo_controlzoneId`= ?,`promo_catNivel1`= ?,"
				+ "`promo_catNivel2`= ?,`promo_idProduct`= ? WHERE promoId = ?";
		int filasAfectadas = jdbc.update(sql, new Object[]{promoName, promoDescription, promoSince, promoTo, promoImage, promoMinAge, promoMaxAge,
				promoGen, promo_controlzoneId, promo_catNivel1, promo_catNivel2, promo_idProduct, promoId});
		return filasAfectadas;
	}
	
	public int deletePromo(int promoId){
		System.out.println("Estoy en el m�todo de eliminar promociones");
		String sql = "DELETE FROM promos WHERE promoId = ?";
		int filasAfectadas = jdbc.update(sql, new Object[]{promoId});
		System.out.println(filasAfectadas);
		return filasAfectadas;
	}

	/**
	 * Método que devuelve una lista de las promociones genéricas activas, pero filtradas 
	 * según el género del usuario y su edad
	 * @param promoGen - género de la persona
	 * @param userAge - edad de la persona
	 * @return List<Promocion> - promociones que le corresponden en función al filtro realizado
	 */
	public List<Promocion> getGenericPromos(String token) {
		List<Promocion> listaPromociones = null;
		Usuario user = new Usuario();
		//primero debemos obtener los datos del usuario en función del token que recibimos
		String sqlUser = "SELECT userGen, userAge FROM users WHERE userId = (SELECT id_user FROM usertoken WHERE token = ?)";
		try {
			user = jdbc.queryForObject(sqlUser, new BeanPropertyRowMapper<Usuario>(Usuario.class),
					new Object[] {token});
		} catch(EmptyResultDataAccessException e) {
			System.out.println("Error al seleccionar el género y edad del usuario");

		}
		//A continuación, podemos realizar la consulta para obtener las promociones
		String sql = "SELECT * FROM promos WHERE promo_controlzoneId = 0 AND (promoGen = ? OR promoGen = 'Todos') AND promoMinAge < ? AND promoMaxAge > ? AND promoState = 1";
		try {
			listaPromociones = jdbc.query(
					sql, 
					new BeanPropertyRowMapper<Promocion>(Promocion.class), new Object[]{user.getUserGen(), user.getUserAge(), user.getUserAge()}
					);	

			//Ahora vamos a contabilizar las promociones que se han enviado
			String sqlSentPromo = "INSERT INTO sentpromos (id_promo, user_token) VALUES (?, ?)";
			int filas = 0;
			for (Promocion promocion : listaPromociones) {
				filas += jdbc.update(sqlSentPromo, new Object[]{promocion.getPromoId(), token});
			}
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones genéricas filtradas por que" + e);
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
	public List<Promocion> listLocationPromos(String token, String controlzoneMajor, String controlzoneMinor) {
		//Al igual que en el método de las promociones genéricas, tenemos que primero coger los datos característicos del usuario
		String sqlUser = "SELECT userGen, userAge FROM users WHERE userId = (SELECT id_user FROM usertoken WHERE token = ?)";
		Usuario user = jdbc.queryForObject(sqlUser, new BeanPropertyRowMapper<Usuario>(Usuario.class),
				new Object[] {token});
		/*Hay una consulta SELECT anidada, ya que necesitamos obtener la id de 
		la zona de control desde los major/minor que nos vienen de la app móvil*/
		String sql = "SELECT * FROM promos "
				+ "WHERE promo_controlzoneId = (SELECT controlzoneId FROM controlzones WHERE controlzoneMajor = ? AND controlzoneMinor = ?) "
				+ "AND (promoGen = ? OR promoGen = 'Todos') AND promoMinAge < ? AND promoMaxAge > ? AND promoState = 1";
		List<Promocion> locationPromos = null;
		try {
			locationPromos = jdbc.query(
					sql, 
					new BeanPropertyRowMapper<Promocion>(Promocion.class), new Object[]{controlzoneMajor, controlzoneMinor, user.getUserGen(), user.getUserAge(), user.getUserAge()}
					);	
			//Tenemos que crear ahora un contador que almacene las ofertas que recibe cada persona
			for (Promocion promocion : locationPromos) {
				//Para cada promoción específica que le enviamos al usuario, insertamos en la tabla contadora
				//la promoción enviada y el usuario que la ha recibido - nos servirá para plantear métricas
				String sqlCounter = "INSERT INTO sentpromos (id_promo, user_token) VALUES (?,?)";
				int filasAfectadas = jdbc.update(sqlCounter, new Object[]{promocion.getPromoId(), token});
				if(filasAfectadas == locationPromos.size()) {
					System.out.println("Se han insertado tantas filas como elementos hay en la lista de promociones enviadas");
				}
			}
		}catch(Exception e) {
			System.out.println("Error en la consulta de listar promociones de localización");
		}
		return locationPromos;
	}


	/**
	 * Metodo para bloquear a varios usuarios se recibe un array de string
	Y bloquea a los usuarios que coincidan con el array
	 * @param usuariosbloqueados
	 * @return devuelve una lista de los usuarios que han sido bloqueados
	 */
	public List<Usuario> bloquearUsuario(String[] usuariosbloqueados){

		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int j=0;j<usuariosbloqueados.length;j++){//Se hacen dos for para poder comprobar un array con la lista de usuarios
			for(int i=0;i<listausuario.size();i++){
				if(usuariosbloqueados[j].equals(listausuario.get(i).getUserEmail())){
					String sql="UPDATE users SET userBlock='1' WHERE userEmail='"+usuariosbloqueados[j]+"'";
					jdbc.update(sql);

				}
			}
		}

		return  listausuario;

	}


	/**
	 * Metodo para desbloquear varios usuarios
	 * @param usuariosdesbloqueados
	 * @return devuelve una lista de los usuarios desbloqueados
	 */
	public List<Usuario> desbloquearUsuario(String[] usuariosdesbloqueados){

		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int j=0;j<usuariosdesbloqueados.length;j++){//Se hacen dos for para poder comprobar un array con la lista de usuarios
			for(int i=0;i<listausuario.size();i++){
				if(usuariosdesbloqueados[j].equals(listausuario.get(i).getUserEmail())){
					String sql="UPDATE users SET userBlock='0' WHERE userEmail='"+usuariosdesbloqueados[j]+"'";
					jdbc.update(sql);

				}
			}
		}
		return  listausuario;
	}


	/**
	 *Segundo metodo para bloquear solo un usuario
 Este se ejecuta al saltar la  excepcion de arraylist al hacer el split
	 * @param userblock
	 * @return una lista de usuarios que han sido bloqueados
	 */
	public List<Usuario> bloquearUsuario(String userblock){
		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int i=0;i<listausuario.size();i++){
			if(userblock.equals(listausuario.get(i).getUserEmail())){
				System.out.println("usuario bloqueado "+ listausuario.get(i).getUserEmail());
				String sql="UPDATE users SET userBlock='1' WHERE userEmail='"+userblock+"'";
				jdbc.update(sql);
				usuario.listarUsuarios();		
			}
		}

		return  listausuario;
	}

	/**
	 * Segundo metodo para desbloquear usuarios en este caso para uno solo
	 * como el de bloqueo
	 * @param userdesblock
	 * @return devuelve una lista de los usuarios desbloqueados
	 */
	public List<Usuario> desBloquearUsuario(String userdesblock){
		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		List<Usuario> listausuario=usuario.listarUsuarios();
		for(int i=0;i<listausuario.size();i++){
			if(userdesblock.equals(listausuario.get(i).getUserEmail())){
				System.out.println("usuario bloqueado "+ listausuario.get(i).getUserEmail());
				String sql="UPDATE users SET userBlock='0' WHERE userEmail='"+userdesblock+"'";
				jdbc.update(sql);
				usuario.listarUsuarios();		
			}
		}

		return  listausuario;
	}


	/**
	 *Metodo para registrar usuario en la base de datos
	 * @param email
	 * @param password
	 * @param sex
	 * @param age
	 * @param socialNetwork
	 * @return un 1 si el usuario ha sido registrado
	 */
	public int registrarUsuario(String email, String password, String sex, int age, String socialNetwork){
		int usuario = 0;
		String SQL = "insert into users (userEmail,userGen,userAge,userPass, socialNetwork) values (?,?,?,?,?)";
		try{
			usuario=jdbc.update(SQL,email,sex,age,password, socialNetwork);
		} catch(EmptyResultDataAccessException e) {
			System.out.println("Error al registrar usuario");
		}
		return usuario;
	}


	/**
	 *Con este metodo saco la idmax del usuario que haya en la base de datos
	  Con ello me aseguro de colocarle el token a la id correcta
	 * @return devuelve un entero que equivale a la idmax de la tabla usuario
	 */
	public int idmaxUsuario(){
		int idmax;
		String sql="SELECT MAX(userid) AS id FROM users";
		idmax=jdbc.queryForInt(sql);
		return idmax;
	}


	/**
	 * Metodo que inserta un token al ultimo usuario registrado
	 * @param idusermax
	 * @param token
	 * @return devuelve una lista con el token del ultimo usuario registrado
	 */
	public List<Map<String, Object>> insertarToken(int idusermax, String token){
		List<Map<String, Object>> tokeninsertado = null;
		int numtoken;
		String sql="insert into usertoken(id_user,token) VALUES (?,?)";
		numtoken=jdbc.update(sql,idusermax,token);
		if(numtoken==1){
			DatabaseMarkDirect db = new DatabaseMarkDirect();
			tokeninsertado=db.sacarToken(idusermax);
		}
		return tokeninsertado;

	}

	/**
	 * Método que consulta las Las categorías de nivel 2 de la BBDD y devuelve un Json
	 * @return List<CategoriaNivel2> listaCatNiv2
	 */
	public List<CategoriaNivel2> listarCategoriasNivel2() {
		String sql = "SELECT * FROM level2categories";
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
		String sql = "SELECT * FROM level1categories";
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
		String sql = "SELECT * FROM products";
		List<Producto> listaProductos = null;

		try{
			listaProductos = jdbc.query(sql, new BeanPropertyRowMapper<Producto>(Producto.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}

		return listaProductos;
	}


	/**
	 * Metodo que devuelve una lista de los productos reducidos
	 * @return una lista con los productos que se encuentren con sus precios reducidos
	 */
	public List<ProductoReducido> listarProductosReducidos() {
		String sql = "SELECT id, productName, id_level2Category, id_level1Category FROM products";
		List<ProductoReducido> listaProductosReducidos = null;

		try{
			listaProductosReducidos = jdbc.query(sql, new BeanPropertyRowMapper<ProductoReducido>(ProductoReducido.class));
		} catch(Exception e){
			System.out.println("Error en la consulta " + e);
		}
		return listaProductosReducidos;
	}



	/**
	 *Metodo para sacar una lista del token del ultimo usuario registrado
	  y lo devuelve en una lista
	 * @param idusermax
	 * @return devuelve una lista en la que esta el token del usuario recien registrado
	 */
	public List<Map<String, Object>> sacarToken(int idusermax){
		List<Map<String, Object>> token;
		String sql="select token from usertoken where id_user="+idusermax+"";
		token=jdbc.queryForList(sql);
		System.out.println(token);
		return token;
	}



	/**
	 * Este metodo saca la id de usuario que contenga el email y password correctos
	 * @param email
	 * @param password
	 * @return devuelve la id del usuario que se esta intentando loquear
	 */
	public int userLogin(String email, String password){
		int usuario = 0;
		String sql = "SELECT userId FROM users WHERE userEmail = ? AND userPass = ?";
		usuario = jdbc.queryForInt(sql,email,password);
		return usuario;
	} 

	/**
	 * Este metodo es para sacar el token segun la idusuario enviada por el login
	 * @param idusuario
	 * @return devuelve una lista con el token del usuario que se esta intentando loguear para darle su token
	 */
	public List<Map<String, Object>> sacarTokenUserLogin(int idusuario){
		List<Map<String, Object>> tokenUser;
		String sql="select token from usertoken where id_user= ?";
		tokenUser=jdbc.queryForList(sql,idusuario);
		return tokenUser;
	}

	/**
	 * Metodo que saca a la red social que pertenece el usuario que tenga el email recibido
	 * @param email
	 * @return devuelve un string que contiene a que red social pertenece el usuario
	 */
	public String socialNetwork(String email){
		List<Map<String, Object>> netdevuelta=null;
		String stringSocial="";
		String redsocial="";
		String sql="SELECT socialNetwork FROM users WHERE userEmail = ?";
		netdevuelta=jdbc.queryForList(sql,email);
		for (Map<String, Object> map : netdevuelta) {
			stringSocial = map.toString();
			redsocial = stringSocial.substring(15, stringSocial.length()-1);
		}

		return redsocial;
	}


	/**
	 * Metodo que saca la idusuario que contenga dicho email
	 * @param email
	 * @return devuelve la id de usuario que tenia dicho email
	 */
	public int comprobarEmail(String email){
		int usuario = 0;
		String sql = "SELECT userId FROM users WHERE userEmail = ?";
		usuario = jdbc.queryForInt(sql,email);
		return usuario;
	} 


	/**
	 * Metodo para editar una zona de control 
	 * @param idzona
	 * @param controlzoneMajor
	 * @param controlzoneMinor
	 * @param controlzoneEmplacement
	 * @return devuelve un 1 si la secuencia sql se ha ejecutado bien y ha editado la zona
	 */
	public int editarZonaControl( int idzona,String controlzoneMajor, String controlzoneMinor, String controlzoneEmplacement){
		String sql="UPDATE controlzones SET controlzonemajor=?,controlzoneMinor=?,controlzoneEmplacement=? where controlzoneId=?";
		int agregarzona = jdbc.update(sql, new Object[]{controlzoneMajor,controlzoneMinor,controlzoneEmplacement,idzona});
		return agregarzona;

	}

	/**
	 * Metodo para eliminar una zona de control mediante su id
	 * @param idzona
	 * @return devuelve un 1 si la consulta ha tenido exito y se ha eliminado
	 */
	public int eliminarZonaControl( int idzona){
		String sql="DELETE FROM controlzones where controlzoneId=?";
		int eliminarzona = jdbc.update(sql,idzona);
		return eliminarzona;

	}
}
