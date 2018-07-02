package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.delegate.ReportsDelegate;
import com.nacre.dto.CountryDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;

/**
 *
 * @author Ankush Vyavhare
 * 
 */

@WebServlet("/devTaskAction.ajax")
public class DeveloperTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = 	Logger.getLogger(DeveloperTaskAction.class);


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("application/json");
		
		List<ModuleTaskDto> list = null;
		ReportsDelegate  delegate = null;
		UserDto u = null;
		HttpSession session = null;
		u = new UserDto();
		String json = null;
		
		session = req.getSession(false);
	
		u.setUserId((Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT));
		delegate = new ReportsDelegate();
		
		try {
			list = delegate.displayDevloperTaskReport(u);
			json = new Gson().toJson(list);
			res.getWriter().write(json);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().write("[]");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}