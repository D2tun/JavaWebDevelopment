package by.ipo.task5.dao;

import by.ipo.task5.dao.exception.FileAccessException;

/**
 * This interface is implemented by classes, which provides methods
 * of creating file.
 * @author Pavel Isidovich
 *
 */
public interface CreateFile {
	
	public void create(String path, String data) throws FileAccessException;

}
