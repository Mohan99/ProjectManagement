package com.nacre.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nacre.constants.URLConstants;

/**
 * @author Shraddha THIS CONTROLLER IS UESD TO DO LOGOUT FUNCTION IS -TAKING
 *         USER ID'S FROM SESSION OR COOKIE AND INVALID SESSION AND COOKIES
 */
@WebServlet("/LogoutAction")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author SHRADDHA
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutAction() {
		super();

	}

	/**
	 * @author SHRADDHA
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//CREATING SESSION
		HttpSession session = null;
       //
		session = request.getSession(false);
		System.out.println("Logout action");
		if (session != null) {
			session.invalidate();
			Cookie[] myCookie = request.getCookies();
			if (myCookie != null) {
				for (Cookie hh : myCookie) {
					hh.setMaxAge(0);
					response.addCookie(hh);
				}
			}
		}
		response.sendRedirect(URLConstants.LOGIN);

	}

	/**
	 * @author SHRADDHA
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} 
}
