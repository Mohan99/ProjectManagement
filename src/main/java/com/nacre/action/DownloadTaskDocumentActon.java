package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nacre.constants.SQLQueryConstants;
import com.nacre.delegate.TaskManagementDelegate;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;
import com.nacre.uitl.PooledConnection;

/**
 * Servlet implementation class downloadFileActon
 */

/**
 *@author Raj Kishore Singh
 *    to download the document from database
 */
@WebServlet("/DownloadTaskDocumentActon")
public class DownloadTaskDocumentActon extends HttpServlet {
	
	public static final Logger logger = 	Logger.getLogger(DownloadTaskDocumentActon.class);
	private static final long serialVersionUID = 1L;
	// size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadTaskDocumentActon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 Blob blob=null;
		String fileName=request.getParameter("taskReferenceDocument");
		
		int id=Integer.parseInt(request.getParameter("moduleTaskId"));
		TaskManagementDelegate taskmanagementdelegate = new TaskManagementDelegate(id) ;
		
		
		try {
		ModuleTaskDto moduletaskdto=null;
		
		moduletaskdto= taskmanagementdelegate.downloadDocument(id);
			
			fileName=moduletaskdto.getDocumentNameWithExtension();
			   // gets file name and file blob data
             blob = moduletaskdto.getTaskReferenceDocument();
             
            InputStream inputStream = blob.getBinaryStream();
            int fileLength = inputStream.available();
             
            /*System.out.println("fileLength = " + fileLength);*/

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
			
				       } catch (Exception e) {
			// TODO: handle exception
	    	   e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
