package com.nacre.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nacre.constants.StringConstants;
import com.nacre.daoi.daoimpl.TaskManagementDaoImpl;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoTaskAvailable;

/**
 * Servlet implementation class viewTaskAction
 */
/**
 * @author Raj Kishore Singh
 * 
 * to view  all the task into a tabular form 
 * 
 */

@WebServlet("/viewTaskAction")
public class ViewTaskAction extends HttpServlet {
	
	
	public static final Logger logger = 	Logger.getLogger(ViewTaskAction.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTaskAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate() ;

		try {
		List<ModuleTaskDto> tasks;
		
		try {
			HttpSession session = request.getSession();
			Integer uId = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			tasks = taskmanagementdelegate.viewTask(uId);
			request.setAttribute("tasks", tasks);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/viewTask.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoTaskAvailable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		} catch (DatabaseException e) {
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
