package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import Interface.log_In;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class add_Car {
	
	String errorMsg=null;

	private JFrame frmAddCar;
	private JTextField txtRegNum;
	private JLabel lblMakeAndModel;
	private JTextField txtModel;
	private JLabel lblBody;
	private JComboBox<String> cmbBody;
	private JLabel lblColour;
	private JTextField txtColour;
	private JLabel lblMileage;
	private JTextField txtMileage;
	private JLabel lblTransmission;
	private JButton btnMainMenu;
	private JTextField txtAccHist;
	private JLabel lblSizevanOnly;
	private JLabel lblPrice;
	private JTextField txtPrice;

	//launches the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_Car window = new add_Car();
					window.frmAddCar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public add_Car() {
		initialize();
	}

	//initialises the components within the JFrame
	private void initialize() {
		frmAddCar = new JFrame();
		frmAddCar.setTitle("Add Car");
		frmAddCar.setResizable(false);
		frmAddCar.getContentPane().setBackground(Color.WHITE);
		frmAddCar.getContentPane().setLayout(null);
		
		//creates a button group for the user to select the transmission type of the car to be added
		ButtonGroup transmissionInput=new ButtonGroup();
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmAddCar.dispose();
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogOut.setBounds(0, 0, 100, 30);
		frmAddCar.getContentPane().add(btnLogOut);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number (7 characters, No spaces):");
		lblRegistrationNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRegistrationNumber.setBounds(40, 60, 293, 14);
		frmAddCar.getContentPane().add(lblRegistrationNumber);
		
		txtRegNum = new JTextField();
		txtRegNum.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRegNum.setBounds(302, 57, 121, 20);
		frmAddCar.getContentPane().add(txtRegNum);
		txtRegNum.setColumns(8);
		
		lblMakeAndModel = new JLabel("Make and Model:");
		lblMakeAndModel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMakeAndModel.setBounds(40, 88, 101, 14);
		frmAddCar.getContentPane().add(lblMakeAndModel);
		
		txtModel = new JTextField();
		txtModel.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModel.setText("e.g. Ford Focus");
		txtModel.setBounds(139, 85, 284, 20);
		frmAddCar.getContentPane().add(txtModel);
		txtModel.setColumns(60);
		
		lblBody = new JLabel("Body:");
		lblBody.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBody.setBounds(445, 60, 48, 14);
		frmAddCar.getContentPane().add(lblBody);
		
		lblColour = new JLabel("Colour:");
		lblColour.setFont(new Font("Arial", Font.PLAIN, 12));
		lblColour.setBounds(40, 116, 48, 14);
		frmAddCar.getContentPane().add(lblColour);
		
		txtColour = new JTextField();
		txtColour.setFont(new Font("Arial", Font.PLAIN, 12));
		txtColour.setBounds(98, 113, 325, 20);
		frmAddCar.getContentPane().add(txtColour);
		txtColour.setColumns(10);
		
		lblMileage = new JLabel("Mileage:");
		lblMileage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMileage.setBounds(40, 147, 48, 14);
		frmAddCar.getContentPane().add(lblMileage);
		
		txtMileage = new JTextField();
		txtMileage.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMileage.setBounds(98, 144, 325, 20);
		frmAddCar.getContentPane().add(txtMileage);
		txtMileage.setColumns(10);
		
		lblTransmission = new JLabel("Transmission:");
		lblTransmission.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTransmission.setBounds(445, 117, 101, 14);
		frmAddCar.getContentPane().add(lblTransmission);
		
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setSelected(true);
		transmissionInput.add(rdbtnManual);
		rdbtnManual.setBackground(new Color(255, 255, 255));
		rdbtnManual.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnManual.setBounds(526, 112, 71, 23);
		frmAddCar.getContentPane().add(rdbtnManual);
		
		JRadioButton rdbtnAutomatic = new JRadioButton("Automatic");
		transmissionInput.add(rdbtnAutomatic);
		rdbtnAutomatic.setBackground(new Color(255, 255, 255));
		rdbtnAutomatic.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnAutomatic.setBounds(599, 112, 86, 23);
		frmAddCar.getContentPane().add(rdbtnAutomatic);
		
		JLabel lblAccidentHistory = new JLabel("Accident History (Max 60 Characters):");
		lblAccidentHistory.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAccidentHistory.setBounds(40, 194, 240, 14);
		frmAddCar.getContentPane().add(lblAccidentHistory);
		
		txtAccHist = new JTextField();
		txtAccHist.setBounds(40, 219, 645, 20);
		frmAddCar.getContentPane().add(txtAccHist);
		txtAccHist.setColumns(10);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmAddCar.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmAddCar.dispose();
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
		btnMainMenu.setBounds(584, 0, 116, 30);
		frmAddCar.getContentPane().add(btnMainMenu);
		
		lblSizevanOnly = new JLabel("Size (Van Only):");
		lblSizevanOnly.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSizevanOnly.setBounds(445, 88, 101, 14);
		frmAddCar.getContentPane().add(lblSizevanOnly);
		
		JComboBox<String> cmbSize = new JComboBox<String>();
		cmbSize.setBackground(new Color(248, 248, 255));
		cmbSize.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbSize.setModel(new DefaultComboBoxModel<String>(new String[] {"small", "large"}));
		cmbSize.setBounds(535, 84, 150, 22);
		frmAddCar.getContentPane().add(cmbSize);
		
		cmbBody = new JComboBox<String>();
		cmbBody.setBackground(new Color(248, 248, 255));
		cmbBody.setModel(new DefaultComboBoxModel<String>(new String[] {"Coupe", "Hatchback", "MPV", "Saloon", "SUV", "Van"}));
		cmbBody.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbBody.setBounds(486, 56, 199, 22);
		frmAddCar.getContentPane().add(cmbBody);
		
		lblPrice = new JLabel("Price (\u00A3):");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrice.setBounds(445, 147, 63, 14);
		frmAddCar.getContentPane().add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(499, 144, 186, 20);
		frmAddCar.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		
		//when the add car button is clicked
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//gets the user input
				String reg=txtRegNum.getText();
				String model=txtModel.getText();
				String colour=txtColour.getText();
				String transmission;
				if(rdbtnManual.isSelected()) {
					transmission="manual";
				}else {
					transmission="automatic";
				}
				String bodyType=(String) cmbBody.getSelectedItem();
				String size=(String) cmbSize.getSelectedItem();
				String mileage=txtMileage.getText();
				String accHist=txtAccHist.getText();
				String price=txtPrice.getText();
				boolean noInputError=false;
				
				try {//checks the user input for errors
					noInputError=errorChecking.addCarInputCheck.inputCheck(reg, model, colour, mileage, accHist, price);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (noInputError==true) {//if there are no input errors then the car is added to the database
					boolean success=cardealer.addCar.addNewCar(reg, model, bodyType, size, colour, mileage, accHist, transmission, price);
					if (success==true) {//if the request succeeds then the current window is closed and the appropriate menu is opened
						String msg="Car Added";
						JOptionPane.showMessageDialog(null, msg);
						if (Interface.log_In.role.equals("admin")) {
							Interface.main_Menu_Admin.main(null);
							frmAddCar.dispose();
						}else if(Interface.log_In.role.equals("staff")) {
							Interface.main_Menu_Staff.main(null);
							frmAddCar.dispose();
						}
					}
				}
				
			
			}
		});
		btnAddCar.setForeground(new Color(255, 255, 255));
		btnAddCar.setBackground(new Color(102, 0, 153));
		btnAddCar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCar.setBounds(281, 250, 150, 30);
		frmAddCar.getContentPane().add(btnAddCar);
		frmAddCar.setBounds(100, 100, 702, 320);
		frmAddCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
