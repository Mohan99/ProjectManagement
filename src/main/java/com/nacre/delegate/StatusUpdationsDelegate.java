/**
 * 
 */
package com.nacre.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.StatusUpdationsServiceI;
import com.nacre.servicei.serviceimpl.StatusUpdationServiceImpl;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StatusUpdationsDelegate 
{

public static final Logger logger = 	Logger.getLogger(StatusUpdationsDelegate.class);


/**
 * @author Pujitha
 * @param dto
 * @param i
 * @return int
 * @throws SQLException
 * @throws NoConnectionException
 */
public int insertTask_Status( TaskStatusDto dto, int i) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI taskStatusService=new StatusUpdationServiceImpl();
	return taskStatusService.insertTask_Status(dto, i);
}

public int insertModule_Status( ModuleStatusDto dto) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI moduleStatusService=new StatusUpdationServiceImpl();
	return moduleStatusService.insertModule_Status(dto);
}

public int insertProject_Status( ProjectStatusDto dto) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI projectStatusService=new StatusUpdationServiceImpl();
	return projectStatusService.insertProject_Status(dto);
}

public int Percentage_Completion_Task( ModuleTaskDto dto) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI taskComPercentage=new StatusUpdationServiceImpl();
	return taskComPercentage.Percentage_Completion_Task(dto);
}
	
/**
 * @author Ram babu
 * @param dto
 * @param a
 * @return Integer
 * @throws SQLException
 * @throws NoConnectionException
 */
public int Percentage_Completion_Module( ModuleStatusDto dto, int a) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI moduleComPercentage=new StatusUpdationServiceImpl();
	return  moduleComPercentage.Percentage_Completion_Module(dto ,a);
}

/**
 * @author Biranchi
 * @param dto
 * @param b
 * @return
 * @throws SQLException
 * @throws NoConnectionException
 */
public int Percentage_Completion_Project( ProjectStatusDto dto,int b,Integer userId ) throws SQLException, NoConnectionException
{
	StatusUpdationsServiceI projectComPercentage=new StatusUpdationServiceImpl();
	return projectComPercentage.Percentage_Completion_Project(dto,b,userId);
}

/**
 * @author Ram Babu
 * @param i
 * @return ProjectModuleDto
 */
public ProjectModuleDto getModulePercentage(int i)
{
	StatusUpdationsServiceI moduleComPercentage =new StatusUpdationServiceImpl(); 
	return moduleComPercentage.getModulePercentage(i);
}

/**
 * @author Ram Babu
 * @param i
 * @return List
 */
public List<ProjectModuleDto>  getModules(int i)
{
	StatusUpdationsServiceI getModule =new StatusUpdationServiceImpl();
	return getModule.getModules(i);
}

/**
 * @author Biranchi
 * @param i
 * @return List 
 */
public List<ProjectManagerProjectDto> getProjects(int i)
{
	StatusUpdationsServiceI getProject =new StatusUpdationServiceImpl();
	return getProject.getProjects(i);
	
}

/**
 * @author Biranchi
 * @param i
 * @return ProjectDto
 */
public ProjectDto getProjectPercentage(int i)
{
	StatusUpdationsServiceI projectComPercentage =new StatusUpdationServiceImpl();
	return projectComPercentage.getProjectPercentage(i);
}

/**
 * @author Pujitha
 * @param cid1
 * @return ModuletaskDto
 */
public ModuleTaskDto getTaskCompletionPercentage(int cid1)
{
	StatusUpdationsServiceI taskComPercentage =new StatusUpdationServiceImpl();
	return taskComPercentage.getTaskCompletionPercentage(cid1);
}

/**
 * @author Pujitha
 * @param i
 * @return List
 */
public List<DeveloperTaskDto> getAllTaskId(int i)
{
	StatusUpdationsServiceI getTask =new StatusUpdationServiceImpl();
	return getTask.getAllTaskId(i);
	
}


}
