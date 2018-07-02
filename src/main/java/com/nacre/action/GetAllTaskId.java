package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.DeveloperTaskDto;

/**
 * @author Pujitha
 * Servlet implementation class GetAllTaskId
 * 
 * This Servlet for getting TaskId from DataBase
 */
@WebServlet("/GetAllTaskId")
public class GetAllTaskId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllTaskId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("get all TaskId");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		int i=(int) session.getAttribute(StringConstants.SESSION_ROLE_CONSTANT);
		
		StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
		List<DeveloperTaskDto> l=d.getAllTaskId(i);
		System.out.println("hi"+"  "+l);
		Gson g1=new Gson();
		String s1=g1.toJson(l);
		response.setContentType("text/json");
		out.println(s1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
