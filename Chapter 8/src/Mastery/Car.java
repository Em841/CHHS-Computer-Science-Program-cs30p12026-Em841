package Mastery;

public class Car extends Vehicle{
	private String model, colour, transmission;

	
	public Car() {
		transmission = "none";
		model = "none";
		colour = "blank";
	}
		

	public Car(int seat, double cargo, double ctyFuel, double hwyFuel, String md, String c, String t) {
		super(seat, cargo, ctyFuel, hwyFuel);
		model = md;
		colour = c;
		transmission = t;
	}
		
	
	public void setModel(String md) {
		model = md;
	}
	public void setColour(String c) {
		colour = c;
	}	
	public void setDrive(String t) {
		transmission = t;
	}
		
	
	public String getTran() {
		return(transmission);
	}
	public String getModel() {
		return(model);
	}
		public String getColour() {
		return(colour);
	}
		
	public String toString() {
		return("Make & Model: " + model + "\n" 				
				+ "Colour: " + colour + "\n"
				+ super.toString() + "\n"
				+ "Transmission Type: " + transmission);
	}

	String vehicleType() {
		return("Car");
	}
	String vehicleModel() {
		return(model);
	}
	String vehicleColour() {
		return(colour);
	}
	
	
	
}