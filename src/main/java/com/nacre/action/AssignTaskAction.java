package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class AddTaskAction
 * 
 * @author Chakravarthi k
 *  this servlet is used as controller for assigning a particular task to a specific developer
 */
@WebServlet("/AssignTaskAction")
public class AssignTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AssignTaskAction.class);
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTaskAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		DeveloperTaskDto devDto = null;
		TaskManagementDelegate delegate = null;
		String json = null;
		ModuleTaskDto tDto = null;
		UserDto udto = null;
		StatusDto status = null;

		logger.debug(request.getParameter("taskId"));
		logger.debug(request.getParameter("uId"));

		udto = new UserDto();
		devDto = new DeveloperTaskDto();
		status = new StatusDto();
		status.setStatusId(8);
		tDto = new ModuleTaskDto();
		tDto.setModuleTaskId(Integer.parseInt(request.getParameter("taskId")));
		udto.setUserId(Integer.parseInt(request.getParameter("uId")));
		devDto.setDeveloperId(udto);
		devDto.setModuleTaskId(tDto);
		devDto.setApprovalStatusId(status);
		Boolean msg = false;

		delegate = new TaskManagementDelegate();

		try {
			msg = delegate.assignTaskToDeveloper(devDto);
			logger.debug(msg);
			if(msg){
			//request.setAttribute("result", msg);
				
				response.getWriter().write("{\"success\":\"SUCCESSFULLY ASSIGNED\"}");
					
			}else{
				
				response.getWriter().write("{\"err\":\"PROBLEM OCCURED FAILED TO ASSIGN\"}");
				
			}
			
		} catch (SQLException | NoConnectionException e) {
			logger.error("Exception raised" + e.getMessage());
			request.setAttribute("err", "unable to process please try again later");

			response.getWriter().write("{\"err\":\"unable to process please try again later\"}");
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
