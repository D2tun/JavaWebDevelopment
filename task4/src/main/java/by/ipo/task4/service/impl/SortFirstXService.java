package by.ipo.task4.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service of sorting triangles by it's first
 * point's x-coordinate.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class SortFirstXService {


	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	private static SortFirstXService instance = new SortFirstXService();

	public static SortFirstXService getInstance() {
		return instance;
	}
	
	/**
	 * This method sorts list of triangles by their first point's
	 * x-coordinate
	 * @param path - path to file
	 * @return sorted list of triangles
	 * @throws ServiceException if file wasn't found
	 */
	public List<Triangle> sort(String path) throws ServiceException {
		logger.trace("Данные получены");
		
		TriangleRepository tr = TriangleRepository.getInstance();

		TriangleLoader.load(path, tr);
		
		List<Triangle> result = tr.giveContent();
		SortListWithComparator.sort(result, new FirstXComparator());
		
		logger.trace("Ответ отправлен");
		return result;
	}
}
