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
 *  THIS ACTION SERVLET IS USED TO GET THE DEVELOPERS FROM DATABASE AND 
 *  THE DATA RETURNED WILL USED IN THE AJAX CALL TO SHOW THE DEVELOPERS 
 *  LIST THERE BY THEY CAN BE ASSIGNED TO TEAM LEADS
 */
@WebServlet("/GetDevelopers")
public class GetDevelopers extends HttpServlet {
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
		

		try {
			// CREATING UserManagementDelegate OBJECT
			uDelegate = new UserManagementDelegate();
			
			// CREATING UserManagementDelegate OBJECT
			al = uDelegate.getDevelopers();
			
		} catch (NoConnectionException | SQLException e) {
			e.printStackTrace();
		}
		
		// SENDING RESPONSE TO THE AJAX CALL
		json = new Gson().toJson(al);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
