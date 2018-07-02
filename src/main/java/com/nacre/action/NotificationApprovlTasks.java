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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AssignTask;

/**
 * Servlet implementation class NotificationApprovlTasks
 */
@WebServlet("/NotificationApprovlTasks")
public class NotificationApprovlTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(NotificationAccepted.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationApprovlTasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/json");
		PrintWriter pw=response.getWriter();
		//int dti=Integer.parseInt(request.getParameter("devloperTaskId"));
		/*DeveloperTaskDto dti1= new DeveloperTaskDto();
		Integer sd= dti1.getDeveloperTaskId();*/
		NotificationDelegate nd= new NotificationDelegate();
		List<AssignTask> list=null;
		try {
			
			String dtId = request.getParameter("dtId");
			list =nd.getNotificationAssignedTaskCompleteInfo(Integer.parseInt(dtId));
			request.getSession().setAttribute("dtDet", list);
			request.getRequestDispatcher("jsp/DisplayCompleteTaskNotificationForDeveloper.jsp").forward(request,response);
			//nd.notificationAcceptedTask1();
		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
			
		} catch (SQLException e) {
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
