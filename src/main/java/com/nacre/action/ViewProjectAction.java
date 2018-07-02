/**
 * 
 */
package com.nacre.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Level;

import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;

/**
 * @author Raghav  Servlet implementation class to get
 *         Record And Perform Edit,Delete Operation
 * 
 */
@WebServlet("/ViewProjectAction")
@MultipartConfig
public class ViewProjectAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ProjectManagementDelegate delegate=null;
		List<ProjectDto> viewProjectList = null;

		try {
			delegate=new ProjectManagementDelegate();
			viewProjectList =delegate.viewAllProjects();
			System.out.println(viewProjectList);
			
			session.setAttribute("viewProjects", viewProjectList);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/project/viweAddEditDelProject.jsp");
			
			
			rd.forward(request, response);
			/*for (ProjectDto list : viewProjectList) {
				System.out.println(list.getProjectTitle());
			}*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
