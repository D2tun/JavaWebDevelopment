package by.epam.task1.ipo.service;

import by.epam.task1.ipo.bean.Rectangle;
import by.epam.task1.ipo.service.AreaCalculation;

public class AreaCalculation {
	
	private static AreaCalculation instance;

	private AreaCalculation() {
		
	}
	
	public static AreaCalculation getInstance() {
		if (instance == null) {
			instance = new AreaCalculation();
		}
		return instance;
	}
	
	public String getAnswer(double length) {
		Rectangle rec = new Rectangle(length);
		return "Прямоугольник длиной " + rec.getLength() + " мм, шириной "
				+ rec.getWidth() + " мм, площадью " + rec.getArea() + " кв. мм.";					
	}

}
