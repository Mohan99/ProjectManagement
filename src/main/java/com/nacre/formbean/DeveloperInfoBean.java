package com.nacre.formbean;

import java.sql.Blob;
/***
 * @author Chakravarthi k
 *         this form bean class id to store developer information
 */
public class DeveloperInfoBean {
	private int userId;
	private String firstName;
	private String email;
	private String mobileNo;
	private String image;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
}
