package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;

public interface StatusUpdationsDaoI 
{
	/**
	 * @author Pujitha
	 * @param dto
	 * @param i
	 * @return int
	 * @throws SQLException
	 */
	public int insertTask_Status( TaskStatusDto dto,int i) throws SQLException;
	public int insertModule_Status(Connection con, ModuleStatusDto dto) throws SQLException;
	public int insertProject_Status(Connection con, ProjectStatusDto dto) throws SQLException;
	public int Percentage_Completion_Task(Connection con, ModuleTaskDto dto) throws SQLException;
	/**
	 * @author Ram Babu
	 * @param dto
	 * @param a
	 * @return Integer
	 * @throws SQLException
	 */
	public int Percentage_Completion_Module(ModuleStatusDto dto, int a) throws SQLException;
	/**
	 * @author Biranchi
	 * @param dto
	 * @param b
	 * @return Integer
	 * @throws SQLException
	 */
	public int Percentage_Completion_Project(ProjectStatusDto dto, int b,Integer userId) throws SQLException;
	
	/**
	 * @author Ram Babu
	 * @param i
	 * @return List
	 */
	public List<ProjectModuleDto> getModules(int i) ;
	/**
	 * @author Biranchi
	 * @param i
	 * @return List
	 */
	public List<ProjectManagerProjectDto> getProjects(int i);
	/**
	 * @author Ram Babu
	 * @param i
	 * @return  ProjectModuleDto
	 */
	public ProjectModuleDto getModulePercentage(int i);
	/**
	 * @author Biranchi
	 * @param i
	 * @return ProjectDto
	 */
	public ProjectDto getProjectPercentage(int i);
	/**
	 * @author Pujitha
	 * @param cid1
	 * @return ModuleTaskDto
	 */
	public ModuleTaskDto getTaskCompletionPercentage(int cid1);
	/**
	 * @author Pujitha
	 * @param i
	 * @return List
	 */
	public List<DeveloperTaskDto> getAllTaskId(int i);
}
