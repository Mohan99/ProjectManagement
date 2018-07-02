/**
 * 
 */
package com.nacre.servicei;

import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;

/**
 * @author kapilraj029 common operations
 *
 */
public interface CommonOperationsServiceI {
	
	public UserDto login(UserDto uDto) 
            throws NoConnectionException, 
                   SQLException, 
                   InvalidUserDetailsException;

/**
* @author Shraddha
* @param email
* @return
* @throws NoConnectionException
* @throws SQLException
* @throws InvalidUserDetailsException
*/
public Boolean forgetService(String email) throws NoConnectionException, SQLException, InvalidUserDetailsException;


/**
* @author Shraddha
* @param uDto
* @return Integer
* @throws NoConnectionException 
* @throws SQLException 
*/
public Integer changePassword(UserDto uDto) throws NoConnectionException, SQLException ;



	/**
	 * @author kapilraj029
	 *  @method viewUserProfile
	 *  @param UserDto user
	 *  @return List
	 */
	UserDto viewUserProfile(Integer userId) throws NoConnectionException, SQLException;

	/**
	 * @author kapilraj029
	 *  @method editProfile
	 *  @param UserDto user
	 *  return String
	 */
	public String editProfile(UserDto user) throws Exception;


	/**
	 * @author kapilraj029
	 *  @method getCities
	 *  @param StateDto sDto
	 * @return List
	 */
	
	List<CityDto> getCities(StateDto sDto) throws SQLException, NoConnectionException;

    /**
	 * @author kapilraj029
	 *  @method getCountries
	 *  @param CountryDto
	 *  @return List
	 */
	List<CountryDto> getCountries() throws SQLException, NoConnectionException;

	/**
	 * @author kapilraj029
	 *  @method getStates
	 *  @param StateDto
	 *  @return List
	 */
	
	List<StateDto> getStates(CountryDto cDto) throws SQLException, NoConnectionException;
	
	/**
	 * @author kapilraj029
	 *  @method editUserImage
	 *  @param UserDto dto
	 *  @return Integer
	 * @throws Exception 
	 */

	public Integer editUserImage(UserDto dto) throws NoConnectionException, SQLException, Exception;

	public UserDto getLoggedInUserDetails(String uid) throws NoConnectionException, SQLException, InvalidUserDetailsException;

}