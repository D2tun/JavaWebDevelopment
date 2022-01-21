package by.ipo.task4.service.impl;

import java.util.Comparator;
import java.util.List;

import by.ipo.task4.bean.Triangle;

/**
 * This class provides method to sort triangles by their id.
 * @author Pavel Isidovich
 *
 */
public class SortListWithComparator {
	
	public static void sort(List<Triangle> list, 
							Comparator<Triangle> comparator) {
		boolean iteration = true;
		while (iteration) {
			iteration = false;
			for (int i = 1; i < list.size(); ++i) {
				if (comparator.compare(list.get(i - 1), list.get(i)) > 0) {
					Triangle temp = list.get(i);
					list.set(i, list.get(i - 1));
					list.set(i - 1, temp);
					iteration = true;
				}
			}
		}
	}
}
