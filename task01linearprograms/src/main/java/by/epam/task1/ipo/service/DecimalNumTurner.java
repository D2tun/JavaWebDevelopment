package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to turn places of decimal number's 
 * integer and fractional parts.
 * @author Pavel Isidovich
 *
 */

public class DecimalNumTurner {
	
	private static DecimalNumTurner instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private DecimalNumTurner() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static DecimalNumTurner getInstance() {
		if (instance == null) {
			instance = new DecimalNumTurner();
		}
		return instance;
	}
	
	/**
	 * This method turns <strong>number</strong> of format nnn.ddd to
	 * ddd.nnn.
	 * @param data - number of format nnn.ddd
	 * @return string-answer
	 */
	public String turn(String data) {
		double num = Double.NaN;
		
		if (data.matches("^[0-9]{3}[.,]{1}[0-9]{3}$")) {
			data = data.replace(',', '.');
			num = Double.valueOf(data);
		}
		
		if (Double.isNaN(num)) {
			return "Неверные данные";
		}
		
		logger.info("Даные получены");
		
		double a = (num * 1000) % 1000 + StrictMath.floor(num) / 1000;
		
		logger.info("Ответ отправлен");
		return "Число " + num + " стало " + a;	 
	}
}
