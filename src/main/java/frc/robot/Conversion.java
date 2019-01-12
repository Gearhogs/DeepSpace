package frc.robot;

public class Conversion {
	double test; 
	//TODO add conversion within function
	public static double DegreesToTicks(double degrees) {
		int driveGear = 16;
		int drivenGear = 60;
		double ratio = .26666;//driveGear / drivenGear;
		
		double result = ((4096/360*-1.0)/ratio)*degrees;
		return result;
		
	}
	
}
