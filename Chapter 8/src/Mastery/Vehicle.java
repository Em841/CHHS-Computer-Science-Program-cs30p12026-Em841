package Mastery;


abstract class Vehicle {	
    private int seatingCapacity;
    private double cargoVolume, fuelEconomyCity, fuelEconomyHwy;;
	

	public Vehicle() {
		seatingCapacity = 0;
		cargoVolume = 0; 
		fuelEconomyCity = 0;
		fuelEconomyHwy = 0;
	}
			
	
	public Vehicle(int s, double c, double fc, double fh) {
		seatingCapacity = s;
		cargoVolume = c;
		fuelEconomyCity = fc;
		fuelEconomyHwy = fh;
	}
			
	
	public void setSeat(int s) {
		seatingCapacity = s;
	}
	public void setCargo(double c) {
		cargoVolume = c;
	}
	public void setCtyEcon(double fc) {
		fuelEconomyCity = fc;
	}
	public void setHwyEcon(double fh) {
		fuelEconomyHwy = fh;
	}
			
	
	public int getSeat() {
		return(seatingCapacity);
	}
	public double getCargo() {
		return(cargoVolume);
	}
	public double getCtyEcon() {
		return(fuelEconomyCity);
	}
	public double getHwyEcon() {
		return(fuelEconomyHwy);
	}
	
	
	public String toString() {
		return("Seat Capacity: " + seatingCapacity + "\n"
				+ "Cargo Volume(m²): " + cargoVolume + "\n"
				+ "City Fuel Economy(km/L): " + fuelEconomyCity + "\n"
				+ "Highway Fuel Economy(km/L): " + fuelEconomyHwy);
	}
	
	
	abstract String vehicleType();
	
	abstract String vehicleModel();
	
	abstract String vehicleColour();
	
	
}