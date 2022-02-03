package by.ipo.task5.service;

import by.ipo.task5.bean.Array;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This interface is implemented by classes, which provides methods
 * of array sorting.
 * @author Pavel Isidovich
 *
 */
public interface SortingService {
	
	public Array sort(String path) throws ServiceException;

}
