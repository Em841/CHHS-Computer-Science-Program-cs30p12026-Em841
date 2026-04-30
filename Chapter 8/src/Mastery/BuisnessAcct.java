package Mastery;

public class BuisnessAcct extends Account{
	int MIN_BALANCE = 100;
	int FEE = 10;
	
	//Overloading method
	public BuisnessAcct(double amt, String fName, String lName, String str, String c, String prov, String postal) {
		super(amt, fName, lName, str, c, prov, postal);
	}
	
	public String PersonalMinFee() {
		double amt = getBalance();
		if (amt < MIN_BALANCE) {
			amt -= FEE;
			withdrawal(amt);
			return ("Minimum Of " + MIN_BALANCE + "Required In Account. " + FEE + "Monthly Fee Applied." + "\n"
					+ "Balance Is: " + amt);
		}
		else {
			return("There Is A Minimum Of " + MIN_BALANCE + " In The Account.");
		}
	}
	
	public String toStringBA() {
		return(toString());
	}

	public char[] BuisnessMinFee() {
		// TODO Auto-generated method stub
		return null;
	}
}