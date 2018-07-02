package com.nacre.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.DateUtil;

/**
 * @author Raghav Servlet implementation class to Edit ProjectAction
 * 
 */
@WebServlet("/EditProjectAction")
@MultipartConfig
public class EditProjectAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		ProjectManagementDelegate delegate = null;
		ProjectDto pdto = null;
		try {
			pdto = new ProjectDto();
			delegate = new ProjectManagementDelegate();

			int projectId = Integer.parseInt(request.getParameter("pid"));
			/*System.out.println("ProjectId::" + projectId);*/
			String title = request.getParameter("txttitle");
			String description = request.getParameter("txtdescription");
			String referenceDoc = request.getParameter("txtdoc");

			if (referenceDoc == null || referenceDoc == "") {
				pdto.setProjectReferenceDocument(null);
				pdto.setDocumetnNameWithExtension(null);
			} else {
				int index = referenceDoc.lastIndexOf("\\");
				String fileName = referenceDoc.substring(index + 1);
				System.out.println(title + "  , " + projectId + "," + referenceDoc + "," + fileName);
				InputStream is = null;
				byte[] b = null;
				int r = 0;
				int count = 0;

				/*System.out.println("FileName::" + fileName);*/
				is = new FileInputStream(referenceDoc);
				b = new byte[is.available()];
				while ((r = is.read()) != -1) {
					b[count++] = (byte) r;
				}
				pdto.setDocumetnNameWithExtension(fileName);
				pdto.setProjectReferenceDocument(new SerialBlob(b));
			}
			String address = request.getParameter("txtloc");
			int locationId=delegate.getClientLocation(address);
			/*System.out.println(address+"......."+locationId);*/
			
			String startDate = request.getParameter("txtSdate");
			String endDate = request.getParameter("txtEdate");
			Double percentage = Double.parseDouble(request.getParameter("txtpercentage"));
			String extension = request.getParameter("exdoc");
			int status = Integer.parseInt(request.getParameter("txtstatus"));

			pdto.setProjectId(projectId);
			pdto.setProjectTitle(title);
			pdto.setProjectDescription(description);

			ClientLocationDto cldto = new ClientLocationDto();
			cldto.setClientLocationId(locationId);

			pdto.setClientLocationId(cldto);
			java.util.Date sdfs = DateUtil.getSqlFromStringDate(startDate);
			java.util.Date sdfe = DateUtil.getSqlFromStringDate(endDate);

			java.sql.Date sqlStartDate = new java.sql.Date(sdfs.getTime());
			java.sql.Date sqlEndDate = new java.sql.Date(sdfe.getTime());
			pdto.setExpectedStartDate(sqlStartDate);
			pdto.setExpectedEndDate(sqlEndDate);

			pdto.setProjectCompletionPercentage(percentage);

			StatusDto sdto = new StatusDto();
			sdto.setStatusId(status);
			pdto.setStatus(sdto);

			flag = delegate.updateProject(projectId, pdto);

			if (flag) {
				System.out.println("Updated Successfully");
				response.getWriter().println("Updated Successfully");
			} else {
				System.out.println("Updated Failed");
				response.getWriter().println("Updation Failed");
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
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
