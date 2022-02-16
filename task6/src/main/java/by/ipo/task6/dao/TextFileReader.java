package by.ipo.task6.dao;

import by.ipo.task6.dao.exception.FileAccessException;

/**
 * This interface contains instruction to create text file reader
 * @author Pavel Isidovich
 *
 */
public interface TextFileReader {
	
	/**
	 * This method reads text from file
	 * @param path - path to file
	 * @return text in a string
	 * @throws FileAccessException if file wasn't found
	 */
	public String read(String path) throws FileAccessException;

}
