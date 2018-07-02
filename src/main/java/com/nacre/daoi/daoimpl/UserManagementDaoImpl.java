/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.net.ConnectException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/*
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;*/
import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.UserManagementDaoI;
import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;

/**
 * @author Avinash Servlet implementation class UserManagementDaoImpl this class
 *         is used for inserting Detais single and multi,disply Role
 */
public class UserManagementDaoImpl implements UserManagementDaoI {

	public static final Logger logger = Logger.getLogger(UserManagementDaoImpl.class);
	
	/**
	 * @author Avinash
	 * @Methode:addUserDetails
	 * @parameter: udto , conn
	 * @exception:NoConnectionException, DuplicatMobNoException
	 *                                       this methode is used to Add single
	 *                                       User
	 */
	@Override
	public int addUserDetails(UserDto udto, Connection conn) throws NoConnectionException, DuplicatMobNoException {
		// TODO Auto-generated method stu
		try {
			java.sql.PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(SQLQueryConstants.INSERT_USER);
			System.out.println("setting params");
			pstmt.setString(1, udto.getFirstName());
			pstmt.setString(2, udto.getLastName());
			pstmt.setString(3, udto.getEmail());
			pstmt.setString(4, udto.getMobileNo());
			pstmt.setString(5, udto.getPassword());
			pstmt.setString(6, udto.getGender());
			pstmt.setInt(7, udto.getRoleId().getRoleId());

			pstmt.setInt(8, udto.getStatusId().getStatusId());
			// pstmt.setInt(9, udto.getUserId());
			// pstmt.setInt(10, udto.getAddressId().getAddressId());
			int b = pstmt.executeUpdate();
			System.out.println("Query executed");
			// conn.commit();
			return b;
		} /*catch (MySQLIntegrityConstraintViolationException  e) {
			e.printStackTrace();
			throw new DuplicatMobNoException("DUPLICTE MOBIE NO OR EMAIL FOUND");
		}*/
		catch (Exception e) {
			// TODO: handle exception
		
				if(e.getMessage().contains("Duplicate entry")){
					
					throw new DuplicatMobNoException("EMAIL OR MOBILE NO ALREADY EXIST");
				}
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NoConnectionException();
		}
	}

	/**
	 * @author Avinash
	 * @Methode:bulkAddUser
	 * @parameter: lisdto , conn
	 * @exception:SQLException this
	 *                             methode is used to Add bulk user(multiple)
	 *                             User
	 */

	@Override
	public int[] bulkAddUser(List<UserDto> listdto, Connection conn) throws SQLException {
		// TODO Auto-generated method stub

		int[] res = null;
		res = new int[100];
		int count = 0;

		java.sql.PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(SQLQueryConstants.INSERT_USERBBULK);
		System.out.println("setting params");
		for (UserDto dto : listdto) {
			pstmt.setString(1, dto.getFirstName());
			// pstmt.setString(2, dto.getLastName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getMobileNo());
			// pstmt.setString(5, dto.getPassword());
			pstmt.setString(4, dto.getGender());
			// pstmt.setString(5, dto.getRole());

			pstmt.setInt(5, dto.getRoleId().getRoleId());
			pstmt.setString(6, dto.getPassword());

			pstmt.setInt(7, IntegerConstants.statusid);
			// pstmt.setInt(8, udto.getUserId());
			// pstmt.setInt(9, udto.getAddressId().getAddressId());
			pstmt.addBatch();
		}
		int[] b = null;
		try {
			b = pstmt.executeBatch();

			System.out.println("Query executed");

		} catch (BatchUpdateException bUE) {
			// b= bUE.getUpdateCounts();
			bUE.printStackTrace();
		}

		return b;
	}

	/**
	 * @author Avinash
	 * @Methode:displyRole
	 * @parameter: conn
	 * @exception:ConnectException, SQLException,
	 *                                  ClassNotFoundException this methode is
	 *                                  used to disply role User
	 */

	@Override
	public List<RoleDto> displyRole(Connection conn) throws ConnectException, SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement pstmt = null;

		ResultSet rs = null;
		List<RoleDto> list = null;
		RoleDto roledto = null;
		pstmt = conn.prepareStatement(SQLQueryConstants.DISPLAY_ROLE);
		rs = pstmt.executeQuery();
		list = new ArrayList<>();
		while (rs.next()) {
			roledto = new RoleDto();
			roledto.setRoleId(rs.getInt(1));
			roledto.setRole(rs.getString(2));
			list.add(roledto);
		}
		return list;
	}

	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeads()
	 * PARAMS  : CONNECTION OBJECT,STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */

	@Override
	public List<UserDto> getTeamLeads(Connection con, String page) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		if (page.equals("developer")) {
			ps = con.prepareStatement(SQLQueryConstants.GET_TL_DEV);
		} else {
			ps = con.prepareStatement(SQLQueryConstants.GET_TL_PM);
		}
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;
	}

	
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopers()
	 * PARAMS  : CONNECTION OBJECT
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getDevelopers(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.GET_DEV);
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopersBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED,CONNECTION
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	@Override
	public List<UserDto> getDevelopersBySearch(Connection con, String search) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.DEVELOPER_SEARCH);
		ps.setString(1, "%" + search + "%");
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");
		System.out.println(ps.toString());
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManager()
	 * PARAMS  : CONNECTION OBJECT
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getProjectManager(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.GET_PM);
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManagerBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED,CONNECTION
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	@Override
	public List<UserDto> getProjectManagerBySearch(Connection con, String search) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.PROJECT_MANAGER_SEARCH);
		ps.setString(1, "%" + search + "%");
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : assignUser()
	 * PARAMS  : CONNECTION OBJECT,UserDto OBJECT,STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : INT VALUE
	 */
	@Override
	public int assignUser(UserDto udto, Connection con, String page) throws SQLException {
		PreparedStatement ps = null;
		Integer status;
		ps = con.prepareStatement(SQLQueryConstants.ASSIGN_USER);
		ps.setInt(1, udto.getSuperiorId().getUserId());
		ps.setInt(2, udto.getUserId());
		status = ps.executeUpdate();
		con.commit();
		con.close();
		return status;
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUsers()
	 * PARAMS  : CONNECTION OBJECT
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getUsers(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.GET_USERS);
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setLastName(rs.getString(3));
			udto.setEmail(rs.getString(4));
			udto.setMobileNo(rs.getString(5));
			udto.setImage(rs.getBlob(6));
			RoleDto rDto = new RoleDto();
			rDto.setRoleId(rs.getInt(7));
			int roleId=rDto.getRoleId();
			PreparedStatement ps1=con.prepareStatement(SQLQueryConstants.GET_ROLENAME);
			ps1.setInt(1, roleId);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			rDto.setRole(rs1.getString(1));
			udto.setRoleId(rDto);
			al.add(udto);
		}
		con.close();
		return al;

	}

	
	@Override
	public List<UserDto> getUsersBySearch(Connection con, String search) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		ps = con.prepareStatement(SQLQueryConstants.ALL_USERS_SEARCH);
		ps.setString(1, "%" + search + "%");
		ps.setString(2, "%" + search + "%");
		ps.setString(3, "%" + search + "%");
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setLastName(rs.getString(3));
			udto.setEmail(rs.getString(4));
			udto.setMobileNo(rs.getString(5));
			udto.setImage(rs.getBlob(6));
			RoleDto rDto = new RoleDto();
			rDto.setRoleId(rs.getInt(7));
			int roleId=rDto.getRoleId();
			PreparedStatement ps1=con.prepareStatement(SQLQueryConstants.GET_ROLENAME);
			ps1.setInt(1, roleId);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			rDto.setRole(rs1.getString(1));
			udto.setRoleId(rDto);
			al.add(udto);
		}
		con.close();
		return al;

	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : removeUser()
	 * PARAMS  : CONNECTION OBJECT,UserDto OBJECT WHICH USERID TO BE REMOVED
	 * RETURNS : INTEGER VALUE
	 */
	@Override
	public int removeUser(UserDto udto, Connection con) throws SQLException {
		PreparedStatement ps = null;
		int userId = udto.getUserId();
		ps = con.prepareStatement(SQLQueryConstants.REMOVE_USER);
		ps.setInt(1, userId);
		int status = ps.executeUpdate();
		con.commit();
		con.close();
		return status;

	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE Get,CONNECTION OBJECT
	 * RETURNS : UserDto
	 */
	@Override
	public UserDto getUser(UserDto udto, Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userId = udto.getUserId();
		ps = con.prepareStatement(SQLQueryConstants.GET_USER);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		rs.next();
		udto.setUserId(rs.getInt(1));
		udto.setFirstName(rs.getString(2));
		udto.setLastName(rs.getString(3));
		udto.setEmail(rs.getString(4));
		udto.setMobileNo(rs.getString(5));
		con.close();
		return udto;
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : editUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE EDITED,CONNECTION OBJECT
	 * RETURNS : INTEGER VALUE
	 */

	@Override
	public int editUser(UserDto udto, Connection con) throws SQLException {
		PreparedStatement ps = null;
		int userId = udto.getUserId();
		ps = con.prepareStatement(SQLQueryConstants.EDIT_USER);
		ps.setString(1, udto.getFirstName());
		ps.setString(2, udto.getLastName());
		ps.setString(3, udto.getEmail());
		ps.setString(4, udto.getMobileNo());
		ps.setInt(5, userId);
		int status = ps.executeUpdate();
		con.commit();
		con.close();
		return status;
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeadsBySearch()
	 * PARAMS  : TWO STRING VALUES TO GET TYPE USER TO SEARCHED,JSP PAGE FROM WHERE WE ARE GETTING REQUEST,CONNECTION OBJECT
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	

	@Override
	public List<UserDto> getTeamLeadsBySearch(Connection con, String page, String search) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> al = null;
		if (page.equals("developer")) {
			ps = con.prepareStatement(SQLQueryConstants.TL_DEV_SEARCH);
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
		} else {
			ps = con.prepareStatement(SQLQueryConstants.TL_PM_SEARCH);
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
		}
		rs = ps.executeQuery();
		al = new ArrayList<UserDto>();
		UserDto udto = null;
		while (rs.next()) {
			udto = new UserDto();
			udto.setUserId(rs.getInt(1));
			udto.setFirstName(rs.getString(2));
			udto.setEmail(rs.getString(3));
			udto.setImage(rs.getBlob(4));
			al.add(udto);
		}
		con.close();
		return al;

	}

}
