package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.TaskStatusDto;
import com.nacre.formbean.NotificationFormBean;

/**
 * Servlet implementation class TaskNotificationDetailsServlet
 * 
 * servlet for assigning task notification send redirect to jsp page
 */
@WebServlet("/taskNotificationDetailsServlet")
public class TaskNotificationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		PrintWriter out=response.getWriter();
		NotificationFormBean bean=null;
		
		NotificationDelegate delegate=null;
	
		try{
		
		
			bean=new NotificationFormBean(); 
			
			Integer taskId = Integer.parseInt(request.getParameter("taskId"));
			
			delegate=new NotificationDelegate();
			
			bean=delegate.getNotificationTaskSeenStatusDetails(taskId);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("taskDetails", bean);
			
			response.sendRedirect(getServletContext().getContextPath()+"/jsp/notificationDetails.jsp");
			

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
