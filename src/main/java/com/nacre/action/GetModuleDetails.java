package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 *@author sindhu Servlet implementation class getmoduledetails
 *
 */

@WebServlet("/GetModuleDetails")
public class GetModuleDetails extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProjectModuleDto>list=new ArrayList<ProjectModuleDto>();
		response.setContentType("application/json");
		UserDto udto=new UserDto();
		HttpSession ses=request.getSession(false);
		 //String id = ses.getId();
		 PrintWriter pw=response.getWriter();
		 // pw.println("Session Id is : " + id);
		  int uid= (int) ses.getAttribute(StringConstants.SESSION_USERID_CONSTANT);  
		ModuleManagementDelegate del=new ModuleManagementDelegate();
		try {
			list=del.getModuleDetails(uid);
			System.out.println(list);
			Gson gson = new Gson();
			String jsonString = gson.toJson(list);
			System.out.println(list+",,,,,,,,,,,,,,,,,,,acion");
			pw.write(jsonString);	
		} catch (NoConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
