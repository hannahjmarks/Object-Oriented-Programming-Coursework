package errorChecking;

import java.time.LocalDate;

public class dateSanityCheck {
	//returns a boolean, true if no errors are detected false otherwise
	public static boolean sanityChecker(LocalDate date) {
		
		//gets the day, month and year as separate variables
		int day=date.getDayOfMonth();
		int month=date.getMonthValue();
		int year=date.getYear();
		
		boolean noError=true;
		
		//if the date is the 29th February and not a leap year it is not valid
		if (day>28 && month==2 && year%4!=0) {
			noError=false;
			
		//if the date is 30th (or greater) February it is not valid
		}else if(day>29 && month==2) {
			noError=false;
			
		//if the day is greater than 30 and the month is one of the following then it is not valid
		}else if(day>30) {
			if(month==4) {
				noError=false;
			}else if(month==6) {
				noError=false;
			}else if(month==9) {
				noError=false;
			}else if(month==11) {
				noError=false;
			}else if(month>12) {
				noError=false;
			}else if(day>31) {
				noError=false;
			}
			
		//if the day exceeds 31 or is less than 1 it is not valid
		}else if(day>31 && day<1) {
			noError=false;
			
		//if the month exceeds 12 or is less than 1 it is not valid
		}else if(month>12 && month<1) {
			noError=false;
		}
	return noError;
	}
}
