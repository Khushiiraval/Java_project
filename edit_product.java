package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class edit_product
 */
@WebServlet("/edit_product")
public class edit_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String id= request.getParameter("id");
		String pname= request.getParameter("pname"); 
		String price= request.getParameter("price");
    	try
		{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String updateSQL = "UPDATE Product SET pname=?,price=? WHERE id=?";
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
    		PreparedStatement pst=  con.prepareStatement(updateSQL);
    		pst.setString(1,pname);
    		pst.setString(2,price);
    		pst.setString(3,id);
    		pst.executeUpdate();
    		out.println("Product Updated");
    		out.println("<a href =\"display_product\">Product Books</a>");
    		System.out.print("Product Updated");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
  
	}

}
