package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import by.ipo.task1.bean.FirstExpression;
import by.ipo.task1.bean.SquareExpressionAbs;

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
	 * @return calculated result
	 * @throws IOException - zero-dividing error
	 */
	public double calculateFirstExpression(double a, double b, double c, 
										   double d) throws IOException {
		if ((c == 0) || (d == 0)) {
			throw new IOException();
		}
		
		logger.info("Данные получены");
		
		FirstExpression fe = new FirstExpression(a, b, c, d);
		
		logger.info("Ответ отправлен");
		
		return fe.getResult();	
	}
	
	/**
	 * This method calculates expression of type 
	 * |a * x * x + b * x + c|.
	 * @param a - expression's parameter 
	 * @param b - expression's parameter 
	 * @param c - expression's parameter 
	 * @param x - expression's parameter 
	 * @return calculated result
	 */
	public double calculateSquareExpressionAbs(double a, double b, double c, 
											   double x) {

		logger.info("Данные получены");
		
		SquareExpressionAbs sea = new SquareExpressionAbs(a, b, c, x);
		
		logger.info("Ответ отправлен");
		
		return sea.getResult();	
	}
}
