/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StatusDto implements Comparable<StatusDto>, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * @author Vijay Kumar Reddy K
	 * statusId holds Unique value to represent status
	 */
	private Integer statusId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * Status represents status
	 */
	private String status;
	

	
	/**
	 * @author Vijay Kumar Reddy K
	 * @return Integer Status Id value
	 */
	public Integer getStatusId() {
		return statusId;
	}


	/**
	 * @author Vijay Kumar Reddy K
	 * @param statusId accepts Integer value of status Unique identification value
	 * 
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
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
		if (!(obj instanceof StatusDto)) {
			return false;
		}
		StatusDto other = (StatusDto) obj;
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (statusId == null) {
			if (other.statusId != null) {
				return false;
			}
		} else if (!statusId.equals(other.statusId)) {
			return false;
		}
		return true;
	}


/**
 * @author Vijay Kumar Reddy K
 * @return status value
 */
	public String getStatus() {
		return status;
	}

/**
 * @author Vijay Kumar Reddy K
 * @param status accepts string status value
 */
	public void setStatus(String status) {
		this.status = status;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(StatusDto o) {
		// TODO Auto-generated method stub
		return statusId.compareTo(o.statusId);
	}


	@Override
	public String toString() {
		return "StatusDto [statusId=" + statusId + ", status=" + status + "]";
	}

}
