/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectManagerProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProjectManagerProjectDto() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer ProjectManagerProjectId;
	private Date decidedStartDate;
	private Date decidedEndDate;
	
	private ProjectDto projectId;
	private UserDto projectManagerId;
	private StatusDto statusid;
	private StatusDto status;
	private StatusDto statusId;

	
	/**
	 * @return the projectManagetProjectId
	 */
	public Integer getProjectManagetProjectId() {
		return ProjectManagerProjectId;
	}
	/**
	 * @param projectManagetProjectId the projectManagetProjectId to set
	 */
	public void setProjectManagetProjectId(Integer projectManagerProjectId) {
		ProjectManagerProjectId = projectManagerProjectId;
	}
	/**
	 * @return the decidedStartDate
	 */
	public Date getDecidedStartDate() {
		return decidedStartDate;
	}
	/**
	 * @param decidedStartDate the decidedStartDate to set
	 */
	public void setDecidedStartDate(Date decidedStartDate) {
		this.decidedStartDate = decidedStartDate;
	}
	/**
	 * @return the decidedEndDate
	 */
	public Date getDecidedEndDate() {
		return decidedEndDate;
	}
	/**
	 * @param decidedEndDate the decidedEndDate to set
	 */
	public void setDecidedEndDate(Date decidedEndDate) {
		this.decidedEndDate = decidedEndDate;
	}
	/**
	 * @return the projectId
	 */
	public ProjectDto getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(ProjectDto projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectManagerId
	 */
	public UserDto getProjectManagerId() {
		return projectManagerId;
	}
	/**
	 * @param projectManagerId the projectManagerId to set
	 */
	public void setProjectManagerId(UserDto projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	
	public StatusDto getStatusid() {
		return statusid;
	}
	public void setStatusid(StatusDto statusid) {
		this.statusid = statusid;
	}
	public Integer getProjectManagerProjectId() {
		return ProjectManagerProjectId;
	}
	public void setProjectManagerProjectId(Integer projectManagerProjectId) {
		ProjectManagerProjectId = projectManagerProjectId;
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
		return "ProjectManagerProjectDto [ProjectManagerProjectId=" + ProjectManagerProjectId + ", decidedStartDate="
				+ decidedStartDate + ", decidedEndDate=" + decidedEndDate + ", projectId=" + projectId
				+ ", projectManagerId=" + projectManagerId + ", statusId=" + status + "]";
	}
	
	
	
	
	

}
