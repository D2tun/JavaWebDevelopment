package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to find code of symbol (UTF-8) and 
 * two neighbor symbols. 
 * @author Pavel Isidovich
 *
 */

public class UTFSymbolSearch {
	
	private static UTFSymbolSearch instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private UTFSymbolSearch() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static UTFSymbolSearch getInstance() {
		if (instance == null) {
			instance = new UTFSymbolSearch();
		}
		return instance;
	}
	
	/**
	 * This method finds code of symbol (UTF-8) and two neighbor 
	 * symbols.
	 * @param data - target symbol
	 * @return string-answer
	 */
	public String searchSymbol(String data) {
		char ch = ' ';
		byte nextChar = 0;
		byte prevChar = 0;
		
		if (data.matches("^.{1}$")) {
			ch = data.charAt(0);
			nextChar = (byte) ((byte) ch + 1);
			prevChar = (byte) ((byte) ch - 1);
			logger.info("Данные получены");
		} else {
			return "Неверные данные";
		}
		
		logger.info("Ответ отправлен");
		
		return "Символу " + ch + " соответствует номер " + (byte) ch 
			   + ".\n Следуюий символ " + (char) nextChar 
			   + ",\n предыдущий " + "символ " + (char) prevChar;
	}
}
