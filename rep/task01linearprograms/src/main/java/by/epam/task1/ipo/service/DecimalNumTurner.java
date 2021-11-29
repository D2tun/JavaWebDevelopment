package by.epam.task1.ipo.service;

import by.epam.task1.ipo.service.DecimalNumTurner;

public class DecimalNumTurner {
	
	private static DecimalNumTurner instance;
	
	private DecimalNumTurner() {
		
	}
	
	public static DecimalNumTurner getInstance() {
		if (instance == null) {
			instance = new DecimalNumTurner();
		}
		return instance;
	}
	
	public String turn(double num) {
		
		double a = (num * 1000) % 1000 + StrictMath.floor(num) / 1000;
		
		return "Число " + num + " стало " + a;	 
	}
}
