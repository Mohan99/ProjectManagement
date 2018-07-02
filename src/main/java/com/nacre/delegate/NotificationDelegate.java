/**
 * 
 */
package com.nacre.delegate;


import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AssignModule;
import com.nacre.formbean.AssignProject;
import com.nacre.formbean.NotificationFormBean;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;
import com.nacre.formbean.ProjectStatus;
import com.nacre.servicei.NotificationServiceI;
import com.nacre.servicei.serviceimpl.NotificationServiceImpl;
import com.nacre.uitl.ImageUtil;

import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.AcceptTask;
import com.nacre.formbean.ApproveRejectForTL;
import com.nacre.formbean.AssignTask;
import com.nacre.servicei.NotificationServiceI;
import com.nacre.servicei.serviceimpl.NotificationServiceImpl;
import com.nacre.uitl.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class NotificationDelegate {

	public static final Logger logger = Logger.getLogger(NotificationDelegate.class);

	public List<DeveloperTaskDto> notificationDeveloperTask(Integer devId) throws SQLException, NoConnectionException {
		NotificationServiceI nsi = new NotificationServiceImpl();

		return nsi.notificationDeveloperTask(devId);

	}

	public List<DeveloperTaskDto> notificationAcceptedTask(Integer supid) throws NoConnectionException, SQLException {
		NotificationServiceI nsi1 = new NotificationServiceImpl();
		System.out.println("del");
		return nsi1.notinotificationAcceptedTask(supid);

	}

	public List<AssignTask> getNotificationAssignedTaskCompleteInfo(Integer dtId) throws NoConnectionException, SQLException {
		NotificationServiceI nsi1 = new NotificationServiceImpl();
		List<AssignTask> list = nsi1.getNotificationAssignedTaskCompleteInfo(dtId);
		
		return list;

		// return nsi1.notinotificationAcceptedTask1(supid);
		// return list;

	}

	public List<ApproveRejectForTL> getNotificationApproveorRejectForTL(Integer sup,Integer dtId) throws NoConnectionException, SQLException {
		NotificationServiceI nsi2 = new NotificationServiceImpl();
		List<ApproveRejectForTL> list=nsi2.getNotificationApproveorRejectForTL(sup,dtId);
		return list;
	}

	

	public List<AcceptTask> getNotificationAcceptTask(Integer sup) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub
		NotificationServiceI nsi3= new NotificationServiceImpl();
		List<AcceptTask> list= nsi3.getNotificationAcceptTask(sup);
		return list;
	}

	

	public boolean updateStatus(Integer id,String accept) throws NoConnectionException, SQLException {
		// TODO Auto-generated method stub;
		NotificationServiceI nsi3= new NotificationServiceImpl();
		boolean b1	= nsi3.updateStatus(id,accept);
		return b1;
	}


public List<AssignProject> getNotificationAssignProject(UserDto dto1)
		throws SQLException, NoConnectionException {
	// TODO Auto-generated method stub
	logger.debug(dto1);
  NotificationServiceI notificationServiceI = new NotificationServiceImpl();
  List<ProjectStatusDto>	list = notificationServiceI.getNotificationAssignProject(dto1);
	
	List<AssignProject>	listbean = new ArrayList<AssignProject>();
	AssignProject bean = null;
	for(ProjectStatusDto dto :list){
	bean = new AssignProject();
	try {
		Blob b = dto.getProjectManagerProjectId().getProjectManagerId().getImage();
		if(b!=null){
		bean.setProjectManagerImage(ImageUtil.encodeImage(b.getBinaryStream()));
		}
	} catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	bean.setProjectId(dto.getProjectManagerProjectId().getProjectId().getProjectId()+"");
	bean.setProjectTitle(dto.getProjectManagerProjectId().getProjectId().getProjectTitle());
	bean.setProjectDescription(dto.getProjectManagerProjectId().getProjectId().getProjectDescription());
	bean.setProjectCompletionPercentage(dto.getProjectManagerProjectId().getProjectId().getProjectCompletionPercentage()+"");
	bean.setExpectedStartDate(dto.getProjectManagerProjectId().getProjectId().getExpectedStartDate()+"");
	bean.setExpectedEndDate(dto.getProjectManagerProjectId().getProjectId().getExpectedEndDate()+"");
	bean.setStatusInfo(dto.getStatusInfo());
	bean.setProjectManagerName(dto.getProjectManagerProjectId().getProjectManagerId().getFirstName());
	bean.setProjectManagerEmail(dto.getProjectManagerProjectId().getProjectManagerId().getEmail());
	bean.setProjectManagerMobileNo(dto.getProjectManagerProjectId().getProjectManagerId().getMobileNo());
	bean.setProjectManagerGender(dto.getProjectManagerProjectId().getProjectManagerId().getGender());
	
	listbean.add(bean);
	
	}
	return listbean;	
} // get notification for assign project



public List<ProjectStatus> getNotificationProjectStatus(Integer pId)
		throws SQLException, NoConnectionException {
	// TODO Auto-generated method stub
	NotificationServiceI notificationServiceI = new NotificationServiceImpl();
	  List<ProjectStatusDto>	list = notificationServiceI.getNotificationProjectStatus(pId);
		
		List<ProjectStatus>	listbean1 = new ArrayList<ProjectStatus>();
		ProjectStatus bean = null;
		for(ProjectStatusDto dto :list){
		bean = new ProjectStatus();
		try {
			Blob b =dto.getProjectManagerProjectId().getProjectManagerId().getImage();
			if(b!=null){
			bean.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
			}
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bean.setProjectId(dto.getProjectManagerProjectId().getProjectId().getProjectId()+"");
		bean.setProjectTitle(dto.getProjectManagerProjectId().getProjectId().getProjectTitle());
		bean.setProjectDescription(dto.getProjectManagerProjectId().getProjectId().getProjectDescription());
		bean.setProjectCompletionPercentage(dto.getProjectManagerProjectId().getProjectId().getProjectCompletionPercentage()+"");
		bean.setExpectedStartDate(dto.getProjectManagerProjectId().getProjectId().getExpectedStartDate()+"");
		bean.setExpectedEndDate(dto.getProjectManagerProjectId().getProjectId().getExpectedEndDate()+"");
		bean.setStatusInfo(dto.getStatusInfo());
		bean.setUpdationDate(dto.getUpdationDate()+"");
		bean.setProjectManagerName(dto.getProjectManagerProjectId().getProjectManagerId().getFirstName());
		bean.setProjectManagerEmail(dto.getProjectManagerProjectId().getProjectManagerId().getEmail());
		bean.setProjectManagerMobileNo(dto.getProjectManagerProjectId().getProjectManagerId().getMobileNo());
		bean.setGender(dto.getProjectManagerProjectId().getProjectManagerId().getGender());
		
		listbean1.add(bean);
		
		}
		return listbean1;	

} // get notification for project seen status

public List<AssignModule> getNotificationAssignModule() throws SQLException, NoConnectionException
{
	// TODO Auto-generated method stub
	 NotificationServiceI notificationServiceI = new NotificationServiceImpl();
	 
	List<ProjectModuleDto>	list = notificationServiceI.getNotificationAssignModule();
	
	List<AssignModule>	listbean = new ArrayList<AssignModule>();
	AssignModule bean = null;
	for(ProjectModuleDto dto :list){
	bean = new AssignModule();
		
		try {
			bean.setProjectManagerImage(ImageUtil.encodeImage(dto.getProjectManagetProjectId().getProjectManagerId().getImage().getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		
		try {
			bean.setTeamLeaderImage(ImageUtil.encodeImage(dto.getTeamLeadId().getImage().getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		
		bean.setProjectId(dto.getProjectManagetProjectId().getProjectId().getProjectId()+"");
		bean.setProjectTitle(dto.getProjectManagetProjectId().getProjectId().getProjectTitle());
		bean.setProjectDescription(dto.getProjectManagetProjectId().getProjectId().getProjectDescription());
		bean.setExpectedStartDate(dto.getProjectManagetProjectId().getProjectId().getExpectedStartDate()+"");
		bean.setExpectedStartDate(dto.getProjectManagetProjectId().getProjectId().getExpectedEndDate()+"");
		bean.setProjectCompletionPercentage(dto.getProjectManagetProjectId().getProjectId().getProjectCompletionPercentage()+"");
		bean.setProjectManagerName(dto.getProjectManagetProjectId().getProjectManagerId().getFirstName());
		bean.setProjectManagerEmail(dto.getProjectManagetProjectId().getProjectManagerId().getEmail());
		bean.setProjectManagerMobileNo(dto.getProjectManagetProjectId().getProjectManagerId().getMobileNo());
		bean.setProjectManagerGender(dto.getProjectManagetProjectId().getProjectManagerId().getGender());
		bean.setProjectModuleId(dto.getProjectModuleId()+"");
		bean.setModuleTitle(dto.getModuleTitle());
		bean.setModuleDescription(dto.getModuleDescription());
		bean.setModuleStartDate(dto.getStartDate()+"");
		bean.setModuleEndDate(dto.getEndDate()+"");
		bean.setTeamLeaderName(dto.getTeamLeadId().getFirstName());
		bean.setTeamLeaderEmail(dto.getTeamLeadId().getEmail());
		bean.setTeamLeaderMobileNo(dto.getTeamLeadId().getMobileNo());
		bean.setTeamLeaderGender(dto.getTeamLeadId().getGender());
		listbean.add(bean);
		
	}
	 
		return listbean;
} // get notification for assigning module


public List<AssignModule> getNotificationAssignModule(Integer mId) throws SQLException, NoConnectionException
{
	// TODO Auto-generated method stub
	 NotificationServiceI notificationServiceI = new NotificationServiceImpl();
	 
	List<ProjectModuleDto>	list = notificationServiceI.getNotificationAssignModule(mId);
	
	List<AssignModule>	listbean = new ArrayList<AssignModule>();
	AssignModule bean = null;
	for(ProjectModuleDto dto :list){
	bean = new AssignModule();
		
		try {
			bean.setProjectManagerImage(ImageUtil.encodeImage(dto.getProjectManagetProjectId().getProjectManagerId().getImage().getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		
		try {
			bean.setTeamLeaderImage(ImageUtil.encodeImage(dto.getTeamLeadId().getImage().getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		
		bean.setProjectId(dto.getProjectManagetProjectId().getProjectId().getProjectId()+"");
		bean.setProjectTitle(dto.getProjectManagetProjectId().getProjectId().getProjectTitle());
		bean.setProjectDescription(dto.getProjectManagetProjectId().getProjectId().getProjectDescription());
		bean.setExpectedStartDate(dto.getProjectManagetProjectId().getProjectId().getExpectedStartDate()+"");
		bean.setExpectedStartDate(dto.getProjectManagetProjectId().getProjectId().getExpectedEndDate()+"");
		bean.setProjectCompletionPercentage(dto.getProjectManagetProjectId().getProjectId().getProjectCompletionPercentage()+"");
		bean.setProjectManagerName(dto.getProjectManagetProjectId().getProjectManagerId().getFirstName());
		bean.setProjectManagerEmail(dto.getProjectManagetProjectId().getProjectManagerId().getEmail());
		bean.setProjectManagerMobileNo(dto.getProjectManagetProjectId().getProjectManagerId().getMobileNo());
		bean.setProjectManagerGender(dto.getProjectManagetProjectId().getProjectManagerId().getGender());
		bean.setProjectModuleId(dto.getProjectModuleId()+"");
		bean.setModuleTitle(dto.getModuleTitle());
		bean.setModuleDescription(dto.getModuleDescription());
		bean.setModuleStartDate(dto.getStartDate()+"");
		bean.setModuleEndDate(dto.getEndDate()+"");
		bean.setTeamLeaderName(dto.getTeamLeadId().getFirstName());
		bean.setTeamLeaderEmail(dto.getTeamLeadId().getEmail());
		bean.setTeamLeaderMobileNo(dto.getTeamLeadId().getMobileNo());
		bean.setTeamLeaderGender(dto.getTeamLeadId().getGender());
		listbean.add(bean);
		
	}
	 
		return listbean;
} // get notification for assigning module



/**
 * @author pravin
 * @method getNotificationTaskNotSeenStatus
 * @param mtdo
 * @return 
 */

public List<ModuleTaskDto> getNotificationTaskNotSeenStatus(ModuleTaskDto mtdo) throws SQLException, NoConnectionException {
	
	NotificationServiceI nsi=new NotificationServiceImpl();
	return nsi.getNotificationTaskNotSeenStatus(mtdo);
}


/**
 * @author pravin
 * @method getNotificationTaskSeenStatus
 * @param tlId
 * @return 
 */

public List<TaskStatusDto> getNotificationTaskSeenStatus(Integer tlId ) throws SQLException, NoConnectionException {
	
	NotificationServiceI nsi1=new NotificationServiceImpl();
	return nsi1.getNotificationTaskSeenStatus( tlId );
	
}

/**
 * @author pravin
 * @method getNotificationTaskSeenStatusDetails
 * @param taskId
 * @return 
 */

public NotificationFormBean getNotificationTaskSeenStatusDetails(Integer taskId) throws SQLException, NoConnectionException {
		NotificationServiceI nsi1=new NotificationServiceImpl();
	return nsi1.getNotificationTaskSeenStatusDetails(taskId);
	
}
	/**
	 * @author pawan
	 * @param udto
	 * @return
	 * @throws SQLException
	 * @throws NoConnectionException
	 */
public List<ModuleStatusDto> getModuleStatusNotification(UserDto udto) throws SQLException, NoConnectionException {
	List<ModuleStatusDto> list = null;
	NotificationServiceI nsi1=new NotificationServiceImpl();
	list= (List<ModuleStatusDto>) nsi1.getModuleStatusNotification(udto);
	logger.info(list);
	return list;
}
	/**
	 * @author pawan
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 * @throws NoConnectionException
	 */
public NotificationModuleStatusDetailsFormBean getModuleStatusNotification(Integer moduleId)
		throws SQLException, NoConnectionException{
	NotificationModuleStatusDetailsFormBean bean = null;
	NotificationServiceI nsi1=new NotificationServiceImpl();
	bean= nsi1.getModuleStatusNotification(moduleId);
	return bean;
	
}



	public List<ProjectStatus> getNotificationProjectStatus() throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationServiceI notificationServiceI = new NotificationServiceImpl();
		  List<ProjectStatusDto>	list = notificationServiceI.getNotificationProjectStatus();
			
			List<ProjectStatus>	listbean1 = new ArrayList<ProjectStatus>();
			ProjectStatus bean = null;
			for(ProjectStatusDto dto :list){
			bean = new ProjectStatus();
			try {
				
				Blob b =dto.getProjectManagerProjectId().getProjectManagerId().getImage();
				if(b!=null){
				bean.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
				}
			} catch (ImageStreamToByteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bean.setProjectId(dto.getProjectManagerProjectId().getProjectId().getProjectId()+"");
			bean.setProjectTitle(dto.getProjectManagerProjectId().getProjectId().getProjectTitle());
			bean.setProjectDescription(dto.getProjectManagerProjectId().getProjectId().getProjectDescription());
			bean.setProjectCompletionPercentage(dto.getProjectManagerProjectId().getProjectId().getProjectCompletionPercentage()+"");
			bean.setExpectedStartDate(dto.getProjectManagerProjectId().getProjectId().getExpectedStartDate()+"");
			bean.setExpectedEndDate(dto.getProjectManagerProjectId().getProjectId().getExpectedEndDate()+"");
			bean.setStatusInfo(dto.getStatusInfo());
			bean.setUpdationDate(dto.getUpdationDate()+"");
			bean.setProjectManagerName(dto.getProjectManagerProjectId().getProjectManagerId().getFirstName());
			bean.setProjectManagerEmail(dto.getProjectManagerProjectId().getProjectManagerId().getEmail());
			bean.setProjectManagerMobileNo(dto.getProjectManagerProjectId().getProjectManagerId().getMobileNo());
			bean.setGender(dto.getProjectManagerProjectId().getProjectManagerId().getGender());
			
			listbean1.add(bean);
			
			}
			return listbean1;	
	}



	public List<AssignProject> getNotificationAssignProject(Integer pId) throws SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		NotificationServiceI notificationServiceI = new NotificationServiceImpl();
		  List<ProjectStatusDto>	list = notificationServiceI.getNotificationAssignProject(pId);
			
			List<AssignProject>	listbean = new ArrayList<AssignProject>();
			AssignProject bean = null;
			for(ProjectStatusDto dto :list){
			bean = new AssignProject();
			try {
				Blob b =dto.getProjectManagerProjectId().getProjectManagerId().getImage();
				if(b!=null){
				bean.setProjectManagerImage( ImageUtil.encodeImage(b.getBinaryStream()));
				}
			} catch (ImageStreamToByteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bean.setProjectId(dto.getProjectManagerProjectId().getProjectId().getProjectId()+"");
			bean.setProjectTitle(dto.getProjectManagerProjectId().getProjectId().getProjectTitle());
			bean.setProjectDescription(dto.getProjectManagerProjectId().getProjectId().getProjectDescription());
			bean.setProjectCompletionPercentage(dto.getProjectManagerProjectId().getProjectId().getProjectCompletionPercentage()+"");
			bean.setExpectedStartDate(dto.getProjectManagerProjectId().getProjectId().getExpectedStartDate()+"");
			bean.setExpectedEndDate(dto.getProjectManagerProjectId().getProjectId().getExpectedEndDate()+"");
			bean.setStatusInfo(dto.getStatusInfo());
			bean.setProjectManagerName(dto.getProjectManagerProjectId().getProjectManagerId().getFirstName());
			bean.setProjectManagerEmail(dto.getProjectManagerProjectId().getProjectManagerId().getEmail());
			bean.setProjectManagerMobileNo(dto.getProjectManagerProjectId().getProjectManagerId().getMobileNo());
			bean.setProjectManagerGender(dto.getProjectManagerProjectId().getProjectManagerId().getGender());
			
			listbean.add(bean);
			
			}
			return listbean;	

	}
}

