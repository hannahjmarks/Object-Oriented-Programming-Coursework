//This class writes an ArrayList to the file containing the user login details

package writeToFile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cardealer.User;

public class writeUser {
	public static void printUsers(ArrayList<User> userDetails) throws FileNotFoundException {
		PrintWriter userOutput=new PrintWriter("cars-users.txt");		
		for (int i=0;i<userDetails.size();i++) {
			User current=userDetails.get(i);//gets a single user from the ArrayList to write as a single line into the file
			String encryptPassword=encryption.encrypter.encrypt(current.getPassword());//password is encrypted when written into the file
			userOutput.println(current.getUserName()+","+encryptPassword+","+current.getRole());//output stream adds user information to file
		}
		userOutput.close();//close output stream
	}
}
