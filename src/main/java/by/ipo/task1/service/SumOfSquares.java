package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to sum square values of first n numbers.
 * @author Pavel Isidovich
 *
 */

public class SumOfSquares {
	
	private static SumOfSquares instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private SumOfSquares() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static SumOfSquares getInstance() {
		if (instance == null) {
			instance = new SumOfSquares();
		}
		return instance;
	}
	
	/**
	 * This method calculates sum of square values of numbers in 
	 * range from 1 to <strong>quantity</strong>.
	 * @param quantity - quantity of numbers
	 * @return sum of numbers' squares
	 */
	public int getSum(int quantity) throws IOException {		
		if (quantity <= 0) {
			throw new IOException();
		}
		
		logger.info("Данные получены");
		
		int result = 0;
		
		for (int i = 1; i <= quantity; ++i) {
			result += i * i;
		}
		
		logger.info("Данные отправлены");
		
		return result;
	}
}
