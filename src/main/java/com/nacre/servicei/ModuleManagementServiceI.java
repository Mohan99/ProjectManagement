/**
 * 
 */
package com.nacre.servicei;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleBean;

import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface ModuleManagementServiceI {
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param userid
	 */
	public List<ProjectModuleDto> getModuleDetails(int uid) throws NoConnectionException, SQLException;
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param projectmoduleid
	 */
	public ProjectModuleDto viewModuleById(int pid) throws NoConnectionException, SQLException;
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param id
	 */
	public ModuleBean getAllModuleDetails(Integer mid) throws NoConnectionException, SQLException;
	/**
	 * It get the all modules to assign or change team lead
	 * @author pavan kumar y
	 *
	 */
	public List<ProjectModuleDto> getModulesToAssignTL(Integer projectManagerId) throws SQLException, NoConnectionException;

	/**
	 * It get the  all team leads to assign module
	 * @author pavan kumar y
	 *
	 */
	public List<UserDto> getTeamLeaderDetails(Integer pmId) throws SQLException, NoConnectionException ;
	/**
	 * It get the  add module
	 * @author sandip
	 *
	 */
	public Integer addModule(ProjectModuleDto projectModuleDto) throws ClassNotFoundException, SQLException, NoConnectionException;
	/**
	 * It get the  display all modules
	 * @author pavan kumar y
	 *
	 */
	public List<ProjectModuleDto> viewMOdules(Integer ProjectManagerId) throws SQLException, NoConnectionException;

	/**
	 * It delete module
	 * @author sandip
	 *
	 */
	public Boolean deleteModule(Integer projectModuleId) throws NoConnectionException, SQLException;

	/**
	 * It used to get the  module refdoc to set refdoc in edit
	 *               module
	 * @author sandip
	 * @throws SQLException 
	 *
	 */
	ProjectModuleDto viewModuleById(Integer projectId) throws NoConnectionException, SQLException;

	/**
	 * It is used to edit the module
	 * @author sandip
	 * @throws SQLException 
	 *
	 */	boolean updateModule(ProjectModuleDto pdto) throws NoConnectionException, SQLException;

	
	 /**
		 * It assign team lead to the module
		 * @author pavan kumar y
		 *
		 */	
	 Integer assignTeamlead(ProjectModuleDto pmdto) throws NoConnectionException, SQLException;

	 /**
		 * It get the module info
		 * @author pavan kumar y
		 *
		 */	
	 ModuleManagementFormBean viewModuleInfo(Integer moduleId) throws SQLException, NoConnectionException;
	 /**
      * to get project manager project id for add module
      * @author sandip
	 * @throws NoConnectionException 
      */
	Integer getProjectManagerProjectId(Integer ProjectManagerID,Integer projectId) throws SQLException, NoConnectionException;


}
