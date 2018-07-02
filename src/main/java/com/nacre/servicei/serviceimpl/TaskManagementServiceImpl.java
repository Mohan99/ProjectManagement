/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.daoi.TaskManagementDaoI;
import com.nacre.daoi.daoimpl.TaskManagementDaoImpl;
import com.nacre.dto.DeveloperTaskDto;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.DatabaseException;
import com.nacre.exception.NoConnectionException;
import com.nacre.exception.NoTaskAvailable;
import com.nacre.formbean.TaskInfoBean;
import com.nacre.formbean.TaskViewInfoBean;
import com.nacre.servicei.TaskManagementServiceI;
import com.nacre.uitl.PooledConnection;
import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class TaskManagementServiceImpl implements TaskManagementServiceI {

	public static final Logger logger = 	Logger.getLogger(TaskManagementServiceImpl.class);
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param Integer
	 *            team lead Id based on which we get moduleId
	 * @return Integer 
	 *              returns value of moduleId
	 *  
	 * @throws SQLException
	 */
	public Integer getModuleID(Integer teamleadId) throws NoConnectionException, SQLException {
		Connection con = null;
		String msg = null;
		Integer moduleId = null;
		// create Connection
		con = PooledConnection.getConnection();

		moduleId = new TaskManagementDaoImpl().getModuleId(con, teamleadId);
		con.commit();
		if (con != null) {
			con.close();
		}
		return moduleId;
	}
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param ModuleTaskDto 
	 *            the task to set
	 * 
	 * @return boolean value true for adding task successfully
	 *                       false when task adding task is not done  
	 *               
	 * @throws SQLException
	 */
	@Override
	public boolean addTask(ModuleTaskDto tDto) throws SQLException, NoConnectionException {
		Connection con = null;
		String msg = null;
		int count = 0;
		// create Connection
		con = PooledConnection.getConnection();

		boolean b = new TaskManagementDaoImpl().addTask(con, tDto);
		

		con.commit();
		if (con != null) {
			con.close();
		}
		return b;
	}
	
	/**
	 * @author Chakravarthi K
	 * 
	 * @param DeveloperTaskDto 
	 *            the developer to set to a particular task
	 * @return Integer
	 * 			 positive value for assigning task to developer successfully
	 *           zero when  assigning task to developer is not done  
	 *               
	 * @throws SQLException
	 */

	public Boolean assignTaskToDeveloper(DeveloperTaskDto pmdto) throws SQLException, NoConnectionException {
		Connection con = null;
		Boolean msg = null;
		int count = 0;
		// create Connection
		con = PooledConnection.getConnection();

		count = new TaskManagementDaoImpl().assignTaskToDeveloper(con, pmdto);

		if (count == 0) {
			msg = false;
			con.rollback();
		} else {
			msg = true;
			con.commit();
		}

		if (con != null) {
			con.close();
		}
		return msg;
	}

	/**
	 * @author Chakravarthi K
	 *            
	 * @return List 
	 * 			   returns list of tasks that are not assigned to any developer  
	 *               
	 * @throws SQLException
	 */

	@Override
	public List<TaskInfoBean> getNotAssignedTasks(Integer teamleadId) throws SQLException, NoConnectionException {
		List<TaskInfoBean> list = null;
		Connection con = null;
		TaskManagementDaoI dao = null;

		// create Connection
		con = PooledConnection.getConnection();

		dao = new TaskManagementDaoImpl();
		list = dao.getNotAssignedTasks(con,teamleadId);

		if (con != null)
			con.close();
		return list;

	}

	/**
	 * @author Chakravarthi K
	 * 
	 * @return List 
	 * 			   returns list of developers who are having superior as currently logged in teamlead 
	 *               
	 * @throws SQLException
	 */

	public List<UserDto> getDevelopers() throws SQLException, NoConnectionException{
		List<UserDto> list = null;
		Connection con = null;
		TaskManagementDaoI dao = null;

		// create Connection
		con = PooledConnection.getConnection();

		dao = new TaskManagementDaoImpl();
		list = dao.getDevelopers(con);

		if (con != null)
			con.close();
		return list;
	}


	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param no parameter
	 * 
	 * @return List
	 *         to get the List type object of ModuleTaskDto
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	
	
	
	@Override
	public List<ModuleTaskDto> viewTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable {
		// TODO Auto-generated method stub
		List<ModuleTaskDto> moduletaskdto=null;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			moduletaskdto=tmdao.viewTaskDao(con,uId);
			con.close();

		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return moduletaskdto;
		
	}
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param no parameter
	 * 
	 * @return List
	 *         to get the List type object of ModuleTaskDto
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	
	
	
	@Override
	public List<DeveloperTaskDto> viewDeveloperTask(Integer uId) throws DatabaseException, SQLException, NoTaskAvailable {
		// TODO Auto-generated method stub
		List<DeveloperTaskDto> moduletaskdto=null;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			moduletaskdto=tmdao.viewDeveloperTaskDao(con,uId);
			con.close();

		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return moduletaskdto;
		
	}
	
	
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return ModuleTaskDto
	 *         to get the ModuleTaskDto type object 
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable      
	 *
	 */
	

	@Override
	public ModuleTaskDto viewIndividualTask(int id) throws DatabaseException, SQLException, NoTaskAvailable {
		ModuleTaskDto moduletaskdto=null;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			moduletaskdto=tmdao.viewIndividualTaskDao(con, id);
			con.close();
				
		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		
		return moduletaskdto;
	}
	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return ModuleTaskDto
	 *         to get the ModuleTaskDto type object for downloading
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable,NoConnectionException     
	 *
	 */
	

	@Override
	public ModuleTaskDto downloadDocument(int id) throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException {
		// TODO Auto-generated method stub
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		Connection con = PooledConnection.getConnection();
		ModuleTaskDto dto = tmdao.downloadDocument(con, id);
		 con.close();
				return dto;
	}

	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param ModuleTaskDto
	 * 
	 * @return Boolean
	 *         to get the boolean type true/false for updatedTaskDetails
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable,NoConnectionException      
	 *
	 */
	
	@Override
	public Boolean updateTaskDetails(ModuleTaskDto mdto)
			throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException {
		boolean result=false;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			 result=tmdao.updateTaskDetails(mdto, con);
				con.close();
		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return result;
	}

	
	

	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return Boolean
	 *         to get the boolean type true/false for removedTaskDetails
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable ,NoConnectionException    
	 *
	 */
	@Override
	public Boolean removeTaskDetails(int id)
			throws DatabaseException, SQLException, NoTaskAvailable, NoConnectionException {
		boolean result=false;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			 result=tmdao.removeDocument(con, id);
				con.close();
				
		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return result;
	}

	
	/**
	 * @author Raj Kishore Singh
	 * 
	 * @param int id
	 * 
	 * @return TaskViewInfoBean
	 *         to get the objects of TaskViewInfoBean
	 *    
	 * @throws  DatabaseException, SQLException, NoTaskAvailable ,NoConnectionException    
	 *
	 */
	
	@Override
	public TaskViewInfoBean viewTaskdetails(int id) throws DatabaseException, SQLException, NoTaskAvailable ,NoConnectionException{
		TaskViewInfoBean bean=null;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			bean=tmdao.viewTaskInfoById(con, id);

			con.close();

		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
catch(SQLException e)
		{
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		
		return bean;
	}

	@Override
	public List<ModuleTaskDto> getTaskDetails(int uid) throws SQLException, NoConnectionException {
		List<ModuleTaskDto> moduletaskdto=null;
		TaskManagementDaoI  tmdao=new TaskManagementDaoImpl();
		
		Connection con = null;
		try {
			con = PooledConnection.getConnection();
			moduletaskdto=tmdao.getTaskDetails(con,uid);
			con.close();

		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
catch(SQLException e)
		{
			e.printStackTrace();
			//throw new DatabaseException(e.getMessage());
		}
		return moduletaskdto;
	}

	
	
}
