package by.ipo.task4.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service to find triangle by entered id.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class FindByIdService {
	
	private static org.apache.logging.log4j
							.Logger logger = LogManager.getFormatterLogger();

	private static FindByIdService instance = new FindByIdService();

	public static FindByIdService getInstance() {
		return instance;
	}

	/**
	* This class tries to find triangle with given id.
	* @param path - path to file
	* @param id - id of triangle
	* @return triangle if it exists, else - null
	* @throws ServiceException - if file is absent, got name 
	* suffix different from txt or json, or if triangle with entered
	* point coordinates is absent in file, or path is invalid.
	*/
	public Triangle find(String path, int id) throws ServiceException {
		logger.trace("Данные получены");

		TriangleRepository tr = TriangleRepository.getInstance();

		TriangleLoader.load(path, tr);

		List<Triangle> triangles = tr.giveContent();
		TriangleIdSpecification tps = new TriangleIdSpecification(id);

		for (int i = 0; i < triangles.size(); ++i) {
			if (tps.isSatisfiedBy(triangles.get(i))) {
				logger.trace("Треугольник с id " + id + " найден");
				return triangles.get(i);
			}
		}

		logger.debug("Треугольник с id " + id + "не найден");
		return null;
	}
}
