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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AssignProject;

/**
 * Servlet implementation class NotificationAssignProject
 * 
 * @author Thejaswi
 * 
 * Servlet Notification for Assign Project
 */
@WebServlet("/NotificationAssignProjecturl")
public class NotificationAssignProject extends HttpServlet {
	private static final Logger logger = Logger.getLogger(NotificationAssignProject.class);
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationAssignProject() {
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
		 List<AssignProject> list=new ArrayList();
		 HttpSession session = request.getSession();
		 System.out.println("Notification called");
		 
		 try {
				Integer uid =	(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
				UserDto dto = new UserDto();
				dto.setUserId(uid);
			list=delegate.getNotificationAssignProject(dto);
			System.out.println(list+"action....");
		Gson g = new Gson();
		String json =	g.toJson(list);
			logger.info(json);
			out.println(json);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("[]");

			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("[]");

		}
		  
	}

}
