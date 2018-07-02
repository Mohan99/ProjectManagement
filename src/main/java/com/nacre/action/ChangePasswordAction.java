package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.constants.MessageConstants;
import com.nacre.constants.StringConstants;
import com.nacre.constants.URLConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class ChangePasswordAction
 */
@WebServlet("/ChangePasswordAction")
public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordAction() {
		super();

	}

	/**
	 * @author Shraddha
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto uDto = null;

		String newPassword = request.getParameter("newPassword");
		String oldPwd = request.getParameter("oldPassword");

		String comfpwd = request.getParameter("confPassword");

		HttpSession session = request.getSession();
		UserDto u = (UserDto) session.getAttribute(StringConstants.SESSION_USER_DTO_CONSTANT);
		if (u != null) {
			if (u.getPassword().equals(oldPwd)) {

				if (newPassword.equals(comfpwd)) {
					Integer uesrID = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);

					uDto = new UserDto();
					uDto.setUserId(uesrID);
					uDto.setPassword(newPassword);
					try {
						CommonOperationsDelegate cod = new CommonOperationsDelegate();
						cod.changePassword(uDto);
						u.setPassword(newPassword);
						session.setAttribute(StringConstants.SESSION_USER_DTO_CONSTANT, u);
						session.setAttribute("success","your password changed successfully..");
						response.sendRedirect(URLConstants.WELCOME_JSP);
					} catch (NoConnectionException e) {
						response.sendRedirect(URLConstants.CONNECTION_PROBLEM);
						e.printStackTrace();
					} catch (SQLException e) {
						response.sendRedirect(URLConstants.CONNECTION_PROBLEM);
						e.printStackTrace();
					}

				} else {

					session.setAttribute(StringConstants.MSG_CHANGE_PWD_NEW_CNF_ERROR,
							MessageConstants.INVAID_MATCH_NEW_CONFIFM_PWD);
					response.sendRedirect(URLConstants.CHANGE_PASSWORD_URL);

				}
			} else {

				session.setAttribute(StringConstants.MSG_ERROR, MessageConstants.INVAID_OLD_PASSWORD);
				response.sendRedirect(URLConstants.CHANGE_PASSWORD_URL);

			}
		} else {
			session.setAttribute(StringConstants.MSG_ERROR, MessageConstants.INVAID_OLD_PASSWORD);
			response.sendRedirect(URLConstants.CHANGE_PASSWORD_URL);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
