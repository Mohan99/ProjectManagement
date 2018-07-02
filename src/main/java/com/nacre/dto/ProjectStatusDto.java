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
public class ProjectStatusDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProjectStatusDto() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer projectStatusId;
	private String statusInfo;
	private ProjectManagerProjectDto projectManagerProjectId;
	private StatusDto seenStatusId;
	private String difficulties;
	private Date updationDate;

	/**
	 * @return the projectStatusId
	 */
	public Integer getProjectStatusId() {
		return projectStatusId;
	}
	/**
	 * @param projectStatusId the projectStatusId to set
	 */
	public void setProjectStatusId(Integer projectStatusId) {
		this.projectStatusId = projectStatusId;
	}
	/**
	 * @return the statusInfo
	 */
	public String getStatusInfo() {
		return statusInfo;
	}
	/**
	 * @param statusInfo the statusInfo to set
	 */
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	/**
	 * @return the projectManagerProjectId
	 */
	public ProjectManagerProjectDto getProjectManagerProjectId() {
		return projectManagerProjectId;
	}
	/**
	 * @param projectManagerProjectId the projectManagerProjectId to set
	 */
	public void setProjectManagerProjectId(ProjectManagerProjectDto projectManagerProjectId) {
		this.projectManagerProjectId = projectManagerProjectId;
	}
	/**
	 * @return the seenStatusId
	 */
	public StatusDto getSeenStatusId() {
		return seenStatusId;
	}
	/**
	 * @param seenStatusId the seenStatusId to set
	 */
	public void setSeenStatusId(StatusDto seenStatusId) {
		this.seenStatusId = seenStatusId;
	}
	/**
	 * @return the difficulties
	 */
	public String getDifficulties() {
		return difficulties;
	}
	/**
	 * @param difficulties the difficulties to set
	 */
	public void setDifficulties(String difficulties) {
		this.difficulties = difficulties;
	}
	/**
	 * @return the updationDate
	 */
	public Date getUpdationDate() {
		return updationDate;
	}
	/**
	 * @param updationDate the updationDate to set
	 */
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectStatusDto [projectStatusId=" + projectStatusId + ", statusInfo=" + statusInfo
				+ ", projectManagerProjectId=" + projectManagerProjectId + ", seenStatusId=" + seenStatusId
				+ ", difficulties=" + difficulties + ", updationDate=" + updationDate + "]";
	}





}
