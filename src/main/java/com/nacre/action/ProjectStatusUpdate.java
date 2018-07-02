package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class ProjectStatusUpdate
 * 
 * @author Biranchi 
 * 
 * Servlet for Updating the project status
 */
@WebServlet("/ProjectStatusUpdate")
public class ProjectStatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectStatusUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String statusInfo;
		String difficulties;
		/*String updationDate1;*/
		int projectCompletionPercentage;
		int projectManagerProjectId;
		
		//getting data from ui page
		 statusInfo=request.getParameter("project_status");
		 difficulties=request.getParameter("difficulties");
		 //wrapping String data to Integer type
		 projectCompletionPercentage=Integer.parseInt(request.getParameter("percentage"));
		 projectManagerProjectId=Integer.parseInt(request.getParameter("hidden1").trim());
		
		 System.out.println(projectManagerProjectId);
		 //getting date value from ui page
	/*	 updationDate1=request.getParameter("updationDate");*/
		//creating SimpleDateFormat object
		/* SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		 //creating the object of java.util.Date class object
		 java.util.Date date1 = null;
		 try {
			 //parsing simpleDateFormat to util Date Format
			date1 = sdf1.parse(updationDate1);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 //creating the object of ProjectStatusDto class
		ProjectStatusDto pr=new ProjectStatusDto();
		pr.setStatusInfo(statusInfo);
		pr.setDifficulties(difficulties); 
		Date date=new Date();
		pr.setUpdationDate(date);
		
		ProjectManagerProjectDto pm=new ProjectManagerProjectDto();
		pm.setProjectManagetProjectId(projectManagerProjectId);
		pr.setProjectManagerProjectId(pm);
		StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
		int s1=0;
		try {
			
			HttpSession session = request.getSession();
	Integer	userId=	(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			//setting the object of P_M_P_Dto to the below method and passing to delegate layer
			s1=d.Percentage_Completion_Project(pr, projectCompletionPercentage,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String success=null;
		
		if(s1>0)
		{
			System.out.println("ProjectStatus inserted");
			success="ProjectStatus is updated into DataBase";
			request.getSession().setAttribute("success", success);
			response.sendRedirect("ViewProjectByManager");
		}
		else
		{
			System.out.println("ProjectStatus inserted");
			success="ProjectStatus is not updated into DataBase";
			request.getSession().setAttribute("success", success);
			response.sendRedirect("ViewProjectByManager");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
