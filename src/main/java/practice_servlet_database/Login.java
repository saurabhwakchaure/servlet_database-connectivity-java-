package practice_servlet_database;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
         
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jsp_database", "root", "saurabh1412");

            
            if (con != null) {
                out.println("<h3>Connection successful!</h3>");
            } else {
                out.println("<h3>Connection failed!</h3>");
            }

            
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM practice_register");
            ResultSet rs = pstmt.executeQuery();

            //<--fetch all records>
            /*out.println("<style>");
            out.println("table { width: 50%; margin: auto; border-collapse: collapse; font-family: Arial, sans-serif;}");
            out.println("th, td { border: 1px solid black; padding: 10px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
            out.println("tr:hover { background-color: #f1f1f1; }");
            out.println("</style>");

            out.println("<h2 style='text-align: center;'>Student Details</h2>");
            out.println("<table>");
            out.println("<tr><th>Name</th><th>Age</th><th>Email</th><th>Password</th></tr>");

            while (rs.next()) 
            {
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("age") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");*/
            
          //<--check login details>
            
            boolean result=false;
            while(rs.next())
            {
            	String check_username=rs.getString("email");
            	String check_password=rs.getString("password");
            	
            	if(check_username.equals(username) && check_password.equals(password))
            	{
            		result=true;
            	}
            	
            }
            
            if(result==true)
            {
            	out.println("<h1>login successful</h1>");
            }
            else
            {
            	out.println("<h1>login not successful</h1>");
            }
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace(out);
            
        } 
    }
}
