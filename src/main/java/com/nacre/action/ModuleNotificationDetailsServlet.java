package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.NotificationDelegate;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;

/**
 * Servlet implementation class TaskNotificationDetailsServlet
 * 
 * servlet for assigning task notification send redirect to jsp page
 */
@WebServlet("/moduleNotificationDetailsServlet")
public class ModuleNotificationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		PrintWriter out=response.getWriter();
		NotificationModuleStatusDetailsFormBean bean=null;
		
		NotificationDelegate delegate=null;
	
		try{
		
		
			bean=new NotificationModuleStatusDetailsFormBean(); 
			
			//Integer moduleId = Integer.parseInt(request.getParameter("moduleId"));
			
			delegate=new NotificationDelegate();
			
			bean=delegate.getModuleStatusNotification(Integer.parseInt(request.getParameter("moduleId")));//http://localhost:8181/ProjectManagement/moduleNotificationDetailsServlet?
			
			HttpSession session = request.getSession();
			
			session.setAttribute("bean", bean);
			System.out.println(bean);
			response.sendRedirect(getServletContext().getContextPath()+"/jsp/notificationModuleDetails.jsp");
			

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
