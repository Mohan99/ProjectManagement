/**
 * 
 */
package com.nacre.delegate;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ClientInfoBean;
import com.nacre.formbean.ClientLocationBean;
import com.nacre.formbean.ClientLocationInfoBean;
import com.nacre.formbean.FormBeanClient;
import com.nacre.formbean.FormBeanClientContactPerson;
import com.nacre.formbean.ProjectInfoBean;
import com.nacre.formbean.ProjectInfoBeanMohan;
import com.nacre.formbean.ProjectManagerInfoBean;
import com.nacre.servicei.ProjectManagementServiceI;
import com.nacre.servicei.serviceimpl.ProjectManagementServiceImpl;
import com.nacre.uitl.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectManagementDelegate {

	public static final Logger logger = Logger.getLogger(ProjectManagementDelegate.class);

	ProjectManagementServiceI service = null;
	
	public ProjectManagementDelegate()  {
		service=new ProjectManagementServiceImpl();
	}

	/**
	 * @author Raghav ,To getting the all Projects
	 * @throws SQLException 
	 *
	 */
	public List<ProjectDto> viewAllProjects() throws NoConnectionException, SQLException{
		List<ProjectDto> project=null;
		try {
			project=service.viewAllProjects();
			return project;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}
	
	/**
	 * @author Raghav ,To updating the Project
	 * @throws NoConnectionException 
	 * @throws SQLException 
	 *
	 */
	public boolean updateProject(int projectId,ProjectDto pdto) throws NoConnectionException, SQLException{
		boolean flag;
		try {
			flag=service.updateProject(projectId, pdto);
			return flag;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}
	
	/**
	 * @author Raghav ,To Delete Project
	 * @throws NoConnectionException 
	 * @throws SQLException 
	 *
	 */
	public boolean deleteProject(int projectId) throws NoConnectionException, SQLException{
		boolean flag;
		try {
			flag=service.deleteProject(projectId);
			return flag;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}
	
	/**
	 * @author Raghav ,get Project by ProjectId
	 * @throws NoConnectionException 
	 * @throws SQLException 
	 *
	 */
	public ProjectDto getProjectById(int projectId) throws NoConnectionException, SQLException{
		ProjectDto pdto=null;
		try {
			pdto=service.viewProjectById(projectId);
			return pdto;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}
	
	public int getClientLocation(String address) throws NoConnectionException{
		int locationId=0;
		
		locationId=service.getClientLocationId(address);
		return locationId;
	}
	
	/**
	 * @author Raghav ,get ProjectInfo by ProjectId
	 * @throws NoConnectionException 
	 * @throws SQLException 
	 *
	 */
	public ProjectInfoBeanMohan getProjectInfById(int projectId) throws NoConnectionException, SQLException{
		ProjectInfoBeanMohan bean=null;
		try {
			bean=service.viewProjectInfoById(projectId);
			return bean;
		} catch (NoConnectionException e) {
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}


	/** method is used for add project
	 * @author Kunal Marathe
	 * @param 
	 *  
	 *  holding project info
	 *
	 */
	public boolean addProject(ProjectDto pDto) throws SQLException, NoConnectionException {
		return new ProjectManagementServiceImpl().addProject(pDto);
	}

	/** method is used for assign project to project manager
	 * @author Kunal Marathe
	 * @param 
	 *  
	 *  holding manager id and client location id
	 *
	 */

	public String assignProjectToPM(ProjectManagerProjectDto pmDto) throws SQLException, NoConnectionException {
		return new ProjectManagementServiceImpl().assignProjectToPM(pmDto);
	}
	
	/** method is used for display not assigned project
	 * and converting ProjectInfo dto obj to ProjectInfoBean obj
	 * @author Kunal Marathe
	 *
	 */

	public List<ProjectInfoBean> displayNotAssignedProject()
			throws SQLException, NoConnectionException {
		List<ProjectDto> listDto = null;
		List<ProjectInfoBean> list = null;

		ProjectManagementServiceI service = null;
		ProjectInfoBean pbean = null;
		list = new ArrayList<>();

		service = new ProjectManagementServiceImpl();
		listDto = service.displayNotAssignedProject();
		for (ProjectDto dto : listDto) {
			pbean = new ProjectInfoBean();
			logger.debug(dto);
			pbean.setProjectId(dto.getProjectId());
			pbean.setProjectTitle(dto.getProjectTitle());
			pbean.setProjectDescription(dto.getProjectDescription());
			pbean.setClientName(dto.getClientLocationId().getClientId().getClientName());
			Blob b = dto.getClientLocationId().getClientId().getLogo();
			if (b != null)
				try {
					pbean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}

			pbean.setAddress(dto.getClientLocationId().getAddressId().getAddress());
			pbean.setPinCode(dto.getClientLocationId().getAddressId().getPinCode());
			list.add(pbean);
		}
		return list;
	}
	
	/** method is used for display not assigned project
	 * and converting ProjectInfo dto obj to ProjectInfoBean obj according to serach condition
	 * @author Kunal Marathe
	 *
	 */

	public List<ProjectInfoBean> displayNotAssignedProject(String search)
			throws SQLException, NoConnectionException {
		List<ProjectDto> listDto = null;
		List<ProjectInfoBean> list = null;

		ProjectManagementServiceI service = null;
		ProjectInfoBean pbean = null;
		list = new ArrayList<>();

		service = new ProjectManagementServiceImpl();
		listDto = service.displayNotAssignedProject(search);
		for (ProjectDto dto : listDto) {
			pbean = new ProjectInfoBean();
			logger.debug(dto);
			pbean.setProjectId(dto.getProjectId());
			pbean.setProjectTitle(dto.getProjectTitle());
			pbean.setProjectDescription(dto.getProjectDescription());
			pbean.setClientName(dto.getClientLocationId().getClientId().getClientName());
			Blob b = dto.getClientLocationId().getClientId().getLogo();
			if (b != null)
				try {
					pbean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}

			pbean.setAddress(dto.getClientLocationId().getAddressId().getAddress());
			pbean.setPinCode(dto.getClientLocationId().getAddressId().getPinCode());
			list.add(pbean);
		}
		return list;
	}

	
	/** method is used display project manager information
	 * @author Kunal Marathe
	 *
	 */


	public List<ProjectManagerInfoBean> displayProjectManager() throws SQLException, NoConnectionException {
		List<UserDto> listDto = null;
		List<ProjectManagerInfoBean> list = null;

		ProjectManagementServiceI service = null;
		ProjectManagerInfoBean pbean = null;
		list = new ArrayList<>();

		service = new ProjectManagementServiceImpl();
		listDto = service.displayProjectManager();

		for (UserDto dto : listDto) {
			pbean = new ProjectManagerInfoBean();
			logger.debug(dto.getFirstName());
			pbean.setUserId(dto.getUserId());
			pbean.setFirstName(dto.getFirstName());
			pbean.setEmail(dto.getEmail());
			pbean.setMobileNo(dto.getMobileNo());
			Blob b = dto.getImage();
			if (b != null)
				try {
					pbean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}
			list.add(pbean);
		}
		return list;
	}
	
	/** method is used display project manager information
	 * @author Kunal Marathe
	 *
	 */


	public List<ProjectManagerInfoBean> displayProjectManager(String search) throws SQLException, NoConnectionException {
		List<UserDto> listDto = null;
		List<ProjectManagerInfoBean> list = null;

		ProjectManagementServiceI service = null;
		ProjectManagerInfoBean pbean = null;
		list = new ArrayList<>();

		service = new ProjectManagementServiceImpl();
		listDto = service.displayProjectManager(search);

		for (UserDto dto : listDto) {
			pbean = new ProjectManagerInfoBean();
			logger.debug(dto.getFirstName());
			pbean.setUserId(dto.getUserId());
			pbean.setFirstName(dto.getFirstName());
			pbean.setEmail(dto.getEmail());
			pbean.setMobileNo(dto.getMobileNo());
			Blob b = dto.getImage();
			if (b != null)
				try {
					pbean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}
			list.add(pbean);
		}
		return list;
	}


	/** method is used add Client information and its multiple contact person
	 * @author Kunal Marathe
	 * @param
	 *
	 */
	
	public boolean addClient(List<ClientContactPerson> list) throws SQLException, NoConnectionException {
		return new ProjectManagementServiceImpl().addClient(list);

	}
	
	/** method is used to get Client information
	 * @author Kunal Marathe
	 *
	 */


	public List<ClientLocationInfoBean> getAllClient() throws SQLException, NoConnectionException {
		List<ClientLocationDto> list = null;
		List<ClientLocationInfoBean> beanList = null;
		ClientLocationInfoBean bean = null;
		list = new ProjectManagementServiceImpl().getAllClient();

		beanList = new ArrayList<>();

		for (ClientLocationDto cldto : list) {
			bean = new ClientLocationInfoBean();
			bean.setLocationId(cldto.getClientLocationId());
			bean.setClientName(cldto.getClientId().getClientName());
			bean.setClientDescription(cldto.getClientId().getClientDescription());
			bean.setAddress(cldto.getAddressId().getAddress());
			bean.setPincode(cldto.getAddressId().getPinCode());
			bean.setCity(cldto.getAddressId().getCityId().getCity());
			
			
			Blob b = cldto.getClientId().getLogo();
			
						if (b != null)
				try {
					bean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}

			beanList.add(bean);
		}

		return beanList;
	}

	/** method is used to get Client information according to search
	 * @author Kunal Marathe
	 * @throws NoConnectionException 
	 * @throws SQLException 
	 *
	 */

	public List<ClientLocationInfoBean> getAllClientSearch(String search) throws SQLException, NoConnectionException {
		List<ClientLocationDto> list = null;
		List<ClientLocationInfoBean> beanList = null;
		ClientLocationInfoBean bean = null;
		list = new ProjectManagementServiceImpl().getAllClient(search);

		beanList = new ArrayList<>();

		for (ClientLocationDto cldto : list) {
			bean = new ClientLocationInfoBean();
			bean.setLocationId(cldto.getClientLocationId());
			bean.setClientName(cldto.getClientId().getClientName());
			bean.setClientDescription(cldto.getClientId().getClientDescription());
			bean.setAddress(cldto.getAddressId().getAddress());
			bean.setPincode(cldto.getAddressId().getPinCode());
			bean.setCity(cldto.getAddressId().getCityId().getCity());
			
			Blob b = cldto.getClientId().getLogo();
			
						if (b != null)
				try {
					bean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
				} catch (ImageStreamToByteException e) {
					logger.error(e.getMessage());
				}

			beanList.add(bean);
		}

		return beanList;
	}

	/**
	 * 
	 * it return the all client and contact person details available in the database  in the form of list
	 * @author N.Sravanthi
	 *@param: --
	 * @Returns:  
	 * ClientDetails in the form of list -->   List<FormBeanClient>
	 *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */

	public List<ClientInfoBean>  viewAllClient() throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ClientDto> list = service.viewAllClient();
		List<ClientInfoBean> listBean = new ArrayList<>();
		ClientInfoBean bean = null;
		
		for (ClientDto dto : list) {
			bean = new ClientInfoBean();
			bean.setClientId(dto.getClientId());
			bean.setClientName(dto.getClientName());
			bean.setClientDescription(dto.getClientDescription());
			
			Blob b = dto.getLogo();
			
			if(b!=null)
				bean.setLogo(ImageUtil.encodeImage(b.getBinaryStream()));
			
			listBean.add(bean);
		}

		return listBean;
		}

	/**
	 * @author N.Sravanthi
	 * @param dto accepts client id in the form of client dto obj
	 * @return client location details
	 * @throws SQLException
	 * @throws NoConnectionException
	 * @throws ImageStreamToByteException
	 */


	public List<ClientLocationBean> viewClientLocation(ClientDto dto) throws SQLException, NoConnectionException, ImageStreamToByteException {
	ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ClientLocationDto> list = service.viewClientLocation(dto);
		List<ClientLocationBean> listBean = new ArrayList<>();
		ClientLocationBean bean = null;
		for (ClientLocationDto cldto : list) {
			bean = new ClientLocationBean();
			bean.setAddress(cldto.getAddressId().getAddress());
			bean.setCity(cldto.getAddressId().getCityId().getCity());
			bean.setPinCode(cldto.getAddressId().getPinCode());
			bean.setClientLocationId(cldto.getClientLocationId());
			
			listBean.add(bean);
		}

		return listBean;
	}

	/**
	 * @author N.Sravanthi
	 * @param dto accepts location details
	 * @return client contact person details
	 * @throws SQLException
	 * @throws NoConnectionException
	 * @throws ImageStreamToByteException
	 */

	public List<ClientContactPerson> viewContactPerson(ClientLocationDto dto) throws SQLException, NoConnectionException, ImageStreamToByteException {
	ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ClientContactPerson> list = service.getClientContactPerson(dto);
		return list;
	}

	/**
	 * it return the all client and contact person details available in the database  in the form of list 
	 * based on the given client name or contact person  name
	 * 
	 * @author N.Sravanthi
	 * @param  name accepts client name or contact person  name in the form of string
	 * @Returns:  
	 * ClientDetails in the form of list -->List<FormBeanClient>
	  *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */

	public ClientInfoBean viewClientName(String name) throws SQLException, NoConnectionException, ImageStreamToByteException
			 {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ClientContactPerson> list = service.viewClientName(name);
		FormBeanClient details = new FormBeanClient();
		List<ClientInfoBean> listbean = new ArrayList<>();
		ClientInfoBean bean = null;
		for (ClientContactPerson dto : list) {
			details.setClientId(dto.getClientLocationId().getClientId().getClientId());
			details.setClientName(dto.getClientLocationId().getClientId().getClientName());
			details.setClientDescription(dto.getClientLocationId().getClientId().getClientDescription());
			Blob blob = dto.getClientLocationId().getClientId().getLogo();

			String encodeImg = ImageUtil.encodeImage(blob.getBinaryStream());
			details.setLogo(encodeImg);
			// details.setLogo(blob);
			FormBeanClientContactPerson ccp = new FormBeanClientContactPerson();
			ccp.setContactPersonId(dto.getClientContactPersonId());
			ccp.setLocationId(dto.getClientLocationId().getClientLocationId());
			ccp.setContactPersonName(dto.getContactPersonName());
			ccp.setMailId(dto.getEmail());
			ccp.setMobileNo(dto.getMobileNo());
			ccp.addrs.setAddress(dto.getClientLocationId().getAddressId().getAddress());

			details.list.add(ccp);
			//System.out.println(details);

			bean = new ClientInfoBean();
			bean.setClientId(dto.getClientLocationId().getClientId().getClientId());
			bean.setClientName(dto.getClientLocationId().getClientId().getClientName());
			bean.setClientDescription(dto.getClientLocationId().getClientId().getClientDescription());
			bean.setLogo(ImageUtil.encodeImage(dto.getClientLocationId().getClientId().getLogo().getBinaryStream()));
			System.out.println(bean);
			listbean.add(bean);
		}
		return bean;

		}
		
		

	/**
	 * @author N.Sravanthi
	 * @param  Mobileno accepts client name or contact person  name in the form of string
	 * @Returns:  ClientDetails in the form of list -->   List<FormBeanClient>
	 *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */
	public ClientInfoBean viewClientMobileNo(String Mobileno)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
	ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		ClientInfoBean  bean = null;
		List<ClientContactPerson> list = service.viewClientMobileNo(Mobileno);
		FormBeanClient details = new FormBeanClient();
		List<ClientInfoBean> listbean = new ArrayList<>();
		for (ClientContactPerson dto : list) {
			details.setClientId(dto.getClientLocationId().getClientId().getClientId());
			details.setClientName(dto.getClientLocationId().getClientId().getClientName());
			details.setClientDescription(dto.getClientLocationId().getClientId().getClientDescription());
			Blob blob = dto.getClientLocationId().getClientId().getLogo();

			String encodeImg = ImageUtil.encodeImage(blob.getBinaryStream());
			details.setLogo(encodeImg);
			// details.setLogo(blob);
			FormBeanClientContactPerson ccp = new FormBeanClientContactPerson();
			ccp.setContactPersonId(dto.getClientContactPersonId());
			ccp.setLocationId(dto.getClientLocationId().getClientLocationId());
			ccp.setContactPersonName(dto.getContactPersonName());
			ccp.setMailId(dto.getEmail());
			ccp.setMobileNo(dto.getMobileNo());
			ccp.addrs.setAddress(dto.getClientLocationId().getAddressId().getAddress());

			details.list.add(ccp);
		//	System.out.println(details);
			
			bean = new ClientInfoBean();
			bean.setClientId(dto.getClientLocationId().getClientId().getClientId());
			bean.setClientName(dto.getClientLocationId().getClientId().getClientName());
			bean.setClientDescription(dto.getClientLocationId().getClientId().getClientDescription());
			bean.setLogo(ImageUtil.encodeImage(dto.getClientLocationId().getClientId().getLogo().getBinaryStream()));
			//System.out.println(bean);
			listbean.add(bean);


		}
		return bean;
	}

	/**
	 * @author N.Sravanthi
	  * @param id accepts client name or contact person  name in the form of string
	 * @Returns:  ClientDetails in the form of list -->   List<FormBeanClient>
	  *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */
	public FormBeanClient viewClientId(Integer id)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
	ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ClientContactPerson> list = service.viewClientId(id);
		FormBeanClient details = new FormBeanClient();
		for (ClientContactPerson dto : list) {
			details.setClientId(dto.getClientLocationId().getClientId().getClientId());
			details.setClientName(dto.getClientLocationId().getClientId().getClientName());
			details.setClientDescription(dto.getClientLocationId().getClientId().getClientDescription());
			Blob blob = dto.getClientLocationId().getClientId().getLogo();

			String encodeImg = ImageUtil.encodeImage(blob.getBinaryStream());
			details.setLogo(encodeImg);
			FormBeanClientContactPerson ccp = new FormBeanClientContactPerson();
			ccp.setContactPersonId(dto.getClientContactPersonId());
			ccp.setLocationId(dto.getClientLocationId().getClientLocationId());
			ccp.setContactPersonName(dto.getContactPersonName());
			ccp.setMailId(dto.getEmail());
			ccp.setMobileNo(dto.getMobileNo());
			ccp.addrs.setAddress(dto.getClientLocationId().getAddressId().getAddress());

			details.list.add(ccp);

		}
		return details;
	}


	/**
	 * @author N.Sravanthi
	  *  @param dto accepts client details   in the form of ClientDto
	 * @Returns:  ClientDetails in the form of list -->   List<FormBeanClient>
	  *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */
	public Integer editClient(ClientDto dto) throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		Integer count = service.editClient(dto);

		return count;
	}

	/**
	 * @author N.Sravanthi
	  * @param dto accepts client details   in the form of ClientDto
	 * @Returns: int value given by database
	 * 
	 * 
	 * 
	 *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */

	public Integer editClientLogo(ClientDto dto)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		Integer count = service.editClientLogo(dto);

		return count;
	}

	/**
	* @author N.Sravanthi
	  * @param: dto accepts ClientContactPerson obj for add details in database
	 * @Returns:  int given by database
	 *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */
	public Integer addContactPerson(ClientContactPerson dto)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		Integer count = service.addContactPerson(dto);

		return count;
	}

	/**
	 * @author N.Sravanthi
	  * @param: dto accepts ClientContactPerson obj  for edit details in database
	 * @Returns:  int given by database
	 *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */
	public Integer editContactPerson(ClientContactPerson dto)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		Integer count = service.editContactPerson(dto);

		return count;
	}

	/**
	 * @author N.Sravanthi
	  * @Parameters: client name or contact person  name in the form of string
	 * @Returns:  ClientDetails in the form of list -->   List<FormBeanClient>
	  *  @throws NoConnectionException Connection is not Established
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 * @throws ImageStreamToByteException while converting image from inputStream to Byte
	 * 
	 */

	public Integer deleteContactPerson(Integer id)
			throws SQLException, NoConnectionException, ImageStreamToByteException {
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		Integer count = service.deleteContactPerson(id);

		return count;
	}
	
	public List<ProjectDto> viewProjectByManager(int managerId) throws NoConnectionException, SQLException{
		ProjectManagementServiceI service = new ProjectManagementServiceImpl();
		List<ProjectDto> list=service.viewProjectByManager(managerId);
		return list;
	}


}
