/*package com.nacre.action;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;

*//**
 * @author Raghav Servlet implementation class ViewAjaxAction/To display the Refresh table of Project Records
 *//*
//@WebServlet("/ViewAjaxModuleAction")
public class ViewAjaxModuleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public ViewAjaxModuleAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ModuleManagementDelegate delegate=null;
		List<ProjectModuleDto> viewProjectList = null;
		Blob blob=null;
		String json=null;
		try {
			delegate=new ModuleManagementDelegate();
			//viewProjectList =delegate.viewMOdules();
			
			if(viewProjectList!=null && viewProjectList.size()>0){
				json = new Gson().toJson(viewProjectList);
				response.getWriter().write("{\"success\":"+json+"}");
				}else{
					response.getWriter().write("{\"err\":\"NO MODULES AVAILABLE\"}");			

				}
				
				//rd=req.getRequestDispatcher("jsp/AssignModuleTO_TeamLead.jsp");
				//req.setAttribute("Modules",list);
				//rd.forward(req,res);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.getWriter().write("{\"err\":\"PLEASE TRY LATER\"}");			

			} catch (NoConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.getWriter().write("{\"err\":\"PLEASE TRY LATER\"}");			

			}
				
		
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/