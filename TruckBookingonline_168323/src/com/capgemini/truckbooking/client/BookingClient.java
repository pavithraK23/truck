package com.capgemini.truckbooking.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.TruckException;
import com.capgemini.truckbooking.service.TruckbookingService;
import com.capgemini.truckbooking.service.TruckbookingServiceImpl;

public class BookingClient {

	
	public static void main(String[] args) throws TruckException {

		int choice = 0;
		boolean flag=false;
        TruckbookingService service =new TruckbookingServiceImpl();
		do {
			Scanner scanner = new Scanner("System.in");
			System.out.println("***TRANSPORT TRUCK BOOKING ONLINE***");
			System.out.println("1.Book Trucks");
			System.out.println("2.Exit");
			System.out.println("Enter ur choice");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				
				/*
				 * System.out.println("Enter Truck Id "); Integer truckid = scanner.nextInt();
				 * System.out.println("enter number of trucks"); Integer numberoftrucks =
				 * scanner.nextInt(); System.out.println("enter customer mobile"); Long
				 * customermobile = scanner.nextLong();
				 * System.out.println("enter date of transportation"); String
				 * dateoftransportation = scanner.nextLine();
				 */
				/*do {
					System.out.println("Enter Truck Id");
					String truckid = scanner.nextLine();
					
					String RegEx ="[A-Z] {1}[0-9] {5}$";
				    flag = Pattern.matches(RegEx, truckid);
					
				}while(flag==false);*/
				
				System.out.println("Enter Truck Id");
				String truckid = scanner.nextLine();
				
				List<TruckBean> list = new ArrayList<>();

				list = service.selectAllTruckdetails();
					System.out.println("truckId" + "   " + "truckType" + "         " + "origin" + "        "
							+ "destination" + "     " + "charges" + "     " + "availableNos");

					for (TruckBean booking : list) {
						System.out.println(booking.getTruckID() + "        " + booking.getTruckType() + "       "
								+ booking.getOrigin() + "          " + booking.getDestination() + "        "
								+ booking.getCharges() + "           " + booking.getAvailabeNos());
					}

				
				break;

			}
		} while (choice != 0);
	}
}
