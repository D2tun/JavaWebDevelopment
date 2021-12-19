package by.ipo.task2.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.bean.Array;
import by.ipo.task2.dao.ArrayFileReader;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.service.SortingService;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method for Shell's sorting.
 * @author Pavel Isidovich
 *
 */
public class ShellSortServiceImpl implements SortingService {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	* Sorts given array using bubble sort algorithm.
	* @param path - path to data source
	* @throws ServiceException if unable to read the file
	* @return parsed array
	* @see Array
	*/
	@Override
	public Array sort(String path) throws ServiceException {
		if (path.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*\\\\{1})*"
						+ "[^|?/:\\\"<>*]{1,}(\\.txt){1}")) {
			logger.info("Данные получены");
	
			DAOFactory daof = DAOFactory.getInstance();
			ArrayFileReader afr = daof.getArrayFileReader();
	
			try {
				String[] data = afr.readFile(path).split(" ");
				Array<Double> result = new Array<>(data.length);
				result.setParameters(data);
	
				 for (int gap = result.getLength() / 2; gap > 0; gap /= 2) {
				        for (int i = gap; i < result.getLength(); i++) {
				        	double key = result.getParameter(i);
				            int j = i;
				            while (j >= gap && result.getParameter(j - gap) 
				            		> key) {
				            	result.swapElements(j, j - gap);
				                j -= gap;
				            }
				            result.setParameter(key, j);
				        }
				    }
	
				logger.info("Cортировка встряхиванием окончена");
	
				return result;
			} catch (IOException e) {
				logger.error("Ошибка сортировки");
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}
	}
}
