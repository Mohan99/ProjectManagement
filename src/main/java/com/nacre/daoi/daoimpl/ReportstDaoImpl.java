/**
 * 
 */
package com.nacre.daoi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.SQLQueryConstants;
import com.nacre.daoi.ReportsDaoI;
import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;

/**
 * @author Ankush Vyavhare
 * 
 */
public class ReportstDaoImpl implements ReportsDaoI {
Logger logger = Logger.getLogger(ReportstDaoImpl.class);


	/**
	 * @author AVEJ SHAIKH
	 *  method used for Generating project report
	 *  @param 
	 *   userid,userRoleid and connection object
	 * @returns list<ProjectManagerProjectDto>
	@Override
	 */
	public List<ProjectManagerProjectDto> getProjectReportDao(Connection con,Integer useroleid,Integer userid) throws NoConnectionException {
		PreparedStatement ps =null;
		// create list of type ProjectManagerProjectDto
		List<ProjectManagerProjectDto> listprojectManagerprojectDto = new ArrayList<>();
		logger.info("Control inside the  getProjectReportDao() method");
		try {
			
			if(useroleid==IntegerConstants.ROLE_ADMIN){
			// Create preparedStatement Object
			ps = con.prepareStatement(SQLQueryConstants.GET_PROJECT_REPORT);
			}
			else{
				ps = con.prepareStatement(SQLQueryConstants.GET_PROJECT_REPORT_BASEDON_USERID);
				ps.setInt(1, userid);
			}
			// execute query
			ResultSet rs = ps.executeQuery();
			// process resultSet object
			while (rs.next()) {

				// Create Object of ProjectManagerProjectDto
				ProjectManagerProjectDto projectManagerprojectDto = new ProjectManagerProjectDto();
				// Create Object of ProjectDto
				ProjectDto projectDto = new ProjectDto();
				// Create Object of UserDto
				UserDto userdto = new UserDto();

				// Setting values to the ProjectManagerProjectDto
				projectManagerprojectDto.setProjectManagetProjectId(rs.getInt(1));

				userdto.setUserId(rs.getInt(2));
				userdto.setFirstName(rs.getString(3));
				userdto.setLastName(rs.getString(4));

				projectDto.setProjectId(rs.getInt(5));
				projectDto.setProjectTitle(rs.getString(6));
				projectDto.setProjectDescription(rs.getString(7));
				projectDto.setProjectReferenceDocument(rs.getBlob(8));

//				projectDto.setClientLocationId(rs.getInt(9));
				projectDto.setExpectedStartDate(rs.getDate(10));
				projectDto.setExpectedEndDate(rs.getDate(11));
				projectDto.setProjectCompletionPercentage(rs.getDouble((12)));
				projectDto.setDocumetnNameWithExtension(rs.getString(13));

				projectManagerprojectDto.setProjectId(projectDto);
				projectManagerprojectDto.setProjectManagerId(userdto);

				// Adding ProjectManagerProjectDto to the list
				listprojectManagerprojectDto.add(projectManagerprojectDto);
			}
			System.out.println(listprojectManagerprojectDto);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NoConnectionException();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listprojectManagerprojectDto;
	}

	/**
	 * @author AVEJ SHAIKH
	 *  method used for Generating Module report depending on
	 * project id it takes connection object and Project id as a parameter
	 * returns list<ProjectModuleDto>
	 */

	@Override
	public List<ProjectModuleDto> getModuleReportDao(Connection con, Integer projectId,Integer useroleid,Integer userid) throws NoConnectionException {
		
		PreparedStatement ps =null;
		// Create List object of type ProjectModuleDto
		List<ProjectModuleDto> listProjectModuleDto = new ArrayList<ProjectModuleDto>();
		try {
			if(useroleid==IntegerConstants.ROLE_ADMIN || useroleid==IntegerConstants.ROLE_PROJECTMANAGER){
			// Create preparedStatement Object
			 ps = con.prepareStatement(SQLQueryConstants.GET_MODULE_REPORT);
			 logger.debug(ps.toString());
			// set query parameters
			ps.setInt(1, projectId);
			}
			else{
				ps = con.prepareStatement(SQLQueryConstants.GET_MODULE_REPORT_BASED_TLID);
				ps.setInt(1, userid);
			}
			// send and execute query
			ResultSet rs = ps.executeQuery();
			// Process resultSet object
			while (rs.next()) {
				// create Object of ProjectModuleDto
				ProjectModuleDto projectModuleDto = new ProjectModuleDto();

				projectModuleDto.setProjectModuleId(rs.getInt(1));
				projectModuleDto.setModuleTitle(rs.getString(2));
				projectModuleDto.setModuleDescription(rs.getString(3));
				projectModuleDto.setModuleReferenceDocument(rs.getBlob(4));
				projectModuleDto.setDocumentNameWithExtension(rs.getString(5));
				projectModuleDto.setStartDate(rs.getDate(6));
				projectModuleDto.setEndDate(rs.getDate(7));

				// Create of ProjectManagerProjectDto
				ProjectManagerProjectDto ProjectManagerProjectDto = new ProjectManagerProjectDto();
				ProjectManagerProjectDto.setProjectManagetProjectId(rs.getInt(8));
				// Add projectManagerProjectDto to ProjectModuleDto as a has a
				// relationship
				projectModuleDto.setProjectManagetProjectId(ProjectManagerProjectDto);

				projectModuleDto.setModuleCompletionPercent(rs.getFloat(9));
				// Create object of UserDto
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getInt(10));
				userDto.setFirstName(rs.getString(11));
				userDto.setLastName(rs.getString(12));
				// Add UserDto to ProjectModuleDto as a has a relationship
				projectModuleDto.setTeamLeadId(userDto);

				// Add projectModuleDto to list
				listProjectModuleDto.add(projectModuleDto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return the ProjectModuleDto list
		return listProjectModuleDto;
	}
	
	

	/**
	 * @author Ankush Vyavhare
	 *  method used for Generating Module report depending on
	 * module id it takes connection object and module id as a parameter
	 * returns list
	 */
@Override
public List reportTaskDao(Connection conn, ProjectModuleDto dto) throws SQLException {
	
	java.sql.PreparedStatement ps=null;
	List list=null;
	ModuleTaskDto mdto=null;
	ResultSet rs=null;
	UserDto udto=null;
	
	//create preparedstatement object
	ps=conn.prepareStatement(SQLQueryConstants.TASK_REPORT_MODULE_ID);
	
	
	//set  the values
ps.setInt(1, dto.getProjectModuleId());
	
//Execute Query
	rs=ps.executeQuery();
	
//Create arraylist object for storing object
	list=new ArrayList<>();
	
	while(rs.next()){
		
		
		
		 mdto=new ModuleTaskDto();
		
		 udto=new UserDto();
		 
		 
		 udto.setUserId(rs.getInt(1));
		 udto.setFirstName(rs.getString(2));
		
		 mdto.setModuleTaskId(rs.getInt(3));
		mdto.setTaskTitle(rs.getString(4));
		mdto.setStartDate(rs.getDate(5));
		mdto.setEndDate(rs.getDate(6));
		mdto.setTaskCompletionPercent(rs.getFloat(7));
		
		//mdto.setProjectModuleId(dto);
		
	//add object to the list	
		list.add(mdto);
		list.add(udto);
		
		
	
}
	
	return list;
}

/**
 * @author Ankush Vyavhare 
 * method used for Generating Developer Task report depending on user id
 *  it takes user id as a parameter 
 * returns List<ModuleTaskDto>
 */

@Override
	public List<ModuleTaskDto> getReportTaskDeveloper(Connection conn, UserDto u) throws SQLException {
	List<ModuleTaskDto>  list = null;
	ModuleTaskDto dto = null;
	PreparedStatement ps  =null;
	ResultSet rs = null;
	
	ps =conn.prepareStatement(SQLQueryConstants.Developer_Task_Report);
	ps.setInt(1, u.getUserId());
	logger.debug(ps.toString());
	rs = ps.executeQuery();
	list = new ArrayList<>();
	while(rs.next()){
		dto = new ModuleTaskDto();
		
		dto.setTaskTitle(rs.getString(1));
		dto.setTaskCompletionPercent(rs.getFloat(2));
		dto.setStartDate(rs.getDate(3));
		dto.setEndDate(rs.getDate(4));
		list.add(dto);
	}
	
		return list;
	}

/**
 * @author Ankush Vyavhare 
 * method used for Generating Developer Task report depending on user id
 *  it takes user id as a parameter 
 * returns List<ModuleTaskDto>
 */

@Override
	public List<ProjectModuleDto> getReportModuleTL(Connection conn, UserDto u) throws SQLException {
	List<ProjectModuleDto>  list = null;
	ProjectModuleDto dto = null;
	PreparedStatement ps  =null;
	ResultSet rs = null;
	
	ps =conn.prepareStatement(SQLQueryConstants.TL_Module_Report);
	ps.setInt(1, u.getUserId());
	logger.debug(ps.toString());
	rs = ps.executeQuery();
	list = new ArrayList<>();
	UserDto udto = null;
	while(rs.next()){
		dto = new ProjectModuleDto();
		udto = new UserDto();
		dto.setProjectModuleId(rs.getInt(3));
		dto.setModuleTitle(rs.getString(1));
		dto.setModuleCompletionPercent(rs.getFloat(2));
		udto.setFirstName(rs.getString(4));
		udto.setLastName(rs.getString(5));
		dto.setTeamLeadId(udto);
		list.add(dto);
	}
	
		return list;
	}


}
