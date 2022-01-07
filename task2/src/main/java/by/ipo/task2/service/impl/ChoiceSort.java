package by.ipo.task2.service.impl;

import by.ipo.task2.bean.Array;

/**
 * This class provides method for choice sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class ChoiceSort {
	
	/**
	 * This method sorts array with choice sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static Array sort(Array array) {
		
		int sortedPos = 0;
		while (sortedPos < array.getLength()) {
			for (int i = sortedPos; i < array.getLength(); ++i) {
				if (array.compareElements(sortedPos, i) > 0) {
					array.swapElements(i, sortedPos);
				}
			}
			++sortedPos;
		}
		
		return array;
	}
}
