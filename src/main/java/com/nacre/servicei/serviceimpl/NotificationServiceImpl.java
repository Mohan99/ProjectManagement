/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.daoi.NotificationDaoI;
import com.nacre.daoi.daoimpl.NotificationDaoImpl;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.NotificationFormBean;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;
import com.nacre.daoi.NotificationDaoI;
import com.nacre.daoi.daoimpl.NotificationDaoImpl;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AcceptTask;
import com.nacre.formbean.ApproveRejectForTL;
import com.nacre.formbean.AssignTask;
import com.nacre.servicei.NotificationServiceI;
import com.nacre.uitl.PooledConnection;


public class NotificationServiceImpl implements NotificationServiceI {
	public static final Logger logger = 	Logger.getLogger(NotificationServiceImpl.class);

	/**
	 * @author pravin
	 * @param mtdo
	 * getNotificationTaskNotSeenStatus
	 * @throws SQLException 
	 */
	
	@Override
	public List<ModuleTaskDto> getNotificationTaskNotSeenStatus(ModuleTaskDto mtdo) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI ndaoI=new NotificationDaoImpl();
		Connection con1 = PooledConnection.getConnection();
List l = ndaoI.getNotificationTaskNotSeenStatus(mtdo,con1);
con1.close();
		return l;
		
	}
	
	/**
	 * @author pravin
	 * @param tlId
	 * getNotificationTaskSeenStatus
	 * @throws SQLException ,NoConnectionException
	 */

	@Override
	public List<TaskStatusDto> getNotificationTaskSeenStatus(Integer tlId ) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI ndaoI=new NotificationDaoImpl();
		Connection con1 = PooledConnection.getConnection();
List l =ndaoI.getNotificationTaskSeenStatus(tlId, con1);
con1.close();
		return l;

	}	
	
	/**
	 * @author pravin
	 * @param taskId
	 * getNotificationTaskSeenStatus
	 * @throws SQLException ,NoConnectionException
	 */
	
	@Override
	public NotificationFormBean getNotificationTaskSeenStatusDetails(Integer taskId) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI ndaoI=new NotificationDaoImpl();
		Connection con1 = PooledConnection.getConnection();
		NotificationFormBean bean = ndaoI.getNotificationTaskSeenStatusDetails(taskId,con1);
con1.close();	
return bean;

	}	
		/**
		 * @author pawan
		 */
	@Override
	public List<ModuleStatusDto> getModuleStatusNotification(UserDto udto) throws SQLException, NoConnectionException {
		NotificationDaoI ndaoI=new NotificationDaoImpl();
		logger.info("before");
		Connection con = PooledConnection.getConnection();
		 List<ModuleStatusDto> list = ndaoI.getModuleStatusNotification(con,udto);
		 logger.info(list);
con.close();	
	return list;	
	}
	/**
	 * @author pawan
	 */
	//@Override
	public NotificationModuleStatusDetailsFormBean getModuleStatusNotification(Integer moduleId) throws SQLException,NoConnectionException {
		NotificationDaoI ndaoI=new NotificationDaoImpl();
		Connection con = PooledConnection.getConnection();
		NotificationModuleStatusDetailsFormBean bean = ndaoI.getModuleStatusNotification(con, moduleId);
		 con.close();	
			return bean;
	}
	
	/**
	 * @author Thejaswi S
	 * getNotificationAssignProject
	 * return list
	 *@throws SQLException,NoConnectionException
	 */
	@Override	
  public List<ProjectStatusDto> getNotificationAssignProject(UserDto dto)
			throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
      NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
      Connection con=PooledConnection.getConnection();
		
	List l= notificationDaoI.getNotificationAssignProject(con,dto);
	con.close();
	return l;
	}
	
	/**
	 * @author Thejaswi S
	 * getNotificationAssignModule
	 * @param pId
	 * return list
	 *@throws SQLException,NoConnectionException
	 */

	@Override
	public List<ProjectStatusDto> getNotificationAssignProject(Integer pId) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
	      Connection con=PooledConnection.getConnection();
			
		List l= notificationDaoI.getNotificationAssignProject(con,pId);
		con.close();
		return l;
	}


	
	/**
	 * @author Thejaswi S
	 * getNotificationProjectStatus
	 * @param pId
	 * return list
	 *@throws SQLException,NoConnectionException
	 */
	

	public List<ProjectStatusDto> getNotificationProjectStatus(Integer pId)
			throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
	      Connection con=PooledConnection.getConnection();
			
			List l = notificationDaoI.getNotificationProjectStatus(con,pId);
	con.close();
			return l;
	}
	
	/**
	 * @author Thejaswi S
	 * getNotificationProjectStatus
	 * return list
	 *@throws SQLException,NoConnectionException
	 */
	
	public List<ProjectStatusDto> getNotificationProjectStatus() throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
	      Connection con=PooledConnection.getConnection();
			
			List l = notificationDaoI.getNotificationProjectStatus(con);
	con.close();
			return l;
	}

	/**
	 * @author Thejaswi S
	 * getNotificationAssignModule
	 * return list
	 *@throws SQLException,NoConnectionException
	 */
	
	
	@Override
	public List<ProjectModuleDto> getNotificationAssignModule() throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
	      Connection con=PooledConnection.getConnection();
			
			List l = notificationDaoI.getNotificationAssignModule(con);
			con.close();
			return l;
	}
	
	/**
	 * @author Thejaswi S
	 * getNotificationAssignModule
	 * @param mId
	 * return list
	 *@throws SQLException,NoConnectionException
	 */
	

	@Override
	public List<ProjectModuleDto> getNotificationAssignModule(Integer mId) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI notificationDaoI = new NotificationDaoImpl();
		
	      Connection con=PooledConnection.getConnection();
			
			List l = notificationDaoI.getNotificationAssignModule(con,mId);
			con.close();
			return l;
	}
	
	
	@Override
	public List<DeveloperTaskDto> notificationDeveloperTask(Integer devId) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationDaoI nsi = new NotificationDaoImpl();
		Connection con = PooledConnection.getConnection();
		List<DeveloperTaskDto> dtd=nsi.notificationDeveloperTask(devId,con);
		
		return dtd ;
	
		
	}

	

	@Override
	public List<DeveloperTaskDto> notinotificationAcceptedTask(Integer supid) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("service");
		NotificationDaoI nsi1= new NotificationDaoImpl();
		Connection con1= PooledConnection.getConnection();
		List<DeveloperTaskDto> dtd1=nsi1.notificationAcceptedTask(supid, con1);
		con1.close();
		return dtd1;
	}



	@Override
	public List<AssignTask> getNotificationAssignedTaskCompleteInfo(Integer dtId) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stu
		NotificationDaoI nsi2=new NotificationDaoImpl();
		Connection con2=PooledConnection.getConnection();
		List<AssignTask> dtd2=nsi2.getNotificationAssignedTaskCompleteInfo(dtId, con2);
		con2.close();
		return dtd2;
	}



	@Override
	public List<ApproveRejectForTL> getNotificationApproveorRejectForTL(Integer sup,Integer dtId) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		NotificationDaoI nsi3=new NotificationDaoImpl();
		Connection con2=PooledConnection.getConnection();
		List<ApproveRejectForTL> arj=nsi3.getNotificationApproveorRejectForTL(sup,dtId, con2);
		con2.close();
		return arj;
		
	}



	@Override
	public List<AcceptTask> getNotificationAcceptTask(Integer sup) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		NotificationDaoI nsi4 = new NotificationDaoImpl();
		Connection con =PooledConnection.getConnection();
		List<AcceptTask> list=nsi4.getNotificationAcceptTask(sup, con);
		con.close();
		return list;
	}



	@Override
	public boolean updateStatus(Integer id,String accept) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		NotificationDaoI nsi5= new NotificationDaoImpl();
		Connection con = PooledConnection.getConnection();
	    boolean b =nsi5.updateStatus(id,accept,con);
	    if(b){
	    	con.commit();
	    }else{
	    	con.rollback();
	    }
	    con.close();
		return b;
	}




	
	

}
