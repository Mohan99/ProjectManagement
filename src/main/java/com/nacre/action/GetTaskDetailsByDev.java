package com.nacre.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.daoi.daoimpl.TaskManagementDaoImpl;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;

/**
 * @author Chakravarthi K
 * 
 * to view  all the tasks assigned to a developer 
 * 
 */

@WebServlet("/GetTaskDetailsByDev")
public class GetTaskDetailsByDev extends HttpServlet {
	
	
	public static final Logger logger = 	Logger.getLogger(ViewTaskAction.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTaskDetailsByDev() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<ModuleTaskDto>list=new ArrayList<>();
		//response.setContentType("application/json");
		UserDto udto=new UserDto();
		HttpSession session=request.getSession();
		 //String id = ses.getId();
		 PrintWriter pw=response.getWriter();
		 // pw.println("Session Id is : " + id);
		  Integer uid=null;
		  uid=(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);

		TaskManagementDelegate del=new TaskManagementDelegate();
		try {
			System.out.println("get task details===========================");
			list=del.getTaskDetails(uid);
			
request.setAttribute("tasks", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/tasksList.jsp");
			rd.forward(request, response);		} catch (NoConnectionException | SQLException e) {
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
