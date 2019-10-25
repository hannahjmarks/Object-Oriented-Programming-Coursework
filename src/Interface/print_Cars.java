//This class contains the user interface for the printCars function

package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import writeToFile.writePrintOutput;

import java.awt.Color;
import javax.swing.JLabel;

public class print_Cars {
	
	String errorMsg=null;

	private JFrame frmPrintCars;

	///launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					print_Cars window = new print_Cars();
					window.frmPrintCars.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public print_Cars() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmPrintCars = new JFrame();
		frmPrintCars.setResizable(false);
		frmPrintCars.setTitle("Print Cars");
		frmPrintCars.getContentPane().setBackground(Color.WHITE);
		frmPrintCars.getContentPane().setLayout(null);
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmPrintCars.dispose();
			}
		});
		btnLogOut.setBounds(0, 0, 100, 30);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		frmPrintCars.getContentPane().add(btnLogOut);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmPrintCars.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmPrintCars.dispose();
				}
				else {
					errorMsg="Error With User Role\nPlease Log In Again";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		btnMainMenu.setBounds(323, 0, 125, 30);
		btnMainMenu.setForeground(new Color(255, 255, 255));
		btnMainMenu.setBackground(new Color(102, 0, 153));
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		frmPrintCars.getContentPane().add(btnMainMenu);
		
		JLabel lblUserMsg = new JLabel("The Output File can be found in the Program Folder");
		lblUserMsg.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUserMsg.setBounds(52, 98, 373, 14);
		frmPrintCars.getContentPane().add(lblUserMsg);
		
		//when the print cars button is clicked
		JButton btnPrintCars = new JButton("Print Cars");
		btnPrintCars.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					boolean success=writePrintOutput.printOutput();//is true if the output is printed successfully
					if (success==true) {//message is displayed, then the appropriate menu is opened and the current window closed
						String msg="Printed Successfully";
						JOptionPane.showMessageDialog(null, msg);
						if (Interface.log_In.role.equals("admin")) {
							Interface.main_Menu_Admin.main(null);
							frmPrintCars.dispose();
						}else if(Interface.log_In.role.equals("staff")) {
							Interface.main_Menu_Staff.main(null);
							frmPrintCars.dispose();
						}
					}else {
						errorMsg="Failed please check database file for errors";
						JOptionPane.showMessageDialog(null, errorMsg);
					}
				} catch (NumberFormatException e1) {

					e1.printStackTrace();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnPrintCars.setForeground(new Color(255, 255, 255));
		btnPrintCars.setBackground(new Color(102, 0, 153));
		btnPrintCars.setFont(new Font("Arial", Font.BOLD, 14));
		btnPrintCars.setBounds(157, 148, 125, 30);
		frmPrintCars.getContentPane().add(btnPrintCars);
		
		frmPrintCars.setBounds(100, 100, 450, 300);
		frmPrintCars.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
