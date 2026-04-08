package Skillbuilder;

public class Circle 
{
	private static double PI = 3.14;
	private double radius;
		
	
	public Circle() 
	{
		radius = 1;			//default radius
	}
	
	
	public Circle(double r) {
		radius = r;
	}

	
	public void setRadius(double newRadius) {
	 	radius = newRadius;
	}
	
	public double area() {
		
	 	double circleArea;
	 	
	 	circleArea = PI * radius * radius;
	 	return(circleArea);
	}

	
	public double getRadius() {
	 	return(radius);
	}
		
	public boolean equals(Object obj) 
	{
		Circle testObj = (Circle)obj;
		
	 	if (testObj.getRadius() == radius) {
			return(true);
		} else {
			return(false);
		}
	}


	
	public String toString() {
		String circleString;

		circleString = "Circle has radius " + radius;
	 	return(circleString);
	}
}