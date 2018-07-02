/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.MessageConstants;
import com.nacre.daoi.CommonOperationsDaoI;
import com.nacre.daoi.daoimpl.CommonOperationsDaoImpl;
import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.CommonOperationsServiceI;
import com.nacre.uitl.PooledConnection;
import com.nacre.constants.MessageConstants;
import com.nacre.constants.StringConstants;
import com.nacre.daoi.CommonOperationsDaoI;
import com.nacre.daoi.daoimpl.CommonOperationsDaoImpl;
import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.CommonOperationsServiceI;
import com.nacre.uitl.EmailUtilty;
import com.nacre.uitl.PooledConnection;

/**
 * @author kapilraj029
 * implements CommonOperationsServiceImpl
 */
public class CommonOperationsServiceImpl implements CommonOperationsServiceI {

	public static final Logger logger = Logger.getLogger(CommonOperationsServiceImpl.class);

	/**
	 * @author Kunal Marathe
	 * @throws SQLException
	 * @return List of Countries
	 * 
	 */

	@Override
	public List<CountryDto> getCountries() throws SQLException, NoConnectionException {
		CommonOperationsDaoI dao = null;
		Connection con = null;
		List<CountryDto> list = null;
		// get Connection
		con = PooledConnection.getConnection();

		// create CommonOperationsServiceImpl object
		dao = new CommonOperationsDaoImpl();

		list = dao.getCountries(con);
		if(con!=null){
			con.close();
		}
		return list;
	}

	/**
	 * @author Kunal Marathe
	 * @throws SQLException
	 * @return List of State
	 * 
	 */

	@Override
	public List<StateDto> getStates(CountryDto cDto) throws SQLException, NoConnectionException {
		CommonOperationsDaoI dao = null;
		Connection con = null;
		List<StateDto> list = null;

		// get Connection
		con = PooledConnection.getConnection();

		// create CommonOperationsServiceImpl object
		dao = new CommonOperationsDaoImpl();

		list = dao.getStates(cDto, con);
		if(con!=null){
			con.close();
		}
		return list;
	}
	
	/**
	 * @author Kunal Marathe
	 * @throws SQLException
	 * @return List of City
	 * 
	 */

	@Override
	public List<CityDto> getCities(StateDto sDto) throws SQLException, NoConnectionException {
		CommonOperationsDaoI dao = null;
		Connection con = null;
		List<CityDto> list = null;
		// get Connection
		con = PooledConnection.getConnection();

		// create CommonOperationsServiceImpl object
		dao = new CommonOperationsDaoImpl();

		list =  dao.getCities(sDto, con);
		if(con!=null){
			con.close();
		}
		return list;
	}

	
	@Override
	public UserDto login(UserDto uDto) throws NoConnectionException, SQLException, InvalidUserDetailsException {
		Connection con = null;
		CommonOperationsDaoImpl cDaoI = null;

		con = PooledConnection.getConnection();

		cDaoI = new CommonOperationsDaoImpl();
		UserDto uDto1 = cDaoI.login(con, uDto);
		logger.info("from service valid ");
		
		if(con!=null){
			con.close();
		}
		return uDto1;
	}

	/**
	 * @author SHRADDHA Forget Password
	 * @throws InvalidUserDetailsException
	 */
	@Override
	public Boolean forgetService(String email) throws NoConnectionException, SQLException, InvalidUserDetailsException {
		Connection con = null;

		con = PooledConnection.getConnection();
		CommonOperationsDaoImpl cDaoI = new CommonOperationsDaoImpl();
		String password = cDaoI.forgotPassword(con, email);
		boolean flag = EmailUtilty.sendEmail(email, StringConstants.FORGETPASSWORD_SUBJECT,
				                                                                    MessageConstants.EMAIL_MASSAGE + password);
		if(con!=null){
			con.close();
		}
		logger.info("control in forget service");
		return flag;
	}

	/**
	 * For Change Password
	 * @return Integer
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public Integer changePassword(UserDto uDto) throws NoConnectionException, SQLException {
		Connection con = null;

		con = PooledConnection.getConnection();
		CommonOperationsDaoImpl cDaoI = new CommonOperationsDaoImpl();
		con.setAutoCommit(false);
		Integer result = cDaoI.changePassword(con, uDto);
	//	con.setAutoCommit(true);
		logger.info("Service:control is in change password");
		con.commit();
		if(con!=null){
			con.close();
		}
		return result;
	}


	/**
	 * @author kapilraj029 
	 * @method viewUserProfile
	 * @param UserDto user
	 * @return List
	 */
	@Override
	public UserDto viewUserProfile(Integer userId) throws NoConnectionException, SQLException {
		System.out.println("from serviceimpl");
		Connection con = null;
		UserDto list = null;
		CommonOperationsDaoI daoi = null;
		int uId = 0;
		// get the Connection
		con = PooledConnection.getConnection();
		// create dao
		daoi = new CommonOperationsDaoImpl();
		list = daoi.viewUserProfile(con,userId);
		if (con != null) {
			con.close();
		}
		return list;
	}


	/**
	 * @author kapilraj029 
	 * @method editProfile
	 * @param UserDto user
	 * @throws Exception
	 * @return msg
	 */

	@Override
	public String editProfile(UserDto user) throws Exception {
		Connection con = null;
		CommonOperationsDaoI dao = null;
		int count = 0;
		String msg = null;
		// get the Connection
		con = PooledConnection.getConnection();

		// create dao obj
		dao = new CommonOperationsDaoImpl();
		count = dao.editProfile(con, user);
		if (count == 0) {
			msg =(MessageConstants.EDIT_USER_FAILURE_MSG);

		} else {
		
			con.commit();
			msg =(MessageConstants.EDIT_USER_SUCCESS_MSG) ;
					}
		if (con != null) {
			con.close();
		}
		return msg;
	}
	
	/**
	 * @author kapilraj029 
	 * @method editUserImage
	 * @param UserDto user
	 * @throws Exception
	 * @return count
	 */

	@Override
	public Integer editUserImage(UserDto dto) throws Exception {
		Integer count = 0;

		String msg=null;
		
		CommonOperationsDaoI dao = null;
		Connection con = null;
		// get the Connection
		con = PooledConnection.getConnection();

		// create dao
		dao = new CommonOperationsDaoImpl();
		count = dao.editUserImage(con,dto);
		logger.debug(count);
		if (count != 0) {
			con.commit();
			msg = (MessageConstants.EDIT_CLIENT_LOGO_SUCCESS_MSG);

		} else {
			con.rollback();
			msg = (MessageConstants.EDIT_CLIENT_LOGO_FAILURE_MSG);

			}
		if (con != null) {
			con.close();
		}
		return count;
	}

	public UserDto getLoggedInUserDetails(String uid) throws NoConnectionException, SQLException, InvalidUserDetailsException {
		// TODO Auto-generated method stub
		CommonOperationsDaoI dao = null;
		Connection con = null;
		// get the Connection
		con = PooledConnection.getConnection();

		// create dao
		dao = new CommonOperationsDaoImpl();
UserDto userDto= dao.getLoggedInUserDetails(uid,con);
try {
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return userDto;
	}
}