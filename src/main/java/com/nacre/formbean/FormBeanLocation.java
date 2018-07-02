package com.nacre.formbean;

import com.nacre.dto.AddressDto;
import com.nacre.dto.ClientDto;


/**
 * 
 * @author N.Sravanthi
 *
 */
public class FormBeanLocation {
	/**
	 * @author N.Sravanthi
	 * clientLocationid holds unique ClitentLocationId 
	 */
	private Integer clientLocationId;
	/**
	 * @author N.Sravanthi
	 * addressId holds AddressDto class Object
	 */
	private AddressDto addressId;
	
	/**
	 * @author N.Sravanthi
	 * clientId holds ClientDto class Object
	 */
	private ClientDto clientId;
	
	/**
	 * @author N.Sravanthi
	 * @return the clientLocationId of client location
	 */
	public Integer getClientLocationId() {
		return clientLocationId;
	}

	/**
	 * @author N.Sravanthi
	 * @param clientLocationId the clientLocationId to set 
	 */
	public void setClientLocationId(Integer clientLocationId) {
		this.clientLocationId = clientLocationId;
	}




	/**
	 * @author N.Sravanthi
	 * @return the AddressDto class Object Which Holds Address Info
	 */
	public AddressDto getAddressId() {
		return addressId;
	}




	/**
	 * @author N.Sravanthi
	 * @param addressId the addressDto Class Object  to set
	 */
	public void setAddressId(AddressDto addressId) {
		this.addressId = addressId;
	}




	/**
	 * @author N.Sravanthi
	 * @return the clientDto classObject
	 */
	public ClientDto getClientId() {
		return clientId;
	}




	/**
	 * @author N.Sravanthi
	 * @param clientId the ClientDto class Object to set
	 */
	public void setClientId(ClientDto clientId) {
		this.clientId = clientId;
	}



}
