package by.ipo.task1.service;

import java.io.IOException;

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
	 * @param num - entered number
	 * @return largest number's digit 
	 * @throws IOException - wrong input data
	 */
	public int getGreaterDigit(int num) throws IOException {
		int greaterDigit = 0;

		if (num <= 0) {
			throw new IOException();
		}
		
		logger.info("Данные получены");
		
		while (num != 0) {
			if (greaterDigit < (num % 10)) {
				greaterDigit =  num % 10;
			}
			num = num / 10;
		}
		
		logger.info("Ответ отправлен");
		return greaterDigit; 
	}
}
