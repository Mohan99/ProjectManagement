/**
 * 
 */
package com.nacre.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.CommunicationException;

import org.apache.log4j.Logger;

import com.mysql.*;
import com.nacre.daoi.ModuleManagementDaoI;
import com.nacre.daoi.daoimpl.ModuleManagementDaoImpl;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleBean;
import com.nacre.daoi.daoimpl.ModuleManagementDaoImpl;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleManagementFormBean;
import com.nacre.servicei.ModuleManagementServiceI;
import com.nacre.uitl.PooledConnection;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ModuleManagementServiceImpl implements ModuleManagementServiceI {

public static final Logger logger = 	Logger.getLogger(ModuleManagementServiceImpl.class);


/**
 * method is used for get all modules to assign or change 
 * 			team lead
 * 
 * @author pavan kumar y
 *
 */@Override
public List<ProjectModuleDto> getModulesToAssignTL(Integer projectManagerId) throws SQLException, NoConnectionException {
	List<ProjectModuleDto> list=null;
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	list=mmd.getModulesToAssignTL(con,projectManagerId);
	con.commit();
	con.close();
	return list;
}

 /**
  * method is used for get all taemleads to assign 
  * 			modules
  * 
  * @author pavan kumar y
  *
  */@Override
public List<UserDto> getTeamLeaderDetails(Integer pmId) throws SQLException, NoConnectionException {
	List<UserDto> list=null;
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoI mmd = new ModuleManagementDaoImpl();
	list=mmd.getTeamLeaderDetails(con,pmId);
	con.commit();
	con.close();
	return list;
}


  /**
   * method is used for add the module
   * 
   * @author sandip
   *
   */@Override
public Integer addModule(ProjectModuleDto projectModuleDto) throws ClassNotFoundException, SQLException, NoConnectionException {
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	 Connection con = PooledConnection.getConnection();
	 Integer result=mmd.addModule(projectModuleDto, con);
	con.commit();
	con.close();
	 return result;
	
}

   /**
    * method is used for disply all modules
    * 			
    * 
    * @author pavan kumar y
    *
    */@Override
public List<ProjectModuleDto> viewMOdules(Integer ProjectManagerId) throws SQLException, NoConnectionException {
	List<ProjectModuleDto> list=null;
	 Connection con = PooledConnection.getConnection();
		ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	list=mmd.viewMOdules(con,ProjectManagerId);
	con.commit();
	con.close();
	return list;
}

    /**
     * method is used for get the module ref doc to set refdoc in edit module
     * 
     * @author sandip
     * @throws SQLException 
     *
     */@Override
 public ProjectModuleDto viewModuleById(Integer projectId) throws NoConnectionException, SQLException {
	ProjectModuleDto pdto=null;
	 Connection con = PooledConnection.getConnection();
		ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	
		pdto=mmd.viewModuleById(con, projectId);
		con.commit();
		con.close();
		return pdto;
	
	
}
     /**
      * method is used for delete module
      * 
      * @author sandip
      *
      */@Override
public Boolean deleteModule(Integer projectModuleId) throws NoConnectionException, SQLException {
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	Boolean b = mmd.deleteModule(con,projectModuleId);
	con.commit();
	con.close();
	return b;
}

      /**
       * method is used for update the module
       * 
       * @author sandip
     * @throws SQLException 
       *
       */@Override
public boolean updateModule(ProjectModuleDto pdto) throws NoConnectionException, SQLException {
	boolean flag;
	int count=0;
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	
		count=mmd.updateModule(pdto, con);
		if(count==0)
			flag=false;
		else
			flag=true;
		
		con.commit();
		con.close();
		return flag;
	
}
       /**
        * method is used for assign module to 
        * 			team lead
        * 
        * @author pavan kumar y
        *
        */@Override
public Integer assignTeamlead(ProjectModuleDto pmdto) throws NoConnectionException, SQLException {
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	Integer n=mmd.assignTeamlead(pmdto,con);
	con.commit();
	con.close();
	return n;
}

        /**
         * method is used foor disply module info
         * 		
         * 
         * @author pavan kumar y
         *
         */@Override
public ModuleManagementFormBean viewModuleInfo(Integer moduleId) throws SQLException, NoConnectionException {
	Connection con = PooledConnection.getConnection();
	ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
	ModuleManagementFormBean bean=null;
	bean=mmd.viewModuleInfo(con,moduleId);
	con.commit();
	con.close();
	return bean;
}
         /**
          * to get project manager project id for add module
          * @author sandip
         * @throws NoConnectionException 
          */
          
          @Override
          public 	Integer getProjectManagerProjectId(Integer ProjectManagerID,Integer projectId) throws SQLException, NoConnectionException
 
          {
        		Connection con = PooledConnection.getConnection();
        		ModuleManagementDaoImpl mmd = new ModuleManagementDaoImpl();
        		Integer pmpid=mmd.getProjectManagerProjectId(con, ProjectManagerID, projectId);
        		con.commit();
        		con.close();
        		return pmpid;
    }




/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param connection,userid
 */
@Override
public List<ProjectModuleDto> getModuleDetails(int uid) throws NoConnectionException, SQLException {
	Connection con=PooledConnection.getConnection();
	ModuleManagementDaoI mdao=null;
	mdao=new ModuleManagementDaoImpl();
	con.commit();

	List<ProjectModuleDto> l = 	mdao.getModuleDetails(con, uid);
	con.close();
return l;
}

/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param connection,projectmoduleid
 */
@Override
public ProjectModuleDto viewModuleById(int moduleId) throws NoConnectionException, SQLException {
	Connection con=PooledConnection.getConnection();
	ModuleManagementDaoI mdao=null;
	mdao=new ModuleManagementDaoImpl();
	con.commit();
	

	ProjectModuleDto pmdto=	mdao.viewModuleById(con,moduleId);

	con.close();
	return pmdto;
}

/**
 * @author sindhusha M B
 *@throws SQLEception
 *@return ModuleBean
 *@param connection,projectmoduleid
 */
@Override
public ModuleBean getAllModuleDetails(Integer mid) throws NoConnectionException, SQLException {
	Connection con=PooledConnection.getConnection();
	ModuleManagementDaoI mdao=null;
	mdao=new ModuleManagementDaoImpl();
	con.commit();

	ModuleBean mb=	 mdao.getAllModuleDetails(con, mid);


		con.close();
		return  mb;
}
}
