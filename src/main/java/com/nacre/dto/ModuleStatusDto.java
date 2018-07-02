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
public class ModuleStatusDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ModuleStatusDto() {
		// TODO Auto-generated constructor stub
	}
	private Integer moduleStatusId;
	private String statusInfo;
	private String dificulties;
	private ProjectModuleDto projectModuleId;
	
	public ProjectModuleDto getProjectModuleId() {
		return projectModuleId;
	}
	public void setProjectModuleId(ProjectModuleDto projectModuleId) {
		this.projectModuleId = projectModuleId;
	}
	private StatusDto seenStatusId;
	private Date updationDate;
	/**
	 * @return the moduleStatusId
	 */
	public Integer getModuleStatusId() {
		return moduleStatusId;
	}
	/**
	 * @param moduleStatusId the moduleStatusId to set
	 */
	public void setModuleStatusId(Integer moduleStatusId) {
		this.moduleStatusId = moduleStatusId;
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
	 * @return the dificulties
	 */
	public String getDificulties() {
		return dificulties;
	}
	/**
	 * @param dificulties the dificulties to set
	 */
	public void setDificulties(String dificulties) {
		this.dificulties = dificulties;
	}
	/**
	 * @return the moduleTaskId
	 */
	
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
		return "ModuleStatusDto [moduleStatusId=" + moduleStatusId + ", statusInfo=" + statusInfo + ", dificulties="
				+ dificulties + ", moduleTaskId=" + projectModuleId + ", seenStatusId=" + seenStatusId + ", updationDate="
				+ updationDate + "]";
	}
	





}
