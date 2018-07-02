package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.daoi.ProjectManagementDaoI;
import com.nacre.daoi.daoimpl.ProjectManagementDaoImpl;
import com.nacre.dto.ProjectDto;

/**
 * Servlet implementation class GetProjectCompletionPercentage
 */
//@WebServlet("/GetProjectCompletionPercentage")
public class GetProjectCompletionPercentage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProjectCompletionPercentage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String cid=request.getParameter("cid");
		int s=Integer.parseInt(cid);
		ProjectManagementDaoI mm=new ProjectManagementDaoImpl();
/*		//ProjectDto p=mm.getProjectCompletePercentage(s);
		
		Gson g4=new Gson();
		String s4=g4.toJson(p);
		response.setContentType("text/json");
		pw.println(s4);
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
