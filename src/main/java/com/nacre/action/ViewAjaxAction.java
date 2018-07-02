package com.nacre.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ProjectDto;

/**
 * Servlet implementation class ViewAjaxAction
 */
@WebServlet("/ViewAjaxAction")
public class ViewAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAjaxAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ProjectManagementDelegate delegate=null;
		List<ProjectDto> viewProjectList = null;

		try {
			delegate=new ProjectManagementDelegate();
			viewProjectList =delegate.viewAllProjects();
			session.removeAttribute("viewProject");
			session.setAttribute("viewProject", viewProjectList);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/project/viweAddEditDelProject.jsp");
			rd.forward(request, response);
			/*for (ProjectDto list : viewProjectList) {
				System.out.println(list.getProjectId()+"------>"+list.getProjectTitle());
			}*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
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
