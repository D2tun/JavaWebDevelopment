package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get dots of function of type
 * y = x (x > 2), y = -x (x <= 2).
 * @author Pavel Isidovich
 *
 */

public class FirstFunctionBuilder {
	
	private static FirstFunctionBuilder instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private FirstFunctionBuilder() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static FirstFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new FirstFunctionBuilder();
		}
		return instance;
	}
	
	/**
	 * This function calculates coordinates of function of type
	 * y = x (x > 2), y = -x (x <= 2).
	 * @param a - low limit of argument x
	 * @param b - high limit of argument x
	 * @param h - calculation step
	 * @return string-answer
	 */
	public String getCoordinates(double a, double b, double h) {
		logger.info("Данные получены");
		String answer = "x    y\n";
		do {
			if (a > 2) {
				answer += a + "    " + a + "\n";
			} else {
				answer += a + "    " + (a * -1) + "\n";
			}
			a += h;
		} while (a <= b); 
		logger.info("Ответ отправлен");
		return answer;
	}
}
