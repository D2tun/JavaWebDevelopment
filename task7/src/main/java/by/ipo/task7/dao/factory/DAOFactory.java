package by.ipo.task7.dao.factory;

import by.ipo.task7.dao.ObjectXMLParser;
import by.ipo.task7.dao.impl.OrderXMLParser;

/**
 * This class represents factory of DAO.
 * @author Pavel Isidovich
 */
public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final ObjectXMLParser oxp = new OrderXMLParser();
	
	/**
	 * This method returns link on existing object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * This method returns link on existing object of TextFileReader 
	 * class.
	 * @return <strong>instance</strong> of object.
	 */
	public ObjectXMLParser getOrderXMLParser() {
		return oxp;
	}
}
