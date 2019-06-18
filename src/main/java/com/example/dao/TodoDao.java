package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Todo;

public class TodoDao {
	private static String url = "jdbc:mysql://localhost:3306/jsp-jdbc-maven-todo";
	private static String username = "root";
	private static String password = "";
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Todo> showAllTodo() throws SQLException{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM todos");
		List<Todo> list = new ArrayList<Todo>();
		while(rs.next()) {
			Todo td = new Todo();
			td.setId(rs.getInt(1));
			td.setTodo(rs.getString(2));
			list.add(td);
		}
		return list;
	}
	
	public boolean deleteTodo(int id) throws SQLException {
		Statement st = conn.createStatement();
		boolean rowDeleted = st.executeUpdate("DELETE FROM Todos WHERE id="+id) > 0;
		return rowDeleted;
	}
	public boolean addTodo(String todo) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO todos(todo)VALUES(?)");
		st.setString(1, todo);
		boolean rowAdded = st.executeUpdate() > 0;
		return rowAdded;
		
	}
}
