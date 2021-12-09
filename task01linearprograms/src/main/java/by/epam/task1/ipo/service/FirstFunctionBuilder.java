package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get dots of function of type
 * y = x (x > 2), y = -x (x <= 2).
 * @author Pavel Isidovich
 *
 */

public class FirstFunctionBuilder {
	
	private static FirstFunctionBuilder instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private FirstFunctionBuilder() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static FirstFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new FirstFunctionBuilder();
		}
		return instance;
	}
	
	/**
	 * This function calculates coordinates of function of type
	 * y = x (x > 2), y = -x (x <= 2).
	 * @param lowBorder - low limit of argument x
	 * @param highBorder - high limit of argument x
	 * @param step - calculation step
	 * @return pack of dots
	 * @throws IOException - step entry error
	 */
	public double[][] getCoordinates(double lowBorder, double highBorder, 
								 double step) throws IOException {
		
		double[][] coordinates = new double[(int) ((highBorder - lowBorder + 1) 
													/ step)][2];
		
		if (lowBorder > highBorder) {
			double temp = lowBorder;
			lowBorder = highBorder;
			highBorder = temp;
		}
			
		if ((step <= 0)) {
			throw new IOException();
		} else {
			logger.info("Данные получены");
				
			String answer = "x    y\n";
			for (int i = 0; i < coordinates.length; ++i) {
				coordinates[i][0] = lowBorder;
				if (lowBorder > 2) {
					coordinates[i][1] = lowBorder;
				} else {
					coordinates[i][1] = -1 * lowBorder;
				}
				lowBorder += step;
			}
				
			logger.info("Ответ отправлен");
			
			return coordinates;
		}
	}
}
