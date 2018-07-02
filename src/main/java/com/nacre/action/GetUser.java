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
 * @author  SAGAR KOMMU
 *   THIS CONTROLLER GET DATA FROM AN AJAX CALL AND IT WILL
 * RETURN UserDto OBJECT FROM DATABASE BASED ON SEARCH TO THE AJAX CALL
 *
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// DECLARING THE UserManagementDelegate OBJECT
		UserManagementDelegate uDelegate = null;
		
		String json = null;
		UserDto udto = null;
		
		// CREATING UserDto OBJECT AND SETTING THE VALUES
		udto = new UserDto();
		int userId = Integer.parseInt(request.getParameter("userid"));
		udto.setUserId(userId);
		try {
			// CREATING UserManagementDelegate OBJECT
			uDelegate = new UserManagementDelegate();
			
			// CALLING METHOD IN UserManagementDelegate WHICH RETURN UserDto OBJECT
			udto = uDelegate.getUser(udto);
		} catch (NoConnectionException | SQLException e) {
			e.printStackTrace();
		}

		// SENDING RESPONSE TO THE AJAX CALL
		json = new Gson().toJson(udto);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
