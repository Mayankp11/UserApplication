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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ViewUserData
 */
public class ViewUserData extends HttpServlet {
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
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			String query = "Select * from user;";
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			
//			int executeUpdate = statement.executeUpdate("Select * user");
			PrintWriter writer = response.getWriter();
            response.setContentType("text/html");
            
            writer.println("<html><body>");
			writer.println("<h2>User Data</h2>");
			writer.println("<table border='1'>");
			writer.println("<tr><th>First Name</th><th>Last Name</th><th>Username</th><th>Password</th></tr>");
            
            while (resultSet.next()) {
				writer.println("<tr>");
				writer.println("<td>" + resultSet.getString("firstName") + "</td>");
				writer.println("<td>" + resultSet.getString("lastName") + "</td>");
				writer.println("<td>" + resultSet.getString("username") + "</td>");
				writer.println("<td>" + resultSet.getString("password") + "</td>");
				writer.println("</tr>");
			}

            writer.println("</table>");
			writer.println("</body></html>");
            resultSet.close();
            
//                if (executeUpdate == 1) {
//                    writer.append("User details updated successfully!");
//                } else {
//                    writer.append("Error updating the user details.");
//                }
//			
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
