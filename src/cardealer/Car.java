package cardealer;

import cardealer.Body;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car {
	String regNum;
	String model;
	Body body;
	String colour;
	int mileage;
	String accidentHistory;
	String transmission;
	float price;
	String arriveDate;
	String sellDate;
	
	//constructor for the Car class, takes 9 strings, 1 integer and 1 float
	public Car (String rn, String md, String bd, String sz, String  cl, int ml, String accHist, String tran, float pr, String ad, String sd) throws Exception{
		regNum=rn;
		model=md;
		body=new Body(bd, sz);
		colour=cl;
		mileage=ml;
		accidentHistory=accHist;
		transmission=tran;
		price=pr;
		arriveDate=ad;
		sellDate=sd;
	}
	
	//returns the registration number
	public String getRegNum() {
		return this.regNum;
	}
	
	//returns the model
	public String getModel() {
		return this.model;
	}
	
	//returns the body type
	public String getBType() {
		return this.body.getBodyType();
	}
	
	//returns the size
	public String getSize() {
		return this.body.getVanSize();
	}
	
	//returns the colour
	public String getColour() {
		return this.colour;
	}
	
	//returns the mileage
	public int getMilegae() {
		return this.mileage;
	}
	
	//returns the accident history
	public String getAccHist() {
		return this.accidentHistory;
	}
	
	//returns the transmission type
	public String getTransmission() {
		return this.transmission;
	}
	
	//returns the price
	public float getPrice() {
		return this.price;
	}
	
	//returns the arrival date
	public String getArriveDate() {
		return this.arriveDate;
	}
	
	//returns the sell date
	public String getSellDate() {
		return this.sellDate;
	}
	
	//returns the number of seats
	public int getSeats() {
		return this.body.getSeats();
	}
	
	//returns the number of doors
	public int getDoors() {
		return this.body.getDoors();
	}
	
	//converts a string into a LocalDate
	public static LocalDate stringToDate(String sDate) throws Exception {
		LocalDate dDate=LocalDate.parse(sDate);
		return dDate;
	}
	
	//converts a LocalDate into a string in the format "yyyy-mm-dd"
	public static String dateToString(LocalDate dDate) {	
		String sDate=dDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return sDate;
	}
	
	//sets the arrival date, used when importing a car in the addCar(s) functions
	public static LocalDate setArriveDate(String aSDate) {
		LocalDate aDate;
		if (aSDate.equals("")) {//if there is no arrival date in the input then it is set to the current date
			aDate= LocalDate.now();
		}
		else {
			try {//if the arrival date input is not in a readable format then it will be set to the current date
				aDate=Car.stringToDate(aSDate);
			} catch (Exception e){
				aDate = LocalDate.now();
			}
		}
		return aDate;
	}
	
	//converts the Car class to a string, used when printing a car in a case where the string does not need to be formatted
	public String carToString() {
		String sCar=this.regNum+","+this.model+","+this.body.printBody()+","+this.colour+","+this.mileage+","+this.accidentHistory+","+this.transmission+","+this.price+","+this.arriveDate+","+this.sellDate;
		return sCar;
	}
}
