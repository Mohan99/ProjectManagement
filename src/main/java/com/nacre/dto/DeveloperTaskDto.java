/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class DeveloperTaskDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DeveloperTaskDto() {
		// TODO Auto-generated constructor stub
	}
	

private Integer developerTaskId;

private String rejectedReason;

/**
 * @return the developerTaskId
 */
public Integer getDeveloperTaskId() {
	return developerTaskId;
}

/**
 * @param developerTaskId the developerTaskId to set
 */
public void setDeveloperTaskId(Integer developerTaskId) {
	this.developerTaskId = developerTaskId;
}

/**
 * @return the rejectedReason
 */
public String getRejectedReason() {
	return rejectedReason;
}

/**
 * @param rejectedReason the rejectedReason to set
 */
public void setRejectedReason(String rejectedReason) {
	this.rejectedReason = rejectedReason;
}

/**
 * @return the moduleTaskId
 */
public ModuleTaskDto getModuleTaskId() {
	return moduleTaskId;
}

/**
 * @param moduleTaskId the moduleTaskId to set
 */
public void setModuleTaskId(ModuleTaskDto moduleTaskId) {
	this.moduleTaskId = moduleTaskId;
}

/**
 * @return the developerId
 */
public UserDto getDeveloperId() {
	return developerId;
}

/**
 * @param developerId the developerId to set
 */
public void setDeveloperId(UserDto developerId) {
	this.developerId = developerId;
}

/**
 * @return the approvalStatusId
 */
public StatusDto getApprovalStatusId() {
	return approvalStatusId;
}

/**
 * @param approvalStatusId the approvalStatusId to set
 */
public void setApprovalStatusId(StatusDto approvalStatusId) {
	this.approvalStatusId = approvalStatusId;
}


private ModuleTaskDto moduleTaskId;

private UserDto developerId;

private StatusDto approvalStatusId;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "DeveloperTaskDto [developerTaskId=" + developerTaskId + ", rejectedReason=" + rejectedReason
			+ ", moduleTaskId=" + moduleTaskId + ", developerId=" + developerId + ", approvalStatusId="
			+ approvalStatusId + "]";
}
}
