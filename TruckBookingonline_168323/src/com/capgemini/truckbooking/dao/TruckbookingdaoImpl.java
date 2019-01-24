package com.capgemini.truckbooking.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.TruckException;
import com.capgemini.truckbooking.utility.TruckUtility;

public class TruckbookingdaoImpl implements Truckbookingdao {

	Connection connection = null;
	Statement state = null;
	PreparedStatement Statement = null;
	ResultSet resultset = null;
	
	
	@SuppressWarnings("static-access")
	@Override
	public List<TruckBean> selectAllTruckdetails() throws TruckException {
		Logger.getLogger("selectalltruckdetails");
	 connection = TruckUtility.getConnection();
	 Logger.getLogger("connection object created");
	 List<TruckBean> list = new ArrayList<>();
	 try {
		 Statement = connection.prepareStatement(QueryMapper.selectAllTruckdetails);
		 Logger.getLogger("statement object created");
		 resultset=Statement.executeQuery();
		 Logger.getLogger("resultset query executed");
		 
		 while(resultset.next()) {
			 String custid = resultset.getString("customer id");
			 String trucktype = resultset.getString("trucktype");
			 String origin = resultset.getString("origin");
			 String destination = resultset.getString("destination");
			 Float charges = resultset.getFloat("charges");
			 Integer availablenos = resultset.getInt("available nos");
 
			 TruckBean booking = new TruckBean();
			 BookingBean bookingbean = new BookingBean();
			 bookingbean.setCustId(custid);
			 booking.setTruckType(trucktype);
			 booking.setOrigin(origin);
			 booking.setDestination(destination);
			 booking.setCharges(charges);
			 booking.setAvailabeNos(availablenos);
			 list.add(booking);
		 }
	} catch (SQLException e) {
		throw new TruckException("prepare stattement not created");
		
	}finally {
	 try {
		 resultset.close();
		 Logger.getLogger("resultset closed");
		} catch (SQLException e) {
			throw new TruckException("resultset not closed");
		}
	 try {
		Statement.close();
		Logger.getLogger("statement closed");
	} catch (SQLException e2) {
		throw new TruckException("statement not closed");
	}
	 try {
		connection.close();
		Logger.getLogger("connection closed");
	} catch (SQLException e2) {
		throw new TruckException("connection not closed");
	}
	}
	
		return list;
	}

}
