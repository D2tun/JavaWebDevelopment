package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides methods to swap variables.
 * @author Pavel Isidovich
 *
 */

public class SwapVariables {
	
	private static SwapVariables instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private SwapVariables() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public SwapVariables getInstance() {
		if (instance == null) {
			instance = new SwapVariables();
		}
		return instance;
	}
	
	/**
	 * This method swaps variables through dump-variable.
	 * @param first - first variable (int)
	 * @param second - second variable (int)
	 * @return string-answer
	 */
	public String swapFirstWay(int first, int second) {
		logger.info("Данные получены");
	
		String original = first + " " + second;
		
		int temp = first;
		first = second;
		second = temp;
		
		logger.info("Ответ отправлен");
		
		return original + " => " + first + " " + second;
	}

	/**
	 * This method swaps variables through arithmetic operations.
	 * @param first - first variable (int)
	 * @param second - second variable (int)
	 * @return string-answer
	 */
	public String swapSecondWay(int first, int second) {
		logger.info("Данные получены");
	
		String original = first + " " + second;
		
		first = first + second;
		second = second - first;
		first = -second;
		second = first - second;
		
		logger.info("Ответ отправлен");
		
		return original + " => " + first + " " + second;
	}
}
