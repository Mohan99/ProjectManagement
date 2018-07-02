/**
 * 
 */
package com.nacre.formbean;

import java.io.Serializable;

/**
 * @author anuj
 *
 */
public class NotificationsForDeveloperNewTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String projectTitle;
	private String projectDescription;
	private int projectModuleId;
	private String ModuleTitle;
	private String ModuleDescrption;
	private String taskTitle;
	private String taskDescription;
	private int StatusId;
	private String status;
	private int developerTaskId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public int getProjectModuleId() {
		return projectModuleId;
	}
	public void setProjectModuleId(int projectModuleId) {
		this.projectModuleId = projectModuleId;
	}
	public String getModuleTitle() {
		return ModuleTitle;
	}
	public void setModuleTitle(String moduleTitle) {
		ModuleTitle = moduleTitle;
	}
	public String getModuleDescrption() {
		return ModuleDescrption;
	}
	public void setModuleDescrption(String moduleDescrption) {
		ModuleDescrption = moduleDescrption;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public int getStatusId() {
		return StatusId;
	}
	public void setStatusId(int statusId) {
		StatusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDeveloperTaskId() {
		return developerTaskId;
	}
	public void setDeveloperTaskId(int developerTaskId) {
		this.developerTaskId = developerTaskId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
