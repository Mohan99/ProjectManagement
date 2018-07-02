package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.AddressDto;
import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;

/**
 * kapilraj029 Servlet implementation class EditProfileAction return list get
 * the list of users details
 */
@WebServlet("/EditProfileAction")
@MultipartConfig
public class EditProfileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ViewProfileAction.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDto user = null;
		AddressDto adto = null;
		CityDto ct = null;
		CountryDto cdto = null;
		int userId = 0;
		String FirstName = null;
		String LastName = null;
		String Email = null;
		String MobileNo = null;
		String Gender = null;
		int AddressId = 0;
		String Address = null;
		Integer PinCode = 0;
		Blob Image = null;
		int CountryId = 0;
		int StateId = 0;
		int CityId = 0;
		String msg = null;

		RequestDispatcher rd = null;
		CommonOperationsDelegate cdelegate = null;
		HttpSession session = null;

		// get request param
		FirstName = request.getParameter("FirstName");
		LastName = request.getParameter("LastName");
		Email = request.getParameter("Email");
		MobileNo = request.getParameter("MobileNo");
		Gender = request.getParameter("gender");
		Address = request.getParameter("address");
		PinCode = Integer.parseInt(request.getParameter("pin"));
		CityId = Integer.parseInt(request.getParameter("city"));
		// StateId=Integer.parseInt(request.getParameter("st"))
		// CountryId=Integer.parseInt(request.getParameter("countryId"));

		// get the new logo from user
		Part part = request.getPart("file");

		// create the userdto object
		user = new UserDto();

		// Gets the content of this part as an InputStream
		// convert image in part to inputstream
		// InputStream is = part.getInputStream();
		int count = 0;
		// converting image in inputstream format to byte[]
		/*
		 * byte[] b = new byte[is.available()]; int r = 0; while ((r =
		 * is.read()) != -1) { b[count] = (byte) r; count++; }
		 */

		// set the values to userdto
		session = request.getSession(false);

		// create the session object
		// session = request.getSession(false);

		// pass the userId in session
		userId = (Integer)session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		user.setUserId(userId);
		user.setFirstName(FirstName);
		user.setLastName(LastName);
		user.setEmail(Email);
		user.setMobileNo(MobileNo);
		user.setGender(Gender);

		// create address obj
		adto = new AddressDto();

		// create city object
		ct = new CityDto();

		// create the state object
		StateDto st = new StateDto();

		adto.setAddress(Address);
		adto.setPinCode(PinCode);
		user.setAddressId(adto);

		cdto = new CountryDto();
		ct.setCityId(CityId);
		adto.setCityId(ct);
		user.setAddressId(adto);

		System.out.println(user);

		// get the delegate
		cdelegate = new CommonOperationsDelegate();
		try {
			// on the delegate write editProfile()
			msg = cdelegate.editProfile(user);

			session.setAttribute("success", msg);
		} catch (Exception e) {
			 e.printStackTrace();

				session.setAttribute("err", e.getMessage());
			logger.error(e.getMessage());
		}
		System.out.println(msg);
		request.getRequestDispatcher("ViewProfileAction").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
