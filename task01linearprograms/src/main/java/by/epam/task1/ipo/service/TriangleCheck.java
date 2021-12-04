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
	 * @param data - lengths of triangle in string format
	 * @return string-answer
	 */
	public String checkEquilaterality(String data) {
		double side1 = 0;
		double side2 = 0;
		double side3 = 0;
		String[] parsedData = data.split(" ");

		//??
		if (parsedData.length != 3) {
			return "Неверные данные";
		}
		
		if (parsedData[0].matches("^[0-9]+[.,]{0,1}[0-9]{0,}$") 
				&& parsedData[1].matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[2].matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			
			parsedData[0] = parsedData[0].replace(',', '.');
			parsedData[1] = parsedData[1].replace(',', '.');
			parsedData[2] = parsedData[2].replace(',', '.');
			
			side1 = Double.valueOf(parsedData[0]);
			side2 = Double.valueOf(parsedData[1]);
			side3 = Double.valueOf(parsedData[2]);
			
			if ((side1 == 0) || (side2 == 0) || (side3 == 0)) {
				return "Неверные данные";
			} 
			
			logger.info("Данные получены");
			
			Triangle tr = new Triangle(side1, side2, side3);
			
			logger.info("Ответ отправлен");
			
			if (tr.isEquilateral()) {
				return "Это равносторонний треугольник";
			} else {
				return "Это не равносторонний треугольник";
			}
		} else {
			return "Неверные данные";
		}
	}
}
