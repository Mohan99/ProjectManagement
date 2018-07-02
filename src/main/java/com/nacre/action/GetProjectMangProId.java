package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.ProjectDto;

/**
 * Servlet implementation class GetProjectMangProId
 * @author Biranchi
 * 
 * Servlet for getting project module Id
 */
@WebServlet("/GetProjectMangProId")
public class GetProjectMangProId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProjectMangProId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		System.out.println(cid);
		int i=Integer.parseInt(cid.trim());
	
		
		StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
		ProjectDto pd=d.getProjectPercentage(i);
		
		Gson g2=new Gson();
		String s2=g2.toJson(pd);
		response.setContentType("text/json");
		out.println(s2);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
