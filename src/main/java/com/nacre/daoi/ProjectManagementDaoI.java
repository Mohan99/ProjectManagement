/**
 * 
 */
package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import com.nacre.dto.ProjectDto;
import java.util.List;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.AddressDto;
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectInfoBeanMohan;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface ProjectManagementDaoI {
	/*
	public List<ProjectManagerProjectDto> getProjects();
	public ProjectDto getProjectCompletePercentage(int x);*/
	/**
	 * @author Kunal394
	 * @param con
	 * @param pDto
	 * @return
	 * @throws SQLException
	 */
	public int addProject(Connection con, ProjectDto pDto) throws SQLException;

	/**
	 * It is used to assign project to project manager 
	 * @author kunal
	 *
	 */
	
	public int assignProjectToPM(Connection con, ProjectManagerProjectDto pmDto) throws SQLException;

	/**
	 * It is used to display not assigned project 
	 * @author kunal
	 *
	 */
	
	public List<ProjectDto> displayNotAssignedProject(Connection con) throws SQLException;
	

	/**
	 * It is used to display not assigned project according to search
	 * @author kunal
	 *
	 */
	
	public List<ProjectDto> displayNotAssignedProject(Connection con,String search) throws SQLException;

	
	/**
	 * It is used to display project manager
	 * @author kunal
	 *
	 */
	
	public List<UserDto> displayProjectManager(Connection con) throws SQLException;
	
	/**
	 * It is used to display project manager according to search
	 * @author kunal
	 *
	 */
	
	public List<UserDto> displayProjectManager(Connection con,String search) throws SQLException;


	/**
	 * It is used to get all Client Information
	 * @author kunal
	 *
	 */

	public List<ClientLocationDto> getAllClient(Connection con) throws SQLException;

	/**
	 * It is used to add multiple client contact person
	 * @author kunal
	 *
	 */
	
	public int[] addClientContactPesrson(Connection con,List<ClientContactPerson> list) throws SQLException;
	
	/**
	 * It is used to add client Location
	 * @author kunal
	 *
	 */
	
	public int addClientLocation(Connection con, ClientLocationDto dto) throws SQLException;
	
	/**
	 * It is used to add client address
	 * @author kunal
	 *
	 */

	public int addClientAddress(Connection con, AddressDto dto) throws SQLException;

	/**
	 * It is used to add client Information
	 * @author kunal
	 *
	 */

	public int addClient(Connection con, ClientDto dto) throws SQLException;
	

	/**
	 * It is used to get all Client Information According to search condition
	 * @author kunal
	 *
	 */


	public List<ClientLocationDto> getAllClient(Connection con, String search) throws SQLException;


	/**
	 * @author Raghav this method is to get the All Project
	 * 
	 */
	public List<ProjectDto> viewAllProjects(Connection con) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to get the Project by ProjectId
	 * 
	 */
	public ProjectDto viewProjectsById(Connection con,Integer projectId) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to Update the Project details
	 * 
	 */
	public int updateProject(ProjectDto pdto,Integer projectId,Connection con) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to Remove the Project
	 * 
	 */
	public int removeProject(Integer projectId,Connection con) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to get the Cliet Locations
	 * 
	 */
	public ClientLocationDto getClientLocatin(Connection con,String address) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to get the Project by ProjectId
	 * 
	 */
	public ProjectInfoBeanMohan viewProjectInfoById(Connection con,Integer projectId) throws NoConnectionException;
	
	

	/**
	 * it takes the id of the ClientContactPerson and delete
	 *      ClientContactPerson details in database and returns integer value
	 *      given by database
	 * @author N.Sravanthi 
	 * @param con
	 *            accepts a sql connection
	 *  @param id accepts ContactPersonId in the form of
	 *         integer
	 * @return integer number given by database
	 * 
	
	 * @throws SQLException
	 */

	public Integer deleteClientContactPerson(Connection con, Integer id) throws SQLException;

	/**
	 * it returns all ClientDetails in the form of List
	 * @return client details in the form of list
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 *  
	
	 * @throws SQLException
	 */
	public List<ClientDto> viewAllClient(Connection con) throws SQLException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 * @param id
	 *            accepts clientId in the form of integer
	 * @return client details in the form of list
	 * 
	
	 * @throws SQLException
	 * 
	 */
	public List viewClientId(Connection con, Integer id) throws SQLException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      Client name or ClientContactPersonName
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 * @param name
	 *            accepts clientName or contactPersonName in the form of string
	 * @return client details in the form of list
	 * 
	
	 * @throws SQLException
	 */

	public List viewClientName(Connection con, String name) throws SQLException;

	/**
	 * it returns all ClientDetails in the form of List based on the given
	 *      ClientContactPersonName mobileNumber
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 * @param Mobileno
	 *            accepts contactPersonName mobileNumber in the form of string
	 * @return client details in the form of list
	 * 
	
	 * @throws SQLException
	 */

	public List viewClientMobileNo(Connection con, String Mobileno) throws SQLException;

	/**
	 * 
	 * it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @author N.Sravanthi
	 *  @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts client Details in the form of ClientDto
	 * @return integer number given by database
	 * 
	
	 * @throws SQLException
	 */
	public Integer editClient(Connection con, ClientDto dto) throws SQLException;

	/**
	 *  it takes the ClientContactPerson object and modifies update the
	 *      ClientContactPerson details and returns integer value given by
	 *      database
	 * @author N.Sravanthi
	 *  @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts ContactPerson Details in the form of
	 *            ClientContactPersonDto
	 * @return integer number given by database
	 *
	
	 * @throws SQLException
	 */
	public Integer editClientContactPerson(Connection con, ClientContactPerson dto) throws SQLException;

	/**
	 * it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @author N.Sravanthi
	 *  @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts client Details in the form of ClientDto
	 * @return integer number given by database
	 * 
	 * @throws SQLException
	 */

	public Integer editClientLogo(Connection con, ClientDto dto) throws SQLException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 *      
	 * @author N.Sravanthi
	 *  @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts ClientDto object having clientId 
	 * @return location details in the form of list
	 * it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 *
	 * @throws SQLException
	 * 
	 */
	List<ClientLocationDto> viewClientLocation(Connection con, ClientDto dto) throws SQLException;
	
	
	/**
	 * it returns all ClientContactPersonDetails in the form of List based on the given
	 *    ContactPersonLocationId
	 * @author N.Sravanthi
	 *  @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts  location id in the form of ClientLocationDto
	 * @return ClientContactPerson details in the form of list
	 *
	 *
	 * @throws SQLException
	 * 
	 */
	List<ClientContactPerson> getClientContactPerson(Connection con, ClientLocationDto dto) throws SQLException;	
	
	
	/**
	 * It is used to add one client contact person
	 * @author N.Sravanthi
	 *
	 */
	
	public int addClientContactPesrson(Connection con,ClientContactPerson list) throws SQLException;
	
	/**
	 * @author Raghav
	 * @throws SQLException 
	 *
	 */
	public List<ProjectDto> viewProjectsByManager(Connection con,int managerId) throws SQLException;
	
	
	

}
