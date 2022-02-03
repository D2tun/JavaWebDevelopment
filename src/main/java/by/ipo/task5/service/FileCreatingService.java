package by.ipo.task5.service;

import by.ipo.task5.service.exception.ServiceException;

/**
 * This interface is implemented by classes, which provides methods
 * of file creating.
 * @author Pavel Isidovich
 *
 */
public interface FileCreatingService {

	void requestCreation(String path, int length) throws ServiceException;
	
}
