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
public class InsertionSortBinaryImpl implements SortingService {
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

				for (int i = 1; i < result.getLength(); i++) {
					double number = result.getParameter(i);
					int indexToInsert = BinarySearch.find(result, number, i);
					for (int j = i; j > indexToInsert; j--) {
						result.swapElements(j, j - 1);
					}
					result.setParameter(number, indexToInsert);
				}
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
}
