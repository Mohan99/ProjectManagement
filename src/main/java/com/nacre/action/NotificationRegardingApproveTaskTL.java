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
import javax.servlet.http.HttpSession;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ApproveRejectForTL;

/**
 * Servlet implementation class NotificationRegardingApproveTaskTL
 */
@WebServlet("/NotificationRegardingApproveTaskTL")
public class NotificationRegardingApproveTaskTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationRegardingApproveTaskTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		NotificationDelegate nd=new NotificationDelegate();
		List<ApproveRejectForTL> list;
		try{
			HttpSession session = request.getSession();
			
			String sup =request.getParameter("dtId"); 
					int dtId = Integer.parseInt(sup);
			int id=4;//(int)session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			System.out.println(sup);
			list=nd.getNotificationApproveorRejectForTL(id,dtId);
			System.out.println("<<<<<<<<<<<<<ss"+list);
			request.setAttribute("supid", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("jsp/DeveloperCompleteInformationForAcceptsTask.jsp");
			
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
