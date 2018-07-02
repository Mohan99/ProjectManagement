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
public class ModuleTaskDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public ModuleTaskDto() {
		// TODO Auto-generated constructor stub
	}

	
    private Integer moduleTaskId;
	private String taskTitle;
	private String taskDescription;
	private Blob taskReferenceDocument;
	private String documentNameWithExtension;
	private Date startDate;
	private Date endDate;
	private ProjectModuleDto projectModuleId;
	private StatusDto statusId;
	private Float taskCompletionPercent;
	/**
	 * @return the moduleTaskId
	 */
	public Integer getModuleTaskId() {
		return moduleTaskId;
	}
	/**
	 * @param moduleTaskId the moduleTaskId to set
	 */
	public void setModuleTaskId(Integer moduleTaskId) {
		this.moduleTaskId = moduleTaskId;
	}
	/**
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}
	/**
	 * @param taskTitle the taskTitle to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	/**
	 * @return the taskReferenceDocument
	 */
	public Blob getTaskReferenceDocument() {
		return taskReferenceDocument;
	}
	/**
	 * @param taskReferenceDocument the taskReferenceDocument to set
	 */
	public void setTaskReferenceDocument(Blob taskReferenceDocument) {
		this.taskReferenceDocument = taskReferenceDocument;
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
	 * @return the projectModuleId
	 */
	public ProjectModuleDto getProjectModuleId() {
		return projectModuleId;
	}
	/**
	 * @param projectModuleId the projectModuleId to set
	 */
	public void setProjectModuleId(ProjectModuleDto projectModuleId) {
		this.projectModuleId = projectModuleId;
	}
	/**
	 * @return the statusId
	 */
	public StatusDto getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the taskCompletionPercent
	 */
	public Float getTaskCompletionPercent() {
		return taskCompletionPercent;
	}
	/**
	 * @param taskCompletionPercent the taskCompletionPercent to set
	 */
	public void setTaskCompletionPercent(Float taskCompletionPercent) {
		this.taskCompletionPercent = taskCompletionPercent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModuleTaskDto [moduleTaskId=" + moduleTaskId + ", taskTitle=" + taskTitle + ", taskDescription="
				+ taskDescription + ", taskReferenceDocument=" + taskReferenceDocument + ", documentNameWithExtension="
				+ documentNameWithExtension + ", startDate=" + startDate + ", endDate=" + endDate + ", projectModuleId="
				+ projectModuleId + ", statusId=" + statusId + ", taskCompletionPercent=" + taskCompletionPercent + "]";
	}
	
	
}
