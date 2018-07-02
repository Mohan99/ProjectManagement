package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.UserManagementDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.UserInformationBean;

/**
 * @author SAGARKOMMU 
 * THIS CONTROLLER GET DATA FROM AN AJAX CALL AND IT WILL
 * RETURN ALL USERS FROM DATABASE BASED ON SEARCH TO THE AJAX CALL
 */
@WebServlet("/GetAllUserBySearch")
public class GetAllUserBySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DECLARING THE UserManagementDelegate OBJECT
		UserManagementDelegate uDelegate = null;

		// DECLARING THIS LIST OBJECT WHICH CAN STORE UserInformationBean OBJECT
		List<UserInformationBean> al = null;

		String json = null;
		String search = null;

		try {
			// CREATING UserManagementDelegate OBJECT
			uDelegate = new UserManagementDelegate();

			// SETTING REQUEST PARAMETER VALUE TO THE VARIABLE
			search = request.getParameter("search");

			// CALLING METHOD IN UserManagementDelegate WHICH RETURN LIST UserInformationBean
			al = uDelegate.getUsersBySearch(search);

		} catch (NoConnectionException | SQLException e) {

			e.printStackTrace();
		}

		// SENDING RESPONSE TO THE AJAX CALL
		json = new Gson().toJson(al);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
