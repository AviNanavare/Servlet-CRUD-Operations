package database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {      
		int fin = 0;
    			try {
    				String url = "jdbc:mysql://localhost:3306/testdatabase";
    				String user = "root";
    				String pass = "root";
    				String driver = "com.mysql.cj.jdbc.Driver";
    				int id = Integer.parseInt(request.getParameter("updateId"));
    				String name = request.getParameter("updateName");
    				int age = Integer.parseInt(request.getParameter("updateAge"));
    				
    		    	Class.forName(driver);
    		    	Connection con = DriverManager.getConnection(url,user,pass);
        			response.setContentType("text/html");
        			PrintWriter out=response.getWriter();		
                	PreparedStatement st = con.prepareStatement
                			("update employee set name=? , age=? where Id=? ");
    	            st.setInt(3, id);
    	            st.setString(1, name);
    	            st.setInt(2, age);
    	            
    	            fin = st.executeUpdate();
    	            
    	            if(fin>0)
    	            {
    	            	out.println("<b>Successful</b><br>");
        	            out.println(fin+" Row's Updated . . .  ");
    	            }
    	            else
    	            {
    	            	out.println("<b>Unsuccessful</b><br>");
        	            out.println("Wrong Id . . . . .");
    	            }
    	     	  	            		
    	           out.println("<br><br></body></html>");
    	            
    	            st.close();
    	            con.close();
    	            
				} catch (Exception e) {
					e.printStackTrace();
				}
    } 

}
