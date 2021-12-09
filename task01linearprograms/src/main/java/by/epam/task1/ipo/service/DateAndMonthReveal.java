package by.ipo.task1.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method, which searches for date and month in
 * range of one year.
 * @author Pavel Isidovich
 *
 */

public class DateAndMonthReveal {

	private static DateAndMonthReveal instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private DateAndMonthReveal() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static DateAndMonthReveal getInstance() {
		if (instance == null) {
			instance = new DateAndMonthReveal();
		}
		return instance;
	}
	
	/**
	 * This method searches for date and month in range of one year
	 * by number of day in year. Method returns string-answer, ready
	 * to be displayed (for example "1 января").
	 * @param data - number of day in year (1 - 365)
	 * @return result - array, where result[0] - number of day in year, 
	 * result[1] - number of month in year
	 * @throws IOException  - wrong data exception
	 */
	public int[] getDateAndMonth(int dayInYear) throws IOException {
		int[] result = {dayInYear, 1};
		
		logger.info("Данные получены");
		
		if ((dayInYear >= 1) & (dayInYear <= 31)) {
			result[1] = 1;
		} else if ((dayInYear >= 32) & (dayInYear <= 59)) {
			result[0] -= 31;
			result[1] = 2;
		} else if ((dayInYear >= 60) & (dayInYear <= 90)) {
			result[0] -= 59;
			result[1] = 3;
		} else if ((dayInYear >= 91) & (dayInYear <= 120)) {
			result[0] -= 90;
			result[1] = 4;
		} else if ((dayInYear >= 121) & (dayInYear <= 151)) {
			result[0] -= 120;
			result[1] = 5;
		} else if ((dayInYear >= 152) & (dayInYear <= 181)) {
			result[0] -= 151;
			result[1] = 6;
		} else if ((dayInYear >= 182) & (dayInYear <= 212)) {
			result[0] -= 181;
			result[1] = 7;
		} else if ((dayInYear >= 213) & (dayInYear <= 243)) {
			result[0] -= 212;
			result[1] = 8;
		} else if ((dayInYear >= 244) & (dayInYear <= 273)) {
			result[0] -= 243;
			result[1] = 9;
		} else if ((dayInYear >= 274) & (dayInYear <= 304)) {
			result[0] -= 273;
			result[1] = 10;
		} else if ((dayInYear >= 305) & (dayInYear <= 334)) {
			result[0] -= 304;
			result[1] = 11;
		} else if ((dayInYear >= 335) & (dayInYear <= 365)) {
			result[0] -= 334;
			result[1] = 12;
		} else {
			throw new IOException();
		}
		
		logger.info("Ответ отправлен");
		
		return result;
	}
}
