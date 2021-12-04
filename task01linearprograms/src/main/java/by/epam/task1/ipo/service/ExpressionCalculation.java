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
	 * @param data - consequence of expression's parameters, divided by space
	 * @return string-answer
	 */
	public String calculateFirstExpression(String data) {
		double a = Double.NaN;
		double b = Double.NaN; 
		double c = Double.NaN; 
		double d = Double.NaN;
		
		String[] parsedData = data.split(" ");
		
		if (parsedData.length != 4) {
			return "Неверные данные";
		}
		
		logger.info("Данные получены");
		
		if (parsedData[0].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[1].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[3].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[2].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			
			parsedData[0] = parsedData[0].replace(',', '.');
			parsedData[1] = parsedData[1].replace(',', '.');
			parsedData[2] = parsedData[2].replace(',', '.');
			parsedData[3] = parsedData[3].replace(',', '.');
			
			a = Double.valueOf(parsedData[0]);
			b = Double.valueOf(parsedData[1]);
			c = Double.valueOf(parsedData[2]);
			d = Double.valueOf(parsedData[3]);
		}
		
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) 
				|| Double.isNaN(d)) {
			return "Неверные данные";
		} else {
			logger.info("Ответ отправлен");
			return a + " / " + c + " * " + b + " / " +  d + " - ((" + a + " * " 
				   + b + " - " + c + ") / (" + c + " * " + d + ")) = " + (a / c 
				   * b / d - ((a * b - c) / (c * d)));
		}
	}
	
	/**
	 * This method calculates expression of type 
	 * |a * x * x + b * x + c|.
	 * @param data - consequence of expression's parameters, divided by space
	 * @return string-answer
	 */
	public String calculateSquareExpressionAbs(String data) {
		double a = Double.NaN;
		double b = Double.NaN; 
		double c = Double.NaN; 
		double x = Double.NaN;
		
		String[] parsedData = data.split(" ");
		
		if (parsedData.length != 4) {
			return "Неверные данные";
		}
		
		logger.info("Данные получены");
		
		if (parsedData[0].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[1].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[3].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[2].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			
			parsedData[0] = parsedData[0].replace(',', '.');
			parsedData[1] = parsedData[1].replace(',', '.');
			parsedData[2] = parsedData[2].replace(',', '.');
			parsedData[3] = parsedData[3].replace(',', '.');
			
			a = Double.valueOf(parsedData[0]);
			b = Double.valueOf(parsedData[1]);
			c = Double.valueOf(parsedData[2]);
			x = Double.valueOf(parsedData[3]);
		}
		
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) 
				|| Double.isNaN(x)) {
			return "Неверные данные";
		} else {
			logger.info("Ответ отправлен");
			return "|" + a + " * " + x + " * " + x + " + " + b + " * " + x 
					+ " + " + c + "| = " + StrictMath.abs(a * x * x + b * x 
					+ c);	
		}
	}
}
