package com.nacre.formbean;
/**
 * It hold the information of an Project Manager
 * @author Kunal394
 *
 */
public class ProjectManagerInfoBean {
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
	public String getLogo() {
		return image;
	}
	public void setLogo(String image) {
		this.image = image;
	}
	
}
