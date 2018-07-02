/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class RoleDto implements Comparable<RoleDto>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @author Vijay Kumar Reddy K
	 * roleId represents An Unique identification value of role
	 */
	private Integer roleId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * role represents role of user
	 */
	private String role;
	
	
	
/**
 * @author Vijay Kumar Reddy K
 * @return Integer value of Unique Identification of Role
 */
	public Integer getRoleId() {
		return roleId;
	}



/**
 * @author Vijay Kumar Reddy K
 * @param roleId accepts Unique representation Value for Role
 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}



/**
 * @author Vijay Kumar Reddy K
 * @return returns String Role of user
 */
	public String getRole() {
		return role;
	}


/**
 * @author Vijay Kumar Reddy K
 * @param role accepts String Role Value of User
 */

	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", role=" + role + "]";
	}




	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RoleDto o) {
		// TODO Auto-generated method stub
		return roleId.compareTo(roleId);
	}

}
