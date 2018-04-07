package jareina;

import java.util.Date;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jareina.dao.AdminDao;
import jareina.pojo.Admin;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");

		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
       
		
		Timestamp fecha = new Timestamp(new Date().getTime());
		
		Admin admin = new Admin();
		admin.setCargo("DESARROLLADOR");
		admin.setNombre("Juan Juan");
		admin.setFechaCreacion(fecha);
		

		if(adminDao.save(admin)) {
			System.out.println("ADMINISTRADOR GURARDADO");
		}else {
			System.out.println("no GURARDADO");
		}
		
		
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
