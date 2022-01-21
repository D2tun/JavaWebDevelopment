package by.ipo.task4.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Point;
import by.ipo.task4.service.FigureService;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service of triangle's area calculation.
 * @author Pavel Isidovich
 *
 */
public class AreaCalculationService implements FigureService {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	private static AreaCalculationService instance = 
						new AreaCalculationService();

	public static AreaCalculationService getInstance() {
		return instance;
	}

	/**
	* This method searches for triangle with given points in file
	* with given path, and, if file exists and got txt or json name
	* suffix, returns triangle's area.
	* @param path - path to file
	* @param point1 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @param point2 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @param point3 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @return area value
	* @throws ServiceException - if file is absent, got name 
	* suffix different from txt or json, or if triangle with entered
	* point coordinates is absent in file, or path is invalid.
	*/
	public double calculate(String path, double[] point1, double[] point2, 
							double[] point3) throws ServiceException {
		TriangleRepository tr = TriangleRepository.getInstance();

		TriangleLoader.load(path, tr);
		
		if (tr.find(new Point[] {new Point(point1[0], point1[1]), 
								 new Point(point2[0], point2[1]), 
								 new Point(point3[0], point3[1])})
													.equals(null)) {
			logger.debug("Треугольника с такими точками нет");
			throw new ServiceException();
		}
		return tr.findRegistrator(tr.find(new Point[] {
										  new Point(point1[0], point1[1]), 
										  new Point(point2[0], point2[1]), 
										  new Point(point3[0], point3[1])})
																.getId())
																.getArea();
	}
}
