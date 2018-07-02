/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectModuleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProjectModuleDto() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer projectModuleId;
	
	private String moduleTitle;
	
	private String moduleDescription;
	
	private Blob moduleReferenceDocument;
	
	private String documentNameWithExtension;
	
	
	private Date startDate;
	private Date endDate;
	
	private ProjectManagerProjectDto projectManagetProjectId;
	private UserDto teamLeadId;
	private Float moduleCompletionPercent;
	private StatusDto status;

	private StatusDto sdto;

	/**
	 * @return the projectModuleId
	 */
	public Integer getProjectModuleId() {
		return projectModuleId;
	}
	/**
	 * @param projectModuleId the projectModuleId to set
	 */
	public void setProjectModuleId(Integer projectModuleId) {
		this.projectModuleId = projectModuleId;
	}
	/**
	 * @return the moduleTitle
	 */
	public String getModuleTitle() {
		return moduleTitle;
	}
	/**
	 * @param moduleTitle the moduleTitle to set
	 */
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	/**
	 * @return the moduleDescription
	 */
	public String getModuleDescription() {
		return moduleDescription;
	}
	/**
	 * @param moduleDescription the moduleDescription to set
	 */
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}
	/**
	 * @return the moduleReferenceDocument
	 */
	public Blob getModuleReferenceDocument() {
		return moduleReferenceDocument;
	}
	/**
	 * @param moduleReferenceDocument the moduleReferenceDocument to set
	 */
	public void setModuleReferenceDocument(Blob moduleReferenceDocument) {
		this.moduleReferenceDocument = moduleReferenceDocument;
	}
	/**
	 * @return the documentNameWithExtension
	 */
	public String getDocumentNameWithExtension() {
		return documentNameWithExtension;
	}
	/**
	 * @param documentNameWithExtension the documentNameWithExtension to set
	 */
	public void setDocumentNameWithExtension(String documentNameWithExtension) {
		this.documentNameWithExtension = documentNameWithExtension;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the projectManagetProjectId
	 */
	public ProjectManagerProjectDto getProjectManagetProjectId() {
		return projectManagetProjectId;
	}
	/**
	 * @param projectManagetProjectId the projectManagetProjectId to set
	 */
	public void setProjectManagetProjectId(ProjectManagerProjectDto projectManagetProjectId) {
		this.projectManagetProjectId = projectManagetProjectId;
	}
	/**
	 * @return the teamLeadId
	 */
	public UserDto getTeamLeadId() {
		return teamLeadId;
	}
	/**
	 * @param teamLeadId the teamLeadId to set
	 */
	public void setTeamLeadId(UserDto teamLeadId) {
		this.teamLeadId = teamLeadId;
	}
	/**
	 * @return the moduleCompletionPercent
	 */
	public Float getModuleCompletionPercent() {
		return moduleCompletionPercent;
	}
	/**
	 * @param moduleCompletionPercent the moduleCompletionPercent to set
	 */
	public void setModuleCompletionPercent(Float moduleCompletionPercent) {
		this.moduleCompletionPercent = moduleCompletionPercent;
	}
	public StatusDto getStatus() {
		return status;
	}
	public void setStatus(StatusDto status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectModuleDto [projectModuleId=" + projectModuleId + ", moduleTitle=" + moduleTitle
				+ ", moduleDescription=" + moduleDescription + ", moduleReferenceDocument=" + moduleReferenceDocument
				+ ", documentNameWithExtension=" + documentNameWithExtension + ", startDate=" + startDate + ", endDate="
				+ endDate + ", projectManagetProjectId=" + projectManagetProjectId + ", teamLeadId=" + teamLeadId
				+ ", moduleCompletionPercent=" + moduleCompletionPercent + ", sdto=" + status + "]";
	}
	public void setStatusId(StatusDto sdto) {
		// TODO Auto-generated method stub
		status=sdto;
		
	}
	public StatusDto getStatusId() {
		// TODO Auto-generated method stub
		return status;
	}
	
	

}
