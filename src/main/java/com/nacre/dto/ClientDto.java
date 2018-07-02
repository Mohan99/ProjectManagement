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
public class ClientDto implements Comparable<ClientDto>, Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * clientId holds unique representation Integer value of Client
	 */
	private Integer clientId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * clientName holds name Of Client
	 */
	private String clientName;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * clientDescription holde Information about Client
	 */
	private String clientDescription;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * logo holds Clients Logo 
	 */
	private Blob logo;
	

	/**
	 * @author Vijay Kumar Reddy K
	 * @return the clientId which represents unique representation of client 
	 */
	public Integer getClientId() {
		return clientId;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @param clientId the clientId to set unique representation integer value of clientId
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @return the clientName 
	 * 
	 */
	public String getClientName() {
		return clientName;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @return the clientDescription
	 */
	public String getClientDescription() {
		return clientDescription;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @param clientDescription the clientDescription to set
	 */
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @return the logo of Client
	 */
	public Blob getLogo() {
		return logo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientDto [clientId=" + clientId + ", clientName=" + clientName + ", clientDescription="
				+ clientDescription + ", logo=" + logo + "]";
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @param logo the logo to set Client Logo
	 */
	public void setLogo(Blob logo) {
		this.logo = logo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientDescription == null) ? 0 : clientDescription.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
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
		if (!(obj instanceof ClientDto)) {
			return false;
		}
		ClientDto other = (ClientDto) obj;
		if (clientDescription == null) {
			if (other.clientDescription != null) {
				return false;
			}
		} else if (!clientDescription.equals(other.clientDescription)) {
			return false;
		}
		if (clientId == null) {
			if (other.clientId != null) {
				return false;
			}
		} else if (!clientId.equals(other.clientId)) {
			return false;
		}
		if (clientName == null) {
			if (other.clientName != null) {
				return false;
			}
		} else if (!clientName.equals(other.clientName)) {
			return false;
		}
		if (logo == null) {
			if (other.logo != null) {
				return false;
			}
		} else if (!logo.equals(other.logo)) {
			return false;
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ClientDto o) {
		// TODO Auto-generated method stub
		return clientId.compareTo(o.clientId);
	}

}
