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

import com.nacre.constants.StringConstants;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoTaskAvailable;

/**
 * Servlet implementation class ViewDeveloperTaskAction
 */



/**
 * @author Raj Kishore Singh
 * 
 * to view  Developer all  tasks into a tabular form 
 * 
 */

@WebServlet("/ViewDeveloperTaskAction")
public class ViewDeveloperTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDeveloperTaskAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate() ;

		try {
		List<DeveloperTaskDto> tasks;
		
		try {
			HttpSession session = request.getSession();
			Integer uId = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			tasks = taskmanagementdelegate.viewDeveloperTask(uId);
			request.setAttribute("tasks", tasks);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/viewDevTask.jsp");
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
