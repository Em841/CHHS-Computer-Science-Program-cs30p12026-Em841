
package Mastery;

public class UEmployee {
	
	private String employeename;
	private double salary;

	
	public UEmployee(String en, double s)
	{
		employeename = en;
		salary = s;
	}

	
	public String getname()
	{
		return(employeename);
	}


	
	public double getsalary()
	{
		return(salary);
	}

	 
	
	public String toString()
	{
		return("Employee name: " + employeename + ", Salary Amount: $ " + salary + "\n");
	}
}