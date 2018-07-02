/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.StringConstants;
import com.nacre.daoi.ProjectManagementDaoI;
import com.nacre.daoi.daoimpl.ProjectManagementDaoImpl;
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectInfoBeanMohan;
import com.nacre.servicei.ProjectManagementServiceI;
import com.nacre.uitl.PooledConnection;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectManagementServiceImpl implements ProjectManagementServiceI {
	
	ProjectManagementDaoI projectDao = null;

	public static final Logger logger = Logger.getLogger(ProjectManagementServiceImpl.class);

	/**
	 * method is used for display not assigned project 
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<ProjectDto> displayNotAssignedProject() throws SQLException, NoConnectionException {
		List<ProjectDto> list = null;
		Connection con = null;
		con = PooledConnection.getConnection();

		ProjectManagementDaoI dao = null;

		// create Connection
	
		dao = new ProjectManagementDaoImpl();
		list = dao.displayNotAssignedProject(con);

		if (con != null)
			con.close();
		return list;
	}

	/**
	 * method is used for display not assigned project according to search condition
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<ProjectDto> displayNotAssignedProject(String search) throws SQLException, NoConnectionException {
		List<ProjectDto> list = null;
		Connection con = null;
		ProjectManagementDaoI dao = null;

		// create Connection
		con = PooledConnection.getConnection();

		dao = new ProjectManagementDaoImpl();
		list = dao.displayNotAssignedProject(con,search);

		if (con != null)
			con.close();
		return list;
	}


	
	/**
	 * method is used display project manager information
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<UserDto> displayProjectManager() throws SQLException, NoConnectionException {
		List<UserDto> list = null;
		Connection con = null;
		ProjectManagementDaoI dao = null;

		// create Connection
		con = PooledConnection.getConnection();

		dao = new ProjectManagementDaoImpl();
		list = dao.displayProjectManager(con);

		if (con != null)
			con.close();
		return list;
	}
	
	/**
	 * method is used display project manager information according to search
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<UserDto> displayProjectManager(String search) throws SQLException, NoConnectionException {
		List<UserDto> list = null;
		Connection con = null;
		ProjectManagementDaoI dao = null;

		// create Connection
		con = PooledConnection.getConnection();

		dao = new ProjectManagementDaoImpl();
		list = dao.displayProjectManager(con,search);

		if (con != null)
			con.close();
		return list;
	}


	/**
	 * method is used for add project
	 * 
	 * @author Kunal Marathe
	 * @param
	 * 
	 * 			holding
	 *            project info
	 *
	 */

	@Override
	public boolean addProject(ProjectDto pDto) throws SQLException, NoConnectionException {
		Connection con = null;
		int count = 0;
		// create Connection
		con = PooledConnection.getConnection();

		count = new ProjectManagementDaoImpl().addProject(con, pDto);


		if (count == 0) {
			con.rollback();
			if (con != null) {
				con.close();
			}
			return true;
		} else {
			con.commit();
			if (con != null) {
				con.close();
			}
			return false;
		}
		
		

	}

	/**
	 * method is used for assign project to project manager
	 * 
	 * @author Kunal Marathe
	 * @param
	 * 
	 * 			holding
	 *            manager id and client location id
	 *
	 */

	@Override
	public String assignProjectToPM(ProjectManagerProjectDto pmDto) throws SQLException, NoConnectionException {
		Connection con = null;
		String msg = null;
		int count = 0;
		// create Connection
		con = PooledConnection.getConnection();

		count = new ProjectManagementDaoImpl().assignProjectToPM(con, pmDto);

		if (count == 0) {
			msg = StringConstants.PROJECT_NOT_ASSIGNED_PROJECTMANAGER;
			con.rollback();
		} else {
			msg = StringConstants.PROJECT_ASSIGNED_PROJECTMANAGER;
			con.commit();
		}

		if (con != null) {
			con.close();
		}
		return msg;
	}

	/**
	 * method is used add Client information and its multiple contact person
	 * 
	 * @author Kunal Marathe
	 * @param
	 *
	 */

	@Override
	public boolean addClient(List<ClientContactPerson> list) throws SQLException, NoConnectionException {
		Connection con = null;
		int clientId = 0;
		int clientAddressId = 0;
		int clientLocationId = 0;
		int[] count = null;
		boolean flag = true;
		ProjectManagementDaoImpl dao = null;
		// create Connection
		con = PooledConnection.getConnection();

		dao = new ProjectManagementDaoImpl();

		ClientContactPerson dto = list.get(0);

		// get client id
		clientId = dao.addClient(con, dto.getClientLocationId().getClientId());

		if (clientId != 0) {
			dto.getClientLocationId().getClientId().setClientId(clientId);

			// get Client AddressId
			clientAddressId = dao.addClientAddress(con, dto.getClientLocationId().getAddressId());
			if (clientAddressId != 0) {
				dto.getClientLocationId().getAddressId().setAddressId(clientAddressId);

				// get Client LocationId
				clientLocationId = dao.addClientLocation(con, dto.getClientLocationId());

				if (clientLocationId != 0) {
					dto.getClientLocationId().setClientLocationId(clientLocationId);
					if (clientLocationId != 0) {
						dto.getClientLocationId().setClientLocationId(clientLocationId);
						count = dao.addClientContactPesrson(con, list);
						for (int i = 0; i < count.length; i++) {
							if (count[i] == 0) {
								flag = false;
								break;
							}
						}
						if (flag) {
							con.commit();
						}
					}
				}
			}
		}

		if (con != null) {
			con.close();
		}
		if (!flag) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * method is used to get Client information
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<ClientLocationDto> getAllClient() throws SQLException, NoConnectionException {
		Connection con = null;
		// create Connection
		con = PooledConnection.getConnection();

		List<ClientLocationDto> list = new ProjectManagementDaoImpl().getAllClient(con);
		if (con != null) {
			con.close();
		}
	return list;
	}
	
	/**
	 * It is used to get all Client Information according to search condition
	 * @author kunal
	 *
	 */
	


	@Override
	public List<ClientLocationDto> getAllClient(String search)throws SQLException, NoConnectionException {
		Connection con = null;
		// create Connection
		con = PooledConnection.getConnection();

		List<ClientLocationDto> list =  new ProjectManagementDaoImpl().getAllClient(con,search);
		if (con != null) {
			con.close();
		}
	return list;
	}

	public ProjectManagementServiceImpl()  {
		projectDao = new ProjectManagementDaoImpl();
	}

	/**
	 * @author Raghav this method is to get the All Project
	 * @throws SQLException 
	 * 
	 */
	@Override
	public List<ProjectDto> viewAllProjects() throws NoConnectionException, SQLException {
		List<ProjectDto> project = null;

		Connection con = null;
		try {
			con = PooledConnection.getConnection();

			project = projectDao.viewAllProjects(con);

			return project;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
		finally{
			if(con!=null)
				con.close();
		}
	}

	/**
	 * @author Raghav this method is to get the Project by ProjectId
	 * @throws SQLException 
	 * 
	 */
	@Override
	public ProjectDto viewProjectById(Integer projectId) throws NoConnectionException, SQLException {
		ProjectDto pdto = null;

		Connection con = null;		
		try {
            con=PooledConnection.getConnection();
			pdto = projectDao.viewProjectsById(con, projectId);

			return pdto;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
		finally{
			if(con!=null)
				con.close();
		}
	}

	/**
	 * @author Raghav this method is to update the Project
	 * @throws SQLException 
	 * 
	 */
	@Override
	public boolean updateProject(int projectId, ProjectDto pdto) throws NoConnectionException, SQLException {
		boolean flag;
		int count = 0;

		Connection con = null;
		try {
			con=PooledConnection.getConnection();
			count = projectDao.updateProject(pdto, projectId, con);
			if (count == 0)
				flag = false;
			else
				flag = true;
			return flag;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
		finally{
			if(con!=null)
				con.close();
		}
	}

	/**
	 * @author Raghav this method is to get Remove the Project
	 * @throws SQLException 
	 * 
	 */
	@Override
	public boolean deleteProject(int projectId) throws NoConnectionException, SQLException {
		boolean flag;
		int count = 0;
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			count = projectDao.removeProject(projectId, con);
			if (count == 0)
				flag = false;
			else
				flag = true;
			return flag;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
		finally{
			if(con!=null)
				con.close();
		}
	}

	/**
	 * @author Raghav this method is to get the Client Location
	 * 
	 */
	@Override
	public int getClientLocationId(String address) throws NoConnectionException {
		ClientLocationDto cldto = null;
		int locationId = 0;

		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			cldto = projectDao.getClientLocatin(con, address);
			locationId = cldto.getClientLocationId();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return locationId;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	@Override
	public ProjectInfoBeanMohan viewProjectInfoById(Integer projectId) throws NoConnectionException, SQLException {
		ProjectInfoBeanMohan bean = null;
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			bean = projectDao.viewProjectInfoById(con, projectId);

			return bean;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
		finally{
			if(con!=null)
				con.close();
		}
	}

	/**
	 * @return client details in the form of list
	 * @author N.Sravanthi
	 * @use it returns all ClientDetails in the form of List
	 * @throws NoConnectionException
	 * @throws SQLException
	 */

	public List<ClientDto> viewAllClient() throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
	Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		List<ClientDto> details = dao.viewAllClient(con);
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return details;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param id
	 *            accepts clientId in the form of integer
	 * @return client details in the form of list
	 * @use it returns all ClientDetails in the form of List based on the given
	 *      ClientId
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */
	public List viewClientId(Integer id) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
	Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		List l = dao.viewClientId(con, id);
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param name
	 *            accepts clientName or contactPersonName in the form of string
	 * @return client details in the form of list
	 * @use it returns all ClientDetails in the form of List based on the given
	 *      Client name or ClientContactPersonName
	 * @throws NoConnectionException
	 * @throws SQLException
	 */

	public List viewClientName(String name) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		List l = dao.viewClientName(con, name);
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param Mobileno
	 *            accepts contactPersonName mobileNumber in the form of string
	 * @return client details in the form of list
	 * @use it returns all ClientDetails in the form of List based on the given
	 *      ClientContactPersonName mobileNumber
	 * @throws NoConnectionException
	 * @throws SQLException
	 */

	public List viewClientMobileNo(String Mobileno) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
		Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		List l = dao.viewClientMobileNo(con, Mobileno);
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts client Details in the form of ClientDto
	 * @return integer number given by database
	 * @use it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	@Override
	public Integer editClient(ClientDto dto) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
		Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		Integer count = dao.editClient(con, dto);
		// if client details is updated in database then it commit the result
		if (count != 0) {
			con.commit();
		}
		// if client details is not updated in database then it rollback the
		// result
		else {
			con.rollback();
		}
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts client Details in the form of ClientDto
	 * @return integer number given by database
	 * @use it takes the clientDto object and modifies update the client details
	 *      and returns integer value given by database
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	@Override
	public Integer editClientLogo(ClientDto dto) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
		Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		Integer count = dao.editClientLogo(con, dto);

		// if Client logo is updated in database then it commit the result
		if (count != 0) {
			con.commit();
		}
		// if client logo is not updated in database then it rollback the result
		else {
			con.rollback();
		}
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ContactPerson Details in the form of
	 *            ClientContactPersonDto
	 * @return integer number given by database
	 * @use it takes the ClientContactPerson object and modifies update the
	 *      ClientContactPerson details and returns integer value given by
	 *      database
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	@Override
	public Integer editContactPerson(ClientContactPerson dto) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
	Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		Integer count = dao.editClientContactPerson(con, dto);

		// if ClientContactPerson is updated in database then it commit the
		// result
		if (count != 0) {
			con.commit();
		}
		// if ClientContactPerson is not updated in database then it rollback
		// the result
		else {
			con.rollback();
		}
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		// returns the result
		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi * @param id accepts ContactPersonId in the form of
	 *         integer
	 * @return integer number given by database
	 * @use it takes the id of the ClientContactPerson and delete
	 *      ClientContactPerson details in database and returns integer value
	 *      given by database
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	@Override
	public Integer deleteContactPerson(Integer id) throws SQLException, NoConnectionException {
		// get the connection from PooledConnection
		Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		Integer count = dao.deleteClientContactPerson(con, id);
		// if ClientContactPerson is deleted in database then it commit the
		// result
		if (count != 0) {
			con.commit();
		}
		// if ClientContactPerson is not deleted in database then it rollback
		// the result

		else {
			con.rollback();
		}
		// closing the connection
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}

		// returns the result
		return count;
	}
	
	/**
	 * @author N.Sravanthi
	 */

	@Override
	public List viewClientLocation( ClientDto dto) throws SQLException, NoConnectionException {
	Connection con = 	PooledConnection.getConnection();
		ProjectManagementDaoI dao =new ProjectManagementDaoImpl();
		List l = dao.viewClientLocation(con, dto);
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		return l;	
	}
	/**
	 * it returns all ClientContactPersonDetails in the form of List based on the given
	 *    ContactPersonLocationId
	 * @author N.Sravanthi
	 * 
	 * @param dto
	 *            accepts  location id in the form of ClientLocationDto
	 * @return ClientContactPerson details in the form of list
	 *
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */

	@Override
	public List<ClientContactPerson> getClientContactPerson(ClientLocationDto dto) throws NoConnectionException, SQLException {
		Connection con = 	PooledConnection.getConnection();
		ProjectManagementDaoI dao =new ProjectManagementDaoImpl();
		List l = dao.getClientContactPerson(con,dto);
		if(con!=null) {
			con.close();
			logger.info("connection closed");
			}
		return l;
	}
	
	/**
	 * 
	 * @author N.Sravanthi
	 * @param dto
	 *            accepts ContactPerson Details in the form of
	 *            ClientContactPersonDto
	 * @return integer number given by database
	 * @use it takes the ClientContactPerson object and adds the
	 *      ClientContactPerson details and returns integer value given by
	 *      database
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	@Override
	public Integer addContactPerson(ClientContactPerson dto) throws SQLException, NoConnectionException {
		Connection con = PooledConnection.getConnection();
		ProjectManagementDaoI dao = new ProjectManagementDaoImpl();
		Integer count = dao.addClientContactPesrson(con, dto);
		// if ClientContactPerson is added in database then it commit the
		// result
		if (count != 0) {
			logger.info("contact person added");
			con.commit();
		}
		// if ClientContactPerson is not added in database then it rollback
		// the result

		else {
			con.rollback();
			logger.info("contact person not added");
		}
		// closing the connection
		if(con!=null) {
		con.close();
		logger.info("connection closed");
		}

		// returns the result
		return count;

	}
	
	/*
	 * 
	 * @see com.nacre.servicei.ProjectManagementServiceI#viewProjectByManager(int)
	 * @author Raghav
	 */
	@Override
	public List<ProjectDto> viewProjectByManager(int managerId) throws NoConnectionException, SQLException {
		Connection con=PooledConnection.getConnection();
		ProjectManagementDaoI dao=new ProjectManagementDaoImpl();
		List<ProjectDto> pdto=dao.viewProjectsByManager(con, managerId);
		return pdto;
	}

}
