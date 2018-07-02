package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.IntegerConstants;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ReportsDelegate;
import com.nacre.dto.ProjectDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectReportVo;

/**
 * @author AVEJ SHAIKH Servlet for Project Report Generation
 */
@WebServlet("/ProjectReport")
public class ProjectReportAction extends HttpServlet {

	private static final Logger logger = Logger.getLogger(ProjectReportAction.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = null;
		Integer userid = null;
		Integer userRoleid = null;
		List<ProjectReportVo> listProjectReportVo = null;
		// resp.setContentType("text/http");
		// get print writer
		pw = resp.getWriter();
		logger.info("Control is in ProjectReportAction");
		HttpSession session = req.getSession();
		userid = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		userRoleid = (Integer) session.getAttribute(StringConstants.SESSION_ROLE_CONSTANT);

		// Create ReportsDelegate object
		ReportsDelegate reportsDelegate = new ReportsDelegate();

			logger.info("user roll id Admin:" + userRoleid);

			try {
				// call getProjectReportDelegate() method
				listProjectReportVo = reportsDelegate.getProjectReportDelegate(userRoleid,userid);
				// Create Gson object
				System.out.println(listProjectReportVo);
				Gson gpr = new Gson();
				// converts to Gson
				String listpr = gpr.toJson(listProjectReportVo);
				// set content type
				resp.setContentType("application/json");
				// print response
				pw.println(listpr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}