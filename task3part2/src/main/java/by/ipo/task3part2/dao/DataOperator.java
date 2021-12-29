package by.ipo.task3part2.dao;


import by.ipo.task3part2.dao.exception.DAOException;
import by.ipo.task3part2.bean.ArtExhibition;

/**
 * This interface provides methods to read from file and write to it.
 * @author Pavel Isidovich
 *
 */
public interface DataOperator {
	
	public ArtExhibition[] readData(String path) throws DAOException;

}
