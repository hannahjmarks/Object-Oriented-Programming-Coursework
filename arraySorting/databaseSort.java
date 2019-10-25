//This class contains the functions needed to sort the sold and available cars into date order by sell date
//and arrival date respectively for use in the print cars function.

package arraySorting;

import java.time.LocalDate;
import java.util.ArrayList;
import cardealer.Car;


public class databaseSort {
	//sorts an ArrayList of sold cars into date order by their sell dates
	public static ArrayList<Car> soldSort(ArrayList<Car> soldCars) throws Exception{
		for (int i=0;i<soldCars.size()-1;i++) {
			for (int j=0;j<soldCars.size()-1-i;j++) {//nested loop through ArrayList
				Car car1=soldCars.get(j);//gets the cars from position j and j+1 from the ArrayList
				Car car2=soldCars.get(j+1);
				LocalDate date1=Car.stringToDate(car1.getSellDate());//gets the sell dates of the 2 cars
				LocalDate date2=Car.stringToDate(car2.getSellDate());
				if (date2.isBefore(date1)) {//swaps the cars positions if the sell date of the first car is after that of the second
					soldCars.set(j, car2);
					soldCars.set(j+1, car1);
				}
			}
		}
		
		
		return soldCars;//returns the newly sorted ArrayList
	}
	
	//sorts an ArrayList of sold cars into date order by their sell dates
	public static ArrayList<Car> availibleDateSort(ArrayList<Car> unsoldCars) throws Exception{
		for (int i=0;i<unsoldCars.size()-1;i++) {
			for (int j=0;j<unsoldCars.size()-1-i;j++) {//nested loop through ArrayList
				Car car1=unsoldCars.get(j);//gets the cars from position j and j+1 from the ArrayList
				Car car2=unsoldCars.get(j+1);
				LocalDate date1=Car.stringToDate(car1.getArriveDate());//gets the arrival dates of the 2 cars
				LocalDate date2=Car.stringToDate(car2.getArriveDate());
				if (date2.isBefore(date1)) {//swaps the cars positions if the arrival date of the first car is after that of the second
					unsoldCars.set(j, car2);
					unsoldCars.set(j+1, car1);
				}
			}
		}		
		return unsoldCars;//returns the newly sorted ArrayList
	}
}
