/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ClientLocationDto implements Comparable<ClientLocationDto>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author Vijay Kumar Reddy K
	 * clientLocationid holds unique ClitentLocationId 
	 */
	private Integer clientLocationId;
	/**
	 * @author Vijay Kumar Reddy K
	 * addressId holds AddressDto class Object
	 */
	private AddressDto addressId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * clientId holds ClientDto class Object
	 */
	private ClientDto clientId;
	
	
	
	
	/**
	 * @author Vijay Kumar Reddy K
	 * @return the clientLocationId of client location
	 */
	public Integer getClientLocationId() {
		return clientLocationId;
	}




	/**
	 * @author Vijay Kumar Reddy K
	 * @param clientLocationId the clientLocationId to set 
	 */
	public void setClientLocationId(Integer clientLocationId) {
		this.clientLocationId = clientLocationId;
	}




	/**
	 * @author Vijay Kumar Reddy K
	 * @return the AddressDto class Object Which Holds Address Info
	 */
	public AddressDto getAddressId() {
		return addressId;
	}




	/**
	 * @author Vijay Kumar Reddy K
	 * @param addressId the addressDto Class Object  to set
	 */
	public void setAddressId(AddressDto addressId) {
		this.addressId = addressId;
	}




	/**
	 * @author Vijay Kumar Reddy K
	 * @return the clientDto classObject
	 */
	public ClientDto getClientId() {
		return clientId;
	}




	/**
	 * @param clientId the ClientDto class Object to set
	 */
	public void setClientId(ClientDto clientId) {
		this.clientId = clientId;
	}




	public int compareTo(ClientLocationDto o) {
		// TODO Auto-generated method stub
		return clientLocationId.compareTo(o.clientLocationId);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientLocationId == null) ? 0 : clientLocationId.hashCode());
		return result;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClientLocationDto)) {
			return false;
		}
		ClientLocationDto other = (ClientLocationDto) obj;
		if (addressId == null) {
			if (other.addressId != null) {
				return false;
			}
		} else if (!addressId.equals(other.addressId)) {
			return false;
		}
		if (clientId == null) {
			if (other.clientId != null) {
				return false;
			}
		} else if (!clientId.equals(other.clientId)) {
			return false;
		}
		if (clientLocationId == null) {
			if (other.clientLocationId != null) {
				return false;
			}
		} else if (!clientLocationId.equals(other.clientLocationId)) {
			return false;
		}
		return true;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientLocationDto [clientLocationId=" + clientLocationId + ", addressId=" + addressId + ", clientId="
				+ clientId + "]";
	}
	
	

	
	
	
	
	
}
