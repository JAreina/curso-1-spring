package jareina;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;

import java.sql.PreparedStatement;



import java.sql.SQLException;
public class Conexion {
	
	///   CONEXION DE PRUEBA  sin spring 

		    public static void main(String[] args) throws Exception {
	
		  // Create a BasicDataSource object and configure database
	
		 
		  BasicDataSource dataSource = new BasicDataSource();
		 
	
		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	
		  dataSource.setUrl("jdbc:mysql://localhost:3306/spring-bd?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");

		  dataSource.setUsername("juan");

		  dataSource.setPassword("juan");

		  Connection conn = null;
	
		  PreparedStatement stmt = null;
	
		  try {
	
		// Get connection and execute a simple query
	
		conn = dataSource.getConnection();
	
		stmt = conn.prepareStatement("INSERT INTO Admin (nombre) values (?)");
		stmt.setString(1, "pepe");
	
		int rs = stmt.executeUpdate();
	
	
		    System.out.println("RESULTADO  : " + rs);
	
		
	
		 
	
		  } catch (SQLException e) {
	
		e.printStackTrace();
	
		  } finally {
	
		if (stmt != null) {
		    stmt.close();
	
		}
	
		if (conn != null) {
	
	
		}
	
		  }
	    }

}
