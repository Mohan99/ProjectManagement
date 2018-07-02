package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.constants.StringConstants;
import com.nacre.constants.URLConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;

/**
 * @author Shraddha This Controller is used to get password if,any user might
 *         forgrt his password Then mail with password will go to Their
 *         perticular mail
 */
@WebServlet("/ForgetPasswordAction")
public class ForgetPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author Shraddha
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPasswordAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Shraddha
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonOperationsDelegate cod = new CommonOperationsDelegate();

		String email = request.getParameter(StringConstants.PARAM_EMAIL);
		Boolean flag;
HttpSession session = request.getSession();
		try {
			flag = cod.forgetPass(email);
			if (flag) {
				session.setAttribute("success", "PASSWORD SENT TO  YOUR MAIL PLEASE CHECK MAIL");
				response.sendRedirect(URLConstants.LOGIN);
			} else {
				session.setAttribute("success", "UNABLE TO SEND MAIL CHECK INTERNET CONNECTION OR TRY LATER");
				
				response.sendRedirect(URLConstants.FORGET_PASSWORD);
			}

		} catch (NoConnectionException e) {
			session.setAttribute("err", "PLEASE TRY LATER");
			
			e.printStackTrace();
			response.sendRedirect(URLConstants.FORGET_PASSWORD);
		} catch (SQLException e) {
			session.setAttribute("err", "PLEASE TRY LATER");

			response.sendRedirect(URLConstants.FORGET_PASSWORD);
			e.printStackTrace();
		} catch (InvalidUserDetailsException e) {
			session.setAttribute("err", "ENTERED EMAIL NOT EXIST");
			
			response.sendRedirect(URLConstants.FORGET_PASSWORD);
			e.printStackTrace();
		}
	}

	/**
	 * @author SHRADDHA
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
