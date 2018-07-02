/**
 * 
 */
package com.nacre.servicei;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;
/**
 * @author Avinash functon add single and multi add ,disply role service
 *         interface
 *
 */
public interface UserManagementServiceI {

	boolean addUserDetails(UserDto udto) throws SQLException, NoConnectionException, DuplicatMobNoException;

	List<UserDto> addUserExcel(List<UserDto> list) throws SQLException, NoConnectionException;

	List<RoleDto> getRole() throws SQLException, ConnectException, ClassNotFoundException, NoConnectionException;

	public List<UserDto> getTeamLeads(String page) throws NoConnectionException, SQLException;
	
	public List<UserDto> getDevelopers() throws NoConnectionException, SQLException;

	public List<UserDto> getProjectManager() throws NoConnectionException, SQLException;
	
	public int assignUser(UserDto udto,String page) throws NoConnectionException, SQLException;
	
	public List<UserDto> getUsers() throws NoConnectionException, SQLException;
	
	public int removeUser(UserDto udto) throws NoConnectionException, SQLException;
	
	public UserDto getUser(UserDto udto) throws NoConnectionException, SQLException;
	
	public int editUser(UserDto udto) throws NoConnectionException, SQLException;
	
	public List<UserDto> getDevelopersBySearch(String search) throws SQLException, NoConnectionException;
	
	public List<UserDto> getProjectManagerBySearch(String search) throws SQLException, NoConnectionException;
	
	public List<UserDto> getUsersBySearch(String search) throws NoConnectionException, SQLException;
	
	public List<UserDto> getTeamLeadsBySearch(String page, String search) throws NoConnectionException, SQLException;

	
}
