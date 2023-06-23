package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginBean;
import dao.LoginDAO;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	
	@Override
	public void init() throws ServletException {
		loginDAO = new LoginDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginBean lb = new LoginBean();
		lb.setUsername(username);
		lb.setPassword(password);
		
		String forwardUrl;
		if(loginDAO.login(lb)) {
			forwardUrl = "/getItems";
			req.setAttribute("username", username);
		} else {
			forwardUrl = "/login/login.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardUrl);
		dispatcher.forward(req, resp);
	}
}










