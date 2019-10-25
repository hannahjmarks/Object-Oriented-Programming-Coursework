//This class contains the help window for the addCars function

package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;

public class help_Add_Cars {

	private JFrame frmHelp;

	//launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help_Add_Cars window = new help_Add_Cars();
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public help_Add_Cars() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("Help");
		frmHelp.getContentPane().setBackground(new Color(255, 255, 255));
		frmHelp.getContentPane().setForeground(new Color(0, 0, 0));
		frmHelp.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmHelp.getContentPane().setLayout(null);
		
		JTextArea txtrHelp = new JTextArea();
		txtrHelp.setEditable(false);
		txtrHelp.setFont(new Font("Arial", Font.BOLD, 14));
		txtrHelp.setText("Help:\r\nThe Import file can be found in the program directory.\r\n\r\nEach Car must be on their own line and has a total of 11 fields (i.e. there should be 10 commas).\r\n\r\nYou must not leave empty lines between cars.\r\n\r\nCommas(\",\") are used to seperate the different fields and can therefore not be used anywhere\r\nelse.\r\n\r\nThe format for each car is as follows:\r\nRegistration Number, Model, Body Type, Size, Colour, Mileage, Accident History, Transmission, Price, Arrival Date, Sell Date\r\n\r\nRegistration Number: 7 characters long, no spaces.\r\n\r\nModel: the make and model of the car (max 30 characters).\r\n\r\nBody Type: the acceptable body types are [Coupe, Hatchback, MPV, Saloon, SUV, Van]\r\n\r\nSize: ths size (small or large) is only applicable to Vans and should be left empty otherwise i.e. hatchback,, blue\r\n\r\nColour: the colour of the car (max 10 characters).\r\n\r\nMileage: the mileage of the car should be an integer (max 10 characters).\r\n\r\nAccident History:the accident history of the car (max 60 characters).\r\n\r\nTransmission: either \"manual\" or \"automatic\".\r\n\r\nPrice: the price in GBP the car will be sold at, please do NOT include \"\u00A3\" (max 10 characters).\r\n\r\nArrival Date: the arrival date of the car in the format \"yyyy-mm-dd\", if left blank or invalid todays date will be used.\r\n\r\nSell Date: the sell date of the car should be the same format as the arrival date or blank if unsold, invalid dates will be made blank.");
		txtrHelp.setBounds(10, 0, 893, 584);
		frmHelp.getContentPane().add(txtrHelp);
		frmHelp.setBounds(100, 100, 925, 630);
		//closes only the help window on close rather than the whole program
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
