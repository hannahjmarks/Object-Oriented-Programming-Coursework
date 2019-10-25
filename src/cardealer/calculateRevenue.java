//This class contains the main calculate revenue functions that are called by the user interface

package cardealer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import cardealer.Car;

public class calculateRevenue {
	//getDayRevenue function used to calculate the revenue made in a single day
	public static float getDayRevenue (String inputDate) throws NumberFormatException, Exception {
		float revenue=0;
		LocalDate startDate=LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));//converts the date input by the user into a LocalDate
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();//generates database from file
		ArrayList<Car> soldCars=search.soldSearch.getSoldCars(database);//ArrayList of all the sold cars in the database
		
		for (int i=0;i<soldCars.size();i++) {
			Car current=soldCars.get(i);
			String carSellDate=current.getSellDate();
			LocalDate sellDate=LocalDate.parse(carSellDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			float price=current.getPrice();
			
			if (sellDate.isEqual(startDate)) {//if the sell date of the car is the same as the search item then the price of the car is added to the total revenue
				revenue+=price;
			}
		}
		
		return revenue;
	}
	
	//getMonthRevenue function used to calculate the revenue generated over a single month
	public static float getMonthRevenue(String inputDate) throws NumberFormatException, Exception {
		float revenue=0;
		LocalDate startDate=LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate endDate=startDate.plusMonths(1);//gets the end date to check against the sell date of the cars
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
		ArrayList<Car> soldCars=search.soldSearch.getSoldCars(database);
		
		for (int i=0;i<soldCars.size();i++) {
			Car current=soldCars.get(i);
			String carSellDate=current.getSellDate();
			LocalDate sellDate=LocalDate.parse(carSellDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			float price=current.getPrice();
			
			if (sellDate.isAfter(startDate) && sellDate.isBefore(endDate)) {//if the sell date lies between the start and end dates then the price is added to the total revenue
				revenue+=price;
			}else if(sellDate.isEqual(startDate)) {//if the sell date matches the start date then the price is added to the total revenue
				revenue+=price;
			}else if(sellDate.isEqual(endDate)) {//if the sell date matches the end date then the price is added to the total revenue
				revenue+=price;
			}	
		}
		return revenue;
	}

}
