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
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;


@WebServlet("/StateAction.ajax")
public class StateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = 	Logger.getLogger(StateAction.class);


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("application/json");

		CommonOperationsDelegate deligate = null;
		List<StateDto> listDTO = null;
		CountryDto dto = null;
		String json = null;

		dto = new CountryDto();

		// get request parameter
		dto.setCountryId(Integer.parseInt(req.getParameter(StringConstants.PARAM_COUNTRY_ID)));
		
		// get Delegate
		deligate = new CommonOperationsDelegate();
			try {
				//get List of State
				listDTO = deligate.getStates(dto);
				
				//create json object
				json = new Gson().toJson(listDTO);


				//write json response 
				res.getWriter().write(json);

			} catch (SQLException | NoConnectionException e) {
				logger.error("Exception raised"+e.getMessage());
				res.getWriter().write("[]");


			}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}