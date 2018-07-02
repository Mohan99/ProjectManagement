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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectStatus;

/**
 * Servlet implementation class ProjectSeenStatus
 * 
 * @author Thejaswi
 * 
 * Servlet updating project status
 */
@WebServlet("/ProjectStatusurl")
public class NotificationProjectStatus extends HttpServlet {
	private static final Logger logger = Logger.getLogger(NotificationAssignProject.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationProjectStatus() {
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
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		 NotificationDelegate delegate = new NotificationDelegate();
		 List<ProjectStatus> list=new ArrayList();
		 
		 System.out.println("Notification called");
		 	
				try {
						list=delegate.getNotificationProjectStatus();
					
					System.out.println(list+"action....");
					Gson g = new Gson();
					String json =	g.toJson(list);
						logger.info(json+".........json");
						out.print(json);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
}
}
