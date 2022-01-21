package by.ipo.task4.service.impl;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.Specification;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents specification, that defines if triangle
 * got entered set of points.
 * @author Pavel Isidovich
 *
 */
public class TrianglePointsSpecification implements Specification<Triangle> {

	private Point[] points = new Point[3];
	
	/**
	 * This constructor takes array of points to check triangles.
	 * @param points - array of points
	 * @throws ServiceException if array's contains less then 3 
	 * elements or one or more elements are null.
	 * @see Triangle
	 * @see Point
	 */
	public TrianglePointsSpecification(Point[] points) throws ServiceException {
		if (points.length != 3) {
			throw new ServiceException();
		}
		for (int i = 0; i < points.length; ++i) {
			if (points[i].equals(null)) {
				throw new ServiceException();
			}
		}
		this.points = points;
	}
	
	/**
	 * This method checks if given triangle got set of points, 
	 * entered in constructor
	 * @param object - triangle to be checked
	 * @return true if triangle got entered in constructor set of
	 * points, else - false
	 */
	@Override
	public boolean isSatisfiedBy(Triangle object) {
		if (object.getPoints().length != 3) {
			return false;
		}
		
		boolean got = false;
		for (int j = 0; j < object.getPoints().length; ++j) {
			for (int k = 0; k < object.getPoints().length; ++k) {
				if (object.getPoint(j).getX() == this.points[k].getX()
						&& object.getPoint(j).getY() == this.points[k].getY()) {
					got = true;
				} else {
					got = false;
				}
			}
		}
		return got;
	}
}
