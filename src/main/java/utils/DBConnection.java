package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String dbURL = "jdbc:mysql://localhost:3306/todo";
	private static String dbUsername = "root";
	private static String dbPassword = "OmkarBathe@1410";
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return cn;
	}
}
