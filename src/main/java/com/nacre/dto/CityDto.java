/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CityDto implements Comparable<CityDto>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * cityId represents Integer value for Unique identification of city
	 */
	private Integer cityId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * city represents a String holding city name
	 */
	private String City;
	
	
	/**
	 * @author Vijay Kumar Reddy K
	 * stateId represents city respective  State information by holding State Class Object Reference 
	 */
	private StateDto stateId;
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return this.City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public StateDto getStateId() {
		return stateId;
	}

	public void setStateId(StateDto stateId) {
		this.stateId = stateId;
	}

	@Override
	public int compareTo(CityDto o) {
		// TODO Auto-generated method stub
		return cityId.compareTo(o.cityId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
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
		CityDto other = (CityDto) obj;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + ", City=" + City + ", stateId=" + stateId + "]";
	}
}