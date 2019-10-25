//This class contains the functions used to get a car and its index from the availibleCars ArrayList

package search;

import cardealer.Car;
import java.util.ArrayList;

public class carSearch {
	//getUnsoldCarIndex returns the index of the ArrayList car with the same registration number as the search item
	public static int getUnsoldCarIndex(String reg) throws NumberFormatException, Exception {
		int databaseIndex=-1;//set to -1 so that there is no possible way that it can be a valid index and will therefore not cause errors in the database
		reg=reg.toUpperCase();
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
		for (int i=0;i<database.size();i++) {
			Car current=database.get(i);
			if (current.getRegNum().toUpperCase().equals(reg)) {//if the registration number of the current ArrayList entry is the same as the search item then the index(i) is returned
				databaseIndex=i;
			}
		}
		
		
		return databaseIndex;
	}
	
	//getUnsoldCar returns the car from the ArrayList with the same registration number as the search item
	public static Car getUnsoldCar(String reg) throws NumberFormatException, Exception {
		Car car=null;
		reg=reg.toUpperCase();
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
		ArrayList<Car> unsoldCars=search.availibleSearch.getAvailibleCars(database);
		for (int i=0;i<unsoldCars.size();i++) {
			Car current=unsoldCars.get(i);
			if (current.getRegNum().toUpperCase().equals(reg)) {//if the registration numbers match then the current car is returned
				car=current;
			}
		}
		
		
		return car;
	}

}
