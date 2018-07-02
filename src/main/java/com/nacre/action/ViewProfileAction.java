package com.nacre.action;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.dao.test.DaoTest;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.UserDto;
import com.nacre.uitl.ImageUtil;

/**
 * @author kapilraj029 
 * Servlet implementation class ViewUserProfileAction return
 */
@WebServlet("/ViewProfileAction")
public class ViewProfileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ViewProfileAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommonOperationsDelegate cdelegate = null;
		
	
		RequestDispatcher rd = null;
		HttpSession session = null;

		// get delegate
		cdelegate = new CommonOperationsDelegate();

		try {
			// create the Session object
			session = request.getSession();
			 int userId =
			 (Integer)session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
logger.info(userId);
			// create the user object
		


UserDto 	udto = cdelegate.viewUserProfile(userId);
String json = null;

if (request.getParameter("ajax") != null && request.getParameter("ajax").equalsIgnoreCase("ajax")) {
	response.setContentType("application/json");

	// create json object
	logger.debug("ajax");
	json = new Gson().toJson(udto);
	// write the json response
	response.getWriter().write(json);
} else {
	// create the RequestDispatcher
	// send to viewProfile.jsp
	logger.debug("jstl");
	response.sendRedirect("jsp/viewProfile.jsp");
}
			// System.out.println(list);

			session.setAttribute("user", udto);
			logger.debug(udto);
			
			Blob img =udto.getImage();
			if(img!=null)
			{
			String image = ImageUtil.encodeImage(img.getBinaryStream());
			session.setAttribute("image", image);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// e.printStackTrace();
			logger.debug(e.getMessage());

			
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
