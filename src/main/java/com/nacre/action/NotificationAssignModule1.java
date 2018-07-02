package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.NotificationDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AssignModule;

/**
 * Servlet implementation class NotificationAssignModule1
 *
 * @author Thejaswi
 * 
 * Servlet for assign module notification send redirect to jsp page
 */
@WebServlet("/NotificationAssignModule1")
public class NotificationAssignModule1 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationAssignModule1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/application");
		PrintWriter out=response.getWriter();
		 NotificationDelegate delegate = new NotificationDelegate();
		 List<AssignModule> list=new ArrayList();
		 
		 System.out.println("Notification called");
						try {
							Integer mId =Integer.parseInt(request.getParameter("projectModuleId"));
							list=delegate.getNotificationAssignModule(mId);
							HttpSession session = request.getSession();
							session.setAttribute("moduledetails", list);
							response.sendRedirect(getServletContext().getContextPath()+"/jsp/NotificationAssignModuleDetails.jsp");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoConnectionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
	}

}
