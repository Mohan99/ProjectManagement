package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.constants.MessageConstants;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.AddressDto;
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;

/**
 *  edit/update contact person details in database
 * @author N.Sravanthi
 *
 */
@WebServlet("/EditContactPerson")
public class EditContactPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContactPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	/**
	 * gathering client new details from request
	 */
		String id=request.getParameter("contactPersonId");
		String name=request.getParameter("cpName");
		String mobileNo=request.getParameter("cpMobile");
		String email=request.getParameter("cpEmail");
			
			//gives printwriter object
			PrintWriter pw=	response.getWriter();
			Integer details=null;
		
			ProjectManagementDelegate deligate = null;
				deligate = new ProjectManagementDelegate();
		
		ClientContactPerson dto=new ClientContactPerson();
		ClientLocationDto cl=new ClientLocationDto();
		AddressDto addr=new AddressDto();
		addr.setAddress(request.getParameter("addrs"));
		cl.setAddressId(addr);
		//set the contact person detalis and location details to contactperson dto
		dto.setClientLocationId(cl);
		dto.setClientContactPersonId(Integer.parseInt(id));
		dto.setContactPersonName(name);
		dto.setMobileNo(mobileNo);
		dto.setEmail(email);
		String msg=null;
		try {
			//calling editContactPerson(dto) in order to store these details in database
			details=	deligate.editContactPerson(dto);
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
		if(details!=null) {
			//details are modified then this message will be printed on browser
			msg=MessageConstants.EDIT_CONTACT_PERSON_SUCCESS_MSG;
		}
		else {
			//details are not  modified then this message will be printed on browser
			msg=MessageConstants.EDIT_CONTACT_PERSON_FAILURE_MSG;
		}
		//create gson object
			Gson gson=new Gson();
			//convert message into json
		String message=gson.toJson(msg);
		//displaying message on browser	
		pw.println(message);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
