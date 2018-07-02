package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;

/**@author Ram Babu
 * Servlet implementation class TaskStatus
 * 
 * Servlet for getting projectModuleId
 */
@WebServlet("/TaskStatus")
public class TaskStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     * 
     *  
     */
    public TaskStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//System.out.println("work is done");

		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		int i=(int) session.getAttribute(StringConstants.SESSION_ROLE_CONSTANT);
		
		StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
			List<ProjectModuleDto> l;
			l = d.getModules(i);
			System.out.println(l);
			Gson g1=new Gson();
			String s1=g1.toJson(l);
			response.setContentType("text/json");
//				out.write(s1);
			out.println(s1);
		
			// TODO Auto-generated catch block
		
		
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
