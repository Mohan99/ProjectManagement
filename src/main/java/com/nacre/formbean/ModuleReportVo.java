package com.nacre.formbean;

import java.io.Serializable;

public class ModuleReportVo implements Serializable {

	private String projectModuleId;
	private String moduleTitle;
	private String moduleCompletionPercent;
	private String userId;
	private String firstName;
	private String lastName;

	/**
	 * @return the projectModuleId
	 */
	public String getProjectModuleId() {
		return projectModuleId;
	}

	/**
	 * @param projectModuleId
	 *            the projectModuleId to set
	 */
	public void setProjectModuleId(String projectModuleId) {
		this.projectModuleId = projectModuleId;
	}

	/**
	 * @return the moduleTitle
	 */
	public String getModuleTitle() {
		return moduleTitle;
	}

	/**
	 * @param moduleTitle
	 *            the moduleTitle to set
	 */
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	/**
	 * @return the moduleCompletionPercent
	 */
	public String getModuleCompletionPercent() {
		return moduleCompletionPercent;
	}

	/**
	 * @param moduleCompletionPercent
	 *            the moduleCompletionPercent to set
	 */
	public void setModuleCompletionPercent(String moduleCompletionPercent) {
		this.moduleCompletionPercent = moduleCompletionPercent;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModuleReportVo [projectModuleId=" + projectModuleId + ", moduleTitle=" + moduleTitle
				+ ", moduleCompletionPercent=" + moduleCompletionPercent + ", userId=" + userId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
