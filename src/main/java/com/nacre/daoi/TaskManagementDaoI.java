/**
 * 
 */
package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;
import com.nacre.formbean.TaskViewInfoBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.UserDto;
import com.nacre.formbean.DeveloperInfoBean;
import com.nacre.formbean.TaskInfoBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface TaskManagementDaoI {
	
	/**
	 * @author Chakravarthi K
	 * @param Integer
	 *            team lead Id based on which we get moduleId
	 * @param Connection
	 *            the Connection to set
	 * @return Integer value of moduleId
	 *  
	 * @throws SQLException
	 */
	public Integer getModuleId(Connection con, Integer teamleadId) throws SQLException;
	
	
	/**
	 * @author Chakravarthi K
	 * @param ModuleTaskDto 
	 *            the task to set
	 * @param Connection
	 *            the Connection to set
	 * @return boolean value true for adding task successfully
	 *                       false when task adding task is not done  
	 *               
	 * @throws SQLException
	 */
	public boolean addTask(Connection con, ModuleTaskDto tDto) throws SQLException;
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param DeveloperTaskDto 
	 *            the developer to set to a particular task
	 * @param Connection
	 *            the Connection to set
	 * @return Integer
	 * 			 positive value for assigning task to developer successfully
	 *           zero when  assigning task to developer is not done  
	 *               
	 * @throws SQLException
	 */

	public Integer assignTaskToDeveloper(Connection con, DeveloperTaskDto pmdto) throws SQLException;

	/**
	 * @author Chakravarthi K
	 * 
	 * @param Connection
	 *            the Connection to set
	 *            
	 * @return List 
	 * 			   returns list of tasks that are not assigned to any developer  
	 *               
	 * @throws SQLException
	 */
	
	public List<TaskInfoBean> getNotAssignedTasks(Connection con,Integer teamleadId) throws SQLException;
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param Connection
	 *            the Connection to set
	 * @return List 
	 * 			   returns list of developers who are having superior as currently logged in teamlead 
	 *               
	 * @throws SQLException
	 */

	public List<UserDto> getDevelopers(Connection con)throws SQLException;

	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection 
	 *               to set connection
	 * 
	 * @return List 
	 *             to get list of object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	public List<ModuleTaskDto> viewTaskDao(Connection con,Integer uId) throws NoConnectionException, DatabaseException;

	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection 
	 *               to set connection
	 * 
	 * @return List 
	 *             to get list of object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	public List<DeveloperTaskDto> viewDeveloperTaskDao(Connection con,Integer uId) throws NoConnectionException, DatabaseException;

	
	
	
	
	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection 
	 *               to set connection ,int
	 * 
	 * @return ProjectDto
	 *             to get ModuleTaskDto type object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	
	
	public ModuleTaskDto viewIndividualTaskDao(Connection con,int id) throws NoConnectionException, DatabaseException;
	
	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection 
	 *               to set connection ,int
	 * 
	 * @return ProjectDto
	 *             to get ModuleTaskDto type object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	
	public ModuleTaskDto downloadDocument(Connection con,int id) throws NoConnectionException, DatabaseException;

    
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param ModuleTaskDto ,Connection 
	 *               to set connection and ModuleTaskDto object
	 * 
	 * @return ModuleTaskDto
	 *             to get ModuleTaskDto type object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	
	
	public boolean updateTaskDetails(ModuleTaskDto mdto,Connection con) throws NoConnectionException, DatabaseException;
    
    
	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection con, Integer moduleTaskId 
	 *               to set connection and moduleTaskId object
	 * 
	 * @return TaskViewInfoBean
	 *             to get TaskViewInfoBean type object 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	
	
public TaskViewInfoBean viewTaskInfoById(Connection con, Integer moduleTaskId) throws NoConnectionException,DatabaseException;
	
	
	/** 
	 * @author Raj Kishore Singh
	 * 
	 * @param Connection 
	 *               to set connection ,int
	 * 
	 * @return boolean 
	 *             to get boolean type true/false return 
	 * 
	 * @throws NoConnectionException, DatabaseException
	 * 
	 */
	
	
	
	
	public boolean removeDocument(Connection con,int id) throws NoConnectionException, DatabaseException;


	public List<ModuleTaskDto> getTaskDetails(Connection con, int uid) throws SQLException;


}
