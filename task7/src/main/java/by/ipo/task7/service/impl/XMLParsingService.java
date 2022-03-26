package by.ipo.task7.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task7.bean.Order;
import by.ipo.task7.service.XMLDocumentOperation;
import by.ipo.task7.service.exception.ServiceException;
import by.ipo.task7.dao.ObjectXMLParser;
import by.ipo.task7.dao.exception.FileAccessException;
import by.ipo.task7.dao.exception.XMLValidationException;
import by.ipo.task7.dao.factory.DAOFactory;

/**
 * This class represents service for parsing xml-document.
 * @author Pavel Isidovich
 *
 */
public class XMLParsingService implements XMLDocumentOperation {
	
	private static org.apache.logging.log4j
							.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method 
	 * @param path - path to file
	 * @param method - xml parsing method
	 * @return list of order-objects
	 * @throws ServiceException if file is absent, file doesn't cord 
	 * to schema, entered unknown method of parsing
	 * @see Order
	 */
	public List<Order> parseXML(String path, String method) throws ServiceException {
		
		logger.trace("Данные получны");
		
		ObjectXMLParser<Order> oxp = DAOFactory.getInstance().getOrderXMLParser();
		
		try {
			switch (method) {
			case "DOM":
				logger.trace("Ответ отправлен");
				return oxp.parseDOM(path);
				
			case "SAX":
				logger.trace("Ответ отправлен");
				return oxp.parseSAX(path);
				
			case "StAX":
				logger.trace("Ответ отправлен");
				return oxp.parseStAX(path);
				
			default:
				logger.warn("Способ " + path + " отсутствует");
				throw new ServiceException("no such method");
			}	
		} catch (FileAccessException e) {
			logger.error("Файл '" + path + "' отсутствует");
			throw new ServiceException(e.getMessage());
		} catch (XMLValidationException e) {
			logger.error("Документ '" + path + "' не соответствует схеме");
			throw new ServiceException(e.getMessage());
		}
	}

}
