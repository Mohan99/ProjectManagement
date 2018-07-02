package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.daoi.ModuleManagementDaoI;
import com.nacre.daoi.daoimpl.ModuleManagementDaoImpl;
import com.nacre.dto.ProjectModuleDto;

/**
 * Servlet implementation class GetModuleCompletePercentage
 */
@WebServlet("/GetModuleCompletePercentage")
public class GetModuleCompletePercentage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetModuleCompletePercentage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String cid=request.getParameter("cid");
		int s=Integer.parseInt(cid);
		ModuleManagementDaoI mm=new ModuleManagementDaoImpl();
		/*ProjectModuleDto p=mm.getModuleCompletePercentage(s);
		
		Gson g2=new Gson();
		String s2=g2.toJson(p);
		response.setContentType("text/json");
		pw.println(s2);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
