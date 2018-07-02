package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;

/**
 * Servlet implementation class ViewModuleInfoAction this class is used to
 *   display module info
 *   @author pavan kumar y
 */
@WebServlet("/viewmoduleinfo")
public class ViewModuleInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewModuleInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModuleManagementDelegate mmd=null;
		HttpSession session=null;
		ModuleManagementFormBean bean=null;
		mmd = new ModuleManagementDelegate();
		response.setContentType("text/html");
		int moduleId=Integer.parseInt(request.getParameter("mid"));
			try {
				 bean= mmd.viewModuleInfo(moduleId);
				response.getWriter().println("dgsdgs"+bean.getProjectDto().getProjectTitle());
				if(bean !=null){
					session = request.getSession();
					session.setAttribute("moduleInfo",bean);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/viewModuleInfo.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoConnectionException e) {
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





















