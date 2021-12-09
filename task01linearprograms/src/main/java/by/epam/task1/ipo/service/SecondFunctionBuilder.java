package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get dots of function of type
 * F(x) = x - sin(x).
 * @author Pavel Isidovich
 *
 */

public class SecondFunctionBuilder {
	
	private static SecondFunctionBuilder instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private SecondFunctionBuilder() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static SecondFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new SecondFunctionBuilder();
		}
		return instance;
	}
	
	/**
	 * This method calculates coordinates of dots in function of type
	 * F(x) = x - sin(x).
	 * @param lowBorder - low limit of argument x
	 * @param highBorder - high limit of argument x
	 * @param step - calculation step
	 * @return pack of dots
	 * @throws IOException - step entry error
	 */
	public double[][] getCoordinates(double lowBorder, double highBorder, 
								 double step) throws IOException {
		
		if (lowBorder > highBorder) {
			double temp = lowBorder;
			lowBorder = highBorder;
			highBorder = temp;
		}
		
		if ((step <= 0)) {
			throw new IOException();
		}	
		
		logger.info("Данные получены");
		
		double[][] coordinates = new double[(int) ((highBorder - lowBorder + 1) 
													/ step)][2];
		
		for (int i = 0; i < coordinates.length; ++i, lowBorder += step) {
			coordinates[i][0] = lowBorder;
			coordinates[i][1] = lowBorder - StrictMath.sin(lowBorder);
		}
		
		
		logger.info("Данные отправлены");
		
		return coordinates;
	}
}
