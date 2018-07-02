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
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.NoConnectionException;
/**
 * Servlet implementation class AddTaskAction
 * @author Chakravarthi K
 * this servlet is used as controller to add new Task
 */
@WebServlet("/AddTaskAction")
@MultipartConfig
public class AddTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=null;
		HttpSession session=null;
		Integer teamleadId=null;
		TaskManagementDelegate delegate = new TaskManagementDelegate();
	    
		String taskTitle=null;
		String taskDescription=null;
		Blob referenceDocument=null;
		String documentName=null;
		String sDate=null;
		String eDate=null;
		taskTitle=request.getParameter("title");
		taskDescription=request.getParameter("description");
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
		/*Integer id=3;
		session.setAttribute("teamleadId", id);
		*/
		//teamleadId=(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
		
		Integer moduleID=Integer.parseInt(request.getParameter("projectmoduleid"));
		
		ModuleTaskDto tDto=new ModuleTaskDto();
	    ProjectModuleDto mDto=new ProjectModuleDto();
	    StatusDto status=new StatusDto();
	    tDto.setTaskTitle(taskTitle);
	    tDto.setTaskDescription(taskDescription);
	    tDto.setTaskReferenceDocument(referenceDocument);
	    tDto.setDocumentNameWithExtension(documentName);
	    tDto.setStartDate(startDate);
	    tDto.setEndDate(endDate);
	    mDto.setProjectModuleId(moduleID);
	    tDto.setProjectModuleId(mDto);
	
	    status.setStatusId(2);
	    tDto.setStatusId(status);
	    float taskCompletionPercent=0;
	    tDto.setTaskCompletionPercent(taskCompletionPercent);
	    InputStream inputStream = null;
        Part filePart = request.getPart("document");
        documentName=extractFileName(filePart);
        tDto.setDocumentNameWithExtension(documentName);
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
            tDto.setTaskReferenceDocument( referenceDocument);
    	try {
    	boolean addTask = delegate.addTask(tDto);
			if(addTask)
			{
				msg="Task Added Successfully";

				request.getSession().setAttribute("result", msg);
			}
			else
			{
				msg="Task not Added ! Try again ";

				request.getSession().setAttribute("err", msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			request.getSession().setAttribute("err", "PEASE TRY LATER");
		} catch (NoConnectionException e) {
			request.getSession().setAttribute("err", "PEASE TRY LATER");
			
			e.printStackTrace();
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/addTask.jsp");
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
