/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.ProjectManagementDaoI;
import com.nacre.dto.AddressDto;
import com.nacre.dto.CityDto;
import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ProjectInfoBeanMohan;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectManagementDaoImpl implements ProjectManagementDaoI {
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static final Logger logger = Logger.getLogger(ProjectManagementDaoImpl.class);

	/**
	 * This method is used to add project
	 * 
	 * @author Kunal Marathe
	 * 
	 * @param ProjectDto
	 *            the Project to set
	 * @param Connection
	 *            the Connection to set
	 * @return int value 0 for successful registration and 1 for registration
	 *         failed
	 * 
	 * @throws SQLException
	 * @see com.nacre.daoi.ProjectManagementDaoI#addProject(com.nacre.dto.ProjectDto)
	 */

	@Override
	public int addProject(Connection con, ProjectDto pDto) throws SQLException {
		PreparedStatement ps = null;
		int count = 0;

		ps = con.prepareStatement(SQLQueryConstants.ADD_PROJECT_QUERY);
		ps.setString(1, pDto.getProjectTitle());
		ps.setString(2, pDto.getProjectDescription());
		ps.setBlob(3, pDto.getProjectReferenceDocument());
		ps.setInt(4, pDto.getClientLocationId().getClientLocationId());
		ps.setDate(5, new Date(pDto.getExpectedStartDate().getTime()));

		if (pDto.getExpectedEndDate() != null)
			ps.setDate(6, new Date(pDto.getExpectedEndDate().getTime()));
		else
			ps.setDate(6, null);

		ps.setDouble(7, pDto.getProjectCompletionPercentage());
		ps.setString(8, pDto.getDocumetnNameWithExtension());
		ps.setInt(9, pDto.getStatus().getStatusId());

		count = ps.executeUpdate();

		return count;
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
	public int assignProjectToPM(Connection con, ProjectManagerProjectDto pmDto) throws SQLException {
		PreparedStatement ps = null;
		int count = 0;
		int update = 0;
		PreparedStatement psUpdate = null;

		ps = con.prepareStatement(SQLQueryConstants.ASSIGN_PROJECT_QUERY);

		if (pmDto.getDecidedStartDate() != null)
			ps.setDate(1, new java.sql.Date(pmDto.getDecidedStartDate().getTime()));
		else
			ps.setDate(1, null);

		if (pmDto.getDecidedEndDate() != null)
			ps.setDate(2, new java.sql.Date(pmDto.getDecidedEndDate().getTime()));
		else
			ps.setDate(2, null);

		ps.setInt(3, pmDto.getProjectId().getProjectId());
		ps.setInt(4, pmDto.getProjectManagerId().getUserId());
		ps.setInt(5, pmDto.getStatus().getStatusId());

		count = ps.executeUpdate();

		psUpdate = con.prepareStatement(SQLQueryConstants.UPDATE_PROJECT_STATUS_QUERY);
		psUpdate.setInt(1, pmDto.getStatus().getStatusId());
		psUpdate.setInt(2, pmDto.getProjectId().getProjectId());
		update = psUpdate.executeUpdate();

		if (count == 0 || update == 0)
			return 0;
		else
			return count;
	}

	/**
	 * method is used for display not assigned project
	 * 
	 * @author Kunal Marathe
	 *
	 */
	@Override
	public List<ProjectDto> displayNotAssignedProject(Connection con) throws SQLException {
		List<ProjectDto> list = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjectDto dto = null;
		ClientDto cdto = null;
		ClientLocationDto cLdto = null;
		AddressDto adto = null;

		// create instance of List
		list = new ArrayList<>();

		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_PROJECT_NOT_ASSIGNED);
		ps.setInt(1, IntegerConstants.PROJECT_NOT_ASSIGNED_STATUS);

		rs = ps.executeQuery();
		while (rs.next()) {
			dto = new ProjectDto();
			cdto = new ClientDto();
			cLdto = new ClientLocationDto();
			adto = new AddressDto();

			dto.setProjectId(rs.getInt(1));
			dto.setProjectTitle(rs.getString(2));
			dto.setProjectDescription(rs.getString(3));
			cdto.setClientName(rs.getString(4));
			cdto.setLogo(rs.getBlob(5));
			adto.setAddress(rs.getString(6));
			adto.setPinCode(rs.getInt(7));
			cLdto.setAddressId(adto);
			cLdto.setClientId(cdto);
			dto.setClientLocationId(cLdto);
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<ProjectDto> displayNotAssignedProject(Connection con, String search) throws SQLException {
		List<ProjectDto> list = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjectDto dto = null;
		ClientDto cdto = null;
		ClientLocationDto cLdto = null;
		AddressDto adto = null;

		// create instance of List
		list = new ArrayList<>();

		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_PROJECT_NOT_ASSIGNED_SEARCH);
		ps.setInt(1, IntegerConstants.PROJECT_NOT_ASSIGNED_STATUS);
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");

		rs = ps.executeQuery();
		while (rs.next()) {
			dto = new ProjectDto();
			cdto = new ClientDto();
			cLdto = new ClientLocationDto();
			adto = new AddressDto();

			dto.setProjectId(rs.getInt(1));
			dto.setProjectTitle(rs.getString(2));
			dto.setProjectDescription(rs.getString(3));
			cdto.setClientName(rs.getString(4));
			cdto.setLogo(rs.getBlob(5));
			adto.setAddress(rs.getString(6));
			adto.setPinCode(rs.getInt(7));
			cLdto.setAddressId(adto);
			cLdto.setClientId(cdto);
			dto.setClientLocationId(cLdto);
			list.add(dto);
		}
		return list;

	}

	/**
	 * method is used display project manager information according to search
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<UserDto> displayProjectManager(Connection con, String search) throws SQLException {
		List<UserDto> list = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDto dto = null;

		// create instance of List
		list = new ArrayList<>();

		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_PROJECT_MANAGER_SEARCH);
		ps.setString(1, "%" + search + "%");
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");
		logger.info(ps.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			dto = new UserDto();
			dto.setUserId(rs.getInt(1));
			dto.setFirstName(rs.getString(2));
			dto.setEmail(rs.getString(3));
			dto.setMobileNo(rs.getString(4));
			dto.setImage(rs.getBlob(5));
			list.add(dto);
		}
		return list;

	}

	/**
	 * method is used display project manager information
	 * 
	 * @author Kunal Marathe
	 *
	 */

	@Override
	public List<UserDto> displayProjectManager(Connection con) throws SQLException {
		List<UserDto> list = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDto dto = null;

		// create instance of List
		list = new ArrayList<>();

		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_PROJECT_MANAGER);
logger.debug(ps.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			dto = new UserDto();
			dto.setUserId(rs.getInt(1));
			dto.setFirstName(rs.getString(2));
			dto.setEmail(rs.getString(3));
			dto.setMobileNo(rs.getString(4));
			dto.setImage(rs.getBlob(5));
			list.add(dto);
		}
		return list;
	}

	/**
	 * method is used for add Client
	 * 
	 * @author Kunal Marathe
	 * @param
	 * 
	 * 
	 */

	@Override
	public int addClient(Connection con, ClientDto dto) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.ADD_CLIENT_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, dto.getClientName());
		ps.setString(2, dto.getClientDescription());
		ps.setBlob(3, dto.getLogo());
		int stat = ps.executeUpdate();

		if (stat != 0) {
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} // if
		} // if
		return 0;
	}

	/**
	 * method is used for add client address
	 * 
	 * @author Kunal Marathe
	 * @param
	 *
	 */

	@Override
	public int addClientAddress(Connection con, AddressDto dto) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.ADD_CLIENT_ADDRESS_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, dto.getAddress());
		ps.setInt(2, dto.getPinCode());
		ps.setInt(3, dto.getCityId().getCityId());

		int stat = ps.executeUpdate();

		if (stat != 0) {
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} // if
		} // if
		return 0;
	}

	/**
	 * method is used for add client Location
	 * 
	 * @author Kunal Marathe
	 * @param
	 *
	 */

	@Override
	public int addClientLocation(Connection con, ClientLocationDto dto) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.ADD_CLIENT_LOCATION_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(2, dto.getClientId().getClientId());
		ps.setInt(1, dto.getAddressId().getAddressId());

		int stat = ps.executeUpdate();

		if (stat != 0) {
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} // if
		} // if
		return 0;
	}

	/**
	 * method is used for add client contact person
	 * 
	 * @author Kunal Marathe
	 * @param
	 *
	 */

	@Override
	public int[] addClientContactPesrson(Connection con, List<ClientContactPerson> list) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.ADD_CLIENT_CONTACT_PERSON_QUERY);
		for (ClientContactPerson dto : list) {
			ps.setString(1, dto.getContactPersonName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getMobileNo());
			ps.setInt(4, dto.getClientLocationId().getClientLocationId());
			ps.addBatch();
		}
		int[] stat = ps.executeBatch();
		logger.debug(stat);
		return stat;
	}

	/**
	 * method is used to get all client
	 * 
	 * @author Kunal Marathe
	 * @param
	 *
	 */

	@Override
	public List<ClientLocationDto> getAllClient(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClientLocationDto> list = null;
		ClientLocationDto dto = null;
		ClientDto cdto = null;
		AddressDto adto = null;
		CityDto ctdto = null;
		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_CLIENT_QUERY);
		logger.debug(ps.toString());
		rs = ps.executeQuery();

		list = new ArrayList<>();
		while (rs.next()) {
			dto = new ClientLocationDto();
			cdto = new ClientDto();
			adto = new AddressDto();
			ctdto = new CityDto();

			dto.setClientLocationId(rs.getInt(1));
			cdto.setClientName(rs.getString(2));
			cdto.setLogo(rs.getBlob(3));
			cdto.setClientDescription(rs.getString(4));
			adto.setAddress(rs.getString(5));
			adto.setPinCode(rs.getInt(6));
			ctdto.setCity(rs.getString(7));

			adto.setCityId(ctdto);
			dto.setAddressId(adto);
			dto.setClientId(cdto);

			list.add(dto);
		}

		return list;
	}

	/**
	 * It is used to get all Client Information According to search condition
	 * 
	 * @author kunal
	 * @throws SQLException
	 *
	 */

	@Override
	public List<ClientLocationDto> getAllClient(Connection con, String search) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClientLocationDto> list = null;
		ClientLocationDto dto = null;
		ClientDto cdto = null;
		AddressDto adto = null;
		CityDto ctdto = null;
		ps = con.prepareStatement(SQLQueryConstants.DISPLAY_CLIENT_SEARCH_QUERY);
		ps.setString(1, "%" + search + "%");
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");

		rs = ps.executeQuery();

		list = new ArrayList<>();
		while (rs.next()) {
			dto = new ClientLocationDto();
			cdto = new ClientDto();
			adto = new AddressDto();
			ctdto = new CityDto();

			dto.setClientLocationId(rs.getInt(1));
			cdto.setClientName(rs.getString(2));
			cdto.setLogo(rs.getBlob(3));
			cdto.setClientDescription(rs.getString(4));
			adto.setAddress(rs.getString(5));
			adto.setPinCode(rs.getInt(6));
			ctdto.setCity(rs.getString(7));

			adto.setCityId(ctdto);
			dto.setAddressId(adto);
			dto.setClientId(cdto);

			list.add(dto);
		}

		return list;
	}

	/**
	 * @author Raghav this method is to get the All Project
	 * 
	 */
	@Override
	public List<ProjectDto> viewAllProjects(Connection con) throws NoConnectionException {
		ProjectDto pdto = null;
		ClientLocationDto cldto = null;
		List<ProjectDto> project = null;
		StatusDto sdto = null;
		AddressDto adto = null;

		// creatig PreparedStatement Obj
		try {
			ps = con.prepareStatement(SQLQueryConstants.VIEW_PROJECTS);

			// execute the Statement
			rs = ps.executeQuery();
			project = new ArrayList();
			// processing the results
			while (rs.next()) {
				// creating dto obj
				pdto = new ProjectDto();
				sdto = new StatusDto();
				cldto = new ClientLocationDto();
				adto = new AddressDto();

				pdto.setProjectId(rs.getInt(1));
				pdto.setProjectTitle(rs.getString(2));
				pdto.setProjectDescription(rs.getString(3));
				pdto.setProjectReferenceDocument(rs.getBlob(4));

				cldto.setClientLocationId(rs.getInt(5));
				adto.setAddressId(rs.getInt(14));
				adto.setAddress(rs.getString(17));
				cldto.setAddressId(adto);

				pdto.setClientLocationId(cldto);
				pdto.setExpectedStartDate(rs.getDate(6));
				pdto.setExpectedEndDate(rs.getDate(7));
				pdto.setProjectCompletionPercentage((rs.getDouble(8)));
				pdto.setDocumetnNameWithExtension(rs.getString(9));

				sdto.setStatusId(rs.getInt(10));
				sdto.setStatus(rs.getString(12));

				pdto.setStatus(sdto);

				project.add(pdto);
			}

			// create list obj
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	/**
	 * @author Raghav this method is to get the Project by ProjectId
	 * 
	 */
	@Override
	public ProjectDto viewProjectsById(Connection con, Integer projectId) throws NoConnectionException {
		ProjectDto pdto = null;
		ClientLocationDto cldto = null;
		StatusDto sdto = null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			ps = con.prepareStatement(SQLQueryConstants.VIEW_PROJECT_BY_ID);
			ps.setInt(1, projectId);
			rs = ps.executeQuery();

			// processing the results
			while (rs.next()) {
				// creating dto obj
				pdto = new ProjectDto();
				cldto = new ClientLocationDto();
				sdto = new StatusDto();

				pdto.setProjectId(rs.getInt(1));
				pdto.setProjectTitle(rs.getString(2));
				pdto.setProjectDescription(rs.getString(3));
				pdto.setProjectReferenceDocument(rs.getBlob(4));

				cldto.setClientLocationId(rs.getInt(5));

				pdto.setClientLocationId(cldto);
				pdto.setExpectedStartDate(rs.getDate(6));
				pdto.setExpectedEndDate(rs.getDate(7));
				pdto.setProjectCompletionPercentage((rs.getDouble(8)));
				pdto.setDocumetnNameWithExtension(rs.getString(9));

				sdto.setStatusId(rs.getInt(10));
				sdto.setStatus(rs.getString(12));

				pdto.setStatus(sdto);
			}
			return pdto;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	/**
	 * @author Raghav this method is to Update the Project details
	 * 
	 */
	@Override
	public int updateProject(ProjectDto pdto, Integer projectId, Connection con) throws NoConnectionException {
		int count = 0;
		try {
			if (pdto.getProjectReferenceDocument() != null) {
				ps = con.prepareStatement(SQLQueryConstants.EDIT_PROJECT_DETAILS_WITH_DOC);
				ps.setString(1, pdto.getProjectTitle());
				ps.setString(2, pdto.getProjectDescription());
				ps.setBlob(3, pdto.getProjectReferenceDocument());
				ps.setInt(4, pdto.getClientLocationId().getClientLocationId());
				ps.setDate(5, new Date(pdto.getExpectedStartDate().getTime()));
				ps.setDate(6, new Date(pdto.getExpectedEndDate().getTime()));
				ps.setDouble(7, pdto.getProjectCompletionPercentage());
				ps.setString(8, pdto.getDocumetnNameWithExtension());
				ps.setInt(9, pdto.getStatus().getStatusId());
				ps.setInt(10, projectId);
				count = ps.executeUpdate();
				con.commit();
			} else {
				ps = con.prepareStatement(SQLQueryConstants.EDIT_PROJECT_DETAILS_WITHOUT_DOC);
				ps.setString(1, pdto.getProjectTitle());
				ps.setString(2, pdto.getProjectDescription());
				ps.setInt(3, pdto.getClientLocationId().getClientLocationId());
				ps.setDate(4, new Date(pdto.getExpectedStartDate().getTime()));
				ps.setDate(5, new Date(pdto.getExpectedEndDate().getTime()));
				ps.setDouble(6, pdto.getProjectCompletionPercentage());
				ps.setInt(7, pdto.getStatus().getStatusId());
				ps.setInt(8, projectId);
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
	 * @author Raghav this method is to Remove the Project
	 * 
	 */
	@Override
	public int removeProject(Integer projectId, Connection con) throws NoConnectionException {
		int count = 0;
		try {
			ps = con.prepareStatement(SQLQueryConstants.REMOVE_PROJECT);
			ps.setInt(1, projectId);
			count = ps.executeUpdate();
			con.commit();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	@Override
	public ClientLocationDto getClientLocatin(Connection con, String address) throws NoConnectionException {
		ClientLocationDto cldto = null;
		AddressDto adto = null;

		try {
			ps = con.prepareStatement(SQLQueryConstants.CLIENT_LOCATION);
			ps.setString(1, address);
			rs = ps.executeQuery();
			while (rs.next()) {
				cldto = new ClientLocationDto();
				adto = new AddressDto();
				cldto.setClientLocationId(rs.getInt(1));
				adto.setAddressId(rs.getInt(2));
				adto.setAddress(rs.getString(5));
				cldto.setAddressId(adto);
			}
			return cldto;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	@Override
	public ProjectInfoBeanMohan viewProjectInfoById(Connection con, Integer projectId) throws NoConnectionException {
		ProjectInfoBeanMohan bean = null;
		ProjectDto pdto = null;
		ProjectManagerProjectDto pmdto = null;
		ClientLocationDto cldto = null;
		ClientContactPerson cpdto = null;
		ClientDto cdto = null;
		UserDto udto = null;
		StatusDto sdto = null;
		AddressDto adto = null;

		try {
			ps = con.prepareStatement(SQLQueryConstants.GETTING_INFORMATION_PROJECT);
			ps.setInt(1, projectId);
			rs = ps.executeQuery();

			// processing the results
			while (rs.next()) {
				// creating dto obj
				bean = new ProjectInfoBeanMohan();
				pdto = new ProjectDto();
				pmdto = new ProjectManagerProjectDto();
				cldto = new ClientLocationDto();
				cpdto = new ClientContactPerson();
				cdto = new ClientDto();
				udto = new UserDto();
				sdto = new StatusDto();
				adto = new AddressDto();

				pdto.setProjectId(rs.getInt(1));
				pdto.setProjectTitle(rs.getString(2));
				pdto.setProjectDescription(rs.getString(3));
				pdto.setProjectReferenceDocument(rs.getBlob(4));

				cldto.setClientLocationId(rs.getInt(5));

				pdto.setClientLocationId(cldto);
				pdto.setExpectedStartDate(rs.getDate(6));
				pdto.setExpectedEndDate(rs.getDate(7));
				pdto.setProjectCompletionPercentage((rs.getDouble(8)));
				pdto.setDocumetnNameWithExtension(rs.getString(9));

				sdto.setStatusId(rs.getInt(10));

				pdto.setStatus(sdto);

				adto.setAddressId(rs.getInt(12));

				cdto.setClientId(rs.getInt(13));

				cpdto.setClientContactPersonId(rs.getInt(14));
				cpdto.setContactPersonName(rs.getString(15));
				cpdto.setEmail(rs.getString(16));
				cpdto.setMobileNo(rs.getString(17));

				cldto.setClientLocationId(rs.getInt(18));

				cpdto.setClientLocationId(cldto);

				cdto.setClientName(rs.getString(20));
				cdto.setClientDescription(rs.getString(21));
				if(rs.getBlob(22)!=null)
				{
				cdto.setLogo(rs.getBlob(22));
				}
				else
				{
					cdto.setLogo(null);
				}
				pmdto.setProjectManagerProjectId(rs.getInt(23));
				pmdto.setDecidedStartDate(rs.getDate(24));
				pmdto.setDecidedEndDate(rs.getDate(25));
				pmdto.setProjectId(pdto);

				udto.setUserId(rs.getInt(29));
				udto.setFirstName(rs.getString(30));
				udto.setLastName(rs.getString(31));
				udto.setEmail(rs.getString(32));
				udto.setMobileNo(rs.getString(33));
				if(rs.getBlob(36)!=null)
				{
				udto.setImage(rs.getBlob(36));
				}
				else
				{
					udto.setImage(null);
				}
				pmdto.setProjectManagerId(udto);

				bean.setCdto(cdto);
				bean.setCldto(cldto);
				bean.setCpdto(cpdto);
				bean.setPdto(pdto);
				bean.setPmdto(pmdto);

			}
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection
	 * 
	 * @return List(ClientDto) All Client details in the form of list
	 * 
	 * @throws SQLException
	 * 
	 */

	@Override
	public List<ClientDto> viewAllClient(Connection con) throws SQLException {
		List<ClientDto> list = new ArrayList<ClientDto>();
		// creating statement object
		java.sql.Statement st = con.createStatement();
		// executing query and return result in the form of ResultSet
		ResultSet rs = st.executeQuery(SQLQueryConstants.ALL_CLIENT);
		while (rs.next()) {
			// creating ClientDto object
			ClientDto dto = new ClientDto();
			/*
			 * Retrieving results and set these details to dto
			 */
			dto.setClientId(rs.getInt(1));
			dto.setClientName(rs.getString(2));
			dto.setClientDescription(rs.getString(3));
			dto.setLogo(rs.getBlob(4));
			// adding dto object to list
			list.add(dto);
		}

		return list;
	}

	/**
	 * it returns all ClientDetails in the form of List based on the given
	 * ClientId
	 * 
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts ClientDto object having clientId
	 * @return location details in the form of list it returns all ClientDetails
	 *         in the form of List based on the given ClientId
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */

	@Override
	public List<ClientLocationDto> viewClientLocation(Connection con, ClientDto dto) throws SQLException {
		ClientLocationDto cldto = null;
		CityDto ctdto = null;
		AddressDto adto = null;
		java.sql.PreparedStatement ps = con.prepareStatement(SQLQueryConstants.VIEW_CLIENT_LOCATION_BY_ID);
		ps.setInt(1, dto.getClientId());
		List<ClientLocationDto> list = null;
		ResultSet rs = ps.executeQuery();
		list = new ArrayList<>();
		while (rs.next()) {
			cldto = new ClientLocationDto();
			adto = new AddressDto();
			ctdto = new CityDto();
			adto.setAddress(rs.getString(1));
			adto.setPinCode(rs.getInt(2));
			ctdto.setCity(rs.getString(3));
			cldto.setClientLocationId(rs.getInt(4));
			adto.setCityId(ctdto);
			cldto.setAddressId(adto);
			list.add(cldto);
		}
		return list;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection
	 * @param id
	 *            accepts a client id in the form of integer
	 * 
	 * 
	 * 
	 * @return List --> All Client details in the form of list
	 * @throws SQLException
	 * 
	 */
	@Override
	public List viewClientId(Connection con, Integer id) throws SQLException {
		PreparedStatement ps = null;
		// prepared statement object is created
		ps = con.prepareStatement(SQLQueryConstants.VIEW_CLIENT_ID);
		// setting parameters to query
		ps.setInt(1, id);
		// System.out.println(ps.toString());
		// executing query
		ResultSet rs = ps.executeQuery();
		Blob imageBlob = null;
		List<ClientContactPerson> l = new ArrayList();

		while (rs.next()) {
			ClientLocationDto cl = new ClientLocationDto();
			ClientContactPerson ccp = new ClientContactPerson();
			AddressDto addrs = new AddressDto();
			CityDto ci = new CityDto();
			// Retrieving result and set details to contactPerson
			ccp.setClientContactPersonId(rs.getInt(5));
			ccp.setContactPersonName(rs.getString(6));
			ccp.setEmail(rs.getString(7));
			ccp.setMobileNo(rs.getString(8));

			ci.setCityId(rs.getInt(13));
			addrs.setCityId(ci);
			addrs.setAddressId(rs.getInt(10));
			addrs.setAddress(rs.getString(11));
			addrs.setPinCode(rs.getInt(12));

			cl.setAddressId(addrs);
			ClientDto c = new ClientDto();
			c.setClientId(rs.getInt(1));
			c.setClientName(rs.getString(2));
			c.setClientDescription(rs.getString(3));
			imageBlob = rs.getBlob(4);
			c.setLogo(rs.getBlob(4));
			cl.setClientId(c);
			cl.setClientLocationId(rs.getInt(9));
			ccp.setClientLocationId(cl);
			// adding contact person details to list
			l.add(ccp);
		}

		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * 
	 * @param name
	 *            accepts a String i.e.. either client name or client
	 *            contactPerson name
	 * 
	 * @return List(Object) -->
	 *
	 *         All Client details in the form of list
	 * @throws SQLException
	 */
	@Override
	public List viewClientName(Connection con, String name) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer count = null;
		Blob imageBlob = null;
		// creating prepared statement
		ps = con.prepareStatement(SQLQueryConstants.VIEW_CLIENT_NAME);
		ps.setString(1, "%" + name + "%");
		ps.setString(2, "%" + name + "%");
		System.out.println(ps.toString());
		logger.info(ps.toString());
		System.out.println(ps.toString());
		rs = ps.executeQuery();

		List<ClientContactPerson> l = new ArrayList<>();

		while (rs.next()) {
			ClientLocationDto cl = new ClientLocationDto();
			ClientContactPerson ccp = new ClientContactPerson();
			AddressDto addrs = new AddressDto();
			ClientDto c = new ClientDto();
			CityDto ci = new CityDto();
			// Retrieving result and set details to contactPerson
			ccp.setClientContactPersonId(rs.getInt(5));
			ccp.setContactPersonName(rs.getString(6));
			ccp.setEmail(rs.getString(7));
			ccp.setMobileNo(rs.getString(8));

			ci.setCityId(rs.getInt(13));
			addrs.setCityId(ci);
			addrs.setAddressId(rs.getInt(10));
			addrs.setAddress(rs.getString(11));
			addrs.setPinCode(rs.getInt(12));

			cl.setAddressId(addrs);

			c.setClientId(rs.getInt(1));
			c.setClientName(rs.getString(2));
			c.setClientDescription(rs.getString(3));
			imageBlob = rs.getBlob(4);
			c.setLogo(rs.getBlob(4));
			cl.setClientId(c);
			cl.setClientLocationId(rs.getInt(9));
			ccp.setClientLocationId(cl);
			// adding contact person details to list
			l.add(ccp);
		}

		// adding client details to list
		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param Mobileno
	 *            accepts a String i.e.. contactPerson MobileNumber
	 * 
	 * @return All Client details in the form of list
	 * @throws SQLException
	 *
	 */

	@Override
	public List viewClientMobileNo(Connection con, String Mobileno) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.VIEW_CLIENT_Mobileno);
		ps.setString(1, Mobileno);
		logger.info((ps.toString()));
		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		List l = new ArrayList<>();

		while (rs.next()) {
			ClientLocationDto cl = new ClientLocationDto();
			ClientContactPerson ccp = new ClientContactPerson();
			AddressDto addrs = new AddressDto();
			CityDto ci = new CityDto();
			// Retrieving result and set details to contactPerson
			ccp.setClientContactPersonId(rs.getInt(5));
			ccp.setContactPersonName(rs.getString(6));
			ccp.setEmail(rs.getString(7));
			ccp.setMobileNo(rs.getString(8));

			ci.setCityId(rs.getInt(13));
			addrs.setCityId(ci);
			addrs.setAddressId(rs.getInt(10));
			addrs.setAddress(rs.getString(11));
			addrs.setPinCode(rs.getInt(12));

			cl.setAddressId(addrs);
			ClientDto c = new ClientDto();
			c.setClientId(rs.getInt(1));
			c.setClientName(rs.getString(2));
			c.setClientDescription(rs.getString(3));
			c.setLogo(rs.getBlob(4));

			cl.setClientId(c);
			cl.setClientLocationId(rs.getInt(9));

			ccp.setClientLocationId(cl);
			// adding contact person details to list
			l.add(ccp);
		}

		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param dto
	 *            accepts a ClientContactPersonDto i.e..
	 *            ClientContactPersonDetails
	 * 
	 * @return int value given by database
	 * @throws SQLException
	 * 
	 */

	@Override
	public Integer editClientContactPerson(Connection con, ClientContactPerson dto) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.EDIT_CONTACT_PERSON);
		ps.setString(1, dto.getContactPersonName());
		ps.setString(2, dto.getEmail());
		ps.setString(3, dto.getMobileNo());
		ps.setInt(4, dto.getClientContactPersonId());
		int count = ps.executeUpdate();

		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param dto
	 *            accepts a ClientDto i.e.. ClientDetails
	 * 
	 * @return int value given by database after executing query
	 * @throws SQLException
	 */

	@Override
	public Integer editClient(Connection con, ClientDto dto) throws SQLException {
		ClientDto client = null;
		// creating prepared statement object
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.EDIT_CLIENT);
		ps.setString(1, dto.getClientDescription());
		ps.setString(2, dto.getClientName());
		ps.setInt(3, dto.getClientId());
		int count = ps.executeUpdate();
		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param dto
	 *            accepts a ClientDto i.e.. Client new Logo
	 * 
	 * @return int value given by database
	 * @throws SQLException
	 */

	@Override
	public Integer editClientLogo(Connection con, ClientDto dto) throws SQLException {
		ClientDto client = null;
		// creating prepared statement object
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.EDIT_CLIENT_LOGO);
		ps.setBlob(1, dto.getLogo());
		ps.setInt(2, dto.getClientId());
		int count = ps.executeUpdate();
		// System.out.println(count + " client id" + dto.getClientId());
		return count;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param id
	 *            accepts a integer i.e.. client id
	 * 
	 * @return int value given by database
	 *
	 * @throws SQLException
	 */
	@Override
	public Integer deleteClientContactPerson(Connection con, Integer id) throws SQLException {
		// creating prepared statement object
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.REMOVE_CLIENT_CONTACT_PERSON);
		ps.setInt(1, id);
		Integer count = ps.executeUpdate();
		return count;
	}

	/**
	 * it returns all ClientContactPersonDetails in the form of List based on
	 * the given ContactPersonLocationId
	 * 
	 * @author N.Sravanthi
	 * @param con
	 *            accepts a sql connection
	 * @param dto
	 *            accepts location id in the form of ClientLocationDto
	 * @return ClientContactPerson details in the form of list
	 *
	 * @throws NoConnectionException
	 * @throws SQLException
	 * 
	 */

	@Override
	public List<ClientContactPerson> getClientContactPerson(Connection con, ClientLocationDto dto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CONTACT_PERSON_BY_LOCATION);
		ClientContactPerson ccp = null;

		ps.setInt(1, dto.getClientLocationId());

		ResultSet rs = ps.executeQuery();
		List l = new ArrayList<>();
		while (rs.next()) {
			ccp = new ClientContactPerson();

			ccp.setClientContactPersonId(rs.getInt(1));
			ccp.setContactPersonName(rs.getString(2));
			ccp.setEmail(rs.getString(3));
			ccp.setMobileNo(rs.getString(4));

			l.add(ccp);
		}

		return l;
	}

	/**
	 * 
	 * @author N.Sravanthi
	 * 
	 * @param con
	 *            accepts a sql connection.
	 * @param dto
	 *            accepts a ClientContactPerson obj i.e.. ClientContactPerson
	 *            details
	 * 
	 * @return int value given by database
	 *
	 * @throws SQLException
	 */
	@Override
	public int addClientContactPesrson(Connection con, ClientContactPerson dto) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.ADD_CLIENT_CONTACT_PERSON_QUERY);

		ps.setString(1, dto.getContactPersonName());
		ps.setString(2, dto.getEmail());
		ps.setString(3, dto.getMobileNo());
		ps.setInt(4, dto.getClientLocationId().getClientLocationId());

		int stat = ps.executeUpdate();
		logger.info("contact person added sucessfully");
		logger.debug(stat);
		return stat;
	}
	
	@Override
	public List<ProjectDto> viewProjectsByManager(Connection con, int managerId) throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProjectDto pdto=null;
		List list=new ArrayList<>();
		
		ps=con.prepareStatement(SQLQueryConstants.VIEW_PROJECT_BY_MANAGER);
		ps.setInt(1, managerId);
		rs=ps.executeQuery();
		while(rs.next()){
			pdto=new ProjectDto();
			pdto.setProjectId(rs.getInt(1));
			pdto.setProjectTitle(rs.getString(2));
			pdto.setProjectDescription(rs.getString(3));
			pdto.setProjectReferenceDocument(rs.getBlob(4));
			pdto.setExpectedStartDate(rs.getDate(6));
			pdto.setExpectedEndDate(rs.getDate(7));
			pdto.setProjectCompletionPercentage(rs.getDouble(8));
			list.add(pdto);
		}
		return list;
	}

	/*@Override
	public List<ProjectManagerProjectDto> getProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto getProjectCompletePercentage(int x) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
