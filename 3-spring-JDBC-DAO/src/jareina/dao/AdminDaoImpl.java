package jareina.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import jareina.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	// plantilla para evitar sql inyeccion
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Admin admin) {
		
		
		MapSqlParameterSource paraMap = new MapSqlParameterSource();
		
		paraMap.addValue("nombre", admin.getNombre());
		paraMap.addValue("cargo", admin.getCargo());
		paraMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		// : comodines 
		return jdbcTemplate.update("insert into Admin(nombre,cargo,fechaCreacion) values(:nombre,:cargo,:fechaCreacion)", paraMap) == 1;
	}

}
