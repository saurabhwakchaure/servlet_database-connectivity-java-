package practice_servlet_database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/add_stud_details")
public class RegisterStud extends HttpServlet
{

		@Override
	   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	    {
		
	    	PrintWriter out=res.getWriter();
	    	String name=req.getParameter("stud_name");
	    	String age=req.getParameter("stud_age");
	    	String email=req.getParameter("stud_email");
	    	String password=req.getParameter("password");
	    	
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jsp_database","root","saurabh1412");
	    		PreparedStatement ps=con.prepareStatement("insert into practice_register values(?,?,?,?)");
	    		ps.setString(1, name);
	    		ps.setString(2,age);
	    		ps.setString(3, email);
	    		ps.setString(4,password);
	    		
	    		int count=  ps.executeUpdate();
	    	
	    		if(count>0) 
	    		{
	    			res.setContentType("text/html");
	    			RequestDispatcher rd=req.getRequestDispatcher("/Login.jsp");
	    			rd.include(req, res);
	    		}
	    		else 
	    		{
	    			res.setContentType("text/html");
	    			out.print("<h3> User not  Register </h3>");
	    			RequestDispatcher rd=req.getRequestDispatcher("/failed.jsp");
	    			rd.include(req, res);
	    		}
	    		
	    		
	    	}
	    	catch(Exception e) 
	    	{
	    		e.printStackTrace(out);
	    	  
	    		res.setContentType("text/html");
	    		out.print("<h3 style='color:red'> Exception occurd " +e.getMessage()+"</h3>");
	    		RequestDispatcher rd=req.getRequestDispatcher("/Register.jsp");
	    		rd.include(req, res);
	    	
	    	}
	  
	    }
	 
}
