package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to count quantity of even digits in 
 * number.
 * @author Pavel Isidovich
 *
 */

public class NumberOfEvenDigits {

	private static NumberOfEvenDigits instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	private NumberOfEvenDigits() {

	}

	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static NumberOfEvenDigits getInstance() {
		if (instance == null) {
			instance = new NumberOfEvenDigits();
		}
		return instance;
	}

	/**
	 * This method count's even digits in digit's set.
	 * @param data - entered number
	 * @return number of even digits
	 * @throws IOException - wrong data entry 
	 */
	public int getQuantity(int num) throws NumberFormatException {
		logger.info("Данные получены");
		
		int count = 0;
		
		if (num <= 0) {
			throw new NumberFormatException();
		}
		
		while (num > 0) {
			if (num % 2 == 0) {
				++count;
			}
			num /= 10;
		}
		
		logger.info("Данные отправлены");
		
		return count;
	}
}
