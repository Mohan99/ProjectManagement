/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.sql.Blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.nacre.constants.StringConstants;
import com.nacre.daoi.ModuleManagementDaoI;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.formbean.ModuleBean;
import com.nacre.uitl.ImageUtil;
import com.nacre.uitl.PooledConnection;
import com.sun.javafx.binding.IntegerConstant;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleBean;
import com.nacre.formbean.ModuleManagementFormBean;
import com.nacre.uitl.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */

public class ModuleManagementDaoImpl implements ModuleManagementDaoI {

public static final Logger logger = 	Logger.getLogger(ModuleManagementDaoImpl.class);

/**
 * method is used for display All modules to assign or
 * 			change team lead
 * 
 * @author pavan kumar y
 *
 */
@Override
public List<ProjectModuleDto> getModulesToAssignTL(Connection con,Integer projectManagerId) throws SQLException{
	// TODO Auto-generated method stub
	PreparedStatement pst=null;
	ResultSet rs=null;
	ProjectModuleDto pmdto=null;
	ProjectManagerProjectDto pmpdto=null;
	ProjectDto pdto=null;
	StatusDto sdto=null;
	UserDto udto=null;
	List<ProjectModuleDto> list=null;
	pst=con.prepareStatement(SQLQueryConstants.GET_MODULES_ASSIGN_TL);
	pst.setInt(1, projectManagerId);
	rs=pst.executeQuery();
	list=new ArrayList();
	if(rs!=null){
		while(rs.next()){
			
			logger.info(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+"  "+rs.getString(5)+"  "+rs.getDate(6)+"  "+rs.getDate(7));
			pmdto=new ProjectModuleDto();
			pmpdto=new ProjectManagerProjectDto();
			pdto=new ProjectDto();
			sdto=new StatusDto();
			udto=new UserDto();
			pmdto.setProjectModuleId(rs.getInt(1));
			pmdto.setModuleTitle(rs.getString(2));
			pmdto.setModuleDescription(rs.getString(3));
			pmdto.setModuleReferenceDocument(rs.getBlob(4));
			pmdto.setDocumentNameWithExtension(rs.getString(5));
			pmdto.setStartDate(rs.getDate(6));
			pmdto.setEndDate(rs.getDate(7));
			pmpdto.setProjectManagerProjectId(rs.getInt(8));
			pdto.setProjectTitle(rs.getString("projectTitle"));
			udto.setUserId(rs.getInt("teamLeadId"));
			udto.setFirstName(rs.getString("firstName"));
			udto.setLastName(rs.getString("lastName"));
			udto.setEmail(rs.getString("email"));
			udto.setMobileNo(rs.getString("mobileNo"));
			udto.setImage(rs.getBlob("image"));
			pmdto.setModuleCompletionPercent(rs.getFloat(10));
			sdto.setStatusId(rs.getInt("statusId"));
			sdto.setStatus(rs.getString("status"));
			pmdto.setStatusId(sdto);
			pmpdto.setProjectId(pdto);
			pmdto.setProjectManagetProjectId(pmpdto);
			pmdto.setTeamLeadId(udto);
			list.add(pmdto);
			System.out.println("dashfg"+pmdto.getStatusId().getStatus());
		}
		logger.info("rs is not null");
		return list;
	}else
		logger.info("rs is null");
	return list;
}
 





/**
	 * method is used for get all team leads to assign module
	 * 
	 * @author pavan kumar y
	 */

@Override
public List<UserDto> getTeamLeaderDetails(Connection con,Integer pmId) throws SQLException {

	PreparedStatement ps=null;
	ps=con.prepareStatement(SQLQueryConstants.GET_TEAMLEAD);
	ps.setInt(1, IntegerConstants.TEAMLEADER_ROLE_ID);
	ps.setInt(2, pmId);
	ResultSet rs=ps.executeQuery();
	List<UserDto> arraylist=new ArrayList();
	UserDto udto=null;
	if(rs!=null){
	while(rs.next()){
	 udto=new UserDto();
	udto.setUserId(rs.getInt(1));
	udto.setFirstName(rs.getString(2));
	udto.setLastName(rs.getString(3));
	udto.setEmail(rs.getString(4));
	udto.setMobileNo(rs.getString(5));
	udto.setPassword(rs.getString(6));
	udto.setGender(rs.getString(7));
	udto.setImage(rs.getBlob(8));
	arraylist.add(udto);
	}	
  }
	return arraylist;
}


/**
 * This method is used to add module
 * 
 * @author sandip
 * 
 * @param ProjectModuleDto
 *            the module to set
 * @param Connection
 *            the Connection to set
 * @return int value 0 for successful registration and 1 for registration
 *         failed
 * 
 * @throws SQLException
 * @see com.nacre.daoi.ModuleManagementDaoI#addModule(com.nacre.dto.ProjectModuleDto)
 */
@Override
public Integer addModule(ProjectModuleDto projectModuleDto, Connection con) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
    ps = con.prepareStatement(SQLQueryConstants.ADDMODULE);
	ps.setString(1, projectModuleDto.getModuleTitle());
	ps.setString(2, projectModuleDto.getModuleDescription());
	ps.setBlob(3,projectModuleDto.getModuleReferenceDocument());
	ps.setString(4, projectModuleDto.getDocumentNameWithExtension());
	
	if (projectModuleDto.getStartDate() != null){
		java.sql.Date startDate = new java.sql.Date(projectModuleDto.getStartDate().getTime());
	     ps.setDate(5, startDate);
	}
	 else
	ps.setDate(5, null);

	if (projectModuleDto.getEndDate() != null){
		java.sql.Date endDate = new java.sql.Date(projectModuleDto.getEndDate().getTime());
	   ps.setDate(6, endDate);
	}
	   else
		ps.setDate(6, null);
	
	
	ps.setInt(7, projectModuleDto.getProjectManagetProjectId().getProjectManagerProjectId());
	ps.setInt(8,IntegerConstants.DEFAULT_STATUSID);
	Integer status = ps.executeUpdate();
	System.out.println("succesfully added  "+status);
	return status;
	
}

/**
 * method is used for display all modules 
 * 					
 * 
 * @author pavan kumar y
 *
 */@SuppressWarnings("unchecked")

@Override
 public List<ProjectModuleDto> viewMOdules(Connection con,Integer ProjectManagerId) throws SQLException {	
	PreparedStatement pst=null;
	ResultSet rs=null;
	ProjectModuleDto pmdto=null;
	ProjectManagerProjectDto pmpdto=null;
	StatusDto sdto=null;
	UserDto udto=null;
	List<ProjectModuleDto> list=null;
	pst=con.prepareStatement(SQLQueryConstants.ViewAllModules);
	pst.setInt(1,ProjectManagerId);
	pst.setInt(2,IntegerConstants.REMOVE_STATUS);
	
	rs=pst.executeQuery();
	list=new ArrayList();
	if(rs!=null){
		while(rs.next()){
			//System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+"  "+rs.getString(5)+"  "+rs.getDate(6)+"  "+rs.getDate(7));
			pmdto=new ProjectModuleDto();
			pmpdto=new ProjectManagerProjectDto();
			sdto=new StatusDto();
			udto=new UserDto();
			pmdto.setProjectModuleId(rs.getInt(1));
			pmdto.setModuleTitle(rs.getString(2));
			pmdto.setModuleDescription(rs.getString(3));
			pmdto.setModuleReferenceDocument(rs.getBlob(4));
			pmdto.setDocumentNameWithExtension(rs.getString(5));
			pmdto.setStartDate(rs.getDate(6));
			pmdto.setEndDate(rs.getDate(7));
			pmpdto.setProjectManagerProjectId(rs.getInt(8));
			pmdto.setModuleCompletionPercent(rs.getFloat(10));
			sdto.setStatusId(rs.getInt(12));
			sdto.setStatus(rs.getString("status"));
			pmdto.setStatusId(sdto);
			list.add(pmdto);
			System.out.println("dashfg"+pmdto.getStatusId().getStatus());

		}
		logger.info("rs is not null");
		return list;
	}else
		logger.info("rs is null");
	return list;
}


 /**
	 * method is used for delete the module
	 * 
	 * @author sandip
	 *
	 */@Override
public Boolean deleteModule(Connection con,Integer projectModuleId) throws SQLException {
	PreparedStatement pst=null;
	
	pst=con.prepareStatement(SQLQueryConstants.DeleteModules);
	pst.setInt(1,projectModuleId);
	int status=pst.executeUpdate();
	if(status==0){
		con.commit();
		return false;

	}else{
		con.commit();
		return true;
	}
	 
}

	 /**
		 * method is used for get module refdoc by moduleid
		 * 			to set refdoc in edit module
		 * 
		 * @author sandip
		 *
		 */@Override
public ProjectModuleDto viewModuleById(Connection con, Integer moduleId) throws NoConnectionException {
	ProjectModuleDto pdto = null;
	StatusDto sdto = null;
PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		ps = con.prepareStatement(SQLQueryConstants.VIEW_MODULE_BY_ID);
		ps.setInt(1, moduleId);
		rs = ps.executeQuery();

		Boolean b =rs.next();
		
		if(b){
			
			logger.debug("VIEW MODULR RECORDAS EXIST");
		}else{
			logger.debug("VIEW MODULR RECORDAS DOES NOT EXIST");
				
		}
		// processing the results
		while (b) {
			// creating dto obj
			pdto = new ProjectModuleDto();
			sdto = new StatusDto();
				
			pdto.setProjectModuleId(rs.getInt(1));
			pdto.setModuleTitle(rs.getString(2));
			pdto.setModuleDescription(rs.getString(3));
			pdto.setModuleReferenceDocument(rs.getBlob(4));

			pdto.setStartDate(rs.getDate(6));
			pdto.setEndDate(rs.getDate(7));
			pdto.setModuleCompletionPercent((rs.getFloat(8)));
			pdto.setDocumentNameWithExtension(rs.getString(5));

			sdto.setStatusId(rs.getInt(10));
			sdto.setStatus(rs.getString(12));
			pdto.setStatusId(sdto);
			logger.info("view module by id");
			logger.info("getmodule:"+pdto.getModuleTitle());
			b =rs.next();
		}
		
		return pdto;

	} catch (SQLException e) {
		e.printStackTrace();
		throw new NoConnectionException();
	}
}

		 /**
			 * method is used for edit the module
			 * 
			 * @author sandip
			 *
			 */@Override
public Integer updateModule(ProjectModuleDto pdto, Connection con) throws NoConnectionException {
	Integer count = 0;
	try {
		PreparedStatement ps = null;
	ResultSet rs = null;
	
	if(pdto.getModuleReferenceDocument()!=null){
	
	
	
		ps = con.prepareStatement(SQLQueryConstants.EDIT_MODULE_DETAILS);
		ps.setString(1, pdto.getModuleTitle());
		ps.setString(2, pdto.getModuleDescription());
		ps.setBlob(3, pdto.getModuleReferenceDocument());
		ps.setDate(4, new Date(pdto.getStartDate().getTime()));
		ps.setDate(5, new Date(pdto.getEndDate().getTime()));
		ps.setDouble(6, pdto.getModuleCompletionPercent());
		ps.setString(7, pdto.getDocumentNameWithExtension());
		ps.setInt(8, pdto.getProjectModuleId());
		count = ps.executeUpdate();
		con.commit();
		
	}
	else{
		ps = con.prepareStatement(SQLQueryConstants.EDIT_MODULE_DETAILS_WITHOUT_DOC);
		ps.setString(1, pdto.getModuleTitle());
		ps.setString(2, pdto.getModuleDescription());
		ps.setDate(3, new Date(pdto.getStartDate().getTime()));
		ps.setDate(4, new Date(pdto.getEndDate().getTime()));
		ps.setDouble(5, pdto.getModuleCompletionPercent());
		ps.setInt(6, pdto.getProjectModuleId());
		count = ps.executeUpdate();
		con.commit();
		
		
	}	
		
		
		return count;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new NoConnectionException();
	}
}

/**
 * method is used for assign module to teamlead
 * 
 * @author Pavan kumar y
 * @param ProjectModuleDto
 *            the module to set
 * @param Connection
 *            the Connection to set
 * @return int value 0 for successful registration and 1 for registration
 *         failed
 * 
 * 			holding
 *            teamlead id and module id
 *
 */
@Override
public Integer assignTeamlead(ProjectModuleDto tmdto,Connection con) throws SQLException{
    PreparedStatement pst=null;
	pst=con.prepareStatement(SQLQueryConstants.ASSIGN_TEAMLEAD);
	pst.setInt(1,tmdto.getTeamLeadId().getUserId());
	pst.setInt(3,tmdto.getProjectModuleId());
	pst.setInt(2,IntegerConstants.Assign_DEFAULT_STATUSID);
	return pst.executeUpdate();
}

/**
 * method is used for display module info
 * 
 * @author pavan kumar y
 *
 */@Override
public  ModuleManagementFormBean viewModuleInfo(Connection con,Integer moduleId) throws SQLException, NoConnectionException{
    PreparedStatement pst=null;
	ModuleManagementFormBean mmfb=null;
	ProjectModuleDto pmdto=null;
	ProjectDto pdto=null;
	UserDto pmanagerdto=null;
	pst=con.prepareStatement(SQLQueryConstants.VIEW_MODULE_INFO);
	pst.setInt(1,moduleId);
	mmfb=new ModuleManagementFormBean();
	try{
ResultSet	 rs = pst.executeQuery();

	// processing the results
	while (rs.next()) {
		// creating dto obj
		pmdto = new ProjectModuleDto();
		pmdto.setModuleTitle(rs.getString("moduleTitle"));
		pmdto.setModuleDescription(rs.getString("moduleDescription"));

		
		pdto=new ProjectDto();
		pdto.setProjectTitle(rs.getString("projectTitle"));
		pdto.setProjectDescription(rs.getString("projectDescription"));
		pmanagerdto=new UserDto();
		pmanagerdto.setFirstName(rs.getString(43));
		pmanagerdto.setLastName(rs.getString(44));
		pmanagerdto.setImage(rs.getBlob(49));
		try {
			Blob b =pmanagerdto.getImage();
			if (b != null)
				mmfb.setPmimage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		pmanagerdto.setMobileNo(rs.getString(46));
		pmanagerdto.setEmail(rs.getString(45));
		mmfb.setFname(rs.getString(15));
		mmfb.setLname(rs.getString(16));
		try {
			Blob b = rs.getBlob(21);
			if (b != null)
				mmfb.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		mmfb.setUserid(rs.getInt(14));
		mmfb.setMobileNo(rs.getString(18));
		mmfb.setEmail(rs.getString(17));
		
		mmfb.setProjectDto(pdto);
		mmfb.setProjectModuleDto(pmdto);
		mmfb.setUserDto(pmanagerdto);
	}
	return mmfb;

   } catch (SQLException e) {
	e.printStackTrace();
	throw new NoConnectionException();
   }
 }	
 
 
 /**
 * to get project manager project id for add module
 * @author sandip
 */
   @Override
   public Integer getProjectManagerProjectId(Connection con, Integer ProjectManagerID,Integer projectId) throws SQLException
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps = con.prepareStatement(SQLQueryConstants.GET_PROJECTMANAGER_PROJECT_ID);
		ps.setInt(1, ProjectManagerID);
		ps.setInt(2,projectId);
		rs=ps.executeQuery();
		Integer projectmanagerprojectID=null;
		while(rs.next())
		{
			projectmanagerprojectID=rs.getInt(1);
		return projectmanagerprojectID;
		}
		return projectmanagerprojectID;
}



/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return list
 *@param Connection,userid
 */

@Override
public List<ProjectModuleDto> getModuleDetails(Connection con,int uid) throws SQLException {
PreparedStatement ps=null;
	List<ProjectModuleDto>list=new ArrayList<>();
	ps=con.prepareStatement(SQLQueryConstants.GET_MODULES);
	
	ps.setInt(1, IntegerConstants.TEAMLEADER_ROLE_ID);
	ps.setInt(2, uid);
ResultSet rs=ps.executeQuery();
while(rs.next()){
ProjectModuleDto pmdto=new ProjectModuleDto();
pmdto.setProjectModuleId(rs.getInt(1));
pmdto.setModuleTitle(rs.getString(2));
pmdto.setModuleDescription(rs.getString(3));
pmdto.setModuleReferenceDocument(rs.getBlob(4));
pmdto.setDocumentNameWithExtension(rs.getString(5));
pmdto.setStartDate(rs.getDate(6));
pmdto.setEndDate(rs.getDate(7));
UserDto udto=new UserDto();
udto.setUserId(rs.getInt(8));
pmdto.setTeamLeadId(udto);

list.add(pmdto);
}
return list;
}


/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ProjectModuleDto
 *@param Connection moduleid
 */

@Override
public ProjectModuleDto viewModuleById(Connection con, int moduleId) throws SQLException {
	PreparedStatement ps=null;
	ProjectModuleDto pdto = new ProjectModuleDto();
	ps=con.prepareStatement(SQLQueryConstants.GET_DOC);
	ps.setInt(1, moduleId);
	
	ResultSet rs = ps.executeQuery();
	
	while (rs.next()) {
		pdto.setDocumentNameWithExtension(rs.getString(2));
		pdto.setModuleReferenceDocument(rs.getBlob(1));
		
	}
	
	return pdto;
}


/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param{connection,moduleId}
 */

@Override
public ModuleBean getAllModuleDetails(Connection con, Integer mid) throws SQLException {
	PreparedStatement ps=null;
	ProjectModuleDto pmdto=new ProjectModuleDto();
 	ModuleBean mmfb=new ModuleBean();

	ps=con.prepareStatement(SQLQueryConstants.GET_ALL_DETAILS);
	ps.setInt(1, mid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	//	ProjectModuleDto pmdto=new ProjectModuleDto();
		pmdto.setProjectModuleId(rs.getInt(8));
		pmdto.setModuleTitle(rs.getString(9));
		pmdto.setModuleDescription(rs.getString(10));
		pmdto.setStartDate(rs.getDate(11));
		pmdto.setEndDate(rs.getDate(12));
		ProjectManagerProjectDto pmpdto=new ProjectManagerProjectDto();
     	pmdto.setProjectManagetProjectId(pmpdto);
     	UserDto udto=new UserDto();
     	udto.setUserId(rs.getInt(14));
     	udto.setFirstName(rs.getString(15));
     	udto.setLastName(rs.getString(16));
     	udto.setEmail(rs.getString(17));
     	udto.setMobileNo(rs.getString(18));
     	udto.setGender(rs.getString(20));
     	udto.setImage(rs.getBlob(19));
     	try {
			Blob b =udto.getImage();
			if (b != null)
				mmfb.setPmImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
     	
     	RoleDto rdto=new RoleDto();
     	rdto.setRoleId(rs.getInt(21));
     	UserDto usdto=new UserDto();
     	usdto.setUserId(rs.getInt(22));
     	usdto.setFirstName(rs.getString(23));
     	usdto.setLastName(rs.getString(24));
     	usdto.setEmail(rs.getString(25));
     	usdto.setMobileNo(rs.getString(26));
     	usdto.setGender(rs.getString(27));
     	usdto.setImage(rs.getBlob(28));
     		try {
			Blob b =usdto.getImage();
			if (b != null)
				mmfb.setTmImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		pmdto.setTeamLeadId(udto);
		pmpdto.setProjectManagerId(udto);
		ProjectDto pdto=new ProjectDto();
		pmpdto.setProjectId(pdto);
		pdto.setProjectId(rs.getInt(1));
		pdto.setProjectTitle(rs.getString(2));
		pdto.setProjectDescription(rs.getString(3));
		pdto.setExpectedStartDate(rs.getDate(4));
		pdto.setExpectedEndDate(rs.getDate(5));
		mmfb.setProjectModuleDto(pmdto);
	}
	return mmfb;
}

}
