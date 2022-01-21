package by.ipo.task4.service.impl;

import java.util.Comparator;

import by.ipo.task4.bean.Triangle;

/**
 * This class represents triangle's comparator, which compares
 * triangle's id.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class ComparatorId implements Comparator<Triangle> {

	/**
	 * This method compares triangles. 
	 * @return If first argument is greater, then second, returns 
	 * positive integer; if first argument is lesser, then second, 
	 * returns negative integer; if arguments are equal, returns 0.
	 */
	@Override
	public int compare(Triangle o1, Triangle o2) {
		return o1.getId() - o2.getId();
	}

}
