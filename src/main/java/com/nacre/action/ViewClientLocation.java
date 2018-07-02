package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ClientDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ClientInfoBean;
import com.nacre.formbean.ClientLocationBean;

/**
 * it gives location/address details of client based on client id
 * @author N.Sravanthi
 * 
 */
@WebServlet("/ViewClientLocation.ajax")
public class ViewClientLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClientLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter pw=	response.getWriter();
	List<ClientLocationBean> details=null;
	response.setContentType("application/json");
	ClientDto dto = null;
	
	dto = new ClientDto();
	
	dto.setClientId(Integer.parseInt(request.getParameter("clientId")));
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
		
		try {
				details=	deligate.viewClientLocation(dto);
		
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
