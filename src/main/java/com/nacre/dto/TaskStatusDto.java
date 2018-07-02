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
public class TaskStatusDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TaskStatusDto() {
		// TODO Auto-generated constructor stub
	}
	

private Integer taskStatusId;
private String statusInfo;
private String difficulties;
private Date updationDate;

private StatusDto seesStatusId;

private DeveloperTaskDto developerTaskId;

/**
 * @return the taskStatusId
 */
public Integer getTaskStatusId() {
	return taskStatusId;
}

/**
 * @param taskStatusId the taskStatusId to set
 */
public void setTaskStatusId(Integer taskStatusId) {
	this.taskStatusId = taskStatusId;
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

/**
 * @return the seesStatusId
 */
public StatusDto getSeesStatusId() {
	return seesStatusId;
}

/**
 * @param seesStatusId the seesStatusId to set
 */
public void setSeesStatusId(StatusDto seesStatusId) {
	this.seesStatusId = seesStatusId;
}

/**
 * @return the developerTaskId
 */
public DeveloperTaskDto getDeveloperTaskId() {
	return developerTaskId;
}

/**
 * @param developerTaskId the developerTaskId to set
 */
public void setDeveloperTaskId(DeveloperTaskDto developerTaskId) {
	this.developerTaskId = developerTaskId;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "TaskStatus [taskStatusId=" + taskStatusId + ", statusInfo=" + statusInfo + ", difficulties=" + difficulties
			+ ", updationDate=" + updationDate + ", seesStatusId=" + seesStatusId + ", developerTaskId="
			+ developerTaskId + "]";
}

	

}
