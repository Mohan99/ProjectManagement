package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.NotificationDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AcceptTask;

/**
 * Servlet implementation class AcceptDeveloperTask
 */
@WebServlet("/AcceptDeveloperTask")
public class AcceptDeveloperTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptDeveloperTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		NotificationDelegate nd = new NotificationDelegate();
		List<AcceptTask> list;
		try{
			String sup= request.getParameter("sup");
			int id=Integer.parseInt(sup);
			list=nd.getNotificationAcceptTask(id);
			
			request.setAttribute("supid", list);
			RequestDispatcher rd= request.getRequestDispatcher("jsp/DisplayCompleteInformationForTL.jsp");
			rd.forward(request, response);
			
			
		}catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
			
		} catch (SQLException e) {
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
