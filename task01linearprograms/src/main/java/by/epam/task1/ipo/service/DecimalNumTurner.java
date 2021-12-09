package by.ipo.task1.service;

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
	 * @param num - number of format nnn.ddd
	 * @return num - array, where num[0] - original number, num[1] - 
	 * changed number
	 */
	public double[] turn(double num) {
		
		if (String.valueOf(num).matches("^[0-9]{3}[.,]{1}[0-9]{3}$")) {
			logger.info("Даные получены");
			
			double turnedNum = (num * 1000) % 1000 + StrictMath.floor(num) 
								/ 1000;
			
			logger.info("Ответ отправлен");
			
			return new double[] {num, turnedNum};
		} else {
			throw new NumberFormatException();
		}
	}
}
