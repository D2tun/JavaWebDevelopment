package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get dots of function of type
 * F(x) = x - sin(x).
 * @author Pavel Isidovich
 *
 */

public class SecondFunctionBuilder {
	
	private static SecondFunctionBuilder instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private SecondFunctionBuilder() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static SecondFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new SecondFunctionBuilder();
		}
		return instance;
	}
	
	/**
	 * This method calculates coordinates of dots in function of type
	 * F(x) = x - sin(x).
	 * @param a - low limit of argument x
	 * @param b - high limit of argument x
	 * @param h - calculation step
	 * @return string-answer
	 */
	public String getCoordinates(double a, double b, double h) {
		logger.info("Данные получены");
		
		String answer = "x    y\n";
		double fx = 0;
		
		do {
			fx = a - StrictMath.sin(a);
			answer += a + "    " + fx + "\n";
			a += h;
		} while (a <= b);
		
		logger.info("Данные отправлены");
		
		return answer;
	}
}
