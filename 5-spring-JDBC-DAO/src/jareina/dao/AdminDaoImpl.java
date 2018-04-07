package jareina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import jareina.pojo.Admin;
import jareina.pojo.AdminRowMapper;

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
		
		
//		MapSqlParameterSource paraMap = new MapSqlParameterSource();
//		
//		paraMap.addValue("nombre", admin.getNombre());
//		paraMap.addValue("cargo", admin.getCargo());
//		paraMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		
		// si el nombre de las propiedades coinciden con la base de datos se puede
		// usarel objeto de abajo para mapearlo y no necesitar las cuatro lineas anteriores
		BeanPropertySqlParameterSource paraMap = new BeanPropertySqlParameterSource(admin);
		
		
		
		
		// : comodines 
		return jdbcTemplate.update("insert into Admin(nombre,cargo,fechaCreacion) values(:nombre,:cargo,:fechaCreacion)", paraMap) == 1;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Admin admin = new Admin();
				
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				admin.setNombre(rs.getString("nombre"));
				admin.setIdAd(rs.getInt("idAd"));
				
				return admin;
			}
			
		});
	}

	@Override
	public Admin encontrarPorId(int id) {
		// UNA FORMA DE HACERLO
//		return (Admin) jdbcTemplate.query("select * from Admin where idAd=:idAd", 
//				                           new MapSqlParameterSource("idAd",id), 
//				                           new AdminRowMapper());
		return jdbcTemplate.queryForObject("select * from Admin where idAd=:idAd", 
								               new MapSqlParameterSource("idAd",id), 
								               new AdminRowMapper());
	}

	@Override
	public List<Admin> encontrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from Admin where nombre like :nombre", 
	               new MapSqlParameterSource("nombre","%"+nombre+"%"), 
	               new AdminRowMapper());

	}

}
