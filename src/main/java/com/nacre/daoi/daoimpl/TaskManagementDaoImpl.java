/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.TaskManagementDaoI;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.TaskViewInfoBean;
import com.nacre.uitl.ImageUtil;
import com.nacre.uitl.PooledConnection;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.UserDto;
import com.nacre.formbean.DeveloperInfoBean;
import com.nacre.formbean.TaskInfoBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class TaskManagementDaoImpl implements TaskManagementDaoI {

public static final Logger logger = 	Logger.getLogger(TaskManagementDaoImpl.class);

/**
 * @author Chakravarthi K
 * @param Integer
 *            team lead Id based on which we get moduleId
 * @param Connection
 *            the Connection to set
 * @return Integer 
 *             this returns the value of moduleId
 *  
 * @throws SQLException
 */

	public Integer getModuleId(Connection con, Integer teamleadId) throws SQLException 
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps = con.prepareStatement(SQLQueryConstants.GET_MODULE_ID);
		ps.setInt(1, teamleadId);
		rs=ps.executeQuery();
		Integer moduleId=null;
		while(rs.next())
		{
			moduleId=rs.getInt(1);
		return moduleId;
		}
		return moduleId;
}

	/**
	 * @author Chakravarthi K
	 * @param ModuleTaskDto 
	 *            the task to set
	 * @param Connection
	 *            the Connection to set
	 * @return boolean 
	 * 			value true for adding task successfully
	 *          false when task adding task is not done  
	 *               
	 * @throws SQLException
	 */
public boolean addTask(Connection con, ModuleTaskDto tDto) throws SQLException {
	PreparedStatement ps = null;
	int count = 0;
	Blob b = tDto.getTaskReferenceDocument();
	byte[] by = null;
	ps = con.prepareStatement(SQLQueryConstants.ADD_TASK);
	ps.setString(1, tDto.getTaskTitle());
	ps.setString(2, tDto.getTaskDescription());
	
		ps.setBlob(3,b);
	
	ps.setString(4, tDto.getDocumentNameWithExtension());
	if (tDto.getStartDate() != null)
		ps.setDate(5, new Date(tDto.getStartDate().getTime()));
	else
		ps.setDate(5, null);

	if (tDto.getEndDate() != null)
		ps.setDate(6, new Date(tDto.getEndDate().getTime()));
	else
		ps.setDate(6, null);

	ps.setInt(7, tDto.getProjectModuleId().getProjectModuleId());
	ps.setInt(8, tDto.getStatusId().getStatusId());
	ps.setFloat(9, tDto.getTaskCompletionPercent());

	count = ps.executeUpdate();
	if(count==0)
		return false;
	else
		return true;
}

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

public Integer assignTaskToDeveloper(Connection con, DeveloperTaskDto devDto) throws SQLException {
	PreparedStatement ps = null;
	Integer count = null;
	Integer update = null;
	PreparedStatement psUpdate = null;

	ps = con.prepareStatement(SQLQueryConstants.ASSIGN_TASK_TO_DEVELOPER);

	ps.setInt(1, devDto.getModuleTaskId().getModuleTaskId());
	ps.setInt(2, devDto.getDeveloperId().getUserId());
	ps.setInt(3, devDto.getApprovalStatusId().getStatusId());

	count = ps.executeUpdate();

	psUpdate = con.prepareStatement(SQLQueryConstants.UPDATE_TASK_STATUS);
	psUpdate.setInt(1, devDto.getApprovalStatusId().getStatusId());
	psUpdate.setInt(2, devDto.getModuleTaskId().getModuleTaskId());
	update = psUpdate.executeUpdate();

	if (count == 0 || update == 0)
		return 0;
	else
		return count;

}
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


@Override
public List<TaskInfoBean> getNotAssignedTasks(Connection con,Integer teamleadId) throws SQLException {
	List<TaskInfoBean> list = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	TaskInfoBean tDto=null;
	// create instance of List
	list = new ArrayList<>();

	ps = con.prepareStatement(SQLQueryConstants.NOT_ASSIGNED_TASKS);
	ps.setInt(1,teamleadId);
	rs = ps.executeQuery();
	while (rs.next()) {
		tDto=new TaskInfoBean();
		tDto.setModuleTaskId(rs.getInt("moduleTaskId"));
		tDto.setTaskTitle(rs.getString("taskTitle"));
		tDto.setTaskDescription(rs.getString("taskDescription"));
		tDto.setModuleTitle(rs.getString("moduleTitle"));
		tDto.setProjectTitle(rs.getString("projectTitle"));
		list.add(tDto);
	}
	return list;
}

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


@Override
public List<UserDto> getDevelopers(Connection con) throws SQLException {
	List<UserDto> list = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	UserDto tDto=null;
	// create instance of List
	list = new ArrayList<>();

	ps = con.prepareStatement(SQLQueryConstants.GET_DEVELOPERS);

	rs = ps.executeQuery();
	while (rs.next()) {
		tDto=new UserDto();
		tDto.setUserId(rs.getInt(1));
		tDto.setFirstName(rs.getString(2));
		tDto.setEmail(rs.getString(3));
		tDto.setMobileNo(rs.getString(4));
		tDto.setImage(rs.getBlob(5));
		list.add(tDto);
	}
	return list;
}




private static final int BUFFER_SIZE = 4096;
public TaskManagementDaoImpl(int id) {
	// TODO Auto-generated constructor stub
}

public TaskManagementDaoImpl() {
	// TODO Auto-generated constructor stub
}

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




@Override
public List<ModuleTaskDto> viewTaskDao(Connection con,Integer uId) throws NoConnectionException, DatabaseException {
	List<ModuleTaskDto> moduletasklist=new ArrayList<ModuleTaskDto>();
	 
	try
	 {
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.VIEWMODULETASK);
		ps.setInt(1, IntegerConstants.REMOVE_STATUS);
		ps.setInt(2, uId);
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			ModuleTaskDto moduletaskdto=new ModuleTaskDto();
			ProjectModuleDto projectmoduledto=new ProjectModuleDto();
			StatusDto statusdto=new StatusDto();
			moduletaskdto.setModuleTaskId(rs.getInt(1));
			moduletaskdto.setTaskTitle(rs.getString(2));
			moduletaskdto.setTaskDescription(rs.getString(3));
			moduletaskdto.setDocumentNameWithExtension(rs.getString(5));
		    moduletaskdto.setStartDate(new Date(rs.getDate(6).getTime()));
		    moduletaskdto.setEndDate(new Date(rs.getDate(7).getTime()));
			projectmoduledto.setProjectModuleId(rs.getInt(8));
			statusdto.setStatusId(rs.getInt(9));
			moduletaskdto.setProjectModuleId(projectmoduledto);
			moduletaskdto.setStatusId(statusdto);
			moduletaskdto.setTaskCompletionPercent(rs.getFloat(10));
			moduletasklist.add(moduletaskdto);
			
			
	  }	
		
		
		
	}catch(Exception e){e.printStackTrace();}
	
	return moduletasklist;
}



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




@Override
public List<DeveloperTaskDto> viewDeveloperTaskDao(Connection con,Integer uId) throws NoConnectionException, DatabaseException {
	List<DeveloperTaskDto> moduletasklist=new ArrayList<DeveloperTaskDto>();
	 
	try
	 {
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.VIEW_DEV_TASK);
		ps.setInt(1, IntegerConstants.REMOVE_STATUS);
		ps.setInt(2, uId);
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			DeveloperTaskDto developerTaskDto = new DeveloperTaskDto();
			
			
			ModuleTaskDto moduletaskdto=new ModuleTaskDto();
			ProjectModuleDto projectmoduledto=new ProjectModuleDto();
			StatusDto statusdto=new StatusDto();
			moduletaskdto.setModuleTaskId(rs.getInt(1));
			moduletaskdto.setTaskTitle(rs.getString(2));
			moduletaskdto.setTaskDescription(rs.getString(3));
			moduletaskdto.setDocumentNameWithExtension(rs.getString(5));
		    

		    Date date =rs.getDate(6);
		    if(date!=null){
			moduletaskdto.setStartDate(new Date(date.getTime()));
		    }
		    date =rs.getDate(7);
		    if(date!=null){
		    moduletaskdto.setEndDate(new Date(date.getTime()));
		    }
		    projectmoduledto.setProjectModuleId(rs.getInt(8));
			statusdto.setStatusId(rs.getInt(9));
			moduletaskdto.setProjectModuleId(projectmoduledto);
			moduletaskdto.setStatusId(statusdto);
			moduletaskdto.setTaskCompletionPercent(rs.getFloat(10));
			
			developerTaskDto.setDeveloperTaskId(rs.getInt(11));
			developerTaskDto.setModuleTaskId(moduletaskdto);
			moduletasklist.add(developerTaskDto);
			
			
	  }	
		
		
		
	}catch(Exception e){e.printStackTrace();}
	
	return moduletasklist;
}


/** 
 * @author Raj Kishore Singh
 * 
 * @param Connection con,int id
 *               to set connection and send id for query to show individual row
 * 
 * @return ModuleTaskDto 
 *             to get  object
 * 
 * @throws NoConnectionException, DatabaseException
 * 
 */
@Override
public ModuleTaskDto viewIndividualTaskDao(Connection con,int id) throws NoConnectionException, DatabaseException {
	ModuleTaskDto moduletasklist=null;
	 
	try
	 {
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.VIEWINDIVIDUALMODULETASK);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			
			ModuleTaskDto moduletaskdto=new ModuleTaskDto();
			ProjectModuleDto projectmoduledto=new ProjectModuleDto();
			StatusDto statusdto=new StatusDto();
			moduletaskdto.setModuleTaskId(rs.getInt(1));
			moduletaskdto.setTaskTitle(rs.getString(2));
			moduletaskdto.setTaskDescription(rs.getString(3));
			moduletaskdto.setTaskReferenceDocument(rs.getBlob(4));
		    /*System.out.println("filenames:::"+rs.getString(5));*/
		    
			moduletaskdto.setDocumentNameWithExtension(rs.getString(5));
		    moduletaskdto.setStartDate(new Date(rs.getDate(6).getTime()));
		    moduletaskdto.setEndDate(new Date(rs.getDate(7).getTime()));
			projectmoduledto.setProjectModuleId(rs.getInt(8));
			statusdto.setStatusId(rs.getInt(9));
			moduletaskdto.setProjectModuleId(projectmoduledto);
			moduletaskdto.setStatusId(statusdto);
			//moduletaskdto.setTaskCompletionPercent(rs.getFloat(10));
			
			return moduletaskdto;
			//moduletasklist.add(moduletaskdto);
			
			
	  }	
		
		
	}catch(Exception e){e.printStackTrace();}
	
	return moduletasklist;
}

/** 
 * @author Raj Kishore Singh
 * 
 * @param Connection con,int id
 *               to set connection and send id for query to show individual row
 * 
 * @return ModuleTaskDto 
 *             to get  object
 * 
 * @throws NoConnectionException, DatabaseException
 * 
 */


public ModuleTaskDto downloadDocument(Connection con,int id) throws NoConnectionException, DatabaseException {	 
	ModuleTaskDto moduletaskdto=null;
	try
	 {
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GETDOCUMENTS);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			moduletaskdto=new ModuleTaskDto();
			moduletaskdto.setTaskReferenceDocument(rs.getBlob(1));
	        moduletaskdto.setDocumentNameWithExtension(rs.getString(2));
			
	     }	
		
	}catch(Exception e){e.printStackTrace();}
	
	return moduletaskdto;
}


/** 
 * @author Raj Kishore Singh
 * 
 * @param ModuleTaskDto mdto,Connection con
 *               to set connection and send ModuleTaskDto mdto objects 
 * 
 * @return boolean
 *             to get true/false for updation
 * 
 * @throws NoConnectionException, DatabaseException
 * 
 */

public boolean updateTaskDetails(ModuleTaskDto mdto,Connection con) throws NoConnectionException, DatabaseException{
   boolean result=false;
    String message = null;  // message will be sent back to client
    /*System.out.println("welcom to con............"+con);*/
     Blob doc=mdto.getTaskReferenceDocument();
    
     int id=mdto.getModuleTaskId();
     /*System.out.println("printing from daoimpl"+id);*/
    
    
       Blob b=null;
       String s=null;
    try {
        
    	PreparedStatement ps=con.prepareStatement(SQLQueryConstants.UPDATETASK);
        ps.setString(1, mdto.getTaskTitle());
        ps.setString(2, mdto.getTaskDescription());
        
        if(doc==null){
        	
        	PreparedStatement ps2=con.prepareStatement(SQLQueryConstants.GET_TASK_DOCUMENT);
        	ps2.setInt(1, id);
        	ResultSet rs=	ps2.executeQuery();
    		
        	if(rs.next()){
    			b=rs.getBlob(1);
    		    s=rs.getString(2);
    	
               }
        	
        	
        	ps.setBlob(3, b);
            ps.setString(4,s);
         } 
        	
        else
        {	
        	ps.setBlob(3, mdto.getTaskReferenceDocument());
            ps.setString(4, mdto.getDocumentNameWithExtension());
        }
        
        
        
        
        
        
        /*System.out.println("filenames:::"+mdto.getDocumentNameWithExtension());*/
        ps.setDate(5,new Date(mdto.getStartDate().getTime()));
        ps.setDate(6,new Date(mdto.getEndDate().getTime()));
        //ps.setInt(7, mdto.getProjectModuleId().getProjectModuleId());
        //ps.setInt(7, mdto.getStatusId().getStatusId());
        ps.setInt(7, mdto.getModuleTaskId());
        // sends the statement to the database server
        int row = ps.executeUpdate();
       /* System.out.println("dao"+row);*/
        if (row != 0) {
            message = "File uploaded and saved into database";
            result=true;
			con.commit();
			
        }else{
        	con.rollback();
        }
        /*System.out.println(message+"maessage");*/
    
   
    } catch (SQLException ex) {
        message = "ERROR: " + ex.getMessage();
        ex.printStackTrace();
        
    }

return result;	
	
}





/** 
 * @author Raj Kishore Singh
 * 
 * @param Connection con,int id
 *               to set connection and send id for query to show individual row
 * 
 * @return boolean 
 *             to get ture/false to removeDocument
 * 
 * @throws NoConnectionException, DatabaseException
 * 
 */


@Override
public boolean removeDocument(Connection con,int id) throws NoConnectionException, DatabaseException {
	boolean result=false;
    String message = null;  // message will be sent back to client
   
    try {
        
    	PreparedStatement ps=con.prepareStatement(SQLQueryConstants.REMOVETASK);
        ps.setInt(1, 11);
        ps.setInt(2, id);
       
        int row = ps.executeUpdate();
        
        if (row != 0) {
            message = "File uploaded and saved into database";
            result=true;
			con.commit();
			
        }else{
        	con.rollback();
        }
        
    
    } catch (SQLException ex) {
        message = "ERROR: " + ex.getMessage();
        ex.printStackTrace();
        
    }

return result;	
	
}



/** 
 * @author Raj Kishore Singh
 * 
 * @param Connection con, Integer moduleTaskId
 *               to set connection and send id for query to show individual row
 * 
 * @return TaskViewInfoBean
 *             to get object of TaskViewInfoBean
 * 
 * @throws NoConnectionException, DatabaseException
 * 
 */




public TaskViewInfoBean viewTaskInfoById(Connection con, Integer moduleTaskId) throws NoConnectionException,DatabaseException {
	
	//TaskViewInfoBean taskVeiwInfoBeanList=null;
	
	
PreparedStatement ps=null;
ResultSet rs=null;
	try {
		
		
		ps = con.prepareStatement(SQLQueryConstants.GET_TASK_INFORMATION);
		ps.setInt(1, moduleTaskId);
		rs = ps.executeQuery();
        System.out.println("<<<<<<<<<<<<<<"+moduleTaskId);
		// processing the results
		if (rs.next()) {
			

	        System.out.println("<<<<<<<<<<<<<<"+moduleTaskId);
			TaskViewInfoBean taskVeiwInfoBean=new TaskViewInfoBean();	
		    ProjectDto projectDto=new ProjectDto();
		    UserDto projectManager=new UserDto();
		    ProjectModuleDto projectModuleDto=new ProjectModuleDto();
		    UserDto teamLeader=new UserDto();
		    UserDto developer=new UserDto();
		    ModuleTaskDto moduleTaskDto=new ModuleTaskDto();
			
			
           
			projectDto.setProjectTitle(rs.getString(1));
			projectDto.setProjectDescription(rs.getString(2));
			
			
			
			projectModuleDto.setModuleTitle(rs.getString(3));
			projectModuleDto.setModuleDescription(rs.getString(4));
			moduleTaskDto.setTaskTitle(rs.getString(5));
			moduleTaskDto.setTaskDescription(rs.getString(6));
			
            projectManager.setFirstName(rs.getString(7));
            projectManager.setMobileNo(rs.getString(8));
            projectManager.setEmail(rs.getString(9));
            Blob b =  rs.getBlob(10);
            if(b!=null)
            {
            
            taskVeiwInfoBean.setPmImage(ImageUtil.encodeImage(b.getBinaryStream()));
            }
            
            teamLeader.setFirstName(rs.getString(11));
            teamLeader.setMobileNo(rs.getString(12));
            teamLeader.setEmail(rs.getString(13));
            
            b= rs.getBlob(14);
            if(b!=null)
            {
            
            taskVeiwInfoBean.setTlImage(ImageUtil.encodeImage(b.getBinaryStream()));

            }

            developer.setFirstName(rs.getString(15));
            developer.setMobileNo(rs.getString(16));
            developer.setEmail(rs.getString(17));

            b= rs.getBlob(18);
            if(b!=null)
            { taskVeiwInfoBean.setdImage(ImageUtil.encodeImage( b.getBinaryStream()));
            }

			
            taskVeiwInfoBean.setProjectDto(projectDto);
            taskVeiwInfoBean.setProjectModuleDto(projectModuleDto);
            taskVeiwInfoBean.setModuleTaskDto(moduleTaskDto);
            taskVeiwInfoBean.setProjectManager(projectManager);
            taskVeiwInfoBean.setTeamLeader(teamLeader);
            taskVeiwInfoBean.setDeveloper(developer);
            
        	System.out.println(taskVeiwInfoBean);
			
			return taskVeiwInfoBean;
		}

	} catch (SQLException e) {
		e.printStackTrace();
		throw new NoConnectionException();
	} catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}

@Override
public List<ModuleTaskDto> getTaskDetails(Connection con, int uid) throws SQLException {
	List<ModuleTaskDto> moduletasklist=new ArrayList<ModuleTaskDto>();
	 
	try
	 {
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.VIEW_TASK_BY_DEV_ID);
		ps.setInt(1, uid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			ModuleTaskDto moduletaskdto=new ModuleTaskDto();
			ProjectModuleDto projectmoduledto=new ProjectModuleDto();
			StatusDto statusdto=new StatusDto();
			moduletaskdto.setTaskTitle(rs.getString("taskTitle"));
			moduletaskdto.setTaskDescription(rs.getString("taskDescription"));
			if(rs.getDate("startDate")==null)
					{
				moduletaskdto.setStartDate(null);
				
					}
			else
			{
				moduletaskdto.setStartDate(new Date(rs.getDate("endDate").getTime()));
				
			}
			if(rs.getDate("endDate")==null)
			{
				moduletaskdto.setEndDate(null);
		
			}
			else
			{
				moduletaskdto.setEndDate(new Date(rs.getDate("endDate").getTime()));
		
			}
			moduletaskdto.setTaskCompletionPercent(rs.getFloat("taskCompletionPercentage"));
			//moduletaskdto.setStartDate(new Date(rs.getDate("").getTime()));
		    //moduletaskdto.setEndDate(new Date(rs.getDate(7).getTime()));
			/*statusdto.setStatusId(rs.getInt(9));
			moduletaskdto.setProjectModuleId(projectmoduledto);
			moduletaskdto.setStatusId(statusdto);
			
			*/moduletasklist.add(moduletaskdto);		
	  }	
		
		
		
	}catch(Exception e){e.printStackTrace();}
	
	return moduletasklist;
}






}
