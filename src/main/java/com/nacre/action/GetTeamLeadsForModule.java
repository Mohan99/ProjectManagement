package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.constants.StringConstants;
import com.nacre.delegate.ModuleManagementDelegate;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;


/***
 * 
 * 
 * Servlet implementation class GetTeamLeads 
 * this class is used to get all team leads to assign modules
 * 
 * @author pavan kumar y
 */


@WebServlet("/GetTeamLeadsForModule")
public class GetTeamLeadsForModule extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModuleManagementDelegate mmd=null;
		List<ModuleManagementFormBean> list=null;
		String json=null;
		mmd=new ModuleManagementDelegate();
		res.setContentType("application/json");
		
		try {
HttpSession session = req.getSession();

			Integer pmId =(Integer) session.getAttribute(StringConstants.SESSION_USERID_CONSTANT);
			list=mmd.getTeamLeaderDetails(pmId);
		
			if(list!=null && list.size()>0){
				System.out.println("list is not null");
				for(ModuleManagementFormBean pmdto:list){
			  System.out.println("ijnhiotrmho"+pmdto.getMobileNo());
			}

			json = new Gson().toJson(list);
			res.getWriter().write("{\"success\":"+json+"}");	
			}else{
				res.getWriter().write("{\"err\":\"NO TEAM LEADS AVAILABLE\"}");	
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().write("{\"err\":\"PLEASE TRY AFTER SOME TIME\"}");	
			
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			res.getWriter().write("{\"err\":\"PLEASE TRY AFTER SOME TIME\"}");	
				}

		
	}
	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, res);
		}
		
	
	
}
