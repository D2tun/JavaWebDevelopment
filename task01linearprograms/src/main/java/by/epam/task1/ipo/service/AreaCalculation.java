package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

import by.epam.task1.ipo.bean.Rectangle;
import by.epam.task1.ipo.service.AreaCalculation;

/**
 * This class works with information, provided by triangle class.
 * @author Pavel Isidovich
 * @see by.epam.task1.ipo.bean.Triangle
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
	 * @param length - rectangle's length.
	 * @return string-answer
	 */
	public String getAnswer(double length) {
		logger.info("Длина получена");
		Rectangle rec = new Rectangle(length);
		logger.info("Данные получены");
		return "Прямоугольник длиной " + rec.getLength() + " мм, шириной "
				+ rec.getWidth() + " мм, площадью " + rec.getArea() + " кв. мм.";	
	}
}
