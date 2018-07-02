package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.AddressDto;
import com.nacre.dto.CityDto;
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.StatusDto;

/***
 * 
 * 
 * Servlet implementation class AddProject This class is used to add project
 * along with Add Client with its Contact Person
 * 
 * @author Kunal Marathe
 */

@WebServlet("/addProject")
@MultipartConfig
public class AddProject extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AddProject.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String addProject = null;
		String projTitle = null;
		String projDesc = null;
		String projDoc = null;
		String startDate = null;
		String endDate = null;
		String addClient = null;
		String contactPerson = null;
		InputStream is = null;

		Part part = null;
		byte[] b = null;
		int count = 0;
		int r = 0;

		// get the values from request parameter
		addProject = req.getParameter("addProject");
		addClient = req.getParameter("addClient");
		contactPerson = req.getParameter("contact");
		HttpSession session = null;

		// check for whether request coming From Add Project Form
		if (addProject != null && addProject.equals("addProjectFirst")) {
			ProjectDto pDto = null;
			StatusDto status = null;
			SimpleDateFormat sdf = null;
			java.util.Date sDate = null;
			java.util.Date eDate = null;

			// get Session Object
			session = req.getSession(false);

			// get Part Object for file uploading
			part = req.getPart("document");

			// get InputStream
			is = part.getInputStream();

			// read data from InputStream store into byte array
		
			if(is.available()>0){
			b = new byte[is.available()];

			while ((r = is.read()) != -1) {
				b[count] = (byte) r;
				count++;
			}
			}

			// get request Parameter
			projTitle = req.getParameter("project_title");
			projDesc = req.getParameter("comment");

			startDate = req.getParameter("date");
			endDate = req.getParameter("enddate");

			logger.debug(startDate);

			pDto = new ProjectDto();

			// set the value ProjectDto
			pDto.setProjectTitle(projTitle);
			pDto.setProjectDescription(projDesc);
			
			logger.debug(getFileName(part));

			projDoc = getFileName(part);
			try {
				if(b!=null && b.length>0){
				pDto.setProjectReferenceDocument(new SerialBlob(b));
				}
				pDto.setDocumetnNameWithExtension(projDoc);
			} catch (SQLException e) {
				pDto.setProjectReferenceDocument(null);
				pDto.setDocumetnNameWithExtension(null);
				logger.error("Exception raised during blob conversion" + e.getMessage());
			}

			SimpleDateFormat sdf1 = null;
			// create simpleDateFormat for Date operation
			sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			try {
				logger.debug(startDate);
				logger.debug("length: "+startDate.length());
				sDate = sdf1.parse(startDate);
			} catch (ParseException e) {
				logger.error("Exception raised during Start  Date conversion from String to java.util.Date" + e.getMessage());
			}

			try{	
				eDate = sdf1.parse(endDate);
			} catch (ParseException e) {
				logger.error("Exception raised during End Date conversion from String to java.util.Date" + e.getMessage());
			}
			logger.debug(startDate+" --------------"+sDate);
			logger.debug(endDate+" --------------"+eDate);

			if(startDate.equals("") || startDate == null){
				pDto.setExpectedStartDate(new java.util.Date());
			}
			else{
				pDto.setExpectedStartDate(sDate);				
			}
			pDto.setExpectedEndDate(eDate);

			logger.debug(sDate + "  ---------" + endDate);

			pDto.setProjectCompletionPercentage(0.0);
			// pDto.setClientLocationId(1);
			status = new StatusDto();
			status.setStatusId(StringConstants.STATUS_NOT_ASSIGNED_CONSTANT);
			pDto.setStatus(status);
		
			// store in Session
			session.setAttribute(StringConstants.SESSION_ADD_PROJECT, pDto);
			//session.setAttribute("result",null);


			// giving signal for open next division for for adding client or
			// selecting existing client

//			req.setAttribute("signal", 2);
			session.setAttribute("signal", 2);

		} else if (addClient != null && addClient.equals("add_client")) {
			session = req.getSession(false);

			ClientLocationDto cldto = null;
			ClientDto dto = null;
			AddressDto adto = null;
			CityDto cdto = null;

			dto = new ClientDto();
			dto.setClientName(req.getParameter("client_name"));
			dto.setClientDescription(req.getParameter("comment"));
			part = req.getPart("logo");

			// get InputStream
			is = part.getInputStream();

			// read data from InputStream store into byte array
			b = new byte[is.available()];
			while ((r = is.read()) != -1) {
				b[count] = (byte) r;
				count++;
			}

			adto = new AddressDto();
			adto.setAddress(req.getParameter("address"));
			adto.setPinCode(Integer.parseInt(req.getParameter("pin")));

			cdto = new CityDto();
			cdto.setCityId(Integer.parseInt(req.getParameter("city")));
			adto.setCityId(cdto);

			cldto = new ClientLocationDto();

			cldto.setClientId(dto);
			cldto.setAddressId(adto);

			session.setAttribute(StringConstants.SESSION_ADD_CLIENT_INFO, cldto);
			//session.setAttribute("result",null);

			try {
				dto.setLogo(new SerialBlob(b));
			} catch (SQLException e) {
				logger.error("Exception raised during blob conversion" + e.getMessage());
			}

			// giving signal for open next division for for adding contact
			// person
		//	req.setAttribute("signal", 3);
			session.setAttribute("signal", 3);
		} else if (contactPerson != null && contactPerson.equals("cntPerson")) {
			List<ClientContactPerson> list = null;
			ClientContactPerson persondto = null;

			session = req.getSession(false);

			// get multiple contact person details
			String[] person_name = req.getParameterValues("person_name");
			String[] email = req.getParameterValues("email");
			String[] phone = req.getParameterValues("phone1");
			logger.debug(Arrays.toString(person_name));
			int c = 0;
			ClientLocationDto dto = null;
			list = new ArrayList();
			for (String name : person_name) {
				
				persondto = new ClientContactPerson();

				if (session != null)
					dto = (ClientLocationDto) session.getAttribute(StringConstants.SESSION_ADD_CLIENT_INFO);

				if (dto != null)
					persondto.setClientLocationId(dto);

				persondto.setContactPersonName(name);
				persondto.setEmail(email[c]);
				persondto.setMobileNo(phone[c]);
				
				c=c+1;
				if(!name.equals(""))
					list.add(persondto);
				
			}

			ProjectManagementDelegate delegate = null;

			try {
				delegate=new ProjectManagementDelegate();
				boolean flag = delegate.addClient(list);
				if(flag)
					session.setAttribute("result", StringConstants.CLIENT_ADDED);
				else
					req.setAttribute("err", StringConstants.CLIENT_NOT_ADDED);
			} catch (Exception e) {
				req.setAttribute("err", StringConstants.ERROR_MESSAGE);
				logger.error(e.getMessage());
			}

//			req.setAttribute("signal", 4);
			session.setAttribute("signal", 4);
		} else {

			session = req.getSession(false);
			ProjectDto dto = null;

			if (session != null) {
				dto = (ProjectDto) session.getAttribute(StringConstants.SESSION_ADD_PROJECT);
			
			int locationId = 0;
			try {
				locationId= Integer.parseInt(req.getParameter("locationId"));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			ClientLocationDto cldto = new ClientLocationDto();
			cldto.setClientLocationId(locationId);
			dto.setClientLocationId(cldto);
			ProjectManagementDelegate delegate = null;

			try {
				delegate=new ProjectManagementDelegate();
				boolean flag = delegate.addProject(dto);
				if(flag)
					session.setAttribute("result", StringConstants.PROJECT_ADDED);
				else
					session.setAttribute("result", StringConstants.PROJECT_NOT_ADDED);
				session.removeAttribute(StringConstants.SESSION_ADD_CLIENT_INFO);
				session.removeAttribute(StringConstants.SESSION_ADD_PROJECT);
			} catch (Exception e) {
				session.setAttribute("err", StringConstants.ERROR_MESSAGE);
				session.removeAttribute(StringConstants.SESSION_ADD_CLIENT_INFO);
				session.removeAttribute(StringConstants.SESSION_ADD_PROJECT);
				logger.error(e.getMessage());
			}
		}else{
			session.setAttribute("err", StringConstants.ERROR_MESSAGE);
		}
		}
		res.sendRedirect(req.getServletContext().getContextPath()+"/jsp/add_project.jsp");
//	req.getRequestDispatcher("/jsp/add_project.jsp").forward(req, res);

	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
	private String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}// class