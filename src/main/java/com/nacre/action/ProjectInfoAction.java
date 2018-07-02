package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nacre.delegate.ProjectManagementDelegate;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectInfoBeanMohan;
import com.nacre.uitl.ImageUtil;

/**
 * @ author Raghav Servlet implementation class ProjectInfoAction
 */
@WebServlet("/ProjectInfoAction")
public class ProjectInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(ProjectInfoAction.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectInfoAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int projectId = Integer.parseInt(request.getParameter("pid"));
		ProjectManagementDelegate delegate = null;
		ProjectInfoBeanMohan bean = null;
		HttpSession session = null;
		String pmImage = null;
		String logo = null;

		try {
			delegate = new ProjectManagementDelegate();
			bean = delegate.getProjectInfById(projectId);
			logger.info(bean);
			if (bean != null) {
				Blob b1 = bean.getPmdto().getProjectManagerId().getImage();
				if (b1 != null) {
					InputStream is1 = b1.getBinaryStream();
					pmImage = ImageUtil.encodeImage(is1);
				}
				Blob b2 = bean.getCdto().getLogo();
				if (b2 != null) {
					InputStream is2 = b2.getBinaryStream();
					logo = ImageUtil.encodeImage(is2);
				}
				bean.setPmImage(pmImage);
				bean.setClientLogo(logo);
				session = request.getSession();
				/* System.out.println(bean); */
				session.setAttribute("projectInfo", bean);
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/project/projectInfo.jsp");
			rd.forward(request, response);
			/* response.getWriter().println(bean); */
		} catch (

		NoConnectionException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (

		SQLException e1)

		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ImageStreamToByteException e) {
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
