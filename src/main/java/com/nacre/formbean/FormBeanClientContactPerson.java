package com.nacre.formbean;

import java.util.LinkedHashSet;
import java.util.Set;

import com.nacre.dto.AddressDto;

/**
 * 
 * @author N.Sravanthi
 *
 */
public class FormBeanClientContactPerson {
	private Integer contactPersonId;
	private String contactPersonName;
	private String mailId;
	private String mobileNo;
	private Integer locationId;
public	AddressDto addrs=new AddressDto();
/**
 * @return the ContactPersonId
 */
	public Integer getContactPersonId() {
		return contactPersonId;
	}
	/**
	 * @param  contactPersonId set the ContactPersonId
	 */
	public void setContactPersonId(Integer contactPersonId) {
		this.contactPersonId = contactPersonId;
	}
	/**
	 * @return the ContactPersonName
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}
	/**
	 * @param   contactPersonName  set the ContactPersonName 
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	/**
	 * @return the MailId
	 */
	public String getMailId() {
		return mailId;
	}
	/**
	 * @param  mailId   set the MailId 
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	/**
	 * @return the MobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param  mobileNo set the MobileNo 
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the LocationId
	 */
	public Integer getLocationId() {
		return locationId;
	}
	/**
	 * @param  locationId set the LocationId 
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "FormBeanClientContactPerson [contactPersonId=" + contactPersonId + ", contactPersonName="
				+ contactPersonName + ", mailId=" + mailId + ", mobileNo=" + mobileNo + ", locationId=" + locationId
				+ ", list=" + addrs + "]";
	}
	
	

}
