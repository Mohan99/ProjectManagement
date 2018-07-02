package com.nacre.formbean;

import java.sql.Blob;
/**
 * it contains all variables required to store ClientDetails 
 * @author N.Sravanthi
 *
 */
public class ClientInfoBean {
	private Integer clientId;
	private String clientName;
	private String clientDescription;
	private String logo;
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientDescription() {
		return clientDescription;
	}
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "ClientInfoBean [clientId=" + clientId + ", clientName=" + clientName + ", clientDescription="
				+ clientDescription + ", logo=" + logo + "]";
	}

	
}
