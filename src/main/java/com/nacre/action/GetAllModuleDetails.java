package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleBean;
/**
 *@author sindhu Servlet implementation class getallmoduledetails
 */

@WebServlet("/GetAllModuleDetails")
public class GetAllModuleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int mid=Integer.parseInt(request.getParameter("projectmoduleid"));
	 ModuleBean bean=new ModuleBean();
	 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ModuleManagementDelegate delegate=new ModuleManagementDelegate();
		try {
			bean=delegate.getAllModuleDetails(mid);
			System.out.println(bean);
			//request.setAttribute("pmdto", pmdto);
					
		} catch (NoConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		 RequestDispatcher dispatcher = 
//				   request.getRequestDispatcher("/jsp/getalldetails.jsp");
//		 dispatcher.forward(request, response);
		HttpSession ses=request.getSession();
		ses.setAttribute("bean", bean);
		response.sendRedirect(getServletContext().getContextPath()+"/jsp/getalldetails1.jsp");
	}

	
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
