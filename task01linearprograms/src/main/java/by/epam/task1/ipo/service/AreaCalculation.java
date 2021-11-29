package by.epam.task1.ipo.service;

import by.epam.task1.ipo.dao.DataGetter;
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
		DataGetter dg = DataGetter.getInstance();
		double[] data = dg.getRectangleData(length);
		return "Прямоугольник длиной " + data[0] + " мм, шириной "
				+ data[1] + " мм, площадью " + data[2] + " кв. мм.";					
	}

}
