package by.ipo.task2.service;

import by.ipo.task2.bean.Array;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This interface is implemented by classes, which provides methods
 * of array sorting.
 * @author Pavel Isidovich
 *
 */
public interface SortingService {
	
	public Array sort(String path) throws ServiceException;

}
