package com.nacre.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;

/**
 * @author pavan kumar y
 * Servlet implementation class to GetModulesToAssignTL this class is used to
 * 			get modules to assign team lead
 * 
 */

@WebServlet("/getmodules")
public class GetModulesToAssignTL extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModuleManagementDelegate mmd=null;
		List<ModuleManagementFormBean> list=null;
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		String json=null;
		mmd=new ModuleManagementDelegate();
		res.setContentType("Application/json");
		pw=res.getWriter();
		try {

			HttpSession session =req.getSession();
			Integer projectManagerId= (Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			list=mmd.getModulesToAssignTL(projectManagerId);
			/*for(ProjectModuleDto pmdto:list){
				pw.println("ijnhiotrmho"+pmdto.getModuleTitle());
			}*/

			if(list!=null && list.size()>0){
			json = new Gson().toJson(list);
			System.out.println(json);
			res.getWriter().write("{\"success\":"+json+"}");
			}else{
				res.getWriter().write("{\"err\":\"NO MODULES AVAILABLE\"}");			

			}
			
			//rd=req.getRequestDispatcher("jsp/AssignModuleTO_TeamLead.jsp");
			//req.setAttribute("Modules",list);
			//rd.forward(req,res);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().write("{\"err\":\"PLEASE TRY LATER\"}");			

		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().write("{\"err\":\"PLEASE TRY LATER\"}");			

		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req,res);
	}
}
