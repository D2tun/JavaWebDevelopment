package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get flattery phrase, according to
 * given gender.
 * @author Pavel Isidovich
 *
 */

public class FlatteryPhrase {

	private static FlatteryPhrase instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private FlatteryPhrase() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static FlatteryPhrase getInstance() {
		if (instance == null) {
			instance = new FlatteryPhrase();
		}
		return instance;
	}
	
	/**
	 * This method returns phrase cording to gender sign (Д/М).
	 * @param data - gender sign (Д/М)
	 * @return string-answer
	 */
	public String getPhrase (String data) {
		if (data.matches("[МД]")) {
			logger.info("Данные получены, ответ отправлен");
			return (data.charAt(0) == 'Д') ? "Мне нравятся девочки!"
						       : "Мне нравятся мальчики!";
		} else {
			return "Неверные данные";
		}
	}
}
