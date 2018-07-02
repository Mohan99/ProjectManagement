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
import com.nacre.formbean.TaskViewInfoBean;

/**
 * Servlet implementation class ViewTaskDetailsAction
 * 
 * 
 */


/**
 * @author Raj Kishore Singh
 * 
 * to view details of particular  task  
 * 
 */
@WebServlet("/ViewTaskDetailsAction")
public class ViewTaskDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Logger logger = 	Logger.getLogger(ViewTaskDetailsAction.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTaskDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(request.getParameter("moduleTaskId"));
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate() ;
         
		try {
		  
			TaskViewInfoBean beans;
		
		try {
			beans= taskmanagementdelegate.viewTaskDetails(id);
			request.setAttribute("beans", beans);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/viewTaskDetails.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoTaskAvailable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
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
