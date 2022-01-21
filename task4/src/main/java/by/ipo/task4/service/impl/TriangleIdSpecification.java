package by.ipo.task4.service.impl;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.Specification;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class represents specification, that defines if triangle
 * got entered id.
 * @author Pavel Isidovich
 *
 */
public class TriangleIdSpecification implements Specification<Triangle>{

	private Integer id;
	
	/**
	 * This constructor id to check triangle's id.
	 * @param id - target id
	 * @throws ServiceException if entered id is null or if entered
	 * id is less than 1.
	 * @see Triangle
	 * @see Point
	 */
	public TriangleIdSpecification(Integer id) throws ServiceException {
		if ((id <= 0) || (id.equals(null))) {
			throw new ServiceException();
		}
		this.id = id;
	}
	
	/**
	 * This method checks if given triangle id, entered in 
	 * constructor
	 * @param object - triangle to be checked
	 * @return true if triangle got id, entered in constructor, 
	 * else - false
	 */
	@Override
	public boolean isSatisfiedBy(Triangle object) {
		if (object.getId() == this.id.intValue()) {
			return true;
		} else {
			return false;
		}
	}
}
