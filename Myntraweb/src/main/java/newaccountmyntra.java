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
@WebServlet("/newaccountmyntra")
public class newaccountmyntra extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String number = req.getParameter("number");
		String pass = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String gender = req.getParameter("gender");
		String loc = req.getParameter("loc");
		
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "insert into myntra.myntralogin values(?,?,?,?,?)";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, number);
			ps.setString(2, pass);
			ps.setString(3, mail);
			ps.setString(4, gender);
			ps.setString(5, loc);
			
			int num = ps.executeUpdate();
			PrintWriter pw = resp.getWriter();
			if (num > 0) 
			{
				pw.println("Account Created Successfully...!!!");
			}
			else 
			{
				pw.println("In-valid Credentials...!!!");

			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
