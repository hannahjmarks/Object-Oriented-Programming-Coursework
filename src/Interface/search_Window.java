//This class contains the user interface for the search functions

package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cardealer.Car;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class search_Window {
	
	String errorMsg=null;

	private JFrame frmSearch;
	private JTextField txtModel;
	private JTextField txtColour;
	private JTextField txtMaxMileage;
	private JTextField txtMinSeats;
	private JTextField txtMinDoors;
	private JTextField txtMinPrice;
	private JTextField txtMaxPrice;
	private JTextField txtMaxSeats;
	private JTextField txtMaxDoors;

	//launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_Window window = new search_Window();
					window.frmSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public search_Window() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setResizable(false);
		frmSearch.setTitle("Search");
		frmSearch.getContentPane().setBackground(Color.WHITE);
		
		//searchType button group is used to distinguish whether the user would like to search for cars or vans
		ButtonGroup searchType=new ButtonGroup();
		
		//transmission button group is used to distinguish which transmission type the user wishes to search for
		ButtonGroup transmission=new ButtonGroup();
		
		//size button group is used to distinguish which size of van the user wishes to search for
		ButtonGroup size=new ButtonGroup();
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(0, 0, 100, 30);
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmSearch.dispose();
			}
		});
		frmSearch.getContentPane().setLayout(null);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		frmSearch.getContentPane().add(btnLogOut);
		
		//when the main menu button is clicked the user's role is checked and depending on the result is taken to either the appropriate menu or is given an error message
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(755, 0, 125, 30);
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmSearch.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmSearch.dispose();
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
		frmSearch.getContentPane().add(btnMainMenu);
		
		frmSearch.setBounds(100, 100, 883, 548);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtModel = new JTextField();
		txtModel.setBounds(37, 118, 106, 25);
		txtModel.setFont(new Font("Arial", Font.PLAIN, 14));
		txtModel.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(txtModel);
		txtModel.setColumns(10);
		
		txtColour = new JTextField();
		txtColour.setBounds(37, 167, 106, 25);
		txtColour.setFont(new Font("Arial", Font.PLAIN, 14));
		txtColour.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(txtColour);
		txtColour.setColumns(10);
		
		txtMaxMileage = new JTextField();
		txtMaxMileage.setBounds(37, 225, 106, 25);
		txtMaxMileage.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMaxMileage.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(txtMaxMileage);
		txtMaxMileage.setColumns(10);
		
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setBounds(131, 72, 111, 23);
		rdbtnManual.setSelected(true);
		transmission.add(rdbtnManual);
		rdbtnManual.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnManual.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnManual);
		
		JRadioButton rdbtnAutomatic = new JRadioButton("Automatic");
		rdbtnAutomatic.setBounds(244, 72, 111, 23);
		transmission.add(rdbtnAutomatic);
		rdbtnAutomatic.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnAutomatic.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnAutomatic);
		
		txtMinSeats = new JTextField();
		txtMinSeats.setBounds(279, 118, 106, 25);
		txtMinSeats.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMinSeats.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(txtMinSeats);
		txtMinSeats.setColumns(10);
		
		txtMaxSeats = new JTextField();
		txtMaxSeats.setBounds(407, 119, 106, 25);
		frmSearch.getContentPane().add(txtMaxSeats);
		txtMaxSeats.setColumns(10);
		
		txtMinDoors = new JTextField();
		txtMinDoors.setBounds(279, 167, 106, 25);
		txtMinDoors.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMinDoors.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(txtMinDoors);
		txtMinDoors.setColumns(10);
		
		txtMaxDoors = new JTextField();
		txtMaxDoors.setBounds(407, 170, 106, 25);
		frmSearch.getContentPane().add(txtMaxDoors);
		txtMaxDoors.setColumns(10);
		
		JRadioButton rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.setBounds(635, 72, 111, 23);
		rdbtnSmall.setSelected(true);
		size.add(rdbtnSmall);
		rdbtnSmall.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnSmall.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnSmall);
		
		JRadioButton rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.setBounds(748, 71, 111, 23);
		size.add(rdbtnLarge);
		rdbtnLarge.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnLarge.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnLarge);
		
		JRadioButton rdbtnCar = new JRadioButton("Cars");
		rdbtnCar.setBounds(355, 33, 111, 23);
		rdbtnCar.setSelected(true);
		searchType.add(rdbtnCar);
		rdbtnCar.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnCar.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnCar);
		
		JRadioButton rdbtnVan = new JRadioButton("Vans");
		rdbtnVan.setBounds(468, 33, 111, 23);
		searchType.add(rdbtnVan);
		rdbtnVan.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnVan.setBackground(new Color(255, 255, 255));
		frmSearch.getContentPane().add(rdbtnVan);
		
		txtMinPrice = new JTextField();
		txtMinPrice.setBounds(279, 225, 106, 25);
		txtMinPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(txtMinPrice);
		txtMinPrice.setColumns(10);
		
		txtMaxPrice = new JTextField();
		txtMaxPrice.setBounds(407, 225, 106, 25);
		txtMaxPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(txtMaxPrice);
		txtMaxPrice.setColumns(10);
		
		JComboBox<String> cmbSortBy = new JComboBox<String>();
		cmbSortBy.setBounds(684, 224, 175, 22);
		cmbSortBy.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSortBy.setBackground(new Color(248, 248, 255));
		cmbSortBy.setModel(new DefaultComboBoxModel<String>(new String[] {"Price(Lowest First)", "Price(Highest First)", "Model", "Mileage"}));
		frmSearch.getContentPane().add(cmbSortBy);
		
		JLabel lblSearchFor = new JLabel("Search for:");
		lblSearchFor.setBounds(266, 37, 89, 14);
		lblSearchFor.setFont(new Font("Arial", Font.BOLD, 16));
		frmSearch.getContentPane().add(lblSearchFor);
		
		JLabel lblTransmission = new JLabel("Transmission:");
		lblTransmission.setBounds(37, 76, 106, 14);
		lblTransmission.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblTransmission);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(37, 101, 48, 14);
		lblModel.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblModel);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(37, 149, 48, 14);
		lblColour.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblColour);
		
		JLabel lblMaximumMileage = new JLabel("Maximum Mileage:");
		lblMaximumMileage.setBounds(37, 203, 119, 16);
		lblMaximumMileage.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblMaximumMileage);
		
		JLabel lblSizevanOnly = new JLabel("Size (Van Only):");
		lblSizevanOnly.setBounds(515, 76, 114, 14);
		lblSizevanOnly.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblSizevanOnly);
		
		JLabel lblSeats = new JLabel("Seats:");
		lblSeats.setBounds(226, 124, 48, 14);
		lblSeats.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblSeats);
		
		JLabel lblMin = new JLabel("MIN");
		lblMin.setBounds(318, 102, 48, 14);
		lblMin.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblMin);
		
		JLabel lblMax = new JLabel("MAX");
		lblMax.setBounds(448, 101, 48, 14);
		lblMax.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblMax);
		
		JLabel lblDoors = new JLabel("Doors:");
		lblDoors.setBounds(226, 173, 48, 14);
		lblDoors.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblDoors);
		
		JLabel lblPrice = new JLabel("Price (\u00A3):");
		lblPrice.setBounds(212, 230, 57, 14);
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblPrice);
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setBounds(684, 205, 62, 14);
		lblSortBy.setFont(new Font("Arial", Font.PLAIN, 14));
		frmSearch.getContentPane().add(lblSortBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 261, 860, 251);
		frmSearch.getContentPane().add(scrollPane);
		
		JTextArea textAreaSearchResults = new JTextArea();
		scrollPane.setViewportView(textAreaSearchResults);
		textAreaSearchResults.setEditable(false);
		textAreaSearchResults.setFont(new Font("Consolas", Font.PLAIN, 14));
		textAreaSearchResults.setBackground(new Color(248, 248, 255));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<Car> database=null;
				ArrayList<Car> availibleCars=null;
				try {
					database=readFile.readDatabaseFile.getDatabase();
					availibleCars=search.availibleSearch.getAvailibleCars(database);
				} catch (Exception e1) {
					String errorMsg="File error please check database file";
					JOptionPane.showMessageDialog(null, errorMsg);
					e1.printStackTrace();
				}
				
				//gets the user input
				String sortType=(String) cmbSortBy.getSelectedItem();
				String model=txtModel.getText();
				String colour=txtColour.getText();
				String maxMileage=txtMaxMileage.getText();
				String seatsMin=txtMinSeats.getText();
				String seatsMax=txtMaxSeats.getText();
				String doorsMin=txtMinDoors.getText();
				String doorsMax=txtMaxDoors.getText();
				String priceMin=txtMinPrice.getText();
				String priceMax=txtMaxPrice.getText();
				String transmission;
				if (rdbtnManual.isSelected()) {
					transmission="manual";
				}else {
					transmission="automatic";
				}
				String size;
				if(rdbtnSmall.isSelected()) {
					size="small";
				}else {
					size="large";
				}
				
				//user input is run through the appropriate error checking function
				boolean noError=errorChecking.searchFieldCheck.inputTypeCheck(maxMileage, seatsMin, seatsMax, doorsMin, doorsMax, priceMin, priceMax);
				
				if(noError==true) {
					if (rdbtnCar.isSelected()) {//if the user is searching cars then the results are filtered by cars and transmission type
						availibleCars=search.searchFilter.searchCars(availibleCars);
						availibleCars=search.searchFilter.searchTransmission(availibleCars, transmission);
						
					}else {//if the user is searching vans then the results are filtered by vans, transmission and size
						availibleCars=search.searchFilter.searchVans(availibleCars);
						availibleCars=search.searchFilter.searchTransmission(availibleCars, transmission);
						availibleCars=search.searchFilter.searchSize(availibleCars, size);
					}
					
					
					//for the following 9 if/else statements the results are filtered appropriately if the user has entered a search item
					if(model==null||model.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchModel(availibleCars, model);
					}
					if(colour==null||colour.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchColour(availibleCars, colour);
					}
					if(maxMileage==null||maxMileage.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMileage(availibleCars, maxMileage);
					}
					if(seatsMin==null||seatsMin.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMinSeats(availibleCars, seatsMin);
					}
					if(seatsMax==null||seatsMax.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMaxSeats(availibleCars, seatsMax);
					}
					if(doorsMin==null||doorsMin.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMinDoors(availibleCars, doorsMin);
					}
					if(doorsMax==null||doorsMax.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMaxDoors(availibleCars, doorsMax);
					}
					if(priceMin==null||priceMin.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMinPrice(availibleCars, priceMin);
					}
					if(priceMax==null||priceMax.isEmpty()) {
					}else {
						availibleCars=search.searchFilter.searchMaxPrice(availibleCars, priceMax);
					}
					
					//the search results are sorted according to the field the user has selected from the combo box
					if (sortType.equals("Model")) {
						availibleCars=arraySorting.arraySearchSort.sortModel(availibleCars);
					}else if(sortType.equals("Mileage")) {
						availibleCars=arraySorting.arraySearchSort.sortMileage(availibleCars);
					}else if(sortType.equals("Price(Lowest First)")) {
						availibleCars=arraySorting.arraySearchSort.sortPriceAsc(availibleCars);
					}else {
						availibleCars=arraySorting.arraySearchSort.sortPriceDesc(availibleCars);
					}
					
					//prints the heading (without accident history for the customer users) to the text area
					String heading;
					if (Interface.log_In.role.equals("customer")) {
						heading="Registration Number |Make and Model                |Body Type |Size(Van only) |Colour    |Mileage   |Transmission   |Price(£)  |\n";
					}else {
						heading="Registration Number |Make and Model                |Body Type |Size(Van only) |Colour    |Mileage   |Accident History                                            |Transmission   |Price(£)  |\n";
					}
					
					textAreaSearchResults.setText(null);
					textAreaSearchResults.append(heading);
					
					//prints the search results (without accident history for the customer users) to the text area
					for (int i=0;i<availibleCars.size();i++) {
						Car current=availibleCars.get(i);
						String reg=current.getRegNum();
						String mod=current.getModel();
						String bdy=current.getBType();
						String sizeVan=current.getSize();
						String col=current.getColour();
						int mil=current.getMilegae();
						String accHist=current.getAccHist();
						String tran=current.getTransmission();
						float price=current.getPrice();
						
						String result;
						if (Interface.log_In.role.equals("customer")) {
							result=String.format("%-20s %-30s %-10s %-15s %-10s %-10d %-15s %-10.2f %n",reg,mod,bdy,sizeVan,col,mil,tran,price);
						}else {
							result=String.format("%-20s %-30s %-10s %-15s %-10s %-10d %-60s %-15s %-10.2f %n",reg,mod,bdy,sizeVan,col,mil,accHist,tran,price);
						}
						textAreaSearchResults.append(result);
					}
				}
			}
		});
		btnSearch.setBounds(684, 120, 175, 43);
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(102, 0, 153));
		btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
		frmSearch.getContentPane().add(btnSearch);
	}
}
