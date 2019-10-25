//This class contains the function used to error check the date input for the calculate revenue function

package errorChecking;

import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class calcRevDateCheck {
	//returns a boolean, true if no errors are detected and false otherwise
	public static boolean dateCheck(String sDate) {
		boolean noError=true;
		String errorMsg=null;
		
		if (Interface.log_In.role.equals("admin")||Interface.log_In.role.equals("staff")) {
			
			//if the input is empty then the appropriate error message is displayed
			if (sDate==null||sDate.isEmpty()) {
				noError=false;
				errorMsg="Please input a date";
				JOptionPane.showMessageDialog(null, errorMsg);
			}else {
				
				//if the length is not exactly 10 characters then the appropriate error message is displayed
				if (sDate.length()!=10) {
					noError=false;
					errorMsg="Please enter a valid date in the correct format";
					JOptionPane.showMessageDialog(null, errorMsg);
				}else {
					try {
						//if the date input is invalid or in an incorrect format then the appropriate error message is displayed
						LocalDate date=LocalDate.parse(sDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						boolean dateIsValid=errorChecking.dateSanityCheck.sanityChecker(date);//date is run through a separate function to test sanity
						if (dateIsValid==false) {
							noError=false;
							errorMsg="Please enter a valid date in the correct format";
							JOptionPane.showMessageDialog(null, errorMsg);
						}
					}catch(Exception e2) {
						noError=false;
						errorMsg="Please enter a valid date in the correct format";
						JOptionPane.showMessageDialog(null, errorMsg);
						e2.printStackTrace();
					}
				}
			}
		
		}else {
			noError=false;
			errorMsg="Function only accessible for admin and staff users";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		
		
		return noError;
	}

}
