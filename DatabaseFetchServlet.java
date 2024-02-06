

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

@WebServlet("/DatabaseFetchServlet")
public class DatabaseFetchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final String URL = "jdbc:mysql://localhost:3306/entd481";
	final String USER = "root";
	final String PASSWORD = "root";
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	Connection conn = null;
	
	public void init() throws ServletException {
		
		// Database Connection with Driver Manager
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//Set response content type and get the PrintWriter object.
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			//Set HTML Table formatting
			out.println("<html><body>");
			out.println("<h3>Database Details</h3>");
			out.println("<table border=1><tr>" + "<td><b>Employee Name</b></td>"
					+ "<td><b>Salary</b></td>" + "<td><b>Job</b></td></tr>");
			
			//Create JDBC statement Object, create SQL query and execute query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			
			//Loop through result set to get data
			while (rs.next()) {
				
				out.println("<tr>" + "<td>" + rs.getString("Employee Name") + "</td>" +
						"<td>" + rs.getInt("Salary") + "</td>" +
						"<td>" + rs.getString("Job") + "</td></tr>");
			}
			out.println("</table></body></html>");
			
			
			//Close result set, statement, and printwriter
			rs.close();
			stmt.close();
			out.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		
		//Close connection object
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
