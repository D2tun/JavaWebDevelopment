package by.ipo.task4.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.dao.exception.DAOException;
import by.ipo.task4.dao.factory.DAOFactory;
import by.ipo.task4.service.FigureService;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents service of defining triangle's type.
 * @author Pavel Isidovich
 *
 */
public class TriangleTypeDefineService implements FigureService {
	
	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	private static TriangleTypeDefineService instance = 
									new TriangleTypeDefineService();

	public static TriangleTypeDefineService getInstance() {
		return instance;
	}
	
	/**
	* This method defines type of triangle with given points in file
	* with given path, and, if file exists and got txt or json name
	* suffix, returns triangle's characteristics.
	* @param path - path to file
	* @param point1 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @param point2 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @param point3 - array, where: element[0] is x-coordinate,
	* element[1] is y-coordinate
	* @return boolean array, where: element[0] is true if triangle is
	* right, element[1] is true if triangle is obtuse, element[2] is
	* true if triangle is acute, element[3] is true if triangle is 
	* equilateral, element[4] is true if triangle is isosceles.
	* @throws ServiceException - if file is absent, got name 
	* suffix different from txt or json, or if triangle with entered
	* point coordinates is absent in file, or path is invalid.
	*/
	public boolean[] define(String path, double[] point1, double[] point2, 
							double[] point3) throws ServiceException {
		logger.trace("Данные получены");
		
		TriangleRepository tr = TriangleRepository.getInstance();
		Triangle target = null;
		boolean[] response = new boolean[] {false, false, false, false, false};
		
		TriangleLoader.load(path, tr);
		
		if (tr.find(new Point[] {new Point(point1[0], point1[1]), 
								 new Point(point2[0], point2[1]), 
								 new Point(point3[0], point3[1])})
													.equals(null)) {
			logger.debug("Треугольника с такими точками нет");
			throw new ServiceException();
		} else {
			target = tr.find(new Point[] {new Point(point1[0], point1[1]), 
					 					  new Point(point2[0], point2[1]), 
					 					  new Point(point3[0], point3[1])});
		}
		
		switch (TriangleOperator.defineTriangle(target)) {
		case "right":
			response[0] = true;
			break;
			
		case "obtuse":
			response[1] = true;
			break;
			
		case "acute":
			response[2] = true;
			break;
		}
		
		if (TriangleOperator.isEquilateral(target)) {
			response[3] = true;
		} else if (TriangleOperator.isIsosceles(target)) {
			response[4] = true;
		}
		
		return response;
	}
}
