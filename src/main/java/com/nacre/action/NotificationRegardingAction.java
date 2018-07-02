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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;

/**
 * Servlet implementation class NotificationRegardingAction
 */
@WebServlet("/NotificationRegardingAction")
public class NotificationRegardingAction extends HttpServlet {
	private static final Logger logger = Logger.getLogger(NotificationRegardingAction.class); 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationRegardingAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
    	
    	// now create the delegate the object
    	
    response.setContentType("text/json");
   PrintWriter out= response.getWriter();
    	NotificationDelegate nd = new NotificationDelegate();
  try {
	List<DeveloperTaskDto> list =nd.notificationDeveloperTask(4);
	
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
	
}
