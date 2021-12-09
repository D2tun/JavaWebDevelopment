package by.ipo.task1.service;

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
	public char[] searchSymbol(char ch) {
		logger.info("Данные получены");
		
		byte nextChar = 0;
		byte prevChar = 0;
		

		nextChar = (byte) ((byte) ch + 1);
		prevChar = (byte) ((byte) ch - 1);
		

		logger.info("Ответ отправлен");
		
		return new char[] {ch, (char) nextChar, (char) prevChar};
	}
}
