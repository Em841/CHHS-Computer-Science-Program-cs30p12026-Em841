package Mastery;


public class Faculty extends UEmployee{

	private String deptname;

	public Faculty(String en, double s, String dn)
	{
		super(en, s);
		deptname = dn;
	}
	public void deptname(String dn) {
		deptname = dn;
	}
	

	public String getdepartment()
	{
		return(deptname);
	}
	
}
