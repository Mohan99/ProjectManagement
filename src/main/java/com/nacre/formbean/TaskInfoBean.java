package com.nacre.formbean;
/***
 * @author Chakravarthi k
 *         this form bean class id to store task information
 */
public class TaskInfoBean {
	private int moduleTaskId;
	private String taskTitle;
	private String taskDescription;
	private String moduleTitle;
	private String projectTitle;
	public int getModuleTaskId() {
		return moduleTaskId;
	}
	public void setModuleTaskId(int moduleTaskId) {
		this.moduleTaskId = moduleTaskId;
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
	public String getModuleTitle() {
		return moduleTitle;
	}
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
}
