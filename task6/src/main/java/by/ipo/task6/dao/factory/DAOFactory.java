package by.ipo.task6.dao.factory;

import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.impl.TextFileReaderImpl;

/**
 * This class represents factory of DAO.
 * @author Pavel Isidovich
 */
public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final TextFileReader tfr = new TextFileReaderImpl();
	
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
	public TextFileReader getTextFileReader() {
		return tfr;
	}
}
