/**
 * 
 */
package com.nacre.servicei;

import java.sql.SQLException;
import java.util.List;

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
public interface ProjectManagementServiceI {
	/**
	 * It get the  list of project that are not assigned
	 * @author kunal
	 *
	 */
	
	public List<ProjectDto> displayNotAssignedProject() throws SQLException, NoConnectionException;

	/**
	 * It get the  list of projectManager 
	 * @author kunal
	 *
	 */

	public List<UserDto> displayProjectManager() throws SQLException, NoConnectionException;
	
	/**
	 * It get the  list of project that are not assigned according to search
	 * @author kunal
	 *
	 */
	
	public List<ProjectDto> displayNotAssignedProject(String search) throws SQLException, NoConnectionException;

	/**
	 * It get the  list of projectManager according to search
	 * @author kunal
	 *
	 */

	public List<UserDto> displayProjectManager(String search) throws SQLException, NoConnectionException;

	
	/**
	 * It assign the project to Project manager
	 * @author kunal
	 *
	 */

	public String assignProjectToPM(ProjectManagerProjectDto pmDto) throws SQLException, NoConnectionException;
	
	/**
	 * It used to add project
	 * @author kunal
	 *
	 */

	public boolean addProject(ProjectDto pDto) throws SQLException, NoConnectionException;
	
	/**
	 * It is used to add client
	 * @author kunal
	 *
	 */

	public boolean addClient(List<ClientContactPerson> list) throws SQLException, NoConnectionException;

	/**
	 * It is used to get all Client Information
	 * @author kunal
	 *
	 */

	public List<ClientLocationDto> getAllClient() throws SQLException, NoConnectionException;

	
	/**
	 * It is used to get all Client Information according to search condition
	 * @author kunal
	 *
	 */
	
	public List<ClientLocationDto> getAllClient(String search)throws SQLException, NoConnectionException;

	
	/**
	 * @author Raghav this method is to get the All Project
	 * @throws SQLException 
	 * 
	 */
	public List<ProjectDto> viewAllProjects() throws NoConnectionException, SQLException;
	
	/**
	 * @author Raghav this method is to get the Project by ProjectId
	 * @throws SQLException 
	 * 
	 */
	public ProjectDto viewProjectById(Integer projectId) throws NoConnectionException, SQLException;
	
	/**
	 * @author Raghav this method is to Update the Project details
	 * @throws SQLException 
	 * 
	 */
	public boolean updateProject(int projectId,ProjectDto pdto) throws NoConnectionException, SQLException;
	
	/**
	 * @author Raghav this method is to Remove the Project
	 * @throws SQLException 
	 * 
	 */
	public boolean deleteProject(int projectId) throws NoConnectionException, SQLException;
	/**
	 * @author Raghav this method is to get client LocationId
	 * 
	 */
	
	public int getClientLocationId(String address) throws NoConnectionException;
	
	/**
	 * @author Raghav this method is to get the Project Info by ProjectId
	 * @throws SQLException 
	 * 
	 */
	public ProjectInfoBeanMohan viewProjectInfoById(Integer projectId) throws NoConnectionException, SQLException;
	/**
	 * 
	 * Return All  Client Details available in database in the form of list
	 * 
	 * @return client details in the form of list
	 * @author N.Sravanthi
	 * @use it returns all ClientDetails in the form of List
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public List<ClientDto> viewAllClient() throws SQLException, NoConnectionException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      Client name or ClientContactPersonName
	 * @author N.Sravanthi
	 * @param name
	 *            accepts clientName or contactPersonName in the form of string
	 * @return client details in the form of list
	 * 
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public List viewClientName(String name) throws SQLException, NoConnectionException;

	/**
	 * it returns all ClientDetails in the form of List based on the given
	 *      ClientContactPersonName mobileNumber
	 * @author N.Sravanthi
	 * @param Mobileno
	 *            accepts contactPersonName mobileNumber in the form of string
	 * @return client details in the form of list
	 *
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public List viewClientMobileNo(String Mobileno) throws SQLException, NoConnectionException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 * @author N.Sravanthi
	 * @param id
	 *            accepts clientId in the form of integer
	 * @return client details in the form of list
	 * 
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */
	public List viewClientId(Integer id) throws SQLException, NoConnectionException;

	/**
	 *  it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts client Details in the form of ClientDto
	 * @return integer number given by database
	 *
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer editClient(ClientDto dto) throws SQLException, NoConnectionException;
	
	/**
	 * it takes the ClientContactPerson object and adds the
	 *      ClientContactPerson details and returns integer value given by
	 *      database
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ContactPerson Details in the form of
	 *            ClientContactPersonDto
	 * @return integer number given by database
	 * 
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer addContactPerson(ClientContactPerson dto) throws SQLException, NoConnectionException;

	
	

	/**
	 * it takes the ClientContactPerson object and modifies update the
	 *      ClientContactPerson details and returns integer value given by
	 *      database
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ContactPerson Details in the form of
	 *            ClientContactPersonDto
	 * @return integer number given by database
	 * 
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer editContactPerson(ClientContactPerson dto) throws SQLException, NoConnectionException;

	/**
	 *  it takes the id of the ClientContactPerson and delete
	 *      ClientContactPerson details in database and returns integer value
	 *      given by database
	 * @author N.Sravanthi 
	 * @param id accepts ContactPersonId in the form of
	 *         integer
	 * @return integer number given by database
	 * 
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer deleteContactPerson(Integer id) throws SQLException, NoConnectionException;

	/**
	 *  it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ClientDto object having logo
	 * @return integer number given by database
	 
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer editClientLogo(ClientDto dto) throws SQLException, NoConnectionException;

	/**
	 *  it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ClientDto object having clientId 
	 * @return location details in the form of list
	 * it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */
	
public	List viewClientLocation(ClientDto dto) throws SQLException, NoConnectionException;
	
	/**
	 * it returns all ClientContactPersonDetails in the form of List based on the given
	 *    ContactPersonLocationId
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts  location id in the form of ClientLocationDto
	 * @return ClientContactPerson details in the form of list
	 *
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */
	
	public List<ClientContactPerson> getClientContactPerson(ClientLocationDto dto) throws NoConnectionException, SQLException; 

	/*
	 * @author Raghav
	 */
	public List<ProjectDto> viewProjectByManager(int managerId) throws NoConnectionException, SQLException;

	
	
}
