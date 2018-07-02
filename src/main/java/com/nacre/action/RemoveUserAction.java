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
 * @author  GANESH
 *  THIS CONTROLLER GET DATA FROM AN AJAX CALL AND IT WILL
 * RETURN UserDto OBJECT FROM DATABASE BASED ON SEARCH TO THE AJAX CALL
 * 
 */
@WebServlet("/RemoveUserAction")
public class RemoveUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// DECLARING THE UserManagementDelegate OBJECT
		UserManagementDelegate uDelegate = null;

		UserDto udDto = null;
		String json = null;
		int count = 0;	
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		// CREATING UserDto OBJECT AND SETTING THE VALUES
		udDto = new UserDto();
		udDto.setUserId(userId);

		

		try {
			// CREATING UserManagementDelegate OBJECT
			uDelegate = new UserManagementDelegate();
			// CALLING METHOD IN UserManagementDelegate WHICH RETURN INTEGER VALUE
			count = uDelegate.removeUser(udDto);
		} catch (NoConnectionException | SQLException e) {
			e.printStackTrace();
		}

		// SENDING RESPONSE TO THE AJAX CALL
		json = new Gson().toJson(count);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
