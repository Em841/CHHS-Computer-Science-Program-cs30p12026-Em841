/*
 * Program:BreakAplate
 * Purpose:user can add cars, trucks, or minivans, then view them by category. Each vehicle shares common properties (seats, cargo, fuel economy) but has unique 
 * features (transmission, seat capacity). 
 * Author: Eman Abid
 * School:CHHS
 * Course: CSE 3130 Object-Oriented Programming 2
  */
package Mastery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Vehicletest {

	public static void main (String[] args) {
		//Initialize variables
		String action, view;
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> carList = new ArrayList<>();
		ArrayList<Vehicle> truckList = new ArrayList<>();
		ArrayList<Vehicle> vanList = new ArrayList<>();
		String[] actionList = {"a", "v", "q"};
		String prompt = "a to Add Vehicle || v to View Catalogue || q to Quit";		
		
		//Display program name
		System.out.println("VEHICLE CATALOGUE");
		
		//do-while loop
		do {
			System.out.println("\n" + prompt);
			action = input.nextLine();	
			action = action.toLowerCase();
			
			while (!Arrays.asList(actionList).contains(action)) {
				System.out.println("Invalid option.");
				System.out.println("\n" + prompt);
				action = input.nextLine();
				action = action.toLowerCase();
			}	
		
			//Checks if user wants to view employees
			if (action.equals("a")) {
				Vehicle obj = assignV();

				if (obj.vehicleType().equals("Car")) {
					carList.add(obj);
				}
				else if (obj.vehicleType().equals("Truck")) {
					truckList.add(obj);
				}
				else if (obj.vehicleType().equals("Minivan")) {
					vanList.add(obj);
				}
			}
			
			else if (action.equals("v") ) {
				System.out.println("View: (C)ars || (T)rucks || (M)inivan");
				view = input.nextLine();
				view = view.toLowerCase();
				//Displays information of each object in arraylist
				if (view.equals("c")) {	
					if(carList.isEmpty()) {
						System.out.println("Car Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < carList.size(); i++) {							
							System.out.println(carList.get(i) + "\n"); 
						}					
					}
					
				}
				else if (view.equals("t")) {				
					if(truckList.isEmpty()) {
						System.out.println("Truck Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < truckList.size(); i++) {
							System.out.println(truckList.get(i) + "\n"); 						
						}						
					}
				}
				else if (view.equals("m")) {	
					if(vanList.isEmpty()) {
						System.out.println("Minivan Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < vanList.size(); i++) {
							System.out.println(vanList.get(i) + "\n"); 
						}						
					}
				}
				else {
					System.out.println("Invalid option.");
				}

			}

			
		} while (!action.equalsIgnoreCase("q"));		
	}
	
	
	public static Vehicle assignV() {	
		//Initialize variables
		String type, make, colour, transmission, door;
		int seatNum;
		double cargoV, ctyEcon, hwyEcon, towCap;
		String[] typeList = {"c", "t", "m"};
		Scanner input = new Scanner(System.in);	
		String typePrompt = "Type Of Vehicle:"
				+ "Write 'c' to add Car || Write 't' to add Truck || Write 'm' to add Minicar";
			
		System.out.print("Make & Model Of Vehicle: ");
		make = input.nextLine();
		
		System.out.print("Colour Of Vehicle: ");
		colour = input.nextLine();
		
		System.out.print("Seat Capacity: ");
		seatNum = input.nextInt();
		input.nextLine();
		
		System.out.print("Cargo Volume(m²): ");
		cargoV = input.nextDouble();
		input.nextLine();
		
		System.out.print("City Fuel Economy(km/L): ");
		ctyEcon = input.nextDouble();
		input.nextLine();
		
		System.out.print("Highway Fuel Economy(km/L): ");
		hwyEcon = input.nextDouble();
		input.nextLine();		
		
		System.out.println(typePrompt);
		type = input.nextLine();
		type = type.toLowerCase();
		
		while(!Arrays.asList(typeList).contains(type)) {
			System.out.println("Invalid option.");

			System.out.println(typePrompt);
			type = input.nextLine();
			type = type.toLowerCase();
		}
		
		if (type.equals("c")) {		
			System.out.print("Transmission Type(Auto/Manual): ");
			transmission = input.nextLine();
			//Returns object with data inputted
			return (new Car(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, transmission));
		}
		else if (type.equals("t")) {		
			System.out.print("Towing Capacity(kg): ");
			towCap = input.nextDouble();
			input.nextLine();		
			//Returns object with data inputted
			return (new Truck(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, towCap));
		}
		else if (type.equals("m")) {		
			System.out.print("Sliding Door(yes/no): ");
			door = input.next();
			//Returns object with data inputted
			return (new Minivan(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, door));
		}
		
		return null;		
	}
	
}

/*VEHICLE CATALOGUE

a to Add Vehicle || v to View Catalogue || q to Quit
a
Make & Model Of Vehicle: BMW
Colour Of Vehicle: Whotw
Seat Capacity: 4
Cargo Volume(m²): 67
City Fuel Economy(km/L): 67
Highway Fuel Economy(km/L): 67
Type Of Vehicle:Write 'c' to add Car || Write 't' to add Truck || Write 'm' to add Minicar
t
Towing Capacity(kg): 45

a to Add Vehicle || v to View Catalogue || q to Quit
v
View: (C)ars || (T)rucks || (M)inivan
t
Make & Model: BMW
Colour: Whotw
Seat Capacity: 4
Cargo Volume(m²): 67.0
City Fuel Economy(km/L): 67.0
Highway Fuel Economy(km/L): 67.0
Towing Capacity(kg): 45.0


a to Add Vehicle || v to View Catalogue || q to Quit
v
View: (C)ars || (T)rucks || (M)inivan
c
Car Catalogue Is Empty

a to Add Vehicle || v to View Catalogue || q to Quit
q

*/