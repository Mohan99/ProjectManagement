package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ClientDto;
import com.nacre.exception.NoConnectionException;

import sun.usagetracker.UsageTrackerClient;

import com.nacre.dto.UserDto;

public interface ReportsDaoI {
	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating project report it takes connection object as a parameter 
	 * returns list<ProjectManagerProjectDto>
	 */
	public List<ProjectManagerProjectDto> getProjectReportDao(Connection con,Integer useroleid,Integer userid) throws NoConnectionException;

	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating Module report depending on
	 * project id it takes connection object and Project id as a parameter
	 * returns list<ProjectModuleDto>
	 */
	public List<ProjectModuleDto> getModuleReportDao(Connection con, Integer projectId,Integer useroleid,Integer userid) throws NoConnectionException;
	
	
 //public List	taskDAO(Connection conn,UserDto udto) throws SQLException;
 
	/**
	 * @author Ankush Vyavhare
	 *
	 */
 
 public List  reportTaskDao(Connection conn,ProjectModuleDto udto) throws SQLException;
 
 
 public List<ModuleTaskDto>  getReportTaskDeveloper(Connection conn,UserDto u) throws SQLException;

List<ProjectModuleDto> getReportModuleTL(Connection conn, UserDto u) throws SQLException;
 
}
