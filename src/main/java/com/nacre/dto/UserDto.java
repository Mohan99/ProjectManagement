/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;
import java.sql.Blob;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class UserDto implements Comparable<UserDto>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", password=" + password + ", gender=" + gender + ", image=" + image
				+ ", roleId=" + roleId + ", statusId=" + statusId + ", superiorId=" + superiorId + ", addressId="
				+ addressId + "]";
	}




	/**
	 * 
	 */
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNo;
	
	private String password;
	
	private String gender;
	private Blob image;
	private RoleDto roleId;
	private StatusDto statusId;
	private UserDto superiorId;
	private AddressDto addressId;
	
	
	
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}




	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}




	/**
	 * @return the image
	 */
	public Blob getImage() {
		return image;
	}




	/**
	 * @param image the image to set
	 */
	public void setImage(Blob image) {
		this.image = image;
	}




	/**
	 * @return the roleId
	 */
	public RoleDto getRoleId() {
		return roleId;
	}




	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(RoleDto roleId) {
		this.roleId = roleId;
	}




	/**
	 * @return the statusId
	 */
	public StatusDto getStatusId() {
		return statusId;
	}




	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}




	/**
	 * @return the superiorId
	 */
	public UserDto getSuperiorId() {
		return superiorId;
	}




	/**
	 * @param superiorId the superiorId to set
	 */
	public void setSuperiorId(UserDto superiorId) {
		this.superiorId = superiorId;
	}




	/**
	 * @return the addressId
	 */
	public AddressDto getAddressId() {
		return addressId;
	}




	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(AddressDto addressId) {
		this.addressId = addressId;
	}




	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(UserDto o) {
		// TODO Auto-generated method stub
		return userId.compareTo(o.userId);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", password=" + password + ", gender=" + gender + ", image=" + image
				+ ", roleId=" + roleId + ", statusId=" + statusId + ", superiorId=" + superiorId + ", addressId="
				+ addressId + "]";
	}*/
}
