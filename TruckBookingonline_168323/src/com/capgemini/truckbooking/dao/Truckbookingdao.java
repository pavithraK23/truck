package com.capgemini.truckbooking.dao;

import java.util.List;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.TruckException;

public interface Truckbookingdao {

	List<TruckBean> selectAllTruckdetails() throws TruckException;

}
