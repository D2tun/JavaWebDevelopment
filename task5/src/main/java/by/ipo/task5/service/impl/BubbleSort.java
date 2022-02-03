package by.ipo.task5.service.impl;

import by.ipo.task5.bean.Array;

/**
 * This class provides method to sort array with bubble sort.
 * @author Pavel Isidovich
 * @see Array
 */
public class BubbleSort {

	/**
	 * This method sorts array with bubble sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static Array sort(Array array) {
		
		boolean needIteration = true;
		while (needIteration) {
			needIteration = false;
			for (int i = 1; i < array.getLength(); ++i) {
				if (array.compareElements(i - 1, i) > 0) {
					array.swapElements(i - 1, i);
					needIteration = true;
				}
			}
		}
		
		return array;
	}
}
