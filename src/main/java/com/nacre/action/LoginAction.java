package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.StringConstants;
import com.nacre.constants.URLConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.ImageUtil;

/**
 * @author SHRADDHA 
 * This controller is used to do login and perform functions
 *         accordingly,if roleid of perticuler person matches it will allow to
 *         access that person only
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

	private static final Logger logger = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @author Shraddha
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author SHRADDHA
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = null;
		String pass = null; 
		UserDto uDto = null;
		CommonOperationsDelegate cDeligate = null;

		// READ THE VALUES FROM JSP PAGE
		email = request.getParameter(StringConstants.PARAM_EMAIL);
		pass = request.getParameter(StringConstants.PARAM_PASSWORD);
		logger.info(email);
		logger.info(pass);

		// SETTING DETAILS TO USERDTO
		uDto = new UserDto();
		uDto.setEmail(email);
		uDto.setPassword(pass);

		// CALL DELIGATE METHOD
		cDeligate = new CommonOperationsDelegate();

		try {

logger.info(uDto);
			uDto = cDeligate.login(uDto);
			
logger.info(uDto);
			// SESSION TRACKING
			// SETTING USER DETAILS AND IDS TO SESSION
			session.setAttribute(StringConstants.SESSION_USER_DTO_CONSTANT, uDto);
			session.setAttribute(StringConstants.SESSION_USERID_CONSTANT, uDto.getUserId());
session.setAttribute(StringConstants.SESSION_ROLE_CONSTANT, uDto.getRoleId().getRoleId());
          try {
        	  
        	  if(uDto.getImage()!=null){
		String img =	ImageUtil.encodeImage(uDto.getImage().getBinaryStream());
		session.setAttribute(StringConstants.SESSION_IMG_CONSTANT, img);
        	  }
          
          } catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
        	  //session.setAttribute(StringConstants.SESSION_IMG_CONSTANT, "");
     		 	  
			e.printStackTrace();
		}
logger.info(session.getAttribute(StringConstants.SESSION_USERID_CONSTANT));
			// GETTING THE ROLE IDS FROM SESSION
			session.setAttribute(StringConstants.ROLE_DEVELOPER_CONSTANT, IntegerConstants.ROLE_DEVELOPER);
			session.setAttribute(StringConstants.ROLE_ADMIN_CONSTANT, IntegerConstants.ROLE_ADMIN);
			session.setAttribute(StringConstants.ROLE_PROJECT_MANAGER_CONSTANT, IntegerConstants.ROLE_PROJECTMANAGER);
			session.setAttribute(StringConstants.ROLE_TEAM_LEAD_CONSTANT, IntegerConstants.ROLE_TEAMLEAD);

			// COOKIES FOR CLIENT SIDE
			// SAVING USERID'S EMAIL,ROLE ID'S IN COOKIES
			Cookie cookieA = new Cookie(StringConstants.SESSION_USERID_CONSTANT, uDto.getUserId().toString());
			Cookie cookieM = new Cookie(StringConstants.PARAM_EMAIL, uDto.getEmail());
			Cookie cookieT = new Cookie(StringConstants.SESSION_ROLE_CONSTANT, uDto.getRoleId().getRoleId().toString());

			// checking condition for remembering password
			if (request.getParameter(StringConstants.REMEMBER_PASSWORD) != null) {
				// SETTING COOKIES MAX AGE
				cookieA.setMaxAge(24 * 60 * 60);

				cookieM.setMaxAge(24 * 60 * 60);

				cookieT.setMaxAge(24 * 60 * 60);
			}
			// ADDING COOKIES TO RESPONSE
			response.addCookie(cookieT);
			response.addCookie(cookieM);
			response.addCookie(cookieA);

			// IF LOGIN VALID FORWORDING RESPONSE TO WELCOME PAGE
			response.sendRedirect(URLConstants.WELCOME_JSP);

		} catch (NoConnectionException e) {
			e.printStackTrace();
			session.setAttribute("err", "PLEASE TRY LATER");
			response.sendRedirect(URLConstants.WELCOME_JSP);
      	  
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("err", "PLEASE TRY LATER");
			response.sendRedirect(URLConstants.LOGIN);
	      	  
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
			session.setAttribute("err",e.getMessage());
			response.sendRedirect(URLConstants.LOGIN);
	      	  
		}

	}

	/**
	 * @author sHRADDHA
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
