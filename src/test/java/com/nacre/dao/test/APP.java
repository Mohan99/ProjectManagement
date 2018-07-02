/**
 * 
 */
package com.nacre.dao.test;

import org.apache.log4j.Logger;

import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.PooledConnection;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class APP {

public static final Logger logger = 	Logger.getLogger(APP.class);
	/**
	 * @param args
	 * @throws NoConnectionException 
	 */
	public static void main(String[] args) throws NoConnectionException {
		// TODO Auto-generated method stub
		
		logger.info("HI HELLO "+PooledConnection.getConnection());

	}

}
