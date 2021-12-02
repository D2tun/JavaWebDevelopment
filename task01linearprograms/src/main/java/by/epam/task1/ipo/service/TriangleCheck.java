package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

import by.epam.task1.ipo.bean.Triangle;

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
	 * @return string-answer
	 */
	public String checkEquilaterality(double side1, double side2, double side3) {
		Triangle tr = new Triangle(side1, side2, side3);
		
		logger.info("Данные получены, ответ отправлен");
		
		if (tr.isEquilateral()) {
			return "Это равносторонний треугольник";
		} else {
			return "Это не равносторонний треугольник";
		}
	}
}
