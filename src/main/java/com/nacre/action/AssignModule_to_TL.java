package com.nacre.action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/***
 * 
 * 
 * Servlet implementation class AddProject This class is used to assign module to team lead
 * 
 * @author pavan kumar y
 */

@WebServlet("/assignmoduletoTl")
public class AssignModule_to_TL extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	ModuleManagementDelegate mmd=null;
	ProjectModuleDto pmdto=null;
	UserDto udto=null;
	mmd=new ModuleManagementDelegate();
	pmdto=new ProjectModuleDto();
	udto=new UserDto();
	udto.setUserId(Integer.parseInt(req.getParameter("txtTlId")));
	System.out.println(">>>>>>>>>>>"+Integer.parseInt(req.getParameter("txtTlId"))+"---"+Integer.parseInt(req.getParameter("txtmoduleId")));
	pmdto.setProjectModuleId(Integer.parseInt(req.getParameter("txtmoduleId")));
	pmdto.setTeamLeadId(udto);
	try {
		Integer result=mmd.assignTeamlead(pmdto);

	if(result==1){
		//res.getWriter().write("{\"success\":"+"module Assigned"+"}");	
		res.getWriter().write("record assigned");
	}
	else
		res.getWriter().write("{\"err\":"+"module not assigned"+"}");		
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		res.getWriter().write("{\"err\":\"PLEASE TRY AFTER SOME TIME\"}");	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		res.getWriter().write("{\"err\":\"PLEASE TRY AFTER SOME TIME\"}");	
	}
 }
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, res);
 }
}
