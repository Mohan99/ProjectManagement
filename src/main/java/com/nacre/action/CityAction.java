package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.CityDto;
import com.nacre.dto.StateDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;

@WebServlet("/CityAction.ajax")
public class CityAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(CityAction.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		
		CommonOperationsDelegate delegate = null;
		List<CityDto> listDTO = null;
		StateDto dto = null;
		String json = null;

		dto = new StateDto();
		// get request parameter
		dto.setStateID(Integer.parseInt(req.getParameter(StringConstants.PARAM_STATE_ID)));
		// get Delegate
		delegate = new CommonOperationsDelegate();

		try {
			// get List of country
			listDTO = delegate.getCities(dto);


			// create json object
			json = new Gson().toJson(listDTO);
			// set Content type
			// write json to response
			res.getWriter().write(json);
		} catch (SQLException | NoConnectionException e) {
			logger.error("Exception raised" + e.getMessage());
			res.getWriter().write("[]");
			
		}

	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}