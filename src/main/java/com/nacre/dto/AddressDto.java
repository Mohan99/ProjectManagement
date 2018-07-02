/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AddressDto implements Comparable<AddressDto>, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * @author Vijay Kumar Reddy K
	 * addressId represents Integer value for Unique identification of address
	 */
	private Integer addressId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * address represents a String holding address Street Info
	 */
	private String address;
	

	/**
	 * @author Vijay Kumar Reddy K
	 * pinCode represents a Integer value having pincode/ZipCode of that area
	 */
	private Integer pinCode;

	/**
	 * @author Vijay Kumar Reddy K
	 * cityId represents City Information this Address by storing details in CityDto Class Object
	 */
	private CityDto cityId;
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AddressDto o) {
		// TODO Auto-generated method stub
		return addressId.compareTo(addressId);
	}

	/**
	 * @author Vijay Kumar Reddy K
	 * @return Integer Value To represent Unique Value Of Address
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @author Vijay Kumar Reddy K
	 * @param addressId accepts An Integer Value that represents  AddressId
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	/**
	 * @author Vijay Kumar Reddy K
	 * @return String Address Details
	 */
	public String getAddress() {
		return address;
	}
/**
 * @author Vijay Kumar Reddy K
 * @param address accepts Address Info As String
 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @author Vijay Kumar Reddy K
	 * @return Integer Value That Represents PinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}
	/**
	 * @author Vijay Kumar Reddy K
	 * @param pinCode Accepts an Integer Value That holds PinCode Of Address
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @author Vijay Kumar Reddy K
	 * @return CityDto object Which Holds Entire City Information of Address 
	 */
	public CityDto getCityId() {
		return cityId;
	}
/**
 * @author Vijay Kumar Reddy K
 * @param cityId Accepts CityDto Class Object Which Holds City Information
 */
	public void setCityId(CityDto cityId) {
		this.cityId = cityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDto other = (AddressDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		return true;
	}
	
	
	

}
