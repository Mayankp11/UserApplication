package com.apex.training;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection = null; 
	
	public void init(ServletConfig config) throws ServletException {
		 try {
			 ServletContext servletContext = config.getServletContext();
			 Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(servletContext.getInitParameter("connectionURL"),
						servletContext.getInitParameter("userName"), servletContext.getInitParameter("password"));
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			
	      }
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
		    // Use a PreparedStatement to prevent SQL injection
		    String query = "DELETE FROM user WHERE username = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, username);

		    int executeUpdate = preparedStatement.executeUpdate();
		    PrintWriter writer = response.getWriter();
		    response.setContentType("text/html");
		    
		    if (executeUpdate == 1) {
		        writer.append("User details deleted successfully!");
		    } else {
		        writer.append("Error deleting the user details.");
		    }

		    preparedStatement.close(); // Close the PreparedStatement instead of Statement
		} catch (SQLException e) {
		    e.printStackTrace();
		}


	}
	}
