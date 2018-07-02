
package com.nacre.daoi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.MessageConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.CommonOperationsDaoI;
import com.nacre.dto.AddressDto;
import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.RoleDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.InvalidUserDetailsException;

/**
 * @author kapilraj029
 *  CommonOperationsDaoImpl
 */

public class CommonOperationsDaoImpl implements CommonOperationsDaoI {

	public static final Logger logger = Logger.getLogger(CommonOperationsDaoImpl.class);

	@Override
	public List<CountryDto> getCountries(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CountryDto> listDto = null;
		CountryDto dto = null;
		ps = con.prepareStatement(SQLQueryConstants.COUNTRYLIST);
		rs = ps.executeQuery();
		listDto = new ArrayList<>();
		while (rs.next()) {
			dto = new CountryDto();
			dto.setCountryId(rs.getInt(1));
			dto.setCountry(rs.getString(2));
			logger.debug(dto);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<StateDto> getStates(CountryDto cDto, Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StateDto> listDto = null;
		StateDto Dto = null;
		ps = con.prepareStatement(SQLQueryConstants.STATELIST);
		ps.setInt(1, cDto.getCountryId());
		rs = ps.executeQuery();
		listDto = new ArrayList<>();
		while (rs.next()) {
			Dto = new StateDto();
			Dto.setStateID(rs.getInt(1));
			Dto.setState(rs.getString(2));
			listDto.add(Dto);
		}
		return listDto;
	}

	@Override
	public List<CityDto> getCities(StateDto dto, Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CityDto> listDto = null;
		CityDto cDto = null;
		ps = con.prepareStatement(SQLQueryConstants.CITYLIST);
		ps.setInt(1, dto.getStateID());
		rs = ps.executeQuery();
		listDto = new ArrayList<>();
		while (rs.next()) {
			cDto = new CityDto();
			cDto.setCityId(rs.getInt(1));
			cDto.setCity(rs.getString(2));

			listDto.add(cDto);
		}
		logger.debug(listDto);
		return listDto;
	}// method
	
	@Override
	public UserDto login(Connection con ,UserDto uDto) throws SQLException, InvalidUserDetailsException {
		String email = null;
		String pass = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer count = null;
		
		email = uDto.getEmail();
		pass = uDto.getPassword();
		pstmt = con.prepareStatement(SQLQueryConstants.LOGIN_QUERY);
		logger.info(email);
		logger.info(pass);
		pstmt.setString(1, email);
		pstmt.setString(2, pass);

		rs = pstmt.executeQuery();
		
		
		// at a time one user only login
		if (rs.next()) {
		
			RoleDto rDto = null;
			StatusDto sDto = null;
			AddressDto aDto = null;
			
			uDto.setUserId(rs.getInt(1));
			uDto.setFirstName(rs.getString(2));
			uDto.setLastName(rs.getString(3));
			uDto.setEmail(rs.getString(4));
			uDto.setMobileNo(rs.getString(5));
			uDto.setPassword(rs.getString(6));
			uDto.setGender(rs.getString(7));
			uDto.setImage(rs.getBlob(8));
			// getting roleId
			rDto = new RoleDto();
			rDto.setRoleId(rs.getInt(9));
			uDto.setRoleId(rDto);
			// getting statusid
			sDto = new StatusDto();
			sDto.setStatusId(rs.getInt(10));
			uDto.setStatusId(sDto);

			// get superior id
			UserDto sid = new UserDto();
			sid.setUserId(rs.getInt(11));
			uDto.setSuperiorId(sid);

			// get address id
			aDto = new AddressDto();
			aDto.setAddressId(rs.getInt(12));
			uDto.setAddressId(aDto);
			
			//list.add(uDto);
			System.out.println(uDto);
			logger.info("Valid loign details");
			return uDto;
		
		} else {
			logger.error("Invalid login details");
					
		throw new InvalidUserDetailsException(MessageConstants.INVALID_USER_CREDIENTIALS);	
			
		}

	}//login()

	/**
	 * @author SHRADDHA
	 * For forget Password
	 * @throws SQLException 
	 * @throws InvalidUserDetailsException 
	 */
	@Override
	public String forgotPassword(Connection con, String email) throws SQLException, InvalidUserDetailsException {
	   
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    Integer count=null;
	   String password=null;
	   
	   pstmt=con.prepareStatement(SQLQueryConstants.FORGET_PASSWORD_QUERY);
	   pstmt.setString(1, email);
	   rs=pstmt.executeQuery();
		
		if(rs.next()){
			password=rs.getString(1);
			logger.info("control is in forget password");
		}
		else{
			logger.info("invalid password,Try again");
			throw new InvalidUserDetailsException();
		}
	   return password;
	}//forget password

/**
 * @author Shraddha
 * @throws SQLException 
 */
	@Override
	public int changePassword(Connection con,UserDto uDto) throws SQLException {
		PreparedStatement pstmt=null;
	    String password=null;
		Integer count=null;   
		pstmt=con.prepareStatement(SQLQueryConstants.CHANGE_PASSWORD);
		pstmt.setString(1,uDto.getPassword());
		pstmt.setInt(2, uDto.getUserId());
		//System.out.println(uDto.getPassword()+"  "+uDto.getUserId()  );
		
		count=pstmt.executeUpdate();
		System.out.println("count=="+count);
		if(count!=0){
			logger.info("DAO:contorl in change password \n changed password success");
			}
		else{
			logger.info("password not changed");
			return 0;
			}
		return count;
	}

	
	/**
	 * @author kapilraj029
	 * @method name viewUserProfile
	 * @param connection con
	 *@return  users
	 */
	public UserDto viewUserProfile(Connection con,Integer uId ) throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs =null;
		System.out.println("from daoimpl");
		UserDto udto = null;
		RoleDto rdto = null;
		AddressDto adto = null;
		CountryDto cdto = null;
		StateDto stdto = null;
		CityDto ctdto = null;
		// create List object

		// prepare the statement
		ps = con.prepareStatement(SQLQueryConstants.VIEW_USER_PROFILE);
		ps.setInt(1, uId);
		
logger.debug(ps.toString());
		// execute the query
		rs = ps.executeQuery();
		if (rs.next()) {
			// createbthe Userdto Object
			udto = new UserDto();
			// create roledto object
			rdto = new RoleDto();
			// create the addressdto object
			adto = new AddressDto();
			// create citydto object
			ctdto = new CityDto();
			// create stateobject
			stdto = new StateDto();
			// create country object
			cdto = new CountryDto();

			// set the value
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setLastName(rs.getString(3));
			udto.setEmail(rs.getString(4));
			udto.setMobileNo(rs.getString(5));
		//	udto.setPassword(rs.getString(6));
			udto.setGender(rs.getString(7));
			udto.setImage(rs.getBlob(8));
			cdto.setCountry(rs.getString(9));
			cdto.setCountryId(rs.getInt(16));
			stdto.setCountryID(cdto);
			stdto.setState(rs.getString(10));
			stdto.setStateID(rs.getInt(17));
			ctdto.setStateId(stdto);
			ctdto.setCity(rs.getString(11));
			ctdto.setCityId(rs.getInt(18));
			adto.setCityId(ctdto);
			adto.setAddress(rs.getString(12));
			adto.setAddressId(rs.getInt(15));
			adto.setPinCode(rs.getInt(19));
			udto.setAddressId(adto);
			rdto.setRole(rs.getString(13));
			rdto.setRoleId(rs.getInt(14));
			udto.setRoleId(rdto);

			// logger.debug(users);
			// add the udto to users

		return udto;
		}else{
			return null;
		}
	}

	/**
	 * @author kapilraj029
	 * @method name editProfile
	 * @param connection con,UserDto user
	 *@return  count
	 */
	@Override
	public int editProfile(Connection con, UserDto user) throws SQLException {
		PreparedStatement ps=null;
		int count = 0;
		
		
	Integer adID=	insertAddress(con,user.getAddressId());
		
		//create the preparedstatement and set the query
		ps = con.prepareStatement(SQLQueryConstants.EDIT_USER_PROFILE);
		
		//set the value to ps
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getMobileNo());
		ps.setString(5, user.getGender());
		//ps.setBlob(9, user.getImage());
		ps.setInt(6	, adID);
		ps.setInt(7	, user.getUserId());

		// update the query
		count = ps.executeUpdate();
		return count;
	}

private Integer insertAddress(Connection con, AddressDto addressId) throws SQLException {
		// TODO Auto-generated method stub
	
PreparedStatement ps=	con.prepareStatement(SQLQueryConstants.INSERT_ADDRESS,Statement.RETURN_GENERATED_KEYS);
	ps.setString(1, addressId.getAddress());
	ps.setInt(2, addressId.getPinCode());	
ps.setInt(3, addressId.getCityId().getCityId());
 int status =ps.executeUpdate();
if(status!=0){
ResultSet rs=	ps.getGeneratedKeys();
	if(rs.next()){
		return rs.getInt(1);
		
	}
}
return null;	
}

/**
 * @author kapilraj029
 * @method name=editUserImage
 * @param connection,userDto user
 *@return  count
 */
	@Override
	public Integer editUserImage(Connection con, UserDto dto) throws SQLException {
		PreparedStatement ps = null;
		UserDto user = null;
		ps = con.prepareStatement(SQLQueryConstants.EDIT_USER_IMAGE);
		ps.setBlob(1, dto.getImage());
		ps.setInt(2, dto.getUserId());
	int count = ps.executeUpdate();
		return count;
	}

@Override
public UserDto getLoggedInUserDetails(String uid, Connection con) throws SQLException, InvalidUserDetailsException {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	UserDto user = null;
	ps = con.prepareStatement(SQLQueryConstants.GET_LOGGED_USER);

	ps.setInt(1, Integer.parseInt(uid));
ResultSet rs=	ps.executeQuery();
	if (rs.next()) {
		UserDto uDto = new UserDto();
		RoleDto rDto = null;
		StatusDto sDto = null;
		AddressDto aDto = null;
		
		uDto.setUserId(rs.getInt(1));
		uDto.setFirstName(rs.getString(2));
		uDto.setLastName(rs.getString(3));
		uDto.setEmail(rs.getString(4));
		uDto.setMobileNo(rs.getString(5));
		uDto.setPassword(rs.getString(6));
		uDto.setGender(rs.getString(7));
		uDto.setImage(rs.getBlob(8));
		// getting roleId
		rDto = new RoleDto();
		rDto.setRoleId(rs.getInt(9));
		uDto.setRoleId(rDto);
		// getting statusid
		sDto = new StatusDto();
		sDto.setStatusId(rs.getInt(10));
		uDto.setStatusId(sDto);

		// get superior id
		UserDto sid = new UserDto();
		sid.setUserId(rs.getInt(11));
		uDto.setSuperiorId(sid);

		// get address id
		aDto = new AddressDto();
		aDto.setAddressId(rs.getInt(12));
		uDto.setAddressId(aDto);
		
		//list.add(uDto);
		System.out.println(uDto);
		logger.info("Valid loign details");
		return uDto;
	
	} else {
		logger.error("Invalid login details");
				
	throw new InvalidUserDetailsException(MessageConstants.INVALID_USER_CREDIENTIALS);	
		
	}
	
}
}
/*
 * // get uid // public UserDto viewUserById(Integer userId) { public int
 * //public int getUid(UserDto user, Connection con) throws SQLException { int
 * count = 0; // prepare statem ps =
 * ps=con.prepareStatement(SQLQueryConstants.VIEW_USER_ID); // set the value
 * ps.setInt(1, user.getUserId()); // execute the query rs= ps.executeQuery();
 * if (rs != null) { while (rs.next()) { user.setUserId(rs.getInt(1));
 * 
 * } } rs.next(); count = rs.getInt(1); return count; }
 */
