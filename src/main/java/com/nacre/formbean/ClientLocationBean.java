package com.nacre.formbean;
/**
 * it contains all variables required to store location details of client
 * @author N.Sravanthi
 *
 */
public class ClientLocationBean {
	
	private Integer clientLocationId;
	private String address;
	private Integer pinCode;
	private String city;
	public Integer getClientLocationId() {
		return clientLocationId;
	}
	public void setClientLocationId(Integer clientLocationId) {
		this.clientLocationId = clientLocationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
