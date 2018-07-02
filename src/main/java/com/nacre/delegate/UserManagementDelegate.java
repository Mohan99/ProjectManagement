
package com.nacre.delegate;

import java.sql.Blob;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.UserInformationBean;
import com.nacre.servicei.UserManagementServiceI;
import com.nacre.servicei.serviceimpl.UserManagementServiceImpl;
import com.nacre.uitl.ImageUtil;



/**
 * @author Vijay Kumar Reddy K
 *
 */

public class UserManagementDelegate {

	public static final Logger logger = Logger.getLogger(UserManagementDelegate.class);
	
	/**
	 * @author Avinash
	 * @Methode:addUserDetail
	 * @parameter:udto
	 * @return servic this method is used for addUserDetails
	 */
	public boolean addUserDetail(UserDto udto) throws SQLException, NoConnectionException, DuplicatMobNoException {
		UserManagementServiceI service = new UserManagementServiceImpl();
		return service.addUserDetails(udto);
	}

	/**
	 * @author Avinash
	 * @Methode:addMultiUEXcel
	 * @parameter:list
	 * @return servic this method is used for addUserExcel
	 */

	public List<UserDto> addMultiUEXcel(List<UserDto> list) throws SQLException, NoConnectionException {

		// TODO Auto-generated method stub
		UserManagementServiceI service = new UserManagementServiceImpl();
		return service.addUserExcel(list);

	}

	/**
	 * @author Avinash
	 * @Methode:getRoleDisply
	 * @parameter:
	 * @return servic this method is used for getRole
	 */

	public List<RoleDto> getRoleDisply()
			throws ConnectException, ClassNotFoundException, SQLException, NoConnectionException {
		// TODO Auto-generated method stub
		UserManagementServiceI service = new UserManagementServiceImpl();

		return service.getRole();
	}


	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopers()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	public List<UserInformationBean> getDevelopers() throws NoConnectionException, SQLException {
		
		//DECLARING UserManagementServiceI OBJECT
		UserManagementServiceI uService = null;
		
		//CREATING UserManagementServiceI OBJECT
		uService = new UserManagementServiceImpl();
		
		//CALLING METHOD IN UserManagementServiceI WHICH CONTAINS LIST OF UserDto OBJECTS
		List<UserDto> listDto = uService.getDevelopers();
		
		//CREATING LIST OBJECT WHICH CONTAINS UserInformationBean
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		
		//CONVERTING UserDto OBJECTS TO UserInformationBean OBJECTS
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeads()
	 * PARAMS  : STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	public List<UserInformationBean> getTeamLeads(String page) throws NoConnectionException, SQLException {
		//DECLARING UserManagementServiceI OBJECT
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getTeamLeads(page);
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}
	
	

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManager()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	public List<UserInformationBean> getProjectManager() throws NoConnectionException, SQLException {
		//DECLARING UserManagementServiceI OBJECT
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getProjectManager();
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setMobileNo(dto.getMobileNo());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;

	}
	
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUsers()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	
	public List<UserInformationBean> getUsers() throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getUsers();
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setLname(dto.getLastName());
			bean.setEmail(dto.getEmail());
			bean.setMobileNo(dto.getMobileNo());
			bean.setRoleId(dto.getRoleId().getRoleId());
			bean.setRole(dto.getRoleId().getRole());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}
	
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : removeUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE REMOVED
	 * RETURNS : INTEGER VALUE
	 */
	public int removeUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		return uService.removeUser(udto);
	}
	

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE Get
	 * RETURNS : UserDto
	 */
	public UserDto getUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		return uService.getUser(udto);
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : editUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE EDITED
	 * RETURNS : INTEGER VALUE
	 */
	public int editUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		return uService.editUser(udto);

	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : assignUser()
	 * PARAMS  : UserDto OBJECT,STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : INT VALUE
	 */
	public int assignUser(UserDto udto, String page) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		return uService.assignUser(udto, page);

	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUsersBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	public List<UserInformationBean> getUsersBySearch(String search) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getUsersBySearch(search);
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setLname(dto.getLastName());
			bean.setEmail(dto.getEmail());
			bean.setMobileNo(dto.getMobileNo());
			bean.setRoleId(dto.getRoleId().getRoleId());
			bean.setRole(dto.getRoleId().getRole());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}



	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopersBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	public List<UserInformationBean> getDevelopersBySearch(String search) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getDevelopersBySearch(search);
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManagerBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	public List<UserInformationBean> getProjectManagerBySearch(String search)
			throws SQLException, NoConnectionException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getProjectManagerBySearch(search);
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;
	}
	
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeadsBySearch()
	 * PARAMS  : TWO STRING VALUES TO GET TYPE USER TO SEARCHED,JSP PAGE FROM WHERE WE ARE GETTING REQUEST
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	public List<UserInformationBean> getTeamLeadsBySearch(String page, String search) throws NoConnectionException, SQLException {
		UserManagementServiceI uService = null;
		uService = new UserManagementServiceImpl();
		List<UserDto> listDto = uService.getTeamLeadsBySearch(page,search);
		List<UserInformationBean> listbean = new ArrayList<>();
		UserInformationBean bean = null;
		for (UserDto dto : listDto) {
			bean = new UserInformationBean();
			bean.setFname(dto.getFirstName());
			bean.setEmail(dto.getEmail());
			bean.setUserId(dto.getUserId());
			try {
				Blob b = dto.getImage();
				if (b != null)
					bean.setImg(ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				e.printStackTrace();
			}
			listbean.add(bean);

		}
		return listbean;

	}
}
