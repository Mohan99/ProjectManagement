package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class NotificationUpdateTask
 */
@WebServlet("/NotificationUpdateTask")
public class NotificationUpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationUpdateTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out=  response.getWriter();//.append("Served at: ").append(request.getContextPath());
		 NotificationDelegate nd = new NotificationDelegate();
		 boolean res;
		 try{

String st=	request.getParameter("dtId");
Integer dtId =Integer.parseInt(st) ;
	String accept = request.getParameter("isAccept");
			System.out.println(">>>>>>>>>>."+accept);
	res=nd.updateStatus(dtId,accept);
		 if(res){
			 out.println("{\"success\":\"SUCCESS\"}");
			 
		 }else{
			 out.println("{\"fail\":\"FAILED\"}");
			  
			 
		 }
	
	
		 }catch (NoConnectionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				out.println("{\"err\":\"FAILED\"}");
				  
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("{\"err\":\"FAILED\"}");
			  
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
