package com.nacre.action;

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

import org.apache.poi.util.IOUtils;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.NoConnectionException;
/***
 * 
 * 
 * Servlet implementation class AddModule This class is used to add module
 * 
 * 
 * @author sandip
 */

@WebServlet("/AddModuleAction")
@MultipartConfig
public class AddModuleAction extends HttpServlet {
	
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
	
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		PrintWriter out=null;
		HttpSession session=null;
		Integer ProjectManagerID=null;
		ModuleManagementDelegate delegate = null;
	    
		String taskTitle=null;
		String taskDescription=null;
		Blob referenceDocument=null;
		String documentName=null;
		
		taskTitle=request.getParameter("title");
		taskDescription=request.getParameter("description");
		String sDate=null;
		String eDate=null;
		sDate=request.getParameter("date");
		eDate=request.getParameter("enddate");
		
		Date startDate=null;
		Date endDate=null;
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
		Integer ProjectManagerId= (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		Integer projectId=3;
		Integer projectmanagerprojectID=null;
/*
		session.setAttribute("ProjectManagerID", ProjectManagerId);
		ProjectManagerId=(Integer)session.getAttribute("ProjectManagerID");
		*/
		projectId=Integer.parseInt(request.getParameter("pid"));
		delegate = new ModuleManagementDelegate();
		try {
			projectmanagerprojectID= delegate.getProjectManagerProjectId(ProjectManagerId,projectId);
			  
		} catch (NoConnectionException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProjectModuleDto pmDto=new ProjectModuleDto();
		ProjectModuleDto pmDto1=null;
	    ProjectManagerProjectDto pmpDto=new ProjectManagerProjectDto();
	    StatusDto status=new StatusDto();
	    pmDto.setModuleTitle(taskTitle);
	    pmDto.setModuleDescription(taskDescription);
	    pmDto.setModuleReferenceDocument(referenceDocument);
	    pmDto.setDocumentNameWithExtension(documentName);
	    pmDto.setStartDate(startDate);
	    pmDto.setEndDate(endDate);
	    pmpDto.setProjectManagerProjectId(projectmanagerprojectID);
	    pmDto.setProjectManagetProjectId(pmpDto);
	//========================================
	    status.setStatusId(2);
	    pmDto.setStatusId(status);
	    float taskCompletionPercent=0;
	    pmDto.setModuleCompletionPercent(taskCompletionPercent);
	    InputStream inputStream = null;
	    
	 	try {
        Part filePart;
			filePart = request.getPart("document");	
        documentName=extractFileName(filePart);
        pmDto.setDocumentNameWithExtension(documentName);
        if (filePart != null) {
            inputStream = filePart.getInputStream();
            byte[] content = IOUtils.toByteArray(inputStream);
            try {
            	if(content.length>0){
				referenceDocument = new SerialBlob(content);
            	}
            	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				referenceDocument=null;
			}    

        }
     
      String msg=null;
            pmDto.setModuleReferenceDocument( referenceDocument);
   
			Integer result = delegate.addModule(pmDto);
			
			if(result==1)
			{
				msg="Module Added Successfully";

				request.getSession().setAttribute("result", msg);
			}
			else
			{
				msg="Module not Added ! Try again ";

				request.getSession().setAttribute("err", msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			request.getSession().setAttribute("err", "PEASE TRY LATER");
		} catch (NoConnectionException e) {
			request.getSession().setAttribute("err", "PEASE TRY LATER");
			
			e.printStackTrace();
		}
	 	catch (ServletException e1) {
			request.getSession().setAttribute("err", "PEASE TRY LATER");
				e1.printStackTrace();
		} 
	 	catch (ClassNotFoundException e) {
			request.getSession().setAttribute("err", "PEASE TRY LATER");
			e.printStackTrace();
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/AddModule.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
