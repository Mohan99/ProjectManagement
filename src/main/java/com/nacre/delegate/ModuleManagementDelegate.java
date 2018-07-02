/**
 * 
 */
package com.nacre.delegate;

import java.sql.Connection;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleBean;
import com.nacre.formbean.ModuleManagementFormBean;
import com.nacre.servicei.ModuleManagementServiceI;
import com.nacre.servicei.serviceimpl.ModuleManagementServiceImpl;
import com.nacre.uitl.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ModuleManagementDelegate {

public static final Logger logger = 	Logger.getLogger(ModuleManagementDelegate.class);
/**
 * @author pavan kumar y 
 *  this method is used for get modules to asign or change teamlead
 * @throws NoConnectionException 
 * @throws SQLException 
 */
 public List<ModuleManagementFormBean> getModulesToAssignTL(Integer projectManagerId) throws SQLException, NoConnectionException {
    List<ModuleManagementFormBean> listbean=null;
	List<ProjectModuleDto>  ulist=null;
	
	ModuleManagementFormBean bean=null;
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
    ulist=mms.getModulesToAssignTL(projectManagerId);
    listbean=new ArrayList<>();
	for (ProjectModuleDto dto : ulist) {
		bean=new ModuleManagementFormBean();
		bean.setName(dto.getTeamLeadId().getFirstName());
		bean.setEmail(dto.getTeamLeadId().getEmail());
		bean.setUserid(dto.getTeamLeadId().getUserId());
		bean.setMobileNo(dto.getTeamLeadId().getMobileNo());
		bean.setProjectModuleDto(dto);
		try {
			Blob b = dto.getTeamLeadId().getImage();
			if (b != null)
				bean.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		listbean.add(bean);

	}
	return listbean;
}

 /**
  * @author pavan kumar y 
  *  this method is used for get team leads to assign modules
  * @throws NoConnectionException 
  * @throws SQLException 
  */public List<ModuleManagementFormBean> getTeamLeaderDetails(Integer pmId) throws SQLException, NoConnectionException {
    ModuleManagementFormBean bean=null;
    List<ModuleManagementFormBean> listbean=null;
	List<UserDto>  ulist=null;

	ModuleManagementServiceI mms = new ModuleManagementServiceImpl();
	ulist=mms.getTeamLeaderDetails(pmId);
	listbean=new ArrayList<>();
	for (UserDto dto : ulist) {
		bean=new ModuleManagementFormBean();
		bean.setName(dto.getFirstName());
		bean.setEmail(dto.getEmail());
		bean.setUserid(dto.getUserId());
		bean.setMobileNo(dto.getMobileNo());
		try {
			Blob b = dto.getImage();
			if (b != null)
				bean.setImage(ImageUtil.encodeImage(b.getBinaryStream()));
		} catch (ImageStreamToByteException e) {
			e.printStackTrace();
		}
		listbean.add(bean);

	}
	return listbean;
	
}


  /**
   * @author sandip
   *  this method is used for add module
   * @throws NoConnectionException 
   * @throws SQLException 
   */public Integer addModule(ProjectModuleDto projectModuleDto)
		throws ClassNotFoundException, SQLException, NoConnectionException {

	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();

	return mms.addModule(projectModuleDto);

}

   /**
    * @author pavan kumar y 
    *  this method is used for display all modules
    * @throws NoConnectionException 
    * @throws SQLException 
    */public List<ProjectModuleDto> viewMOdules(Integer ProjectManagerId) throws SQLException, NoConnectionException {
    ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	List<ProjectModuleDto> plist = mms.viewMOdules(ProjectManagerId);
	for(ProjectModuleDto pmdto:plist){
		System.out.println("dhf"+pmdto.getModuleCompletionPercent());
	}
    return plist;
}


    /**
     * @author sandip
     *  this method is used for get module refdoc to set refdoc in edit module
     * @throws NoConnectionException 
     * @throws SQLException 
     */
public ProjectModuleDto viewModuleById(Integer projectId) throws NoConnectionException, SQLException {
	ProjectModuleDto pdto=null;
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();

	try {
		pdto=mms.viewModuleById(projectId);
		
		return pdto;
	} catch (NoConnectionException e) {
		e.printStackTrace();
		throw new NoConnectionException();
	}
}
/**
 * @author sandip
 *  this method is used for delete module
 * @throws NoConnectionException 
 * @throws SQLException 
 */public Boolean deleteModule(Integer projectModuleId) throws NoConnectionException, SQLException {
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	return mms.deleteModule(projectModuleId);
}


 /**
  * @author sandip
  *  this method is used for edit module
  * @throws NoConnectionException 
  * @throws SQLException 
  */
public boolean updateModule(ProjectModuleDto pdto) throws NoConnectionException, SQLException {
	boolean flag;
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	try {
		flag=mms.updateModule(pdto);
		
	} catch (NoConnectionException e) {
		e.printStackTrace();
		throw new NoConnectionException();
	}
	return flag;
}

/**
 * @author pavan kumar y 
 *  this method is used for assign module to teamlead
 * @throws NoConnectionException 
 * @throws SQLException 
 */public Integer assignTeamlead(ProjectModuleDto pmdto) throws NoConnectionException, SQLException {
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	return mms.assignTeamlead(pmdto);
}


 /**
  * @author pavan kumar y 
  *  this method is used for disply module info
  * @throws NoConnectionException 
  * @throws SQLException 
  */public ModuleManagementFormBean viewModuleInfo(Integer moduleId) throws SQLException, NoConnectionException {
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	ModuleManagementFormBean bean=null;
	bean=mms.viewModuleInfo(moduleId);
	return bean;
}
  
  /**
   * to get project manager project id for add module
   * @author sandip
  * @throws NoConnectionException 
   */
   
public Integer getProjectManagerProjectId(Integer ProjectManagerID,Integer projectId) throws SQLException, NoConnectionException{
	ModuleManagementServiceImpl mms = new ModuleManagementServiceImpl();
	Integer pmpId=mms.getProjectManagerProjectId(ProjectManagerID,projectId);
   return pmpId;
}




/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param userid
 */
public List<ProjectModuleDto> getModuleDetails(int uid) throws NoConnectionException, SQLException  {
	ModuleManagementServiceI mservice=null;
	mservice= new ModuleManagementServiceImpl();
	return mservice.getModuleDetails(uid);
}



/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param projectmoduleid
 */
public ProjectModuleDto viewModuleById(int pid) throws NoConnectionException, SQLException{
ModuleManagementServiceI mservice=null;
mservice= new ModuleManagementServiceImpl();
return mservice.viewModuleById(pid);

}
/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param projectmoduleid
 */
public ModuleBean getAllModuleDetails(Integer mid) throws NoConnectionException, SQLException{
	ModuleManagementServiceI mservice=null;
	mservice= new ModuleManagementServiceImpl();
ProjectModuleDto dto=new ProjectModuleDto();
ModuleBean bean = null;

bean =mservice.getAllModuleDetails(mid);
		
	
		return bean;
}
}


