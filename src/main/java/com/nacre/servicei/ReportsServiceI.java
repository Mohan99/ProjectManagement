package com.nacre.servicei;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

import java.sql.Connection;
import java.util.List;

import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.exception.NoConnectionException;

public interface ReportsServiceI {
	
	
	//public List<UserDto> taskReport(UserDto dto) throws SQLException, Exception;

	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating Project report 
	 * returns list<ProjectManagerProjectDto>
	 */
	public List<ProjectManagerProjectDto> getProjectReportService(Integer useroleid,Integer userid) throws NoConnectionException;
	
	/**
	 * @author AVEJ SHAIKH 
	 * method used for Generating Module report depending on project id 
	 * it takes Project id as a parameter 
	 * returns list<ProjectModuleDto>
	 */
	public List<ProjectModuleDto> getModuleReportService(Integer projectId,Integer useroleid,Integer userid) throws NoConnectionException;
	/**
	 * @author Ankush Vyavhare
	 *
	 */
	public List<UserDto> taskReportService(ProjectModuleDto dto) throws SQLException, Exception;

	public List<ModuleTaskDto> getReportTaskDeveloper(UserDto u) throws SQLException, NoConnectionException;

	public List<ProjectModuleDto> getTLModuleReport(UserDto u) throws SQLException, NoConnectionException;
}

