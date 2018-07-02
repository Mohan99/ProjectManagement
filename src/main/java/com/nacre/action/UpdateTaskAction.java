package com.nacre.action;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
import org.apache.poi.util.IOUtils;

import com.nacre.constants.SQLQueryConstants;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.DateUtil;
import com.nacre.uitl.PooledConnection;

/**
 * Servlet implementation class UpdateTaskAction
 */
/**
 *@author Raj Kishore Singh
 *
 *after the editing the task then to update the task details.
 *
 */
@WebServlet("/UpdateTaskAction")
@MultipartConfig

public class UpdateTaskAction extends HttpServlet {
	
	public static final Logger logger = 	Logger.getLogger(UpdateTaskAction.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate() ;
		ModuleTaskDto mdto=new ModuleTaskDto();	
		boolean res=false;
		
        int ModuleTaskId=Integer.parseInt(request.getParameter("moduletaskid"));
		String tasktitle=request.getParameter("tasktitle");
		String taskdescription=request.getParameter("taskdescription");
		 Part filePart = request.getPart("taskreferencedocument"); 
		
		String documentNameWithExtension=extractFileName(filePart);
		
		String startdate=request.getParameter("startdate");
		String enddate=request.getParameter("enddate");
		
		InputStream inputStream = null;
	
      

        ServletContext context = getServletContext();

// sets MIME type for the file download
String mimeType = context.getMimeType("taskreferencedocument");

Blob blob =null;
byte [] content=null;
if (filePart != null) {
	
    // obtains input stream of the upload file
    inputStream = filePart.getInputStream();

     

    if (inputStream != null) {
        // fetches input stream of the upload file for the blob column
    	try {
		 content=IOUtils.toByteArray(inputStream);
		  if(content.length>0)
    		blob =new SerialBlob(content);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    	
    }	
       
    }



	Date startDate=null;
	Date endDate=null;
	if(startdate.equals(""))
	{
		startDate=null;
	}
	else
	{
	startDate=com.nacre.uitl.DateUtil.stringToSqlDate(startdate, "MM/dd/yyyy");
	}
	if(enddate.equals(""))
	{
		endDate=null;
	}
	else
	{
	endDate=com.nacre.uitl.DateUtil.stringToSqlDate(enddate,"MM/dd/yyyy" );
	}


		ProjectModuleDto pmdto=new ProjectModuleDto();
		StatusDto sdto=new StatusDto();
		
		mdto.setTaskTitle(tasktitle);
		mdto.setTaskDescription(taskdescription);
		mdto.setTaskReferenceDocument(blob);
		if(content.length>0){
		mdto.setDocumentNameWithExtension(documentNameWithExtension);
		}
		mdto.setStartDate(startDate);
		mdto.setEndDate(endDate);
	   //pmdto.setProjectModuleId(projectmoduleid);
       mdto.setProjectModuleId(pmdto);	
       //sdto.setStatusId(statusid);
       mdto.setStatusId(sdto);
       mdto.setModuleTaskId(ModuleTaskId);
        String msg=null;
		try {
			res = taskmanagementdelegate.updateTaskDetails(mdto);
		
			if(res)
			{
				msg="Task Updated Successfully";

				request.getSession().setAttribute("result", msg);
			/*RequestDispatcher rd=request.getRequestDispatcher("/viewTaskAction");
			rd.forward(request, response);
			*/
			}
			else
			{
				msg="Task Not Updated Try again";

				request.getSession().setAttribute("err", msg);

			}
		  }catch (Exception e) {
			// TODO: handle exception
			  e.getMessage();

				request.getSession().setAttribute("err", "PEASE TRY LATER");
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/viewTaskAction");
        
	} 
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}