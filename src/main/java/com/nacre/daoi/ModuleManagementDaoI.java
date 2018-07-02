/**
 * 
 */
package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.UserDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;
import com.nacre.dto.UserDto;
import com.nacre.formbean.ModuleBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface ModuleManagementDaoI { 

	/**
	 * It is used to get all modules  to assign or change teamlead 
	 * @author pavan kumar y
	 *
	 */
	public List<ProjectModuleDto> getModulesToAssignTL(Connection con,Integer projectManagerId) throws SQLException;
	/**
	 * It is used to get all team leads to assign modules 
	 * @author  pavankumar
	 *
	 */
	public List<UserDto> getTeamLeaderDetails(Connection con,Integer pmId) throws SQLException ;

	
	/**
	 * @author sandip
	 * @param con
	 * @param pDto
	 * @return
	 * @throws SQLException
	 */
	public Integer addModule(ProjectModuleDto projectModuleDto, Connection con) throws SQLException ;

	/**
	 * It is used to disply all modules
	 * @author pavan kumar y
	 *
	 */
	public List<ProjectModuleDto> viewMOdules(Connection con,Integer ProjectManagerId) throws SQLException ;

	/**
	 * It is used to delete module
	 * @author sandip
	 *
	 */	public Boolean deleteModule(Connection con,Integer projectModuleId) throws SQLException;

	
	 /**
		 * It is used to get module refdoc by moduleid
		 * 			to set refdoc in edit module
 
		 * @author sandip
		 *
		 */	
	 public ProjectModuleDto viewModuleById(Connection con, Integer projectId) throws NoConnectionException;

	 /**
		 * It is used to updatemodule
		 * @author sandip
		 *
		 */
	public Integer updateModule(ProjectModuleDto pdto, Connection con) throws NoConnectionException;

	/**
	 * It is used to assign teamlead to module 
	 * @author pavan kumar y
	 *
	 */
	Integer assignTeamlead(ProjectModuleDto tmdto, Connection con) throws SQLException;

	
	/**
	 * It is used to disply moduleInfo
	 * @author pavan kumar y
	 *
	 */
	ModuleManagementFormBean viewModuleInfo(Connection con,Integer moduleId) throws SQLException, NoConnectionException;
	 /**
	 * to get projectmanagerprojectId for add module
	 * @author sandip
	 *
	 */
	Integer getProjectManagerProjectId(Connection con, Integer ProjectManagerID,Integer projectId) throws SQLException;

	
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param connection,userid
	 */
	public List<ProjectModuleDto> getModuleDetails(Connection con,int id) throws SQLException;
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param{connection,projeectmoduleId}
	 */

	public ProjectModuleDto viewModuleById(Connection con, int pid) throws SQLException;
	/**
	 * @author sindhusha M B
	 *@throws SQLEception
	 *@return ModuleBean
	 *@param{connection,projectmoduleidId}
	 */

	public ModuleBean getAllModuleDetails(Connection con,Integer mid) throws SQLException;
}
