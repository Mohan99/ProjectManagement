package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.exception.NoConnectionException;

/**
 * @author Raghav Servlet implementation class Delete MentorAction
 *         
 */
@WebServlet("/DeleteProjectAction")
public class DeleteProjectAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=false;
		int projectId=Integer.parseInt(request.getParameter("txtprojectId"));
		/*System.out.println("projectId:"+projectId);*/
		ProjectManagementDelegate delegate=null;
		try {
			delegate=new ProjectManagementDelegate();
			flag=delegate.deleteProject(projectId);
			
			if(flag){
				System.out.println("Deleted Successfully");
				request.setAttribute("deleteMentor", "Deleted Successfully");
				response.getWriter().println("Deleted Successfully");
				
			}
			else{
				System.out.println("Deletion Failed");
				request.setAttribute("deleteMentor", "Deletion Failed");
				response.getWriter().println("Deletion Failed");
			}
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
