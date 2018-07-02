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
public class ProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public ProjectDto() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer projectId;
	private String projectTitle;
	private String projectDescription;
	private Blob projectReferenceDocument;
	private ClientLocationDto clientLocationId;
	private Date expectedStartDate;
	private Date expectedEndDate;
	private Double projectCompletionPercentage;

	private String documetnNameWithExtension;
	private StatusDto status;
	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectTitle
	 */
	public String getProjectTitle() {
		return projectTitle;
	}
	/**
	 * @param projectTitle the projectTitle to set
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
	 * @param projectDescription the projectDescription to set
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
	 * @param projectReferenceDocument the projectReferenceDocument to set
	 */
	public void setProjectReferenceDocument(Blob projectReferenceDocument) {
		this.projectReferenceDocument = projectReferenceDocument;
	}
	/**
	 * @return the clientLocationId
	 */
	public ClientLocationDto getClientLocationId() {
		return clientLocationId;
	}
	/**
	 * @param clientLocationId the clientLocationId to set
	 */
	public void setClientLocationId(ClientLocationDto clientLocationId) {
		this.clientLocationId = clientLocationId;
	}
	/**
	 * @return the expectedStartDate
	 */
	public Date getExpectedStartDate() {
		return expectedStartDate;
	}
	/**
	 * @param expectedStartDate the expectedStartDate to set
	 */
	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}
	/**
	 * @return the expectedEndDate
	 */
	public Date getExpectedEndDate() {
		return expectedEndDate;
	}
	/**
	 * @param expectedEndDate the expectedEndDate to set
	 */
	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}
	/**
	 * @return the projectCompletionPercentage
	 */
	public Double getProjectCompletionPercentage() {
		return projectCompletionPercentage;
	}
	/**
	 * @param projectCompletionPercentage the projectCompletionPercentage to set
	 */
	public void setProjectCompletionPercentage(Double projectCompletionPercentage) {
		this.projectCompletionPercentage = projectCompletionPercentage;
	}
	/**
	 * @return the documetnNameWithExtension
	 */
	public String getDocumetnNameWithExtension() {
		return documetnNameWithExtension;
	}
	/**
	 * @param documetnNameWithExtension the documetnNameWithExtension to set
	 */
	public void setDocumetnNameWithExtension(String documetnNameWithExtension) {
		this.documetnNameWithExtension = documetnNameWithExtension;
	}
	public StatusDto getStatus() {
		return status;
	}
	public void setStatus(StatusDto status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDescription="
				+ projectDescription + ", projectReferenceDocument=" + projectReferenceDocument + ", clientLocationId="
				+ clientLocationId + ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
				+ ", projectCompletionPercentage=" + projectCompletionPercentage + ", documetnNameWithExtension="
				+ documetnNameWithExtension + "]";
	}
	public void setClientLocationId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public void setProjectCompletionPercentage(float float1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
