package com.capgemini.truckbooking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.truckbooking.exception.TruckException;

public class TruckUtility {

	private static Connection connection = null;
	public static Connection getConnection() throws TruckException{
		File file = null;
		FileInputStream inputStream =null;
		file = new File ("resources/jdbc.properties");
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new TruckException("file not found");
			
		}
		 Properties properties = new Properties();
		 try {
			 properties.load(inputStream);
			 String driver = properties.getProperty("db.driver");
	         String url = properties.getProperty("db.url");
	         String username = properties.getProperty("db.username");
	         String passowrd = properties.getProperty("db.password");
	         
	         Class.forName(driver);
	         connection = DriverManager.getConnection(url, "system", "corp123");
	         
			
		} catch (IOException e) {
			throw new TruckException("unable to load file");
			
		} catch (ClassNotFoundException e) {
			throw new TruckException("class not loaded");
		} catch (SQLException e) {
			throw new TruckException("not connected");
		}
		
         return connection;
		
	}
}
