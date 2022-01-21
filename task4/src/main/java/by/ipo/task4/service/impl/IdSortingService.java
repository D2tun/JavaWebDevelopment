package by.ipo.task4.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service of sorting triangles by id;
 * @author Pavel Isidovich
 * @see Triangle
 */
public class IdSortingService {
	
	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	private static IdSortingService instance = new IdSortingService();

	public static IdSortingService getInstance() {
		return instance;
	}
	
	public List<Triangle> sort(String path) throws ServiceException {
		logger.trace("Данные получены");
		
		TriangleRepository tr = TriangleRepository.getInstance();

		TriangleLoader.load(path, tr);
		
		List<Triangle> result = tr.giveContent();
		SortListWithComparator.sort(result, new ComparatorId());
		
		logger.trace("Ответ отправлен");
		return result;
	}
}
