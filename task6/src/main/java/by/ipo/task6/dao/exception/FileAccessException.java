package by.ipo.task6.dao.exception;

import java.io.IOException;

/**
 * This exception is called when file cannot be read.
 * @author Pavel Isidovich
 *
 */
public class FileAccessException extends IOException {

	private static final long serialVersionUID = 1L;
	
	public FileAccessException() {
		super();
	}
}
