package by.epam.task1.ipo.service;

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
	 * @return string-answer
	 */
	public String getQuantity(String data) {
		char[] digits;
		
		if (data.matches("[0-9]+") && !data.matches("0{1}")) {
			digits = data.toCharArray();
		} else {
			return "Неверные данные";
		}
		
		logger.info("Данные получены");
		
		String answer = "Чётные цифры числа: ";
		
		for (int i = 0; i < digits.length; i++) {
			if (Integer.valueOf(digits[i]) % 2 == 0) {
				answer += (digits[i]) + ", ";
			}
		}
		
		answer = answer.trim();
		
		StringBuilder cut = new StringBuilder(answer);
		answer = cut.deleteCharAt(answer.length() - 1).toString();
		
		logger.info("Данные отправлены");
		
		return answer;
	}
}
