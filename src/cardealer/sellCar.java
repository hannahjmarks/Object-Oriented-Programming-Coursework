//This class contains the main sell car function that is called when the user clicks the required button on the interface

package cardealer;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.util.ArrayList;


public class sellCar {
	//function returns a boolean in order to show that the request has succeeded and that an appropriate message can therefore be shown to the user
	public static boolean sellCarFunction(String reg) throws Exception {
		boolean success;
		String errorMsg=null;
		try {
			//gets the car with the input registration number and its index from the database
			Car carToSell=search.carSearch.getUnsoldCar(reg);
			int carIndex=search.carSearch.getUnsoldCarIndex(reg);
			ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();//loads the database file into a local ArrayList
			carToSell.sellDate=Car.dateToString(LocalDate.now());//sets the sell date of the car to the current date and updates the database entry
			database.set(carIndex, carToSell);
			writeToFile.writeDatabase.printDatabase(database);//writes the updated database to its file
			success=true;
		}catch(Exception e) {//in the event of a runtime error an error message is displayed to the user and the stack trace is printed to the console
			e.printStackTrace();
			errorMsg="Error request not completed";
			JOptionPane.showMessageDialog(null, errorMsg);
			success=false;
		}
		
		return success;
	}

}
