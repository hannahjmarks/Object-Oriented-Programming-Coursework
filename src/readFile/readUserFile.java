//This class contains the function used to read the user details from the relevant text file

package readFile;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import cardealer.User;


public class readUserFile {	
	public static ArrayList<User> getUserDetails() throws IOException{
		
		Scanner fileIn = new Scanner(new BufferedReader(new FileReader("cars-users.txt")));//input stream starts
		ArrayList<User> userDetails=new ArrayList<User>();
		while(fileIn.hasNextLine()){
			String[] line=fileIn.nextLine().split(",",-1);//uses the commas to split the line of the file, the -1 is so that the split function includes 
														  //the empty fields at the end of the lines so as not to cause index errors in the ArrayList
			
			//password is decoded here
			userDetails.add(new User(line[0], encryption.encrypter.decrypt(line[1]), line[2]));
			}
		fileIn.close();//close input stream
		return userDetails;
	}
}
