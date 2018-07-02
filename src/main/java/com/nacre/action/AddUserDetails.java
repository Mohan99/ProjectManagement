package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.UserManagementDelegate;
import com.nacre.dto.RoleDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.EmailUtilty;

/**
 * @author Avinash Servlet implementation class AddUserDetails add single user
 *         Details
 */

@WebServlet("/AddUserDetails")
public class AddUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Create Userdto object
		UserDto userdto = new UserDto();

		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String email_id = request.getParameter("email");
		String mobile_no = request.getParameter("mobileno");
		String gender = request.getParameter("gender");

		// create RoleDto object
		RoleDto rdto = new RoleDto();
		Integer role = Integer.parseInt(request.getParameter("role"));
		rdto.setRoleId(role);

		StatusDto sdto = new StatusDto();
		Integer status_id = 1;
		sdto.setStatusId(status_id);
		userdto.setStatusId(sdto);
		userdto.setFirstName(first_name);
		userdto.setLastName(last_name);
		userdto.setGender(gender);
		userdto.setEmail(email_id);
		userdto.setMobileNo(mobile_no);
		userdto.setGender(gender);
		userdto.setRoleId(rdto);

		// password
		Random rnd = new Random();
		userdto.setPassword("P" + rnd.nextInt() + "M");

		// create the Delegate object
		UserManagementDelegate umdelegate = new UserManagementDelegate();
		boolean i = false;

		try {
			i = umdelegate.addUserDetail(userdto);

			System.out.println(i + "ivalue");
			List<UserDto> l = new ArrayList<>();
			if (!i) {
				l.add(userdto);
				request.getSession().setAttribute("Error", "INVALID EMAILS FOUND");

				request.getSession().setAttribute("invalidEmails1", userdto);
			} else {

				request.getSession().setAttribute("Success", "ADDED SUCCESSFULLY");
			}
			System.out.println(">>" + i);

			// send redirect the Jsp page request sent message

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			request.getSession().setAttribute("Error", "PLEASE TRY AFTER SOME TIME");

		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			request.getSession().setAttribute("Error", "PLEASE TRY AFTER SOME TIME");

		} catch (DuplicatMobNoException e) {
			// TODO Auto-generated catch block

			request.getSession().setAttribute("Error", "EMAIL OR MOBILENO ALREADY EXIST");

			e.printStackTrace();
		}catch (Exception e) {
			request.getSession().setAttribute("invalidEmails1", userdto);
		}

		response.sendRedirect(getServletContext().getContextPath()+"/jsp/addUserNewCreate.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
