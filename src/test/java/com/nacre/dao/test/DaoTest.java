/**
 * 
 */
package com.nacre.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nacre.daoi.CommonOperationsDaoI;
import com.nacre.daoi.daoimpl.CommonOperationsDaoImpl;
import com.nacre.dto.AddressDto;
import com.nacre.dto.CityDto;
import com.nacre.dto.CountryDto;
import com.nacre.dto.StateDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;

/**
 * @author Kapilraj029
 *
 */
public class DaoTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		UserDto user = null;
		StateDto Dto=new StateDto();
		CityDto cDto =new CityDto();
		//AddressDto adto=new AddressDto();  
		CountryDto dto=new CountryDto();
		dto.setCountryId(1);
		Dto.setCountryID(dto);
		cDto.setCityId(1);
		user = new UserDto();
		CommonOperationsDaoI daoi = null;
		daoi = new CommonOperationsDaoImpl();
		try {
			con = PooledConnection.getConnection();
			
			//System.out.println(daoi.viewUserProfile(con));
			daoi.getStates(dto, con);
	//System.out.println(daoi.getCountries(con));
//	System.out.println(daoi.getStates(dto, con));
//	System.out.println(daoi.getCities(Dto, con));
		//	System.out.println(daoi.editUserImage(con, dto));
			} catch (NoConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger(DaoTest.class).warn("test");
	}
}
