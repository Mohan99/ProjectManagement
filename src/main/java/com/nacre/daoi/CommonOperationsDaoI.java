
package com.nacre.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.InvalidUserDetailsException;

/**
 *@author kapilraj029
 *CommonOperationsDaoi 
 */

public interface CommonOperationsDaoI {
	

	/**
	 * @author SHRADDHA
	 * @param con
	 * @param uDto
	 * @return
	 * @throws SQLException
	 * @throws InvalidUserDetailsException
	 */
	public UserDto login(Connection con, UserDto uDto) 
			                                                                             throws SQLException, 
			                                                                                              InvalidUserDetailsException;

	/**
	 * @author Shraddha
	 * @param con
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws InvalidUserDetailsException
	 */
	public String forgotPassword(Connection con, String email) 
			                                                                           throws SQLException, 
			                                                                                            InvalidUserDetailsException;

	

	int changePassword(Connection con, UserDto uDto) throws SQLException;

	
	
	
	/**
	 * @author kapilraj029 
	 *  @method viewUserProfile
	 *  @param con
	 *  @return List
	 *  @exception SQLException
	 */

	public UserDto viewUserProfile(Connection con,Integer uId) throws SQLException;

	/**
	 * @author kapilraj029 
	 *  @method editProfile
	 *  @param cDto,con
	 *  @return int
	 *  @exception SQLException
	 */
		
	public int editProfile(Connection con, UserDto user) throws SQLException;

	/**
	 * @author kapilraj029 
	 *  @method getCities
	 *  @param cDto,con
	 *  @return List
	 *  @exception SQLException
	 */
	

	public List<CityDto> getCities(StateDto dto, Connection con) throws SQLException;

	/**
	 * @author kapilraj029 
	 *  @method getStates
	 *  @param cDto,con
	 *  @return List
	 *  @exception SQLException
	 */
	
	public List<StateDto> getStates(CountryDto cDto, Connection con) throws SQLException;

	/**
	 * @author kapilraj029 
	 *  @method getCountry
	 *  @param con
	 *  @return List
	 *  @exception SQLException
	 */	
	public List<CountryDto> getCountries(Connection con) throws SQLException;

	/**
	 * @author kapilraj029 
	 *  @method editUserImage
	 *    @param dto,con
	 *  @return Integer
	 *  @exception SQLException
	 */
	


public Integer editUserImage(Connection con, UserDto dto) throws SQLException;

	public UserDto getLoggedInUserDetails(String uid, Connection con) throws SQLException, InvalidUserDetailsException;
}