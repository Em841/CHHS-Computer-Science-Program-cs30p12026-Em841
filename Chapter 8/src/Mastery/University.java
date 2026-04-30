/*
 * Program:BreakAplate
 * Purpose:Users had to type the info  about university, employees, faculty and staff. They share a name and salary, but faculty have a department and staff have a job title.
 * Author: Eman Abid
 * School:CHHS
 * Course: CSE 3130 Object-Oriented Programming 2
  */
package Mastery;


public class University {

	public static void main(String[] args)
	{
		Faculty f = new Faculty("Ar", 70000, " Science");
		Staff s = new Staff("AA", 100000, "Principal");

		System.out.println("Faculty" + "\nName: " + f.getname() + " \nSalary: $" + f.getsalary() + " \nDepartment: " + f.getdepartment());
		
		System.out.println();

		System.out.println("Staff" + "" + " \nName: " + s.getname() + " \nSalary: $" + s.getsalary() + " \nJob Title: " + s.gettitle());
	}
}
/*Faculty
Name: Ar 
Salary: $70000.0 
Department:  Science

Staff 
Name: AA 
Salary: $100000.0 
Job Title: Principal
*/