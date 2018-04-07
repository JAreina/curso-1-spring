package jareina;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import jareina.dao.AdminDao;
import jareina.pojo.Admin;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");

		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
       
		
		Timestamp fecha = new Timestamp(new Date().getTime());
		
		Admin admin = new Admin();
		admin.setCargo("DESARROLLADOR");
		admin.setNombre("Juan excepciones Juan");
		admin.setFechaCreacion(fecha);
		

	
		
		try {
			adminDao.save(admin);
			System.out.println("ADMINISTRADOR GURARDADO");
			
			
			List<Admin> adminList = adminDao.findAll();
			
			for(Admin a : adminList) {
				System.out.println(a);
			}
			
			
		} catch (CannotGetJdbcConnectionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
