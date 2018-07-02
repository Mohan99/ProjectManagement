/**
 * 
 */
package com.nacre.servicei;

import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.NotificationFormBean;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;

import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AcceptTask;
import com.nacre.formbean.ApproveRejectForTL;
import com.nacre.formbean.AssignTask;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface NotificationServiceI {
	

	/**
	 * @author pravin
	 * @param mtdo
	 * @throws SQLException ,NoConnectionException
	 */
	
	
	public	List<ModuleTaskDto> getNotificationTaskNotSeenStatus(ModuleTaskDto mtdo) throws SQLException, NoConnectionException;

	/**
	 * @author pravin
	 * @param tlId
	 * @throws SQLException ,NoConnectionException
	 */
	
	public List<TaskStatusDto> getNotificationTaskSeenStatus(Integer tlId ) throws SQLException, NoConnectionException;

	/**
	 * @author pravin
	 * @param taskId
	 * @throws SQLException ,NoConnectionException
	 */
	
	public NotificationFormBean getNotificationTaskSeenStatusDetails(Integer taskId) throws SQLException, NoConnectionException;

	
	
	/**
	 * @author pawan
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 * @throws NoConnectionException
	 */
	
	public NotificationModuleStatusDetailsFormBean getModuleStatusNotification( Integer moduleId)
			throws SQLException,NoConnectionException;
	

	/**
	 * @author pawan
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 * @throws NoConnectionException
	 */
	
	public List<ModuleStatusDto> getModuleStatusNotification( UserDto userDto)
			throws SQLException,NoConnectionException;
	
	
	/**
	 * @author Thejaswi S
	 * @return list
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectStatusDto> getNotificationAssignProject(UserDto dto) throws SQLException, NoConnectionException;
	
	/**
	 * @author Thejaswi S
	 * @return list
	 * @param Pid
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectStatusDto> getNotificationAssignProject(Integer pId) throws NoConnectionException, SQLException ;
    
	/**
	 * @author Thejaswi S
	 * @return list
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectStatusDto> getNotificationProjectStatus() throws SQLException, NoConnectionException;

	
	/**
	 * @author Thejaswi S
	 * @return list
	 * @param Pid
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectStatusDto> getNotificationProjectStatus(Integer pId) throws SQLException, NoConnectionException;

	/**
	 * @author Thejaswi S
	 * @return list
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectModuleDto> getNotificationAssignModule() throws SQLException, NoConnectionException;

	/**
	 * @author Thejaswi S
	 * @return list
	 * @param mid
	 * @throws SQLException,NoConnectionException
	 *
	 */
	
	public List<ProjectModuleDto> getNotificationAssignModule(Integer mId) throws SQLException, NoConnectionException;
	
	
	public List<DeveloperTaskDto> notificationDeveloperTask(Integer devId) throws SQLException, NoConnectionException ;
	
	



	public List<DeveloperTaskDto> notinotificationAcceptedTask(Integer supid) throws NoConnectionException, SQLException;
	
	public List<AssignTask> getNotificationAssignedTaskCompleteInfo(Integer dtId) throws NoConnectionException, SQLException ;





	public List<ApproveRejectForTL> getNotificationApproveorRejectForTL(Integer sup,Integer dtId) throws NoConnectionException, SQLException;





	public List<AcceptTask> getNotificationAcceptTask(Integer sup) throws NoConnectionException, SQLException;





	





	public boolean updateStatus(Integer id,String accept) throws NoConnectionException, SQLException;
















	




	

}
