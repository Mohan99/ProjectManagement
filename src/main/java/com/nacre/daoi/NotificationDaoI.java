/**
 * 
 */
package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.formbean.AcceptTask;
import com.nacre.formbean.ApproveRejectForTL;
import com.nacre.formbean.AssignTask;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.formbean.NotificationFormBean;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface NotificationDaoI {
	
	/**
	 * @author pravin
	 * @param con
	 * @param mtdo
	 * @return
	 * @throws SQLException
	 */

	public	List<ModuleTaskDto> getNotificationTaskNotSeenStatus(ModuleTaskDto mtdo, Connection con) throws SQLException;

	/**
	 * @author pravin
	 * @param con
	 * @param tlId
	 * @return
	 * @throws SQLException
	 */
	
	public List<TaskStatusDto> getNotificationTaskSeenStatus( Integer tlId ,Connection con) throws SQLException;

	/**
	 * @author pravin
	 * @param con
	 * @param taskId
	 * @return
	 * @throws SQLException
	 */
	
	public NotificationFormBean getNotificationTaskSeenStatusDetails(Integer taskId, Connection con) throws SQLException;
	
	
	/**
	 * @author pawan
	 * @param con
	 * @param udto
	 * @return
	 * @throws SQLException
	 */
	public List<ModuleStatusDto> getModuleStatusNotification(Connection con,UserDto udto) throws SQLException ;
	
	/**
	 * @author pawan
	 * @param con
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public NotificationModuleStatusDetailsFormBean getModuleStatusNotification(Connection con,Integer moduleId) throws SQLException ;
	
	
	/**
	 * @author Thejaswi S
	 * @param con
	 * @return list
	 * @throws SQLException
	 *
	 */
	public List<ProjectStatusDto> getNotificationAssignProject( Connection con,UserDto uDto) throws SQLException;
	
	/**
	 * @author Thejaswi
	 * @param con,pId
	 * @return list
	 * @throws SQLException
	 */
	
	public List getNotificationAssignProject(Connection con, Integer pId) throws SQLException;

	/**
	 * @author Thejaswi
	 * @param con
	 * @return list
	 * @throws SQLException
	 */
		public List getNotificationProjectStatus(Connection con)throws SQLException;

	/**
	 * @author Thejaswi S
	 * @param con,pId
	 * @return list
	 * @throws SQLException
	 *
	 */
	
	public List<ProjectStatusDto> getNotificationProjectStatus(Connection con,Integer pId) throws SQLException;

	/**
	 * @author Thejaswi S
	 * @param con
	 * @return
	 * @throws SQLException
	 *
	 */
	
	public List<ProjectModuleDto> getNotificationAssignModule(Connection con) throws SQLException;

	/**
	 * @author Thejaswi
	 * @param con,mId
	 * @return list
	 * @throws SQLException
	 */
	
	public List getNotificationAssignModule(Connection con, Integer mId) throws SQLException;

	
	public List<DeveloperTaskDto> notificationDeveloperTask(Integer devid, Connection con) throws SQLException;

	public List<DeveloperTaskDto> notificationAcceptedTask(Integer supid, Connection con1);
	
	public List<AssignTask> getNotificationAssignedTaskCompleteInfo(Integer dtId, Connection con2) throws SQLException;
	 
	public List<ApproveRejectForTL> getNotificationApproveorRejectForTL(Integer sup,Integer dtId,Connection con) throws SQLException;
	
	public List<AcceptTask> getNotificationAcceptTask(Integer sup,Connection con) throws SQLException;

	public boolean updateStatus(Integer id,String accept,Connection con) throws SQLException ;

	//boolean updateStatus(Integer id, Connection con) throws SQLException;

	

	


		
	
	
	

}
