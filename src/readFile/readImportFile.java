//This class contains the function used to read the import file into an ArrayList for the addcars function

package readFile;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import cardealer.Car;


public class readImportFile {

	public static void main(String[] args){
	}
	
	public static ArrayList<Car> getCarImport() throws NumberFormatException, Exception{
		
		Scanner fileIn = new Scanner(new BufferedReader(new FileReader("cars-import.txt")));//starts the input stream
		ArrayList<Car> carImport=new ArrayList<Car>();
		while(fileIn.hasNextLine()){
			String[] line=fileIn.nextLine().split(",",-1);//uses the commas to split the line of the file, the -1 is so that the split function includes 
														  //the empty fields at the end of the lines so as not to cause index errors in the ArrayList
			for (int j=0;j<line.length;j++) {
				line[j]=line[j].trim();
			}
			carImport.add(new Car(line[0], line[1], line[2], line[3], line[4], Integer.parseInt(line[5]), line[6], line[7], Float.parseFloat(line[8]), line[9], line[10]));
			}
		fileIn.close();//closes the input stream
		return carImport;
	}
		


}
