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
	 * @param data - entered number
	 * @return string-answer
	 */
	public String getGreaterDigit(String data) {
		char greaterDigit = 0;
		
		if (data.matches("^[0-9]+$") && !data.matches("^0{1}&")) {
			char[] digits = data.toCharArray();
			for (int i = 0; i < digits.length; i++) {
				if (Integer.valueOf(digits[i]) > greaterDigit) {
					greaterDigit = digits[i];
				}
			}
			logger.info("Данные получены");
			logger.info("Ответ отправлен");
			return "Наибольшая цифра числа: " + greaterDigit; 
		} else {
			return "Неверные данные";
		}
	}
}
