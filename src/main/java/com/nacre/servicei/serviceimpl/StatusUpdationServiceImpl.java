/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.daoi.StatusUpdationsDaoI;
import com.nacre.daoi.daoimpl.StatusUpdationsDaoImpl;
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
import com.nacre.uitl.PooledConnection;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StatusUpdationServiceImpl implements StatusUpdationsServiceI {

	public static final Logger logger = 	Logger.getLogger(StatusUpdationServiceImpl.class);
	
	/**
	 * @author Pujitha
	 * @param dto
	 * @param i
	 * @return int
	 */
	public int insertTask_Status( TaskStatusDto dto, int i) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.insertTask_Status( dto, i);
		
	}
	
	public int insertModule_Status( ModuleStatusDto dto) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		Connection con=PooledConnection.getConnection();
		int status =daoI.insertModule_Status(con, dto);
		con.close();
		return status;
		}
	
	public int insertProject_Status( ProjectStatusDto dto) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		Connection con=PooledConnection.getConnection();
		int status =daoI.insertProject_Status(con, dto);
		con.close();
		return status;
	}
	
	public int Percentage_Completion_Task( ModuleTaskDto dto) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		Connection con=PooledConnection.getConnection();
		int percent =daoI.Percentage_Completion_Task(con, dto);
		con.close();
		return percent;
		
	}
	
	/**
	 * @author Ram Babu
	 * @param dto
	 * @param a
	 * @return int
	 */
	public int Percentage_Completion_Module( ModuleStatusDto dto, int a) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.Percentage_Completion_Module(dto , a);
	}
	
	/**
	 * @author Biranchi
	 * @param dto
	 * @param b
	 * @return Integer
	 * 
	 * 
	 */
	public int Percentage_Completion_Project( ProjectStatusDto dto,int b,Integer userID) throws SQLException, NoConnectionException
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.Percentage_Completion_Project( dto, b,userID);
		
	}

	/**
	 * @author Ram Babu
	 * @param i
	 * @return ProjectModuleDto
	 */
	@Override
	public ProjectModuleDto getModulePercentage(int i) 
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getModulePercentage(i);
	}

	/**
	 * @author Ram Babu
	 * @param i
	 * @return List<ProjectModuleDto>
	 */
	@Override
	public List<ProjectModuleDto> getModules(int i) 
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getModules(i);
	}

	@Override
	public ProjectDto getProjectPercentage(int i) 
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getProjectPercentage(i);
	}

	
	@Override
	public List<ProjectManagerProjectDto> getProjects(int i) 
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getProjects(i);
	}

	/**
	 * @author Pujitha
	 * @param cid1
	 * @return ModuleTaskDto
	 */
	@Override
	public ModuleTaskDto getTaskCompletionPercentage(int cid1) 
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getTaskCompletionPercentage(cid1);
	}

	/**
	 * @author Pujitha
	 * @param i
	 * @return List
	 */
	@Override
	public List<DeveloperTaskDto> getAllTaskId(int i)
	{
		StatusUpdationsDaoI daoI=new StatusUpdationsDaoImpl();
		return daoI.getAllTaskId(i);
	}
	
}
