package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task1.bean.Triangle;

/**
 * This class provides method to check triangle.
 * @author Pavel Isidovich
 *
 */

public class TriangleCheck {
	
	private static TriangleCheck instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private TriangleCheck() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static TriangleCheck getInstance() {
		if (instance == null) {
			instance = new TriangleCheck();
		}
		return instance;
	}
	
	/**
	 * This method returns string-answer cording to condition if 
	 * triangle is equilateral or not.
	 * @param side1 - side of triangle
	 * @param side2 - side of triangle
	 * @param side3 - side of triangle
	 * @return true if triangle is equilateral, esle - false
	 */
	public boolean checkEquilaterality(double side1, double side2, double side3)
		throws IOException {
			
			if ((side1 <= 0) || (side2 <= 0) || (side3 <= 0)) {
				throw new IOException();
			} 
			
			logger.info("Данные получены");
			
			Triangle tr = new Triangle(side1, side2, side3);
			
			logger.info("Ответ отправлен");
			
			return tr.isEquilateral();
	}
}
