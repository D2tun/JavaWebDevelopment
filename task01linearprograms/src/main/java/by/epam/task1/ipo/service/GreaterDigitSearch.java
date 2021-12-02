package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to search the largest digit.
 * @author Pavel Isidovich
 *
 */

public class GreaterDigitSearch {
	
	private static GreaterDigitSearch instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private GreaterDigitSearch() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static GreaterDigitSearch getInstance() {
		if (instance == null) {
			instance = new GreaterDigitSearch();
		}
		return instance;
	}
	
	/**
	 * This method searches the largest digit.
	 * @param digits - set of number's digits
	 * @return string-answer
	 */
	public String getGreaterDigit(char[] digits) {
		logger.info("Данные получены");
		
		char greaterDigit = 0;

		for (int i = 0; i < digits.length; i++) {
			if (Integer.valueOf(digits[i]) > greaterDigit) {
				greaterDigit = digits[i];
			}
		}
		
		logger.info("Ответ отправлен");
		return "Наибольшая цифра числа: " + greaterDigit; 
	}
}
