/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.PoolableConnection;
import org.apache.log4j.Logger;

import com.nacre.daoi.UserManagementDaoI;
import com.nacre.daoi.daoimpl.UserManagementDaoImpl;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.constants.MessageConstants;
import com.nacre.constants.StringConstants;
import com.nacre.daoi.UserManagementDaoI;
import com.nacre.daoi.daoimpl.UserManagementDaoImpl;
import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DuplicatMobNoException;
import com.nacre.exception.NoConnectionException;
import com.nacre.servicei.UserManagementServiceI;
import com.nacre.uitl.EmailUtilty;
import com.nacre.uitl.PooledConnection;

public class UserManagementServiceImpl implements UserManagementServiceI {

	public static final Logger logger = Logger.getLogger(UserManagementServiceImpl.class);

	/**
	 * @author Avinash
	 * @Methode:addUserDetails
	 * @parameter:udto
	 * @Exception:SQLException, NoConnectionException, DuplicatMobNoException
	 *                          this method is used for add and EmailUtility
	 *                          clss call sendEmail methodesent the Email
	 */

	// Add single User
	public boolean addUserDetails(UserDto udto) throws SQLException, NoConnectionException, DuplicatMobNoException {
		int count = 0;
		boolean b = false;
		UserManagementDaoI umdao = new UserManagementDaoImpl();
		Connection conn = PooledConnection.getConnection();
		{
			try {
				count = umdao.addUserDetails(udto, conn);
				if (count == 1) {
					
					System.out.println("User Add");

					// Sent the Username and password in mail
					b = EmailUtilty.sendEmail(udto.getEmail(), "ACCESS GRANTED FOR  PROJECT MANEGMENT APP",
							"HI Dear "+  " " + udto.getFirstName() + "   " +"YOUR CREDIENTIALS FOR PROJECT MANAGEMENT ARE  USERNAME : " + udto.getEmail()
									+" ,  PASSWORD :" + udto.getPassword());

					if(b){
						conn.commit();
					}
					// b = true;
				} else {
					conn.rollback();
					b = false;
				}
				return b;

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
		return false;

	}

	/**
	 * @author Avinash
	 * @Methode:addUserExcel
	 * @parameter:list
	 * @exception:SQLException, NoConnectionException
	 *                              this method is used for add multi and
	 *                              EmailUtility clss call sendEmail methodesent
	 *                              the Email
	 */
	public List<UserDto> addUserExcel(List<UserDto> list) throws SQLException, NoConnectionException {

		List<UserDto> invalidEmails = new ArrayList<UserDto>();
		int[] count = null;
		UserManagementDaoI umdao = new UserManagementDaoImpl();
		Connection conn = PooledConnection.getConnection();
		{
			try {
				count = umdao.bulkAddUser(list, conn);

				if (count != null) {

					//conn.commit();
					for (int i = 0; i < count.length; i++) {

						if (count[i] == 1) {
							UserDto udto = list.get(i);
							boolean b = EmailUtilty.sendEmail(udto.getEmail(), "ACCESS GRANTED FOR  PROJECT MANEGMENT APP",
									"HI Dear "+  " " + udto.getFirstName() + "   " +"YOUR  PROJECT MANEGMENT CREDIENTIALS ARE  USERNAME : " + udto.getEmail()
									+ " ,  PASSWORD IS:" + udto.getPassword());
							if(b){
								conn.commit();
							}
							if (!b) {

								invalidEmails.add(udto);

							}
						}

					}
				} else {
					System.out.println("<<<not Inserted");
					conn.rollback();

					invalidEmails = list;
				}

			} catch (SQLException e) {

				invalidEmails = list;
				e.printStackTrace();
				conn.rollback();
			}
		}
		return invalidEmails;
	}

	/**
	 * @author Avinash
	 * @Methode:getRole
	 * @parameter:
	 * @exception:SQLException, ConnectException,
	 *                              ClassNotFoundException,
	 *                              NoConnectionException this methode disply
	 *                              the role
	 */

	public List<RoleDto> getRole()
			throws SQLException, ConnectException, ClassNotFoundException, NoConnectionException {
		UserManagementDaoI umdao = new UserManagementDaoImpl();
		Connection conn = PooledConnection.getConnection();

		return umdao.displyRole(conn);
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeads()
	 * PARAMS  : STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getTeamLeads(String page) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getTeamLeads(con,page);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopers()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getDevelopers() throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getDevelopers(con);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManager()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	@Override
	public List<UserDto> getProjectManager() throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getProjectManager(con);
		
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : assignUser()
	 * PARAMS  : UserDto OBJECT,STRING VALUE CONTAINS REQUEST JSP PAGE NAME
	 * RETURNS : INT VALUE
	 */
	@Override
	public int assignUser(UserDto udto,String page) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.assignUser(udto,con,page);
	}
	
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUsers()
	 * PARAMS  : NONE
	 * RETURNS : List OBJECT OF UserInformationBean TYPE
	 */
	
	@Override
	public List<UserDto> getUsers() throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getUsers(con);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : removeUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE REMOVED
	 * RETURNS : INTEGER VALUE
	 */
	@Override
	public int removeUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.removeUser(udto, con);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE Get
	 * RETURNS : UserDto
	 */
	@Override
	public UserDto getUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getUser(udto, con);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : editUser()
	 * PARAMS  : UserDto OBJECT WHICH USERID TO BE EDITED
	 * RETURNS : INTEGER VALUE
	 */
	@Override
	public int editUser(UserDto udto) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.editUser(udto, con);
	}

	/**
	 * @author SAGARKOMMU
	 * METHOD  : getDevelopersBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	
	@Override
	public List<UserDto> getDevelopersBySearch(String search) throws SQLException, NoConnectionException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getDevelopersBySearch(con,search);
	}
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getProjectManagerBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	@Override
	public List<UserDto> getProjectManagerBySearch(String search) throws SQLException, NoConnectionException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getProjectManagerBySearch(con,search);
	}
		
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getUsersBySearch()
	 * PARAMS  : STRING VALUE TO GET TYPE USER TO SEARCHED
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	@Override
	public List<UserDto> getUsersBySearch(String search) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getUsersBySearch(con,search);
	}
	
	/**
	 * @author SAGARKOMMU
	 * METHOD  : getTeamLeadsBySearch()
	 * PARAMS  : TWO STRING VALUES TO GET TYPE USER TO SEARCHED,JSP PAGE FROM WHERE WE ARE GETTING REQUEST
	 * RETURNS : LIST OF UserInformationBean OBJECTS
	 */	
	@Override
	public List<UserDto> getTeamLeadsBySearch(String page, String search) throws NoConnectionException, SQLException {
		UserManagementDaoI uDao=null;
		Connection con=null;
		uDao=new UserManagementDaoImpl();
		con=PooledConnection.getConnection();
		return uDao.getTeamLeadsBySearch(con,page,search);
	}
}
