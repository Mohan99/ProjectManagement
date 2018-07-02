/**
 * 
 */
package com.nacre.servicei;

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

import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.TaskInfoBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface TaskManagementServiceI {
	/**
	 * @author Chakravarthi K
	 * 
	 * @param Integer
	 *            team lead Id based on which we get moduleId
	 * @return Integer 
	 *              returns value of moduleId
	 *  
	 * @throws SQLException
	 */
	public Integer getModuleID(Integer teamleadId) throws NoConnectionException, SQLException;
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param ModuleTaskDto 
	 *            the task to set
	 * 
	 * @return boolean value true for adding task successfully
	 *                       false when task adding task is not done  
	 *               
	 * @throws SQLException
	 */

	boolean addTask(ModuleTaskDto tDto) throws SQLException, NoConnectionException;
	/**
	 * @author Chakravarthi K
	 * 
	 * @param DeveloperTaskDto 
	 *            the developer to set to a particular task
	 * @return String 
	 * 			   whether developer asssigned or not               
	 * @throws SQLException
	 */

	public Boolean assignTaskToDeveloper(DeveloperTaskDto pmdto) throws SQLException, NoConnectionException;
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @return List 
	 * 			   returns list of tasks that are not assigned to any developer
	 *               
	 * @throws SQLException
	 */

	public List<TaskInfoBean> getNotAssignedTasks(Integer teamleadId) throws SQLException,NoConnectionException;
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @return List 
	 * 			   returns list of developers who are having superior as currently logged in teamlead 
	 *               
	 * @throws SQLException
	 */

	public List<UserDto> getDevelopers() throws SQLException, NoConnectionException;
	
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param no parameter
	 * 
	 * @return List
	 *         to get the List type object of ModuleTaskDto
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	
	public List<ModuleTaskDto> viewTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable;
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param no parameter
	 * 
	 * @return List
	 *         to get the List type object of ModuleTaskDto
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	
	public List<DeveloperTaskDto> viewDeveloperTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable;
	
	
	
	
	
	
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return ModuleTaskDto
	 *         to get the ModuleTaskDto type object 
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	
	public ModuleTaskDto viewIndividualTask(int id) throws DatabaseException, SQLException, NoTaskAvailable;

	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return ModuleTaskDto
	 *         to get the ModuleTaskDto type object for downloading
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable,NoConnectionException     
	 *
	 */
	
	
	public ModuleTaskDto downloadDocument(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException;
	
	
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return TaskViewInfoBean
	 *         to get  objects of TaskViewInfoBean
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable,NoConnectionException     
	 *
	 */
	
	public TaskViewInfoBean viewTaskdetails(int id) throws DatabaseException, SQLException, NoTaskAvailable,NoConnectionException;
	
	
	
	
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param ModuleTaskDto
	 * 
	 * @return Boolean
	 *         to get the boolean type true/false for updatedTaskDetails
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable,NoConnectionException      
	 *
	 */
	
	public Boolean updateTaskDetails(ModuleTaskDto mdto) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException;
	
 
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return Boolean
	 *         to get the boolean type true/false for removedTaskDetails
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable ,NoConnectionException    
	 *
	 */
	
	public Boolean removeTaskDetails(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException;

	public List<ModuleTaskDto> getTaskDetails(int uid) throws SQLException,NoConnectionException;

 
}
