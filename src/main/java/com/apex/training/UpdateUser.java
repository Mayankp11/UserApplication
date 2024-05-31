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
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
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

	/**
	 * @see Servlet#destroy()
	 */
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
			Statement statement = connection.createStatement();
			
			int executeUpdate = statement.executeUpdate("update user set password='"+password+"' where username='"+username+"'");
			PrintWriter writer = response.getWriter();
            response.setContentType("text/html");
                if (executeUpdate == 1) {
                    writer.append("User details updated successfully!");
                } else {
                    writer.append("Error updating the user details.");
                }
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
