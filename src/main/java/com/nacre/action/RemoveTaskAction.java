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
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;

/**
 * Servlet implementation class RemoveTaskAction
 */

/**
 *@author Raj Kishore Singh
 *
 *to set status as removed for removing task
 *
 *
 */
@WebServlet("/RemoveTaskAction")
public class RemoveTaskAction extends HttpServlet {
	
	public static final Logger logger = 	Logger.getLogger(RemoveTaskAction.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTaskAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate() ;
        int moduletaskid=Integer.parseInt(request.getParameter("moduleTaskId"));
        boolean res=false;
        
		try {
			res=taskmanagementdelegate.removeTaskDetails(moduletaskid);
			
			
			if(res)
			{
				

				request.getSession().setAttribute("result", "Task Removed Successfully");
			/*RequestDispatcher rd=request.getRequestDispatcher("/viewTaskAction");
			rd.forward(request, response);
			*/
			}
			else
			{
				

				request.getSession().setAttribute("err", "Task not Removed ");

			}
			
		}catch (Exception e) {
			// TODO: handle exception
			  e.getMessage();

				request.getSession().setAttribute("err", "PEASE TRY LATER");
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/viewTaskAction");
		
			/*RequestDispatcher rd=request.getRequestDispatcher("/viewTaskAction");
			rd.forward(request, response);*/
		
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
