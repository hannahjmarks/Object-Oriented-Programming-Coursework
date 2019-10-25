//This class contains the function used to error check the input for the new user function

package errorChecking;

import javax.swing.JOptionPane;

public class newUserInputCheck {
	//returns a boolean, true if no errors are detected and false otherwise
	public static boolean inputCheck(String userName, String password, String confirmPassword) {
		boolean noErrors=true;
		String errorMsg=null;
		
		if (Interface.log_In.role.equals("admin")) {
			//if the input is empty then the appropriate error message is displayed
			if (userName==null||userName.isEmpty()||password==null||password.isEmpty()||confirmPassword==null||confirmPassword.isEmpty()) {
				noErrors=false;
				errorMsg="Please input into all the fields";
				JOptionPane.showMessageDialog(null, errorMsg);
				
			//if the user name or password exceeds 20 characters in length then the appropriate error message is displayed
			} else if (userName.length()>20||password.length()>20) {
				noErrors=false;
				errorMsg="Usernames and Passwords can be at most 20 Characters";
				JOptionPane.showMessageDialog(null, errorMsg);
				
			//if there is a comma in either the user name or password then the appropriate error message is displayed
			} else if (userName.indexOf(",")>-1||password.indexOf(",")>-1) {
				noErrors=false;
				errorMsg="Usernames and Passwords cannot contain \",\"";
				JOptionPane.showMessageDialog(null, errorMsg);
				
			//if the password and password confirmation do not match then the appropriate error message is displayed
			} else if (!password.equals(confirmPassword)) {
				noErrors=false;
				errorMsg="Passwords must Match";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}else {
			errorMsg = "Administrator access Only";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		return noErrors;
	}
}
