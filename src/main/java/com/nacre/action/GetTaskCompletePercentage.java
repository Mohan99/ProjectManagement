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
import com.nacre.dto.ModuleTaskDto;

/**
 * @author Pujitha
 * Servlet implementation class GetTaskCompletePercentage
 * This servlet for getting Previous TaskCompletionPercentage
 */
@WebServlet("/GetTaskCompletePercentage")
public class GetTaskCompletePercentage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTaskCompletePercentage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("hi task");
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String cid=request.getParameter("cid");
	int cid1=Integer.parseInt(cid.trim());
	
	StatusUpdationsDelegate tsu=new StatusUpdationsDelegate();
	ModuleTaskDto mtd=tsu.getTaskCompletionPercentage(cid1);
	System.out.println("hello task");
	Gson g3=new Gson();
	String s3=g3.toJson(mtd);
	response.setContentType("application/json");
	out.println(s3);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
