package by.ipo.task7.service.factory;

import by.ipo.task7.service.XMLDocumentOperation;
import by.ipo.task7.service.impl.XMLParsingService;

/**
 * This class represents factory of service.
 * @author Pavel Isidovich
 */
public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final XMLDocumentOperation xps = new XMLParsingService();
	
	/**
	 * This method returns link on existing object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public XMLDocumentOperation getXMLParsingService() {
		return xps;
	}
}
