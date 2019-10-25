//This class contains the function that generates an ArrayList of all of the available cars within the database

package search;

import java.util.ArrayList;
import cardealer.Car;

public class availibleSearch {
	public static ArrayList<Car> getAvailibleCars(ArrayList<Car> database) throws Exception{
		ArrayList<Car> unsoldCars=new ArrayList<Car>();
		
		for (int i=0;i<database.size();i++) {
			Car currentCar=database.get(i);
			String sdate=currentCar.getSellDate();
			if (sdate.equals("")) {//if the sell date of the current car is blank then it is classed as available and added to the ArrayList
				unsoldCars.add(currentCar);
			}
		}
		return unsoldCars;
	}

}
