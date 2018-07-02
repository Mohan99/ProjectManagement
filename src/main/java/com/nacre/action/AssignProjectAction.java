package com.nacre.action;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

@WebServlet("/assignProjectAction.ajax")
public class AssignProjectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AssignProjectAction.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/css");
		ProjectManagerProjectDto pmdto = null;
		ProjectManagementDelegate delegate = null;
		String json = null;
		ProjectDto pdto = null;
		UserDto udto = null;
		StatusDto status = null;

		logger.debug(req.getParameter("projId"));
		logger.debug(req.getParameter("uId"));

		udto = new UserDto();
		pmdto = new ProjectManagerProjectDto();
		status = new StatusDto();
		status.setStatusId(8);
		pdto = new ProjectDto();
		pdto.setProjectId(Integer.parseInt(req.getParameter("projId")));
		udto.setUserId(Integer.parseInt(req.getParameter("uId")));
		pmdto.setProjectManagerId(udto);
		pmdto.setProjectId(pdto);
		pmdto.setStatus(status);
		String msg = "";

		try {
			delegate = new ProjectManagementDelegate();
			msg = delegate.assignProjectToPM(pmdto);
			logger.debug(msg);

			// create json object
			json = new Gson().toJson(msg);
			
			
		} catch (SQLException | NoConnectionException e) {
			logger.error("Exception raised" + e.getMessage());
			json = new Gson().toJson(StringConstants.ERROR_MESSAGE);
		}
		res.getWriter().write(json);
		
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}