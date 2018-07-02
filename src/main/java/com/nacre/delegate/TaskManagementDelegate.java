/**
 * 
 */
package com.nacre.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;
import com.nacre.formbean.TaskViewInfoBean;
import com.nacre.servicei.TaskManagementServiceI;
import com.nacre.servicei.serviceimpl.TaskManagementServiceImpl;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.DeveloperInfoBean;
import com.nacre.formbean.TaskInfoBean;
import com.nacre.servicei.TaskManagementServiceI;
import com.nacre.servicei.serviceimpl.TaskManagementServiceImpl;
import com.nacre.uitl.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class TaskManagementDelegate {

public static final Logger logger = 	Logger.getLogger(TaskManagementDelegate.class);

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
public Integer getModuleId(Integer teamleadId) throws NoConnectionException, SQLException {
	// TODO Auto-generated method stub
	return new TaskManagementServiceImpl().getModuleID(teamleadId);
}
/**
 * @author Chakravarthi K
 * 
 * @param ModuleTaskDto 
 *            the task to set
 * 
 * @return boolean value true for adding task successfully
 *                       false when task adding task is not done  
 *               
 * @throws SQLException,NoConnectionException
 */


public boolean addTask(ModuleTaskDto tDto) throws SQLException, NoConnectionException {
	return new TaskManagementServiceImpl().addTask(tDto);
}
/**
 * @author Chakravarthi K
 * 
 * @param DeveloperTaskDto 
 *            the developer to set to a particular task
 * @return String 
 * 			   whether developer assigned or not               
 * @throws SQLException,NoConnectionException
 */
public Boolean assignTaskToDeveloper(DeveloperTaskDto pmdto) throws SQLException, NoConnectionException{
	// TODO Auto-generated method stub
	return new TaskManagementServiceImpl().assignTaskToDeveloper(pmdto);
}

/**
 * @author Chakravarthi K
 * 
 * @return List 
 * 			   returns list of tasks that are not assigned to any developer
 *               
 * @throws SQLException,NoConnectionException
 */
public List<TaskInfoBean> getNotAssignedTasks(Integer teamleadId) throws SQLException,NoConnectionException
{
	return new TaskManagementServiceImpl().getNotAssignedTasks(teamleadId);
}

/**
 * @author Chakravarthi K
 * 
 * @return List 
 * 			   returns list of developers who are having superior as currently logged in teamlead 
 *               
 * @throws SQLException,NoConnectionException
 */

public List<DeveloperInfoBean> getDevelopers() throws SQLException,NoConnectionException
{
	TaskManagementServiceI taskService=null;
	taskService=new TaskManagementServiceImpl();
	List<UserDto> listDto = taskService.getDevelopers();
	List<DeveloperInfoBean> listbean = new ArrayList<>();
	DeveloperInfoBean bean = null;
	
	for(UserDto dto : listDto){
		bean = new DeveloperInfoBean();
		bean.setFirstName(dto.getFirstName());
		bean.setEmail(dto.getEmail());
		bean.setUserId(dto.getUserId());
		bean.setMobileNo(dto.getMobileNo());
		try {
			Blob b  = dto.getImage();
			if(b!=null)
			bean.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		listbean.add(bean);
		
	}
	return listbean;
	
}


public TaskManagementDelegate(int id) {
	// TODO Auto-generated constructor stub
}

public TaskManagementDelegate() {
	// TODO Auto-generated constructor stub
}

/**
 * @author Raj Kishore Singh
 * 
 * @param no parameter
 * 
 * @return List 
 *         to get the group of moduletaskdto object
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */
public List<ModuleTaskDto> viewTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .viewTask(uId);
	
}
/**
 * @author Raj Kishore Singh
 * 
 * @param no parameter
 * 
 * @return List 
 *         to get the group of moduletaskdto object
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */
public List<DeveloperTaskDto> viewDeveloperTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .viewDeveloperTask(uId);
	
}



/**
 * @author Raj Kishore Singh
 * 
 * @param int id
 * 
 * @return ModuleTaskDto 
 *         to get the modiletaskdto object
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */


public ModuleTaskDto viewIndividualTask(int id) throws DatabaseException, SQLException, NoTaskAvailable
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .viewIndividualTask(id);
	
}




/**
 * @author Raj Kishore Singh
 * 
 * @param int id
 * 
 * @return ModuleTaskDto 
 *         to get the modiletaskdto object for downloading document
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */


public ModuleTaskDto downloadDocument(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .downloadDocument(id);
	
}


/**
 * @author Raj Kishore Singh
 * 
 * @param int id
 * 
 * @return TaskViewInfoBean
 *         to get the object of TaskViewInfoBean 
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 * @throws NoConnectionException 
 *  
 *
 */
public TaskViewInfoBean viewTaskDetails(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI.viewTaskdetails(id);
	
}









/**
 * @author Raj Kishore Singh
 * 
 * @param int id
 * 
 * @return Boolean 
 *         to get the boolean type true/false updatedtaskdetails
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */





public Boolean updateTaskDetails(ModuleTaskDto mdto) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .updateTaskDetails(mdto);
	
}


/**
 * @author Raj Kishore Singh
 * 
 * @param int id
 * 
 * @return Boolean 
 *         to get the boolean type true/false removedtaskdetails
 *    
 * @throws  DatabaseException, SQLException, NoTaskAvailable      
 *
 */


public Boolean removeTaskDetails(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException
{
    TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .removeTaskDetails(id);
	
}
public List<ModuleTaskDto> getTaskDetails(int uid) throws SQLException, NoConnectionException {
	TaskManagementServiceI serviceI =new TaskManagementServiceImpl();
	return serviceI .getTaskDetails(uid);
}





}
