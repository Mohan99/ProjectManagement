/**
 * 
 */
package com.nacre.formbean;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ProjectReportVo implements Serializable {

	private String ProjectManagerProjectId;

	private String userId;
	private String firstName;
	private String lastName;

	private String projectId;
	private String projectTitle;
	private String projectDescription;
	private Blob projectReferenceDocument;
	private String clientLocationId;
	private String expectedStartDate;
	private String expectedEndDate;
	private String projectCompletionPercentage;
	private String documetnNameWithExtension;

	/**
	 * @return the projectManagerProjectId
	 */
	public String getProjectManagerProjectId() {
		return ProjectManagerProjectId;
	}

	/**
	 * @param projectManagerProjectId
	 *            the projectManagerProjectId to set
	 */
	public void setProjectManagerProjectId(String projectManagerProjectId) {
		ProjectManagerProjectId = projectManagerProjectId;
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

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectTitle
	 */
	public String getProjectTitle() {
		return projectTitle;
	}

	/**
	 * @param projectTitle
	 *            the projectTitle to set
	 */
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	/**
	 * @return the projectDescription
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * @param projectDescription
	 *            the projectDescription to set
	 */
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * @return the projectReferenceDocument
	 */
	public Blob getProjectReferenceDocument() {
		return projectReferenceDocument;
	}

	/**
	 * @param projectReferenceDocument
	 *            the projectReferenceDocument to set
	 */
	public void setProjectReferenceDocument(Blob projectReferenceDocument) {
		this.projectReferenceDocument = projectReferenceDocument;
	}

	/**
	 * @return the clientLocationId
	 */
	public String getClientLocationId() {
		return clientLocationId;
	}

	/**
	 * @param clientLocationId
	 *            the clientLocationId to set
	 */
	public void setClientLocationId(String clientLocationId) {
		this.clientLocationId = clientLocationId;
	}

	/**
	 * @return the expectedStartDate
	 */
	public String getExpectedStartDate() {
		return expectedStartDate;
	}

	/**
	 * @param expectedStartDate
	 *            the expectedStartDate to set
	 */
	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	/**
	 * @return the expectedEndDate
	 */
	public String getExpectedEndDate() {
		return expectedEndDate;
	}

	/**
	 * @param expectedEndDate
	 *            the expectedEndDate to set
	 */
	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	/**
	 * @return the projectCompletionPercentage
	 */
	public String getProjectCompletionPercentage() {
		return projectCompletionPercentage;
	}

	/**
	 * @param projectCompletionPercentage
	 *            the projectCompletionPercentage to set
	 */
	public void setProjectCompletionPercentage(String projectCompletionPercentage) {
		this.projectCompletionPercentage = projectCompletionPercentage;
	}

	/**
	 * @return the documetnNameWithExtension
	 */
	public String getDocumetnNameWithExtension() {
		return documetnNameWithExtension;
	}

	/**
	 * @param documetnNameWithExtension
	 *            the documetnNameWithExtension to set
	 */
	public void setDocumetnNameWithExtension(String documetnNameWithExtension) {
		this.documetnNameWithExtension = documetnNameWithExtension;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectVo [ProjectManagerProjectId=" + ProjectManagerProjectId + ", userId=" + userId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", projectId=" + projectId + ", projectTitle=" + projectTitle
				+ ", projectDescription=" + projectDescription + ", projectReferenceDocument="
				+ projectReferenceDocument + ", clientLocationId=" + clientLocationId + ", expectedStartDate="
				+ expectedStartDate + ", expectedEndDate=" + expectedEndDate + ", projectCompletionPercentage="
				+ projectCompletionPercentage + ", documetnNameWithExtension=" + documetnNameWithExtension + "]";
	}

}
