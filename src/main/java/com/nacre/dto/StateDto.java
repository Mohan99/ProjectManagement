/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StateDto implements Serializable, Comparable<StateDto> {

	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @author Vijay Kumar Reddy K
	 * stateId represents Uique identity of a state
	 */
	private Integer stateID;
	/**
	 * @author Vijay Kumar Reddy K
	 * state represents name of state
	 */
	private String state;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * countryId Holds country details of state with reference of CounryDto Class Object
	 */
	private CountryDto countryID;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * @return Integer value holds unique representation StateId
	 */
	public Integer getStateID() {
		return stateID;
	}

/**
 * @author Vijay Kumar Reddy K
 * @param stateID accepts Integer StateId 
 */
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

/**
 * @author Vijay Kumar Reddy K
 * @return String State Name  
 */
	public String getState() {
		return state;
	}

/**
 * @author Vijay Kumar Reddy K
 * @param state accept String State Name
 */
	public void setState(String state) {
		this.state = state;
	}

/**
 * @author Vijay Kumar Reddy K
 * @return CountryDto Object Which holds Country Info
 */
	public CountryDto getCountryID() {
		return countryID;
	}

/**
 * @author Vijay Kumar Reddy K
 * @param countryID accepts CountryDto Which holds Country Info
 */
	public void setCountryID(CountryDto countryID) {
		this.countryID = countryID;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(StateDto o) {
		// TODO Auto-generated method stub
		return stateID.compareTo(o.stateID);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryID == null) ? 0 : countryID.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stateID == null) ? 0 : stateID.hashCode());
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
		StateDto other = (StateDto) obj;
		if (countryID == null) {
			if (other.countryID != null)
				return false;
		} else if (!countryID.equals(other.countryID))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stateID == null) {
			if (other.stateID != null)
				return false;
		} else if (!stateID.equals(other.stateID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "StateDto [stateID=" + stateID + ", state=" + state + ", countryID=" + countryID + "]";
	}
	
	
	
	
	

}
