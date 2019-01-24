package com.capgemini.truckbooking.service;

import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.TruckException;

public interface TruckbookingService {

	List<TruckBean> selectAllTruckdetails() throws TruckException;

	static boolean validateFields(String custid) {
	
    String regEx="[A-Z]{1}[A-Za-z\\s]{1,3}$";
		
		return Pattern.matches(regEx, custid);
		
	}

}
