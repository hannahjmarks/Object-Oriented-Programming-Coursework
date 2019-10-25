//This class contains the function used to error check the input for the sell car function

package errorChecking;

import javax.swing.JOptionPane;

public class sellCarInputCheck {
	//returns a boolean, true if no errors are detected or false otherwise
	public static boolean checkInput(String reg) throws NumberFormatException, Exception {
		boolean noError=true;
		String errorMsg=null;
		
		//if the input is empty then the appropriate error message is displayed
		if (Interface.log_In.role.equals("admin")||Interface.log_In.role.equals("staff")) {
			if (reg==null||reg.isEmpty()) {
				noError=false;
				errorMsg="Please enter a Registration Number";
				JOptionPane.showMessageDialog(null, errorMsg);
			}else {
				//if the length of the input is less than 7 then the appropriate error message is displayed
				if (reg.length()!=7) {
					noError=false;
					errorMsg="The Registration Number must be 7 characters long\nand should contain only letters and numbers";
					JOptionPane.showMessageDialog(null, errorMsg);
					
				//if there is a comma in the input then the appropriate error message is displayed
				}else if(reg.indexOf(",")>-1||reg.indexOf(" ")>-1) {
					noError=false;
					errorMsg="The Registration Number must be 7 characters long\nand should contain only letters and numbers";
					JOptionPane.showMessageDialog(null, errorMsg);
				}else {
					
					//if the car does not exist or is not available then the appropriate error message is displayed
					boolean exists=search.exists.carAlreadyExists(reg);
					boolean isAvailible=search.exists.carIsAvailible(reg);
					if (exists==false||isAvailible==false) {
						noError=false;
						errorMsg="There is no car with this registration number or it has already been sold\nPlease try again";
						JOptionPane.showMessageDialog(null, errorMsg);
					}
				}
			}
		}else {
			noError=false;
			errorMsg="Only admin and staff users can access this function";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		return noError;
	}

}
