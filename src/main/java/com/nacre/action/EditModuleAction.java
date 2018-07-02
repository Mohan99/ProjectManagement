package com.nacre.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import com.nacre.daoi.daoimpl.ProjectManagementDaoImpl;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.DateUtil;

/**
 * @author sandip
 * Servlet implementation class to EditModuleAction this class is used to
 * edit the module
 * 
 */
@WebServlet("/EditModuleAction")
@MultipartConfig
public class EditModuleAction extends HttpServlet {
	public static final Logger logger = Logger.getLogger(ProjectManagementDaoImpl.class);

	/**
	 * 
	 */
	
	 String extractFileName(Part part) 
	    {
	     String contentDisp = part.getHeader("content-disposition");
	     String[] items = contentDisp.split(";");
	     for(String s : items) {
	      if (s.trim().startsWith("filename")) {
	        return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	     }
	     return "";
	    }
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=null;
		HttpSession session=null;
		Integer ProjectManagerID=null;
		ModuleManagementDelegate delegate = null;
	    

		System.out.println(">>>>>>>>>>>>>>>");
		Integer moduleId=null;
		String moduleTitle=null;
		String moduleDescription=null;
		Blob referenceDocument=null;
		String documentName=null;
		float modulepercent;
		moduleId=Integer.parseInt(request.getParameter("hdmid"));
		moduleTitle=request.getParameter("title");
		moduleDescription=request.getParameter("description");
		String sDate=null;
		String eDate=null;
	     String msg=null;
		sDate=request.getParameter("date");
		eDate=request.getParameter("enddate");
		modulepercent=Float.parseFloat(request.getParameter("modulepercent"));
		ProjectModuleDto pmDto=null;
		ProjectModuleDto pmDto1=null;
		Date startDate=null;
		Date endDate=null;
		Boolean flag;
	    InputStream inputStream = null;
		if(sDate.equals(""))
		{
			startDate=null;
		}
		else
		{
		startDate=com.nacre.uitl.DateUtil.stringToSqlDate(sDate,"MM/dd/yyyy");
		}
		if(eDate.equals(""))
		{
			endDate=null;
		}
		else
		{
		endDate=com.nacre.uitl.DateUtil.stringToSqlDate(eDate,"MM/dd/yyyy");
		}
		response.setContentType("text/html");
		out=response.getWriter();
		session=request.getSession();
		Integer id=2;
		session.setAttribute("ProjectManagerID", id);
		ProjectManagerID=(Integer)session.getAttribute("ProjectManagerID");
		try {
			pmDto = new ProjectModuleDto();
			delegate = new ModuleManagementDelegate();
			
			
		     Part filePart;
			 filePart = request.getPart("document");
		System.out.println(filePart+ ">>>>>>>>>>>>"+request.getParameter("document")); 
			 
			if (filePart!= null) {
				System.out.println(">>>>>>>>>>>>>>>"+filePart.getName());
	            inputStream = filePart.getInputStream();
	            
	            if (inputStream != null) {
	            byte[] content = IOUtils.toByteArray(inputStream);

				   System.out.println(">>>>>>>>>>>>>>>if2"+content.length);
	            try {
	            	if(content.length>0){
					referenceDocument = new SerialBlob(content);
					documentName=extractFileName(filePart);
					System.out.println(documentName+"<<<<<<<<<<<");
					pmDto.setModuleReferenceDocument(referenceDocument);
					pmDto.setDocumentNameWithExtension(documentName);
	            	}else{
	            		
	            		
	            		System.out.println(documentName+"<<<<<<<<<<<else");
	    						
	            	}
	            	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					referenceDocument=null;
				}
	            }else{
	        
/*					pmDto1 = delegate.viewModuleById(moduleId);
					if(pmDto!=null){
						pmDto.setModuleReferenceDocument(pmDto1.getModuleReferenceDocument());
						documentName=pmDto1.getDocumentNameWithExtension();
					    pmDto.setDocumentNameWithExtension(documentName);

					}else{
						logger.info("viewModuleById returns IP STREAM nulllll");
					}
				
*/	            } 

	        }  else{
/*				pmDto1 = delegate.viewModuleById(moduleId);
				if(pmDto!=null){
					pmDto.setModuleReferenceDocument(pmDto1.getModuleReferenceDocument());
					documentName=pmDto1.getDocumentNameWithExtension();
				    pmDto.setDocumentNameWithExtension(documentName);
				}else{
					logger.info("viewModuleById returns nulllll");
				}
*/			}
			
			
		    pmDto.setProjectModuleId(moduleId);
		    pmDto.setModuleTitle(moduleTitle);
			pmDto.setModuleDescription(moduleDescription);

			
			pmDto.setStartDate(startDate);
			pmDto.setEndDate(endDate);

			pmDto.setModuleCompletionPercent(modulepercent);
			flag = delegate.updateModule(pmDto);

			if(flag)
			{
				msg="Module upadted Successfully";

				request.getSession().setAttribute("result", msg);
			}
			else
			{
				msg="Module not updated ! Try again ";

				request.getSession().setAttribute("err", msg);
			}
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/viewmodules");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
