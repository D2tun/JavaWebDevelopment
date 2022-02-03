package by.ipo.task5.dao.factory;

import by.ipo.task5.dao.FileReader;
import by.ipo.task5.dao.impl.ArrayFileReaderImpl;
import by.ipo.task5.dao.impl.CreateArrayTextFile;

/**
 * This class represents factory of DAO.
 * @author Pavel Isidovich
 */
public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final FileReader afr = new ArrayFileReaderImpl();
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
	public FileReader getArrayFileReader() {
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
