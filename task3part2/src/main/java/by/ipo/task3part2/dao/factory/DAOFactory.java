package by.ipo.task3part2.dao.factory;

import by.ipo.task3part2.dao.DataOperator;
import by.ipo.task3part2.dao.impl.DataOperatorImpl;

/**
 * This class represents factory of DAO.
 * @author Pavel Isidovich
 */
public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final DataOperator dOperator = new DataOperatorImpl();
	
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
	public DataOperator getDataOperator() {
		return dOperator;
	}
	
}
