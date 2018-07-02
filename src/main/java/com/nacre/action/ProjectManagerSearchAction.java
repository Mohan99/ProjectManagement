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
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.CountryDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectManagerInfoBean;

@WebServlet("/ProjectManagerSearchAction.ajax")
public class ProjectManagerSearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(ProjectManagerSearchAction.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.setContentType("text/html");
		ProjectManagementDelegate delegate = null;
		List<ProjectManagerInfoBean> listDTO = null;
		String json = null;
		String search = null;

		//get request parameter
		search = req.getParameter("search");
		// get Delegate

		try {
			delegate = new ProjectManagementDelegate();
			listDTO = new ArrayList<>();
			// get List of Project
			listDTO = delegate.displayProjectManager(search);
			res.setContentType("application/json");

			// write json response
			json = new Gson().toJson(listDTO);

			res.getWriter().write(json);

		
		} catch (SQLException | NoConnectionException e) {
			logger.error("Excepton Raised" + e.getMessage());

			res.setContentType("application/json");

			// write json response
			res.getWriter().write("[]");

		}

		// create json object

		// set content type

	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class