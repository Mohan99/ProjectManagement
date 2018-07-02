/**
 * 
 */
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

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ReportsDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleReportVo;

/**
 * @author AVEJ SHAIKH Servlet for Module Report Generation
 */
@WebServlet("/ModuleReport")
public class ModuleReportAction extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = null;
		String projectId = null;
		Integer userid = null;
		Integer userRoleid = null;
		// set content type
		resp.setContentType("text//html");
		// get print writer object
		pw = resp.getWriter();
		// get project id as a request parameter
		projectId = req.getParameter("pid");

		HttpSession session = req.getSession();
		userid = (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		userRoleid = (Integer) session.getAttribute(StringConstants.SESSION_ROLE_CONSTANT);

		
		// create List<ModuleReportVo> type variable
		List<ModuleReportVo> listModuleReportVo = null;
		// create ReportsDelegate class Object
		ReportsDelegate reportsDelegate = new ReportsDelegate();
		try {
			// call getModuleReportDelegate(String projectId) method
			listModuleReportVo = reportsDelegate.getModuleReportDelegate(projectId,userRoleid,userid);

			// create Gson Object
			Gson gmr = new Gson();
			// Converts Gson
			String listmr = gmr.toJson(listModuleReportVo);
			// set content type
			resp.setContentType("text/json");
			// print Gson objetc
			pw.println(listmr);

		} catch (NoConnectionException e) {
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
		doGet(req, resp);
	}

}
