package by.epam.task1.ipo.dao;

import by.epam.task1.ipo.bean.Rectangle;

public class DataGetter {
	
	private static DataGetter instance;
	
	private DataGetter() {
		
	}
	
	public static DataGetter getInstance() {
		if (instance == null) {
			instance = new DataGetter();
		}
		return instance;
	}
	
	public double[] getRectangleData(double length) {
		Rectangle rec = new Rectangle(length);
		return rec.getData();
	}

}
