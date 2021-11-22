package by.epam.task1.ipo.service;

public class DecimalNumTurner {
	
	public static DecimalNumTurner instance;
	
	private DecimalNumTurner() {
		
	}
	
	public static DecimalNumTurner getInstance() {
		if (instance == null) {
			instance = new DecimalNumTurner();
		}
		return instance;
	}
	
	public String turn(double num) {
		
		double a = StrictMath.round(num);
		double b = (num - a) * 1000;
		
		return "Число" + num + "стало " + (int) b + "." + (int) a;	 
	}
}
