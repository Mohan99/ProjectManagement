/**
 * 
 */
package com.nacre.daoi;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;

/**
 * @author Avinash Function add single and multi daointeface
 *
 */
public interface UserManagementDaoI {
	
	public List<UserDto> getTeamLeads(Connection con,String page) throws SQLException;
	public int addUserDetails(UserDto udto, Connection conn) throws NoConnectionException, DuplicatMobNoException;

	public int[] bulkAddUser(List<UserDto> udto, Connection conn) throws SQLException;

	List<RoleDto> displyRole(Connection conn) throws ConnectException, SQLException, ClassNotFoundException;

	public List<UserDto> getDevelopers(Connection con) throws SQLException;

	public List<UserDto> getProjectManager(Connection con) throws SQLException;

	public int assignUser(UserDto udto, Connection con,String page) throws SQLException;

	public List<UserDto> getUsers(Connection con) throws SQLException;

	public int removeUser(UserDto udto, Connection con) throws SQLException;

	public UserDto getUser(UserDto udto, Connection con) throws SQLException;

	public int editUser(UserDto udto, Connection con) throws SQLException;

	public List<UserDto> getDevelopersBySearch(Connection con, String search) throws SQLException;

	public List<UserDto> getProjectManagerBySearch(Connection con, String search) throws SQLException;

	public List<UserDto> getUsersBySearch(Connection con, String search) throws SQLException;

	public List<UserDto> getTeamLeadsBySearch(Connection con, String page, String search) throws SQLException;
	
}
