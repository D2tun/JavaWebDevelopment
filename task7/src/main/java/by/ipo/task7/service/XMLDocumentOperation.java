package by.ipo.task7.service;

import java.util.List;

import by.ipo.task7.bean.Order;
import by.ipo.task7.service.exception.ServiceException;

/**
 * This is a marker-interface for service classes, which makes 
 * operations on xml-documents
 * @author Pavel Isidovich
 *
 */
public interface XMLDocumentOperation {
	
	public List<Order> parseXML(String path, String method) throws ServiceException;

}
