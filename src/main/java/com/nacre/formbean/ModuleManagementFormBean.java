package com.nacre.formbean;

import java.sql.Blob;
import java.util.Date;

import com.nacre.dto.AddressDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.RoleDto;
import com.nacre.dto.StatusDto;
import com.nacre.dto.UserDto;

public class ModuleManagementFormBean {
	
	private ProjectModuleDto projectModuleDto;
	private ProjectDto projectDto;
	private StatusDto statusDto;
	private UserDto  userDto;
	private ProjectManagerProjectDto projectManagerProjectDto;
	//user bean
	
	private String name;
	private String fname;
	private String lname;
	private Integer userid;
	private String email;
	private String mobileNo;
	private String image;
	private String pmimage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProjectModuleDto getProjectModuleDto() {
		return projectModuleDto;
	}
	public void setProjectModuleDto(ProjectModuleDto projectModuleDto) {
		this.projectModuleDto = projectModuleDto;
	}
	public ProjectDto getProjectDto() {
		return projectDto;
	}
	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}
	public StatusDto getStatusDto() {
		return statusDto;
	}
	public void setStatusDto(StatusDto statusDto) {
		this.statusDto = statusDto;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public ProjectManagerProjectDto getProjectManagerProjectDto() {
		return projectManagerProjectDto;
	}
	public void setProjectManagerProjectDto(ProjectManagerProjectDto projectManagerProjectDto) {
		this.projectManagerProjectDto = projectManagerProjectDto;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPmimage() {
		return pmimage;
	}
	public void setPmimage(String pmimage) {
		this.pmimage = pmimage;
	}
	
	
	
}
