/**
 * 
 */
package com.nacre.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CountryDto implements Serializable ,Comparable<CountryDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * countryId represents unique identification of Country Object
	 */
	private Integer countryId;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * country represents name of Country
	 */
	private String country;

	/**
	 * @author Vijay Kumar Reddy K
	 * @return Integer Value That represents Unique Value to represent Country
	 */
	public Integer getCountryId() {
		return countryId;
	}
/**
 * @author Vijay Kumar Reddy K
 * @param countryId accepts An Integer value as countryId
 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
/**
 * @author Vijay Kumar Reddy K
 * @return String Value Of Country Name
 */
	public String getCountry() {
		return country;
	}
	
/**
 * @author Vijay Kumar Reddy K
 * @param country accepts Country name As String
 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CountryDto [countryId=" + countryId + ", country=" + country + "]";
	}

	public int compareTo(CountryDto o) {
		// TODO Auto-generated method stub
		return this.countryId.compareTo(o.countryId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
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
		CountryDto other = (CountryDto) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		return true;
	}
	

}
