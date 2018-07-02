/**
 * 
 */
package com.nacre.uitl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.nacre.constants.DbConstants;
import com.nacre.exception.NoConnectionException;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class PooledConnection {

public static final Logger logger = 	Logger.getLogger(PooledConnection.class);
	/**
	 * 
	 */
private static BasicDataSource dataSource ;
	
static{
	InputStream is =  PooledConnection.class.getClassLoader().getResourceAsStream("database.properties");
	Properties p = new Properties();
	
	
	try {
		p.load(is);
	String userName = 	p.getProperty(DbConstants.USER_NAME);
	String password = p.getProperty(DbConstants.PASSWORD);	
	String url = p.getProperty(DbConstants.URL);
	String driver = p.getProperty(DbConstants.DRIVER_CLASS_NAME);
	String minPool = p.getProperty(DbConstants.MIN_CONNECTIONS);
	String maxPool = p.getProperty(DbConstants.MAX_CONNECTIONS);
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dataSource = new BasicDataSource();
	dataSource.setUsername(userName);
	dataSource.setPassword(password);
	dataSource.setUrl(url);
	dataSource.setDriverClassName(driver);/*
	dataSource.setMaxIdle(Integer.parseInt(maxPool));
	dataSource.setMinIdle(Integer.parseInt(minPool));*/
	dataSource.setDefaultAutoCommit(false);
	

	logger.info("DATASOURCE : "+userName);
	logger.info("DATASOURCE : "+password);
	logger.info("DATASOURCE : "+driver);
	
	logger.info("DATASOURCE : "+dataSource);
	
	
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	logger.error(e.getMessage());
	
	}
	
	
	
}
/**
 * @author Vijay Kumar Reddy K
 * @return java.sql.Connection which is available in pool
 * @throws NoConnectionException if unable to connect database
 */
public static Connection getConnection() throws NoConnectionException{

	try {
		Connection	con = dataSource.getConnection();
		logger.info("CONECTION OBTAINED : "+con);
		return con;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.error("ERROR CODE : "+e.getErrorCode()+" MESSAGE : "+e.getMessage()+"SQL STATE : "+e.getSQLState());
		
		throw new NoConnectionException(e.getMessage());
	}
}

public static void main(String[] args) throws SQLException {
	
	
	logger.info(dataSource.getConnection());
}
	
}
