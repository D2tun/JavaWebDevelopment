package by.epam.task1.ipo.service;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to get dots of function of type
 * y = x (x > 2), y = -x (x <= 2).
 * @author Pavel Isidovich
 *
 */

public class FirstFunctionBuilder {
	
	private static FirstFunctionBuilder instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private FirstFunctionBuilder() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static FirstFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new FirstFunctionBuilder();
		}
		return instance;
	}
	
	/**
	 * This function calculates coordinates of function of type
	 * y = x (x > 2), y = -x (x <= 2).
	 * @param a - low border, high border and step in string format
	 * @return string-answer
	 */
	public String getCoordinates(String data) {
		double lowBorder = Double.NaN;
		double highBorder = Double.NaN;
		double step = Double.NaN;
		String[] parsedData = data.split(" ");
		
		if (parsedData.length != 3) {
			return "Неверные данные";
		}
		
		if (parsedData[0].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$") 
				&& parsedData[1].matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")
				&& parsedData[2].matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			
			parsedData[0] = parsedData[0].replace(',', '.');
			parsedData[1] = parsedData[1].replace(',', '.');
			parsedData[2] = parsedData[2].replace(',', '.');
			
			lowBorder = Double.parseDouble(parsedData[0]);
			highBorder = Double.parseDouble(parsedData[1]);
			step = Double.parseDouble(parsedData[2]);
		
			if (lowBorder > highBorder) {
				double temp = lowBorder;
				lowBorder = highBorder;
				highBorder = temp;
			}
			
			if ((lowBorder == Double.NaN) || (highBorder == Double.NaN) 
					|| (step == Double.NaN) || (step <= 0)) {
				return "Неверные данные";
			} else {
				logger.info("Данные получены");
				
				String answer = "x    y\n";
				do {
					if (lowBorder > 2) {
						answer += lowBorder + "    " + lowBorder + "\n";
					} else {
						answer += lowBorder + "    " + (lowBorder * -1) + "\n";
					}
					lowBorder += step;
				} while (lowBorder <= highBorder); 
				
				logger.info("Ответ отправлен");
				
				return answer;
			}
		} else {
			return "Неверные данные";
		}
	}
}
