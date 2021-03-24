package database;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DisplayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,  HttpServletResponse response)
    {      
		try{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/testdatabase","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from employee");	
        	
			PrintWriter out = response.getWriter();
			out.println();
			out.println("<html><body><table>");
			
			while(rs.next())
			{	
				out.println("<tr><td>"+rs.getInt(1)+
						" </td><td>"+ rs.getString(2)+ 
						"</td><td>"+rs.getInt(3)+"</td></tr>");
			}
			out.println("</table></body></html>");         
    	            st.close();
    	            con.close();
    	            
				} catch (Exception e) {
					e.printStackTrace();
				}
    } 

}
