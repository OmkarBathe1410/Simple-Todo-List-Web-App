package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import model.TodoItemBean;
import utils.DBConnection;

public class TodoItemsDAO {
	
	private static final String insertQuery = "INSERT INTO items(title, username, target_date, is_done) VALUES (?, ?, ?, ?)";
	private static final String deleteQuery = "DELETE FROM items WHERE id = ?";
	private static final String retrieveQuery = "SELECT * FROM items WHERE username = ?";
	
	public boolean insertItem(TodoItemBean todoItemBean) {
		Connection cn = DBConnection.getConnection();
		boolean status = false;
		
		try {
			PreparedStatement ps = cn.prepareStatement(insertQuery);
			ps.setString(1, todoItemBean.getTitle());
			ps.setString(2, todoItemBean.getUsername());
			ps.setDate(3, Date.valueOf(todoItemBean.getTargetDate()));
			ps.setBoolean(4, todoItemBean.getIsDone());
			
			status = ( ps.executeUpdate() > 0 );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean deleteItem(int id) {
		Connection cn = DBConnection.getConnection();
		boolean status = false;
		
		try {
			PreparedStatement ps = cn.prepareStatement(deleteQuery);
			ps.setLong(1, id);
			
			status = ( ps.executeUpdate() > 0 );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<TodoItemBean> getTodoItems(String username) {
		
		List<TodoItemBean> todoItems = new ArrayList<>();
		Connection cn = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = cn.prepareStatement(retrieveQuery);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				LocalDate targetDate = rs.getDate(3).toLocalDate();
				boolean isDone = rs.getBoolean(4);
				String username1 = rs.getString(5);
				
				TodoItemBean newTodoItem = new TodoItemBean();
				newTodoItem.setId(id);
				newTodoItem.setTitle(title);
				newTodoItem.setTargetDate(targetDate);
				newTodoItem.setIsDone(isDone);
				newTodoItem.setUsername(username1);
				
				todoItems.add(newTodoItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todoItems;
	}
	
}
