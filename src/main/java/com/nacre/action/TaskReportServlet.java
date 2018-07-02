/**
 * @author Ankush Vyavhare
 *
 */

package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.delegate.ReportsDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class TaskReportServlet
 */
@WebServlet("/TaskReportServlet")
public class TaskReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<UserDto> list=null;
		HttpSession session=null;
		ModuleTaskDto mdto=null;
		ReportsDelegate delegate=null;
		UserDto udto=null;
		String json=null;
		
		mdto=new ModuleTaskDto();
		
		//create Delegates Object
		delegate =new ReportsDelegate();
		
		
		//get the Session
		session=request.getSession(false);
		
		//Prepare DTO 
		udto=new UserDto();
	
		
			
		//udto.setUserId(Integer.parseInt(request.getParameter("id")));
		 ProjectModuleDto d=new ProjectModuleDto();
		 d.setProjectModuleId(Integer.parseInt(request.getParameter("id")));
		mdto.setProjectModuleId(d);
		
		
		response.setContentType("application/json");
		
		try {
			list=delegate.displayTaskReport(d);
			json=new Gson().toJson(list);
			
			//set the Content type
			
			response.getWriter().write(json);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("[]");
			
		}
		
		//create Json Object
	
	
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
