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
import com.nacre.dto.ProjectManagerProjectDto;

/**
 * Servlet implementation class GetAllProject
 * @author Biranchi 
 * 
 * Servlet for getting all project based on projectId
 */
@WebServlet("/GetAllProject")
public class GetAllProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		int i=  (int) session.getAttribute(StringConstants.SESSION_ROLE_CONSTANT);
				
				//PROVIDE ROLEID OF LOGGEG IN PERSONM
				//(int) session.getAttribute(" ");
		
		StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
		List<ProjectManagerProjectDto> l=d.getProjects(i);
		
		//l = d.getProjects(i);
		System.out.println(l);
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
