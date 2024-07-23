import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/myntralogin")
public class myntralogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String number = req.getParameter("number");
		String pass = req.getParameter("pass");
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "select * from myntra.myntralogin where mobilenumber=? and password=?";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, number);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("myntrawebpage.html");
				dispatcher.include(req, resp);
				
			}
			else 
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("myntralogin.html");
				dispatcher.include(req, resp);

			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
