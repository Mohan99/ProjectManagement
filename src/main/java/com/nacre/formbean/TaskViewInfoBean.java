package com.nacre.formbean;

import com.nacre.dto.ModuleTaskDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectModuleDto;
import com.nacre.dto.UserDto;

/**
 * @author Raj Kishore Singh
 *
 */



public class TaskViewInfoBean {
	
	
	
	private ProjectDto projectDto;
	
	private UserDto projectManager;
	
	private ProjectModuleDto projectModuleDto;
	
	private UserDto teamLeader;
	
	private UserDto developer;
	
	private ModuleTaskDto moduleTaskDto;
	
	
	private String pmImage;
	
	private String tlImage;
	
	private String dImage;

	public ProjectDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}

	public UserDto getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(UserDto projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectModuleDto getProjectModuleDto() {
		return projectModuleDto;
	}

	public void setProjectModuleDto(ProjectModuleDto projectModuleDto) {
		this.projectModuleDto = projectModuleDto;
	}

	public UserDto getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(UserDto teamLeader) {
		this.teamLeader = teamLeader;
	}

	public UserDto getDeveloper() {
		return developer;
	}

	public void setDeveloper(UserDto developer) {
		this.developer = developer;
	}

	public ModuleTaskDto getModuleTaskDto() {
		return moduleTaskDto;
	}

	public void setModuleTaskDto(ModuleTaskDto moduleTaskDto) {
		this.moduleTaskDto = moduleTaskDto;
	}

	public String getPmImage() {
		return pmImage;
	}

	public void setPmImage(String pmImage) {
		this.pmImage = pmImage;
	}

	public String getTlImage() {
		return tlImage;
	}

	public void setTlImage(String tlImage) {
		this.tlImage = tlImage;
	}

	public String getdImage() {
		return dImage;
	}

	public void setdImage(String dImage) {
		this.dImage = dImage;
	}

	@Override
	public String toString() {
		return "TaskViewInfoBean [projectDto=" + projectDto + ", projectManager=" + projectManager
				+ ", projectModuleDto=" + projectModuleDto + ", teamLeader=" + teamLeader + ", developer=" + developer
				+ ", moduleTaskDto=" + moduleTaskDto + ", pmImage=" + pmImage + ", tlImage=" + tlImage + ", dImage="
				+ dImage + ", getProjectDto()=" + getProjectDto() + ", getProjectManager()=" + getProjectManager()
				+ ", getProjectModuleDto()=" + getProjectModuleDto() + ", getTeamLeader()=" + getTeamLeader()
				+ ", getDeveloper()=" + getDeveloper() + ", getModuleTaskDto()=" + getModuleTaskDto()
				+ ", getPmImage()=" + getPmImage() + ", getTlImage()=" + getTlImage() + ", getdImage()=" + getdImage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
