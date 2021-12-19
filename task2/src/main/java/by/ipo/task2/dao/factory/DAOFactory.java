package by.ipo.task2.dao.factory;

import by.ipo.task2.dao.ArrayFileReader;
import by.ipo.task2.dao.impl.ArrayFileReaderImpl;
import by.ipo.task2.dao.impl.CreateArrayTextFile;

/**
 * This class represents factory of DAO.
 * @author Pavel Isidovich
 */
public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final ArrayFileReader afr = new ArrayFileReaderImpl();
	private final CreateArrayTextFile catf = new CreateArrayTextFile();
	
	/**
	 * This method returns link on existing object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * This method returns link on existing object of ArrayFileReader 
	 * class.
	 * @return <strong>instance</strong> of object.
	 */
	public ArrayFileReader getArrayFileReader() {
		return afr;
	}
	
	/**
	 * This method returns link on existing object of 
	 * CreateArrayTextFile class.
	 * @return <strong>instance</strong> of object.
	 */
	public CreateArrayTextFile getCreateArrayTextFile() {
		return catf;
	}
}
