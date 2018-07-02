package com.nacre.action;

import java.io.IOException;
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
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.TaskInfoBean;

/**
 * Servlet implementation class AddTaskAction
 * 
 * @author Chakravarthi k
 *  this servlet is used as controller for getting the task details which are yet to assign to a developer
 */
@WebServlet("/TaskAction")
public class NotAssignedTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(NotAssignedTaskAction.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotAssignedTaskAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskManagementDelegate delegate = null;
		List<TaskInfoBean> listDTO = null;
		String json = null;
		Integer teamLeadId=null;
		HttpSession session=null;
		delegate = new TaskManagementDelegate();
		listDTO = new ArrayList<>();
		session=request.getSession();
		teamLeadId=(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);

		try {
			
			listDTO = delegate.getNotAssignedTasks(teamLeadId);
		response.setContentType("application/json");
			json = new Gson().toJson(listDTO);
			response.getWriter().write(json);
		} catch (SQLException | NoConnectionException  e) {
			logger.error("Excepton Raised" + e.getMessage());
			response.setContentType("application/json");
			response.getWriter().write("[]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
