package com.nacre.formbean;

public class AcceptTask {
	
	private String firstName;
	private String email;
	private String mobileNo;
	private String image;
	private int projectId;
	private String projectTitle;
	private String projectDescription;
	private String projectModuleId;
	private String moduleTitle;
	private String moduleDescription;
	private String taskTitle;
	private String taskDescription;
	private String statusId;
	private String status;
	private String developerTasKId;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	public String getProjectModuleId() {
		return projectModuleId;
	}
	public void setProjectModuleId(String projectModuleId) {
		this.projectModuleId = projectModuleId;
	}
	public String getModuleTitle() {
		return moduleTitle;
	}
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	public String getModuleDescription() {
		return moduleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
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
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeveloperTasKId() {
		return developerTasKId;
	}
	public void setDeveloperTasKId(String developerTasKId) {
		this.developerTasKId = developerTasKId;
	}
	@Override
	public String toString() {
		return "AcceptTask [firstName=" + firstName + ", email=" + email + ", mobileNo=" + mobileNo + ", image=" + image
				+ ", projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDescription="
				+ projectDescription + ", projectModuleId=" + projectModuleId + ", moduleTitle=" + moduleTitle
				+ ", moduleDescription=" + moduleDescription + ", taskTitle=" + taskTitle + ", taskDescription="
				+ taskDescription + ", statusId=" + statusId + ", status=" + status + ", developerTasKId="
				+ developerTasKId + "]";
	}

}
