/**
 * 
 */
package com.nacre.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.CommonOperationsServiceI;
import com.nacre.servicei.serviceimpl.CommonOperationsServiceImpl;

/**
 * @author kapilraj029 CommonOperationsDelegate
 */
public class CommonOperationsDelegate {

	public static final Logger logger = Logger.getLogger(CommonOperationsDelegate.class);

	/**
	 * @author kapilraj029
	 * @method name viewUserProfile
	 * @param UerDto
	 *            user
	 * @return list
	 */

	public UserDto viewUserProfile(Integer user) throws NoConnectionException, SQLException {
		UserDto list = null;
		CommonOperationsServiceI service = null;
		// create the CommonOpertionsServiceI
		service = new CommonOperationsServiceImpl();
		// call the service and
		list = service.viewUserProfile(user);
		return list;
	}

	/**
	 * @author kapilraj029
	 * @method editProfile
	 * @param UerDto
	 *            user
	 * @return msg
	 */

	public String editProfile(UserDto user) throws Exception {

		CommonOperationsServiceI service = null;
		String msg = null;
		// create serviceI object
		service = new CommonOperationsServiceImpl();

		msg = service.editProfile(user);
		return msg;
	}
	/**
	 * @author kapilraj029
	 * @method editUserImage
	 * @param UerDto
	 *            user
	 * @return service
	 * @throws Exception 
	 */

	public Integer editUserImage(UserDto dto) throws Exception {

		CommonOperationsServiceI service = null;
		// create serviceI object and return the editUserImage
		service = new CommonOperationsServiceImpl();
		Integer count = service.editUserImage(dto);
		return count;
	}

	/**
	 * @author kapilraj029
	 * @throws SQLException
	 * @return List of Countries
	 * 
	 */

	public List<CountryDto> getCountries() throws SQLException, NoConnectionException {
		CommonOperationsServiceI Service = null;

		// create CommonOperationsServiceImpl object
		Service = new CommonOperationsServiceImpl();

		return Service.getCountries();
	}

	/**
	 * @author kapilraj029
	 * @throws SQLException
	 * @return List of State
	 * 
	 */

	public List<StateDto> getStates(CountryDto cDto) throws SQLException, NoConnectionException {
		CommonOperationsServiceI Service = null;

		// create CommonOperationsServiceImpl object
		Service = new CommonOperationsServiceImpl();

		return Service.getStates(cDto);
	}

	/**
	 * @author kapilraj029
	 * @throws SQLException
	 * @return List of City
	 * 
	 */

	public List<CityDto> getCities(StateDto sDto) throws SQLException, NoConnectionException {
		CommonOperationsServiceI service = null;

		// create CommonOperationsServiceImpl object
		service = new CommonOperationsServiceImpl();

		return service.getCities(sDto);
	}
	
	
	/**
	 * @author SHRADDHA
	 * @param uDto
	 * @return
	 * @throws NoConnectionException
	 * @throws SQLException
	 * @throws InvalidUserDetailsException
	 */
	public UserDto login(UserDto uDto) throws NoConnectionException, SQLException, InvalidUserDetailsException{
		CommonOperationsServiceImpl cServiceI=null;
		cServiceI=new CommonOperationsServiceImpl();
		UserDto uDto2=cServiceI.login(uDto);
		logger.info("From deligate valid"+uDto);
		return uDto2;
	}


	public Boolean forgetPass(String email) throws NoConnectionException, SQLException, InvalidUserDetailsException{
		CommonOperationsServiceImpl cServiceI=new CommonOperationsServiceImpl();
		Boolean flag=cServiceI.forgetService(email);
		return flag ;
	}

	public Integer changePassword(UserDto uDto) throws NoConnectionException, SQLException{
		CommonOperationsServiceImpl cServiceI=new CommonOperationsServiceImpl();
		Integer count=cServiceI.changePassword(uDto);
		return count ;
	}

	public UserDto getLoggedInUserDetails(String uid) throws NoConnectionException, SQLException, InvalidUserDetailsException {
		
		CommonOperationsServiceI cServiceI=new CommonOperationsServiceImpl();
		
		
		return cServiceI.getLoggedInUserDetails( uid);
		// TODO Auto-generated method stub
		
	}
	
}
