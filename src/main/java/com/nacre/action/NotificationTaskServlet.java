package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.TaskStatusDto;

/**
 * Servlet implementation class NotificationTaskServlet
 * 
 * servlet for updating notification task status
 */
@WebServlet("/NotificationTaskServlet")
public class NotificationTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("action");
		PrintWriter out=response.getWriter();
		
		List<TaskStatusDto> list=null;
     	TaskStatusDto tsdto=null;
		NotificationDelegate delegate=null;
	    HttpSession session = request.getSession();
		try{
		
			list=new ArrayList<TaskStatusDto>();
	
			delegate=new NotificationDelegate();
			
			Integer tlId = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			System.out.println(tlId);
			list=delegate.getNotificationTaskSeenStatus(tlId);
			
		System.out.println(list);
			Gson gson=new Gson();
			String listg=gson.toJson(list);
			response.setContentType("application/json");
			out.println(listg);
		//	}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
