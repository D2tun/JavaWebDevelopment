package by.ipo.task5.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Array;
import by.ipo.task5.service.SortingService;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This class provides method for choice sorting.
 * @author Pavel Isidovich
 *
 */
public class ChoiceSortServiceImpl implements SortingService {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	* Sorts given array using choice sort algorithm.
	* @param path - path to data source
	* @throws ServiceException if unable to read the file
	* @return parsed array
	* @see Array
	*/
	@Override
	public Array sort(String path) throws ServiceException {
		if (PathValidator.validateTXT(path)) {
			logger.trace("Данные получены");
			
			try {
				Array<Double> result = ArrayReader.readArray(path);

				return ChoiceSort.sort(result);
			} catch (IOException e) {
				logger.error("Ошибка сортировки");
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}
	}
}