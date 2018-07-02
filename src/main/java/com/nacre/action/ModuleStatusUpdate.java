package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class ModuleStatusUpdate
 * 
 * Servlet for updating module status
 */
@WebServlet("/ModuleStatusUpdate")
public class ModuleStatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleStatusUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String statusinfo;
		String difficulties;
		int moduleTaskId;
		int seenStatusId;
		/*String updationDate1;*/
	   int	ModuleCompletionPercentage;
	   int ProjectModuleId;
		
	   PrintWriter out=response.getWriter();
	   ProjectModuleId=Integer.parseInt(request.getParameter("hidden1").trim());
	   System.out.println("ProjectModuleId:"+ProjectModuleId);
	   ModuleCompletionPercentage=Integer.parseInt(request.getParameter("percentage"));
		 statusinfo=request.getParameter("module_status");
		difficulties=request.getParameter("difficulties");
		/*updationDate1=request.getParameter("updationDate");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = null;
		try{
			date = sdf1.parse(updationDate1);
		//java.sql.Date updationDate = new java.sql.Date(date.getTime());  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		Date date=new Date();
		
		ModuleStatusDto m=new ModuleStatusDto();
		m.setDificulties(difficulties);
		m.setStatusInfo(statusinfo);
		m.setUpdationDate(date);
		
		ProjectModuleDto p=new ProjectModuleDto();
		
		p.setProjectModuleId(ProjectModuleId);
		m.setProjectModuleId(p);
		 StatusUpdationsDelegate  d=new  StatusUpdationsDelegate ();
		
		 int s = 0;
		 try {
			 s=d.Percentage_Completion_Module(m , ModuleCompletionPercentage); 
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String success=null;
		if(s!=0)
		{
			System.out.println("ModuleStatus inserted");
			success="ModuleStatus is updated into DataBase";
			request.getSession().setAttribute("success", success);
		}
		else
		{
			
			System.out.println("ModuleStatus is not inserted");
			success="ModuleStatus is not updated into DataBase";
			request.getSession().setAttribute("err", success);
			
		}
		response.sendRedirect("jsp/modulelist.jsp");
		
		/*request.setAttribute("Biranchi", s);
		request.getRequestDispatcher("/ProjectManagement/WebContent/jsp/ModuleStatus.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
