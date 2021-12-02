package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides methods to get results of different expressions.
 * @author Pavel Isidovich
 *
 */

public class ExpressionCalculation {

	private static ExpressionCalculation instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private ExpressionCalculation() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static ExpressionCalculation getInstance() {
		if (instance == null) {
			instance = new ExpressionCalculation();
		}
		return instance;
	}
	
	/**
	 * This method calculates expression of type 
	 * (a / c) * (b / d) - ((a * b - c) / (c * d)).
	 * @param a - expression's parameter
	 * @param b - expression's parameter
	 * @param c - expression's parameter
	 * @param d - expression's parameter
	 * @return string-answer
	 */
	public String calculateFirstExpression(double a, double b, double c, 
										   double d) {
		logger.info("Данные получены, ответ отправлен");
		return a + " / " + c + " * " + b + " / " +  d + " - ((" + a + " * " 
			   + b + " - " + c + ") / (" + c + " * " + d + ")) = " + (a / c 
			   * b / d - ((a * b - c) / (c * d)));
	}
	
	/**
	 * This method calculates expression of type 
	 * |a * x * x + b * x + c|.
	 * @param a - expression's parameter
	 * @param b - expression's parameter
	 * @param c - expression's parameter
	 * @param x - expression's parameter
	 * @return string-answer
	 */
	public String calculateSquareExpressionAbs(double a, double b, double c,
			                                double x) {
		logger.info("Данные получены, ответ отправлен");
		return "|" + a + " * " + x + " * " + x + " + " + b + " * " + x + " + "
				+ c + "| = " + StrictMath.abs(a * x * x + b * x + c);
	}
}
