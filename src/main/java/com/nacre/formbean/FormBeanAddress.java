package com.nacre.formbean;

import com.nacre.dto.CityDto;
/**
 * 
 * @author N.Sravanthi
 *
 */
public class FormBeanAddress {
private Integer addressId;
	
	/**
	 * @author N.Sravanthi
	 * address represents a String holding address Street Info
	 */
	private String address;
	

	/**
	 * @author N.Sravanthi
	 * pinCode represents a Integer value having pincode/ZipCode of that area
	 */
	private Integer pinCode;

	/**
	 * @author N.Sravanthi
	 * cityId represents City Information this Address by storing details in CityDto Class Object
	 */
	private CityDto cityId;
	
	
	
	/**
	 * @author N.Sravanthi
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}



	/**
	 * @author N.Sravanthi
	 * @param addressId  set the addressId 
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}



	/**
	 * @author N.Sravanthi
	 * @return the address 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @author N.Sravanthi
	 * @param address set the address 
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @author N.Sravanthi
	 * @return   the pinCode 
	 */
	public Integer getPinCode() {
		return pinCode;
	}




	/**
	 * @author N.Sravanthi
	 * @param pinCode  set the pinCode 
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * @author N.Sravanthi
	 * @return the cityId 
	 */
	public CityDto getCityId() {
		return cityId;
	}




	/**
	 * @author N.Sravanthi
	 * @param cityId set the cityId 
	 */
	public void setCityId(CityDto cityId) {
		this.cityId = cityId;
	}




	@Override
	public String toString() {
		return "AddressDto [addressId=" + addressId + ", address=" + address + ", pinCode=" + pinCode + ", cityId="
				+ cityId + "]";
	}
}
