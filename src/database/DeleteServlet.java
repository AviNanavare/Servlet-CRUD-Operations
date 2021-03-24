package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "jdbc:mysql://localhost:3306/testdatabase";
			String user = "root";
			String pass = "root";
			String driver = "com.mysql.cj.jdbc.Driver";
			int deleteId = 
				Integer.parseInt(request.getParameter("deleteId"));
			int fin = 0;
			
			try {
				Class.forName(driver);
		    	Connection con = DriverManager.getConnection(url,user,pass);
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();		
	        	PreparedStatement st = con.prepareStatement
	            		("Delete from employee where id=?"); 
	        	st.setInt(1, deleteId);
	        	fin = st.executeUpdate();
	        	
	            if(fin>0)
	            {
	            	out.println("<html><body><b>"
		            		+"Successful"+ "</b><br>"
		            		+fin+" Row's Deleted . . . "+ 
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
			
		}

}
