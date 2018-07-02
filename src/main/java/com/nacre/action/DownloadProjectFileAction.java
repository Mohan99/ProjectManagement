package com.nacre.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;

/**
 *@author sindhu Servlet implementation class DownloadFileAction
 */
@WebServlet("/DownloadProjectFileAction")
public class DownloadProjectFileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final int BUFFER_SIZE = 4096;   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadProjectFileAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pId=Integer.parseInt(request.getParameter("pId"));
		/*System.out.println("PID>>>>>>>>>"+pId);*/
		ProjectManagementDelegate delegate=null;
		ProjectDto pdto = new ProjectDto();
		try {
			delegate=new ProjectManagementDelegate();
			pdto=delegate.getProjectById(pId);
			 // gets file name and file blob data
			
            String fileName = pdto.getDocumetnNameWithExtension();
            Blob blob = pdto.getProjectReferenceDocument();
            InputStream inputStream = blob.getBinaryStream();
            int fileLength = inputStream.available();
             
            System.out.println("fileLength = " + fileLength);

            ServletContext context = getServletContext();

            // sets MIME type for the file download
            String mimeType = context.getMimeType(fileName);
            if (mimeType == null) {        
                mimeType = "application/octet-stream";
            }              
             
            // set content properties and header attributes for the response
            response.setContentType(mimeType);
            response.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName);
            response.setHeader(headerKey, headerValue);

            // writes the file to the client
            OutputStream outStream = response.getOutputStream();
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
             
            inputStream.close();
            outStream.close();             
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
