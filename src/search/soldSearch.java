//This class generates the ArrayList of sold cars from the database

package search;

import java.util.ArrayList;
import cardealer.Car;

public class soldSearch {
	public static ArrayList<Car> getSoldCars(ArrayList<Car> database) throws Exception{
		ArrayList<Car> soldCars=new ArrayList<Car>();
		
		for (int i=0;i<database.size();i++) {//loops through the database ArrayList
			Car currentCar=database.get(i);
			String sdate=currentCar.getSellDate();//gets the sell date for the current car in the database
			if (sdate.equals("")) {
			}
			else {//if the sell date is not blank/empty then the current car is added to the sold cars ArrayList
				soldCars.add(currentCar);
			}
		}
		return soldCars;
	}
}
