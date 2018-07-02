package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.NotificationDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AssignProject;

/**
 * Servlet implementation class NotificationAssignProject1
 * 
 * @author Thejaswi
 * 
 * Servlet for assign project notification send redirect to jsp page
 */
@WebServlet("/NotificationAssignProject1")
public class NotificationAssignProject1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationAssignProject1() {
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
		 List<AssignProject> list=new ArrayList();
		 
		 System.out.println("Notification called");
		 
		 
			try {
				Integer pId =Integer.parseInt(request.getParameter("projectId"));
				list=delegate.getNotificationAssignProject(pId);
				System.out.println(list+"action....");
				HttpSession session = request.getSession();
				session.setAttribute("projectdetails", list);
				response.sendRedirect(getServletContext().getContextPath()+"/jsp/NotificationAssignProjectDetails.jsp");
			} catch (SQLException | NoConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
