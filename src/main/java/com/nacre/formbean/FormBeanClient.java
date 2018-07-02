package com.nacre.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author N.Sravanthi
 *
 */
public class FormBeanClient implements Serializable {

	private static final long serialVersionUID = 6096678972616637384L;
public static  Integer clientId;
public static String clientName;
public static String clientDescription;
public static String logo;
public static   List<FormBeanClientContactPerson> list=new ArrayList<FormBeanClientContactPerson>();



/**
 * @return the clientId 
 */
public Integer getClientId() {
	return clientId;
}

/**
 * @param clientId  set the clientId 
 */
public void setClientId(Integer clientId) {
	this.clientId = clientId;
}

/**
 * @return the clientName 
 */
public String getClientName() {
	return clientName;
}


/**
 * @param  clientName  set the clientName
 */
public void setClientName(String clientName) {
	this.clientName = clientName;
}
/**
 * @return the Description of client
 */
public String getClientDescription() {
	return clientDescription;
}

/**
 * @param  clientDescription  set the Description of client
 */
public void setClientDescription(String clientDescription) {
	this.clientDescription = clientDescription;
}/**
 * @return the Logo 
 */
public String getLogo() {
	return logo;
}

/**
 * @param logo set the Logo
 */
public void setLogo(String logo) {
	this.logo = logo;
}
@Override
public String toString() {
	return "FormBeanClient [clientId=" + clientId + ", clientName=" + clientName + ", clientDescription="
			+ clientDescription + ", logo=" + logo + ", list=" + list + "]";
}


}
