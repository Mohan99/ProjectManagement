package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ClientInfoBean;

/**
 *   This is used to get client details
 *  search  based on client name or client contact person name or client contact
 *  person mobile number as given by Admin 
 * @author N.Sravanthi
 *
 *
 */
@WebServlet("/ClientDetailsBasedOnSearch")
public class ClientDetailsBasedOnSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientDetailsBasedOnSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		/**
		 * used for give response in either application or json format
		 */
		
		response.setContentType("application/json");
		
		PrintWriter pw=	response.getWriter();
		ClientInfoBean details=null;
		List<ClientInfoBean> list =null;
		List<ClientInfoBean> Moredetails=null;
		/**
		 * String value =request.getParameter("searchValue");
		 * where value is holding searchValue given by admin
		 */
	String value=	request.getParameter("searchValue");
	System.out.println(value+" value");
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
	
		try {
			
			/**
			 * if given value matches with numbers then
			 * it search for clientDetails based on  ClientContactPerson  mobileNumber
			 */
			if(value.matches("[0-9]+") ) {
				details=deligate.viewClientMobileNo(value);
				
			}
			/**
			 * if given value  not  matches with numbers then
			 * it search for clientDetails based on  ClientContactPerson name (or) ClientName
			 * by calling  viewClientName(value)  in  ProjectManagementDeligate
			 */
			
			else {
				details=deligate.viewClientName(value);
			}
			 list = new ArrayList<>();
				list.add(details);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson=new Gson();
		
		/**
		 * converting result given by delegate into json format
		 */
	String clientdetails=gson.toJson(list);
	//displaying details on browser	
		pw.println(clientdetails);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
