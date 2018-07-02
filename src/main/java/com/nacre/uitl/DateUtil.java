package com.nacre.uitl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This is a utility class for date conversion, 
 * contain methods to convert String Date to SQl Date.
 * @version 1.0.0 2017
 * @author Nacre Batch 40 Java
 */
public class DateUtil {
	private static SimpleDateFormat dateFormat = null;

	/**
	 * @author Vijay Kumar Reddy K
	 * @param date accepts String Date in dd-MM-yyyy
	 * @return  java.sql.Date object
	 */
	public static Date getSqlFromStringDate(String date) {
		String[] dateArray = date.split("[\\-\\.\\/]");
		String requiredFormat = dateArray[2] + "-" + dateArray[1] + "-"
				+ dateArray[0];
		java.sql.Date date2 = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date date1 = dateFormat.parse(requiredFormat);
			 date2 = new java.sql.Date(date1.getTime());
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
		
		
	}

	
	/**
	 * @author Vijay Kumar Reddy K 
	 * @param inputDate accepts any string date
	 * @param format  accepts  format of given string
	 * @return converted java.sql.Date object
	 */
	public static Date stringToSqlDate(String inputDate ,String format) 
	{
		SimpleDateFormat formater = new SimpleDateFormat(format);
		java.util.Date utilDate;
		java.sql.Date sqlDate = null;
		try 
		{
			utilDate = formater.parse(inputDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return sqlDate;

	}
	/**
	 * @author pavan pratap singh b-35
	 * @param inputDate
	 * @return
	 */
	
	public static String sqlDateToString(java.util.Date inputDate) {
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = dateFormat.format(inputDate);
		return stringDate;
	}
	

	/**
	 * @author Vijay Kumar Reddy K 
	 */
	public static Date getSQLDate(java.util.Date utilDate) {

		return new java.sql.Date(utilDate.getTime());
		
	}


}
