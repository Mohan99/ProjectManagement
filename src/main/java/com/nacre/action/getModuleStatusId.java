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
import com.nacre.dto.ProjectModuleDto;

/**@author Ram Babu
 * Servlet implementation class getModuleStatusId
 * 
 * Servlet for getting module status id
 */
@WebServlet("/getModuleStatusId")
public class getModuleStatusId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getModuleStatusId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String cid=request.getParameter("cid");
	
	System.out.println(cid);
	
	int i=Integer.parseInt(cid.trim());
	/*if(cid!=null)
	 i=Integer.parseInt(cid);*/
	System.out.println("get "+i);
	StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
	ProjectModuleDto pmd=d.getModulePercentage(i);
		System.out.println(pmd);
	Gson g2=new Gson();
	String s2=g2.toJson(pmd);
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
