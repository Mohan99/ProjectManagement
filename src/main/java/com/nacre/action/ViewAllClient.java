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
import com.nacre.formbean.FormBeanClient;

/**
 *This servlet get all clients information from database
 * @author N.Sravanthi
 * 
 * 
 * 
 */
@WebServlet("/ViewAllClient")
public class ViewAllClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=	response.getWriter();
	List<ClientInfoBean> details=null;
	/**
	 * used for give response in either application or json format
	 */
	response.setContentType("application/json");
		ProjectManagementDelegate deligate = null;
			deligate = new ProjectManagementDelegate();
		
		try {
			/**
			 *for getting clientDetails from database it calling  viewAllClient() available in ProjectManagementDeligate
			 */
			details=	deligate.viewAllClient();
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
		
		Gson gson=new Gson();

		/**
		 * converting result given by delegate into json format
		 */
	String clientdetails=gson.toJson(details);
	System.out.println(clientdetails);
	//displaying message on browser	
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
