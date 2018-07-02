/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.PoolableConnection;
import org.apache.log4j.Logger;

import com.nacre.constants.DbConstants;
import com.nacre.daoi.daoimpl.ReportstDaoImpl;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.ReportsServiceI;
import com.nacre.uitl.PooledConnection;
import com.nacre.daoi.ReportsDaoI;
import com.nacre.daoi.daoimpl.ReportstDaoImpl;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.ReportsServiceI;
import com.nacre.uitl.PooledConnection;

/**
 * @author Ankush Vyavhare
 *
 */
public class ReportsServiceImpl implements ReportsServiceI {

	public static final Logger logger = Logger.getLogger(ReportsServiceImpl.class);

	// Create object ReportDaoImpl() class
	ReportsDaoI reportsDaoI = new ReportstDaoImpl();

	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating Project report 
	 * returns list<ProjectManagerProjectDto>
	 */

	@Override
	public List<ProjectManagerProjectDto> getProjectReportService(Integer useroleid,Integer userid) throws NoConnectionException {
		/*
		 * call the getProjectReportDao() method by passing connection object to it
		 * returns list<ProjectManagerProjectDto>
		 */
		Connection con = PooledConnection.getConnection();
		
		List l =reportsDaoI.getProjectReportDao(con,useroleid,userid);

		return  l; 
 	}

	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating Module report depending on project id
	 *  it takes Project id as a parameter 
	 * returns list<ProjectModuleDto>
	 */
	@Override
	public List<ProjectModuleDto> getModuleReportService(Integer projectId,Integer useroleid,Integer userid) throws NoConnectionException {
		
		/*
		 * call the getProjectReportDao() method by passing project id 
		 * it returns list<ProjectModuleDto>
		 */
		return reportsDaoI.getModuleReportDao(PooledConnection.getConnection(), projectId,useroleid,userid);
	}

	

	/*@Override
	public List<UserDto> taskReport(UserDto dto) throws SQLException, NoConnectionException {
	
		Connection conn=null;
		
	
		
		ReportstDaoImpl daoimp=null;
		List list=new ArrayList<>();
		
		
		daoimp=new ReportstDaoImpl();
		
		conn=PooledConnection.getConnection();
		
	list=	daoimp.taskDAO(conn, dto);
		
		return list;
	}

*/	
	/**
	 * @author Ankush Vyavhare 
	 * method used for Generating Module report depending on module id
	 *  it takes module id as a parameter 
	 * returns list<ProjectModuleDto>
	 */
	@Override
	public List<UserDto> taskReportService(ProjectModuleDto dto) throws SQLException, Exception {
		Connection conn=null;
		
		ReportstDaoImpl daoimp=null;
		List list=new ArrayList<>();
		
	//create DAO implementation class object and calling method	
		
daoimp=new ReportstDaoImpl();
		
		conn=PooledConnection.getConnection();
		
	list=	daoimp.reportTaskDao(conn, dto);
		
	
	conn.close();
		return list;
		
	}
	
	/**
	 * @author Ankush Vyavhare 
	 * method used for Generating Developer report depending on user id
	 *  it takes user id as a parameter 
	 * returns list<ProjectModuleDto>
	 */
	
	

	@Override
	public List<ModuleTaskDto> getReportTaskDeveloper(UserDto u) throws SQLException, NoConnectionException {
	Connection conn=null;
		
		ReportstDaoImpl daoimp=null;
		List<ModuleTaskDto> list =new ArrayList<>();
		
	//create DAO implementation class object and calling method	
		
daoimp=new ReportstDaoImpl();
		
		conn=PooledConnection.getConnection();
		
	list=	daoimp.getReportTaskDeveloper(conn, u);
	
	if(conn!=null){
		conn.close();
	}
		
		return list;
		
	}
	

	/**
	 * @author Ankush Vyavhare 
	 * method used for Generating Developer report depending on user id
	 *  it takes user id as a parameter 
	 * returns list<ProjectModuleDto>
	 */
	
	

	@Override
	public List<ProjectModuleDto> getTLModuleReport(UserDto u) throws SQLException, NoConnectionException {
	Connection conn=null;
		
		ReportstDaoImpl daoimp=null;
		List<ProjectModuleDto> list =new ArrayList<>();
		
	//create DAO implementation class object and calling method	
		
daoimp=new ReportstDaoImpl();
		
		conn=PooledConnection.getConnection();
		
	list=	daoimp.getReportModuleTL(conn, u);
			
			if(conn!=null){
		conn.close();
	}
		
		return list;
		
	}
}
