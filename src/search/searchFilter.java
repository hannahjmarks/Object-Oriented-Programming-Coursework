//This class contains the search functions called by the interface used to filter out the cars from the database that do not match the search criteria 

package search;

import java.util.ArrayList;
import cardealer.Car;

public class searchFilter {
	//searchCars filters the vans out of the search results
	public static ArrayList<Car> searchCars(ArrayList<Car> availibleCars){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			String body=current.getBType().toUpperCase();//gets the body type of the current car
			if (body.equals("VAN")) {
			}else {//if the body type of the current car is not "van" then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchVans filters all the cars out of the search results
	public static ArrayList<Car> searchVans(ArrayList<Car> availibleCars){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			String body=current.getBType().toUpperCase();//gets the body type of the current database entry
			if (body.equals("VAN")) {//if the body type of the current database entry is "van" then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	public static ArrayList<Car> searchTransmission(ArrayList<Car> availibleCars,String searchItem){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			String transmission=current.getTransmission().toUpperCase();
			searchItem=searchItem.toUpperCase();
			if (transmission.equals(searchItem)) {
				results.add(current);
			}
		}
		return results;
	}
	
	//searchModel filters out all the cars whose model field do not contain the search item
	public static ArrayList<Car> searchModel(ArrayList<Car> availibleCars,String searchItem){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);//gets the model of the current database entry
			String model=current.getModel().toUpperCase();//converts model to upper case so that the input is case insensitive
			searchItem=searchItem.toUpperCase();
			if (model.indexOf(searchItem)>-1) {//if the model of the current database entry contains the search item then its index will be greater than 0 
				results.add(current);
			}
		}
		return results;
	}
	
	//searchColour filters out all the cars whose colour field do not contain teh search item
	public static ArrayList<Car> searchColour(ArrayList<Car> availibleCars,String searchItem){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			String colour=current.getColour().toUpperCase();//converts the colour to upper case so that the input is case insensitive
			searchItem=searchItem.toUpperCase();
			if (colour.indexOf(searchItem)>-1) {//if the colour of the current database entry contains the search item then its index wil be greater than 0
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMileage filters out all the cars whose mileage is greater than the search item
	public static ArrayList<Car> searchMileage(ArrayList<Car> availibleCars,String searchItem){
		ArrayList<Car> results=new ArrayList<Car>();
		int intSearchItem=Integer.parseInt(searchItem);//converts the search item to an integer
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			int mileage=current.getMilegae();
			if (mileage<=intSearchItem) {//if the mileage of the current car is lower than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMinSeats filters out all of the cars who have fewer seats than the search item
	public static ArrayList<Car> searchMinSeats(ArrayList<Car> availibleCars,String searchMin){
		int intSearchMin=Integer.parseInt(searchMin);
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			int seats=current.getSeats();
			if (seats>=intSearchMin) {//if the current car has more seats than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMaxSeats filters out all of the cars who have more seats than the search item
	public static ArrayList<Car> searchMaxSeats(ArrayList<Car> availibleCars,String searchMax){
		int intSearchMax=Integer.parseInt(searchMax);
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			int seats=current.getSeats();
			if (seats<=intSearchMax) {//if the current car has fewer seats than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMinDoors filters out the cars that have fewer doors than the search item
	public static ArrayList<Car> searchMinDoors(ArrayList<Car> availibleCars,String searchMin){
		int intSearchMin=Integer.parseInt(searchMin);
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			int doors=current.getDoors();
			if (doors>=intSearchMin) {//if the current car has more doors than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMaxDoors filters out the cars that have more doors than the search item
	public static ArrayList<Car> searchMaxDoors(ArrayList<Car> availibleCars,String searchMax){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			int doors=current.getDoors();
			int intSearchMax=Integer.parseInt(searchMax);
			if (doors<=intSearchMax) {//if the current car has fewer doors than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		return results;
	}
	
	//searchMinPrince filters out the cars that are less expensive than the minimum price set by the user
	public static ArrayList<Car> searchMinPrice(ArrayList<Car> availibleCars,String searchMin){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			float price=current.getPrice();
			float fSearchMin=Float.parseFloat(searchMin);
			if (price>=fSearchMin) {//if the current car is more expensive than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		
		return results;
	}
	
	//searchMaxPrince filters out the cars that are more expensive than the maximum price set by the user
	public static ArrayList<Car> searchMaxPrice(ArrayList<Car> availibleCars,String searchMax){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			float price=current.getPrice();
			float fSearchMax=Float.parseFloat(searchMax);
			if (price<=fSearchMax) {//if the current car is less expensive than the search item then it is added to the results ArrayList
				results.add(current);
			}
		}
		
		return results;
	}
	
	//searchSize filters out the vans that are not the same size as the size selected by the user
	public static ArrayList<Car> searchSize(ArrayList<Car> availibleCars,String searchItem){
		ArrayList<Car> results=new ArrayList<Car>();
		for (int i=0;i<availibleCars.size();i++) {
			Car current=availibleCars.get(i);
			String size=current.getSize().toUpperCase();
			searchItem=searchItem.toUpperCase();
			if (size.equals(searchItem)) {//if the size of the current van is the same as that specified by the user then it is added to the ArrayList
				results.add(current);
			}
		}
		return results;
	}
}
