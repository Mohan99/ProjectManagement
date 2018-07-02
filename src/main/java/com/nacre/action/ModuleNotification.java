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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.NotificationDelegate;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

@WebServlet("/ModuleNotification")
public class ModuleNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=null;
		HttpSession session=null;
		Integer teamleadId=null;
		NotificationDelegate delegate = null;
		UserDto udto =  new UserDto();
		String json = null;
		out = response.getWriter();
		response.setContentType("application/json");

		Integer uid = (Integer) request.getSession().getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		udto.setUserId(uid);
		
		delegate = new NotificationDelegate();
		try {
			List<ModuleStatusDto> list = delegate.getModuleStatusNotification(udto);
			json = new Gson().toJson(list);
			
			out.write(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("[]");
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
