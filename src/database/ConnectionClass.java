package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection getConnection() throws 
	ClassNotFoundException, SQLException {
		 
		String url = "jdbc:mysql://localhost:3306/testdatabase";
		String user = "root";
		String pass = "root";
		String driver = "com.mysql.cj.jdbc.Driver";
		
    	Class.forName(driver);
    	Connection con = DriverManager.getConnection(url,user,pass);
        
        System.out.println("Connection Created...");
        
		return con; 
	}
}
