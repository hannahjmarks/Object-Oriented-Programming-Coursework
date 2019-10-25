//This class contains the user interface for the logIn function

package Interface;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import cardealer.User;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPasswordField;

public class log_In {

	public static String role;
	private JFrame frmLogIn;
	private JTextField textFieldUserName;
	private JPasswordField pfPassword;
	
	//launch the application window
	public static void main(String[] args) throws IOException{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log_In window = new log_In();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public log_In() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogIn.setResizable(false);
		frmLogIn.setBounds(100, 100, 450, 200);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//gets the user input
				String userName=textFieldUserName.getText();
				String password=convertToString(pfPassword.getPassword());
				String errorMsg=null;
				
				try {
					ArrayList<User>userDetails = readFile.readUserFile.getUserDetails();//loads the user details into an ArrayList
					
					if (userName==null||userName.isEmpty()||password==null||password.isEmpty()) {//if either of the text fields are left blank then an error message is displayed
						errorMsg="Please input a username and password";
						JOptionPane.showMessageDialog(null, errorMsg);
					}
					else {
						boolean found=false;

						for (int i=0; i<userDetails.size();i++) {//searches through the ArrayList
							String fileUserName=userDetails.get(i).getUserName();
							String filePassword=userDetails.get(i).getPassword();
							if (fileUserName.equals(userName) && filePassword.equals(password)) {//if the input matches then the user is logged in and their role is stored as a public variable for use in other packages
								role=userDetails.get(i).getRole();
								found=true;
								break;
							}
						}
						if (found==false) {//if no matches are found an error message is displayed
							errorMsg="Incorrect Username or Password\nPlease Try Again";
							JOptionPane.showMessageDialog(null, errorMsg);
						}
						
						//opens the correct window depending on the users role
						if (role.equals("admin")) {
							Interface.main_Menu_Admin.main(null);
							frmLogIn.dispose();
						}
						else if (role.equals("staff")) {
							Interface.main_Menu_Staff.main(null);
							frmLogIn.dispose();
						}
						else if (role.equals("customer")) {
							Interface.search_Window.main(null);
							frmLogIn.dispose();
						}
						else {
							errorMsg="This User has an Unrecognised Role\nPlease Try Again";
							JOptionPane.showMessageDialog(null, errorMsg);
						}
					}
				}catch (IOException e1) {
				e1.printStackTrace();
				errorMsg="File Error No Users Found";
				JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		
		
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogIn.setBackground(new Color(102, 0, 153));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBounds(160, 125, 130, 25);
		frmLogIn.getContentPane().add(btnLogIn);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(40, 70, 60, 14);
		frmLogIn.getContentPane().add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldUserName.setBounds(40, 40, 370, 25);
		frmLogIn.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUserName.setBounds(40, 20, 70, 14);
		frmLogIn.getContentPane().add(lblUserName);
		
		pfPassword = new JPasswordField();
		pfPassword.setColumns(20);
		pfPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		pfPassword.setBounds(40, 90, 370, 25);
		frmLogIn.getContentPane().add(pfPassword);
	}
	
	//used to get the input in the password entry field
	protected String convertToString(char[] password) {
		String result="";
		for (int i=0;i<password.length;i++) {
			result=result+password[i];
		}
		return result;
	}

}
