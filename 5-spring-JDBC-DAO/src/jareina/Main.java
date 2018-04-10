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

	
	
	public static void mostrar(Admin admin,AdminDao adminDao) {
		// LISTAR
					List<Admin> adminList = adminDao.findAll();
					
					for(Admin a : adminList) {
						System.out.println(a);
					}
	}
	
	public static Admin buscarPorId(int id,AdminDao adminDao) {
		Admin ad;
		ad = adminDao.encontrarPorId(id);
		System.out.println("ENCONTRADO POR ID: "+ ad.toString());
	    return ad;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");

		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
       
		
		Timestamp fecha = new Timestamp(new Date().getTime());
		
		Admin admin = new Admin();
		admin.setCargo("DESARROLLADOR");
		admin.setNombre("Juan excepciones Juan");
		admin.setFechaCreacion(fecha);
		

	
		
		try {
			
			// GUARDAR
			//adminDao.save(admin);
			//System.out.println("ADMINISTRADOR GURARDADO");
			
			
			//LISTAR
			
			//Main.mostrar(admin, adminDao);
			
             // BUSCAR POR ID
			Main.buscarPorId(1, adminDao);
			
			//buscar por nombre 
//			List<Admin> ad2;
//			ad2= adminDao.encontrarPorNombre("juan");
//			System.out.println("LISTADO ");
//			for(Admin a : ad2) {
//				
//				System.out.println(a);
//			}
//			
			// actualizar 
			Admin adminActualizado = adminDao.encontrarPorId(13);
			adminActualizado.setCargo("ACTUALIZADO");
			adminActualizado.setNombre("actualizado");
			System.out.println(adminActualizado.toString());
			adminDao.actualiza(adminActualizado);
			
			Admin a= Main.buscarPorId(adminActualizado.getIdAd(), adminDao);
			
			
			
			// BORRAR 
			boolean borrado = adminDao.borrar(a.getIdAd());
			
			System.out.print(borrado +"  BORRADO ----");
			
		} catch (CannotGetJdbcConnectionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
