//This class contains the functions needed to sort the search results into the users chosen order within the search function.

package arraySorting;

import java.util.ArrayList;
import cardealer.Car;

public class arraySearchSort {
	//sortPriceAsc sorts the cars in the ArrayList in order by the price field from lowest to highest.
	public static ArrayList<Car> sortPriceAsc(ArrayList<Car> searchResults){
		for (int i=0;i<searchResults.size()-1;i++) {
			for(int j=0;j<searchResults.size()-i-1;j++) {//nested loop through ArrayList
				Car car1=searchResults.get(j);//gets the cars at position j and j+1 from the ArrayList
				Car car2=searchResults.get(j+1);
				float price1=car1.getPrice();//gets the price field of the cars
				float price2=car2.getPrice();
				if (price1>price2) {//swaps the positions of 2 elements of the ArrayList if the price of the first car is greater than the second
					searchResults.set(j, car2);
					searchResults.set(j+1, car1);
				}
			}
		}
		
		return searchResults;//returns the newly sorted ArrayList
	}
	
	//sortPriceDesc sorts the cars in the ArrayList in order by the price field from highest to lowest.
	public static ArrayList<Car> sortPriceDesc(ArrayList<Car> searchResults){
		for (int i=0;i<searchResults.size()-1;i++) {
			for(int j=0;j<searchResults.size()-i-1;j++) {//nested loop through ArrayList
				Car car1=searchResults.get(j);//gets the cars at position j and j+1 from the ArrayList
				Car car2=searchResults.get(j+1);
				float price1=car1.getPrice();//gets the price field of the cars
				float price2=car2.getPrice();
				if (price1<price2) {//swaps the positions of 2 elements of the ArrayList if the price of the first car is less than the second
					searchResults.set(j, car2);
					searchResults.set(j+1, car1);
				}
			}
		}
		
		return searchResults;//returns the newly sorted ArrayList
	}
	
	//sortModel sorts the cars in the ArrayList alphabetically by the model.
	public static ArrayList<Car> sortModel(ArrayList<Car> searchResults){
		for (int i=0;i<searchResults.size()-1;i++) {
			for(int j=0;j<searchResults.size()-i-1;j++) {//nested loop through ArrayList
				Car car1=searchResults.get(j);//gets the cars at position j and j+1 from the ArrayList
				Car car2=searchResults.get(j+1);
				String model1=car1.getModel();//gets the model field of the cars
				String model2=car2.getModel();
				if(model1.toLowerCase().compareTo(model2.toLowerCase())>0) {//swaps the positions of 2 elements of the ArrayList if the model of the first car is alphbetically after the second
					searchResults.set(j, car2);
					searchResults.set(j+1, car1);
				}
			}
		}
		
		return searchResults;//returns the newly sorted ArrayList
	}
	
	//sortMileage sorts the cars in the ArrayList in order by the mileage field from lowest to highest.
	public static ArrayList<Car> sortMileage(ArrayList<Car> searchResults){
		for (int i=0;i<searchResults.size()-1;i++) {
			for(int j=0;j<searchResults.size()-i-1;j++) {//nested loop through ArrayList
				Car car1=searchResults.get(j);//gets the cars at position j and j+1 from the ArrayList
				Car car2=searchResults.get(j+1);
				int mile1=car1.getMilegae();//gets the mileage field of the cars
				int mile2=car2.getMilegae();
				if (mile1>mile2) {//swaps the positions of 2 elements of the ArrayList if the mileage of the first car is greater than the second
					searchResults.set(j, car2);
					searchResults.set(j+1, car1);
				}
			}
		}
		
		return searchResults;//returns the newly sorted ArrayList
	}
}
