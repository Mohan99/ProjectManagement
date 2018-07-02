package com.nacre.formbean;

import com.nacre.dto.ProjectModuleDto;

public class ModuleBean {
	
	
private	ProjectModuleDto projectModuleDto;
private String projectId;
private String projectTitle;
private String projectDescription;
private String expectedStartDate;
private String expectedEndDate;
private String projectManagerProjectId;
private String projectManagerId;
private String projectModuleId;
private String moduleTitle;
private String teamLeadId;
private String pmFirstName;
private String pmLastName;
private String pmEmail;
private String pmMobileNo;
private String pmGender;
private String pmImage;
private String pmRoleId;
private String tmUserId;
private String tmFirstName;
private String tmLastName;
private String tmEmail;
private String tmMobileNo;
private String tmGender;
private String tmImage;
public String getProjectId() {
	return projectId;
}
public void setProjectId(String projectId) {
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
public ProjectModuleDto getProjectModuleDto() {
	return projectModuleDto;
}

public void setProjectDescription(String projectDescription) {
	this.projectDescription = projectDescription;
}
public String getExpectedStartDate() {
	return expectedStartDate;
}
public void setExpectedStartDate(String expectedStartDate) {
	this.expectedStartDate = expectedStartDate;
}
public String getExpectedEndDate() {
	return expectedEndDate;
}
public void setExpectedEndDate(String expectedEndDate) {
	this.expectedEndDate = expectedEndDate;
}
public String getProjectManagerProjectId() {
	return projectManagerProjectId;
}
public void setProjectManagerProjectId(String projectManagerProjectId) {
	this.projectManagerProjectId = projectManagerProjectId;
}
public String getProjectManagerId() {
	return projectManagerId;
}
public void setProjectManagerId(String projectManagerId) {
	this.projectManagerId = projectManagerId;
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
public String getTeamLeadId() {
	return teamLeadId;
}
public void setTeamLeadId(String teamLeadId) {
	this.teamLeadId = teamLeadId;
}

public String getPmFirstName() {
	return pmFirstName;
}
public void setPmFirstName(String pmFirstName) {
	this.pmFirstName = pmFirstName;
}
public String getPmLastName() {
	return pmLastName;
}
public void setPmLastName(String pmLastName) {
	this.pmLastName = pmLastName;
}
public String getPmEmail() {
	return pmEmail;
}
public void setPmEmail(String pmEmail) {
	this.pmEmail = pmEmail;
}
public String getPmMobileNo() {
	return pmMobileNo;
}
public void setPmMobileNo(String pmMobileNo) {
	this.pmMobileNo = pmMobileNo;
}
public String getPmGender() {
	return pmGender;
}
public void setPmGender(String pmGender) {
	this.pmGender = pmGender;
}
public String getPmImage() {
	return pmImage;
}
public void setPmImage(String pmImage) {
	this.pmImage = pmImage;
}
public String getPmRoleId() {
	return pmRoleId;
}
public void setPmRoleId(String pmRoleId) {
	this.pmRoleId = pmRoleId;
}
public String getTmUserId() {
	return tmUserId;
}
public void setTmUserId(String tmUserId) {
	this.tmUserId = tmUserId;
}
public String getTmFirstName() {
	return tmFirstName;
}
public void setTmFirstName(String tmFirstName) {
	this.tmFirstName = tmFirstName;
}
public String getTmLastName() {
	return tmLastName;
}
public void setTmLastName(String tmLastName) {
	this.tmLastName = tmLastName;
}
public String getTmEmail() {
	return tmEmail;
}
public void setTmEmail(String tmEmail) {
	this.tmEmail = tmEmail;
}
public String getTmMobileNo() {
	return tmMobileNo;
}
public void setTmMobileNo(String tmMobileNo) {
	this.tmMobileNo = tmMobileNo;
}
public String getTmGender() {
	return tmGender;
}
public void setTmGender(String tmGender) {
	this.tmGender = tmGender;
}
public String getTmImage() {
	return tmImage;
}
public void setTmImage(String tmImage) {
	this.tmImage = tmImage;
}
public void setProjectModuleDto(ProjectModuleDto pmdto) {
	this.projectModuleDto = pmdto;
	
}
@Override
public String toString() {
	return "ModuleBean [projectModuleDto=" + projectModuleDto + ", projectId="
			+ projectId + ", projectTitle=" + projectTitle
			+ ", projectDescription=" + projectDescription
			+ ", expectedStartDate=" + expectedStartDate + ", expectedEndDate="
			+ expectedEndDate + ", projectManagerProjectId="
			+ projectManagerProjectId + ", projectManagerId="
			+ projectManagerId + ", projectModuleId=" + projectModuleId
			+ ", moduleTitle=" + moduleTitle + ", teamLeadId=" + teamLeadId
			+ ", pmFirstName=" + pmFirstName + ", pmLastName=" + pmLastName
			+ ", pmEmail=" + pmEmail + ", pmMobileNo=" + pmMobileNo
			+ ", pmGender=" + pmGender + ", pmImage=" + pmImage + ", pmRoleId="
			+ pmRoleId + ", tmUserId=" + tmUserId + ", tmFirstName="
			+ tmFirstName + ", tmLastName=" + tmLastName + ", tmEmail="
			+ tmEmail + ", tmMobileNo=" + tmMobileNo + ", tmGender=" + tmGender
			+ ", tmImage=" + tmImage + "]";
}


}
