package com.project.spring.testjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJdbcServlet
 */
@WebServlet("/TestJdbcServlet")
public class TestJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// define database username
		String user = "MyProjects";
		
		// define database password
		String pass = "myprojects";
		
		// define JDBC url
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/web_customer_tracker2?useSSL=false";
		
		// define jdbc driver
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			// get the PrintWriter object
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database : " + jdbcUrl);
			
			// define ClassForName
			Class.forName(driver);
			
			// define Connection object
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Connection Success !!!");
			
			// close the connection
			
			myConn.close();
			
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}









