package validate.bean; //Package for bean

public class ValidateCode{
	private String user, pass; //creating variables for user and password
	
	//Methods to set user/password to form data
	public void setUser(String u1) {this.user = u1;} 
	public void setPass(String p1) {this.pass = p1;}
	
	//Methods to obtain the values set by setters
	public String getUser() {return user;}
	public String getPass() {return pass;}
	
	//Method to validate user
	public boolean validate(String u1, String p1) {
		if (u1.equals(user) && p1.equals(pass))
			return true;
		else
			return false;
	}
}
