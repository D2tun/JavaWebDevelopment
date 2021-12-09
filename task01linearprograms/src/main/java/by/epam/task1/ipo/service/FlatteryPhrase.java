package by.ipo.task1.service;

import java.io.IOException;

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
	 * @throws IOException - input data error
	 */
	public String getPhrase (String data) throws IOException {
		if (data.matches("[МД]")) {
			logger.info("Данные получены, ответ отправлен");
			return (data.charAt(0) == 'Д') ? "Мне нравятся девочки!"
										   : "Мне нравятся мальчики!";
		} else {
			throw new IOException();
		}
	}
}
