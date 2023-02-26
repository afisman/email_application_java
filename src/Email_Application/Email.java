package Email_Application;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call a method asking for department - return department
		this.department = setDepartment();
		
		//Calls a method that returns random password
		
		this.password = randomPassword(defaultPasswordLength);
		
		//Combine elements to generate email

		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

		
	}
	//Ask department
	
	private String setDepartment() {
		System.out.println("New worker: " + firstName + " " + lastName +"\nDepartment codes\n1 for Sales \n2 for Development \n3 for Accounting \n0 for nothing\nEnter department code:");
		Scanner in = new Scanner(System.in);
		int depChoice =in.nextInt();
		if(depChoice == 1) {
			return "sales";
		} else if(depChoice ==2) {
			return "dev";
		} else if(depChoice ==3) {
			return "acct";
		} else {
			return "";
		}
	}
	
	
	
	//Generate random password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		
		char[] password = new char[length];
		for(int i =0; i < length; i++) {
			int rand = (int) (Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY NAME: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
	
}
