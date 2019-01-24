package com.capgemini.truckbooking.service;

import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.dao.Truckbookingdao;
import com.capgemini.truckbooking.dao.TruckbookingdaoImpl;
import com.capgemini.truckbooking.exception.TruckException;

public class TruckbookingServiceImpl implements TruckbookingService {

	Truckbookingdao bookingdao = new TruckbookingdaoImpl();
	@Override
	public List<TruckBean> selectAllTruckdetails() throws TruckException {
		
		return bookingdao.selectAllTruckdetails();
	}		

	public boolean checkcustId(String custId) {
		String regEx="[A-Z]{1}[A-Za-z\\s]{1,5}$";
		
		return Pattern.matches(regEx, custId);
		
	}
	
	
	
	}	