package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.UserManagementDelegate;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 * @author SAGARKOMMU
 *  THIS CONTROLLER GET DATA FROM AN AJAX CALL AND PERSIST THAT DATA 
 *  THIS WILL RETURN STATUS VARIABLE OF TYPE INTEGER TO THE AJAX CALL
 */
@WebServlet("/AssignUsers")
public class AssignUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// READING THE VALUE FROM REQUEST AND ASSIGNING VALUES TO VARIABLES
		int devId = Integer.parseInt(request.getParameter("devId"));
		int tlId = Integer.parseInt(request.getParameter("tlId"));
		String page = request.getParameter("p");
		String json = null;
		int status = 0;
		
		// DECLARING THE UserDelegate OBJECT 
		UserManagementDelegate uDelegate = null;
		
		//DECLARING THE userDto OBJECT
		UserDto udto = null;
		UserDto sdto = null;
		
		
		// CREATING THE UserDto Object and Setting the values
		udto = new UserDto();
		sdto = new UserDto();
		udto.setUserId(devId);
		sdto.setUserId(tlId);
		udto.setSuperiorId(sdto);
		
		try {
			
			// CREATING THE UserManagementDelegate OBJECT  
			uDelegate = new UserManagementDelegate();
			status = uDelegate.assignUser(udto, page);

		} catch (NoConnectionException | SQLException e) {
			e.printStackTrace();
		}
		if (status == 1 && page.equals("teamlead")) {
			
			//SENDING DATA TO JSON OBJECT
			json = new Gson().toJson("assigned successfully");
			response.setContentType("application/json");
			response.getWriter().write(json);

		} else if (status == 1 && page.equals("teamlead")) {
			
			//SENDING DATA TO JSON OBJECT
			json = new Gson().toJson("assigned successfully");
			response.setContentType("application/json");
			response.getWriter().write(json);

		}

	}

}
