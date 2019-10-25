//This class contains the function used to error check the input for the 

package errorChecking;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import cardealer.Car;

public class addCarsFileCheck {
	//returns a boolean, true if no errors are detected and false otherwise
	public static boolean importFileCheck() {
		boolean noError=true;
		String errorMsg=null;
		ArrayList<Car> carImport;
		
		try {//try to read the import file into the ArrayList, if it fails then the appropriate error message is displayed
			carImport=readFile.readImportFile.getCarImport();
			ArrayList<Car> database=readFile.readDatabaseFile.getDatabase();
			for (int i=0;i<carImport.size();i++) {
				Car current=carImport.get(i);
				for (int j=i+1;j<carImport.size();j++) {//nested loop begins at the next index of the outer loop to compare each entry to the ones after it
					Car regCheck=carImport.get(j);
					if (current.getRegNum().toUpperCase().equals(regCheck.getRegNum().toUpperCase())) {//if the registration numbers match then the appropriate error message is displayed
						noError=false;
						errorMsg="There appears to be at least one repeated registration number in the import file";
						JOptionPane.showMessageDialog(null, errorMsg);
					}
				}
				for (int k=0;k<database.size();k++) {//nested loop to check all import entries against all database entries
					Car databaseCheck=database.get(k);
					if (current.getRegNum().toUpperCase().equals(databaseCheck.getRegNum())) {//if the registration numbers match then the appropriate error message is displayed
						noError=false;
						errorMsg="There appears to be at least one car in the file already in the database";
						JOptionPane.showMessageDialog(null, errorMsg);
					}
			}
			}
		}catch (Exception e) {
			noError=false;
			errorMsg="There appears to be an error in the import file please press \"Help\"";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		return noError;
	}
}
