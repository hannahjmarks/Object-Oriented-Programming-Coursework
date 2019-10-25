package Interface;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;

import cardealer.Car;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class add_Cars {
	
	String errorMsg=null;

	private JFrame frmAddCars;

	//launches the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_Cars window = new add_Cars();
					window.frmAddCars.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public add_Cars() {
		initialize();
	}

	//initialises the components within the JFrame
	private void initialize() {
		frmAddCars = new JFrame();
		frmAddCars.setResizable(false);
		frmAddCars.setTitle("Add Cars");
		frmAddCars.getContentPane().setBackground(new Color(255, 255, 255));
		frmAddCars.getContentPane().setLayout(null);
		
		JTextArea txtAreaDisplay = new JTextArea();
		txtAreaDisplay.setBackground(new Color(248, 248, 255));
		txtAreaDisplay.setBounds(20, 92, 746, 319);
		frmAddCars.getContentPane().add(txtAreaDisplay);
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmAddCars.dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(102, 0, 153));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogout.setBounds(0, 0, 100, 30);
		frmAddCars.getContentPane().add(btnLogout);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Interface.log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmAddCars.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmAddCars.dispose();
				}
				else {
					errorMsg="Error With User Role\nPlease Log In Again";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		btnMainMenu.setForeground(new Color(255, 255, 255));
		btnMainMenu.setBackground(new Color(102, 0, 153));
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		btnMainMenu.setBounds(673, 0, 125, 30);
		frmAddCars.getContentPane().add(btnMainMenu);
		
		//when the display file button is clicked
		JButton btnDisplayFile = new JButton("Display File");
		btnDisplayFile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Interface.log_In.role.equals("admin")||Interface.log_In.role.equals("staff")) {
					boolean noError=errorChecking.addCarsFileCheck.importFileCheck();//file is checked for input errors
					if (noError==true) {
						ArrayList<Car> carImport=null;
						try {
							carImport=readFile.readImportFile.getCarImport();//gets the contents of the import file
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						for (int i=0;i<carImport.size();i++) {//displays the import file in the text area
							Car displayCar=carImport.get(i);
							
							String sDisplayCar=displayCar.carToString();
							txtAreaDisplay.append(sDisplayCar+"\n");
						}
					}
				}else {
					String errorMsg="Only admin and staff have access to this function";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		btnDisplayFile.setForeground(new Color(255, 255, 255));
		btnDisplayFile.setBackground(new Color(102, 0, 153));
		btnDisplayFile.setFont(new Font("Arial", Font.BOLD, 14));
		btnDisplayFile.setBounds(186, 422, 125, 30);
		frmAddCars.getContentPane().add(btnDisplayFile);
		
		//when the add cars button is clicked
		JButton btnAddCars = new JButton("Add Cars");
		btnAddCars.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Interface.log_In.role.equals("admin")||Interface.log_In.role.equals("staff")) {
					boolean noError=errorChecking.addCarsFileCheck.importFileCheck();//checks the file for input errors
					if (noError==true) {
						try {
							boolean success=cardealer.addCars.importCars();//imports the file and adds the contents to the database
							if(success==true) {//if the request was successful then a message is displayed, the current window is closed and the appropriate menu is opened
								String msg="Request Completed";
								JOptionPane.showMessageDialog(null, msg);
								if (Interface.log_In.role.equals("admin")) {
									Interface.main_Menu_Admin.main(null);
									frmAddCars.dispose();
								}else {
									Interface.main_Menu_Staff.main(null);
									frmAddCars.dispose();
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}else {
					String errorMsg="Only admin and staff have access to this function";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
				
			}
		});
		btnAddCars.setForeground(new Color(255, 255, 255));
		btnAddCars.setBackground(new Color(102, 0, 153));
		btnAddCars.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCars.setBounds(456, 422, 125, 30);
		frmAddCars.getContentPane().add(btnAddCars);
		
		JLabel lblUserInfo = new JLabel("Click the Display File button to display the file contents bellow:");
		lblUserInfo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUserInfo.setBounds(20, 64, 643, 14);
		frmAddCars.getContentPane().add(lblUserInfo);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.help_Add_Cars.main(null);
			}
		});
		btnHelp.setForeground(new Color(255, 255, 255));
		btnHelp.setBackground(new Color(102, 0, 153));
		btnHelp.setFont(new Font("Arial", Font.BOLD, 14));
		btnHelp.setBounds(673, 56, 93, 30);
		frmAddCars.getContentPane().add(btnHelp);
		frmAddCars.setBounds(100, 100, 800, 500);
		frmAddCars.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
