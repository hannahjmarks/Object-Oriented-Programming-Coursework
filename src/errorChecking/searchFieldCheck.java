//This class contains the function for error checking the search input

package errorChecking;

import javax.swing.JOptionPane;

public class searchFieldCheck {
	public static boolean inputTypeCheck(String mileageMax,String seatsMin,String seatsMax,String doorsMin,String doorsMax,String priceMin,String priceMax) {
		boolean noError=true;
		String errorMsg=null;
		
		//if the mileage search item is not a number then an error message is displayed
		if(mileageMax==null||mileageMax.isEmpty()) {
		}else {
			try {
				Integer.parseInt(mileageMax);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Maximum Mileage should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the minimum seats search item is not a number then an error message is displayed
		if(seatsMin==null||seatsMin.isEmpty()) {
		}else {
			try {
				Integer.parseInt(seatsMin);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Minimum Seats should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the maximum seats search item is not a number then an error message is displayed
		if(seatsMax==null||seatsMax.isEmpty()) {
		}else {
			try {
				Integer.parseInt(seatsMax);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Maximum Seats should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the minimum doors search item is not a number then an error message is displayed
		if(doorsMin==null||doorsMin.isEmpty()) {
		}else {
			try {
				Integer.parseInt(doorsMin);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Minimum Doors should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the maximum doors search item is not a number then an error message is displayed
		if(doorsMax==null||doorsMax.isEmpty()) {
		}else {
			try {
				Integer.parseInt(doorsMax);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Maximum Doors should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the minimum price search item is not a number then an error message is displayed
		if(priceMin==null||priceMin.isEmpty()) {
		}else {
			try {
				Float.parseFloat(priceMin);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Minimum Price should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		//if the maximum price search item is not a number then an error message is displayed
		if(priceMax==null||priceMax.isEmpty()) {
		}else {
			try {
				Float.parseFloat(priceMax);
			}catch(Exception e) {
				noError=false;
				errorMsg="The Maximum Price should only contain numbers";
				JOptionPane.showMessageDialog(null, errorMsg);
			}
		}
		
		return noError;
	}
}
