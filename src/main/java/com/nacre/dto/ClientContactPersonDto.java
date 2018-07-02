/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ClientContactPersonDto implements Comparable<ClientContactPersonDto>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	private Integer clientContactPersonId;
	
	private String contactPersonName;
	
	private String email;
	
	private String mobileNo;
	
	private ClientLocationDto clientLocationId;
	
	
	
	
	
	
	
	/**
	 * @return the clientContactPersonId
	 */
	public Integer getClientContactPersonId() {
		return clientContactPersonId;
	}

	/**
	 * @param clientContactPersonId the clientContactPersonId to set
	 */
	public void setClientContactPersonId(Integer clientContactPersonId) {
		this.clientContactPersonId = clientContactPersonId;
	}

	/**
	 * @return the contactPersonName
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * @param contactPersonName the contactPersonName to set
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	 * 
	 */
	public ClientContactPersonDto() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ClientContactPersonDto o) {
		// TODO Auto-generated method stub
		return clientContactPersonId.compareTo(o.clientContactPersonId);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientContactPerson [clientContactPersonId=" + clientContactPersonId + ", contactPersonName="
				+ contactPersonName + ", email=" + email + ", mobileNo=" + mobileNo + ", clientLocationId="
				+ clientLocationId + "]";
	}

}
