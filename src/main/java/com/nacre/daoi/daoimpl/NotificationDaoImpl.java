/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.NotificationDaoI;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleStatusDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectStatusDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.TaskStatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.formbean.AcceptTask;
import com.nacre.formbean.ApproveRejectForTL;
import com.nacre.formbean.AssignTask;
import com.nacre.formbean.NotificationFormBean;
import com.nacre.formbean.NotificationModuleStatusDetailsFormBean;
import com.nacre.uitl.DateUtil;
import com.nacre.uitl.ImageUtil;

/**
 * @author Thejaswi
 * NotificationDaoImpl
 *
 */
/**
 * 
 * @author anuj
 * 
 */
/**
 * @author anuj
 * @see
 */
public class NotificationDaoImpl implements NotificationDaoI {

	Connection con = null;
	java.sql.PreparedStatement ps = null;
	ResultSet rs = null;
	List<ModuleTaskDto> list = null;
	List<TaskStatusDto> list1 = null;

	public static final Logger logger = Logger.getLogger(NotificationDaoImpl.class);
	
	/**
	 * @author pravin
	 * getNotificationTaskNotSeenStatus
	 * @throws SQLException 
	 */
	public List<ModuleTaskDto> getNotificationTaskNotSeenStatus(ModuleTaskDto mtdo, Connection con)
			throws SQLException {
		logger.info("dao");
		ps = con.prepareStatement(SQLQueryConstants.TASK_STATUS_NOTSEEN);
		ps.setInt(1, IntegerConstants.NOT_SEEN_TASK);
		rs = ps.executeQuery();
		list = new ArrayList<ModuleTaskDto>();
		while (rs.next()) {
			mtdo = new ModuleTaskDto();

			mtdo.setModuleTaskId(rs.getInt(1));
			System.out.println("ModuleTaskId :" + rs.getInt(1));
			mtdo.setTaskTitle(rs.getString(2));
			System.out.println("TaskTitle :" + rs.getString(2));
			mtdo.setTaskDescription(rs.getString(3));
			System.out.println("TaskDescription :" + rs.getString(3));
			mtdo.setTaskCompletionPercent(rs.getFloat(4));
			System.out.println("TaskCompletionPercent :" + rs.getFloat(4));

			ProjectModuleDto pmdto = new ProjectModuleDto();
			mtdo.setProjectModuleId(pmdto);
			pmdto.setModuleTitle(rs.getString(5));
			System.out.println("ModuleTitle :" + rs.getString(5));

			list.add(mtdo);
		}
		return list;
	}


	/**
	 * @author pravin
	 * @param tlId
	 * @param con
	 * getNotificationTaskSeenStatus
	 * @throws SQLException 
	 */
	public List<TaskStatusDto> getNotificationTaskSeenStatus( Integer tlId ,Connection con) throws SQLException {
		ps = con.prepareStatement(SQLQueryConstants.TASK_STATUS_SEEN);
		ps.setInt(1, IntegerConstants.SEEN_TASK);
		ps.setInt(2, tlId);
		System.out.println(ps.toString());
		rs = ps.executeQuery();
		list1 = new ArrayList<TaskStatusDto>();
		logger.info("dao");
		while (rs.next()) {
			TaskStatusDto 	tsdto = new TaskStatusDto();

			ModuleTaskDto mtdto = new ModuleTaskDto();
			mtdto.setModuleTaskId(rs.getInt(1));
			System.out.println("ModuleTaskId :" + rs.getInt(1));
			mtdto.setTaskTitle(rs.getString(2));
			System.out.println("TaskTitle :" + rs.getString(2));
			mtdto.setTaskDescription(rs.getString(3));
			System.out.println("TaskDescription :" + rs.getString(3));

			DeveloperTaskDto dtdto = new DeveloperTaskDto();
			dtdto.setModuleTaskId(mtdto);
			dtdto.setDeveloperTaskId(rs.getInt(4));
			System.out.println("DeveloperTaskId :" + rs.getInt(4));

			tsdto.setDeveloperTaskId(dtdto);
			tsdto.setTaskStatusId(rs.getInt(5));
			System.out.println("TaskStatusId :" + rs.getInt(5));

			tsdto.setStatusInfo(rs.getString(6));
			System.out.println("StatusInfo :" + rs.getString(6));
			tsdto.setUpdationDate(rs.getDate(7));
			System.out.println("UpdationDate :" + rs.getDate(7));

			/*
			 * mtdto.setTaskCompletionPercent(rs.getFloat(8));
			 * System.out.println("TaskCompletionPercent :"+rs.getFloat(8));
			 */

			list1.add(tsdto);
			System.out.println(list);
		}
		return list1;
	}
	

	/**
	 * @author pravin
	 * getNotificationTaskSeenStatusDetails
	 * @param taskId
	 * @param con
	 * @return
	 * @throws SQLException 
	 */

	@Override
	public NotificationFormBean getNotificationTaskSeenStatusDetails(Integer taskId, Connection con) throws SQLException {
		ps = con.prepareStatement(SQLQueryConstants.TASK_STATUS_SEEN_DETAILS);
		ps.setInt(1, IntegerConstants.SEEN_TASK);
		ps.setInt(2, taskId);
		TaskStatusDto tsdto = null;
		System.out.println(ps.toString());
		rs = ps.executeQuery();

		tsdto = new TaskStatusDto();
		logger.info("dao");

		
		NotificationFormBean bean = new NotificationFormBean();
		
		while(rs.next()){
			bean.setProjectId(rs.getInt(1));
			bean.setProjectTitle(rs.getString(2));
			bean.setProjectDescription(rs.getString(3));
			bean.setProjectCompletionPercentage(rs.getFloat(4));
			bean.setProjMngFirstName(rs.getString(5));
			bean.setProjMngLastName(rs.getString(6));
			bean.setProjMngEmail(rs.getString(7));
			bean.setProjMngMobileNo(rs.getString(8));
		try {
			bean.setProjMngImage(ImageUtil.encodeImage(rs.getBlob(9).getBinaryStream()));
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
			
			bean.setModuleTaskId(rs.getInt(10));
			bean.setTaskTitle(rs.getString(11));
			bean.setDevFirstName(rs.getString(12));
			bean.setDevLastName(rs.getString(13));
			bean.setDevEmail(rs.getString(14));
			bean.setDevMobileNo(rs.getString(15));
		try {
			bean.setDevImage(ImageUtil.encodeImage(rs.getBlob(16).getBinaryStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
			bean.setTaskDescription(rs.getString(17));
			bean.setTaskCompletionPercentage(rs.getFloat(18));
			bean.setDeveloperTaskId(rs.getInt(19));
			bean.setTaskStatusId(rs.getInt(20));
			bean.setStatusInfo(rs.getString(21));
			bean.setUpdationDate(rs.getDate(22)+"");
			
			bean.setProjectModuleId(rs.getInt(23));
			bean.setModuleTitle(rs.getString(24));
			bean.setModuleDescription(rs.getString(25));
			bean.setModuleCompletionPercentage(rs.getFloat(26));
			bean.setTlFirstName(rs.getString(27));
			bean.setTlLastName(rs.getString(28));
			bean.setTlEmail(rs.getString(29));
			bean.setTlMobileNo(rs.getString(30));
			try {
				bean.setTlImage(ImageUtil.encodeImage(rs.getBlob(31).getBinaryStream()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

		return bean;
	}

		/**
		 * @author pawan
		 */
	@Override
	public List<ModuleStatusDto> getModuleStatusNotification(Connection con,UserDto udto) throws SQLException {
		logger.info("before dao");
		ModuleStatusDto dto = null;
		ProjectModuleDto pmdto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ModuleStatusDto> list = null;

		logger.info("before rs"+udto.getUserId());
		ps = con.prepareStatement(SQLQueryConstants.NOTIFICATION_REGARDING_MODULE_STATUS);
		ps.setInt(1, udto.getUserId());
		ps.setInt(2, IntegerConstants.NOT_SEEN_STATUS);
		list =new ArrayList<>();
		rs = ps.executeQuery();
		logger.info("before rs");
		
		while(rs.next()){
			logger.info("r s");
			
		dto = new ModuleStatusDto();
		pmdto = new ProjectModuleDto();	
		
		logger.debug(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
		pmdto.setProjectModuleId(rs.getInt(1));
		pmdto.setModuleTitle(rs.getString(2));
		dto.setDificulties(rs.getString(3));
		dto.setUpdationDate(rs.getDate(4));
		dto.setProjectModuleId(pmdto);
		list.add(dto);
		}
	logger.info(list);
	
		return list;
	}


	/**
	 * @author pawan
	 */
	@Override
	public NotificationModuleStatusDetailsFormBean getModuleStatusNotification(Connection con, Integer moduleId)
			throws SQLException {
		
		NotificationModuleStatusDetailsFormBean bean = null;
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.MODULE_DETAILS_NOTIFICAION_STATUS);
		ResultSet rs = null;
		ps.setInt(1, moduleId);
		ps.setInt(2, IntegerConstants.NOT_SEEN_STATUS);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			bean = new NotificationModuleStatusDetailsFormBean();
			bean.setProjectTitle(rs.getString(1));
			bean.setProjectDescription(rs.getString(2));
			bean.setpMfirstName(rs.getString(3));
			bean.setpMlastName(rs.getString(4));
			bean.setpMemail(rs.getString(5));
			bean.setpMMobileNo(rs.getString(6));	
			try {
				bean.setpMimage(ImageUtil.encodeImage(rs.getBlob(7).getBinaryStream()));
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
			bean.setModuleTitle(rs.getString(8));
			bean.setModuleDescription(rs.getString(9));
			bean.setStartDate(rs.getDate(10)+"");
			bean.setEndDate(rs.getDate(11)+"");
			bean.setModuleCompletionPercent(rs.getFloat(12));
			bean.settLfirstName(rs.getString(13));
			bean.settLlastName(rs.getString(14));
			bean.settLemail(rs.getString(15));
			bean.settLmobileNo(rs.getString(16));	
			try {
				bean.settLimage(ImageUtil.encodeImage(rs.getBlob(17).getBinaryStream()));
			} catch (Exception e) {
				//e.printStackTrace();
			}

		}
		
		return bean;
	}

	
	

  //PreparedStatement ps=null;
  //ResultSet rs=null;
  List<ProjectStatusDto> listps=null;
  List<ProjectDto>  listpd=null;
  List<ProjectStatusDto> list2=null;
  List<ModuleTaskDto> list3=null;
  List<ProjectModuleDto> list4=null;
  
  //public static final Logger logger = Logger.getLogger(NotificationDaoImpl.class);

  /**
   * @author Thejaswi S
   * @param con
   * getNotificationDaoImpl
   * return list
   * @throws SQLException
   */
public List<ProjectStatusDto> getNotificationAssignProject( Connection con,UserDto dto) throws SQLException {
	// TODO Auto-generated method stub
	ps = con.prepareStatement(SQLQueryConstants.ASSIGN_ALL_PROJECT_NOTIFICATION);
	ps.setInt(1,IntegerConstants.ASSIGN_STATUS_ID);
	ps.setInt(2,dto.getUserId());
	
	rs = ps.executeQuery();
	listps=new ArrayList();
	while(rs.next())
	{
		
		ProjectDto pdto=new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		System.out.println("projectId :"+rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		System.out.println("Project Title : "+rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setProjectCompletionPercentage(rs.getDouble(4));
		System.out.println("ProjectCompletionPercentage : "+rs.getString(4));
		pdto.setExpectedStartDate(rs.getDate(5));
		pdto.setExpectedEndDate(rs.getDate(6));
		System.out.println("endDate"+rs.getDate(6));
		ProjectManagerProjectDto pmpdto1=new ProjectManagerProjectDto();
		pmpdto1.setProjectId(pdto);
		ProjectStatusDto psdto=new ProjectStatusDto();
		psdto.setProjectManagerProjectId(pmpdto1);
		psdto.setStatusInfo(rs.getString(7));
		System.out.println(rs.getString(7));
		UserDto udto = new UserDto();
		udto.setFirstName(rs.getString(8));
		udto.setEmail(rs.getString(9));
		udto.setMobileNo(rs.getString(10));
		udto.setImage(rs.getBlob(11));
		udto.setGender(rs.getString(12));
		pmpdto1.setProjectManagerId(udto);
		psdto.setProjectManagerProjectId(pmpdto1);
		listps.add(psdto);
		
	}
	
	
	return listps;
}
/*
//@Override
public List<DeveloperTaskDto> notificationDeveloperTask(Integer devid, Connection con) {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	List<DeveloperTaskDto> taskstatus= new ArrayList<DeveloperTaskDto>();
	try{
		ps=con.prepareStatement(SQLQueryConstants.NOTIFICATION_REGARDING_TO_APPROVE_A_TASK);
ps.setInt(1, IntegerConstants.STATUS_ASSIGNED);
		ps.setInt(2, devid);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			
			logger.info("retriving notifications");
			
			ProjectDto projectDto = new ProjectDto();
			projectDto.setProjectId(rs.getInt(1));
			projectDto.setProjectTitle(rs.getString(2));
			projectDto.setProjectDescription(rs.getString(3));
			ProjectManagerProjectDto projectManagetProjectId = new ProjectManagerProjectDto();
			projectManagetProjectId.setProjectId(projectDto);
        ProjectModuleDto projectModuleDto = new ProjectModuleDto();
         projectModuleDto.setProjectModuleId(rs.getInt(4));
			
        projectModuleDto.setModuleTitle(rs.getString(5));

            projectModuleDto.setModuleDescription(rs.getString(6));
          projectModuleDto.setProjectManagetProjectId(projectManagetProjectId);

			ModuleTaskDto moduleTaskDto= new ModuleTaskDto();
			
			moduleTaskDto.setTaskTitle(rs.getString(7));
			moduleTaskDto.setTaskDescription(rs.getString(8));
			StatusDto statusDto = new StatusDto();
			statusDto.setStatusId(rs.getInt(9));
			statusDto.setStatus(rs.getString(10));
			moduleTaskDto.setProjectModuleId(projectModuleDto);
			
			DeveloperTaskDto tDto=new DeveloperTaskDto();
			tDto.setDeveloperTaskId(rs.getInt(11));
			tDto.setModuleTaskId(moduleTaskDto);
		tDto.setApprovalStatusId(statusDto);
        tDto.setModuleTaskId(moduleTaskDto);		
			taskstatus.add(tDto);
			
			
		}
	}
	catch(SQLException e)
	{
		logger.error(e.getMessage());
	}
	return taskstatus;
	}  */


@Override
public List<DeveloperTaskDto> notificationDeveloperTask(Integer devid, Connection con) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	List<DeveloperTaskDto> taskstatus= new ArrayList<DeveloperTaskDto>();
	try{
		ps=con.prepareStatement(SQLQueryConstants.NOTIFICATION_REGARDING_TO_APPROVE_A_TASK);
ps.setInt(1, IntegerConstants.STATUS_ASSIGNED);
		ps.setInt(2, devid);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			
			logger.info("retriving notifications");
			
			ProjectDto projectDto = new ProjectDto();
			projectDto.setProjectId(rs.getInt(1));
			System.out.println(rs.getInt(1));
			projectDto.setProjectTitle(rs.getString(2));
			System.out.println(rs.getString(2));
			projectDto.setProjectDescription(rs.getString(3));
			System.out.println(rs.getString(3));
			ProjectManagerProjectDto projectManagetProjectId = new ProjectManagerProjectDto();
			projectManagetProjectId.setProjectId(projectDto);
        ProjectModuleDto projectModuleDto = new ProjectModuleDto();
         projectModuleDto.setProjectModuleId(rs.getInt(4));
         System.out.println(rs.getInt(4));
			
        projectModuleDto.setModuleTitle(rs.getString(5));
        System.out.println(rs.getString(5));

            projectModuleDto.setModuleDescription(rs.getString(6));
            System.out.println(rs.getString(6));
          projectModuleDto.setProjectManagetProjectId(projectManagetProjectId);

			ModuleTaskDto moduleTaskDto= new ModuleTaskDto();
			
			moduleTaskDto.setTaskTitle(rs.getString(7));
			System.out.println(rs.getString(7));
			moduleTaskDto.setTaskDescription(rs.getString(8));
			System.out.println(rs.getString(8));
			StatusDto statusDto = new StatusDto();
			statusDto.setStatusId(rs.getInt(9));
			System.out.println(rs.getInt(9));
			statusDto.setStatus(rs.getString(10));
			System.out.println(rs.getString(10));
			moduleTaskDto.setProjectModuleId(projectModuleDto);
			
			DeveloperTaskDto tDto=new DeveloperTaskDto();
			tDto.setDeveloperTaskId(rs.getInt(11));
			System.out.println(rs.getInt(11));
			tDto.setModuleTaskId(moduleTaskDto);
		tDto.setApprovalStatusId(statusDto);
        tDto.setModuleTaskId(moduleTaskDto);		
			taskstatus.add(tDto);
			
			
		}
	}
	catch(SQLException e)
	{
		logger.error(e.getMessage());
	}
	return taskstatus;
	
}



/**
 * @author Thejaswi S
 * @param con
 * getNotificationProjectStatus
 * return list2
 * @throws SQLException
 */
public List<ProjectStatusDto> getNotificationProjectStatus(Connection con,Integer pId) throws SQLException {
	// TODO Auto-generated method stub
	ps = con.prepareStatement(SQLQueryConstants.PROJECT_STATUS_NOTIFICATION);
	ps.setInt(1,IntegerConstants.SEEN_STATUS);
	ps.setInt(2, pId);
	rs = ps.executeQuery();
	list2=new ArrayList();
	while(rs.next())
	{
		
		ProjectDto pdto=new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		System.out.println("projectId :"+rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		System.out.println("Project Title : "+rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setProjectCompletionPercentage(rs.getDouble(4));
		System.out.println("ProjectCompletionPercentage : "+rs.getString(4));
		pdto.setExpectedStartDate(rs.getDate(5));
		System.out.println("startDate:"+rs.getDate(5));
		pdto.setExpectedEndDate(rs.getDate(6));
		ProjectManagerProjectDto pmpdto1=new ProjectManagerProjectDto();
		pmpdto1.setProjectId(pdto);
		ProjectStatusDto psdto1=new ProjectStatusDto();
		psdto1.setProjectManagerProjectId(pmpdto1);
		psdto1.setStatusInfo(rs.getString(7));
		System.out.println("StatusInfo :"+rs.getString(7));
		psdto1.setUpdationDate(rs.getDate(8));
		System.out.println("Updatation Date :"+rs.getDate(8));
		UserDto udto = new UserDto();
		udto.setFirstName(rs.getString(9));
		udto.setEmail(rs.getString(10));
		udto.setMobileNo(rs.getString(11));
		udto.setImage(rs.getBlob(12));
		udto.setGender(rs.getString(13));
		pmpdto1.setProjectManagerId(udto);
		psdto1.setProjectManagerProjectId(pmpdto1);
		list2.add(psdto1);	
	}
	
	
	return list2;
}

/**
 * @author Thejaswi S
 * @param con
 * getNotificationAssignModule
 * return list4
 * @throws SQLException
 */

public List<ProjectModuleDto> getNotificationAssignModule(Connection con) throws SQLException{
	ps=con.prepareStatement(SQLQueryConstants.ASSIGNED_ALL_MODULE_NOTIFICATION);
	ps.setInt(1, IntegerConstants.TEAM_LEADER_ID);
	ps.setInt(2, IntegerConstants.PROJECT_MANAGER_ID);
	ps.setInt(3, IntegerConstants.ASSIGN_STATUS_ID);
	rs=ps.executeQuery();
	list4=new ArrayList();
	while(rs.next()){
		ProjectDto pdto = new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setExpectedStartDate(rs.getDate(4));
		pdto.setExpectedEndDate(rs.getDate(5));
		pdto.setProjectCompletionPercentage(rs.getDouble(6));
		ProjectManagerProjectDto pmpdto=new ProjectManagerProjectDto();
		pmpdto.setProjectId(pdto);
	    UserDto udto = new UserDto();
	    udto.setFirstName(rs.getString(7));
	    udto.setEmail(rs.getString(8));
	    udto.setMobileNo(rs.getString(9));
	    udto.setImage(rs.getBlob(10));
	    udto.setGender(rs.getString(11));
	    pmpdto.setProjectManagerId(udto);
	    ProjectModuleDto pmdto=new ProjectModuleDto();
	    pmdto.setProjectManagetProjectId(pmpdto);
	    pmdto.setProjectModuleId(rs.getInt(12));
	    pmdto.setModuleTitle(rs.getString(13));
	    pmdto.setModuleDescription(rs.getString(14));
	    pmdto.setStartDate(rs.getDate(15));
	    pmdto.setEndDate(rs.getDate(16));
	    UserDto udto1=new UserDto();
	    udto1.setFirstName(rs.getString(17));
	    udto1.setEmail(rs.getString(18));
	    udto1.setMobileNo(rs.getString(19));
	   Blob b = rs.getBlob(20);
	   // byte bar[]=b.getBytes(1, (int)b.length());
	    //FileOutputStream fout=new FileOutputStream();
	   udto1.setImage(rs.getBlob(20));
	    udto1.setGender(rs.getString(21));
	    pmdto.setTeamLeadId(udto1);
	    
	    list4.add(pmdto);
		
	}
	return list4;
	
}


@Override
public List getNotificationProjectStatus(Connection con) throws SQLException {
	ps = con.prepareStatement(SQLQueryConstants.PROJECT_ALL_STATUS_NOTIFICATION);
	ps.setInt(1,IntegerConstants.SEEN_STATUS);
	
	rs = ps.executeQuery();
	list2=new ArrayList();
	while(rs.next())
	{
		
		ProjectDto pdto=new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		System.out.println("projectId :"+rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		System.out.println("Project Title : "+rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setProjectCompletionPercentage(rs.getDouble(4));
		System.out.println("ProjectCompletionPercentage : "+rs.getString(4));
		pdto.setExpectedStartDate(rs.getDate(5));
		System.out.println("startDate:"+rs.getDate(5));
		pdto.setExpectedEndDate(rs.getDate(6));
		ProjectManagerProjectDto pmpdto1=new ProjectManagerProjectDto();
		pmpdto1.setProjectId(pdto);
		ProjectStatusDto psdto1=new ProjectStatusDto();
		psdto1.setProjectManagerProjectId(pmpdto1);
		psdto1.setStatusInfo(rs.getString(7));
		System.out.println("StatusInfo :"+rs.getString(7));
		psdto1.setUpdationDate(rs.getDate(8));
		System.out.println("Updatation Date :"+rs.getDate(8));
		UserDto udto = new UserDto();
		udto.setFirstName(rs.getString(9));
		udto.setEmail(rs.getString(10));
		udto.setMobileNo(rs.getString(11));
		udto.setImage(rs.getBlob(12));
		udto.setGender(rs.getString(13));
		pmpdto1.setProjectManagerId(udto);
		psdto1.setProjectManagerProjectId(pmpdto1);
		list2.add(psdto1);	
	}
	
	
	return list2;
}


@Override
public List getNotificationAssignModule(Connection con, Integer mId) throws SQLException {
	// TODO Auto-generated method stub
	ps=con.prepareStatement(SQLQueryConstants.ASSIGNED_MODULE_NOTIFICATION);
	ps.setInt(1, IntegerConstants.TEAM_LEADER_ID);
	ps.setInt(2, IntegerConstants.PROJECT_MANAGER_ID);
	ps.setInt(3, IntegerConstants.ASSIGN_STATUS_ID);
	ps.setInt(4, mId);
	rs=ps.executeQuery();
	list4=new ArrayList();
	while(rs.next()){
		ProjectDto pdto = new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setExpectedStartDate(rs.getDate(4));
		pdto.setExpectedEndDate(rs.getDate(5));
		pdto.setProjectCompletionPercentage(rs.getDouble(6));
		ProjectManagerProjectDto pmpdto=new ProjectManagerProjectDto();
		pmpdto.setProjectId(pdto);
	    UserDto udto = new UserDto();
	    udto.setFirstName(rs.getString(7));
	    udto.setEmail(rs.getString(8));
	    udto.setMobileNo(rs.getString(9));
	    udto.setImage(rs.getBlob(10));
	    udto.setGender(rs.getString(11));
	    pmpdto.setProjectManagerId(udto);
	    ProjectModuleDto pmdto=new ProjectModuleDto();
	    pmdto.setProjectManagetProjectId(pmpdto);
	    pmdto.setProjectModuleId(rs.getInt(12));
	    pmdto.setModuleTitle(rs.getString(13));
	    pmdto.setModuleDescription(rs.getString(14));
	    pmdto.setStartDate(rs.getDate(15));
	    pmdto.setEndDate(rs.getDate(16));
	    UserDto udto1=new UserDto();
	    udto1.setFirstName(rs.getString(17));
	    udto1.setEmail(rs.getString(18));
	    udto1.setMobileNo(rs.getString(19));
	   Blob b = rs.getBlob(20);
	   // byte bar[]=b.getBytes(1, (int)b.length());
	    //FileOutputStream fout=new FileOutputStream();
	   udto1.setImage(rs.getBlob(20));
	    udto1.setGender(rs.getString(21));
	    pmdto.setTeamLeadId(udto1);
	    
	    list4.add(pmdto);
		
	}
	return list4;
	

}


@Override
public List getNotificationAssignProject(Connection con, Integer pId) throws SQLException {
	// TODO Auto-generated method stub
	ps = con.prepareStatement(SQLQueryConstants.ASSIGN_PROJECT_NOTIFICATION);
	ps.setInt(1,IntegerConstants.ASSIGN_STATUS_ID);
	ps.setInt(2, pId);
	rs = ps.executeQuery();
	List listp = new ArrayList();
	while(rs.next())
	{
		
		ProjectDto pdto=new ProjectDto();
		pdto.setProjectId(rs.getInt(1));
		System.out.println("projectId :"+rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		System.out.println("Project Title : "+rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setProjectCompletionPercentage(rs.getDouble(4));
		System.out.println("ProjectCompletionPercentage : "+rs.getString(4));
		pdto.setExpectedStartDate(rs.getDate(5));
		pdto.setExpectedEndDate(rs.getDate(6));
		System.out.println("endDate"+rs.getDate(6));
		ProjectManagerProjectDto pmpdto1=new ProjectManagerProjectDto();
		pmpdto1.setProjectId(pdto);
		ProjectStatusDto psdto=new ProjectStatusDto();
		psdto.setProjectManagerProjectId(pmpdto1);
		psdto.setStatusInfo(rs.getString(7));
		System.out.println(rs.getString(7));
		UserDto udto = new UserDto();
		udto.setFirstName(rs.getString(8));
		udto.setEmail(rs.getString(9));
		udto.setMobileNo(rs.getString(10));
		udto.setImage(rs.getBlob(11));
		udto.setGender(rs.getString(12));
		pmpdto1.setProjectManagerId(udto);
		psdto.setProjectManagerProjectId(pmpdto1);
		listp.add(psdto);
		
	}
	logger.debug(listp);
	
	return listp;

}






@Override
public List<DeveloperTaskDto> notificationAcceptedTask(Integer supid, Connection con) {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	List<DeveloperTaskDto> taskstatus1= new ArrayList<DeveloperTaskDto>();
	try{
		ps=con.prepareStatement(SQLQueryConstants.NOTIFICATION_REGARDING_TO_ACCEPTED_OR_REJECTED);


ps.setInt(1, IntegerConstants.STATUS_ASSIGNED);
		
		ps.setInt(2, supid);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			
			logger.info("retriving notifications");
			UserDto ud = new UserDto();
			ud.setFirstName(rs.getString(1));
			System.out.println(rs.getString(1));
			ud.setEmail(rs.getString(2));
			System.out.println(rs.getString(2));
			ud.setMobileNo(rs.getString(3));
	        System.out.println(rs.getString(3));
			
			ProjectDto projectDto = new ProjectDto();
			projectDto.setProjectId(rs.getInt(4));
			System.out.println(rs.getInt(4));
			projectDto.setProjectTitle(rs.getString(5));
			System.out.println(rs.getString(5));
			projectDto.setProjectDescription(rs.getString(6));
			System.out.println(rs.getString(6));
			ProjectManagerProjectDto projectManagetProjectDto = new ProjectManagerProjectDto();
			projectManagetProjectDto.setProjectId(projectDto);
        ProjectModuleDto projectModuleDto = new ProjectModuleDto();
        projectModuleDto.setProjectManagetProjectId(projectManagetProjectDto);
        
         projectModuleDto.setProjectModuleId(rs.getInt(7));
         System.out.println(rs.getInt(7));
			
        projectModuleDto.setModuleTitle(rs.getString(8));
        System.out.println(rs.getString(8));

            projectModuleDto.setModuleDescription(rs.getString(9));
            System.out.println(rs.getString(9));

			ModuleTaskDto moduleTaskDto= new ModuleTaskDto();
			moduleTaskDto.setProjectModuleId(projectModuleDto);
			
			moduleTaskDto.setTaskTitle(rs.getString(10));
			System.out.println(rs.getString(10));
			moduleTaskDto.setTaskDescription(rs.getString(11));
			System.out.println(rs.getString(11));
			StatusDto statusDto = new StatusDto();
			statusDto.setStatusId(rs.getInt(13));
			System.out.println(rs.getInt(13));
			statusDto.setStatus(rs.getString(14));
			System.out.println(rs.getString(14));
		
			moduleTaskDto.setStatusId(statusDto);
			
			DeveloperTaskDto tDto=new DeveloperTaskDto();
			tDto.setModuleTaskId(moduleTaskDto);
			 tDto.setDeveloperTaskId(rs.getInt(15));
			 System.out.println(rs.getInt(15));
		     tDto.setApprovalStatusId(statusDto);
             tDto.setModuleTaskId(moduleTaskDto);
             tDto.setDeveloperId(ud);
       
			taskstatus1.add(tDto);
		
			/*
			logger.debug(tDto.getDeveloperTaskId());
			
			logger.debug(tDto);*/
		}
	}
	catch(SQLException e)
	{
		logger.error(e.getMessage());
		e.printStackTrace();
	}
	return taskstatus1;
	
}

@Override
public List<AssignTask> getNotificationAssignedTaskCompleteInfo(Integer dtId, Connection con1) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	List<AssignTask> taskstatus2= new ArrayList<AssignTask>();
	try{
		ps=con1.prepareStatement(SQLQueryConstants.GET_CMPLETE_TASK_INFO_NOTI);
		ps.setInt(1, dtId);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			
			AssignTask at = new AssignTask();
			
			
			logger.info("retriving notifications");
			// developer
		at.setDevFirstName(rs.getString(1));
		System.out.println(rs.getString(1));
		at.setDevemail(rs.getString(2));
		System.out.println(rs.getString(2));
	at.setDevMobileNo(rs.getString(3));
        System.out.println(rs.getString(3));
       try {
		at.setDevimage(ImageUtil.encodeImage( rs.getBlob(4).getBinaryStream()));
	System.out.println("img : Success"+( rs.getBlob(4).getBinaryStream()));
       } catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
        // TeamLeader
        at.setTemledFirstName(rs.getString(5));
		System.out.println(rs.getString(5));
at.setTemledemail(rs.getString(6));
		System.out.println(rs.getString(6));
	at.setTemledMobileNo(rs.getString(7));
	 System.out.println(rs.getString(7));
	   
      try {
		at.setTemledimage(ImageUtil.encodeImage(rs.getBlob(8).getBinaryStream()));
		System.out.println("TL IMG SUCC");
	} catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("TL IMG fail");
		
	}
        
        // project manager
      
      
        at.setPromgrFirstName(rs.getString(9));
		System.out.println(rs.getString(9));
	at.setPromgremail(rs.getString(10));
		System.out.println(rs.getString(10));
		at.setPromgrMobileNo(rs.getString(11));
        System.out.println(rs.getString(11));
     try {
		at.setPromgrimage(ImageUtil.encodeImage(rs.getBlob(12).getBinaryStream()));
	System.out.println("PM IMG SUCCESS");
     } catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("PM IMG fail");
		  
     }
        System.out.println(rs.getBlob(12));
        
		// project dto
		at.setExpectedStartDate(DateUtil.sqlDateToString(rs.getDate(13)));
		System.out.println(at.getExpectedStartDate());
		at.setExceptedEndDate(DateUtil.sqlDateToString(rs.getDate(14)));
		System.out.println(at.getExceptedEndDate());
		at.setProjectId(rs.getInt(15)+"");
		System.out.println(rs.getInt(15));
		at.setProjectTitle(rs.getString(16));
		System.out.println(rs.getString(16));
		at.setProjectDescription(rs.getString(17));
		System.out.println(rs.getString(17));
	
     at.setProjectModuleid(rs.getInt(18)+"");
     System.out.println(rs.getInt(18));
		
    at.setModuleTitle(rs.getString(19));
    System.out.println(rs.getString(19));

       at.setModuleDescription(rs.getString(20));
        System.out.println(rs.getString(20));
    
		
		at.setTaskTitle(rs.getString(21));
		System.out.println(rs.getString(21));
		at.setTaskDescription(rs.getString(22));
		System.out.println(rs.getString(22));
		StatusDto statusDto = new StatusDto();
		at.setStatusId(rs.getInt(24)+"");
		System.out.println(rs.getInt(24));
		at.setStatus(rs.getString(25));
		System.out.println(rs.getString(25));
	
		 at.setDevloperTaskId(rs.getInt(15)+"");
		 System.out.println(rs.getInt(15));
	
         taskstatus2.add(at);
	
		/*
		logger.debug(tDto.getDeveloperTaskId());
		
		logger.debug(tDto);*/
	}
}
catch(SQLException e)
{
	logger.error(e.getMessage());
	e.printStackTrace();
}
return taskstatus2;

}

@Override
public List<ApproveRejectForTL> getNotificationApproveorRejectForTL(Integer sup, Integer dtId,Connection con) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement ps=null;
	List<ApproveRejectForTL> atl= new ArrayList<ApproveRejectForTL>();
	try{
		ps=con.prepareStatement(SQLQueryConstants.GET_NOTIFICATION_REGARDING_TO_ACCEPTED_OR_REJECTED_FOR_TL);
		ps.setInt(1,IntegerConstants.ACCEPTED_TASK);
		ps.setInt(2,IntegerConstants.REJECTED_TASK);
		
		ps.setInt(3, sup);

		ps.setInt(4, dtId);
		logger.info(ps.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
				
			
			logger.info("retriving notifications");
			//UserDto ud = new UserDto();
			ApproveRejectForTL art= new ApproveRejectForTL();
			
			art.setFirstName(rs.getString(1));
			System.out.println(rs.getString(1));
			art.setEmail(rs.getString(2));
			System.out.println(rs.getString(2));
			art.setMobileNo(rs.getString(3));
	        System.out.println(rs.getString(3));
	        
	        try {
				
	        	art.setImage(ImageUtil.encodeImage(rs.getBlob(4).getBinaryStream()));
				System.out.println("img success");
			} catch (ImageStreamToByteException e) {
				
			    e.printStackTrace();
				System.out.println("img not success");
			}
	        System.out.println(rs.getBlob(4));
			
	        art.setProjectId(rs.getInt(5));
	        System.out.println(rs.getInt(5));
	        
	         art.setProjectTitle(rs.getString(6));
	        System.out.println(rs.getString(6));
	        
	       art.setProjectDescription(rs.getString(7));
	       System.out.println(rs.getString(7));
	        
	       
	        /*art.setModuleTitle(rs.getString(8));
	        System.out.println(rs.getString(8));*/
	        
	        
	       art.setProjectModuleId(rs.getString(8));
	       System.out.println(rs.getString(8));
	        
	        art.setModuleTitle(rs.getString(9));
	        System.out.println(rs.getString(9));
	        
	        art.setModuleDescription(rs.getString(10));
	        System.out.println(rs.getString(10));
	        
	          art.setTaskTitle(rs.getString(11));	
	          System.out.println(rs.getString(11));
             
             art.setTaskDescription(rs.getString(12));
             System.out.println(rs.getString(12));
             
            art.setStatusId(rs.getString(14));
            System.out.println(rs.getString(14));
            
            
            art.setStatus(rs.getString(15));
            System.out.println(rs.getString(15));
            
            art.setDeveloperTasKId(rs.getString(16));
            System.out.println(rs.getString(16));
			/*//ProjectDto projectDto = new ProjectDto();
			art.setProjectId(rs.getString(5));
			System.out.println(rs.getInt(5));
			//ProjectDto projectDto = new ProjectDto();
			art.setProjectTitle(rs.getString(6));
			System.out.println(rs.getString(6));
			art.setProjectDescription(rs.getString(7));
			System.out.println(rs.getString(7));
			ProjectManagerProjectDto projectManagetProjectDto = new ProjectManagerProjectDto();
			projectManagetProjectDto.setProjectId(projectDto);
        ProjectModuleDto projectModuleDto = new ProjectModuleDto();
        projectModuleDto.setProjectManagetProjectId(projectManagetProjectDto);
        
         art.setProjectModuleId(rs.getString(8));
         System.out.println(rs.getInt(8));
			
        art.setModuleTitle(rs.getString(9));
        System.out.println(rs.getString(9));

            art.setModuleDescription(rs.getString(10));
            System.out.println(rs.getString(10));

			ModuleTaskDto moduleTaskDto= new ModuleTaskDto();
			moduleTaskDto.setProjectModuleId(projectModuleDto);
			
		       // art.setTaskTitle(rs.getString(11));
			System.out.println(rs.getString(11));
			//art.setModuleDescription(rs.getString(12));
			System.out.println(rs.getString(12));
			//StatusDto statusDto = new StatusDto();
			//art.setStatusId(rs.getString(14));
			System.out.println(rs.getInt(14));
			//art.setStatus(rs.getString(15));
			System.out.println(rs.getString(15));
		
			//moduleTaskDto.setStatusId(statusDto);
			
			DeveloperTaskDto tDto=new DeveloperTaskDto();
			//tDto.setModuleTaskId(moduleTaskDto);
			 tDto.setDeveloperTaskId(rs.getInt(16));
			 System.out.println(rs.getInt(16));
		    // tDto.setApprovalStatusId(statusDto);
          //   tDto.setModuleTaskId(moduleTaskDto);
            // tDto.setDeveloperId(atl);
       */
             atl.add(art);
			
		}
		//return ;
	}catch(SQLException e)
	{
		logger.error(e.getMessage());
		e.printStackTrace();
	}
	return atl;
}

@Override
public List<AcceptTask> getNotificationAcceptTask(Integer sup, Connection con)throws SQLException {
	// TODO Auto-generated method stub
	List<AcceptTask> at = new ArrayList<AcceptTask>();
	PreparedStatement ps =null;
	try{
		ps=con.prepareStatement(SQLQueryConstants.GET_NOTIFICATION_ACCEPT_TASK);
		ps.setInt(1, IntegerConstants.ASSIGNED_STATUS);
		ps.setInt(2, sup);
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
		AcceptTask accepts = new AcceptTask();
		// set the value 
		accepts.setFirstName(rs.getString(1));
		System.out.println(rs.getString(1));
		
		accepts.setEmail(rs.getString(2));
		System.out.println(rs.getString(2));
		
		accepts.setMobileNo(rs.getString(3));
		System.out.println(rs.getString(3));
		
		try {
			accepts.setImage(ImageUtil.encodeImage(rs.getBlob(4).getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		accepts.setProjectId(rs.getInt(5));
		System.out.println(rs.getInt(5));
		
		accepts.setProjectTitle(rs.getString(6));
		System.out.println(rs.getString(6));
		
		
		
		accepts.setProjectDescription(rs.getString(7));
		System.out.println(rs.getString(7));
		
		accepts.setProjectModuleId(rs.getString(8));
		System.out.println(rs.getString(8));
		
		accepts.setModuleTitle(rs.getString(9));
		System.out.println(rs.getString(9));
		
		accepts.setModuleDescription(rs.getString(10));
		System.out.println(rs.getString(10));
		
		accepts.setTaskTitle(rs.getString(11));
		System.out.println(rs.getString(11));
		
		accepts.setTaskDescription(rs.getString(12));
		System.out.println(rs.getString(12));
		
		accepts.setStatusId(rs.getString(14));
		System.out.println(rs.getString(14));
		
		accepts.setStatus(rs.getString(15));
		System.out.println(rs.getString(15));
		
		accepts.setDeveloperTasKId(rs.getString(16));
		System.out.println(rs.getString(16));
		}
	}catch(SQLException e1)
	{
		logger.error(e1.getMessage());
		e1.printStackTrace();
	}
	return at;
}
public   boolean updateStatus1( Integer id ,Connection con) throws SQLException{
	    boolean res = false;
	   PreparedStatement ps =null;
		try{
			ps=con.prepareStatement(SQLQueryConstants.UPDATE_STATUS);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
			}
	   
	   
	   
	   
		}catch(SQLException e){
			e.getMessage();
			
		}
	   
	   
	   
	  
	   return res;
	   
	   
	   
	   
	   
	   
   }
	   
	  
@Override
public boolean updateStatus(Integer id,String accept,Connection con) throws SQLException {
	 boolean res = false;
	   PreparedStatement ps =null;
		System.out.println("<<<<<<<<<<<< DAO>>"+accept+"<<M");
		try{
			ps=con.prepareStatement(SQLQueryConstants.UPDATE_STATUS);
			
			if(accept.equalsIgnoreCase("true")){
				ps.setInt(1, IntegerConstants.ACCEPTED_TASK);
				
			}else 	if(accept.equalsIgnoreCase("false")){
			
				ps.setInt(1, IntegerConstants.REJECTED_TASK);
				
			}else{
				ps.setInt(1, IntegerConstants.STATUS_ASSIGNED);
					
				
			}
			
			ps.setInt(2,id);
			int stat = ps.executeUpdate();
			System.out.println("<<<<<<<<<<<<"+stat);
			if(stat!=0){
				return true;
			}else{
			return false;
			}
	   
	   
	   
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	   
	   
	   
	  
	   return res;
	   
	   
	   
	   
	   
	   
 }
	



/*@Override
public List<DeveloperTaskDto> updateStatus(Integer id) {
	// TODO Auto-generated method stub
	return null;
}*/

/*public List<DeveloperTaskDto> notificationAcceptedTask1(Integer supid1, Connection con2) {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	List<DeveloperTaskDto> taskstatus2= new ArrayList<DeveloperTaskDto>();
	try{
		ps=con2.prepareStatement(SQLQueryConstants.NOTIFICATION_REGARDING_TO_ACCEPTED_OR_REJECTED);
ps.setInt(1, IntegerConstants.STATUS_ASSIGNED);
		ps.setInt(2, supid1);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			
			logger.info("retriving notifications");
			UserDto ud = new UserDto();
			ud.setFirstName(rs.getString(1));
			System.out.println(rs.getString(1));
			ud.setEmail(rs.getString(2));
			System.out.println(rs.getString(2));
			ud.setMobileNo(rs.getString(3));
	        System.out.println(rs.getString(3));
			
			ProjectDto projectDto = new ProjectDto();
			projectDto.setProjectId(rs.getInt(4));
			System.out.println(rs.getInt(4));
			projectDto.setProjectTitle(rs.getString(5));
			System.out.println(rs.getString(5));
			projectDto.setProjectDescription(rs.getString(6));
			System.out.println(rs.getString(6));
			ProjectManagerProjectDto projectManagetProjectDto = new ProjectManagerProjectDto();
			projectManagetProjectDto.setProjectId(projectDto);
        ProjectModuleDto projectModuleDto = new ProjectModuleDto();
        projectModuleDto.setProjectManagetProjectId(projectManagetProjectDto);
        
         projectModuleDto.setProjectModuleId(rs.getInt(7));
         System.out.println(rs.getInt(7));
			
        projectModuleDto.setModuleTitle(rs.getString(8));
        System.out.println(rs.getString(8));

            projectModuleDto.setModuleDescription(rs.getString(9));
            System.out.println(rs.getString(9));

			ModuleTaskDto moduleTaskDto= new ModuleTaskDto();
			moduleTaskDto.setProjectModuleId(projectModuleDto);
			
			moduleTaskDto.setTaskTitle(rs.getString(10));
			System.out.println(rs.getString(10));
			moduleTaskDto.setTaskDescription(rs.getString(11));
			System.out.println(rs.getString(11));
			StatusDto statusDto = new StatusDto();
			statusDto.setStatusId(rs.getInt(13));
			System.out.println(rs.getInt(13));
			statusDto.setStatus(rs.getString(14));
			System.out.println(rs.getString(14));
		
			moduleTaskDto.setStatusId(statusDto);
			
			DeveloperTaskDto tDto=new DeveloperTaskDto();
			tDto.setModuleTaskId(moduleTaskDto);
			 tDto.setDeveloperTaskId(rs.getInt(15));
			 System.out.println(rs.getInt(15));
		     tDto.setApprovalStatusId(statusDto);
             tDto.setModuleTaskId(moduleTaskDto);
             tDto.setDeveloperId(ud);
       
			taskstatus2.add(tDto);
		
			
			logger.debug(tDto.getDeveloperTaskId());
			
			logger.debug(tDto);
		}
	}
	catch(SQLException e)
	{
		logger.error(e.getMessage());
		e.printStackTrace();
	}
	return taskstatus2;
	
}*/






}






