package by.ipo.task4.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service to find triangle by entered points.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class FindByPointsService {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	private static FindByPointsService instance = new FindByPointsService();

	public static FindByPointsService getInstance() {
		return instance;
	}
	
	/**
	 * This class tries to find triangle with given points.
	 * @param path - path to file
	 * @param point1 - array, where: element[0] is x-coordinate,
	 * element[1] is y-coordinate
	 * @param point2 - array, where: element[0] is x-coordinate,
	 * element[1] is y-coordinate
	 * @param point3 - array, where: element[0] is x-coordinate,
	 * element[1] is y-coordinate
	 * @return triangle if it exists, else - null
	 * @throws ServiceException - if file is absent, got name 
	 * suffix different from txt or json, or if triangle with entered
	 * point coordinates is absent in file, or path is invalid.
	 */
	public Triangle find(String path, double[] point1, double[] point2, 
						 double[] point3) throws ServiceException {
		logger.trace("Данные получены");
		
		TriangleRepository tr = TriangleRepository.getInstance();
		
		TriangleLoader.load(path, tr);
		
		List<Triangle> triangles = tr.giveContent();
		TrianglePointsSpecification tps = new TrianglePointsSpecification(
											new Point[] {
													new Point(point1[0], 
															  point1[1]), 
													new Point(point2[0], 
															  point2[1]), 
													new Point(point3[0], 
															  point3[1])
													}
											);
		
		for (int i = 0; i < triangles.size(); ++i) {
			if (tps.isSatisfiedBy(triangles.get(i))) {
				logger.trace("Треугольник " + triangles.get(i).toString() 
							+ " найден");
				return triangles.get(i);
			}
		}
		
		logger.trace("Треугольник не найден");
		return null;
	}
}
