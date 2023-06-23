package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBean;
import utils.DBConnection;

public class UserDAO {
	
	private static final String insertQuery = "INSERT INTO users(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
	
	public boolean registerUser(UserBean ub) {
		boolean isRegistered = false;
		
		Connection cn = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = cn.prepareStatement(insertQuery);
			ps.setString(1, ub.getFirstName());
			ps.setString(2, ub.getLastName());
			ps.setString(3, ub.getUsername());
			ps.setString(4, ub.getPassword());
			
			int rs = ps.executeUpdate();
			isRegistered = (rs != 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isRegistered;
	}
}
