package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nacre.dao.test.APP;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.exception.NoConnectionException;


/***
 * 
 * 
 * Servlet implementation class DeleteModuleAction This class is used to delete module
 * 
 * 
 * @author sandip
 */

@WebServlet("/DeleteModuleAction")
public class DeleteModuleAction extends HttpServlet{	
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	Integer projectModuleId=null;
	ModuleManagementDelegate mmd=null;

	projectModuleId=Integer.parseInt(req.getParameter("txtmoduleId"));
    System.out.println("moduleId:"+projectModuleId);

	mmd=new ModuleManagementDelegate();
	try {
		boolean flag=mmd.deleteModule(projectModuleId);
		
     System.out.println("result:"+flag);
		res.getWriter().println("response:::"+flag);
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
