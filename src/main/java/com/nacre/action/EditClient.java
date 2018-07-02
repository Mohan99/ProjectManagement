package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
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
 *it get the new details of client and update these values in database
 * @author N.Sravanthi
 * 
 * 
 * 
 */
@WebServlet("/EditClient")
public class EditClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String id=request.getParameter("clientId");
	String name=request.getParameter("cName");
	String desc=request.getParameter("cDesc");
	
		PrintWriter pw=	response.getWriter();
		Integer details=null;
	
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
	
	ClientDto dto=new ClientDto();
	dto.setClientId(Integer.parseInt(id));
	dto.setClientName(name);
dto.setClientDescription(desc);

		try {
		details=	deligate.editClient(dto);
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
			msg=MessageConstants.EDIT_CLIENT_SUCCESS_MSG;
		}
		else {
			msg=MessageConstants.EDIT_CLIENT_FAILURE_MSG;
		}
		
			Gson gson=new Gson();
			/**
			 * converting result given by delegate into json format
			 */
		String message=gson.toJson(msg);
	//displaying message on browser	
	pw.println(message);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
