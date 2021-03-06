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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class NotificationAccepted
 */
@WebServlet("/NotificationAccepted")
public class NotificationAccepted extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(NotificationAccepted.class); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationAccepted() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/json");
		   PrintWriter out= response.getWriter();
	    NotificationDelegate nd = new NotificationDelegate();
	  // List l = new ArrayList();
	   

	  /*try{
			List<DeveloperTaskDto> list =null;
			try {
				list = nd.notificationAcceptedTask(3);

				
				Gson gson = new Gson();	
			String jsonData=		gson.toJson(list);

			logger.info(jsonData);
			out.println(jsonData);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				out.println("[]");
			}
			l.add(list.get(0).getDeveloperTaskId());
			l.add(list.get(0).getModuleTaskId());
			

		}catch (NoConnectionException e) {
			// TODO Auto-generated ca2tch block
			e.printStackTrace();

			out.println("[]");
	
		}
	}*/
	    try {
	    	
	    	
int uid =4;	    	
	    	List<DeveloperTaskDto> list =nd.notificationAcceptedTask(uid);
	    	
	    	Gson g = new Gson();
	    String json =	g.toJson(list);
	    	logger.info(json);
	    	out.println(json);
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } catch (NoConnectionException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	        	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
