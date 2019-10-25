//This class contains the user interface for the admin main menu

package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class main_Menu_Admin {

	private JFrame frmMainMenu;

	//launch the application window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_Menu_Admin window = new main_Menu_Admin();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates the application window
	public main_Menu_Admin() {
		initialize();
	}

	//initialises the components inside the JFrame
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setResizable(false);
		frmMainMenu.getContentPane().setBackground(new Color(255, 255, 255));
		frmMainMenu.getContentPane().setLayout(null);
		
		//when the log out button is clicked the current window is closed and the log in window is opened
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			try {
				Interface.log_In.main(null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frmMainMenu.dispose();
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(102, 0, 153));
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogOut.setBounds(0, 0, 125, 30);
		frmMainMenu.getContentPane().add(btnLogOut);
		
		//when the new user button is clicked the current window is closed and the new user window is opened
		JButton btnNewUser = new JButton("Create New User");
		btnNewUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			Interface.new_User.main(null);
			frmMainMenu.dispose();
			}
		});
		btnNewUser.setBackground(new Color(102, 0, 153));
		btnNewUser.setForeground(new Color(255, 255, 255));
		btnNewUser.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewUser.setBounds(225, 160, 250, 30);
		frmMainMenu.getContentPane().add(btnNewUser);
		
		//when the add car button is clicked the current window is closed and the add car window is opened
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.add_Car.main(null);
				frmMainMenu.dispose();
			}
		});
		btnAddCar.setBackground(new Color(102, 0, 153));
		btnAddCar.setForeground(new Color(255, 255, 255));
		btnAddCar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCar.setBounds(225, 201, 250, 30);
		frmMainMenu.getContentPane().add(btnAddCar);
		
		//when the add cars button is clicked the current window is closed and the add cars window is opened
		JButton btnAddCars = new JButton("Add Multiple Cars");
		btnAddCars.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.add_Cars.main(null);
				frmMainMenu.dispose();
			}
		});
		btnAddCars.setBackground(new Color(102, 0, 153));
		btnAddCars.setForeground(new Color(255, 255, 255));
		btnAddCars.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCars.setBounds(225, 242, 250, 30);
		frmMainMenu.getContentPane().add(btnAddCars);
		
		
		//when the sell car button is clicked the current window is closed and the sell car window is opened
		JButton btnSellCar = new JButton("Sell Car");
		btnSellCar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.sell_Car.main(null);
				frmMainMenu.dispose();
			}
		});
		btnSellCar.setBackground(new Color(102, 0, 153));
		btnSellCar.setForeground(new Color(255, 255, 255));
		btnSellCar.setFont(new Font("Arial", Font.BOLD, 14));
		btnSellCar.setBounds(225, 283, 250, 30);
		frmMainMenu.getContentPane().add(btnSellCar);
		
		//when the print cars button is clicked the current window is closed and the print cars window is opened
		JButton btnPrintCars = new JButton("Print Cars");
		btnPrintCars.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.print_Cars.main(null);
				frmMainMenu.dispose();
			}
		});
		btnPrintCars.setBackground(new Color(102, 0, 153));
		btnPrintCars.setForeground(new Color(255, 255, 255));
		btnPrintCars.setFont(new Font("Arial", Font.BOLD, 14));
		btnPrintCars.setBounds(225, 324, 250, 30);
		frmMainMenu.getContentPane().add(btnPrintCars);
		
		//when the search button is clicked the current window is closed and the search window is opened
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.search_Window.main(null);
				frmMainMenu.dispose();
			}
		});
		btnSearch.setBackground(new Color(102, 0, 153));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearch.setBounds(225, 365, 250, 30);
		frmMainMenu.getContentPane().add(btnSearch);
		
		//when the calculate revenue button is clicked the current window is closed and the calculate revenue window is opened
		JButton btnCalcRev = new JButton("Calculate Revenue");
		btnCalcRev.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interface.calculate_Revenue.main(null);
				frmMainMenu.dispose();
			}
		});
		btnCalcRev.setBackground(new Color(102, 0, 153));
		btnCalcRev.setForeground(new Color(255, 255, 255));
		btnCalcRev.setFont(new Font("Arial", Font.BOLD, 14));
		btnCalcRev.setBounds(225, 406, 250, 30);
		frmMainMenu.getContentPane().add(btnCalcRev);
		frmMainMenu.setBounds(100, 100, 700, 650);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
