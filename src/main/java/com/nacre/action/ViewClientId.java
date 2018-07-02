package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.nacre.formbean.FormBeanClient;

/**
 * 
 * This is used to get the clientDetails based on given client id
 * @author N.Sravanthi
 * 
 * 
 * 
 * 
 
 */
@WebServlet("/ViewClientId")
public class ViewClientId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClientId() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//gather client id form request
	String id=request.getParameter("id");
	FormBeanClient details = null;
	ProjectManagementDelegate deligate = null;
		deligate = new ProjectManagementDelegate();
	
	try {
		//in order to interact with database it calls this method
		 details = deligate.viewClientId(Integer.parseInt(id));
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (NoConnectionException e) {
		
		e.printStackTrace();
	} catch (ImageStreamToByteException e) {
		e.printStackTrace();
	}
	//Create Gson object
	Gson gson=new Gson();

	/**
	 * converting result given by delegate into json format
	 */
String clentdetails=gson.toJson(details);
//displaying details on browser	
	response.getWriter().println(clentdetails);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
