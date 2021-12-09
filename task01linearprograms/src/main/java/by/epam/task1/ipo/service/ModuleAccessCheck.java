package by.ipo.task1.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to check access to database.
 * @author Pavel Isidovich
 *
 */

public class ModuleAccessCheck {
	
	private static ModuleAccessCheck instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private ModuleAccessCheck() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static ModuleAccessCheck getInstance() {
		if (instance == null) {
			instance = new ModuleAccessCheck();
		}
		return instance;
	}
	
	/**
	 * This method checks access to database modules cording to 
	 * provided password.
	 * @param password - entered password
	 * @return string-answer
	 */
	public int checkAccess(String password) {
		logger.info("Данные получены, ответ отправлен");
		
		if (password.matches("^9583$") | password.matches("^1747$")) {
			return 3;
		} else if (password.matches("^3331$") | password.matches("^7922$")) {
			return 2;
		} else if (password.matches("^9455$") | password.matches("^8997$")) {
			return 1;
		} else {
			return 0;
		}
	}
}
