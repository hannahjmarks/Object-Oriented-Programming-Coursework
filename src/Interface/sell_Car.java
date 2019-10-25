//This class contains the user interface for the sellCar function

package Interface;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import cardealer.Car;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class sell_Car {
	
	String errorMsg=null;

	private JFrame frmSellCar;

	//launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sell_Car window = new sell_Car();
					window.frmSellCar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public sell_Car() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmSellCar = new JFrame();
		frmSellCar.setTitle("Sell Car");
		frmSellCar.getContentPane().setBackground(Color.WHITE);
		frmSellCar.getContentPane().setLayout(null);
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmSellCar.dispose();
			}
		});
		btnLogOut.setBounds(0, 0, 100, 30);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		frmSellCar.getContentPane().add(btnLogOut);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmSellCar.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmSellCar.dispose();
				}
				else {
					errorMsg="Error With User Role\nPlease Log In Again";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		btnMainMenu.setBounds(300, 0, 125, 30);
		btnMainMenu.setForeground(new Color(255, 255, 255));
		btnMainMenu.setBackground(new Color(102, 0, 153));
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		frmSellCar.getContentPane().add(btnMainMenu);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number:");
		lblRegistrationNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegistrationNumber.setBounds(40, 60, 120, 14);
		frmSellCar.getContentPane().add(lblRegistrationNumber);
		
		JTextField txtRegNum = new JTextField();
		txtRegNum.setBounds(40, 85, 230, 30);
		frmSellCar.getContentPane().add(txtRegNum);
		txtRegNum.setColumns(10);
		
		JTextArea txtAreaConfirmCar = new JTextArea();
		txtAreaConfirmCar.setBackground(new Color(248, 248, 255));
		txtAreaConfirmCar.setBounds(40, 152, 340, 302);
		frmSellCar.getContentPane().add(txtAreaConfirmCar);
		
		//when the find car button is clicked
		JButton btnFindCar = new JButton("Find Car");
		btnFindCar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String reg=txtRegNum.getText().toUpperCase();
				boolean noError=false;
				
				try {
					noError=errorChecking.sellCarInputCheck.checkInput(reg);//user input is run through the appropriate error checking function
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if (noError==true) {
					try {
						Car displayCar=search.carSearch.getUnsoldCar(reg);//gets the car with the matching registration number from the database
						
						//prints the car to the text area so that the user can comfirm that they have selected the correct car
						String pntReg="Registration: "+reg+"\n";
						String pntModel="Model: "+displayCar.getModel()+"\n";
						String pntBody="Body Type: "+displayCar.getBType()+"\n";
						String pntSize="Size: "+displayCar.getSize()+"\n";
						String pntCol="Colour: "+displayCar.getColour()+"\n";
						String pntMile="Mileage: "+displayCar.getMilegae()+"\n";
						String pntAccHist="Accident History: "+displayCar.getAccHist()+"\n";
						String pntTran="Transmission: "+displayCar.getTransmission()+"\n";
						String pntPrice=String.format("Price: £%.2f%n", displayCar.getPrice());
						
						txtAreaConfirmCar.insert(pntReg, 0);
						txtAreaConfirmCar.append(pntModel);
						txtAreaConfirmCar.append(pntBody);
						if (pntBody.toLowerCase().equals("van")) {//checks whether or not the vehicle is a van before printing the size
							txtAreaConfirmCar.append(pntSize);
						}
						txtAreaConfirmCar.append(pntCol);
						txtAreaConfirmCar.append(pntMile);
						txtAreaConfirmCar.append(pntAccHist);
						txtAreaConfirmCar.append(pntTran);
						txtAreaConfirmCar.append(pntPrice);
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnFindCar.setBounds(280, 85, 100, 30);
		btnFindCar.setForeground(new Color(255, 255, 255));
		btnFindCar.setBackground(new Color(102, 0, 153));
		btnFindCar.setFont(new Font("Arial", Font.BOLD, 14));
		frmSellCar.getContentPane().add(btnFindCar);
		
		//when the user clicks the sell car button
		JButton btnSellCar = new JButton("Sell Car");
		btnSellCar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String reg=txtRegNum.getText().toUpperCase();//gets the user input
				boolean noError=false;
				
				try {
					noError=errorChecking.sellCarInputCheck.checkInput(reg);//user input is run through the appropriate error checking function
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (noError==true) {
					try {
						boolean success=cardealer.sellCar.sellCarFunction(reg);//runs the sellCar function providing that the input has passed error checks
						if (success==true) {
							//success message is displayed, current window is closed and the appropriate menu is opened
							String msg="Car Sold";
							JOptionPane.showMessageDialog(null, msg);
							if (Interface.log_In.role.equals("admin")) {
								Interface.main_Menu_Admin.main(null);
								frmSellCar.dispose();
							}else if (Interface.log_In.role.equals("staff")) {
								Interface.main_Menu_Staff.main(null);
								frmSellCar.dispose();
							}
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
				
				
				
			}
		});
		btnSellCar.setBounds(149, 465, 100, 30);
		btnSellCar.setForeground(new Color(255, 255, 255));
		btnSellCar.setBackground(new Color(102, 0, 153));
		btnSellCar.setFont(new Font("Arial", Font.BOLD, 14));
		frmSellCar.getContentPane().add(btnSellCar);
		frmSellCar.setBounds(100, 100, 436, 550);
		frmSellCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
