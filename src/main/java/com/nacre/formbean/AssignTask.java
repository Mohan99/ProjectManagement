package com.nacre.formbean;

import java.io.Serializable;

public class AssignTask implements Serializable{
	
	@Override
	public String toString() {
		return "AssignTask [DevFirstName=" + DevFirstName + ", Devemail=" + Devemail + ", DevMobileNo=" + DevMobileNo
				+ ", Devimage=, TemledFirstName=" + TemledFirstName + ", Temledemail=" + Temledemail
				+ ", TemledMobileNo=" + TemledMobileNo + ", Temledimage= , PromgrFirstName="
				+ PromgrFirstName + ", Promgremail=" + Promgremail + ", PromgrMobileNo=" + PromgrMobileNo
				+ ", Promgrimage= , ExpectedStartDate=" + ExpectedStartDate + ", ExceptedEndDate="
				+ ExceptedEndDate + ", projectId=" + projectId + ", ProjectTitle=" + ProjectTitle
				+ ", ProjectDescription=" + ProjectDescription + ", projectModuleid=" + projectModuleid
				+ ", moduleTitle=" + moduleTitle + ", ModuleDescription=" + ModuleDescription + ", taskTitle="
				+ taskTitle + ", taskDescription=" + taskDescription + ", StatusId=" + StatusId + ", Status=" + Status
				+ ", devloperTaskId=" + devloperTaskId + "]";
	}
	private String DevFirstName;
	private String Devemail;
	private String DevMobileNo;
	private String Devimage;
	private String TemledFirstName;
	private String Temledemail;
	private String TemledMobileNo;
	private String Temledimage;
	private String PromgrFirstName;
	private String Promgremail;
	private String PromgrMobileNo;
	private String Promgrimage;
	private String ExpectedStartDate;
	private String ExceptedEndDate;
	private String projectId;
	private String ProjectTitle;
	private String ProjectDescription;
	private String projectModuleid;
	private String moduleTitle;
	private String ModuleDescription;
	private String taskTitle;
	private String taskDescription;
	private String StatusId;
	private String Status;
	private String devloperTaskId;
	
	public String getDevloperTaskId() {
		return devloperTaskId;
	}
	public void setDevloperTaskId(String devloperTaskId) {
		this.devloperTaskId = devloperTaskId;
	}
	public String getDevFirstName() {
		return DevFirstName;
	}
	public void setDevFirstName(String devFirstName) {
		DevFirstName = devFirstName;
	}
	public String getDevemail() {
		return Devemail;
	}
	public void setDevemail(String devemail) {
		Devemail = devemail;
	}
	public String getDevMobileNo() {
		return DevMobileNo;
	}
	public void setDevMobileNo(String devMobileNo) {
		DevMobileNo = devMobileNo;
	}
	public String getDevimage() {
		return Devimage;
	}
	public void setDevimage(String devimage) {
		Devimage = devimage;
	}
	public String getTemledFirstName() {
		return TemledFirstName;
	}
	public void setTemledFirstName(String temledFirstName) {
		TemledFirstName = temledFirstName;
	}
	public String getTemledemail() {
		return Temledemail;
	}
	public void setTemledemail(String temledemail) {
		Temledemail = temledemail;
	}
	public String getTemledMobileNo() {
		return TemledMobileNo;
	}
	public void setTemledMobileNo(String temledMobileNo) {
		TemledMobileNo = temledMobileNo;
	}
	public String getTemledimage() {
		return Temledimage;
	}
	public void setTemledimage(String temledimage) {
		Temledimage = temledimage;
	}
	public String getPromgrFirstName() {
		return PromgrFirstName;
	}
	public void setPromgrFirstName(String promgrFirstName) {
		PromgrFirstName = promgrFirstName;
	}
	public String getPromgremail() {
		return Promgremail;
	}
	public void setPromgremail(String promgremail) {
		Promgremail = promgremail;
	}
	public String getPromgrMobileNo() {
		return PromgrMobileNo;
	}
	public void setPromgrMobileNo(String promgrMobileNo) {
		PromgrMobileNo = promgrMobileNo;
	}
	public String getPromgrimage() {
		return Promgrimage;
	}
	public void setPromgrimage(String promgrimage) {
		Promgrimage = promgrimage;
	}
	public String getExpectedStartDate() {
		return ExpectedStartDate;
	}
	public void setExpectedStartDate(String expectedStartDate) {
		ExpectedStartDate = expectedStartDate;
	}
	public String getExceptedEndDate() {
		return ExceptedEndDate;
	}
	public void setExceptedEndDate(String exceptedEndDate) {
		ExceptedEndDate = exceptedEndDate;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectTitle() {
		return ProjectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}
	public String getProjectDescription() {
		return ProjectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}
	public String getProjectModuleid() {
		return projectModuleid;
	}
	public void setProjectModuleid(String projectModuleid) {
		this.projectModuleid = projectModuleid;
	}
	public String getModuleTitle() {
		return moduleTitle;
	}
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	public String getModuleDescription() {
		return ModuleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		ModuleDescription = moduleDescription;
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
		return StatusId;
	}
	public void setStatusId(String statusId) {
		StatusId = statusId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
