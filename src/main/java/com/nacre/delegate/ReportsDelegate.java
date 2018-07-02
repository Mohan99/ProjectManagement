/**
 * 
 */
package com.nacre.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.formbean.ModuleReportVo;
import com.nacre.formbean.ProjectReportVo;
import com.nacre.servicei.ReportsServiceI;
import com.nacre.servicei.serviceimpl.ReportsServiceImpl;
import com.nacre.uitl.DateUtil;

/**
 * @author Ankush Vyavhare
 *
 */
public class ReportsDelegate {


	// Create object of ReportsServiceImpl class
	ReportsServiceI reportsServiceI = new ReportsServiceImpl();
	// create object od utilDate class
	DateUtil utilDate = new DateUtil();

	/**
	 * @author AVEJ SHAIKH This method is used to convert
	 *         List<ProjectManagerProjectDto> to list<ProjectReportVo> returns
	 *         list<ProjectReportVo>
	 */

	public List<ProjectReportVo> getProjectReportDelegate(Integer useroleid, Integer userid)
			throws NoConnectionException {
		// Create the list<ProjectReportVo> object
		List<ProjectReportVo> listProjectManagerProjectVo = new ArrayList<>();
		// Create the List<ProjectManagerProjectDto> type variable
		List<ProjectManagerProjectDto> listProjectManagerProjectDto = null;

		// call the getProjectReportService() method
		listProjectManagerProjectDto = reportsServiceI.getProjectReportService(useroleid, userid);

		/**
		 * @author AVEJ SHAIKH Iterate the list of ProjetcManagerProjectDto
		 *         converts the all data type to String and Prepare
		 *         ProjectReportVo
		 */
		for (ProjectManagerProjectDto projectManagerProjectDto : listProjectManagerProjectDto) {
			// create ProjectReportVo object
			ProjectReportVo projectReportVo = new ProjectReportVo();

			// prepare ProjectReportVo object
			projectReportVo.setProjectManagerProjectId(
					String.valueOf((projectManagerProjectDto.getProjectManagetProjectId())));

			projectReportVo.setUserId(String.valueOf(projectManagerProjectDto.getProjectManagerId().getUserId()));
			projectReportVo.setFirstName(projectManagerProjectDto.getProjectManagerId().getFirstName());
			projectReportVo.setLastName(projectManagerProjectDto.getProjectManagerId().getLastName());

			projectReportVo.setProjectId(String.valueOf(projectManagerProjectDto.getProjectId().getProjectId()));
			projectReportVo.setProjectTitle(projectManagerProjectDto.getProjectId().getProjectTitle());
			projectReportVo.setProjectDescription(projectManagerProjectDto.getProjectId().getProjectDescription());
			projectReportVo
					.setProjectReferenceDocument(projectManagerProjectDto.getProjectId().getProjectReferenceDocument());
			projectReportVo
					.setClientLocationId(String.valueOf(projectManagerProjectDto.getProjectId().getClientLocationId()));

			Date dateutilExpectedStart = new Date(
					projectManagerProjectDto.getProjectId().getExpectedStartDate().getTime());
			projectReportVo.setExpectedStartDate(utilDate.sqlDateToString(dateutilExpectedStart));

			if (projectManagerProjectDto.getProjectId().getExpectedEndDate() != null) {
				Date dateutilExpectedEnd = new Date(
						projectManagerProjectDto.getProjectId().getExpectedEndDate().getTime());
				projectReportVo.setExpectedEndDate(utilDate.sqlDateToString(dateutilExpectedEnd));
			}
			projectReportVo.setProjectCompletionPercentage(
					String.valueOf(projectManagerProjectDto.getProjectId().getProjectCompletionPercentage()));
			projectReportVo.setDocumetnNameWithExtension(
					projectManagerProjectDto.getProjectId().getDocumetnNameWithExtension());

			// adding ProjectReportVo to the list
			listProjectManagerProjectVo.add(projectReportVo);
		} // for loop

		System.out.println(listProjectManagerProjectDto);

		System.out.println(listProjectManagerProjectVo);
		// return the list
		return listProjectManagerProjectVo;
	}// method

	/**
	 * @author AVEJ SHAIKH This method is used to convert
	 *         List<ProjectManagerProjectDto> to list<ProjectReportVo> it takes
	 *         project id as parameter returns list<ProjectReportVo>
	 */

	public List<ModuleReportVo> getModuleReportDelegate(String projectId, Integer useroleid, Integer userid)
			throws NoConnectionException {

		int projectid = 0;
		// create List<ProjectModuleDto> type variable
		List<ProjectModuleDto> listProjectModuleDto = null;
		// create List<ModuleReportVo> Object
		List<ModuleReportVo> listModuleReportVo = new ArrayList<>();
		if (projectId != null)
			projectid = Integer.parseInt(projectId);

		// call the getModuleReportService() by passing project id as a
		// parameter
		listProjectModuleDto = reportsServiceI.getModuleReportService(projectid, useroleid, userid);

		/*
		 * @author AVEJ SHAIKH Iterate the list of ProjectModuleDto converts the
		 * all data type to String and Prepare ModuleReportVo object
		 */

		for (ProjectModuleDto projectModuleDto : listProjectModuleDto) {

			// create ModuleReportVo objects
			ModuleReportVo moduleReportVo = new ModuleReportVo();
			// prepare ModuleReportVo object
			moduleReportVo.setProjectModuleId(String.valueOf(projectModuleDto.getProjectModuleId()));
			moduleReportVo.setModuleTitle(projectModuleDto.getModuleTitle());
			moduleReportVo.setModuleCompletionPercent(String.valueOf(projectModuleDto.getModuleCompletionPercent()));
			moduleReportVo.setUserId(String.valueOf(projectModuleDto.getTeamLeadId().getUserId()));
			moduleReportVo.setFirstName(projectModuleDto.getTeamLeadId().getFirstName());
			moduleReportVo.setLastName(projectModuleDto.getTeamLeadId().getLastName());
			// add ModuleReportVo to list
			listModuleReportVo.add(moduleReportVo);

		} // for loop
		return listModuleReportVo;
	}// method

	/**
	 *
	 * @author AVEJ SHAIKH Iterate the list of UserDTO converts the
	 * all data type to String and Prepare object
	 * 
	 */
	public List<UserDto> displayTaskReport(ProjectModuleDto d) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return new ReportsServiceImpl().taskReportService(d);
	}

	
	/**
	 *@author Ankush Vyavhare Iterate the list of  converts the
	 * all data type to String and Prepare ModuleReportVo object
	 * 
	 */
	public List<ModuleTaskDto> displayDevloperTaskReport(UserDto udto) throws SQLException, Exception {
		return new ReportsServiceImpl().getReportTaskDeveloper(udto);
	}
	
	/**
	 *@author Ankush Vyavhare Iterate the list of  converts the
	 * all data type to String and Prepare ModuleReportVo object
	 * 
	 */
	public List<ProjectModuleDto> displayModuleReportReport(UserDto udto) throws SQLException, Exception {
		return new ReportsServiceImpl().getTLModuleReport(udto);
	}


	
}// class
