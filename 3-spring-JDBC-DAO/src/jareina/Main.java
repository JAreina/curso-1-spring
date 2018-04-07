package jareina;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jareina.pojo.Admin;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");

		
		
        Admin admi = (Admin) applicationContext.getBean("admin");
      //  admi.imprimir();
        
        System.out.println(admi);
        ((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
