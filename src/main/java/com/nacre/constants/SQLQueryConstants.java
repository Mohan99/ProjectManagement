package com.nacre.constants;

public class SQLQueryConstants {
	
	/**
	 * @author Raj Kishore Singh
	 * to retrieve all the task details which is not removed
	 */
   public static final String VIEWMODULETASK = "select * from tbl_module_task inner join " + 
   		" tbl_project_module on " + 
   		" tbl_project_module.projectModuleId = tbl_module_task.projectModuleId " + 
   		" where  tbl_module_task.statusId <>? and tbl_project_module.teamLeadId=?";
   
   
   public static final String  VIEW_DEV_TASK ="select * from tbl_module_task mt inner join " + 
   		"tbl_developer_task  dt " + 
   		"on " + 
   		"mt.moduleTaskId =dt.moduleTaskId " + 
   		"where  mt.statusId <>?  and dt.developerId= ?";
   
   /**
	 * @author Raj Kishore Singh
	 *  to retrieve the document 
	 */
  public static final String GETDOCUMENTS = "select taskReferenceDocument,documentNameWithExtension from tbl_module_task WHERE moduleTaskId= ?";
	
  

  
  /**
	 * @author Raj Kishore Singh
	 *   to retrieve the individual row data
	 *
	 *
	 *
	 */
 public static final String VIEWINDIVIDUALMODULETASK = "select moduleTaskId,taskTitle,taskDescription,taskReferenceDocument,documentNameWithExtension,startDate,endDate,projectModuleId,statusId from tbl_module_task where moduleTaskId=?";
 
 
 
 /**
	 * @author Raj Kishore Singh
	 * 
	 * 
	 * to update the records to the database
	 *
	 */
  
 public static final String UPDATETASK="update tbl_module_task set taskTitle=?,taskDescription=?,taskReferenceDocument=?,documentNameWithExtension=?,startDate=?,endDate=? where moduleTaskId=?";
  
 
 
 /**
	 * @author Raj Kishore Singh
	 *
	 * to set the status as removed when remove operation perform
	 *
	 */

public static final String REMOVETASK="update tbl_module_task set statusId=? where moduleTaskId=?";

/**
 * @author Raj Kishore Singh
 *
 * to get the details to  perform operation for view Details
 *
 */
public static final String GET_TASK_INFORMATION = "select  projectTitle,projectDescription,moduleTitle,moduleDescription,taskTitle, taskDescription ,upm.firstName,upm.mobileNo,upm.email,upm.image,utl.firstName,utl.mobileNo,utl.email,utl.image,ud.firstName,ud.mobileNo,ud.email,ud.image "+
" from tbl_module_task t   "+
" left outer join  "+
" tbl_developer_task d on d.moduleTaskId=t.moduleTaskId  "+
" left outer join tbl_user ud on d.developerId=ud.userId  "+
" left outer join  "+
" tbl_project_module m on m.projectModuleId=t.projectModuleId  "+
" left outer join  "+
" tbl_user utl on utl.userId=m.teamLeadId  "+

" left outer join tbl_project_manager_project pmp on pmp.projectManagerProjectId=m.projectManagerProjectId  "+
" left outer join tbl_project p on p.projectId=pmp.projectId "+
" left outer join tbl_user upm on upm.userId=pmp.projectManagerId WHERE t.moduleTaskId=?";
//"select  projectTitle,projectDescription,moduleTitle,moduleDescription,taskTitle, taskDescription ,upm.firstName,upm.mobileNo,upm.email,upm.image,utl.firstName,utl.mobileNo,utl.email,utl.image,ud.firstName,ud.mobileNo,ud.email,ud.image from tbl_module_task t  left outer join tbl_developer_task d on d.moduleTaskId=t.moduleTaskId left outer join tbl_user ud on d.developerId=ud.userId left outer join tbl_project_module m on m.projectModuleId=t.projectModuleId left outer join tbl_user utl on utl.userId=m.teamLeadId left outer join tbl_project p on p.projectId=m.projectManagerProjectId left outer join tbl_project_manager_project pmp on pmp.projectManagerProjectId=p.projectId left outer join tbl_user upm on upm.userId=pmp.projectManagerId WHERE t.moduleTaskId=?";
 




/**
 * @author Raj Kishore Singh
 *
 * to get the details of taskReferenceDocument and documentNameWithExtension
 *
 */
public static final String GET_TASK_DOCUMENT = "select taskReferenceDocument,documentNameWithExtension from tbl_module_task where moduleTaskId=?";
 







 
 
public static final String MODULE_REPORT_QUERY = "select tbl_project_module.moduleTitle,tbl_project_module.moduleDescription,tbl_project_module.startDate,tbl_project_module.endDate,tbl_project_module.moduleCompletionPercent,tbl_user.firstName,tbl_status.`status` from tbl_project_module join tbl_user on tbl_user.userId=tbl_project_module.teamLeadId join tbl_project_manager_project on tbl_project_manager_project.projectManagerProjectId = tbl_project_module.projectManagerProjectId join tbl_status on tbl_project_module.statusId=tbl_status.statusId";
public static final String MODULE_REPORT_QUERY_ON_DATE = "select tbl_project_module.moduleTitle,tbl_project_module.moduleDescription,tbl_project_module.startDate,tbl_project_module.endDate,tbl_project_module.moduleCompletionPercent,tbl_user.firstName,tbl_status.`status` from tbl_project_module join tbl_user on tbl_user.userId=tbl_project_module.teamLeadId join tbl_project_manager_project on tbl_project_manager_project.projectManagerProjectId = tbl_project_module.projectManagerProjectId join tbl_status on tbl_project_module.statusId=tbl_status.statusId where tbl_project_module.startDate=? and tbl_project_module.endDate=?";
public static final String INSERT = "INSERT INTO TBL_TASK_STATUS( statusInfo, dificulties, updationDate, seenStatusId, developerTaskId) VALUES(?, ?, ?,?,?)";

	public static final String INSERTMODULE_STATUS = "INSERT INTO TBL_MODULE_STATUS(statusInfo,difficulties, updationDate , seenStatusId ,moduleTaskId) VALUES(?,?,?,?,?)";

	public static final String INSERTPROJECT_STATUS = "INSERT INTO TBL_PROJECT_STATUS(statusInfo, difficulties, updationDate,projectManagerProjectId , seenStatusId ) VALUES(?,?,?,(select tbl_project_manager_project.projectManagerProjectId from "+
" tbl_project_manager_project "+
" inner join "+
" tbl_user "+
" on "+ 
" tbl_user.userId=tbl_project_manager_project.projectManagerId "+
" where tbl_project_manager_project.projectId=? and tbl_project_manager_project.projectManagerId=?),?)";

	public static final String PercentageTaskQuery = "update tbl_task_status T INNER JOIN tbl_developer_task T1 "
			+ "ON T.developerTaskId=T1.developerTaskId, tbl_developer_task T2 INNER JOIN tbl_module_task T3 "
			+ "ON  T2.moduleTaskId =T3.moduleTaskId set T3.taskCompletionPercentage=? " + "where T1.developerTaskId=?";
		
	
	/*public static final String task_query="SELECT tbl_user.userId,tbl_user.firstName,tbl_module_task.moduleTaskId,tbl_module_task.taskTitle, tbl_module_task.startDate,tbl_module_task.endDate,tbl_module_task.taskCompletionPercentage FROM tbl_module_task JOIN tbl_developer_task  ON tbl_module_task.moduleTaskId=tbl_developer_task.moduleTaskId JOIN tbl_user ON tbl_user.userId=tbl_developer_task.developerId WHERE tbl_user.userId=? ";

	public static final String developerIDQuery="SELECT tbl_user.userId,tbl_user.firstName,tbl_module_task.moduleTaskId,tbl_module_task.taskTitle,  tbl_module_task.startDate,tbl_module_task.endDate,tbl_module_task.taskCompletionPercentage  FROM tbl_module_task JOIN tbl_developer_task   ON tbl_module_task.moduleTaskId=tbl_developer_task.moduleTaskId  JOIN tbl_user ON tbl_user.userId=tbl_developer_task.developerId WHERE tbl_developer_task.developerId=?";
	
	
public final static String  tl_module_query="SELECT tbl_user.userId,tbl_user.firstName,tbl_module_task.moduleTaskId,tbl_module_task.taskTitle,  tbl_module_task.startDate,tbl_module_task.endDate,tbl_module_task.taskCompletionPercentage  FROM tbl_module_task JOIN tbl_developer_task   ON tbl_module_task.moduleTaskId=tbl_developer_task.moduleTaskId  JOIN tbl_user ON tbl_user.userId=tbl_developer_task.developerId WHERE  tbl_module_task.moduleTaskId=?";
*/

	/**
	 * @author pawan
	 */
	public static final String NOTIFICATION_REGARDING_MODULE_STATUS = "select ms.projectModuleId,pm.moduleTitle,ms.difficulties,ms.updationDate "
			+ " from tbl_module_status ms join tbl_project_module pm on ms.projectModuleId = " 
			+ " pm.projectModuleId "
			+ " join tbl_project_manager_project pmp on pmp.projectManagerProjectId = pm.projectManagerProjectId "
			+ " join tbl_user u on u.userId = pmp.projectManagerId " 
			+ " join tbl_status s on s.statusId=ms.seenStatusId "
			+ " where u.userId =? and ms.seenStatusId=?";
	/**
	 * @author Avej
	 */

	
	//
	/**
	 * @author ankush
	 * Based on Project Module Id retrive the data in database
	 */
	public static final String TASK_REPORT_MODULE_ID="SELECT tbl_user.userId,tbl_user.firstName,tbl_module_task.moduleTaskId,tbl_module_task.taskTitle,  tbl_module_task.startDate,tbl_module_task.endDate,tbl_module_task.taskCompletionPercentage  FROM tbl_module_task JOIN tbl_developer_task   ON tbl_module_task.moduleTaskId=tbl_developer_task.moduleTaskId  JOIN tbl_user ON tbl_user.userId=tbl_developer_task.developerId WHERE  tbl_module_task.projectModuleId=?";


/**
 * @author Avej
 * 
 */
	public static final String GET_PROJECT_REPORT = "SELECT PM.PROJECTMANAGERPROJECTID,U.USERID,U.FIRSTNAME,U.LASTNAME,P.PROJECTID,P.PROJECTTITLE,P.PROJECTDESCRIPTION,P.PROJECTREFERENCEDOCUMENT,P.CLIENTLOCATIONSID,P.EXPECTEDSTARTDATE,P.EXPECTEDENDDATE,P.PROJECTCOMPLETIONPERCENTAGE,P.DOCUMENTNAMEWITHEXTENSION FROM TBL_USER U INNER JOIN TBL_PROJECT_MANAGER_PROJECT PM ON U.USERID=PM.PROJECTMANAGERID INNER JOIN TBL_PROJECT P ON PM.PROJECTID=P.PROJECTID";
	/**
	 * @author Avej
	 */
	public static final String GET_MODULE_REPORT = "SELECT M.PROJECTMODULEID,M.MODULETITLE,M.MODULEDESCRIPTION,M.MODULEREFERENCEDOCUMENT,M.DOCUMENTNAMEWITHEXTENSION,M.STARTDATE,M.ENDDATE,M.PROJECTMANAGERPROJECTID,M.MODULECOMPLETIONPERCENT,M.TEAMLEADID,U.FIRSTNAME,U.LASTNAME FROM TBL_PROJECT_MANAGER_PROJECT PM INNER JOIN  TBL_PROJECT_MODULE M  ON PM.PROJECTMANAGERPROJECTID=M.PROJECTMANAGERPROJECTID INNER JOIN TBL_USER U ON M.TEAMLEADID=U.USERID WHERE PM.PROJECTID=?";

	/*
	 * @author Avej
	 * */
	
	public static final String GET_PROJECT_REPORT_BASEDON_USERID="SELECT PM.PROJECTMANAGERPROJECTID,U.USERID,U.FIRSTNAME,U.LASTNAME,P.PROJECTID,P.PROJECTTITLE,P.PROJECTDESCRIPTION,P.PROJECTREFERENCEDOCUMENT,P.CLIENTLOCATIONSID,P.EXPECTEDSTARTDATE,P.EXPECTEDENDDATE,P.PROJECTCOMPLETIONPERCENTAGE,P.DOCUMENTNAMEWITHEXTENSION FROM TBL_USER U INNER JOIN TBL_PROJECT_MANAGER_PROJECT PM ON U.USERID=PM.PROJECTMANAGERID INNER JOIN TBL_PROJECT P ON PM.PROJECTID=P.PROJECTID WHERE U.USERID=?";
	
	/*
	 *@author Avej 
	 * 
	 * */
	
	
	public static final String GET_MODULE_REPORT_BASED_TLID = "SELECT M.PROJECTMODULEID,M.MODULETITLE,M.MODULEDESCRIPTION,M.MODULEREFERENCEDOCUMENT,M.DOCUMENTNAMEWITHEXTENSION,M.STARTDATE,M.ENDDATE,M.PROJECTMANAGERPROJECTID,M.MODULECOMPLETIONPERCENT,M.TEAMLEADID,U.FIRSTNAME,U.LASTNAME FROM TBL_PROJECT_MANAGER_PROJECT PM INNER JOIN  TBL_PROJECT_MODULE M  ON PM.PROJECTMANAGERPROJECTID=M.PROJECTMANAGERPROJECTID INNER JOIN TBL_USER U ON M.TEAMLEADID=U.USERID WHERE U.USERID=?";
	
	
	/**
	 * Add Project Information
	 * 
	 * @author kunal
	 * 
	 */
	public static final String ADD_PROJECT_QUERY = "Insert into tbl_project (projecttitle,projectDescription,projectReferenceDocument,clientLocationsId,expectedStartDate,expectedEndDate,projectCompletionPercentage,documentNameWithExtension,statusId) values (?,?,?,?,?,?,?,?,?)";

	/**
	 * kapilraj029 inserting user profile
	 */
	public static final String VIEW_USER_PROFILE = "select tbl_user.userId,tbl_user.firstName,tbl_user.lastName,tbl_user.email,tbl_user.mobileNo,tbl_user.password,tbl_user.gender,tbl_user.image, tbl_country.country,tbl_state.state,tbl_city.city,tbl_address.address,  "
			+ "tbl_role.role,tbl_role.roleId,tbl_address.addressId,tbl_country.countryId,tbl_state.stateId,tbl_city.cityId,tbl_address.pincode from (((((tbl_country inner join tbl_state on tbl_country.countryId=tbl_state.countryId)inner join tbl_city on "
			+ "tbl_state.stateId=tbl_city.stateId) inner join tbl_address on "
			+ "tbl_city.cityId=tbl_address.cityId) right Outer join tbl_user ON "
			+ "tbl_address.addressId=tbl_user.addressId) inner join tbl_role on tbl_user.roleId=tbl_role.roleId) where tbl_user.userid=?";
	/**
	 * kapilraj029 get the userid
	 */
	public static final String VIEW_USER_ID = "SELECT  * FROM TBL_USER WHERE USERID=?";

	/**
	 * kapilraj029 update the user profile
	 */

	public static final String EDIT_USER_PROFILE = "update tbl_user u "+
" set u.firstName = ?,u.lastName =?,u.email=?,u.mobileNo=?,u.gender =?,u.addressId=? "+
" where u.userId=?";
	// public static final String VIEW_USER_ID ="SELECT userid FROM TBL_USER
	// WHERE email=?";

	/**
	 * kapilraj029 update user Image
	 */

	public static final String EDIT_USER_IMAGE = "UPDATE TBL_USER C SET C.IMAGE=? WHERE C.USERID=?";

	// public static final String LOGIN_QUERY = "select from tbl_user where
	// email=? and password=?";

	/**
	 * Assign Project to Project Manager
	 * 
	 * @author kunal
	 * 
	 */
	// Query single data insert
	public static final String INSERT_USER = "insert into tbl_user(tbl_user.firstName,tbl_user.lastName,tbl_user.email,tbl_user.mobileNo,tbl_user.password,tbl_user.gender,tbl_user.roleId,tbl_user.statusId) values(?,?,?,?,?,?,?,?)";
	// Query Multiple Data inset
	public static final String INSERT_USERBBULK = "insert into tbl_user(tbl_user.firstName,tbl_user.email,tbl_user.mobileNo,tbl_user.gender,tbl_user.roleId,tbl_user.password,tbl_user.statusid) values(?,?,?,?,?,?,?)";
	// Disply role
	public static final String DISPLAY_ROLE = "select * from tbl_role";
	public static final String PercentageModuleQuery = " update tbl_project_module set moduleCompletionPercent=? where projectModuleId=?";
	
	
	
	/**
	 * @author SAGAR
	 * Description:Query to get all the users from the database
	 */
	public static final String GET_USERS = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.LASTNAME,TBL_USER.EMAIL,TBL_USER.MOBILENO,TBL_USER.IMAGE,TBL_USER.ROLEID FROM TBL_USER WHERE ROLEID !="
			+ IntegerConstants.ADMIN_ROLEID + " AND STATUSID !=" + IntegerConstants.REMOVE_STATUS;
 
	/**
	 * @author SAGAR
	 * Description: Query to get a user details from DB to edit
	 */
	
	public static final String GET_USER = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.LASTNAME,TBL_USER.EMAIL,TBL_USER.MOBILENO,TBL_USER.IMAGE,TBL_USER.ROLEID FROM TBL_USER WHERE USERID=? ";

	/**
	 * @author SAGAR
	 * Description: Query to Assign users by admin
	 */
	public static final String ASSIGN_USER = "UPDATE TBL_USER SET TBL_USER.SUPERIORID=?  WHERE TBL_USER.USERID=? ";

	/**
	 * @author SAGAR
	 * Description: Query to get all the Team leads to assign for pm
	 */
	 
	public static final String GET_TL_PM = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.TL_ROLEID + " AND SUPERIORID IS NULL";

	/**
	 * @author SAGAR
	 * Description: Query to get all the Team leads to assign developer
	 */
	
	public static final String GET_TL_DEV = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.TL_ROLEID;

	/**
	 * @author SAGAR
	 * Description:  Query to get all the Developers
	 */
	 
	public static final String GET_DEV = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.DEV_ROLEID + " AND SUPERIORID IS NULL ";

	/**
	 * @author SAGAR
	 * Description: Query to get all the PM
	 */
	
	public static final String GET_PM = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.PM_ROLEID;

	
	/**
	 * @author SAGAR
	 * Description: Query to remove a user
	 */
	public static final String REMOVE_USER = "UPDATE TBL_USER SET TBL_USER.STATUSID=" + IntegerConstants.REMOVE_STATUS
			+ " WHERE USERID=?";
	/**
	 * @author SAGAR
	 * Description:  Query to edit a user
	 */
	public static final String EDIT_USER = "UPDATE TBL_USER SET TBL_USER.FIRSTNAME=?,TBL_USER.LASTNAME=?,TBL_USER.EMAIL=?,TBL_USER.MOBILENO=? WHERE  TBL_USER.USERID=?";

	/**
	 * @author SAGAR
	 * Description:  Query to search all users
	 */
	public static final String ALL_USERS_SEARCH = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.LASTNAME,TBL_USER.EMAIL,TBL_USER.MOBILENO,TBL_USER.IMAGE,TBL_USER.ROLEID FROM TBL_USER WHERE ROLEID !="
			+ IntegerConstants.ADMIN_ROLEID + " AND STATUSID !=" + IntegerConstants.REMOVE_STATUS
			+ "  AND SUPERIORID IS NULL AND (TBL_USER.FIRSTNAME LIKE ? OR TBL_USER.MOBILENO LIKE ? OR TBL_USER.EMAIL LIKE ?)";

	/**
	 * @author SAGAR
	 * Description:  Query to search Developer
	 */

	public static final String DEVELOPER_SEARCH = "SELECT TBL_USER.USERID ,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER  WHERE TBL_USER.ROLEID = "
			+ IntegerConstants.DEV_ROLEID
			+ "  AND SUPERIORID IS NULL AND (TBL_USER.FIRSTNAME LIKE ? OR TBL_USER.MOBILENO LIKE ? OR TBL_USER.EMAIL LIKE ?)";

	/**
	 * @author SAGAR
	 * Description:  Query to search Project manager
	 */
	public static final String PROJECT_MANAGER_SEARCH = "SELECT TBL_USER.USERID ,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER  WHERE TBL_USER.ROLEID = "
			+ IntegerConstants.PM_ROLEID
			+ "  AND SUPERIORID IS NULL AND (TBL_USER.FIRSTNAME LIKE ? OR TBL_USER.MOBILENO LIKE ? OR TBL_USER.EMAIL LIKE ?)";

	/**
	 * @author SAGAR
	 * Description: Query to get all the Team leads to assign developer by search
	 */
	public static final String TL_DEV_SEARCH = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.TL_ROLEID
			+ " AND (TBL_USER.FIRSTNAME LIKE ? OR TBL_USER.MOBILENO LIKE ? OR TBL_USER.EMAIL LIKE ?)";

	/**
	 * @author SAGAR
	 * Description: Query to get all the Team leads to assign for pm by search
	 */
	public static final String TL_PM_SEARCH = "SELECT TBL_USER.USERID,TBL_USER.FIRSTNAME,TBL_USER.EMAIL,TBL_USER.IMAGE FROM TBL_USER WHERE ROLEID="
			+ IntegerConstants.TL_ROLEID
			+ " AND SUPERIORID IS NULL AND (TBL_USER.FIRSTNAME LIKE ? OR TBL_USER.MOBILENO LIKE ? OR TBL_USER.EMAIL LIKE ?)";

	/**
	 * @author SAGAR
	 * Description: Query to get role name
	 */
	public static final String GET_ROLENAME="SELECT ROLE FROM TBL_ROLE WHERE ROLEID=?";
	
	public static final String PercentageProjectQuery=" update tbl_project_status P INNER JOIN tbl_project_manager_project P1 "
			+ "ON P.projectManagerProjectId=P1.projectManagerProjectId,tbl_project_manager_project P2 INNER JOIN tbl_project P3 "
			+ "ON P2.projectId=P3.projectId set P3.projectCompletionPercentage=?" + " where P3.projectId=?";

	public static final String InsertModuleStatus = "insert into tbl_module_status(statusInfo,difficulties,projectModuleId,seenStatusId,updationDate) values(?,?,?,?,?)";
	public static final String getModulePercentage = "select taskCompletionPercentage from tbl_module_task where projectModuleId=?"; 
			
	public static final String getModule = "select * from tbl_project_module where teamLeadId=?";
	public static final String getProjectManagetProjectId = "select projectManagerProjectId from tbl_project_manager_project where projectManagerId=?";
	public static final String getProjectPercentage = "select moduleCompletionPercent from tbl_project_module pm " + 
			" INNER JOIN " + 
			" tbl_project_manager_project pmp " + 
			" on " + 
			" pm.projectManagerProjectId=pmp.projectManagerProjectId " + 
			" where  pmp.projectId=?";
	public static final String getProjectId = "select projectId from tbl_project_manager_project where projectManagerProjectId=?";
	public static final String updateProjectPercentage = "update tbl_project set projectCompletionPercentage=? where projectId=?";
	public static final String getTaskCompletionPercentage = "select taskCompletionPercentage from tbl_module_task where moduleTaskId=(select moduleTaskId from tbl_developer_task where developerTaskId=?)";
	public static final String getAllTaskId = "select developerTaskId from tbl_developer_task where developerId=?";
	public static final String updateTaskPercentage = "update tbl_module_task set taskCompletionPercentage=? where moduleTaskId=(select moduleTaskId from tbl_developer_task where developerTaskId=?)";

	public static final String ASSIGN_PROJECT_QUERY = "Insert into tbl_project_manager_project (decidedstartDate,decidedEndDate,projectId,projectManagerId,statusId) values (?,?,?,?,?)";

	/**
	 * After assigning project to project manager its change the status of an
	 * project
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String UPDATE_PROJECT_STATUS_QUERY = "update tbl_project set statusId = ? where projectId=?";

	/**
	 * Get all the Country
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String COUNTRYLIST = "SELECT countryId,COUNTRY FROM TBL_COUNTRY";

	/**
	 * Get all the State
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String STATELIST = "SELECT STATEID,STATE FROM TBL_STATE WHERE COUNTRYID = ?";

	/**
	 * Get all the City
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String CITYLIST = "SELECT CITYID,CITY FROM TBL_CITY WHERE STATEID = ?";

	/**
	 * Its display all the project that are not assigned to project manager
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String DISPLAY_PROJECT_NOT_ASSIGNED = "SELECT p.projectId,p.projectTitle,p.projectDescription,c.clientName,c.logo,a.address,a.pincode from tbl_project p inner join tbl_client_locations lc on p.clientLocationsId = lc.clientLocationsId join tbl_address a on lc.addressId = a.addressId join tbl_client c on lc.clientId = c.clientId   where  p.statusId = ?  ";

	/**
	 * Its display all the project that are not assigned to project manager
	 * according to Search
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String DISPLAY_PROJECT_NOT_ASSIGNED_SEARCH = "SELECT p.projectId,p.projectTitle,p.projectDescription,c.clientName,c.logo,a.address,a.pincode from tbl_project p inner join tbl_client_locations lc on p.clientLocationsId = lc.clientLocationsId join tbl_address a on lc.addressId = a.addressId join tbl_client c on lc.clientId = c.clientId   where  p.statusId = ? and (c.clientName like ? or p.projectTitle like ?) ";

	/**
	 * Get all the Project Manager
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String DISPLAY_PROJECT_MANAGER = "select u.userId ,u.firstName,u.email,u.mobileNo,u.image from tbl_user u left outer join tbl_address a on u.addressId = a.addressId  where u.roleId ="+IntegerConstants.ROLE_PROJECT_MANAGER;

	/**
	 * Get all the Project Manager
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String DISPLAY_PROJECT_MANAGER_SEARCH = "select u.userId ,u.firstName,u.email,u.mobileNo,u.image from tbl_user u where u.roleId = "
			+ IntegerConstants.ROLE_PROJECT_MANAGER
			+ " and (u.firstName like ? or u.mobileNo like ? or u.email like ?)";

	/**
	 * Add Client Information
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String ADD_CLIENT_QUERY = "Insert into tbl_client (clientName,clientDescription,logo)values (?,?,?)";

	/**
	 * Add Client Address
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String ADD_CLIENT_ADDRESS_QUERY = "Insert into tbl_address (address,pincode,cityId)values (?,?,?)";

	/**
	 * Add Client Address
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String ADD_CLIENT_LOCATION_QUERY = "Insert into tbl_client_locations (addressId,clientId)values (?,?)";

	/**
	 * Add Client Contact person according to client location
	 * 
	 * @author Kunal
	 * 
	 */

	public static final String ADD_CLIENT_CONTACT_PERSON_QUERY = "Insert into tbl_client_contact_person (contactPersonName,email,mobileNo,clientLocationsId)values (?,?,?,?)";

	/**
	 * Display All Client
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String DISPLAY_CLIENT_QUERY = "SELECT lc.clientLocationsId, c.clientName,c.logo,c.clientDescription,a.address,a.pincode,cty.city from tbl_client_locations lc inner join tbl_address a on lc.addressId = a.addressId join  tbl_client c on lc.clientId = c.clientId join tbl_city cty on cty.cityId=a.cityId   ";
	/**
	 * Display All Client According to search condition like client name,
	 * address and city
	 * 
	 * @author Kunal
	 * 
	 */
	public static final String DISPLAY_CLIENT_SEARCH_QUERY = "SELECT lc.clientLocationsId, c.clientName,c.logo,c.clientDescription,a.address,a.pincode,cty.city from tbl_client_locations lc inner join tbl_address a on lc.addressId = a.addressId join  tbl_client c on lc.clientId = c.clientId join tbl_city cty on cty.cityId=a.cityId where  c.clientName like ? or a.address like ? or cty.city like ? ";

	/**
	 * @author Chakravarthi K
	 * 
	 *         GET_MODULE_ID holds VALUE OF SQL query to get the module Id for
	 *         logged in team leader
	 */
	public static final String GET_MODULE_ID = "select tbl_project_module.projectModuleId from tbl_project_module where tbl_project_module.teamLeadId=?";

	/**
	 * @author Chakravarthi K
	 * 
	 *         ADD_TASK holds VALUE OF SQL query to insert values into
	 *         moduleTask table
	 */

	public static final String ADD_TASK = "insert into tbl_module_task(tbl_module_task.taskTitle,tbl_module_task.taskDescription,tbl_module_task.taskReferenceDocument,tbl_module_task.documentNameWithExtension,tbl_module_task.startDate,tbl_module_task.endDate,tbl_module_task.projectModuleId,tbl_module_task.statusId,tbl_module_task.taskCompletionPercentage) values(?,?,?,?,?,?,?,?,?)";

	/**
	 * @author Chakravarthi K
	 * 
	 *         ADD_TASK holds VALUE OF SQL query to insert into developerTask
	 *         table
	 */

	public static final String ASSIGN_TASK_TO_DEVELOPER = "insert into tbl_developer_task (tbl_developer_task.moduleTaskId,tbl_developer_task.developerId,tbl_developer_task.approvalStatusId) values (?,?,?)";

	/**
	 * @author Chakravarthi K
	 * 
	 *         UPDATE_TASK_STATUS holds VALUE OF SQL query to update the status
	 *         of task
	 */

	public static final String UPDATE_TASK_STATUS = "update tbl_developer_task set tbl_developer_task.approvalStatusId=? where tbl_developer_task.moduleTaskId=?";

	/**
	 * @author Chakravarthi K
	 * 
	 *         NOT_ASSIGNED_TASKS holds VALUE OF SQL query to get the tasks that
	 *         are not assigned to any developer
	 */

	public static final String NOT_ASSIGNED_TASKS = "select * from tbl_module_task t1 "+
" inner join "+
" tbl_project_module m  "+
" on  "+
" t1.projectModuleId=m.projectModuleId  "+
" inner join  "+
" tbl_project_manager_project pmp "+
" on "+
" m.projectManagerProjectId = pmp.projectManagerProjectId "+

" inner join  "+
" tbl_project p  "+
" on  "+
" pmp.projectId=p.projectId  "+
" where  "+
" t1.moduleTaskId not in   "+
" (select t.moduleTaskId  from tbl_module_task t "+
" inner join tbl_developer_task d on d.moduleTaskId=t.moduleTaskId) and  "+
" m.teamLeadId=?";

	/**
	 * @author Chakravarthi K
	 * 
	 *         GET_DEVELOPERS holds VALUE OF SQL query to get the developers who
	 *         are having superior as currently logged in team leader
	 */

	public static final String GET_DEVELOPERS = "select u.userId,u.firstName,u.email,u.mobileNo,u.image from tbl_user u where roleId=4 ";

	/*
	 * @author Raghav
	 * 
	 * This is used to All Projects
	 */
	public static final String VIEW_PROJECTS = "select * from tbl_project,tbl_status,tbl_client_locations,tbl_address where tbl_project.statusId=tbl_status.statusId and tbl_project.clientLocationsId=tbl_client_locations.clientLocationsId and tbl_client_locations.addressId=tbl_address.addressId and tbl_project.statusId!=11";

	/*
	 * @author Raghav
	 * 
	 * This is used to get Project by ProjectId
	 */
	public static final String VIEW_PROJECT_BY_ID = "SELECT * FROM TBL_PROJECT,TBL_STATUS WHERE tbl_project.statusId=tbl_status.statusId AND PROJECTID=?";

	/*
	 * @author Raghav
	 * 
	 * This is used to Update the Project details
	 */
	public static final String EDIT_PROJECT_DETAILS_WITH_DOC = "UPDATE TBL_PROJECT SET PROJECTTITLE=?,PROJECTDESCRIPTION=?,PROJECTREFERENCEDOCUMENT=?,CLIENTLOCATIONSID=?,EXPECTEDSTARTDATE=?,expectedEndDate=?,PROJECTCOMPLETIONPERCENTAGE=?,DOCUMENTNAMEWITHEXTENSION=?,STATUSID=? WHERE PROJECTID=?";

	/*
	 * @author Raghav
	 * 
	 * This is used to Update the Project details
	 */
	public static final String EDIT_PROJECT_DETAILS_WITHOUT_DOC = "UPDATE TBL_PROJECT SET PROJECTTITLE=?,PROJECTDESCRIPTION=?,CLIENTLOCATIONSID=?,EXPECTEDSTARTDATE=?,expectedEndDate=?,PROJECTCOMPLETIONPERCENTAGE=?,STATUSID=? WHERE PROJECTID=?";

	/*
	 * @author Raghav
	 * 
	 * This is used to Remove the Project
	 */
	public static final String REMOVE_PROJECT = "UPDATE TBL_PROJECT SET STATUSID=11 WHERE PROJECTID=?";

	public static final String GETTING_INFORMATION_PROJECT = "select * from tbl_project p left outer join tbl_client_locations cl on p.clientLocationsId=cl.clientLocationsId left outer join tbl_client_contact_person ccp on ccp.clientLocationsId=cl.clientLocationsId left outer join tbl_client c on c.clientId=cl.clientId left outer join tbl_project_manager_project tpm on tpm.projectId=p.projectId left outer join tbl_user u on u.userId=tpm.projectManagerId where p.projectId=?";

	/*
	 * @author Raghav
	 * 
	 * This is used to get the Client Location
	 */
	public static final String CLIENT_LOCATION = "select * from tbl_client_locations,tbl_address where tbl_address.addressId=tbl_client_locations.addressId and tbl_address.address=?";

	/**
	 * @author Shradha
	 */
	public static final String LOGIN_QUERY = "SELECT * FROM TBL_USER WHERE EMAIL=? AND PASSWORD=?";
	/**
	 * @author Shradha
	 */
	public static final String FORGET_PASSWORD_QUERY = "SELECT PASSWORD FROM TBL_USER WHERE EMAIL=?";
	/**
	 * @author Shradha
	 */
	public static final String CHANGE_PASSWORD = "UPDATE TBL_USER SET PASSWORD = ? WHERE USERID = ?";

	public static final String MODULE_DETAILS_NOTIFICAION_STATUS = "select p.projectTitle,p.projectDescription,pmng.firstName,pmng.lastName,pmng.email,pmng.mobileNo,pmng.image, pm.moduleTitle,pm.moduleDescription,pm.startDate,pm.endDate,pm.moduleCompletionPercent,tl.firstName,tl.lastName,tl.email,tl.mobileNo,tl.image from tbl_module_status ms join tbl_project_module pm on ms.projectModuleId = pm.projectModuleId join tbl_project_manager_project pmp on pmp.projectManagerProjectId = pm.projectManagerProjectId join tbl_user pmng on pmng.userId = pmp.projectManagerId join tbl_user tl on tl.userId = pm.teamLeadId join tbl_status s on s.statusId=ms.seenStatusId  join tbl_project p on p.projectId = pmp.projectId  where pm.projectModuleId=? and ms.seenStatusId=?";

	
	
/**
 * @author pravin
 */
	public static final String TASK_STATUS_NOTSEEN = "select  mt.moduleTaskId,mt.taskTitle,mt.taskDescription,mt.taskCompletionPercentage,pm.moduleTitle  from tbl_project_module pm   join tbl_status s on (ts.seenStatusId=s.statusId) where s.statusId=?";


/**
 * 	TO GET ALL NOT ASSIGNED MODULES

 * @author pavan kumar y
 */
public static final String GET_MODULES_ASSIGN_TL="select * from tbl_project_module tpm inner join tbl_status ts on tpm.statusId=ts.statusId left outer join tbl_user tu on tpm.teamLeadId=tu.userId"
+" inner join tbl_project_manager_project tpmp "
+" on tpmp.projectManagerProjectId=tpm.projectManagerProjectId inner join tbl_project tp on tpmp.projectId=tp.projectId where tpmp.projectManagerId=? ";
/*
              
/**
* TO VIEW MODULES BY MODULE ID
*
* @author sandip
*/
public static final String VIEW_MODULE_BY_ID="SELECT * FROM tbl_project_module,TBL_STATUS WHERE tbl_project_module.statusId=tbl_status.statusId AND projectModuleId=?";

/**
* To get All team leads
*
* @author pavan kumar y
*/  
public static final String GET_TEAMLEAD="select  u.userId,u.firstName,u.lastName,u.email,u.mobileNo,u.password,u.gender,u.image from tbl_user u inner join tbl_status s on u.statusId=s.statusId inner join tbl_role r on r.roleId=u.roleId  where s.statusId=s.statusId  and r.roleId=? and u.superiorId=?";



/**
* add modules
* @author sandip
*/

public static final String ADDMODULE="INSERT INTO TBL_PROJECT_MODULE (moduleTitle,moduleDescription,"
	+ "moduleReferenceDocument,documentNameWithExtension,startDate,endDate,projectManagerProjectId,"
	+ "statusId) values(?,?,?,?,?,?,?,?)";

/**
* to get project manager project id for add module
* @author sandip
*/
public static final String GET_PROJECTMANAGER_PROJECT_ID = "select tpmp.projectManagerProjectId from  tbl_project_manager_project tpmp  where tpmp.projectManagerId=? and tpmp.projectId=?";

/**
* view all modules
* @author pavan kumar y
*/

public static final String ViewAllModules="select * from tbl_project_module tpm inner join tbl_status ts on tpm.statusId=ts.statusId"
+" inner join tbl_project_manager_project tpmp"
+" on tpmp.projectManagerProjectId=tpm.projectManagerProjectId where tpmp.projectManagerId=? and tpm.statusId !=?";


/**
* to delete modules
* @author sandip
*/

public static final String DeleteModules="update tbl_project_module set tbl_project_module.statusId=11 where tbl_project_module.projectModuleId=?";

/**
* to edit modules
* @author sandip
*/public static final String EDIT_MODULE_DETAILS="UPDATE tbl_project_module TPM SET TPM.moduleTitle=?,TPM.moduleDescription=?,TPM.moduleReferenceDocument=?,TPM.startDate=?,TPM.endDate=?,TPM.moduleCompletionPercent=?,TPM.documentNameWithExtension=? WHERE TPM.projectModuleId=?";


/**
* to assign team lead
* @author pavan kumar y
*/
public static final String   ASSIGN_TEAMLEAD="update tbl_project_module tpm set tpm.teamLeadId=?,tpm.statusId=?  where tpm.projectModuleId=?";

/**
* to view module info
* @author pavan kumar y
*/

public static final String VIEW_MODULE_INFO="select * from tbl_project_module tpm inner join tbl_status ts on tpm.statusId=ts.statusId" 
+" left outer join tbl_user tu on tpm.teamLeadId=tu.userId inner join tbl_project_manager_project tpmp"
+" on tpmp.projectManagerProjectId=tpm.projectManagerProjectId inner join tbl_project tp"
+" on tpmp.projectId=tp.projectId inner join tbl_user tu1 on tpmp.projectManagerId=tu1.userId where  tpm.projectModuleId=?";
public static final String GET_LOGGED_USER = "SELECT * FROM TBL_USER WHERE userid=?";




	
	/**
	 * @author pravin
	 */
	
	 public static final String TASK_STATUS_SEEN = "select mt.moduleTaskId,mt.taskTitle,mt.taskDescription,dt.developerTaskId,"
			
			        + " ts.taskStatusId,ts.statusInfo,ts.updationDate,pm.moduleTitle from tbl_project_module pm " + 
	             
	                " join tbl_module_task mt on pm.projectModuleId=mt.projectModuleId"+
	             
	                " join tbl_developer_task dt on mt.moduleTaskId=dt.moduleTaskId" + 
	             
	                " join tbl_task_status ts on dt.developerTaskId=ts.developerTaskId" + 
	                "	  join tbl_user u "+
					"	  on u.userId = dt.developerId "+
	             
	                " join tbl_status s on (ts.seenStatusId=s.statusId) where s.statusId=? and u.superiorId=?"; 
	
	 /**
	  * @author pravin
	  */
	 public static final String TASK_STATUS_SEEN_DETAILS = 
			 "select p.projectId,p.projectTitle,p.projectDescription,p.projectCompletionPercentage,projmng.firstName,projmng.lastName,projmng.email,projmng.mobileNo,projmng.image, mt.moduleTaskId,mt.taskTitle,dev.firstName,dev.lastName,dev.email,dev.mobileNo,dev.image,mt.taskDescription,mt.taskCompletionPercentage,ts.developerTaskId,ts.taskStatusId, ts.statusInfo,ts.updationDate,pm.projectModuleId, pm.moduleTitle,pm.moduleDescription,pm.moduleCompletionPercent,tl.firstName,tl.lastName,tl.email,tl.mobileNo,tl.image from tbl_project p \r\n" + 
			 "\r\n" + 
			 "join tbl_project_manager_project pmp on p.projectId=pmp.projectId  \r\n" + 
			 "\r\n" + 
			 "join tbl_user projmng on projmng.userId=pmp.projectManagerId\r\n" + 
			 "\r\n" + 
			 "join  tbl_project_module pm  on pm.projectManagerProjectId = pmp.projectManagerProjectId\r\n" + 
			 "\r\n" + 
			 "join tbl_user tl on tl.userId=pm.teamLeadId\r\n" + 
			 "\r\n" + 
			 "join tbl_module_task mt on pm.projectModuleId=mt.projectModuleId\r\n" + 
			 "\r\n" + 
			 "join tbl_developer_task dt on mt.moduleTaskId=dt.moduleTaskId\r\n" + 
			 "\r\n" + 
			 "join tbl_user dev on dev.userId=dt.developerId\r\n" + 
			 "\r\n" + 
			 "join tbl_task_status ts on dt.developerTaskId=ts.developerTaskId\r\n" + 
			 "\r\n" + 
			 "join tbl_status s on (ts.seenStatusId=s.statusId) where s.statusId=? and mt.moduleTaskId=?;";
	 

		/**
		 * @author N.Sravanthi
		 * @use it gives the  all  client   details 
		 */

		public static final String ALL_CLIENT = "select c.clientId, c.clientName,c.clientDescription,c.logo from tbl_client c;";

		/**
		 * @author N.Sravanthi
		 * @use it gives the all client and contact person  details based on given contactPerson mobileNumber
		 */

		public static final String VIEW_CLIENT_Mobileno = ""
				+ "select  c.clientId,c.clientName,c.clientDescription,c.logo,ccp.clientContactPersonId,ccp.contactPersonName,ccp.email,ccp.mobileNo,ccp.clientLocationsId,l.addressId,ad.address,ad.pincode,ad.cityId "
				+ "			 from " + "			 tbl_client c join tbl_client_locations l  on c.clientid=l.clientid"
				+ "	  join tbl_client_contact_person ccp on l.clientLocationsId=ccp.clientLocationsId"
				+ "		 join tbl_address ad on l.addressId= ad.addressId"
				+ "		  where   c.clientId=(select lc.clientId   from tbl_client_locations lc where lc.clientLocationsId= ( select p.clientLocationsId from  tbl_client_contact_person p where   p.mobileNo=?));";

		/**
		 * @author N.Sravanthi
		 * @use it gives the all client and contact person  details based on given client id
		 */

		public static final String VIEW_CLIENT_ID = " select  c.clientId,c.clientName,c.clientDescription,c.logo,ccp.clientContactPersonId,ccp.contactPersonName,ccp.email,ccp.mobileNo,ccp.clientLocationsId,l.addressId,ad.address,ad.pincode,ad.cityId"
				+ " from tbl_client c" + "  join tbl_client_locations l  on c.clientid=l.clientid"
				+ "   join tbl_client_contact_person ccp on l.clientLocationsId=ccp.clientLocationsId"
				+ "	 join tbl_address ad on l.addressId= ad.addressId " + "	  where c.clientid=?";
		/**
		 * @author N.Sravanthi
		 * @use it gives the all client and contact person details based on given  client name or contactPerson name
		 */
		public static final String VIEW_CLIENT_NAME = "select  c.clientId,c.clientName,c.clientDescription,c.logo,ccp.clientContactPersonId,ccp.contactPersonName,ccp.email,ccp.mobileNo,ccp.clientLocationsId,l.addressId,ad.address,ad.pincode,ad.cityId "
				+ "from tbl_client c join tbl_client_locations l on c.clientid=l.clientid"
				+ " join tbl_client_contact_person ccp on l.clientLocationsId=ccp.clientLocationsId "
				+ " join tbl_address ad on l.addressId= ad.addressId "
				+ "			 where c.clientName like ? or c.clientName in(select cc.clientName   from tbl_client cc join tbl_client_locations ll on cc.clientid=ll.clientid"
				+ " join tbl_client_contact_person ccpp on ll.clientLocationsId=ccpp.clientLocationsId  where ccpp.contactPersonName like ?)";


		/**
		 * @author N.Sravanthi
		 * @use it gives count of contactPersons available for specific client based on given client name or contactPerson name
		 */

		
		public static final String FIND_NO_OF_CONTACT_PERSONS="select count(l.clientLocationsId) from tbl_client_locations l where l.clientId=(select  c.clientId from tbl_client c " + 
				"		 			 where c.clientName like ? or c.clientName in(select cc.clientName   from tbl_client cc join tbl_client_locations ll on cc.clientid=ll.clientid " + 
				"		  join tbl_client_contact_person ccpp on ll.clientLocationsId=ccpp.clientLocationsId  where ccpp.contactPersonName like ?) );" + 
				"";
		
		/**
		 * @author N.Sravanthi
		 * @use it gives client details  based on given client name 
		 
		 */

		public static final String CLIENT_DETAILS_NAME = "select c.clientId, c.clientName,c.clientDescription,c.logo from tbl_client c " + 
				"		 			 where c.clientName like ? or c.clientName in(select cc.clientName   from tbl_client cc join tbl_client_locations ll on cc.clientid=ll.clientid " + 
				"		  join tbl_client_contact_person ccpp on ll.clientLocationsId=ccpp.clientLocationsId  where ccpp.contactPersonName like ?)";
		
		/**
		 * 
		 * @author N.Sravanthi
		 * @use it update client details  based on given client details 
		 
		 */
		public static final String EDIT_CLIENT = "update tbl_client c  set  c.clientDescription=? ,c.clientName=? where c.clientId=?";

		/**
		 * @author N.Sravanthi
		 * @use it update client logo  based on given client logo 
		 
		 */
		public static final String EDIT_CLIENT_LOGO = "update tbl_client c  set	c.logo=? where c.clientId=?";

		/**
		 * @author N.Sravanthi
		 * @use it update clientContactPerson details  based on given clientContactPerson new Details and his id 
		 
		 */

		public static final String EDIT_CONTACT_PERSON = "update  tbl_client_locations cl  join tbl_client_contact_person cp on cl.clientLocationsId=cp.clientLocationsId"
				+" join  tbl_address ad on ad.addressId=cl.addressId set cp.contactPersonName=?, cp.email=?,cp.mobileNo=? " 
				+" where  cp.clientContactPersonId=?";
		/**
		 * @author N.Sravanthi
		 * @use it gives addressId of given address
		  */
		public static final String EditClientAddress = "select a.addressId from tbl_address a where a.address=? ";

		/**
		 * @author N.Sravanthi
		  * @use it remove the clientContactPerson  based on given clientContactPerson id
		 */
		public static final String REMOVE_CLIENT_CONTACT_PERSON = "delete from tbl_client_contact_person where clientContactPersonId=?";

		/**
		 * @author N.Sravanthi
		  * @use it will give client location details based on given client id
		 */
		public static final String VIEW_CLIENT_LOCATION_BY_ID ="select a.address,a.pincode,ct.city,l.clientLocationsId  from tbl_address a join tbl_client_locations l  on a.addressId = l.addressId join tbl_city ct on ct.cityId = a.cityId join tbl_client c on c.clientId =l.clientId where c.clientid=?";
		
		/**
		 * @author N.Sravanthi
		  * @use it will give contact person details based on given locationId
		 */
		
		public static final String GET_CONTACT_PERSON_BY_LOCATION= "select p.clientContactPersonId,p.contactPersonName,p.email,p.mobileNo from tbl_client_contact_person p where p.clientLocationsId=?"; 


		/**
		* to get module details
		* @author sindhusha M B
		*/	
public static final String GET_MODULES="select projectModuleId,moduleTitle,moduleDescription,moduleReferenceDocument,documentNameWithExtension,startDate,endDate,teamLeadId from tbl_project_module pm inner join tbl_user u on pm.teamLeadId=u.userId inner join tbl_role r on u.roleId=r.roleId where r.roleId=? and u.userId=?";
/**
* to download doc in modulelist
* @author sindhusha M B
*/
public static final String GET_DOC="select m.moduleReferenceDocument,m.documentNameWithExtension from tbl_project_module m where m.projectModuleId =?";
/**
* to get all info about module
* @author sindhusha M B
*/
public static final String GET_ALL_DETAILS="select p.projectId,p.projectTitle,p.projectDescription,p.expectedStartDate,p.expectedEndDate,pmp.projectManagerProjectId,pmp.projectManagerId,pm.projectModuleId,pm.moduleTitle,pm.ModuleDescription,pm.StartDate,pm.EndDate,pm.teamLeadId,u.userId,u.firstName,u.lastName,u.email,u.mobileNo,u.image,u.gender,r.roleId,us.userId,us.firstName,us.lastName,us.email,us.mobileNo,us.gender,us.image from tbl_project p inner join  tbl_project_manager_project pmp on p.projectId=pmp.projectId inner join tbl_project_module pm  on pmp.projectManagerProjectId=pm.projectManagerProjectId inner join tbl_user u on pm.teamLeadId=u.userId inner join tbl_role r on u.roleId=r.roleId inner join tbl_user us on us.userId=pmp.projectManagerId where pm.projectModuleId=?";
	
	/**
	   * @author Thejaswi
	   * Query is Assigning Project details will be retrieved
	   */

	public static final String ASSIGN_PROJECT_NOTIFICATION="SELECT  p.projectId,p.projectTitle,p.projectDescription,p.projectCompletionPercentage,p.expectedStartDate,p.expectedEndDate,ps.statusInfo,"
	        
			+ "u.firstName,u.email,u.mobileNo,u.image,u.gender FROM tbl_project p "
			
			+ "JOIN tbl_project_manager_project pmp ON (p.projectId = pmp.projectId)"
			
			+ "JOIN tbl_project_status ps ON (pmp.projectManagerProjectId=ps.projectManagerProjectId)"
			
			+ "JOIN tbl_status s ON (p.statusId=s.statusId) "
			
			+ "JOIN tbl_user u ON (pmp.projectManagerId=u.userId) where s.statusId=? and p.projectId=?;";

	
public static final String ASSIGN_ALL_PROJECT_NOTIFICATION="SELECT  p.projectId,p.projectTitle,p.projectDescription,p.projectCompletionPercentage,p.expectedStartDate,p.expectedEndDate,ps.statusInfo,"
	        
			+ "u.firstName,u.email,u.mobileNo,u.image,u.gender FROM tbl_project p "
			
			+ "JOIN tbl_project_manager_project pmp ON (p.projectId = pmp.projectId)"
			
			+ "JOIN tbl_project_status ps ON (pmp.projectManagerProjectId=ps.projectManagerProjectId)"
			
			+ "JOIN tbl_status s ON (p.statusId=s.statusId) "
			
			+ "JOIN tbl_user u ON (pmp.projectManagerId=u.userId) where s.statusId=? and u.userId=?";

	
	/**
	   * @author Thejaswi
	   * Query is Project Status will be retrieved
	   */

	
	public static final String PROJECT_STATUS_NOTIFICATION="select p.projectId,p.projectTitle,p.projectDescription,p.projectCompletionPercentage,p.expectedStartDate,p.expectedEndDate,ps.statusInfo,ps.updationDate,u.firstName,u.email,u.mobileNo,u.image,u.gender,pmp.projectManagerProjectId,ps.statusInfo,ps.updationDate from tbl_project p "
			
			+ "JOIN tbl_project_manager_project pmp ON (p.projectId=pmp.projectId)"
			
			+ "JOIN tbl_project_status ps ON (pmp.projectManagerProjectId=ps.projectManagerProjectId)"
			
			+ "JOIN tbl_status s ON (ps.seenStatusId=s.statusId) "
			
			+ "JOIN tbl_user u ON (pmp.projectManagerId=u.userId) where s.statusId=? and pmp.projectId =?";
	

	/**
	   * @author Thejaswi
	   * Query is Assign Module details will be retrieved
	   */

	
	public static final String ASSIGNED_ALL_MODULE_NOTIFICATION="select tp.projectId,tp.projectTitle,tp.projectDescription,tp.expectedStartDate,tp.expectedEndDate,tp.projectCompletionPercentage, "
			
			+ " tu1.firstName,tu1.email,tu1.mobileNo,tu1.image,tu1.gender,"
			
			+ " tbm.projectModuleId,tbm.moduleTitle,tbm.moduleDescription,tbm.startDate,tbm.endDate,"
			
			+ " tu2.firstName,tu2.email,tu2.mobileNo,tu2.image,tu2.gender from tbl_project_module tbm "
			
			+ " inner join tbl_project_manager_project tbmp on (tbm.projectManagerProjectId=tbmp.projectManagerProjectId)"
			
			+ " inner join tbl_project tp on (tp.projectId=tbmp.projectId)"
			
			+ " inner join tbl_user tu1 on (tu1.userId=tbmp.projectManagerId)"
			
			+ " inner join tbl_user tu2 on (tu2.userId=tbm.teamLeadId)"
			
			+ " inner join tbl_status tbs on (tbm.statusId=tbs.statusId) "
			
			+ " where tbm.teamLeadId=? and tbmp.projectManagerId=? and tbs.statusId=?;";

    
public static final String ASSIGNED_MODULE_NOTIFICATION="select tp.projectId,tp.projectTitle,tp.projectDescription,tp.expectedStartDate,tp.expectedEndDate,tp.projectCompletionPercentage,"
			
			+ "tu1.firstName,tu1.email,tu1.mobileNo,tu1.image,tu1.gender,"
			
			+ "tbm.projectModuleId,tbm.moduleTitle,tbm.moduleDescription,tbm.startDate,tbm.endDate,"
			
			+ "tu2.firstName,tu2.email,tu2.mobileNo,tu2.image,tu2.gender from tbl_project_module tbm "
			
			+ "inner join tbl_project_manager_project tbmp on (tbm.projectManagerProjectId=tbmp.projectManagerProjectId)"
			
			+ "inner join tbl_project tp on (tp.projectId=tbmp.projectId)"
			
			+ "inner join tbl_user tu1 on (tu1.userId=tbmp.projectManagerId)"
			
			+ "inner join tbl_user tu2 on (tu2.userId=tbm.teamLeadId)"
			
			+ "inner join tbl_status tbs on (tbm.statusId=tbs.statusId)"
			
			+ "where tbm.teamLeadId=? and tbmp.projectManagerId=? and tbs.statusId=? and tbm.projectModuleId=? ";


	
	public static final String PROJECT_ALL_STATUS_NOTIFICATION = "select p.projectId,p.projectTitle,p.projectDescription,p.projectCompletionPercentage,p.expectedStartDate,p.expectedEndDate,ps.statusInfo,ps.updationDate,u.firstName,u.email,u.mobileNo,u.image,u.gender,pmp.projectManagerProjectId,ps.statusInfo,ps.updationDate from tbl_project p "
			
			+ "left outer JOIN tbl_project_manager_project pmp ON (p.projectId=pmp.projectId)"
			
			+ " left outer JOIN tbl_project_status ps ON (pmp.projectManagerProjectId=ps.projectManagerProjectId)"
			
			+ "left outer JOIN tbl_status s ON (ps.seenStatusId=s.statusId) "
			
			+ "left outer JOIN tbl_user u ON (pmp.projectManagerId=u.userId) where s.statusId=?";


	public static final String INSERT_ADDRESS = "insert into tbl_address  (address ,pincode,cityId) values  (?,?,?)";


	/**
	 * @author Chakravarthi K
	 * 
	 *    this is used to get tasks assigned to a developer        
	 */

	public static final String VIEW_TASK_BY_DEV_ID = "select *from tbl_module_task t inner join tbl_developer_task d on d.moduleTaskId=t.moduleTaskId where d.developerId=?";
	
	public static final String VIEW_PROJECT_BY_MANAGER ="select * from tbl_project,tbl_project_manager_project where tbl_project.projectId=tbl_project_manager_project.projectId and tbl_project_manager_project.projectManagerId=?";
	
	/**
	 * @author Ankush Vyavhare 
	 *Based on user id display the Developer Task report
	 */
	
	public static final String Developer_Task_Report="select m.taskTitle,m.taskCompletionPercentage,m.startDate, m.endDate from tbl_developer_task d inner join tbl_user u on u.userId = d.developerId join tbl_module_task m on m.moduleTaskId = d.developerTaskId where d.developerId=?"; 
	
	/**
	 * @author Ankush Vyavhare 
	 *Based on TL id display the Developer Task report
	 */
	
	public static final String TL_Module_Report="select pm.moduleTitle,pm.moduleCompletionPercent, pm.projectModuleId,u.firstName,u.lastName  from tbl_project_module pm  inner join tbl_user u on u.userId=pm.teamLeadId where pm.teamLeadId= ?"; 
	
		
public static final String NOTIFICATION_REGARDING_TO_APPROVAL_OF_TASK="select dt.developerTaskId, "+
" mt.moduleTaskId,"+
" developerId,"+
" approvalStatusId,"+
" tu.firstName,"+
" p.projectTitle,"+
" mt.taskTitle,"+
" pm.moduleTitle"+ 
" from  tbl_developer_task dt"+
" inner join tbl_task_status ts "+
" on(dt.developerTaskId=ts.developerTaskId)"+
" inner join tbl_status tst "+
" on(ts.taskStatusId=tst.statusId)"+
" inner join tbl_user tu "+
" on(dt.developerId=tu.userId)"+
" inner join tbl_module_task mt "+
" on (mt.moduleTaskId = dt.moduleTaskId)"+
" inner join tbl_project_module pm "+
" on (pm.projectModuleId = mt.projectModuleId)"+
" inner join tbl_project_manager_project pmgr "+
" on ( pm.projectManagerProjectId = pmgr.projectManagerProjectId)"+
" inner join tbl_project p on "+
" (p.projectId=pmgr.projectId)"+
" where (dt.approvalStatusId=?) and tu.userId=?";
public static final String NOTIFICATION_REGARDING_TO_APPROVE_A_TASK = "select p.projectId, "+
" p.projectTitle, "+
" p.projectDescription, "+
" pm.projectModuleId, "+
" pm.moduleTitle, "+
" pm.moduleDescription , "+
" mt.taskTitle, "+
" mt.taskDescription,  "+
" s.statusId, "+
" s.`status`, "+

" dt.developerTaskId "+
" from  tbl_developer_task dt "+
" inner join tbl_status s "+
" on s.statusId=dt.approvalStatusId "+
" inner join tbl_module_task mt  "+
" on (mt.moduleTaskId = dt.moduleTaskId) "+
" inner join tbl_project_module pm  "+
" on (pm.projectModuleId = mt.projectModuleId) "+
" inner join tbl_project_manager_project pmgr  "+
" on ( pm.projectManagerProjectId = pmgr.projectManagerProjectId) "+
" inner join tbl_project p on  "+
" (p.projectId=pmgr.projectId) "+
" where (dt.approvalStatusId=?) and dt.developerId=?";


public static final String NOTIFICATION_REGARDING_TO_ACCEPTED_OR_REJECTED=" select u.firstName,u.email,u.mobileNo,   p.projectId, "+ 
 " p.projectTitle,  "+
 " p.projectDescription,  "+
 " pm.projectModuleId, "+ 
 " pm.moduleTitle,  "+
 " pm.moduleDescription , "+ 
 " mt.taskTitle,  "+
 " mt.taskDescription, "+ 
 " dt.reasonForRejection, "+
 " s.statusId,  "+
 " s.`status`,  "+

" dt.developerTaskId  "+
" from  tbl_developer_task dt  "+
" INNER JOIN tbl_user u on "+
" u.userId = dt.developerId "+
" inner join tbl_status s  "+
" on s.statusId=dt.approvalStatusId  "+
" inner join tbl_module_task mt   "+
" on (mt.moduleTaskId = dt.moduleTaskId)  "+
" inner join tbl_project_module pm   "+
" on (pm.projectModuleId = mt.projectModuleId)  "+
" inner join tbl_project_manager_project pmgr  "+ 
" on ( pm.projectManagerProjectId = pmgr.projectManagerProjectId)  "+
" inner join tbl_project p on  "+ 
" (p.projectId=pmgr.projectId) "+
" where (dt.approvalStatusId<>?) and u.superiorId=? ";

public static final String NOTIFICATION_REGARDING_TO_APPROVE_A_TASK_DISPLAY=" select "+
" u.firstName DEVNAME, "+
"  u.email DEVEMAIL, "+
" u.mobileNo DEVMOBNO, "+ 
" u.image DEVIMG, "+
" tl.firstName TLNAME, "+
" tl.email TLEMAIL, "+
" tl.mobileNo TLMOBNO, "+
" tl.image TLMIMG, "+
" mgr.firstName PROMGR, "+
" mgr.email PROJMGR, "+
" mgr.mobileNo PROMGR, "+
" mgr.image PROMGR, "+
" p.expectedStartDate, "+
" p.expectedEndDate, "+
" p.projectId,  "+
" p.projectTitle,  "+
" p.projectDescription,  "+
" pm.projectModuleId,  "+
" pm.moduleTitle,  "+
" pm.moduleDescription ,  "+
" mt.taskTitle,  "+
" mt.taskDescription,   "+
" dt.reasonForRejection, "+
" s.statusId,  "+
" s.`status`,  "+

" dt.developerTaskId  "+
" from  tbl_developer_task dt   "+
" INNER JOIN "+
" tbl_user u  "+
" on  "+
" u.userId=dt.developerId "+
" inner join tbl_module_task mt  "+ 
" on (mt.moduleTaskId = dt.moduleTaskId)  "+
" inner join tbl_project_module pm   "+
" on (pm.projectModuleId = mt.projectModuleId)  "+

" inner join "+
" tbl_user tl on "+

" tl.userId= pm.teamLeadId "+
" inner join tbl_project_manager_project pmgr   "+
" on  pm.projectManagerProjectId = pmgr.projectManagerProjectId  "+
" inner join tbl_user mgr "+
" on mgr.userId=pmgr.projectManagerId "+
" inner join tbl_project p on  "+ 
"  p.projectId=pmgr.projectId  "+
" inner join tbl_status s  "+
" on s.statusId=dt.approvalStatusId  "+
" where (dt.approvalStatusId<>?) and u.superiorId=?";
public static final String GET_CMPLETE_TASK_INFO_NOTI =" select  "+
" u.firstName DEVNAME,  "+
"   u.email DEVEMAIL,  "+
"  u.mobileNo DEVMOBNO , "+ 
"  u.image DEVIMG,  "+
"  tl.firstName TLNAME,  "+
"  tl.email TLEMAIL,  "+
"  tl.mobileNo TLMOBNO, "+ 
"  tl.image TLMIMG,  "+
"  mgr.firstName PROMGR,  "+
"  mgr.email PROJMGR,  "+
"  mgr.mobileNo PROMGR,  "+
"  mgr.image PROMGR,  "+
"  p.expectedStartDate,  "+
"  p.expectedEndDate , "+ 
"  p.projectId,   "+
"  p.projectTitle,   "+
"  p.projectDescription,   "+
"  pm.projectModuleId,  "+ 
"  pm.moduleTitle,   "+
"  pm.moduleDescription ,   "+
" mt.taskTitle,   "+
" mt.taskDescription,    "+
" dt.reasonForRejection,  "+
"   s.statusId,   "+
"  s.`status`,   "+

" dt.developerTaskId   "+
" from  tbl_developer_task dt  "+  
" INNER JOIN  "+
"  tbl_user u   "+
"  on   "+
" u.userId=dt.developerId  "+
" inner join tbl_module_task mt   "+
" on (mt.moduleTaskId = dt.moduleTaskId)   "+
" inner join tbl_project_module pm   "+ 
" on (pm.projectModuleId = mt.projectModuleId)  "+ 

"  inner join  "+
" tbl_user tl on  "+

"  tl.userId= pm.teamLeadId  "+
" inner join tbl_project_manager_project pmgr    "+
" on  pm.projectManagerProjectId = pmgr.projectManagerProjectId   "+
" inner join tbl_user mgr  "+
" on mgr.userId=pmgr.projectManagerId  "+
" inner join tbl_project p on  "+ 
"  p.projectId=pmgr.projectId "+  
" inner join tbl_status s  "+
" on s.statusId=dt.approvalStatusId "+  
" where (dt.developerTaskId=?)";

public static final String GET_NOTIFICATION_REGARDING_TO_ACCEPTED_OR_REJECTED_FOR_TL=" select u.firstName,u.email,u.mobileNo, u.image,  p.projectId, "+ 
         
		 " p.projectTitle,  "+
		 " p.projectDescription,  "+
		 " pm.projectModuleId, "+ 
		 " pm.moduleTitle,  "+
		 " pm.moduleDescription , "+ 
		 " mt.taskTitle,  "+
		 " mt.taskDescription, "+ 
		 " dt.reasonForRejection, "+
		 " s.statusId,  "+
		 " s.`status`,  "+

		" dt.developerTaskId  "+
		" from  tbl_developer_task dt  "+
		" INNER JOIN tbl_user u on "+
		" u.userId = dt.developerId "+
		" inner join tbl_status s  "+
		" on s.statusId=dt.approvalStatusId  "+
		" inner join tbl_module_task mt   "+
		" on (mt.moduleTaskId = dt.moduleTaskId)  "+
		" inner join tbl_project_module pm   "+
		" on (pm.projectModuleId = mt.projectModuleId)  "+
		" inner join tbl_project_manager_project pmgr  "+ 
		" on ( pm.projectManagerProjectId = pmgr.projectManagerProjectId)  "+
		" inner join tbl_project p on  "+ 
		" (p.projectId=pmgr.projectId) "+
		" where (dt.approvalStatusId=? or dt.approvalStatusId=?) and u.superiorId=? and dt.developerTaskId=? ";
public static final String GET_NOTIFICATION_ACCEPT_TASK=" select u.firstName,u.email,u.mobileNo, u.image,  p.projectId, "+ 
        
		 " p.projectTitle,  "+
		 " p.projectDescription,  "+
		 " pm.projectModuleId, "+ 
		 " pm.moduleTitle,  "+
		 " pm.moduleDescription , "+ 
		 " mt.taskTitle,  "+
		 " mt.taskDescription, "+ 
		 " dt.reasonForRejection, "+
		 " s.statusId,  "+
		 " s.`status`,  "+

		" dt.developerTaskId  "+
		" from  tbl_developer_task dt  "+
		" INNER JOIN tbl_user u on "+
		" u.userId = dt.developerId "+
		" inner join tbl_status s  "+
		" on s.statusId=dt.approvalStatusId  "+
		" inner join tbl_module_task mt   "+
		" on (mt.moduleTaskId = dt.moduleTaskId)  "+
		" inner join tbl_project_module pm   "+
		" on (pm.projectModuleId = mt.projectModuleId)  "+
		" inner join tbl_project_manager_project pmgr  "+ 
		" on ( pm.projectManagerProjectId = pmgr.projectManagerProjectId)  "+
		" inner join tbl_project p on  "+ 
		" (p.projectId=pmgr.projectId) "+
		" where (dt.approvalStatusId=?) and u.superiorId=? ";

public static final String UPDATE_STATUS="update tbl_developer_task set approvalStatusId = ? where developerTaskId=?";


public static final String EDIT_MODULE_DETAILS_WITHOUT_DOC = "UPDATE tbl_project_module TPM SET TPM.moduleTitle=?,TPM.moduleDescription=?,TPM.startDate=?,TPM.endDate=?,TPM.moduleCompletionPercent=? WHERE TPM.projectModuleId=?";
}
