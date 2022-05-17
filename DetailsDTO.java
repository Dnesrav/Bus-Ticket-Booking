package Reg_Controllers;

/*
 * This class is an encapsulated class having only details for the user registered 
 * only setters and getter methods used to access data members
 */
	public class DetailsDTO {
	private String Name;
	private String Number;
	private String EmailId;
	private String Password;
	private String gender;
	private String Marital_Status;

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getNumber() {
	return Number;
}
public void setNumber(String number) {
	Number = number;
}
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMarital_Status() {
	return Marital_Status;
}
public void setMarital_Status(String marital_Status) {
	Marital_Status = marital_Status;

}

}
