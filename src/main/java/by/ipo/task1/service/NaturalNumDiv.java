package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to divide numbers and get youngest 
 * radix of result's integer part and oldest radix of result's 
 * fractional part.
 * @author Pavel Isidovich
 *
 */
public class NaturalNumDiv {

	private static NaturalNumDiv instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private NaturalNumDiv() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static NaturalNumDiv getInstance() {
		if (instance == null) {
			instance = new NaturalNumDiv();
		}
		return instance;
	}
	
	/**
	 * This method divides numbers and gets youngest radix of result's 
	 * integer part and oldest radix of result's fractional part.
	 * @param m - dividend
	 * @param n - divider
	 * @return array, where element[0] - youngest integer radix, 
	 * element[1] - eldest fractional radix
	 */
	public int[] divide(double m, double n) throws IOException {
		
		if ((m <= 0) | (n <= 0)) {
			throw new IOException();
		}
		
		double divRes = m / n;
		int num = (int) divRes;
		double frac = divRes - num;
		int[] result = {num % 10, (int) (frac * 10)};
			
		logger.info("Ответ отправлен");
			
		return result;
	}
}
