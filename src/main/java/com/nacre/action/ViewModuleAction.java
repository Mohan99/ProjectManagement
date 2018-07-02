package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.bcel.classfile.PMGClass;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
  
/**
 * @author pavan kumar y
 * Servlet implementation class to ViewModuleAction this class is used to
 * 			disply all modules
 * 
 */



@WebServlet("/viewmodules")
public class ViewModuleAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModuleManagementDelegate mmd=null;
		List<ProjectModuleDto> list=null;
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		HttpSession session=null;
		mmd=new ModuleManagementDelegate();
		session=req.getSession();
		try {
			pw=res.getWriter();
			res.setContentType("text/html");

			Integer ProjectManagerId= (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			list=mmd.viewMOdules(ProjectManagerId);
			/*for(ProjectModuleDto pmdto:list){
				System.out.println(pmdto.getDocumentNameWithExtension());
			}*/
	
			session.setAttribute("viewModules",list);
			rd=req.getRequestDispatcher("jsp/view_edit_addModule.jsp");
			rd.forward(req,res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
		
	}
}
