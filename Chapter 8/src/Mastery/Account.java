
package Mastery;

import java.text.NumberFormat;

public class Account {
	private double balance;
	private customer cust;
	private String acctID, street, city, province, postalCode;
	
		
	
	public Account(double bal, String fName, String lName, String str, String c, String prov, String postal)
	 {
		balance = bal;
		cust = new customer(fName, lName, str, c, prov, postal);
		acctID = fName.substring(0,1) + lName;
		street = str;
		city = c;
		province = prov;
		postalCode = postal;
	}
	

	
	public Account(String ID) {
		balance = 0;
		cust = new customer("", "", "", "", "", "");
		acctID = ID;
	}


	public String getID() {
	 	return(acctID);
	}


	public double getBalance() {
	 	return(balance);
	}


	public void deposit(double amt) {
	 	balance += amt;
	}

	
	
	public void withdrawal(double amt) {
	 	if (amt <= balance) {
	 		balance -= amt;
	 	} else {
	 		System.out.println("Not enough money in account.");
	 	}
	}



	
	public void changeAddress(String newStr, String newCty, String newPv, String newPostal) {
		cust.setStreet(newStr);
		cust.setCity(newCty);
		cust.setProv(newPostal);
		cust.setPostal(newPostal);
	}
	
	
	public boolean equals(Object acct) {
		Account testAcct = (Account)acct;
		if (acctID.equals(testAcct.acctID)) {
				return(true);
			} else {
				return(false);
			}
	}


	
	public String toString() {
		String accountString;
		NumberFormat money = NumberFormat.getCurrencyInstance();

		accountString = acctID + "\n";
		accountString += cust.toString();
		accountString += "Current balance is " + money.format(balance);
	 	return(accountString);
	}



	public String acctType() {
		// TODO Auto-generated method stub
		return null;
	}
}
