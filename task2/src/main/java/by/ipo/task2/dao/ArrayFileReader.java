package by.ipo.task2.dao;

import java.io.IOException;

/**
 * This interface is for data access classes, which read
 * data from file.
 * @author Pavel Isidovich 
 *
 */
public interface ArrayFileReader {
	
	public String readFile(String path) throws IOException;

}
