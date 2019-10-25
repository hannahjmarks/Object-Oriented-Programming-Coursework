//This class contains the functions used to determine whether a car or user exists within the respective data files and contains the function
//used to check if a car is available for purchase

package search;

import java.io.IOException;
import java.util.ArrayList;

import cardealer.Car;
import cardealer.User;

public class exists {
	//carAlreadyExists returns a boolean result for use outside the function
	public static boolean carAlreadyExists(String reg) throws NumberFormatException, Exception {
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();//loads car database
		boolean exists=false;
		reg=reg.toUpperCase();//set to upper case to make the search case insensitive
		
		for (int i=0;i<database.size();i++) {
			Car current=database.get(i);
			if (current.getRegNum().toUpperCase().equals(reg)) {//searches the database by registration number
				exists=true;//if a matching registration number is found then the car already exists
			}
		}
		
		return exists;
	}
	
	//userAlreadyExists returns a boolean result for use outside the function
	public static boolean userAlreadyExists(String userName) throws IOException {
		ArrayList<User> userDetails=readFile.readUserFile.getUserDetails();
		boolean exists=false;
		
		for (int i=0;i<userDetails.size();i++) {
			User current=userDetails.get(i);
			if (current.getUserName().equals(userName)) {//searches the data file by username
				exists=true;//if a matching username is found then the user already exists
			}
		}
		
		return exists;
	}
	
	//carIsAvailible returns a boolean for use outside of the function 
	public static boolean carIsAvailible(String reg) throws Exception {
		boolean isAvailible=false;
		reg=reg.toUpperCase();//done to make search case insensitive
		ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
		ArrayList<Car> unsold=search.availibleSearch.getAvailibleCars(database);//gets the ArrayList of available cars
		
		for (int i=0;i<unsold.size();i++) {//searches the ArrayList of available cars by registration number
			Car current=unsold.get(i);
			if (current.getRegNum().toUpperCase().equals(reg)) {//if the registration number of the current database item is the same as the search item then the car is available for purchase
				isAvailible=true;
			}
		}
		
		return isAvailible;
	}
}
