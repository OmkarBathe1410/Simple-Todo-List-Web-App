package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import dao.UserDAO;

@WebServlet("/register")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserBean ub = new UserBean();
		ub.setFirstName(firstName);
		ub.setLastName(lastName);
		ub.setUsername(username);
		ub.setPassword(password);
		
		boolean result = userDAO.registerUser(ub);
		if(result) {
			req.setAttribute("username", username);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/getItems");
			dispatcher.forward(req, resp);
		}
	}
	
}






