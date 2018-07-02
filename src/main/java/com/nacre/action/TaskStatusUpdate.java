package com.nacre.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.constants.StringConstants;
import com.nacre.delegate.StatusUpdationsDelegate;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.exception.NoConnectionException;

/**
 * @author Pujitha
 * Servlet implementation class TaskStatusUpdate
 * 
 * Servlet for updating the TaskStatus
 */

@WebServlet("/TaskStatusUpdate")
public class TaskStatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskStatusUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	/*String updateDate;*/
	String difficulties;
	int developerTaskId;
	int currentTaskCompletion;
	String taskStatusInfo;

	
	/*updateDate=request.getParameter("updationDate");*/
	difficulties=request.getParameter("difficulties");
	developerTaskId=Integer.parseInt(request.getParameter("hidden1"));
	currentTaskCompletion=Integer.parseInt(request.getParameter("c_t_c_p").trim());
	taskStatusInfo=request.getParameter("Task_status_info");
	System.out.println("go to DB"+developerTaskId+" "+difficulties+" "+currentTaskCompletion);
	TaskStatusDto td=new TaskStatusDto();
	td.setDifficulties(difficulties);
	td.setStatusInfo(taskStatusInfo);
	/*SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	java.util.Date date = null;
	try {
		date=sdf1.parse(updateDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	Date date=new Date();
	td.setUpdationDate(date);
	
	DeveloperTaskDto dt=new DeveloperTaskDto();
	dt.setDeveloperTaskId(developerTaskId);
	td.setDeveloperTaskId(dt);
	int i = 0;
	StatusUpdationsDelegate sud=new StatusUpdationsDelegate();
	try {
		i=sud.insertTask_Status(td, currentTaskCompletion);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	String success=null;
	if(i!=0)
	{
		System.out.println("task status inserted");
		success="TaskStatus is updated into DataBase";
		request.getSession().setAttribute("success", success);

	}
	else
	{
		System.out.println("task status is not inserted");
		success="TaskStatus is not updated into DataBase";
		request.getSession().setAttribute("err", success);
		///response.sendRedirect("ViewDeveloperTaskAction");
	}
	response.sendRedirect("ViewDeveloperTaskAction");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
