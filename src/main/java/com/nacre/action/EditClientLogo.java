package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
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
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ClientDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.FormBeanClient;


/**
 * change the logo of client in database
 * @author N.Sravanthi
 *
 *
 */
@WebServlet("/uploadLogo")
@MultipartConfig
public class EditClientLogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientLogo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get the client id
		String id=request.getParameter("id");
		//get the new logo from admin
		Part part = request.getPart("logo");
	byte[] b = null;
	int count = 0;
	int r = 0;
	//convert image in part to inputstream
		InputStream is = part.getInputStream();
		//get writer
		PrintWriter pw=	response.getWriter();
		Integer details=null;
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
		
	ClientDto dto=new ClientDto();
	//converting image in inputstream format to byte[] 
b = new byte[is.available()];
while ((r = is.read()) != -1) {
	b[count] = (byte) r;
	count++;
}
//System.out.println(id);
dto.setClientId(Integer.parseInt(id));
try {
	dto.setLogo(new SerialBlob(b));
} catch (SerialException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		try {
			//in order to interact with database to store updated image
		details=	deligate.editClientLogo(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg=null;
		if(details!=0) {
			//if  updated logo is stored in database then this message will be printed on browser
			msg=MessageConstants.EDIT_CLIENT_LOGO_SUCCESS_MSG;

			request.getSession().setAttribute("ImgMsg",msg);
		}
		else {
			//if  updated logo is not stored in database then this message will be printed on browser
			msg=MessageConstants.EDIT_CLIENT_LOGO_FAILURE_MSG;

			request.getSession().setAttribute("err",msg);
		}
		//.setAttribute("ImgMsg", msg);
		response.sendRedirect(request.getContextPath()+  "/jsp/viewClient.jsp");
		
		/*//create gson object
			Gson gson=new Gson();
			//converte the message in json format
		String message=gson.toJson(msg);
		//displaying json message on browser
	pw.println(message);*/
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//calling doGet(request, response)
		doGet(request, response);
	}

}
