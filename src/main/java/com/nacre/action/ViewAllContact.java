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
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientLocationDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;

/**
 * it gives contact person details based on the location id
 * @author N.Sravanthi
 * 
 */
@WebServlet("/ViewContactPerson.ajax")
public class ViewAllContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter pw=	response.getWriter();
	List<ClientContactPerson> details=null;
	ClientLocationDto dto =null;
	response.setContentType("application/json");
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
		
		try {
			dto = new ClientLocationDto();

			dto.setClientLocationId(Integer.parseInt(request.getParameter("locationId")));
				details= deligate.viewContactPerson(dto);
	
		}
		 catch (ImageStreamToByteException e) {
				e.printStackTrace();
			 }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson=new Gson();
		// gson.toJson(details.getLogo());
	String clentdetails=gson.toJson(details);
	
		pw.println(clentdetails);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
