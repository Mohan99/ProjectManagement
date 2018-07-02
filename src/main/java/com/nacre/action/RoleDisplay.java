package com.nacre.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.delegate.UserManagementDelegate;
import com.nacre.dto.RoleDto;

/**
 * @author Avinash
 * Servlet implementation class RoleDisplay
 * Disply the Role S 
 */
@WebServlet("/RoleDisplay")
public class RoleDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("application/json");
		UserManagementDelegate delegate=null;
		List<RoleDto> list=null;
		RequestDispatcher rd=null;
		//get delegate
		try{
			delegate=new UserManagementDelegate();
			list=delegate.getRoleDisply();
			Gson g=new Gson();
			String json=g.toJson(list);
			System.out.println(json);
			response.getWriter().print(json);
			
		}catch(Exception e){
			e.printStackTrace();
		
			response.getWriter().print("[]");
			
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
