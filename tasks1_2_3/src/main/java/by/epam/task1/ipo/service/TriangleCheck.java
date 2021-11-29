package by.epam.task1.ipo.service;

import by.epam.task1.ipo.bean.Triangle;

public class TriangleCheck {
	
	private static TriangleCheck instance;
	
	private TriangleCheck() {
		
	}
	
	public static TriangleCheck getInstance() {
		if (instance == null) {
			instance = new TriangleCheck();
		}
		return instance;
	}

	public String checkEquilaterality(double side1, double side2, double side3) {
		Triangle tr = new Triangle(side1, side2, side3);
		if (tr.isEquilateral()) {
			return "Это равносторонний треугольник";
		} else {
			return "Это не равносторонний треугольник";
		}
	}
	
}
