package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.ImageUtil;
import com.nacre.uitl.PooledConnection;

/**
 * Servlet implementation class ImageTest
 */
@WebServlet("/ImageTest")
public class ImageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//.append("Served at: ").append(request.getContextPath());
		PrintWriter out = 	response.getWriter();
		try {
			Connection con = PooledConnection.getConnection();
		try {
			PreparedStatement ps=  con.prepareStatement("select * from images");
			
		ResultSet rs=	ps.executeQuery();
		if(rs.next()){
	String s=		rs.getString(1);
	Blob b=		rs.getBlob(2);
			
byte[]b1 =	b.getBytes(1, (int)b.length());

	String img =ImageUtil.encodeImage(b1);
	out.println("<html>");

	out.println("<body>");

	out.println(s);
	out.print("<img src='"+img+"'>");

	out.println("</body>");
	out.println("</html>");
		}	
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
