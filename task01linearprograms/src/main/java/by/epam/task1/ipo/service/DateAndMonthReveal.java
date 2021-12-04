package by.epam.task1.ipo.service;

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
	 * @return string-answer
	 */
	public String getDateAndMonth(String data) {
		
		int dayInYear = 0;
		
		if (data.matches("[0-9]{1,3}")) {
			dayInYear = Integer.parseInt(data);
		} 
		
		logger.info("Данные получены");
		
		if ((dayInYear >= 1) & (dayInYear <= 31)) {
			return dayInYear + " января";
		} else if ((dayInYear >= 32) & (dayInYear <= 59)) {
			dayInYear -= 31;
			return dayInYear + " февраля";
		} else if ((dayInYear >= 60) & (dayInYear <= 90)) {
			dayInYear -= 59;
			return dayInYear + " марта";
		} else if ((dayInYear >= 91) & (dayInYear <= 120)) {
			dayInYear -= 90;
			return dayInYear + " апреля";
		} else if ((dayInYear >= 121) & (dayInYear <= 151)) {
			dayInYear -= 120;
			return dayInYear + " мая";
		} else if ((dayInYear >= 152) & (dayInYear <= 181)) {
			dayInYear -= 151;
			return dayInYear + " июня";
		} else if ((dayInYear >= 182) & (dayInYear <= 212)) {
			dayInYear -= 181;
			return dayInYear + " июля";
		} else if ((dayInYear >= 213) & (dayInYear <= 243)) {
			dayInYear -= 212;
			return dayInYear + " августа";
		} else if ((dayInYear >= 244) & (dayInYear <= 273)) {
			dayInYear -= 243;
			return dayInYear + " сентября";
		} else if ((dayInYear >= 274) & (dayInYear <= 304)) {
			dayInYear -= 273;
			return dayInYear + " октября";
		} else if ((dayInYear >= 305) & (dayInYear <= 334)) {
			dayInYear -= 304;
			return dayInYear + " ноября";
		} else if ((dayInYear >= 335) & (dayInYear <= 365)) {
			dayInYear -= 334;
			return dayInYear + " декабря";
		} else {
			return "Неверные данные";
		}
	}
}
