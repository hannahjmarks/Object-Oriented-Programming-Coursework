//This class contains the function that adds a new user to the user database

package cardealer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class addUser {
	//returns a boolean, true if the request succeeds false otherwise
	public static boolean addNewUser(String userName, String password, String role) {
		boolean success;
		String errorMsg=null;
		
		try {//try to create a new User object and add it to the user ArrayList
			User newUser = new User(userName, password, role);
			ArrayList<User> userDetails=readFile.readUserFile.getUserDetails();
			userDetails.add(newUser);
			writeToFile.writeUser.printUsers(userDetails);//writes the updated ArrayList to the relevant text file
			
			success=true;
		}catch(Exception e){
			success=false;
			errorMsg="File error\nRequestNot Completed";
			JOptionPane.showMessageDialog(null, errorMsg);
		}
		
		return success;
	}

}
