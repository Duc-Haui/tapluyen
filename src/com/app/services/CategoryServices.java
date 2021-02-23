package com.app.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CategoryDAO;
import com.app.entity.Category;
import com.app.entity.Users;

public class CategoryServices {
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
		categoryDAO = new CategoryDAO();
		this.request = request;
		this.response = response;
	}
	
	public void listAll() throws ServletException, IOException {
		ListAll(null);
	}
	
	public void ListAll(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
		dispatcher.forward(request, response);
	}
	
	public void editCategory() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Category category = categoryDAO.find(id);
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_form.jsp");
		dispatcher.forward(request, response);
	}

	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category category = new Category();
		category.setName(name);
		category = categoryDAO.create(category);
		ListAll("create success");
	}
	
	public void update() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		Category category = categoryDAO.find(id);
		category.setName(name);
		
		category = categoryDAO.update(category);
		
		ListAll("update success");
	}

	public void delete() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(id);
		ListAll("deletesuccess");
		
		
	}
	
	
}
