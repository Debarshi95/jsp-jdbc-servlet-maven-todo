package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.TodoDao;
import com.example.model.Todo;

/**
 * Servlet implementation class TodoServlet
 */
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try{
			if(action.equals("/showTodos")) {
				showTodos(request, response);
			}
			else if(action.equals("/deleteTodo")) {
				deleteTodo(request, response);
			}else if(action.equals("/addTodo")) {
				addTodo(request, response);
			}else if(action.equals("/")) {
				response.sendRedirect("showTodos");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	protected void showTodos(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		TodoDao td = new TodoDao();
		List<Todo> list = null;
		try {
			list = td.showAllTodo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("showTodos.jsp");
		rd.forward(request, response);
	}
	protected void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TodoDao td = new TodoDao();
		td.deleteTodo(id);
		response.sendRedirect("showTodos");
		
	}

	protected void addTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String todo = request.getParameter("todo");
		TodoDao td = new TodoDao();
		td.addTodo(todo);
		response.sendRedirect("showTodos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
