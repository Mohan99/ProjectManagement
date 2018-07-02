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
 * @author GANESH 
 * THIS CONTROLLER GET DATA FROM EDITUSER() USING AJAX CALL AND
 * UPDATES THE DATA IN TABLE THIS CONTROLLER WILL RETURN STATUS VALUE 
 * OF TYPE INTEGER TO THE AJAX CALL
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// READING THE VALUE FROM REQUEST AND ASSIGNING VALUES TO VARIABLES
		int userId = Integer.parseInt(request.getParameter("uid"));
		String fname = request.getParameter("First_name");
		String lname = request.getParameter("Last_name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("phone");

		// CREATING THE UserDelegate OBJECT 
		UserManagementDelegate uDelegate = null;
		String json = null;
		int status = 0;
		
		// CREATING THE UserDto OBJECT AND SETTING VALUES TO SETTERS 
		UserDto udto = new UserDto();
		udto.setUserId(userId);
		udto.setFirstName(fname);
		udto.setLastName(lname);
		udto.setEmail(email);
		udto.setMobileNo(mobile);

		try {
			
			// CREATING THE UserManagementDelegate OBJECT AND SETTING VALUES TO SETTERS 
			uDelegate = new UserManagementDelegate();
			
		    //CALLING editUser METHOD OF DELEGATE CALLS
			status = uDelegate.editUser(udto);

		} catch (NoConnectionException | SQLException e) {
			e.printStackTrace();
		}

		if (status != 0) {
			
			//SENDING DATA TO JSON OBJECT
			json = new Gson().toJson("data edited successfully");

		} else {

			json = new Gson().toJson("data not edited successfully");

			response.setContentType("application/json");

			response.getWriter().write(json);
		}

	}

}
