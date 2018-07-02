package com.nacre.action;
/**
 *@author pavankumar y to get module details for edit record
 */

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
@WebServlet("/GetModuleDataForEdit")
public class GetModuleDataForEdit extends HttpServlet {
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	Integer mid=Integer.parseInt(req.getParameter("mid"));
	ModuleManagementDelegate delegate=null;
	ProjectModuleDto pdto=null;
	HttpSession session=null;
	res.setContentType("text/html");
	try {
		delegate=new ModuleManagementDelegate();
		pdto=delegate.viewModuleById(mid);
		session=req.getSession();
		session.setAttribute("editmodule", pdto);
		
	 } catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
	}
	res.sendRedirect(req.getServletContext().getContextPath()+"/jsp/EditModule.jsp");
}
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
