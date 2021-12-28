package by.ipo.task3part1.dao;

import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.dao.exception.DAOException;

/**
 * This interface provides methods to read from file and write to it.
 * @author Pavel Isidovich
 *
 */
public interface DataOperator {
	
	public Derivative readData(String path) throws DAOException;

}
