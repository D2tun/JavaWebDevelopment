package by.ipo.task6.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.bean.Text;
import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.exception.FileAccessException;
import by.ipo.task6.dao.factory.DAOFactory;
import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.exception.ServiceException;

/**
 * This class provides method to divide text on text unit objects and
 * then recover it.
 * @author Pavel Isidovich
 * @see TextUnit
 */
public class TextRecoverService implements TextOperation {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method divides text on text unit objects and
	 * then recovers it.
	 * @param path - path to file
	 * @return original text as a string
	 * @throws ServiceException if file not found or can't be read
	 */
	public String recover(String path) throws ServiceException {
		if (PathValidator.validate(path) == false) {
			logger.error("Неверный путь " + path);
			throw new ServiceException();
		}
		
		logger.trace("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		TextFileReader tfr = daof.getTextFileReader();
		
		try {
			Text text = new Text(tfr.read(path));
			
			logger.trace("Ответ отправлен");
			
			return text.getText();
		} catch (FileAccessException e) {
			logger.error("Ошибка чтения файла " + path);
			throw new ServiceException();
		}
	}
}
