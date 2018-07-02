package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.google.gson.Gson;
import com.nacre.constants.MessageConstants;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.ImageUtil;

/**
 * @author kapilraj029 
 * Servlet implementation class EditUserLogo return integer
 */
@WebServlet("/EditUserLogo")
@MultipartConfig
public class EditUserLogo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the client id
		Integer id = (Integer) request.getSession().getAttribute(StringConstants.SESSION_USERID_CONSTANT);

		// get the new logo from user
		Part part = request.getPart("file");
		byte[] b = null;
		int count = 0;
		int r = 0;

		// convert image in part to inputstream
		InputStream is = part.getInputStream();

		// get writer
		PrintWriter pw = response.getWriter();
		Integer details = 0;
		CommonOperationsDelegate cdelegate = new CommonOperationsDelegate();
		UserDto dto = new UserDto();

		// converting image in inputstream format to byte[]

		b = new byte[is.available()];
		while ((r = is.read()) != -1) {
			b[count] = (byte) r;
			count++;
		}
		dto.setUserId(id);
		try {
			dto.setImage(new SerialBlob(b));
			
			
				details = cdelegate.editUserImage(dto);
		
			

			String msg = null;
			if (details != 0) {
				// if updated logo is stored in database then this message will be
				// printed on browser
				msg = (MessageConstants.EDIT_CLIENT_LOGO_SUCCESS_MSG);
				String image;
				try {
					image = ImageUtil.encodeImage(dto.getImage().getBinaryStream());
					request.getSession().setAttribute("image", image);
				} catch (ImageStreamToByteException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {

				// if updated logo is not stored in database then this message will
				// be printed on browser

				msg = (MessageConstants.EDIT_CLIENT_LOGO_FAILURE_MSG);

			}
			request.getSession().setAttribute("success", msg);
		} catch (SerialException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		// in order to interact with database to store updated image
				
		response.sendRedirect(getServletContext().getContextPath()+"/jsp/editProfile.jsp");

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
