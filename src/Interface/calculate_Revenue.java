//This class contains the user interface for the calculateRevenue function

package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class calculate_Revenue {
	
	String errorMsg=null;

	private JFrame frmCalculateRevenue;
	private JTextField txtDate;

	//launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculate_Revenue window = new calculate_Revenue();
					window.frmCalculateRevenue.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public calculate_Revenue() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmCalculateRevenue = new JFrame();
		frmCalculateRevenue.setResizable(false);
		frmCalculateRevenue.setTitle("Calculate Revenue");
		frmCalculateRevenue.getContentPane().setBackground(new Color(255, 255, 255));
		frmCalculateRevenue.getContentPane().setLayout(null);
		
		//creates a button group for the user to select the time period over which to calculate the revenue
		ButtonGroup timePeriod=new ButtonGroup();
		
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Interface.log_In.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frmCalculateRevenue.dispose();
			}
		});
		btnLogOut.setBounds(0, 0, 100, 30);
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculateRevenue.getContentPane().add(btnLogOut);
		
		//when the main menu button is clicked the current window is closed and the appropriate main menu is opened depending on the users role
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (log_In.role.equals("admin")) {
					Interface.main_Menu_Admin.main(null);
					frmCalculateRevenue.dispose();
				}
				else if (log_In.role.equals("staff")) {
					Interface.main_Menu_Staff.main(null);
					frmCalculateRevenue.dispose();
				}
				else {
					errorMsg="Error With User Role\nPlease Log In Again";
					JOptionPane.showMessageDialog(null, errorMsg);
				}
			}
		});
		btnMainMenu.setBounds(224, 0, 125, 30);
		btnMainMenu.setForeground(new Color(255, 255, 255));
		btnMainMenu.setBackground(new Color(102, 0, 153));
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		frmCalculateRevenue.getContentPane().add(btnMainMenu);
		
		JRadioButton rdbtnDay = new JRadioButton("Day");
		rdbtnDay.setSelected(true);
		timePeriod.add(rdbtnDay);
		rdbtnDay.setBackground(new Color(255, 255, 255));
		rdbtnDay.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnDay.setBounds(69, 89, 111, 23);
		frmCalculateRevenue.getContentPane().add(rdbtnDay);
		
		JRadioButton rdbtnMonth = new JRadioButton("Month");
		timePeriod.add(rdbtnMonth);
		rdbtnMonth.setBackground(new Color(255, 255, 255));
		rdbtnMonth.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnMonth.setBounds(188, 89, 111, 23);
		frmCalculateRevenue.getContentPane().add(rdbtnMonth);
		
		JLabel lblCalculateRevenueFor = new JLabel("Calculate Revenue for:");
		lblCalculateRevenueFor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCalculateRevenueFor.setBounds(64, 68, 273, 14);
		frmCalculateRevenue.getContentPane().add(lblCalculateRevenueFor);
		
		JLabel lblDate = new JLabel("Select a Date (DD/MM/YYYY):");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDate.setBounds(69, 132, 213, 14);
		frmCalculateRevenue.getContentPane().add(lblDate);
		
		JLabel lblTotalRevenue = new JLabel("Total Revenue:");
		lblTotalRevenue.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTotalRevenue.setBounds(64, 288, 273, 14);
		frmCalculateRevenue.getContentPane().add(lblTotalRevenue);
		
		txtDate = new JTextField();
		txtDate.setBounds(69, 150, 203, 20);
		frmCalculateRevenue.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblPleaseKeepTo = new JLabel("Please keep to the above date format");
		lblPleaseKeepTo.setBounds(69, 172, 213, 14);
		frmCalculateRevenue.getContentPane().add(lblPleaseKeepTo);
		
		//when the calculate revenue button is clicked
		JButton btnCalculateRevenue = new JButton("Calculate Revenue");
		btnCalculateRevenue.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//gets user input
				String sDate=txtDate.getText();
				
				boolean noError=errorChecking.calcRevDateCheck.dateCheck(sDate);//error checks user input
				float revenue;
				if (noError==true) {
					if(rdbtnDay.isSelected()) {
						try {//calculates revenue for a single day
							revenue=cardealer.calculateRevenue.getDayRevenue(sDate);
						} catch (NumberFormatException e1) {
							revenue=0;
							e1.printStackTrace();
						} catch (Exception e1) {
							revenue=0;
							e1.printStackTrace();
						}
					}else {
						try {//calculates revenue for a single month
							revenue=cardealer.calculateRevenue.getMonthRevenue(sDate);
						} catch (NumberFormatException e1) {
							revenue=0;
							e1.printStackTrace();
						} catch (Exception e1) {
							revenue=0;
							e1.printStackTrace();
						}
					}
					//displays revenue in the total revenue label
					String totalRevenue=String.format("Total Revenue: £%.2f", revenue);
					lblTotalRevenue.setText(totalRevenue);
					
				}
			}
		});
		btnCalculateRevenue.setForeground(new Color(255, 255, 255));
		btnCalculateRevenue.setBackground(new Color(102, 0, 153));
		btnCalculateRevenue.setFont(new Font("Arial", Font.BOLD, 14));
		btnCalculateRevenue.setBounds(70, 234, 200, 30);
		frmCalculateRevenue.getContentPane().add(btnCalculateRevenue);
		
		JLabel lblIfYouHave = new JLabel("If you have selected month then this is the");
		lblIfYouHave.setBounds(65, 192, 217, 14);
		frmCalculateRevenue.getContentPane().add(lblIfYouHave);
		
		JLabel lblNewLabel = new JLabel("date that will be used as a start point");
		lblNewLabel.setBounds(71, 209, 201, 14);
		frmCalculateRevenue.getContentPane().add(lblNewLabel);
		
		
		frmCalculateRevenue.setBounds(100, 100, 351, 400);
		frmCalculateRevenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
