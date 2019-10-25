//This class writes the database ArrayList to the database text file. It is called whenever the database needs updating during the sell car, add car
//and add cars functions

package writeToFile;

import java.io.PrintWriter;
import java.util.ArrayList;

import cardealer.Car;

public class writeDatabase {
	//takes the database ArrayList and prints it to the database text file
	public static void printDatabase(ArrayList<Car> database) throws NumberFormatException, Exception {
		PrintWriter carOutput=new PrintWriter("cars-database.txt");	//starts output stream	
		for (int i=0;i<database.size();i++) {
			Car current=database.get(i);
			String currentString=current.carToString();//converts the current car from the ArrayList to a string to be printed to the file
			carOutput.println(currentString);//prints the car to the database file
		}
		carOutput.close();//closes the output stream
	}

}
