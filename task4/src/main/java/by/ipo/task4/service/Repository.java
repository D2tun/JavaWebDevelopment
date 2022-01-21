package by.ipo.task4.service;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This interface provides triangle repository's specification.
 * @author Isidovich Pavel
 * @see Triangle
 */
public interface Repository<T> {
	
	public void update(T t);
	public T find(Point[] points);
	public T find(int id);
	public int findPosition(T t);
	public void delete(int id);
}
