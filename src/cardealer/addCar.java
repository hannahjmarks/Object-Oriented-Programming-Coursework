package cardealer;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import cardealer.Car;

public class addCar {
	//returns a boolean, true if the request succeeds false otherwise
	public static boolean addNewCar(String reg, String model, String body, String size, String colour, String mileage, String accHist, String tran, String price) {
		boolean success;
		String errorMsg=null;
		
		try {
			//converts required variables
			int mileageInt=Integer.parseInt(mileage);
			float priceFloat=Float.parseFloat(price);
			LocalDate today=LocalDate.now();
			String aDate=Car.dateToString(today);
			String sDate="";
			
			if (!body.equals("Van")) {//if it is not a van then the size is set as blank to prevent errors
				size="";
			}
			
			//constructs new Car object and adds it to the database ArrayList
			Car newCar = new Car(reg,model,body,size,colour,mileageInt,accHist,tran.toLowerCase(),priceFloat,aDate,sDate);
			ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
			database.add(newCar);
			writeToFile.writeDatabase.printDatabase(database);//writes the updated database to the relevant text file
			
			success=true;
		}catch(Exception e){
			success=false;
			errorMsg="File error\nRequestNot Completed";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		return success;
	}
}
