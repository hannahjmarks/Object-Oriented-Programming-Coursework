//User object class

package cardealer;

public class User {
	String userName;
	String password;
	String role;
	
	//constructor for the User class, takes 3 strings
	public User(String uName, String pWord, String r) {
		userName=uName;
		password=pWord;
		role=r;
	}
	//returns the username field
	public String getUserName() {
		return this.userName;
	}
	
	//returns the password field
	public String getPassword() {
		return this.password;
	}
	
	//returns the role field
	public String getRole() {
		return this.role;
	}
	
	

}
