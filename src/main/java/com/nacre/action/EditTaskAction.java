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

import org.apache.log4j.Logger;

import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoTaskAvailable;

/**
 * Servlet implementation class EditTaskAction
 */
/**
 *@author Raj Kishore Singh
 *
 * to edit task details 
 */
@WebServlet("/EditTaskAction")
public class EditTaskAction extends HttpServlet {
	
	public static final Logger logger = 	Logger.getLogger(EditTaskAction.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("moduleTaskId"));
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate(id) ;
		
		try {
		ModuleTaskDto individualtasks;
		
		try {
			
			individualtasks = taskmanagementdelegate.viewIndividualTask(id);
			request.setAttribute("individualtask", individualtasks);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/editTask.jsp");
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
