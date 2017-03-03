package com.markdirect.markdirect.database;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.beans.Administrador;
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
			System.out.println("Error en la consulta");
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
	
	//Metodo que devuelve un objeto segun la peticion creada y comprueba si el usuario existe o no 
	public  Administrador login(String usuario,String password){
		Administrador admin=new Administrador();
			String sql = "SELECT*FROM admins WHERE admin= ? AND adminPassword=?";
			admin = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Administrador>(Administrador.class),
					new Object[]{usuario,password});
		return admin;
	}
	
	
	

}
