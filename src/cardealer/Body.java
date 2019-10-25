package cardealer;

public class Body {
	String bodyType;
	String size;
	int doors;
	int seats;
	
	//constructor for the Body class, takes 2 strings and then uses local methods (shown bellow) to set the remaining fields
	Body (String bt, String sz){
	bodyType=bt;
	size=sz;
	seats=seatNum(bt.toUpperCase());//the body type is set to uppercase here so that the input is case insensitive
	doors=doorNum(bt.toUpperCase());
	
	}
	
	//returns the number of seats which are determined by the body type
	int seatNum(String bType) {
		int seats=0;
		
		if (bType.equals("COUPE")) {
			seats=2;
		}
		else if (bType.equals("HATCHBACK")) {
			seats=4;
		}
		else if (bType.equals("MPV")) {
			seats=7;
		}
		else if (bType.equals("SALOON")) {
			seats=5;
		}
		else if (bType.equals("SUV")) {
			seats=5;
		}
		else if (bType.equals("VAN")) {
			seats=3;
		}
		else {
			seats=0;
		}
		
		return seats;
	}
	
	//returns the number of doors which are determined by the body type
	int doorNum(String bType) {
		int doors=0;
		
		if (bType.equals("COUPE")) {
			doors=2;
		}
		else if (bType.equals("HATCHBACK")) {
			doors=4;
		}
		else if (bType.equals("MPV")) {
			doors=7;
		}
		else if (bType.equals("SALOON")) {
			doors=5;
		}
		else if (bType.equals("SUV")) {
			doors=5;
		}
		else if (bType.equals("VAN")) {
			doors=3;
		}
		else {
			doors=0;
		}
		
		return doors;
	}
	
	//returns the body type
	public String getBodyType() {
		return this.bodyType;
	}
	
	//returns the size
	public String getVanSize() {
		return this.size;
	}
	
	//returns the number of seats
	public int getSeats() {
		return this.seats;
	}
	
	//returns the number of doors
	public int getDoors() {
		return this.doors;
	}
	
	//sets the body type
	public void setBodyType(String newBodyType) {
		this.bodyType=newBodyType;
	}
	
	//sets the size
	public void setSize(String newSize) {
		if ((this.bodyType).equals("VAN")) {//only sets the size if it is a van, otherwise is left blank
			this.size=newSize;
		}
		else {
			this.size="";
		}
	}
	
	//converts the class to a string for use in printing provided that it does not need to be formatted
	public String printBody() {
		String result=this.bodyType+", "+this.size;
		
		return result;
	}
}
