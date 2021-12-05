package by.epam.task1.ipo.service;import org.apache.logging.log4j.LogManager;/** * This class provides methods to swap variables. * @author Pavel Isidovich * */public class SwapVariables {		private static SwapVariables instance;	private static org.apache.logging.log4j					.Logger logger = LogManager.getFormatterLogger();		private SwapVariables() {			}		/**	 * This method returns link on existing object of this class. If	 * object doesn't exist, creates new object of this class.	 * @return <strong>instance</strong> of object.	 */	public static SwapVariables getInstance() {		if (instance == null) {			instance = new SwapVariables();		}		return instance;	}		/**	 * This method swaps variables through dump-variable.	 * @param data - variables in string format	 * @return string-answer	 */	public String swapFirstWay(String data) {		String[] parsedData = data.split(" ");				if (parsedData.length != 3) {			return "Неверные данные";		}				if (parsedData[1].matches("^-{0,1}[0-9]+") 				&& parsedData[2].matches("^-{0,1}[0-9]+")) {			logger.info("Данные получены");						int first = Integer.parseInt(parsedData[1]);			int second = Integer.parseInt(parsedData[2]);			String original = first + " " + second;						int temp = first;			first = second;			second = temp;						logger.info("Ответ отправлен");						return original + " => " + first + " " + second;		} else {			return "Неверные данные";		}							}	/**	 * This method swaps variables through arithmetic operations.	 * @param data - variables in string format	 * @return string-answer	 */	public String swapSecondWay(String data) {		String[] parsedData = data.split(" ");				if (parsedData.length != 3) {			return "Неверные данные";		}				if (parsedData[1].matches("^-{0,1}[0-9]+") 				&& parsedData[2].matches("^-{0,1}[0-9]+")) {			logger.info("Данные получены");						int first = Integer.parseInt(parsedData[1]);			int second = Integer.parseInt(parsedData[2]);			String original = first + " "+ second;			first = first + second;			second = first - second;			first = first - second;						logger.info("Ответ отправлен");						return original + " => " + first + " " + second;		} else {			return "Неверные данные";		}									}		/**	 * This method swaps variables through XOR operation	 * @param data - variables in string format	 * @return string-answer	 */	public String swapThirdWay(String data) {		String[] parsedData = data.split(" ");				if (parsedData.length != 3) {			return "Неверные данные";		}				if (parsedData[1].matches("^-{0,1}[0-9]+") 				&& parsedData[2].matches("^-{0,1}[0-9]+")) {			logger.info("Данные получены");						int first = Integer.parseInt(parsedData[1]);			int second = Integer.parseInt(parsedData[2]);			String original = first + " "+ second;						first = first ^ second;			second = second ^ first;			first = first ^ second;						logger.info("Ответ отправлен");						return original + " => " + first + " " + second;		} else {			return "Неверные данные";		}	}}