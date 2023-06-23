package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginBean;
import utils.DBConnection;

public class LoginDAO {
	public boolean login(LoginBean lb) {
		boolean isLoggedIn = false;
		
		Connection cn = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?");
			ps.setString(1, lb.getUsername());
			ps.setString(2, lb.getPassword());
			
			ResultSet rs = ps.executeQuery();
			isLoggedIn = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isLoggedIn;
	}
}
