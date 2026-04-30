package Mastery;



public class Staff extends UEmployee {

	private String title;

	
	public Staff(String en, double s, String t)
	{
		super(en, s);
		title = t;
	}

	
	public String gettitle()
	{
		return(title);
	}
}
