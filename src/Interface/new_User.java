//This class contains the user interface for the newUser function

package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class new_User {

	private JFrame frmNewUser;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	//launch the application window
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_User window = new new_User();
					window.frmNewUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public new_User() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmNewUser = new JFrame();
		frmNewUser.setTitle("New User");
		frmNewUser.setResizable(false);
		frmNewUser.getContentPane().setBackground(new Color(255, 255, 255));
		frmNewUser.getContentPane().setLayout(null);
		
		//userRole button group used to select the role of the new user account
		ButtonGroup userRole=new ButtonGroup();
		
		txtUserName = new JTextField();
		txtUserName.setBounds(30, 98, 380, 30);
		frmNewUser.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name (Max 20 characters cannot contain \",\"):");
		lblUserName.setFont(new Font("Arial", Font.BOLD, 14));
		lblUserName.setBounds(30, 73, 380, 20);
		frmNewUser.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password (Max. 20 characters cannot include \",\"):");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(30, 143, 375, 20);
		frmNewUser.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(30, 169, 380, 30);
		frmNewUser.getContentPane().add(txtPassword);
		txtPassword.setColumns(20);
		
		JLabel lblConfirmPassowrd = new JLabel("Confirm Password:");
		lblConfirmPassowrd.setFont(new Font("Arial", Font.BOLD, 14));
		lblConfirmPassowrd.setBounds(30, 213, 160, 20);
		frmNewUser.getContentPane().add(lblConfirmPassowrd);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBounds(30, 238, 380, 30);
		frmNewUser.getContentPane().add(txtConfirmPassword);
		txtConfirmPassword.setColumns(20);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setFont(new Font("Arial", Font.BOLD, 14));
		lblRole.setBounds(52, 295, 48, 20);
		frmNewUser.getContentPane().add(lblRole);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		userRole.add(rdbtnAdmin);
		rdbtnAdmin.setBackground(new Color(255, 255, 255));
		rdbtnAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnAdmin.setBounds(49, 328, 106, 30);
		frmNewUser.getContentPane().add(rdbtnAdmin);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		userRole.add(rdbtnStaff);
		rdbtnStaff.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnStaff.setBackground(new Color(255, 255, 255));
		rdbtnStaff.setBounds(170, 328, 75, 30);
		frmNewUser.getContentPane().add(rdbtnStaff);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setSelected(true);
		userRole.add(rdbtnCustomer);
		rdbtnCustomer.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnCustomer.setBackground(new Color(255, 255, 255));
		rdbtnCustomer.setBounds(266, 328, 125, 30);
		frmNewUser.getContentPane().add(rdbtnCustomer);
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			try {
				Interface.log_In.main(null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frmNewUser.dispose();
			}
		});
		btnLogOut.setBounds(0, 0, 100, 30);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(102, 0, 153));
		frmNewUser.getContentPane().add(btnLogOut);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			Interface.main_Menu_Admin.main(null);
			frmNewUser.dispose();
			}
		});
		btnMainMenu.setForeground(new Color(255, 255, 255));
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		btnMainMenu.setBackground(new Color(102, 0, 153));
		btnMainMenu.setBounds(323, 0, 125, 30);
		frmNewUser.getContentPane().add(btnMainMenu);
		
		//when the done button is clicked
		JButton btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String errorMsg=null;
				//get the user input
				String userName=txtUserName.getText();
				String password=txtPassword.getText();
				String confirmPassword=txtConfirmPassword.getText();
				String inputRole;
				if(rdbtnAdmin.isSelected()) {
					inputRole="admin";
				}else if(rdbtnStaff.isSelected()) {
					inputRole="staff";
				}else {
					inputRole="customer";
				}
				
				//user input is run through the appropriate error check function
				boolean noInputError = errorChecking.newUserInputCheck.inputCheck(userName, password, confirmPassword);
				if (noInputError==true) {
					try {//if there are no input errors then the user name is checked to see if it already exists
						if (search.exists.userAlreadyExists(userName)==true) {
							errorMsg="Error Username is already taken\nPlease choose another";
							JOptionPane.showMessageDialog(null, errorMsg);
							
						}else {
							//new user is created, message is displayed, the current window is closed and the menu is opened
							boolean success=cardealer.addUser.addNewUser(userName, password, inputRole.toLowerCase());
							if (success==true) {
								String msg="New User Created";
								JOptionPane.showMessageDialog(null, msg);
								Interface.main_Menu_Admin.main(null);
								frmNewUser.dispose();
							}
						}
					} catch (IOException e1) {
						errorMsg="File error";
						JOptionPane.showMessageDialog(null, errorMsg);
						e1.printStackTrace();
					}	
				}
			}
		});
		btnDone.setForeground(new Color(255, 255, 255));
		btnDone.setFont(new Font("Arial", Font.BOLD, 14));
		btnDone.setBackground(new Color(102, 0, 153));
		btnDone.setBounds(160, 373, 130, 30);
		frmNewUser.getContentPane().add(btnDone);
		frmNewUser.setBounds(100, 100, 450, 441);
		frmNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
