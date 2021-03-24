package database;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class InsertData extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {      
		int fin = 0;
    			try {
    				String url = "jdbc:mysql://localhost:3306/testdatabase";
    				String user = "root";
    				String pass = "root";
    				String driver = "com.mysql.cj.jdbc.Driver";
    				
    		    	Class.forName(driver);
    		    	Connection con = DriverManager.getConnection(url,user,pass);
        			response.setContentType("text/html");
        			PrintWriter out=response.getWriter();		
        			
                	PreparedStatement st = con.prepareStatement
    	            		("insert into employee values(?, ?, ?)"); 
                	
    	            st.setInt(1,Integer.parseInt(request.getParameter("id"))); 
    	            st.setString(2,request.getParameter("name")); 
    	            st.setInt(3,Integer.parseInt(request.getParameter("age")));
    	            fin = st.executeUpdate();
    	            
    	            if(fin>0)
    	            {
    	            	out.println("<html><body><b>"
        	            		+"Successful"+ "</b><br>"
        	            		+fin+" Row's Inserted . . . "+ 
        	            		"<br><br>"+   	            		
        	            		"</body></html>");
    	            }
    	            else
    	            {
    	            	out.println("<html><body><b>"
        	            		+"Unsuccessful"+ "</b><br>"
        	            		+"Wrong Id . . . . ."+ 
        	            		"<br><br>"+   	            		
        	            		"</body></html>");
    	            }
    	            
    	            st.close();
    	            con.close();
    	            
				} catch (Exception e) {
					e.printStackTrace();
				}
	            System.out.println(fin+"Row's Added . . . ");
    } 
} 