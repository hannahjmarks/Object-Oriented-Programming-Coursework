//This class contains the function used to error check the input for the 

package errorChecking;

import javax.swing.JOptionPane;

public class addCarInputCheck {
	//returns a boolean, true if no errors are detected and false otherwise
	public static boolean inputCheck(String reg, String model, String colour, String mileage, String accHist, String price) throws NumberFormatException, Exception {
		boolean noError=true;
		String errorMsg=null;
		
		//if the input is empty then the appropriate error message is displayed
		if (reg==null||reg.isEmpty()||model==null||model.isEmpty()||colour==null||colour.isEmpty()||mileage==null||mileage.isEmpty()||accHist==null||accHist.isEmpty()||price==null||price.isEmpty()) {
			noError=false;
			errorMsg="Please enter all fields";
			JOptionPane.showMessageDialog(null, errorMsg);
			
		//for the following 6 if statements the length is incorrect then the appropriate error message is displayed
		}else if(reg.length()!=7) {
			noError=false;
			errorMsg="Registration Numbers can only be 7 characters long";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if(model.length()>30) {
			noError=false;
			errorMsg="Make and Model is too long";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if(colour.length()>10) {
			noError=false;
			errorMsg="Colour is too long";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if(mileage.length()>10) {
			noError=false;
			errorMsg="Mileage has too many characters (max 10)";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if(accHist.length()>60) {
			noError=false;
			errorMsg="Accident History is too long";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if (price.length()>10) {
			noError=false;
			errorMsg="Price is too long (max 10 characters)";
			JOptionPane.showMessageDialog(null, errorMsg);
			
			
		//if there is a comma in any of the inputs then the appropriate error message is displayed	
		}else if(reg.indexOf(",")>-1||model.indexOf(",")>-1||colour.indexOf(",")>-1||mileage.indexOf(",")>-1||accHist.indexOf(",")>-1||price.indexOf(",")>-1) {
			noError=false;
			errorMsg="Please do not use \",\" in any of the fields";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else if(Interface.log_In.role.equals("customer")) {
			noError=false;
			errorMsg="This function can only be accessed by Staff and Admin users";
			JOptionPane.showMessageDialog(null, errorMsg);
		}else {
			//if the car already exists in the database then the appropriate error message is displayed
			boolean duplicate=search.exists.carAlreadyExists(reg);
			if (duplicate==true) {
				noError=false;
				errorMsg="There is already a car with this registration\nPlease try again";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		return noError;
	}
}
