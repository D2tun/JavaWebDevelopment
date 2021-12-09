package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task1.bean.TaskRequiredRectangle;
import by.ipo.task1.service.AreaCalculation;

/**
 * This class works with information, provided by triangle class.
 * @author Pavel Isidovich
 * @see by.ipo.task1.bean.Triangle
 */

public class AreaCalculation {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	private static AreaCalculation instance;

	private AreaCalculation() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static AreaCalculation getInstance() {
		if (instance == null) {
			instance = new AreaCalculation();
		}
		return instance;
	}
	
	/**
	 * This method gets data about rectangle of given <strong>length
	 * </strong> and returns string-answer, which is ready to be
	 * displayed.
	 * @param data - rectangle's length.
	 * @return rectangle's area
	 * @throws IOException - entered length error
	 */
	public double getAnswer(double length) throws IOException {
		 
		if (length > 0) {
			logger.info("Длина получена");
			
			TaskRequiredRectangle rec = new TaskRequiredRectangle(length);
			
			logger.info("Ответ отправлен");
			
			return rec.getArea();
		} else {
			throw new IOException();
		}	
	}
}