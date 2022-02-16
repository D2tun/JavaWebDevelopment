package by.ipo.task6.service;

import by.ipo.task6.service.exception.ServiceException;

/**
 * This is a marker-interface for services, which are operating with
 * text.
 * @author Pavel isidovich
 *
 */
public interface TextOperation {

	public default String sortBySentencesNumber(String path) 
			throws ServiceException {
		return null;
	}
	
	public default String sortByLength(String path) throws ServiceException {
		return null;
	}
	
	public default String sortByEnteredSymbol(String path, String symbol) 
			throws ServiceException {
		return null;
	}
	
	public default String recover(String path) throws ServiceException {
		return null;
	}
}
