package com.app.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UsersDAO;
import com.app.entity.Users;

public class UserServices {
	private UsersDAO usersDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		usersDAO = new UsersDAO();
		this.request = request;
		this.response = response;
	}
	
	public void listAll() throws ServletException, IOException {
		ListAll(null);
	}
	
	public void ListAll(String message) throws ServletException, IOException {
		List<Users> listUsers = usersDAO.listAll();
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

	public void editUser() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Users user = usersDAO.find(id);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		dispatcher.forward(request, response);
	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users emailUsersExits = usersDAO.findByEmail(email);
		if(emailUsersExits == null) {
			Users user = new Users();
			user.setEmail(email);
			user.setFullName(fullName);
			user.setPassword(password);
			user= usersDAO.create(user);
			ListAll("create success");
		}else {
			String messString = "email already exits";
			ListAll(messString);
		}
		
		
		
	}
	
	public void update() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Users user = usersDAO.find(id);
		user.setEmail(email);
		user.setFullName(fullName);
		user.setPassword(password);
		user = usersDAO.update(user);
		
		ListAll("update success");
	}

	public void delete() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		usersDAO.delete(id);
		ListAll("deletesuccess");
		
		
	}

	public void checkLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean result = usersDAO.checkLogin(email, password);
		if (result) {
			request.getSession().setAttribute("useremail", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}else {
			String message = "login failed";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void logout() throws ServletException, IOException {
		request.getSession().removeAttribute("useremail");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
		dispatcher.forward(request, response);
	}
	
	
	
	
}
