package com.nacre.action;

import java.io.IOException;
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
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.DeveloperInfoBean;

/**
 * Servlet implementation class AddTaskAction
 * 
 * @author Chakravarthi k
 *  this servlet is used as controller for getting the developer details assigned to the logged in team leader
 */
@WebServlet("/DeveloperAction")
public class DeveloperAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(DeveloperAction.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				TaskManagementDelegate delegate = null;
				List<DeveloperInfoBean> listDTO = null;
				String json = null;
				delegate = new TaskManagementDelegate();
				listDTO = new ArrayList<>();

				try {
					listDTO = delegate.getDevelopers();
					response.setContentType("application/json");
					json = new Gson().toJson(listDTO);
					response.getWriter().write(json);
				} catch (SQLException | NoConnectionException e) {
					logger.error("Excepton Raised" + e.getMessage());
					response.setContentType("application/json");
					response.getWriter().write("[]");
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
