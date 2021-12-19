package by.ipo.task2.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.bean.Array;
import by.ipo.task2.dao.ArrayFileReader;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.service.SortingService;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method for insertion sorting.
 * @author Pavel Isidovich
 *
 */
public class MergeSortServiceImpl implements SortingService {
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
		if (path.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*\\\\{1})*"
						+ "[^|?/:\\\"<>*]{1,}(\\.txt){1}")) {
			logger.info("Данные получены");

			DAOFactory daof = DAOFactory.getInstance();
			ArrayFileReader afr = daof.getArrayFileReader();

			try {
				String[] data = afr.readFile(path).split(" ");

				Array<Double> result = new Array<>(data.length);
				result.setParameters(data);

				this.mergeSort(result);

				logger.info("Сортировка выбором окончена");

				return result;
			} catch (IOException e) {
				logger.error("Ошибка сортировки");
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}
	}
	
	private <T> Array mergeSort(Array<T> array) {
		int mid = array.getLength() / 2;
	    Array<T> left = new Array(mid);
	    Array<T> right = new Array(array.getLength() - mid);

	    for (int i = 0; i < mid; i++) {
	    	left.setParameter(array.getParameter(i), i);
	    }
	    for (int i = mid; i < array.getLength(); i++) {
	    	right.setParameter(array.getParameter(i), i);
	    }
	    mergeSort(left);
	    mergeSort(right);
	    
	    int i = 0; 
	    int	j = 0;
	    int	k = 0;
	    while (i < left.getLength() && j < right.getLength()) {
	        if (left.getParameter(i).hashCode() <= right.getParameter(j).hashCode()) {
	            array.setParameter(left.getParameter(i++), k++);
	        }
	        else {
	        	array.setParameter(right.getParameter(i++), k++);
	        }
	    }
	    while (i < left.getLength()) {
	    	array.setParameter(left.getParameter(i++), k++);
	    }
	    while (j < right.getLength()) {
	    	array.setParameter(right.getParameter(i++), k++);;
	    }
	    return array;
	}
}
