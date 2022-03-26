package by.ipo.task7.dao.exception;

import java.io.IOException;

/**
 * This exception thrown if there is no such file.
 * @author Pavel Isidovich
 *
 */
public class FileAccessException extends IOException {
	
	public FileAccessException() {
		super("There is no such file");
	}
}
