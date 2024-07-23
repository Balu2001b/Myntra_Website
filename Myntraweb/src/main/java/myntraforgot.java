import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/myntraforgot")
public class myntraforgot extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String number = req.getParameter("number");
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		
		String url ="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "update myntra.myntralogin set password=? where mobilenumber=?";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, pass2);
			ps.setString(2, number);
			int num = ps.executeUpdate();
			PrintWriter pw = resp.getWriter();
			if (num > 0 ) 
			{
				pw.println("Password Updated Successfully...!!!");
				
			} else 
			{
				pw.println("In-valid Details");

			}
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
