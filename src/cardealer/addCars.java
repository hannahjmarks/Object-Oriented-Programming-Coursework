//This class contains the main function for adding multiple cars to the database via an import text file

package cardealer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class addCars {
	//returns a boolean, true if the request succeeds false otherwise
	public static boolean importCars() throws NumberFormatException, Exception {
		boolean success=true;
		ArrayList<Car> carImport;
		ArrayList<Car> database;
		try {//reads both the import and database files into their respective ArrayLists
			carImport=readFile.readImportFile.getCarImport();
			database=readFile.readDatabaseFile.getDatabase();
			
			for (int i=0;i<carImport.size();i++) {
				Car current=carImport.get(i);
				
				try {//tries to parse the arrival date (if there is no arrival date or that date is invalid then it is set as the current date)
					LocalDate arrivalDate=LocalDate.parse(current.getArriveDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					boolean noArriveDateError=errorChecking.dateSanityCheck.sanityChecker(arrivalDate);//sanity checks date
					
					if (noArriveDateError==false) {
						LocalDate today=LocalDate.now();
						String stringToday = Car.dateToString(today);
						current.arriveDate=stringToday;
					}else if (!current.getSellDate().equals("")) {//if the sell date is not blank
						
						try {//if the sell date is invalid then it is set as blank
							LocalDate sellDate=LocalDate.parse(current.getSellDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
							boolean noSellDateError=errorChecking.dateSanityCheck.sanityChecker(sellDate);//sanity checks the sell date
							if (noSellDateError==false) {
								current.sellDate="";
							}
						}catch(Exception e2) {
							current.sellDate="";
							e2.printStackTrace();
						}
					}
				}catch (Exception e) {
					LocalDate today=LocalDate.now();
					String stringToday = Car.dateToString(today);
					current.arriveDate=stringToday;
				}
				current.regNum=current.regNum.toUpperCase();//prevents database errors
				database.add(current);
				writeToFile.writeDatabase.printDatabase(database);//writes the updated database ArrayList to the relevant text file
				success=true;
			}
		}catch(Exception e1) {
			success=false;
		}	
		return success;
	}
}
