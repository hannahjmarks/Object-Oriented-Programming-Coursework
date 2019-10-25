//This class writes an ArrayList of cars to the output file for the print cars function

package writeToFile;

import java.io.PrintWriter;
import java.util.ArrayList;
import cardealer.Car;

public class writePrintOutput {
	//returns a boolean to display a message to the user if the request succeeds
	public static boolean printOutput() throws NumberFormatException, Exception {
		boolean success=true;
		
		try {//uses nested try statements to identify which part of the code is generating errors if any
			PrintWriter carOutput=new PrintWriter("cars-output.txt");
			ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
			
			try {//split the database ArrayList into sold and available cars
				ArrayList<Car> soldCars=search.soldSearch.getSoldCars(database);
				ArrayList<Car> unsoldCars=search.availibleSearch.getAvailibleCars(database);
				
				try {//sorts the 2 ArrayLists into date order by sell date for sold cars and arrival date for available cars
					ArrayList<Car> sortedSoldCars=arraySorting.databaseSort.soldSort(soldCars);
					ArrayList<Car> sortedUnsoldCars=arraySorting.databaseSort.availibleDateSort(unsoldCars);
					
					try {//prints the ArrayList of sold cars to the file complete with headings
						carOutput.println("SOLD CARS-----------------------------------------------------------------------------");
						carOutput.println("Registration Number |Make and Model                |Body Type |Size(Van only) |Colour    |Mileage   |Accident History                                            |Transmission   |Price(£)  |Arrival Date   |Sell Date      |");
					
						for (int i=0;i<sortedSoldCars.size();i++) {//gets all required fields for each car as a separate string for formatting
							Car current=sortedSoldCars.get(i);
							String reg=current.getRegNum();
							String mod=current.getModel();
							String bdy=current.getBType();
							String size=current.getSize();
							String col=current.getColour();
							int mil=current.getMilegae();
							String accHist=current.getAccHist();
							String tran=current.getTransmission();
							float price=current.getPrice();
							String aDate=current.getArriveDate();
							String sDate=current.getSellDate();
						
							//prints a formatted string to the file
							carOutput.printf("%-20s %-30s %-10s %-15s %-10s %-10d %-60s %-15s %-10.2f %-15s %-15s %n",reg,mod,bdy,size,col,mil,accHist,tran,price,aDate,sDate);
						}
						try {//prints the ArrayList of available cars to the file complete with headings
							carOutput.println("\n\n");
							carOutput.println("UNSOLD CARS-----------------------------------------------------------------------------");
							carOutput.println("Registration Number |Make and Model                |Body Type |Size(Van only) |Colour    |Mileage   |Accident History                                            |Transmission   |Price(£)  |Arrival Date   |");		
							
							for (int j=0;j<sortedUnsoldCars.size();j++) {//gets all required fields for each car as a separate string for formatting
								Car current=sortedUnsoldCars.get(j);
								String reg=current.getRegNum();
								String mod=current.getModel();
								String bdy=current.getBType();
								String size=current.getSize();
								String col=current.getColour();
								int mil=current.getMilegae();
								String accHist=current.getAccHist();
								String tran=current.getTransmission();
								float price=current.getPrice();
								String aDate=current.getArriveDate();
							
								//prints a formatted string to the file
								carOutput.printf("%-20s %-30s %-10s %-15s %-10s %-10d %-60s %-15s %-10.2f %-15s %n",reg,mod,bdy,size,col,mil,accHist,tran,price,aDate);
							}
						}catch(Exception e4) {//catches exceptions thrown when printing the available cars
							System.out.println("e4");
							e4.printStackTrace();
							success=false;
						}
					}catch (Exception e3) {//catches exceptions thrown when printing the sold cars
						System.out.println("e3");
						e3.printStackTrace();
						success=false;
					}
				}catch(Exception e2) {//catches exceptions thrown when sorting the sold and available cars ArrayLists
					System.out.println("e2");
					e2.printStackTrace();
					success=false;
				}
			}catch(Exception e1) {//catches exceptions thrown when generating the sold and available cars ArrayLists from the database
				System.out.println("e1");
				e1.printStackTrace();
				success=false;
			}
			
			carOutput.close();//closes the output stream
			
		}catch(Exception e) {//catches exceptions thrown when generating the database ArrayList from the file
			System.out.println("e");
			e.printStackTrace();
			success=false;
		}
		return success;
	}
	
}
