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
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;

/**
 *  delete ClientContactPerson of client
 * @author N.Sravanthi
 *
 * 
 * 
 */
@WebServlet("/DeleteContactPerson")
public class DeleteContactPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
	//	System.out.println(request.getParameter("id"));
		Integer id=Integer.parseInt(request.getParameter("id"));
		Integer count=null;
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
	
	try {
		/**
		 * based on  given id of ClientContactPerson it will delete details in database
		 */
	count=	deligate.deleteContactPerson(id);
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
	if(count!=0) {
		/**
		 * if this operation is succeed in database then it gives this message
		 */
		msg=MessageConstants.DELETE_CONTACT_PERSON_SUCCESS_MSG;
	}
	
	/**
	 * if this operation is failed in database then it gives this message
	 */
	else {
		msg=MessageConstants.DELETE_CONTACT_PERSON_FAILURE_MSG;
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
